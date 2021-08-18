<template>
<div>
    <div class="container" style="font-size:22px; color:black; background-color:#d9d9d9; padding:10px; ">
    <label>Creat eRecepie: </label>
    <div class="row">
        <div class="col-sm-5">
        <label > Patient: </label>
        </div>
        <div  class="col-sm">
        <select class="form-control" id="patient" style="font-size:22px;"
                                          aria-label="Enter patient" v-model="patSelected"                                          
                                    aria-describedby="addon-wrapping"
                                    v-on:change="selected">
                                    <option value="0"> Select patient.. </option>
                                    </select>
        </div>
        
    </div>

  <div class="row">
        <div class="col-sm-5">
        <label > Which medicationes: </label>
        </div>
        <div  class="col-sm-5">
        <select class="form-control" id="drugs" style="font-size:22px; "
                                          aria-label="Enter patient" v-model="drugSelected"                                          
                                    aria-describedby="addon-wrapping"
                                    ></select>
        </div>
        <div  class="col-sm-2">
        <input type="text" class="form-control" id="quan" style="font-size:22px;"
                                          aria-label="Enter patient" v-model="quantity"                                          
                                   >
        </div>        
    </div>


    
    <div class="row" >
   
     <div class="col-sm" style="margin-bottom:10px; margin-top:10px;">
      <h4> Medication list: </h4>
      <lable type="text" style="font-size:22px;" v-for="a in this.forRecept" v-bind:key="a" class="form-control">
        {{a.drugName}} - {{ a.quantity}}kom
      </lable>
      </div>
    </div>

    <div class="row" >
      
        <div class="col-sm" >
          <button class = "btn btn-primary btn-xs"                      
                          style="margin:auto;background: #303030; width: 500px;  border-color:black;" 
                          @click="add"> Add medication </button>
            
        </div>
        
    </div>

    <div class="row">
      
        <div class="col-sm" >
          <button class = "btn btn-primary btn-xs" :disabled="this.forRecept.length == 0"                     
                          style="margin:auto;background: #303030; width: 500px;
                          border-color:black;" 
                          @click="eRecept()"> eRecepie </button>
            
        </div>
        
    </div>

</div>

</div>
</template>

<script>
export default {
  
  data() {
    
    return {
       patients: [],
        id : this.$route.params.id,
       patSelected: "",
       drugs: [],
       drugSelected: "",
       accessToken: localStorage.getItem('accessToken'),
       num: 1,
       quantity: 0,
       forRecept: [],
    }
  },
  
  mounted() {
        this.axios.get('/patient/findAll/')
        .then(response => {

                this.patients = response.data;  
                document.getElementById("patient").length = 0; 
                var optionPharmacy1 = document.createElement("option");
                 optionPharmacy1.text = "Select patient.."
                 var select1 = document.getElementById("patient");
                 optionPharmacy1.value = 0;
                  select1.appendChild(optionPharmacy1);

              for(var p in this.patients)
                { 
                  var optionPharmacy = document.createElement("option");
                  optionPharmacy.text = this.patients[p].firstname+" "+ this.patients[p].surname;
                  optionPharmacy.value = this.patients[p].id;
                  var select = document.getElementById("patient");
                  select.appendChild(optionPharmacy);
                }

              

         }).catch(res => {
                console.log(res);
        });                       
                 
},
  methods:{
    eRecept: function()
    {
      alert("Please wait a few seconds..");
       this.axios.post('/erecipe/createERecp' ,this.forRecept, { 
            headers: {                    
                    'Authorization': `Bearer ` +  this.accessToken,                    
                }
            }).then(response => {
                  console.log(response.data);
                  alert("Successeffully created eRecepi!") 
                   window.location.href = this.$router.go(-1);
                   
                  
            }).catch(res => {
                          console.log(res.response.data.message);
                          alert(res.response.data.message);
                    });
    },
    add: function()
    {
      if(this.drugSelected != 0 && this.quantity != 0)
      {
        var name = "";
      for(var d in this.drugs)
                { 
                  const num = Number(this.drugSelected);
                  const id = Number(this.drugs[d].idDrug);
                  if( id == num)
                    {  name = this.drugs[d].name;}
                }
      const info = 
      {
        idDrug: this.drugSelected,
        idWhoCreate: this.id,
        drugName: name,
        idPatient: this.patSelected,
        quantity: this.quantity
      }
      console.log(info);
      this.forRecept.push(info);
      this.quantity = 0;
      this.drugSelected = 0;
      console.log( this.forRecept);
      }
      else{
        alert("Choose the medication or quantity!");
      }
      
    },
    selected: function()
    {
       document.getElementById("drugs").length = 0; 
       this.forRecept = [];
       console.log(this.patSelected);
        if(this.patSelected != 0){
        this.axios.get('/drug/getDrugsForERecepie/' + this.patSelected, { 
            headers: {                    
                    'Authorization': `Bearer ` +  this.accessToken,                    
                }
            }).then(response => {
                  console.log(response.data);
                  this.drugs = response.data;
          var optionD1 = document.createElement("option");
                 optionD1.text = "Select drug.."
                 var selectD1 = document.getElementById("drugs");
                 optionD1.value = 0;
                  selectD1.appendChild(optionD1);
                  
                   for(var d in this.drugs)
                { 
                  var optionD = document.createElement("option");
                  optionD.text = this.drugs[d].name;
                  optionD.value = this.drugs[d].idDrug;
                  var select = document.getElementById("drugs");
                  select.appendChild(optionD);
                }
                  //window.location.href = "/ReserveDrug/"+ response.data.idDrug +"/"+ p.name +"/" + this.id;
            }).catch(res => {
                          console.log(res.response.data.message);
                          alert("Greska");
                    });
    }
      else
      {
         document.getElementById("drugs").length = 0; 
        this.drugs = [];
      }
    }    
  }
}
</script>
<style>

</style>