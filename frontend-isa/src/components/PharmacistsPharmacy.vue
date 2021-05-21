<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Our pharmacists:</label>

        <div style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.farmaceut"  v-bind:key="d.idUser">
                   <form>
                      <table style="" id="table2" class="table" > 

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{d.name}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th ></th>
      <td>Address:</td>
      <td>{{d.address}}</td>

    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Surname:</td>   
       <td>{{d.surname}}</td>
    </tr>

    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Phone number:</td>   
       <td>{{d.phoneNumber}}</td>

    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Email:</td>   
       <td>{{d.email}}</td>
    </tr>
 <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Adredd:</td>   
       <td>{{d.address}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >City:</td>   
       <td>{{d.city}}</td>
    </tr >
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Country:</td>   
       <td>{{d.country}}</td>
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
       farmaceut : {},
       welcomePageShow : true

       
    }
  },
  mounted() {
        this.axios.get('/pharmacist/getPharmacist/'+this.id)
        .then(response => {
                this.farmaceut = response.data;
                 
       
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

























