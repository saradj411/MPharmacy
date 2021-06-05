<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Drug price list:</label>

        <div style=" width:650px;margin-left:38px;"  v-for="d in this.drugpricelist"  v-bind:key="d.idPricelist">

                   <form>
                      <table id="table2" class="table" style="background:#B0B3D6;" >

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

 <router-link :to="{ path: '/UpdatePricelist/'+d.idPricelist}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Update pricelist</button>
               </router-link>





                </form>
      
                    </div>



        
        </div>
        


</template>

<script>
export default {
  data() {
    return {
      
       id : this.$route.params.id,
       drugpricelist : {},
       pricelist:{}

       
    }
  },
  mounted() {
        this.axios.get('/drugPricelist/getDrugsPricelistByIdPharm/'+this.id)
        .then(response => {
                this.drugpricelist = response.data;
                 
       
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

























