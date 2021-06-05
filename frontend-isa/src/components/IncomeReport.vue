<template>
   <div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Income report for the first three months</label>
    
      
   <chartjs-line :labels="labels" :data="[months.jan,months.feb,months.mart]" :bind="true"></chartjs-line>  
      </div>

</template>

<script>


export default {
  name: 'VueCharts',
    data () {
      return {
        id : this.$route.params.id,
        months:{},
        labels: ['January', 'February', 'March'],
          
      }
    },

    mounted() {
    this.axios.get('/reports/incomeReport/'+this.id)
        .then(response => {
                this.months = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
     }
 
};
</script>

<style>

</style>


  