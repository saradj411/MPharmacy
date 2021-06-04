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
<button class="btn btn-primary btn-lg"  style="margin-left:-30px; margin-top:50px;background:#474A8A" v-on:click ="startEx(d.id)">Start examination</button>

                </form>
      
      
        </div>
        </div>


<!--PREGLED-->

 <div v-if="showNew" style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;">
                                      <label style="font-size:30px;color:#0D184F;margine-left:20px;">Schedule new examination</label >

                    <div >
                        <div>
                        <label style="font-size:22px;color:#0D184F;">Date:</label>
                        <input type="date" class="form-control" v-model="date" placeholder="Enter description">
                        </div>
                    </div>
                    <div >
                        <div >
                        <label style="font-size:22px;color:#0D184F;">Start time:</label>
                        <input type="time" class="form-control" v-model = "start" placeholder="Enter start date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">End time:</label>
                            <input type="time" class="form-control"  v-model="end" placeholder="Enter end date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">Pharmacy:</label>
                            <input type="text" class="form-control"  v-model="pharmacy" placeholder="Enter pharmacy">
                        </div>
                    </div>
                     <button class="btn btn-primary btn-lg" v-on:click ="shedule" style="margin-left:10px; margin-top:50px;background:#474A8A">Shedule</button>

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
                                   console.log("id pacijenta "+this.jedanPacijent.id);

        this.axios.get('/patient/findAll/')
        .then(response => {
                this.pacijent = response.data;  
                 
       
         }).catch(res => {
                console.log(res);
        });   
                             console.log("oooo"+this.id);

    },
      methods:{
            startEx : function(data){
               console.log(data);
                     this.showNew = true;
                     this.showUsers = false;
                     this.axios.get('/patient/findOneById/'+data)
                           .then(response => {
                              this.jedanPacijent = response.data;

                                    
                                    
                              }).catch(res => {
                                    console.log(res);
                           });
            },


            shedule : function(){
                    console.log("ime je "+this.pharmacy)
                     this.axios.get('/pharmacy/findOneByName/'+this.pharmacy)
                           .then(response => {
                    console.log("ime je "+this.pharmacy)

                                    this.apoteka = response.data;
                                                            
                              }).catch(res => {
                                    console.log(res);
                           });   
                           console.log("datum je "+this.date)
                     const infoExamination = {
                              idPatient: this.jedanPacijent.id,
                              idStaff: this.id,
                              name : this.pharmacy,
                              date : this.date,
                              start : this.start,
                              end : this.end,
                           }

                        this.axios.post('/examination/createDermatologist',infoExamination,{ 
                        headers: {
                        }}).then(response => {
                                 alert("Examination is successfully created!");
                                    console.log(response.data);
                        
                           })
                           .catch(response => {
                              alert(response.response.data.message);
                                    console.log(response);
                           });    
                  },

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

























