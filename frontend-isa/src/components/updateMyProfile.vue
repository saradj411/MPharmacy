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
                        <label>Name:</label>
                        <input type="text" class="form-control" v-model = "admin.name" >
                        </div>
                        <div class="form-group col-md-6">
                        <label>Surname:</label>
                        <input type="text"  class="form-control" v-model = "admin.surname">
                        </div>
                         <div class="form-group col-md-6">
                        <label>Email:</label>
                        
                        <input type="text"  class="form-control" v-model= "admin.email" >
                        </div>
                         <div class="form-group col-md-6">
                        <label>Phone number:</label>
                        <input type="text"  class="form-control" v-model= "admin.phoneNumber" >
                        </div>
                    </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                        <label>Country:</label>
                        <input type="text"  class="form-control" v-model= "admin.country" >
                        </div>
                        <div class="form-group col-md-6">
                        <label>City:</label>
                        <input type="text" class="form-control" v-model= "admin.city" >
                        </div>
                        <div class="form-group col-md-6">
                        <label>Address:</label>
                        <input type="text"  class="form-control" v-model= "admin.address">
                        </div>
                         <div class="form-group  col-md-6">
                            <label>Current Password:</label>
                            <input type="password" class="form-control" v-model= "currentPassword" placeholder="Current password">
                        </div>
                    </div>
                    
           
                       <div class="form-row">
                        <div class="form-group  col-md-6">
                            <label>New password:</label>
                            <input type="password" class="form-control" v-model= "newPassword" placeholder=" New password">
                        </div>
                        <div class="form-group  col-md-6">
                            <label>Repeat new password:</label>
                            <input type="password" class="form-control" v-model= "newPasswordRepeat" placeholder="Repeat new password">
                        </div>
                       </div>
                         
                         
              
                    <button class="btn btn-primary btn-lg" v-on:click = "update">Change</button>
                   
                </form>


</div>

  

    </div>
</template>

<script>
export default {
  data() {
    return {
    admin: {},
    pharmacy : {},
    nesto:{},

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
        this.axios.get('adminstrator/findById/'+505,{ 
             
         }).then(response => {
               this.admin=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
               
},
  methods:{
     update: function(){

        if(this.currentPassword ==""){
          
          this.sifra=this.admin.password
        }else if (this.currentPassword !=this.admin.password) {
           alert("Invalid old password")
            return;
        } 

        if(this.newPassword != this.newPasswordRepeat) {
                    alert("New passwords must be equal.")
                    return;
        }else{
               this.sifra=this.newPassword;
        }
       
        
        
          const adminInfo = {
                    idUser : this.admin.idUser,
                    name: this.admin.name,
                    surname : this.admin.surname,
                    phoneNumber: this.admin.phoneNumber,
                    address: this.admin.address,
                    city:this.admin.city,
                    country:this.admin.country,
                    password: this.sifra,
                    email: this.admin.email

        } 
        this.axios.post('/adminstrator/updateAdmin',adminInfo,{
      }).then(response => {
               this.nesto=response.data;
                alert("Changes have been saved!");
                window.location.href = "/ProfileAdmin";
          }).catch(res => {
                      alert("neceeee!");

                       console.log(res);
                 });
      }
}
}












</script>