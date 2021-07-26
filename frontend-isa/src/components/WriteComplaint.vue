  <template>
  <div class="com">
  <div class="complain">
   <label style="color:#474A8A;font-size:35px;" align = "center">WRITE A COMPLAINT</label>
  
    <table> 
       <tr  style="font-size:22px; height:60px;" class="form-control">
                                <td style="margine:20px; width:600px; font-size:22px;" > Complain for: </td>
                                    <td style="margine:20px; width:600px; font-size:22px;">
                                    <select v-model="people" id="people" class="form-control" @change="changeOption"
                                          aria-label="Enter phone nubmer"
                                          :select="people" style="font-size:22px;"
                                    aria-describedby="addon-wrapping">
                                    <option  value="PHARMACY" > PHARMACY </option>
                                    <option  value="DERMATOLOGIST">DERMATOLOGIST</option>
                                    <option  value="PHARMACIEST">PHARMACIEST</option>
                        </select>
                                    
                                    </td>
                            </tr >
                                <tr class="form-control" style=" height:60px;"> 
                                    <td style="margine:20px; width:600px; font-size:22px;" >  Employee name: </td>
                                    <td style="margine:20px; width:600px; font-size:22px;">
                                    <select class="form-control" id="employee" style="font-size:22px;"
                                          aria-label="Enter employee" v-model="employee"                                          
                                    aria-describedby="addon-wrapping">
                        </select>
                                    
                                    </td></tr>
                                    
                                    <tr class="form-control" style=" height:max-content;"> 
                                    <td style="margine:20px; width:600px; font-size:22px;" >  Complain: </td>
                                    <td style="margine:20px; width:600px; font-size:22px;">
                                     <b-form-textarea   id="textarea" v-model="textComplain"
                                      placeholder="Enter yout complain..." style="font-size:22px;" rows="4" max-rows="10"></b-form-textarea>

                                    </td></tr>

                                     <tr  class="form-control" style=" height:max-content;" > 
                                    
                                            <td colspan="2"   style="margine:20px;  margine-left: 500px; font-size:22px;">
                                              <button class="btn btn-primary btn-xs"
                                                style="margin:auto; background: #000;font-size:22px; width:500px;"
                                                @click="sendOffer"                                    
                                                > Send complain </button>
                                              </td>
                                     </tr>
                  </table>  


                 
    </div> 
  </div>


</template>

<script>
export default {
  data() {
    return {
     
         id : this.$route.params.id,
         dermatologist: [],
         pharmaciest: [],
         pharmacies: [],
         textComplain: "",
         people: "",
         to: "",
         employee: "",

         idPatient: "",
         idPharmacy: "",
         idStaff: "",
         text: ""
        

    }
  },
  methods:
  {
    sendOffer()
    {
        console.log("DER");

        var vrsta = document.getElementById("people").value;
      
        var name = document.getElementById("employee").value;
        var deo = name.split("-");
      
        if(vrsta == "PHARMACY")
        {
          const complaintPharmacy = 
            {
                idPatient : this.id,                
                idPharmacy : deo[0],
                idStaff : null,
                text : this.textComplain
            }
            console.log(complaintPharmacy);
              this.axios.post('/complaint/save', complaintPharmacy,
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                        
                        alert("Successfully added complain! ");
                        console.log(response.data);
                         window.location.href = '/HomePagePatient/'+this.id;             
                    }).catch(res => {
                        alert(res.response.data.message);
                    });
            
        }
        else
        {
            const complaintStaff = 
            {
                idPatient : this.id,                
                idPharmacy : null,
                idStaff : deo[0],
                text : this.textComplain
            }
            console.log(complaintStaff);
            this.axios.post('/complaint/save', complaintStaff,
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                        
                        alert("Successfully added complain! ");
                        console.log(response.data);
                         window.location.href = '/HomePagePatient/'+this.id;             
                    }).catch(res => {
                        alert(res.response.data.message);
                    });


        }
          

           
    },

    changeOption: function(event)
        {   
            this.key = event.target.value;

            if(this.key == "PHARMACY")
            {              
              document.getElementById("employee").length = 0; 
              for(var pharmacy in this.pharmacies)
                { 
                  var optionPharmacy = document.createElement("option");
                  optionPharmacy.text = this.pharmacies[pharmacy].idPharmacy+"-"+ this.pharmacies[pharmacy].name;
                  optionPharmacy.value = this.pharmacies[pharmacy].idPharmacy+"-"+ this.pharmacies[pharmacy].name;
                  var select = document.getElementById("employee");
                  select.appendChild(optionPharmacy);
                }
            }else if(this.key == "DERMATOLOGIST")
            {
               document.getElementById("employee").length = 0;           
                     
                for(var dermatologist in this.dermatologist)
                {     
                      
                      var optionDerma = document.createElement("option");
                      optionDerma.text = this.dermatologist[dermatologist].idDermatologist+"-"+ this.dermatologist[dermatologist].name+" "+this.dermatologist[dermatologist].surname;
                      optionDerma.value = this.dermatologist[dermatologist].idDermatologist+"-"+ this.dermatologist[dermatologist].name+" "+this.dermatologist[dermatologist].surname;
                      var selectD = document.getElementById("employee");
                      selectD.appendChild(optionDerma);            

                }
            }else if(this.key == "PHARMACIEST")
            {
                        document.getElementById("employee").length = 0; 
                      for(var pharmaciest in this.pharmaciest)
                    {       
                        console.log("pharmaciest" , this.pharmaciest[pharmaciest].name);
                        var optionpharmaciest = document.createElement("option");
                        optionpharmaciest.text =this.pharmaciest[pharmaciest].idPharmacist+"-"+ this.pharmaciest[pharmaciest].name+" "+this.pharmaciest[pharmaciest].surname;
                        optionpharmaciest.value =this.pharmaciest[pharmaciest].idPharmacist+"-"+ this.pharmaciest[pharmaciest].name+" "+this.pharmaciest[pharmaciest].surname;
                        var selectpharmaciest = document.getElementById("employee");
                        selectpharmaciest.appendChild(optionpharmaciest);
                }
                 
            }
            
        },
  },
  
  mounted() {
  ///patient/findDermatologistForGrade/{id}
  this.axios.get('grade/findDermatologistForGrade/'+ this.id ,{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.dermatologist = response.data;
                  console.log(this.dermatologist);

            }).catch(res => {
                          //alert("Token expired!");
                          //window.location.href = '/login';
                        console.log(res.response.data.message);
                    });

  this.axios.get('grade/findPharmacistForGrade/'+ this.id ,{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.pharmaciest = response.data;
                  console.log(this.pharmaciest);

            }).catch(res => {
                         // alert("Token expired!");
                         // window.location.href = '/login';
                          console.log(res.response.data.message);
                    });

    this.axios.get('grade/findPharmaciesForGrade/'+ this.id ,{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.pharmacies = response.data;
                  console.log(this.pharmacies);

            }).catch(res => {
                          //alert("Token expired!");
                         // window.location.href = '/login';
                          console.log(res.response.data.message);
                    });


               
}
}
</script>

<style>
body
{
  background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);
  background-repeat: no-repeat; 
  background-size: 150% 111%;
  height: 1600px;
}
.complain
{
  margin: 0 auto;
}
table
{
  margin:auto;
}

</style>

  