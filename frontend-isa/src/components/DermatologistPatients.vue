<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">List of dermatologist patients:</label>



<div  style="background: #B0B3D6; height: 80px;">



</div>






<!--Lista pacijanata-->

        <div  style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.patients"  v-bind:key="d.idUser">
                   <form>
                      <table style="" id="table2" class="table" > 

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{d.firstname}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Surname:</td>   
       <td>{{d.surname}}</td>
    </tr>    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Phone number:</td>   
       <td>{{d.phonenumber}}</td>
    </tr>    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Email:</td>   
       <td>{{d.email}}</td>
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
       patients:{}
       
    }
  },
  mounted() {
        this.axios.get('/dermatologist/findAllPatient/'+this.id)
        .then(response => {
                this.patients = response.data;
                 
       
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

























