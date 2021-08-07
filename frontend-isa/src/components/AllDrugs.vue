<template>
<div class="all">
    <h1 style="margin-top:10px"> ALL DRUGS: </h1>
    <div class="container">
  <div class="row">
    <div class="col-sm" style="font-size:20px;">
      Searh drug: 
    </div>
    <div class="col-sm">
     <input type="text" v-model="drugSearch" 
                   
                    class="form-control" placeholder="Enter drug name.."  
                    aria-label="Enter drug name.." aria-describedby="addon-wrapping"
                    style="width:350px; ">
    </div>
        
        <div class="col-sm">
        <button class = "btn btn-primary btn-xs"                      
                        style="margin:auto;background: #000; width: 200px;" v-on:click="search(drugSearch)" > Search </button>
                 
    
      </div>
  </div>
                </div>
                <div class="container" style="margin-top:10px;">
                <div class="row">
                    <div class="col-sm"> <button class = "btn btn-primary btn-xs"                      
                        style="margin:auto; background: #000; width: 200px;" v-on:click="filter('gradeAsc')" > Grade ascending </button>
                 
  
                    </div>
                    <div class="col-sm">
                    <button class = "btn btn-primary btn-xs"                     
                        style="margin:auto; background: #000; width: 200px;"
                         v-on:click="filter('gradeDesc')" > Grade descendign </button>
                 
                    </div>
                    <div class="col-sm"> <button class = "btn btn-primary btn-xs"                     
                        style="margin:auto; background: #000; width: 200px;"
                         v-on:click="filter('drugTypeAsc')" > Drug type ascending </button>
                    </div>
                    <div class="col-sm">
                     <button class = "btn btn-primary btn-xs"                     
                        style="margin:auto; background: #000; width: 200px;"
                         v-on:click="filter('drugTypeDesc')" > Drug type descendign </button>
                    </div>
                </div>
                </div>
<!-- PROBA -->
    <div class="" style="width: 500px; margin: 10px; display: inline-table" v-for="drug in this.drugs" v-bind:key="drug.idDrug">
        <div class="panel panel-prmary" style="text-align: left;">   
            <div class="panel-heading" style="border-style:solid;" >  
            <table style="width:100%;">
            <tr>
                <td style="width:85%; text-align:center; font-family: Georgia, serif;" >
             <h2> <b> {{ drug.name }} </b></h2>
                </td>
                <td  rowspan="2" style="text-align:center">
                <div style="background-color:#ebe5c5;  border-radius: 100%; padding:10px; margin:5px; margin-left:20px margin-right:20px;" >
            {{ drug.grade }}
            </div>
                </td>
            </tr>
            <tr>
            <td style="width:85%; text-align:center;" >
            <h4> Drug type:  {{ drug.drugType }}</h4>
            </td>
            
            </tr>
            </table>          
               
               
            </div>
              
            <div class="panel-body" style="text-align:center;"  v-for="p in drug.pharmaciesAndPriceDTO" v-bind:key="p.name" >            
                
                <table style="text-align:center;">
                    <tr>
                    <td rowspan="2" style="width:200px; text-align:left; padding-left:10px; margin: 0 auto;">
                         <h3>{{p.name}}  </h3> 
                                               
                    </td>
                     
                        <td rowspan="2" style="width:150px; text-align: left; font-size:20px;"> {{p.price}} din</td>
                    
                    
                    
                    <td style="text-align: left;">
                        <tr>
                        {{p.address}},</tr>
                        <tr>
                        {{p.city}} </tr>
                    </td>
                </tr>
                </table>
                     
                

            </div>
             <div class="panel-body" v-if="drug.pharmaciesAndPriceDTO.length < 1" 
             style=" text-align:center;" >
                <h5> Pharmacies doesn't have this drug. </h5>
             </div>
                        
<!-- SPECIFICATION -->

            <div class="panel-body" style="background-color:#fcfcfc;" v-show="drug.name == selected && selected != ''"  >            
                
                <h4  style="text-align:center;">Specification about drug: </h4>
                <table >
                <tr  style="border-top: 1px solid;">
                    <td style="width: 300px; padding-left:10px;"> Recomended dose: </td>
                    <td style="width: 400px; padding-left:10px;">{{ spec.recommendedDose }}</td>
                </tr>
                <tr  style="border-top: 1px solid;">
                    <td style="padding-left:10px;">Structure: </td>
                    <td style="padding-left:10px;">{{ spec.structure }}</td>
                </tr>
                <tr  style="border-top: 1px solid;">
                    <td style="padding-left:10px;"> Contraindications:</td>
                    <td style="padding-left:10px;">{{spec.contraindications}}</td>
                </tr>
                 <tr  style="border-top: 1px solid;">
                    <td style="padding-left:10px;"> Ingredients:</td>
                    <td style="padding-left:10px;">{{spec.ingredients}}</td>
                </tr>
                <tr  style="border-top: 1px solid;">
                    <td style="padding-left:10px;"> Manufacturer:</td>
                    <td style="padding-left:10px;">{{spec.drug.manufacturer}}</td>
                </tr >
                <tr  style="border-top: 1px solid;">
                    <td style="padding-left:10px;"> Alternative drugs:</td>
                    <td style="padding-left:10px;">
                        <table>
                            <tr v-show ="selected != '' && spec.drug.alternativeDrugs.length == 0"> Doesn't have alternative drugs. </tr>
                            <tr v-for="d in spec.drug.alternativeDrugs" v-bind:key="d.idDrug" >
                                <td style=""> {{d.name}} </td>
                            </tr>
                        
                        </table>
                    </td>
                </tr>
                <tr  style="border-top: 1px solid;">
                    <td style="padding-left:10px;"> You should know:</td>
                    <td style="padding-left:10px;">{{spec.drug.napomene}}</td>
                </tr>


                <tr>

                </tr>
                </table>
                     
                

            </div>


            <div class="panel-body" style="background-color:#fcfcfc;" v-show="drug.pharmaciesAndPriceDTO.length != 0 &&  user.authorityRole == 'ROLE_PATIENT'"  >            
                <button class="btn btn-danger" style="width:100%;" v-on:click="showPharmacies(drug.name)" > Reserve </button> 
            </div>
            <div class="panel-body" style="background-color:#fcfcfc;" v-if="drug.name == reservDrugSelected && reservDrugSelected != ''">            
                <h5 style="padding: 10px; font-size: 19px; text-align:center;" > Please select in which pharmacy you want to reserve. </h5>
               <table>
                <tr v-for="p in drug.pharmaciesAndPriceDTO" v-bind:key="p.name" style="width:100%;  border-top: 1px solid;" >
                    <td style="width:100%; padding-left: 20px;" > {{p.name}} </td>
                    <td style="width:100%"> <button class="btn btn-danger" style="width:100%;" v-on:click="reserveDrug(drug, p)" > Reserve </button> </td>
                
                </tr>
               </table>
            </div>





                
            <div class="panel-footer">            
        <button class="btn btn-dark" style="width:100%;" v-on:click="getSpec(drug.name)"> See specification </button> 
            </div>
        </div>
        
    </div>

</div>
</template>

<script>
export default {
      data() {
        return {             
            
            id : this.$route.params.id,
            drugs: [],
            spec: {
                contraindications: "",
                drug: {},
                idSpec: 0,
                ingredients: "",
                recommendedDose: 0,
                structure: ""
            },
            accessToken: localStorage.getItem('accessToken'),
            hasSpec: "",
            selected: "",
            drugSearch: "",
            allDrugs: [],
            fil: "",
            reservDrugSelected: "",
            user: {}

                        
           
        }
      },
      methods:{
          showPharmacies: function(name)
          {
              this.reservDrugSelected = name;
              
          },
          reserveDrug: function(drug, p)
          {
              console.log(drug.name);
              console.log(p.name);

                 this.axios.get('/drug/getByName/' + drug.name, { 
            headers: {                    
                    'Authorization': `Bearer ` +  this.accessToken,                    
                }
            }).then(response => {
                  console.log(response.data);
                  //window.location.href = "/ReserveDrug/"+ response.data.idDrug +"/"+this.id;
            }).catch(res => {
                          console.log(res.response.data.message);
                          alert("Greska");
                    });

          },
          getSpec: function(name)
          {           
            this.selected = name;
            this.axios.get('specification/findSpecByDrugName/' + name, { 
            headers: {                    
                    'Authorization': `Bearer ` +  this.accessToken,
                    
                }
            }).then(response => {
                  this.spec = response.data;
            }).catch(res => {
                          console.log(res.response.data.message);
                    });


        
        }  ,
        search: function(drugSearch)
        {
            if(drugSearch != "")
            {
            this.axios.get('drug/searchByName/' + drugSearch, { 
            headers: {                    
                    'Authorization': `Bearer ` +  this.accessToken,                    
                }
            }).then(response => {
                  this.drugs = response.data;
            }).catch(res => {
                       
                          console.log(res.response.data.message);
                    });
            }
            else
            {
                this.drugs = this.allDrugs;
            }
        },
        
        filter: function(sortType)
        {
            console.log(sortType);
                if(this.drugSearch == "")
                     this.fil = "empty";
                else
                    this.fil = this.drugSearch;


            this.axios.get('/drug/sort/' + sortType +'/'+ this.fil, { 
            headers: {                    
                    'Authorization': `Bearer ` +  this.accessToken,                    
                }
            }).then(response => {
                  this.drugs = response.data;
            }).catch(res => {
                          console.log(res.response.data.message);
                    });
        }
          
          
    },
    mounted() {
     

     this.axios.get('drug/drugsInfo/',{ 
            headers: {                    
                    'Authorization': `Bearer ` + this.accessToken,
                    
                }
            }).then(response => {

                  this.drugs = response.data;
                  this.allDrugs = response.data;

            }).catch(res => {
                        
                          console.log(res.response.data.message);
                    });


        this.axios.get('user/findById/'+ this.id ,{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + this.accessToken,
                    'Access-Control-Allow-Origin': '*',
                 
                }
            }).then(response => {

                  this.user = response.data;
                  console.log(this.user);

            }).catch(res => {
                          alert("Token expired!");
                          //window.location.href = '/login';
                          console.log(res.response.data.message);
                    });
        
        }  
        
    }

</script>

<style>
@import url('https://fonts.googleapis.com/css?family=Open+Sans');
.all
{
    margin-top:-40px;
    background-color:white;
    color:black;
    font-family: "Open Sans", sans-serif;
}

.col-sm-4
{    
    display: inline-table;
    margin:10px;
     
}

.panel-heading
{
    background-color: #969696;
    width: 100%;
    border-style: solid;
    border-width: 1px;
}
.panel-body
{
    background-color: #dbdbdb;
    border-style: solid;
    border-width: 1px;
}
.panel-footer
{
    border-style: solid;
    border-width: 1px;
    background-color: #dbdbdb;
}

tr{    
 
}
td
{
    
}
</style>