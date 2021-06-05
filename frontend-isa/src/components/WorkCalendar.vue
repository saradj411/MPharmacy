<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Work calendar</label>




<div>
<div  align = "center" style="width:650px;margin-left:400px;margin-top:60px;"  v-for="d in this.examination"  v-bind:key="d.idDrug">
                   <form align = "center">
                      <table align = "left" id="table2" class="table"  >
                          <h1 style="font-size:22px;color:#0D184F;">Examination:</h1>
                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Datum:</td>   
       <td>{{d.date}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Start time:</td>   
       <td>{{d.startTime}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >End time:</td>   
       <td>{{d.endTime}}</td>
    
    </tr>

    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Price:</td>   
       <td>{{d.price}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Pharmacy:</td>   
       <td>{{d.pharmacyName}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Patient name:</td>   
       <td>{{d.name}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Patient surname:</td>   
       <td>{{d.surname}}</td>
    
    </tr>

   </tbody>

                        </table>
                        <router-link :to="{ path: '/StartExamination/'+d.id}" v-slot="{href, navigate}" custom>
           <b-link style="font-size: 30px;margin-left:50px;" :href="href" @click="navigate"  elevation="1">
<button class="btn btn-primary btn-lg"  style="margin-left:110px; margin-top:50px;background:#474A8A">Start examination</button>
            </b-link >
         </router-link>


<button class="btn btn-primary btn-lg" v-on:click = "notAppear(d.id)" style="margin-left:60px; margin-top:42px;background:#474A8A">Patient did not come</button>

                </form>
      </div>
</div>




</div>

</template>

<script>
export default {
  data() {
    return {
      
       id : this.$route.params.id,
       examination : {},

       
    }
  },
  mounted() {
        this.axios.get('/dermatologist/getFreeEx/'+this.id)
        .then(response => {
                this.examination = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
        
        
        
    },
      methods:{
         
         notAppear : function(data){
            console.log("ispisi"+data);
            this.axios.get('dermatologist/updateFreeEx/'+data)
        .then(response => {
                this.nesto = response.data;
                alert(response.data);
        
         }).catch(res => {
                console.log(res);
                alert("nee");
        });

      },


      }
   
}

</script>

























