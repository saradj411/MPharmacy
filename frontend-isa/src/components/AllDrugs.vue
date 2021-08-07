<template>
<div class="all">
    <h1> All drugs: </h1>
   <!-- <div class="container" >  
  <div class="col-sm " style="margin-bottom:5px; border-style:solid; color:black;" v-for="drug in this.drugs" v-bind:key="drug.idDrug" >
    <div>
    </div>

            <div class="container">
                <div class="row">
                    <div class="col-sm" style="width:100%">
                        <div class="row">
                                <div class="col-sm">
                            Name: 
                            </div>
                            <div class="col-sm">
                                {{drug.name}}
                                </div>                               
                        </div>
                         <div class="row">
                                <div class="col-sm">
                            Type:
                            </div>
                            <div class="col-sm">
                                 {{drug.drugType}}
                                </div>                               
                        </div>
                         <div class="row">
                                <div class="col-sm">
                            Grade:
                            </div>
                            <div class="col-sm">
                                 {{drug.grade}}
                                </div>                               
                        </div>

                    
                    
                    
                    
                    
                    
                    
                    
                    
                    </div>
                    <div class="col-sm">
                        <div class="row" v-for="p in drug.pharmaciesAndPriceDTO" v-bind:key="p.name">
                                  <div class="col-sm">
                            {{p.name}} <br>
                            {{p.address}}, {{p.city}}
                            </div>
                            <div class="col-sm">
                                 {{p.price}} din
                                </div>                                
                        </div>

                  
                  
                    </div>
                
                </div>
            </div>



   
    </div>
    </div>-->
<!-- PROBA -->
    <div class="col-sm-4" style="" v-for="drug in this.drugs" v-bind:key="drug.idDrug">
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
                
                <table style="width:100%; text-align:center;">
                    <tr>
                    <td rowspan="2" style="width:70%; text-align:center; margin: 0 auto;">
                         <h3>{{p.name}} </h3> 
                                               
                    </td>
                    </tr> 
                <tr>
                    
                    <td style="width:30%; text-align: left;">
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

            <div class="panel-body" style="text-align:center;" >            
                
                <h1>DASD</h1>
                     
                

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
            userAuth: localStorage.getItem('accessToken'), 
            id : this.$route.params.id,
            drugs: [],
            spec: {},
                        
           
        }
      },
      methods:{
          getSpec: function(name)
          {
              
            console.log(name);
            this.axios.get('specification/findSpecByDrugName/' + this.name, { 
            headers: {                    
                    'Authorization': `Bearer ` + accessToken,
                    
                }
            }).then(response => {

                  this.spec = response.data;
                  console.log(this.spec);

            }).catch(res => {
                          alert("Token expired!");
                          window.location.href = '/login';
                          console.log(res.response.data.message);
                    });


        
        }       
          }
          
    },
    mounted() {
     var accessToken = localStorage.getItem('accessToken');
    this.axios.get('drug/drugsInfo/',{ 
            headers: {                    
                    'Authorization': `Bearer ` + accessToken,
                    
                }
            }).then(response => {

                  this.drugs = response.data;
                  console.log(this.drugs);

            }).catch(res => {
                          alert("Token expired!");
                          window.location.href = '/login';
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
    width:100%;
}
td
{
    width: 100%;
}
</style>