<template>
<div style="color:black;">
<h1> Your QR Code: </h1>
  <div class="panel-body" style="text-align:center; background-color:#fff; border: 0px solid;" >            
           
<table style="width:800px;font-size:20px; background-color:#d9d9d9; color:black; border: 1px solid; text-align:left; margin:0 auto; ">
    <tbody>
    <tr style="border: 1px solid; background-color: #b7d4b0;">
      <td style="padding-left:10px;">ERecepie id: </td>
      <td>{{this.result.eRecipe.idRecipe}}</td>
    </tr>
    <tr>
      <td style="padding-left:10px;">Code: </td>
      <td>{{this.result.eRecipe.code}}</td>
    </tr>
    <tr style="border: 1px solid;">
      <td style="padding-left:10px;">Date of issuing: </td>
      <td>{{this.result.eRecipe.dateOfIssue[2]}}.{{this.result.eRecipe.dateOfIssue[1]}}.{{this.result.eRecipe.dateOfIssue[0]}}</td>
    </tr>
    <tr>
      <td style="padding-left:10px;">Who prescibe: </td>
      <td > {{this.result.user.name}} {{this.result.user.surname}} </td>
    </tr>
    <tr style="border: 1px solid;">
          <td  style="padding-left:10px;"> You will need: </td>
           <td></td>
           </tr>
    <tr style="border: 1px solid;">
      <td style="padding-left:10px;">Medications: </td>
      <td> 
          <table style="width:200px;">
          


            <tr v-for="d in this.result.eRecipe.eRecipeDrug" v-bind:key="d.id">
             <td> {{d.name}}: </td>
             <td> {{d.quantity}}piecs </td>
            </tr>
          
          </table>
      
       </td>
    </tr>

    </tbody>
  
  </table>
      </div>

      <div class="container" style="margin-top:10px;">
                    <div class="row">
                        <div class="col-sm"> <button class = "btn btn-primary btn-xs"                      
                            style="margin:auto; background: #000; width: 200px;" v-on:click="filter('gradeAsc')" > Grade Asc</button>
                    
    
                        </div>
                        <div class="col-sm">
                        <button class = "btn btn-primary btn-xs"                     
                            style="margin:auto; background: #000; width: 200px;"
                            v-on:click="filter('gradeDesc')" > Town & Country Asc </button>
                    
                        </div>
                        <div class="col-sm"> <button class = "btn btn-primary btn-xs"                     
                            style="margin:auto; background: #000; width: 200px;"
                            v-on:click="filter('drugTypeAsc')" > Price Asc </button>
                        </div>
                        <div class="col-sm">
                        <button class = "btn btn-primary btn-xs"                     
                            style="margin:auto; background: #000; width: 200px;"
                            v-on:click="filter('drugTypeDesc')" > Pharmacy name Asc </button>
                        </div>
                    </div>
                </div>

 <div class="" style="width: 500px; margin: 10px; display: inline-table" v-for="dd in this.pharmaciesWithDrugs" v-bind:key="dd.pharmacyName">
        <div class="panel panel-prmary" style="text-align: left;">   
            <div class="panel-heading" style="border-style:solid;" >  
            <table style="width:100%;">
            <tr>
                <td style="width:85%; text-align:center; font-family: Georgia, serif;" >
             <h2> <b> {{ dd.pharmacyName }}</b></h2>
                </td>
                <td> 
                 <div style="background-color:#ebe5c5; text-align:center;  border-radius: 100%; padding:10px; margin:5px; margin-left:20px margin-right:20px;" >
            {{ dd.grade }}
            </div>
                </td>
                
            </tr>
            <tr>
            <td style="width:85%; text-align:center;" >
            {{dd.address}} , {{dd.town}}
            </td>
            
            </tr>
            </table>          
               
               
            </div>
              
            <div class="panel-body" style="text-align:center;"   >            
                
                <table style="text-align:right; font-size:22px;width:100%">
                    <tr style="width:100%; border: 1px solid;">
                    <td style="width:200px; text-align:right; padding-left:20px;padding-right:20px; margin: 0 auto;">
                         <h3>{{dd.drugName }}  </h3> 
                                               
                    </td>
                     
                    
                    <td style="text-align: right;width:200px; padding-left:20px; padding-right:20px;">
                        {{dd.quantity}}x
                    </td>
                    <td style="text-align: right; width:200px;padding-left:20px; padding-right:20px;">
                        {{dd.price}} din 
                    </td>
                </tr>
                <tr style="width:100%; border: 1px solid;">
                <td style="width:200px; padding-right:20px;"></td>
                <td style="width:200px; padding-right:20px;">Total:</td>
                <td style="width:200px; padding-right:20px;">{{dd.price*dd.quantity}} din</td>
                </tr>
                <tr>
                <td colspan="3">
                <button class="btn btn-danger" style="width:100%;" > Buy </button> 
                </td>
                </tr>
                </table>
                     
                

            </div>
</div></div>



</div>
</template>

<script>
export default
{
     data() {
    return {
        id : this.$route.params.id,
        idRec : this.$route.params.idRec,           
       result: {},
       user: {},
       //pharmacyDrug : [],
       reserveDate:null,
       pharmacy: {},
       drug: {},
       pharmaciesWithDrugs: [],
      accessToken: localStorage.getItem('accessToken'),
        
       
    }
  },
  
  methods:{
  
  },    
    

mounted() {
       this.axios.get('erecipe/showERecepieQRcode/'+this.idRec,
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + this.accessToken,
                        
                    }}).then(response => 
                    {                    
                      this.result = response.data;

                      for(var i = 0; i < this.result.eRecipe.eRecipeDrug.length ; i++)
                      {
                            this.axios.get('/erecipe/getPharmacyWhereToBuy/'+ this.result.eRecipe.eRecipeDrug[i].name+'/' +parseInt(this.result.eRecipe.eRecipeDrug[i].quantity),
                            {
                          headers: 
                          {
                              'Authorization': `Bearer ` + this.accessToken,
                              
                          }}).then(response => 
                          {     

                            this.pharmaciesWithDrugs.push(response.data);                          
                              
                    console.log(this.pharmaciesWithDrugs);      
                          }).catch(res => {
                              alert(res.response.data);                            
                          });                        
                        }                    
        
                    }).catch(res => {
                       // alert(res.response.data);
                        console.log(res);
                    }); 

        
    }
}

</script>