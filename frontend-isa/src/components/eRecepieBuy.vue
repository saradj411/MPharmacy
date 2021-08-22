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
                            v-on:click="filter('gradeDesc')" > Town Asc </button>
                    
                        </div>
                        <div class="col-sm"> <button class = "btn btn-primary btn-xs"                     
                            style="margin:auto; background: #000; width: 200px;"
                            v-on:click="sortPrice" > {{ this.priceLabelSort }}</button>
                        </div>
                        <div class="col-sm">
                        <button class = "btn btn-primary btn-xs"                     
                            style="margin:auto; background: #000; width: 200px;"
                            v-on:click="sortName" >{{nameLabelSort }} </button>
                        </div>
          </div>
      </div>

   <div class="" style="width: 500px; margin: 10px; display: inline-table" v-for="drugAndP in this.pharmaciesWithDrugs" v-bind:key="drugAndP.totalPrice">
     
          <div class="panel-heading" style="border-style:solid;" >  
                <table style="width:100%;">
                  <tr>
                      <td style="width:85%; text-align:center; font-family: Georgia, serif;" >
                  <h2> <b>  {{ drugAndP.pharmacyDrugsDTOList.pharmacy.name }}</b></h2>
                      </td>
                      <td> 
                      <div style="background-color:#ebe5c5; text-align:center;  border-radius: 100%; padding:10px; margin:10px; margin-left:20px margin-right:20px; margin-bottom: -10px;" >
                  {{ drugAndP.pharmacyDrugsDTOList.pharmacy.avgGrade }}
                  </div>
                      </td>
                      
                  </tr>
                  <tr>
                    <td style="width:85%; text-align:center;" >
                    {{ drugAndP.pharmacyDrugsDTOList.pharmacy.address}} , {{ drugAndP.pharmacyDrugsDTOList.pharmacy.town}}
                    </td>
                  </tr>
                </table> 
            </div>


      <div class="panel-body" style="text-align: left;" v-for=" one in drugAndP.pharmacyDrugsDTOList.drugs" v-bind:key="one.name">
        <table style="text-align:right; font-size:22px;width:800px">
                        <tr style="width:100%;">
                        <td style="width:200px; text-align:right; padding-left:20px;padding-right:20px; margin: 0 auto;">
                            <h3>{{ one.drug.name }}  </h3>                                               
                        </td>  
                        <td style="text-align: right;width:200px; padding-left:20px; padding-right:20px;">
                            {{one.quantity}} x
                        </td>
                        <td style="text-align: right; width:200px;padding-left:20px; padding-right:20px;">
                            {{one.price}} din/piecs 
                        </td>
                    </tr>   
        </table>
    </div>
        <div class="panel-body" style="text-align:center;">          
                  
                   
          <table style="text-align:right; font-size:22px;width:800px;">
                        <tr style="width:100%; background-color:rgb(183, 212, 176);">
                        <td style="width:200px; text-align:right; padding-left:20px;padding-right:20px; margin: 0 auto;">
                                                                  
                        </td>  
                        <td style="text-align: right;width:200px; padding-left:20px; padding-right:20px;">
                         <h3>Total price: </h3>         
                        </td>
                        <td style="text-align: right; width:200px;padding-left:20px; padding-right:20px;">
                           {{drugAndP.totalPrice}} din
                        </td>
                    </tr>   
        </table>

               <button class="btn btn-danger" style="width:100%;" v-on:click="buy(drugAndP.pharmacyDrugsDTOList.pharmacy)" > Buy </button>      
        </div>  




  </div>
  




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
        priceAsc: false,
        gradeAsc: false,
        townAsc: false,
        nameAsc: false,
        
      priceLabelSort: "Price Asc",
      nameLabelSort: "Pharmacy name Asc",
        
       
    }
  },
  
  methods:{
    buy: function(p)
  {
    console.log("AAA");
    console.log(p);

    this.axios.get('/erecipe/buyDrug/'+this.idRec+'/'+ p.idPharm,
                                {
                              headers: 
                              {
                                  'Authorization': `Bearer ` + this.accessToken,
                                  
                              }}).then(response => 
                              { console.log(response.data);
                                alert("You buy it successeffully!");
                                window.location.href = "/HomePagePatient/"+this.id;

                              }).catch(res => {
                                  alert(res.response.data);                            
                              });  

    
  },
  sortName: function()
  {
    if(this.nameAsc == false)
    {
      this.nameAsc = true;
      this.nameLabelSort = "Pharmacy name Desc";
      this.axios.get('/erecipe/sortNameAsc/'+this.idRec,
                                  {
                                headers: 
                                {
                                    'Authorization': `Bearer ` + this.accessToken,
                                    
                                }}).then(response => 
                                {    
                                  this.pharmaciesWithDrugs = response.data;
                                  console.log(this.pharmaciesWithDrugs);  
                                      
                                }).catch(res => {
                                    alert(res.response.data);                            
                                });


    }
    else
    {
      this.nameAsc = false;
      this.nameLabelSort = "Pharmacy name Asc";
    }
  },
  sortPrice: function()
  {
    if(this.priceAsc == false)
    {
      this.priceAsc = true;
      this.priceLabelSort = "Price Desc"
       this.axios.get('/erecipe/sortPriceAsc/'+this.idRec,
                            {
                          headers: 
                          {
                              'Authorization': `Bearer ` + this.accessToken,
                              
                          }}).then(response => 
                          {    
                            this.pharmaciesWithDrugs = response.data;
                            console.log(this.pharmaciesWithDrugs);  
                                
                          }).catch(res => {
                              alert(res.response.data);                            
                          });
    }
    else
    {
      this.priceAsc = false;
      this.priceLabelSort = "Price Asc"
       this.axios.get('/erecipe/sortPriceDesc/'+this.idRec,
                            {
                          headers: 
                          {
                              'Authorization': `Bearer ` + this.accessToken,
                              
                          }}).then(response => 
                          {    
                            this.pharmaciesWithDrugs = response.data;
                            console.log(this.pharmaciesWithDrugs);  
                                
                          }).catch(res => {
                              alert(res.response.data);                            
                          });
      
    }
  }
  
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

                      this.axios.get('/erecipe/getPharmacyForRecept/'+this.idRec,
                            {
                          headers: 
                          {
                              'Authorization': `Bearer ` + this.accessToken,
                              
                          }}).then(response => 
                          {     
                            console.log("APOTEKE");   
                            this.pharmaciesWithDrugs = response.data;
                            console.log(this.pharmaciesWithDrugs);      
                          }).catch(res => {
                              alert(res.response.data);                            
                          });                        
                                            
        
                    }).catch(res => {
                       // alert(res.response.data);
                        console.log(res);
                    }); 

        
    }
}

</script>