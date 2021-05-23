<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Pharmacy drugs:</label>



<!--pretrazi-->


<div  style="background: #B0B3D6; height: 80px;">

        <span  style="float:right;margin:15px">
                    
          <div class="input-group mb-3">
              <input type="text" v-model="drugName" class="form-control" placeholder="Enter name" aria-label="Enter name" aria-describedby="addon-wrapping">
              <div class="input-group-append">
                  <button class="btn btn-info" style="background: #474A8A;color:white" type="button"  v-on:click = "searchName(drugName)" >Search</button>
                </div>
           </div>
      </span>
</div>



<!-- prikaz svih lijekova -->

<div v-if="showDrugs">
<div  align = "center" style="width:650px;margin-left:400px;margin-top:60px;"  v-for="d in this.drugs"  v-bind:key="d.idDrug">
                   <form align = "center">
                      <table align = "center" id="table2" class="table"  >

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{d.name}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Code:</td>   
       <td>{{d.code}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Recipe need:</td>   
       <td>{{d.recipeNeed}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Type drug:</td>   
       <td>{{d.drugType}}</td>
    
    </tr>
    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Fromat drug:</td>   
       <td>{{d.format}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Manufacturer:</td>   
       <td>{{d.manufacturer}}</td>
    
    </tr>

   </tbody>

                        </table>

<router-link :to="{ path: '/updateDrug/'+d.idDrug}" v-slot="{href, navigate}" custom>
           <b-link style="font-size: 30px;margin-left:50px;" :href="href" @click="navigate"  elevation="1">
<button class="btn btn-primary btn-lg"  style="margin-left:60px; margin-top:50px;background:#474A8A">Update drug</button>
            </b-link >
         </router-link>


<button class="btn btn-primary btn-lg" style="margin-left:60px; margin-top:42px;background:#474A8A">Delete drug</button>

                </form>
      </div>
</div>










<!-- pretraga lijeka!-->
<div v-if="showDrugsTable"  style="margin-left:0px;">
     <h4 style="margin:30px;color:black;">Search results:</h4>    
 <div style="background: #B0B3D6; width: 700px;margin-left:380px;"  v-for="dd in this.medications"  v-bind:key="dd.idDrug">
      
       <table align = "center" id="table2" class="table"  >

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{dd.name}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Code:</td>   
       <td>{{dd.code}}</td>
    
    </tr>   
    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Recipe need:</td>   
       <td>{{dd.recipeNeed}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Type drug:</td>   
       <td>{{dd.drugType}}</td>
    
    </tr>
    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Fromat drug:</td>   
       <td>{{dd.format}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Manufacturer:</td>   
       <td>{{dd.manufacturer}}</td>
    
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
       drugs : [],
       drugName: null,
      showDrugs: true,
      showDrugsTable:false,

       medications:{}

       
    }
  },
  mounted() {
        this.axios.get('/pharmacy/getDrugsPharmacy/'+this.id)
        .then(response => {
                this.drugs = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
        
        
        
    },
      methods:{

          searchName: function(drugName){
          this.drugName = drugName

          this.axios.get('/drugPricelist/searchDrugName/'+ this.id+"/"+this.drugName,{
      }).then(response => {
                this.showDrugs = false;
                this.showDrugsTable = true;
                this.medications= response.data;

       
          }).catch(res => {
                       alert("Please first choose allergy!");
                       console.log(res);
                 });
      }



      }
   
}

</script>

























