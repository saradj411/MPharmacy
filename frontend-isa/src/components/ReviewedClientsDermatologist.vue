<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Reviewed clients:</label>





<!--Lista -->
<div>

        <div  style="width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.pacijent"  v-bind:key="d.idUser">
                   <form>
                      <table style="background:#B0B3D6; " id="table2" class="table" > 

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{d.name}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Surname:</td>   
       <td>{{d.surname}}</td>
    </tr>

    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Date:</td>   
       <td>{{d.date | formatDate}}</td>

    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Start time:</td>   
       <td>{{d.start}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >End time:</td>   
       <td>{{d.end}}</td>
    </tr>
 
  </tbody>
                        </table>

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
      name : "",
      surname:"",
      date :null,
      start: null,
      end : null,
      pacijent:{}
       
    }
  },
  mounted() {
        this.axios.get('/dermatologist/findClientsDermatologist/'+this.id)
        .then(response => {
                this.pacijent = response.data;  
                 
       
         }).catch(res => {
                console.log(res);
        });   
                             console.log("oooo"+this.id);

    },
      methods:{



       
    
      
      }
   
}

</script>

























