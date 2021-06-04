 <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Dermatologist profile</label>

        <div style="background: #B0B3D6; height: 80px;">

           
                                  
        </div>

<div style="margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F">About you</h3>
            
    <form>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Name:</label>
                        <input type="text" class="form-control" v-model = "dermatolog.name" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Surname:</label>
                        <input type="text"  class="form-control" v-model = "dermatolog.surname">
                        </div>
                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Email:</label>
                        
                        <input type="text"  class="form-control" v-model= "dermatolog.email" >
                        </div>
                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Phone number:</label>
                        <input type="text"  class="form-control" v-model= "dermatolog.phoneNumber" >
                        </div>
                    </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Country:</label>
                        <input type="text"  class="form-control" v-model= "dermatolog.country" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">City:</label>
                        <input type="text" class="form-control" v-model= "dermatolog.city" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Address:</label>
                        <input type="text"  class="form-control" v-model= "dermatolog.address">
                        </div>
                         <div class="form-group  col-md-6">
                            <label style="color: #0D184F">Current Password:</label>
                            <input type="password" class="form-control" v-model= "currentPassword" placeholder="Current password">
                        </div>
                    </div>
                    
           
                       <div class="form-row">
                        <div class="form-group  col-md-6">
                            <label style="color: #0D184F">New password:</label>
                            <input type="password" class="form-control" v-model= "newPassword" placeholder=" New password">
                        </div>
                        <div class="form-group  col-md-6">
                            <label style="color: #0D184F">Repeat new password:</label>
                            <input type="password" class="form-control" v-model= "newPasswordRepeat" placeholder="Repeat new password">
                        </div>
                       </div>
                         
                         
              
                    <button class="btn btn-primary btn-lg" style="background:#474A8A" v-on:click = "update">Change</button>
                   
                </form>


</div>

  

    </div>
</template>

<script>
export default {
  data() {
    return {
    dermatolog: {},
    nesto:{},
       id : this.$route.params.id,

    name : "",
    surname : "",
    password : "",
    phoneNumber : "",
    city : "",
    country : "",
    currentPassword : "",
    newPassword : "",
    newPasswordRepeat : "",
    sifra:"",
    email:"",
    
    }
  },

  
  mounted() {
        this.axios.get('dermatologist/findById/'+this.id,{ 
             
         }).then(response => {
               this.dermatolog=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
               
},
  methods:{
     update: function(){

        if(this.currentPassword ==""){
          
          this.sifra=this.dermatolog.password
        }else if (this.currentPassword !=this.dermatolog.password) {
           alert("Invalid old password")
            return;
        } 

        if(this.newPassword != this.newPasswordRepeat) {
                    alert("New passwords must be equal.")
                    return;
        }else{
               this.sifra=this.newPassword;
        }
       
        
        
          const pharmacistInfo = {
                    id : this.dermatolog.id,
                    name: this.dermatolog.name,
                    surname : this.dermatolog.surname,
                    phoneNumber: this.dermatolog.phoneNumber,
                    address: this.dermatolog.address,
                    city:this.dermatolog.city,
                    country:this.dermatolog.country,
                    password: this.sifra,
                    email: this.dermatolog.email

        } 
        this.axios.post('/dermatologist/updateDermatologist',pharmacistInfo,{
      }).then(response => {
               this.nesto=response.data;
                alert("Changes have been saved!");
                console.log(this.id);
                //window.location.href = "/profileDermatologist/"+this.id;
                
          }).catch(res => {
                      alert("neceeee!");

                       console.log(res);
                 });
      }
}
}












</script>