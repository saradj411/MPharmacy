<template>

<div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
            <h3 style="color: #0D184F ;font-size:33px;font-weight:bold;">Welcome to the profile of the {{pharmacy.name}} pharmacy </h3>
        
<div style="width:650px;margin-left:400px;margin-top:150px;">
<form>
     <table style="" id="table2" class="table" >
           <tbody>
             <div style=" margin: auto; width: 50%;"> </div>
    <tr style="font-size:22px;color:#0D184F;">
      <th ></th>
      <td></td>
      <td></td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th ></th>
      <td>Pharmacy description:</td>
      <td>{{pharmacy.description}} </td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th ></th>
      <td>Pharmacy average:</td>
      <td>{{pharmacy.avgGrade}}</td>


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
       pharmacy : [],
       welcomePageShow : true

       
    }
  },
  mounted() {
        this.axios.get('/pharmacy/findById/'+this.id)
        .then(response => {
                this.pharmacy = response.data;
                 
       
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