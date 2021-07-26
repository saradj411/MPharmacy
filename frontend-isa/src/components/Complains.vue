<template>
<div>
    <h1> All complains </h1>
    <div class="complain" v-for="c in this.complains"
        v-bind:key="c.idComplaint">   
             
            <table> 
             <tr  style="font-size:22px;" class="form-control">
              <td style="margine:20px; width:600px; font-size:22px;"> ID complain: </td>
              <td style="margine:20px; width:600px; font-size:22px;">
                  <input type="text" v-model="c.idComplaint" :id="'id_' + c.idComplaint"                                   
                                    class="form-control" 
                                    aria-label="Enter phone nubmer"
                                    :disabled="true"
                                    aria-describedby="addon-wrapping">   </td>
            </tr >
            <tr  style="font-size:22px;" class="form-control">
              <td style="margine:20px; width:600px; font-size:22px;"> Patien: </td>
              <td style="margine:20px; width:600px; font-size:22px;">
                  <!--<input type="text" v-model="" :id="'patien_' + c.idComplaint"                                   
                                    class="form-control" 
                                    aria-label="Enter phone nubmer"
                                    :disabled="true"
                                    aria-describedby="addon-wrapping">  --> </td>
            </tr >
                               
             </table>
                         

           
            <!--<div v-for="offer in this.offerList"
                v-bind:key="offer.idOffer">

             <table v-if="prosledjena.idOrder==offer.idOrder" style="" id="table2" class="table" >
                <tbody  >
                    
                    <tr style="font-size:22px;color:#0D184F;">
                    <td colspan="2" style=" width:200px;" >Total price:</td>
                    <td colspan="2"><input type="text" v-model="offer.totalPrice" :id="'price_' + offer.idOffer"
                                    :class="{'input--error':!offer.totalPrice}"
                                    class="form-control" 
                                    aria-label="Enter phone nubmer"
                                    :disabled="true"
                                    aria-describedby="addon-wrapping">  
                                  
                                  </td>                               
                    
                    </tr>
                    <tr style="font-size:22px;color:#0D184F;">
                    <td colspan="2">Delivery date:</td>
                    <td colspan="2"><input type="localdate" v-model="offer.deliveryDate" 
                                    :class="{'input--error':!offer.deliveryDate}"
                                    :disabled="true"
                                    class="form-control" :id="'deliverDate_' +offer.idOffer"                                    
                                    aria-label="Enter phone nubmer"                                
                                    aria-describedby="addon-wrapping"> </td>
                    
                    </tr>
                    <tr style="font-size:22px;color:#0D184F;">
                    <td colspan="2" style=" width:200px;" >Status:</td>
                    <td colspan="2"><input type="text" v-model="offer.offerStatus" :id="'status_' + offer.idOffer"
                                    class="form-control" 
                                    aria-label="Enter phone nubmer"
                                    :disabled="true"
                                    aria-describedby="addon-wrapping">  
                                  
                                  </td>                               
                    
                    </tr>


                    </tbody>
                    <tr>                  
                    <td>
                    <button class="btn btn-primary btn-xs"
                            style="margin:auto; background: #000; width:250px;"
                            @click="editOffer(offer)" :id="'edit_'+offer.idOffer"
                            > Edit </button>
                    </td>
                      <td>
                    <button class="btn btn-primary btn-xs"
                             style="margin:auto; ;background: #000;  width:250px;"
                             @click="saveOffer(offer)" :disabled="!isDisabled" 
                             :id="'save'+offer.idOffer"
                             > Save </button>
                    </td>
                    <td>
                    <button class="btn btn-primary btn-xs"
                             style="margin:auto; ;background: #000;  width:250px;"
                             @click="cancelEditOffer(offer)" :disabled="!isDisabled"
                             :id="'cancel_'+offer.idOffer"
                             > Cancel </button>
                    </td>
                    <td>
                    <button class="btn btn-primary btn-xs"
                             style="margin:auto; ;background: #000;  width:250px;"
                             :id="'delete'+offer.idOffer"
                             @click ="deleteOffer(offer)" > Delete </button>
                    </td>

                   
                    </tr>
                    <tr>
                   
                    </tr>
                    <tr></tr>
                </table>
        


            </div>-->
                 


    </div>

</div>
</template>


<script>
export default {
  data() {
    return {
     
         id : this.$route.params.id,
         complains: [],
         staffComplains: []
         
        

    }
  },
  methods:
  {
    /*sendOffer()
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

    /*changeOption: function(event)
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
            
        },*/
  },
  
  mounted() {
  ///patient/findDermatologistForGrade/{id}
  this.axios.get('/complaint/findAll/',{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.complains = response.data;
                  console.log(this.complains);

            }).catch(res => {
                          //alert("Token expired!");
                          //window.location.href = '/login';
                        console.log(res.response.data.message);
                    }); 
  this.axios.get('/complaint/findAllStaffComplaint/',{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.staffComplains = response.data;
                  console.log("STAFF");
                  console.log(this.staffComplains);

            }).catch(res => {
                          //alert("Token expired!");
                          //window.location.href = '/login';
                        console.log(res.response.data.message);
                    }); 

               
            }
}
</script>

<style>
.complain
{
    background-color: white;
    width: 500px;
    height: 100px;
}

</style>
