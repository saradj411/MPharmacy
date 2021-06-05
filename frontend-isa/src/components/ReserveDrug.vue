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
        <td>{{pharmacyDrug.drug.name}}
           </td>
      </tr>
    <tr>
      <th></th>
      <td >Pharmacy:</td>   
       <td>{{pharmacyDrug.pharmacy.name}}</td>

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
        idPatient : this.$route.params.idPatient,
       pharmacyDrug : [],
       reserveDate:null
      
      
       
    }
  },
  methods:{
    createReservation : function(){
            const reservation = {
            drug:this.pharmacyDrug.drug.idDrug,
            patient : this.idPatient,
            pharmacy : this.pharmacyDrug.pharmacy.idPharm,
            pickUpDate  :this.reserveDate,
            idPharmacyDrug:this.id
        }
        console.log(this.start);
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
         
      },
      
    
},
mounted() {
        this.axios.get('/pharmacyDrugs/getById/'+this.id)
        .then(response => {
                this.pharmacyDrug = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

        
        
    }
     
}
</script>

<style>
</style>
