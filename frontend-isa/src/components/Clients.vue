<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
        
                     <label style="color:#474A8A;font-size:35px;" align = "center">Users:</label>



<div  style="background: #B0B3D6; height: 80px;">


<span  style="float:right;margin:15px">
            <div class="input-group mb-3">
              <input type="text" v-model="userName" class="form-control" placeholder="Enter name " >
              <input type="text" v-model="userSurname" class="form-control" placeholder="Enter surname">

                 <div class="input-group-append">
                    <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "searchByName" >Search</button>
                  </div>
            </div>
          </span>

</div>



<!-- pretraga !-->
<div v-if="showUsersTable"  style="margin-left:0px;">
     <h4 style="margin:30px;color:black;">Search results:</h4>    
 <div style="background: #B0B3D6; width: 700px;margin-left:380px;" v-for="d in this.user"  v-bind:key="d.idUser">
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

   
 
   </tbody>

                        </table>

           </div>

      </div>   








<!--Lista -->
<div v-if="showUsers">

        <div  style="width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.pacijent"  v-bind:key="d.idUser">
                   <form>
                      <table style="background:#B0B3D6; " id="table2" class="table" > 

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{d.firstname    }}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Surname:</td>   
       <td>{{d.surname}}</td>
    </tr>

    <tr style="font-size:22px;color:#0D184F;">
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






</div>

</template>

<script>
export default {
  data() {
    return {
      id : this.$route.params.id,
      pacijent : {},
      showNew: false,
      showUsers: true,
      showUsersTable:false,
      jel:false,
      name : "",
      userName:"",
      userSurname:"",
      user:[],
      idPatient:"",
      jedanPacijent:{},
      pharmacy:"",
      apoteka:{},
      date :null,
      start: null,
      end : null
       
    }
  },
  mounted() {
        this.axios.get('/patient/findAll/')
        .then(response => {
                this.pacijent = response.data;  
                 
       
         }).catch(res => {
                console.log(res);
        });   
                             console.log("oooo"+this.id);

    },
      methods:{
            
           
      searchByName: function(){
        
         const data = {
            name : this.userName,
            surame : this.userSurname
            
          }

          this.axios.post('/patient/searchUser/',data,{
      }).then(response => {
                this.showUsers = false;
                this.showUsersTable = true;
                this.user= response.data;
                
       
          }).catch(res => {
                       alert("necee!");
                       console.log(res);
                 });
      },




       
    
      
      }
   
}

</script>

























