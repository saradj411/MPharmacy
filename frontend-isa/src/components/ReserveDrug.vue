<template>


  <div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  background-size: 150% 111%;  height: 1100px">

 
  
  
<!--prikaz lijekova!-->
<div style="margin-left:0px;">
  <h4 style="margin:30px">DRUGS:</h4>
      <div style="background: #a7c1c9; width: 700px;margin-left:300px;">
      
         
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td>Drug:</td>
        <td>{{ this.drug.name}}
           </td>
      </tr>
    <tr>
      <th></th>
      <td >Pharmacy:</td>   
       <td>{{this.pharmacy.name}}</td>

    </tr>
    <tr>
      <th></th>
       <td>Picked up date:</td>
       <td><input type="date" class="form-control" v-model = "reserveDate" placeholder="Enter date"></td>
    </tr>
 <tr>
      <th></th>
       <td></td>
       
        <td ><button class="btn btn-danger btn-sm" v-on:click = "createReservation()">Reserve</button></td> 
    </tr>

  </tbody>
</table>
           </div>

      </div>   
      


                
            
        </div>

</template>



<script>
export default {
  data() {
    return {
        id : this.$route.params.id,        
        pharmacyName: this.$route.params.pharmacyName,
        idPatient : this.$route.params.idPatient,

       //pharmacyDrug : [],
       reserveDate:null,
       pharmacy: {},
       drug: {},
      accessToken: localStorage.getItem('accessToken'),
        
       
    }
  },
  
  methods:{
  
    createReservation : function(){
    

            const reservation = {            
              patient : this.idPatient,
              drug: this.drug.idDrug,
              pharmacy : this.pharmacy.idPharm,              
              pickUpDate  : this.reserveDate
          }
        console.log("sasa",this.reserveDate);
       
        if(this.reserveDate===null){
          alert("Please check date!")
        }else{
          var currentDate = new Date();
          var odabrani=new Date(this.reserveDate)

           if(odabrani<currentDate){
             alert("Choose a date from the future!")
           }else{
           console.log(reservation);

         
         
           this.axios.post('/reservation/create',reservation,{ 
                        })
                .then(response => {
                       alert("Reservation created!");
                        window.location.href = "/HomePagePatient/"+this.idPatient;
                        console.log(response.data);
                })
                .catch(response => {
                       alert("It is not possible reserve");
                        console.log(response);
                 }); 
          }
        }
      }
  },    
    

mounted() {
        /*this.axios.get('/pharmacyDrugs/getById/'+this.id)
        .then(response => {
                this.pharmacyDrug = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
*/ 
    console.log("STA");
    this.axios.get('/pharmacy/getByName/'+ this.pharmacyName,{ 
       headers: {                    
                    'Authorization': `Bearer ` +  this.accessToken,
                    
                }
                        })
                .then(response => {
                        console.log("naziv apoteke:");
                        console.log(response.data);
                        this.pharmacy = response.data;
                })
                .catch(response => {
                      console.log(response);
                 });
        
    this.axios.get('/drug/findById/'+ this.id,{ 
                        })
                .then(response => {
                        console.log(response.data);
                        this.drug = response.data;
                })
                .catch(response => {
                      console.log(response);
                 });
        
    }
     
}
</script>

<style>
</style>
