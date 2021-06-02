<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Our dermatologists:</label>



<div  style="background: #B0B3D6; height: 80px;">


<span  style="float:right;margin:15px">
            <div class="input-group mb-3">
              <input type="text" v-model="dermatologistName" class="form-control" placeholder="Enter name " >
              <input type="text" v-model="dermatologistSurname" class="form-control" placeholder="Enter surname">

                 <div class="input-group-append">
                    <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "searchByName" >Search</button>
                  </div>
            </div>
          </span>

</div>







<!-- pretraga dermtologa!-->
<div v-if="showDermatologistsTable"  style="margin-left:0px;">
     <h4 style="margin:30px;color:black;">Search results:</h4>    
     <div style="background: #B0B3D6; width: 700px;margin-left:380px;" v-for="d in this.f=dermatologists"  v-bind:key="d.id">

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


   </tbody>

                        </table>
</div>
     
      </div>   







<!--prikaz dermatologa-->
<div v-if="showDermatologists">

    <div style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.dermatolog"  v-bind:key="d.id">
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

                        <button class="btn btn-primary btn-lg" v-on:click = "canceling(d.id)" style="margin-left:30px; margin-top:42px;background:#474A8A">Delete dermatolog</button>

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
       dermatolog : {},
       jeste:"",
         name : "",
     dermatologistName:"",
     dermatologistSurname:"",
     dermatologists:"",
     showDermatologists : true,
     showDermatologistsTable : false

       
    }
  },
  mounted() {
        this.axios.get('/dermatologist/getDermatologists/'+this.id)
        .then(response => {
                this.dermatolog = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
       
    }
     ,
      methods:{

      searchByName: function(){
        
         const data = {
            name : this.dermatologistName,
            surame : this.dermatologistSurname
            
          }

          this.axios.post('/dermatologist/searchDermatologistName/'+this.id,data,{
      }).then(response => {
                this.showDermatologists = false;
                this.showDermatologistsTable = true;
                this.dermatologists= response.data;
                
       
          }).catch(res => {
                       alert("necee!");
                       console.log(res);
                 });
      },


      canceling:
       function(date){
       this.axios.get('/dermatologist/delete/'+date)
        .then(response => {
                this.jeste = response.data;
                if(this.jeste=="Dermatoloist is not deleted!"){
                                      alert("Dermatoloist is not deleted!") 

                }
                if(this.jeste=="Dermatoloist is deleted!"){
                                      alert("Dermatoloist is deleted!") 

                }
                

         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });


       }
    
      
      }
   
}

</script>

























