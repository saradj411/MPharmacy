<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Issuing a reserved medicine</label>

        
<div  style="background: #B0B3D6; height: 80px;">


<span  style="float:right;margin:15px">
            <div class="input-group mb-3">
              <input type="text" v-model="drugName" class="form-control" placeholder="Enter name drug" >

                 <div class="input-group-append">
                    <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "searchByName" >Search reservation</button>
                  </div>
            </div>
          </span>

</div>
<div v-if="showFirst">
        <div  style="background:#B0B3D6; width:500px;margin-left:38px;margin-top:60px;">
                    
                    
                    <div >
                        <div>
                        <label style="font-size:22px;color:#0D184F;">Enter a unique number reservations:</label>
                        <input type="number" class="form-control" v-model="idRez" placeholder="Enter id">
                        </div>
                    </div>
 
            </div>
       <button class="btn btn-primary btn-lg" style="margin-left:-920px; margin-top:50px;background:#474A8A" v-on:click="idemo" >Confirm</button>
</div>


<div v-if="showUsersTable"  style="margin-left:0px;">
     <h4 style="margin:30px;color:black;">Search results:</h4>    
 <div style="background: #B0B3D6; width: 700px;margin-left:380px;" v-for="d in this.rezultat"  v-bind:key="d.id">
       <table align = "center" id="table2" class="table"  >
                       <tbody>
      
      <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name drug:</td>   
       <td>{{d.drugName}}</td>
    
    </tr>
   <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name patient:</td>   
       <td>{{d.patientName}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Surname patient:</td>   
       <td>{{d.patientSurname}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Quantity of drug:</td>   
       <td>{{d.quantity}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Date Of Reservation:</td>   
       <td>{{d.dateOfReservation | formatDate}}</td>
    </tr>

   
 
   </tbody>

                        </table>

           </div>

      </div>   



    
    </div>
</template>

<script>
export default {
  data() {
    return {
      
      nesto:{},
      idRez:"",
      drugName:"",
      showUsersTable:false,
      showFirst:true,
      rezultat:{},
      id : this.$route.params.id,

     

      
    }
  },

    methods:{
      idemo : function(){

              this.axios.get('/reservation/res/'+this.idRez)
            .then(response => {
                    this.pharmacies1 = response.data;
                    alert("Patient successfully took the drug.");
                    
            }).catch(res => {
                    alert("The booking number is incorrects");
                    console.log(res);
            });

      },

      searchByName : function(){

            this.showUsersTable=true;
            this.showFirst=false;
              this.axios.get('/reservation/res2/'+this.id+'/'+this.drugName)
            .then(response => {
                    this.rezultat = response.data;
                    
            }).catch(res => {
                    console.log(res);
            });

      },

      
    
     
},
 mounted() {  
        
        

      
    }
}
</script>  