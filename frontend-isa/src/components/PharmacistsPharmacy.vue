<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Our pharmacists:</label>



<div  style="background: #B0B3D6; height: 80px;">


<span  style="float:right;margin:15px">
            <div class="input-group mb-3">
              <input type="text" v-model="pharmacistName" class="form-control" placeholder="Enter name " >
              <input type="text" v-model="phrmacistSurname" class="form-control" placeholder="Enter surname">

                 <div class="input-group-append">
                    <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "searchByName" >Search</button>
                  </div>
            </div>
          </span>

</div>



<!-- pretraga farmaceuta!-->
<div v-if="showPharmacistsTable"  style="margin-left:0px;">
     <h4 style="margin:30px;color:black;">Search results:</h4>    
 <div style="background: #B0B3D6; width: 700px;margin-left:380px;" v-for="d in this.pharmacists"  v-bind:key="d.idUser">
       <table align = "center" id="table2" class="table"  >

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
      <td >Average grade:</td>   
       <td>{{d.avgGrade}}</td>
    </tr>
    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Pharmacy:</td>   
       <td>{{d.pharmacy.name}}</td>
    </tr>
   </tbody>

                        </table>

           </div>

      </div>   








<!--Lista farmamceuta-->
<div v-if="showPharmacists">

        <div  style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.farmaceut"  v-bind:key="d.idUser">
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
      <td >Adress:</td>   
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
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Average grade:</td>   
       <td>{{d.avgGrade}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Pharmacy:</td>   
       <td>{{d.pharmacy.name}}</td>
    </tr>
  </tbody>
                        </table>
                                                <button class="btn btn-primary btn-lg" v-on:click = "canceling(d.idUser)" style="margin-left:30px; margin-top:42px;background:#474A8A">Delete pharmacist</button>

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
       farmaceut : {},
       showPharmacists: true,
       showPharmacistsTable:false,
      jel:false,
       name : "",
     pharmacistName:"",
     phrmacistSurname:"",
       pharmacists:[]
       
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


      searchByName: function(){
        
         const data = {
            name : this.pharmacistName,
            surame : this.phrmacistSurname
            
          }

          this.axios.post('/pharmacist/searchPharmacistName/'+this.id,data,{
      }).then(response => {
                this.showPharmacists = false;
                this.showPharmacistsTable = true;
                this.pharmacists= response.data;
                
       
          }).catch(res => {
                       alert("necee!");
                       console.log(res);
                 });
      },




        canceling:
       function(date){
       this.axios.get('/pharmacist/delete/'+ date)
        .then(response => {
                this.jeste = response.data;
                if(this.jeste=="Pharmacist is not  deleted"){
                                      alert("Pharmacist is not  deleted") 

                }
                if(this.jeste=="Pharmacist is successfully deleted"){
                                      alert("Pharmacist is successfully deleted") 

                }
                

         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });


       }
    
      
      }
   
}

</script>

























