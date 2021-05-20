<template>
  <div id="registration" >
  

 <button style="float:left;margin-left:20px;" type="button" class="btn btn-primary btn-xs" v-on:click = "addDrug" >Dodaj lijek</button>
 <button style="float:left;margin-left:20px;" type="button" class="btn btn-primary btn-xs" v-on:click = "profileDermatologist">Profil dermatologa</button>
 <button style="float:left;margin-left:20px;" type="button" class="btn btn-primary btn-xs" v-on:click = "profilePharmacist">Profil farmaceuta</button>
 
 
        <h4 style="float:left;margin-top:100px;margin-left:20px;">Pharmacies:</h4>
        <h4 style="margin:20px">Pharmacies:</h4>

 <button style="float:left;margin-left:20px;" v-on:click = "addDrug" >Dodaj lijek</button>
 <button style="float:left;margin-left:20px;" v-on:click = "profileAdmin" >Profil administratora apoteke</button>

 <div  v-for="pharmacy in this.pharmacies"  v-bind:key="pharmacy.idPharm">
       <div v-if="showTable"  style="margin-left:300px; margin-top: 20px"> 
         
 <router-link :to="{ path: '/Home/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
 
<table  style="" id="table2" class="table" :href="href" @click="navigate"  elevation="1">
 
    <tbody>
    <tr>
      <th scope="row"></th>
      <td>Pharmacy name</td>
      <td>{{pharmacy.name}} </td>
    
    </tr>
    <tr>
      <th scope="row"></th>
      <td>Address</td>
      <td>{{pharmacy.address}}</td>

    </tr>
    <tr>
      <th scope="row"></th>
      <td>Grade</td>
      <td>{{pharmacy.avgGrade}} </td>
     
    </tr>
     
    
  </tbody>
</table>

        </router-link>
     
           </div>

      </div>     
<div>
                
            
        </div>
    </div>
    
</template>



<script>
export default {
  data() {
    return {
       pharmacies : [],
       showTable: true,
      
       
    }
  },
  methods:{
    addDrug : function(){
          window.location.href = "/createDrugPage";
      },
      profileAdmin : function(){
          window.location.href = "/ProfileAdmin";
      }
     ,profileDermatologist: function(){
          window.location.href = "/profileDermatologist";
      }  
      ,profilePharmacist: function(){
          window.location.href = "/profilePharmacist";
      }  
},
mounted() {
        this.axios.get('/pharmacy/findAll')
        .then(response => {
                this.pharmacies = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
        
    }
     
}
</script>

<style>
</style>
