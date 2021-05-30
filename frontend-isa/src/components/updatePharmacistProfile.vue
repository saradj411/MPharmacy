 <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Admin profile</label>

        <div style="background: #B0B3D6; height: 80px;">

           
                                  
        </div>

<div style="margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F">About you</h3>
            
    <form>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Name:</label>
                        <input type="text" class="form-control" v-model = "pharmacist.name" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Surname:</label>
                        <input type="text"  class="form-control" v-model = "pharmacist.surname">
                        </div>
                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Email:</label>
                        
                        <input type="text"  class="form-control" v-model= "pharmacist.email" >
                        </div>
                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Phone number:</label>
                        <input type="text"  class="form-control" v-model= "pharmacist.phoneNumber" >
                        </div>
                    </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Country:</label>
                        <input type="text"  class="form-control" v-model= "pharmacist.country" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">City:</label>
                        <input type="text" class="form-control" v-model= "pharmacist.city" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Address:</label>
                        <input type="text"  class="form-control" v-model= "pharmacist.address">
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
    pharmacist: {},
    pharmacy : {},
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
        this.axios.get('pharmacist/findById/'+this.id,{ 
             
         }).then(response => {
               this.pharmacist=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
               
},
  methods:{
     update: function(){

        if(this.currentPassword ==""){
          
          this.sifra=this.pharmacist.password
        }else if (this.currentPassword !=this.pharmacist.password) {
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
                    idUser : this.pharmacist.idUser,
                    name: this.pharmacist.name,
                    surname : this.pharmacist.surname,
                    phoneNumber: this.pharmacist.phoneNumber,
                    address: this.pharmacist.address,
                    city:this.pharmacist.city,
                    country:this.pharmacist.country,
                    password: this.sifra,
                    email: this.pharmacist.email

        } 
        this.axios.post('/pharmacist/updatePharmacist',pharmacistInfo,{
      }).then(response => {
               this.nesto=response.data;
                alert("Changes have been saved!");
                window.location.href = "/profilePharmacist";
          }).catch(res => {
                      alert("neceeee!");

                       console.log(res);
                 });
      }
}
}












</script>