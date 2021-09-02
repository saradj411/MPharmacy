<template>
<div>
    <h1> All complains </h1>
    <h4 v-if="this.complains.length === 0"> You dont answer to all complain. </h4>

    <div class="complain" v-for="c in this.complains"
        v-bind:key="c.idComplaint"> 
             
            <table style="margin-top:100px;"> 
             <tr  style="font-size:22px;" class="form-control">
              <td style="margine:20px; width:600px; font-size:22px;"> ID complain: </td>
              <td style="margine:20px; width:600px; font-size:22px;"> {{ c.idComplaint}}  </td>
            </tr >
            <tr  style="font-size:22px;" class="form-control">
              <td style="margine:20px; width:600px; font-size:22px;"> For: </td>
              <td style="margine:20px; width:600px; font-size:22px;" v-if="c.staff != null"> {{c.staff.name}} {{ c.staff.surname}}</td>
              <td style="margine:20px; width:600px; font-size:22px;" v-if="c.pharmacy != null"> {{c.pharmacy.name}}</td>
             
            </tr >
            <tr  style="font-size:22px;" class="form-control">
             <td style="margine:20px; width:600px; font-size:22px;"> Text: </td>
             <td style="margine:20px; width:600px; font-size:22px;"> {{c.text}} </td>
            </tr>
               <tr  style="font-size:22px;" class="form-control">
                <button class = "btn btn-primary btn-xs"                      
                            style="margin:auto;  background: #000; width: 200px;"
                            @click="showModalOffer(c)"  > Create an answer </button>
                    
               </tr>                
             </table>
             <br>
             
                 


    </div>

<!-- Answer oon complain modal  -->

  <b-modal ref="my-modal" hide-footer title="Enter your answer: " style="width:800px; height: 100%;">
        <div class="d-block text-center ">            
             <!--<div v-for="order in drug_order"
                    v-bind:key ="order.idOrder">
                    <h1 v-if="order.idOrder == prosledjena"> {{ order.idOrder }}: {{order.pharmacyName - order.pharmacyId}} </h1>
            </div>--> 

         
            <div>
                             <table> 
                             <tr  style="font-size:22px;" class="form-control">
                                <td style="margine:20px; width:600px; font-size:22px;" > Text: </td>
                                   <td style="margine:20px; width:600px; font-size:22px; height:30px;"> 
                                       
                                        <p><b>{{this.prosledjena.text}}</b></p>
                                    </td>  
                            </tr >

                            <tr  style="font-size:22px;" class="form-control">
                                <td style="margine:20px; width:600px; font-size:22px;" > Patient: </td>
                                   <td style="margine:20px; width:600px; font-size:22px; height:30px;"> 
                                       
                                        <p><b>{{this.patient.name}} {{this.patient.surname}}</b></p>
                                    </td>  
                            </tr >

                            <tr  style="font-size:22px;" class="form-control">
                                <td style="margine:20px; width:600px; font-size:22px;" > To who: </td>
                                   <td style="margine:20px; width:600px; font-size:22px; height:30px;"> 
                                       
                                        <p v-if="this.staff != null"><b>{{this.staff.name}} {{this.staff.surname}}</b></p>
                                        <p v-if="this.pharmacy != null"><b>{{this.pharmacy.name}}</b></p>
                                    </td>  
                            </tr >
                                <tr  style="font-size:22px; height: 170px;" class="form-control">
                                <td style="margine:20px; width:600px; font-size:22px;" > Answer: </td>
                                   <td style="margine:20px; width:600px; font-size:22px; height:30px;">                                        
                                       <b-form-textarea   id="textarea" v-model="textAnswer"
                                      placeholder="Enter yout complain..." style="font-size:22px;" rows="4" max-rows="10"></b-form-textarea>
                                    </td>  
                            </tr >
                                

                            </table>

                            
                    </div>

        </div>
        <button class="btn btn-primary btn-xs" style="margin:auto; margin-left:40px; background: #000; margin-top:10px; width:400px;"  @click="sendAnswer" > Send answer </button>
        <button class="btn btn-primary btn-xs" style="margin:auto; margin-left:40px;background: #000;  width:400px;"   @click="cancelModal"> Close </button>
        </b-modal>





</div>
</template>


<script>
export default {
  data() {
    return {
     
         id : this.$route.params.id,
         complains: [],
         staffComplains: [],
         prosledjena: {},
         patient: {},
         staff: {},
         textAnswer: "",
         pharmacy: {},
         token: localStorage.getItem('accessToken'),
         
        

    }
  },
  methods:
  { sendAnswer()
  {
      console.log(this.token);

        //console.log(accessToken.substr(1).slice(0, -1));

        alert("Please wait a few seconds..");
        this.$refs['my-modal'].toggle('#toggle-btn')
            this.axios.get('/complaint/saveAnswer/'+this.prosledjena.idComplaint+'/'+this.textAnswer,
                {
                    headers: 
                    {
                        'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                    }}).then(response => 
                    {
                        
                        alert("Successfully added answer! ");
                        console.log(response.data);                        
                         window.location.href = this.$router.go(-1);
                                 
                    }).catch(res => {
                        alert(res.response.data);
                         this.$router.go();
                    });
  },
      cancelModal() {       
           
            this.$refs['my-modal'].toggle('#toggle-btn')
        },
        showModalOffer(c)
            {  
                console.log("Udje");
                this.prosledjena = c;
                this.patient = c.patient;
                if(c.staff != null)
                {
                    this.staff = c.staff;
                    this.pharmacy = {};
                }
                else
                {
                    this.pharmacy = c.pharmacy;
                     this.staff = {};
                }
               
                
                console.log("LISTA OFFERSA: ");
                console.log(this.prosledjena);              
                this.$refs['my-modal'].show()
                
            }    
  },
  
  mounted() {
  ///patient/findDermatologistForGrade/{id}
  this.axios.get('/complaint/findAll/',{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {



                console.log("PRIAZ ZLABI");
                  this.complains = response.data;
                  console.log(this.complains);

            }).catch(res => {
                          //alert("Token expired!");
                          //window.location.href = '/login';
                        console.log(res.response.data.message);
                    }); 
  this.axios.get('/complaint/findAllStaffComplaint/',{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.staffComplains = response.data;
                  console.log("STAFF");
                  console.log(this.staffComplains);

            }).catch(res => {
                          //alert("Token expired!");
                          //window.location.href = '/login';
                        console.log(res.response.data.message);
                    }); 

               
            }
}
</script>

<style>
.complain
{
    background-color: white;
    width: 500px;
    height: 100px;
}
.d-block
{
    height: 310px;
}

</style>
