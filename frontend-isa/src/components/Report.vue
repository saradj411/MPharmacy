<template>

<div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
            <h3 style="color: #0D184F ;font-size:33px;">Display of business reports  </h3>
<div style="background: #B0B3D6; height: 80px;">


        </div>
       

         <div  style="width:650px;margin-left:38px;margin-top:60px;"  >
                   <form>
                      <table style="background:#B0B3D6; " id="table2" class="table" > 

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Average pharmacy:</td>   
       <td>{{average}}</td>
    
    </tr>
    
  </tbody>
                        </table>

                </form>
      
      
        </div>
               
        
 <div  style="width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.dermatolozi"  v-bind:key="d.id">
                <form>
                      <table style="background:#B0B3D6; " id="table2" class="table" > 
                       <tbody>
                            <tr style="font-size:22px;color:#0D184F;">
                            <th></th>
                            <td >Dermatologist name:</td>   
                            <td>{{d.name    }}</td>
                            </tr>
                            <tr style="font-size:22px;color:#0D184F;">
                            <th></th>
                            <td >Dermatologist surname:</td>   
                            <td>{{d.surname}}</td>
                            </tr>
                            <tr style="font-size:22px;color:#0D184F;">
                            <th></th>
                            <td >Average:</td>   
                            <td>{{d.avgGrade}}</td>
                            </tr>
                        </tbody>
                   </table>
              </form>
        </div>
 

      <div  style="width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.farmaceuti"  v-bind:key="d.id">
                <form>
                      <table style="background:#B0B3D6; " id="table2" class="table" > 
                       <tbody>
                            <tr style="font-size:22px;color:#0D184F;">
                            <th></th>
                            <td >Pharmasist name:</td>   
                            <td>{{d.name    }}</td>
                            </tr>
                            <tr style="font-size:22px;color:#0D184F;">
                            <th></th>
                            <td >Pharmasist surname:</td>   
                            <td>{{d.surname}}</td>
                            </tr>
                            <tr style="font-size:22px;color:#0D184F;">
                            <th></th>
                            <td >Average:</td>   
                            <td>{{d.avgGrade}}</td>
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
      average:null,
      farmaceuti:{},
      dermatolozi:{}

    }
  },
  mounted() {
         this.axios.get('/pharmacist/getAvgGrade/'+this.id)
        .then(response => {
                this.average = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
        this.axios.get('/pharmacist/view/'+this.id)
        .then(response => {
                this.farmaceuti = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });

        this.axios.get('/pharmacist/viewDerm/'+this.id)
        .then(response => {
                this.dermatolozi = response.data;
                 
       
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