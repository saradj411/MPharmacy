 <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Add new pharmacist</label>

        <div style="background: #B0B3D6; height: 80px;">

           
                                  
        </div>

<div style="margin: auto; width: 50%;margin-top:45px;">
            
    <form>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Name:</label>
                        <input type="text" class="form-control" v-model = "name" placeholder="Enter name" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Surname:</label>
                        <input type="text"  class="form-control" v-model = "surname" placeholder="Enter surname ">
                        </div>
                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Email:</label>
                        
                        <input type="text"  class="form-control" v-model= "email"  placeholder="Enter email">
                        </div>
                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Phone number:</label>
                        <input type="text"  class="form-control" v-model= "phoneNumber" placeholder="Enter phone number">
                        </div>
                    </div>
                      <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Country:</label>
                        <input type="text"  class="form-control" v-model= "country" placeholder="Enter coutry" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">City:</label>
                        <input type="text" class="form-control" v-model= "city" placeholder="Enter city">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Address:</label>
                        <input type="text"  class="form-control" v-model= "address" placeholder="Enter adress">
                        </div>
                        <div class="form-group  col-md-6">
                            <label style="color: #0D184F">New password:</label>
                            <input type="password" class="form-control" v-model= "password" placeholder=" New password">
                        </div>
                        

                    </div>
                     <label style="color:#474A8A;font-size:30px;" align = "center">Define working hours</label>
                    
             <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Date:</label>
                        <input type="date"  class="form-control" v-model= "date" placeholder="Enter date" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Start time:</label>
                        <input type="time" class="form-control" v-model= "start" placeholder="Enter start date">
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">End time:</label>
                        <input type="time"  class="form-control" v-model= "end" placeholder="Enter end date">
                        </div>
                        

                    </div>
                    
                         
                         
              
                    <button class="btn btn-primary btn-lg" style="background:#474A8A" v-on:click = "addDrug">Change</button>
                   
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
id : this.$route.params.id,

    name : "",
    surname : "",
    password : "",
    phoneNumber : "",
    city : "",
    country : "",
    address:"",
    email:"",
    date:null,
    start:null,
    end:null
    
    }
  },

  
  mounted() {
               
},
  methods:{




     addDrug : function() {
          const medicationInfo = {
               name : this.name,
               surname : this.surname,
               email : this.email,
               password : this.password,
               city : this.city,
               country : this.country,
               address : this.address,
               idPharmacy:this.id,
               date:this.date,
               startTime:this.start,
               endTime:this.end

          }
          this.axios.post('/pharmacist/createPharmacist',medicationInfo,{ 
             headers: {
             }}).then(response => {
                       alert("Pharmacist is added!");
                        this.nesto=response.data;
          //window.location.href = "/ProfileAdmin";

                        console.log(response.data);
                })
                .catch(res => {
                    alert(res.response.data.message);
                 });    
      },

     
}
}












</script>