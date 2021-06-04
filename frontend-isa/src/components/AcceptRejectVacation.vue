<template>

  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
        
    
    <label style="color:#474A8A;font-size:35px;" align = "center">Vacation requirements from a dermatologist/pharmacist </label>



<div v-if="showReason" style="width:500px;margin-left:38px;margin-top:60px;">
                    <div style="background:#B0B3D6;">
                        <div>
                        <label style="font-size:22px;color:#0D184F;">Reason of refusing:</label>
                        <input type="text" class="form-control" style="width:500px;height:60px; " v-model="reason" placeholder="Enter reason">
                        </div>
                    </div>
                    <button class="btn btn-primary btn-lg" v-on:click ="sentReason"  style="margin-left:10px; margin-top:50px;background:#474A8A">Sent</button>
</div>






<!--Lista -->
<div v-if="showRequests">

        <div  style="width:650px;margin-left:38px;margin-top:60px;"  v-for="d in this.requests"  v-bind:key="d.id">
                   <form>
                      <table style="background:#B0B3D6; " id="table2" class="table" > 

                       <tbody>
      
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Name:</td>   
       <td>{{d.nameStaff}}</td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Surname:</td>   
       <td>{{d.surnameStaff}}</td>
    </tr>

    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Pharmacy:</td>   
       <td>{{d.pharmacyName}}</td>

    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Start:</td>   
       <td>{{d.start}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >End:</td>   
       <td>{{d.end}}</td>
    </tr>
 
  </tbody>
                        </table>
                        
<button class="btn btn-primary btn-l" v-on:click = "accept(d.id)" style="font-size: 25px;margin-left:0px;">Accept</button>


<button class="btn btn-primary btn-l"  v-on:click = "refuse(d.id)" style="font-size: 25px;margin-left:100px;">Refuse </button>





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
      requests : {},
      showRequests: true,
      showReason: false,
      reason:"",
      start: null,
      end : null,
      idRequest:null,
      prihvacenJe:"prihvacen",
      zahtjev:{}
       
    }
  },
  mounted() {
        this.axios.get('/requestVacation/findAll/'+this.id)
        .then(response => {
                this.requests = response.data;  
       
         }).catch(res => {
                console.log(res);
        });   

    },
     methods:{
        
          refuse : function(data){
              //this.idRequest=data;
              console.log("ajde"+data);
              this.idRequest=this.data;
              
              this.showReason = true;
              this.showRequests=false;
               this.axios.get('/requestVacation/getRequestById/'+data)
                    .then(response => {
                            this.zahtjev = response.data;
                    }).catch(res => {
                            console.log(res);
                    });
           },

            sentReason : function(){

                this.axios.get('/requestVacation/acceptOrRefuseRequest/'+this.zahtjev.id+'/'+this.reason)
                    .then(response => {
                            alert("The holiday request was denied!");                            
                                                        this.nesto = response.data;

                    }).catch(res => {
                            console.log(res);
                    });
           },
        accept: function(data){
                this.axios.get('/requestVacation/acceptRequest/'+data)
                    .then(response => {
                            alert("The holiday request was accepted!");                  
                            this.nesto = response.data;
                                      
                            
                    }).catch(res => {
                            console.log(res);
                    });
           }
    
      
      }
   
}

</script>

























