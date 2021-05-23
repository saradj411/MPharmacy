<template>


  <div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  background-size: 150% 111%;  height: 1100px">

<div  style="background: #d1af71; height: 90px;">

 <button style="float:left;margin-left:20px;" type="button" class="btn btn-primary btn-xs" v-on:click = "addDrug" >Dodaj lijek</button>
 <button style="float:left;margin-left:20px;" type="button" class="btn btn-primary btn-xs" v-on:click = "profileDermatologist">Profil dermatologa</button>
 <button style="float:left;margin-left:20px;" type="button" class="btn btn-primary btn-xs" v-on:click = "profilePharmacist">Profil farmaceuta</button>
 <button style="float:left;margin-left:20px;" v-on:click = "addDrug" >Dodaj lijek</button>
 <button style="float:left;margin-left:20px;" v-on:click = "profileAdmin" >Profil administratora apoteke</button>

<button style="float:left;margin-left:20px;" v-on:click = "profilePatient" >Patinet profil</button>

</div>
   <div style="background: #676982; height: 90px;margin-top: 15px;">

      <span style="float:left; margin: 15px;">
          <button class="btn btn-danger btn-lg" style="float:left;margin-left:20px;margin-top:7px" v-on:click = "showPharmacies">Pharmacies</button>
           <button class="btn btn-danger btn-lg" style="float:left;margin-left:20px;margin-top:7px" v-on:click = "showDrugs">Drugs</button>
           
      </span>
      <span  style="float:right;margin:15px">
           <button class="btn btn-info btn-lg" v-on:click = "loginForm">Login</button>
           <button class="btn btn-info btn-lg" style="margin:10px;" v-on:click = "registrationForm">Register</button>
      </span>

    </div>
        
    <div v-if="showSearchPharmacy"  style="background:#B0B3D6; height: 70px; margin-top: 10px">
            
      <span  style="float:right;margin:15px">
                    
          <div class="input-group mb-3">
              <input type="text" v-model="pharmacyName" class="form-control" placeholder="Enter name" aria-label="Enter name" aria-describedby="addon-wrapping">
              <div class="input-group-append">
                  <button class="btn btn-info" type="button"  v-on:click = "searchName(pharmacyName)" >Search</button>
                </div>
           </div>
      </span>

      <span  style="float:right;margin:15px">
                    
        <div class="input-group mb-3">
             <input type="text" v-model="pharmacyCity" class="form-control" placeholder="Enter city" aria-label="Enter city" aria-describedby="addon-wrapping">
              <div class="input-group-append">
                  <button class="btn btn-info" type="button"  v-on:click = "searchCity(pharmacyCity)" >Search</button>
              </div>
        </div>

            
      </span>
             
            
  </div>
 
 
 
 <div v-if="showTable"  style="margin-left:0px;">
     <h4 style="margin:30px">PHARMACIES:</h4>    
 <div style="background: #a7c1c9; width: 700px;margin-left:300px;"  v-for="pharmacy in this.pharmacies"  v-bind:key="pharmacy.idPharm">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td><router-link :to="{ path: '/Home/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size: 30px;margin-left:50px;" :href="href" @click="navigate"  elevation="1">
              {{pharmacy.name}}
            </b-link >
         </router-link></td>
      <td>Grade:{{pharmacy.avgGrade}} </td>
      </tr>
    <tr>
      <th></th>
      <td >Address  </td>   
       <td>{{pharmacy.address}}</td>

    </tr>
   
  </tbody>
</table>
           </div>

      </div>   
<!-- PRETRAGA APOTEKA!-->
<div v-if="showSearchPharmacyTable"  style="margin-left:0px;">
     <h4 style="margin:30px">PHARMACIES1:</h4>    
 <div style="background: #a7c1c9; width: 700px;margin-left:300px;"  v-for="pharmacy1 in this.pharmacies1"  v-bind:key="pharmacy1.idPharm">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td><router-link :to="{ path: '/Home/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size: 30px;margin-left:50px;" :href="href" @click="navigate"  elevation="1">
              {{pharmacy1.name}}
            </b-link >
         </router-link></td>
      <td>Grade:{{pharmacy.avgGrade}} </td>
      </tr>
    <tr>
      <th></th>
      <td >Address  </td>   
       <td>{{pharmacy1.address}}</td>

    </tr>
   
  </tbody>
</table>
           </div>

      </div>   
<!--prikaz lijekova!-->
<div v-if="showDrugTable"  style="margin-left:0px;">
  <h4 style="margin:30px">DRUGS:</h4>
      <div style="background: #a7c1c9; width: 700px;margin-left:300px;"  v-for="drug in this.drugs"  v-bind:key="drug.idDrug">
      
         
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td style="font-size:25px;font-weight:bold;">{{drug.drug.name}}
           </td>
      <td style="font-weight:bold;">{{drug.price}}RSD</td>
      </tr>
    <tr>
      <th></th>
      <td >Pharmacy:</td>   
       <td>{{drug.pharmacy.name}}</td>

    </tr>
    <tr>
      <th></th>
      <td >Price duration:</td>   
       <td>{{drug.start | formatDate}}-{{drug.end| formatDate}}</td>

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
       pharmacies : [],
       pharmacies1 : [],
       drugs:[],

       showTable: true,
       showDrugTable: false,

       showSearchPharmacyTable:false,
       showSearchDrugTable:false,

       pharmacyName: null,
       pharmacyCity: null,

       showSearchPharmacy:true,
       showSearchDrug:false
      
       
    }
  },
  methods:{
    addDrug : function(){
          window.location.href = "/createDrugPage";
      },
      profileAdmin : function(){
          window.location.href = "/ProfileAdmin";
      },
       profilePatient : function(){
          window.location.href = "/HomePagePatient/508";
      }
     ,profileDermatologist: function(){
          window.location.href = "/profileDermatologist";
      }  
      ,profilePharmacist: function(){
          window.location.href = "/profilePharmacist";
      }  ,
        registrationForm : function(){
        window.location.href = "/registration";
      },
      loginForm : function(){
        window.location.href = "/login";
      },
      showDrugs: function(){
        this.showTable=false
        this.showDrugTable=true
        this.showSearchPharmacy=false
        this.showSearchPharmacyTable=false
      },
      showPharmacies: function(){
        this.showTable=true
        this.showDrugTable=false
        this.showSearchPharmacy=true
      },
      searchName: function(pharmacyName){
           
             this.pharmacyName = pharmacyName
      this.axios.get('/pharmacy/findByName/'+ this.pharmacyName)
          .then(response => {
              this.showTable = false;
              this.showSearchPharmacyTable = true;
                this.pharmacies1= response.data;
                
              
          })
      },
      searchCity: function(pharmacyCity){
           
             this.pharmacyCity = pharmacyCity
      this.axios.get('/pharmacy/findByCity/'+ this.pharmacyCity)
          .then(response => {
              this.showTable = false;
              this.showSearchPharmacyTable = true;
                this.pharmacies1= response.data;
                
              
          })
      },
    
},
mounted() {
        this.axios.get('/pharmacy/findAll')
        .then(response => {
                this.pharmacies = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

        this.axios.get('/drugPricelist/findAll')
        .then(response => {
                this.drugs = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

        this.axios.get('/user/updatePenality')
        .catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
        
    }
     
}
</script>

<style>
</style>
