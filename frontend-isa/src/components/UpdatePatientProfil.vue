  <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Patient profile</label>

        <div style="background: #B0B3D6; height: 80px;">

           
                                  
        </div>

<div style="margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F">About you</h3>
            
    <form>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label>Name:</label>
                        <input type="text" class="form-control" v-model = "patient.name" >
                        </div>
                        <div class="form-group col-md-6">
                        <label>Surname:</label>
                        <input type="text"  class="form-control" v-model = "patient.surname">
                        </div>
                         <div class="form-group col-md-6">
                        <label>Email:</label>
                        
                        <p><input v-model = "patient.email" readonly></p>
                        </div>
                         <div class="form-group col-md-6">
                        <label>Phone number:</label>
                        <input type="text"  class="form-control" v-model="patient.phoneNumber" >
                        </div>
                    </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                        <label>Country:</label>
                        <input type="text"  class="form-control" v-model="patient.country" >
                        </div>
                        <div class="form-group col-md-6">
                        <label>City:</label>
                        <input type="text" class="form-control" v-model="patient.city" >
                        </div>
                        <div class="form-group col-md-6">
                        <label>Address:</label>
                        <input type="text"  class="form-control" v-model="patient.address">
                        </div>
                         <div class="form-group  col-md-6">
                            <label>Current Password:</label>
                            <input type="password" class="form-control" v-model="currentPassword" placeholder="Current password">
                        </div>
                    </div>
                    
           
                       <div class="form-row">
                        <div class="form-group  col-md-6">
                            <label>New password:</label>
                            <input type="password" class="form-control" v-model="newPassword" placeholder=" New password">
                        </div>
                        <div class="form-group  col-md-6">
                            <label>Repeat new password:</label>
                            <input type="password" class="form-control" v-model="newPasswordRepeat" placeholder="Repeat new password">
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
        patient: {},

    pharmacy : {},
    nesto:{},
    name : "",
    id:"",
        surname : "",
        email : "",
        password : "",
        phoneNumber : "",
        city : "",
        country : "",
        currentPassword : "",
        newPassword : "",
        newPasswordRepeat : "",
        sifra:"",
         idU : this.$route.params.id,
    }
  },
  
  mounted() {
        this.axios.get('patient/findOneById/'+this.idU,{ 
             
         }).then(response => {
               this.patient=response.data;
         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
               
},
  methods:{
     update: function(){
        if(this.newPassword != this.newPasswordRepeat) {
            alert("New passwords must be equal.")
            return;
        }else{
        
        if(this.currentPassword ==""){
          
          this.sifra=this.patient.password
        }else if (this.currentPassword !=this.patient.password) {
           alert("Invalid old password")
            return;
        } else if (this.newPassword!=="") {
           this.sifra=this.newPassword
            }else{
          this.sifra=this.patient.password
        }
           const patientInfo = {
                     id : this.patient.id,
                    name: this.patient.name,
                    surname : this.patient.surname,
                    phoneNumber: this.patient.phoneNumber,
                    address: this.patient.address,
                    city:this.patient.city,
                    country:this.patient.country,
                    password: this.sifra,
                    penalty:this.patient.penalty
          }
    this.axios.post('/patient/updatePatient',patientInfo,{
      }).then(response => {
               this.nesto=response.data;
                alert("Changes have been saved!");
                window.location.href = "/ProfilePatient/"+this.patient.id;
          }).catch(res => {
                       //alert("Please first choose allergy!");
                       console.log(res);
                 });
      }
     }
}
}
</script>

  