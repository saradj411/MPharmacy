<template>
   <div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Month review of drug</label>
    
   <chartjs-line :labels="labels" :data="[months.day1,months.day2,months.day3,months.day4,months.day5,months.day6,months.day7,months.day8,months.day9,months.day10,months.day11,months.day12,months.day13,months.day14,months.day15,months.day16,months.day17,months.day18,months.day19,months.day20,months.day21,months.day22,months.day23,months.day24,months.day25,months.day26,months.day27,months.day28,months.day29,months.day30,months.day31]" :bind="true"></chartjs-line>  
        </div>
     

</template>

<script>




export default {
  name: 'VueCharts',
    data () {
      return {
        id : this.$route.params.id,
        months:{},
        labels: ['1', '2', '3', '4', '5', '6', '7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31'],
          
      }
    },

    mounted() {
    this.axios.get('/reports/monthlyReportDrugs/'+this.id)
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


  