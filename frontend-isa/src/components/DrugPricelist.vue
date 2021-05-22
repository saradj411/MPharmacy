<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Drug price list:</label>




       




        <div style="background:#B0B3D6; width:650px;margin-left:38px;"  v-for="d in this.drug"  v-bind:key="d.idDrug">

                   <form>
                      <table style="" id="table2" class="table" >

                       <tbody>
<tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{d.drug.name}} </td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Price:</td>   
       <td>{{d.price}} RSD</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Price duration:</td>   
       <td>{{d.start | formatDate}}-{{d.end| formatDate}}</td>

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
       drug : {},
       drugs : {},

       
    }
  },
  mounted() {
        this.axios.get('/drugPricelist/getDrugsPharmacy/'+this.id)
        .then(response => {
                this.drug = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
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

























