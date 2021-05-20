<template>
  <div id="registration" >
   <div style="background: #d1af71; height: 90px;">
            
            <span style="float:left; margin: 15px;">
              
                <button class="btn btn-danger btn-lg" style="float:left;margin-left:20px;margin-top:7px" v-on:click = "showDrugs">Drugs</button>
                <button class="btn btn-danger btn-lg" style="float:left;margin-left:20px;margin-top:7px" v-on:click = "showPharmacies">Pharmacies</button>
                
            </span>
              <span  style="float:right;margin:15px">
                    <button class="btn btn-info btn-lg" v-on:click = "loginForm">Login</button>

                    <button class="btn btn-info btn-lg" style="margin:10px;" v-on:click = "registrationForm">Register</button>
                </span>

        </div>
        

 <button style="float:left;margin-left:20px;" v-on:click = "addDrug" >Dodaj lijek</button>

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
<div v-if="showDrugTable"  style="margin-left:0px;">
  <h4 style="margin:30px">DRUGS:</h4>
      <div style="background: #a7c1c9; width: 700px;margin-left:300px;"  v-for="drug in this.drugs"  v-bind:key="drug.idDrug">
      
         
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td>{{drug.name}}
           </td>
      <td>Grade:{{drug.avgGrade}} </td>
      </tr>
    <tr>
      <th></th>
      <td >Address  </td>   
       <td>{{drug.address}}</td>

    </tr>
   
  </tbody>
</table>
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
       drugs:[],
       showTable: true,
       showDrugTable: false,
       showShearchPharmacy:true,
       showShearchDrug:false
      
       
    }
  },
  methods:{
    addDrug : function(){
          window.location.href = "/createDrugPage";
      },
        registrationForm : function(){
        window.location.href = "/registration";
      },
      loginForm : function(){
        window.location.href = "/login";
      },
      showDrugs: function(){
        this.showTable=false
        this.showDrugTable=true
      },
      showPharmacies
      : function(){
        this.showTable=true
        this.showDrugTable=false
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

        this.axios.get('/drug/findAll')
        .then(response => {
                this.drugs = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
        
    }
     
}
</script>

<style>
</style>
