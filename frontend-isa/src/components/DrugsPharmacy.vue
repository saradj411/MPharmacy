<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Pharmacy drugs 
:</label>

        <div align = "center" style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.drugs"  v-bind:key="d.idDrug">
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
                </form>
      
      
        
        </div>
</div>

</template>

<script>
export default {
  data() {
    return {
      
       id : this.$route.params.id,
       drugs : {}

       
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
       
    }
     ,
      methods:{
    
      
      }
   
}

</script>

























