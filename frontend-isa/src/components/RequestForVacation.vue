<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Request for vacation:</label>

        
        <div style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;">
                    
                    <div >
                        
                        <div >
                        <label style="font-size:22px;color:#0D184F;">Choose the pharmacy for which you want to request a vacation:</label>
                         <div style="color:#0D184F;">
                       
                            <b-dropdown id="ddCommodity" style="font-size:22px;height:45px;margin-top:5px;width:200px;background:#474A8A;color:white;"  name="ddCommodity" text="Choose pharmacy "  >
                                <b-dropdown-item  v-for="item in this.pharmacies" v-on:click ="typeIsSelected1($event, item.name)" v-bind:key="item.name"> {{item.name }}</b-dropdown-item>
                            </b-dropdown> 
                          </div>
                        </div>

                      <div>

                                                  <span style="font-size:22px;color:#474A8A;">{{choosen}}</span>

                      </div>
                   </div>

                  

                    
 


                    <div >
                        <div >
                        <label style="font-size:22px;color:#0D184F;">Start date:</label>
                        <input type="date" class="form-control" v-model = "start" placeholder="Enter start date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">End date:</label>
                            <input type="date" class="form-control"  v-model="end" placeholder="Enter end date">
                        </div>
                    </div>


                    
                    
                  
                  
            </div>
  
                           <button class="btn btn-primary btn-lg" v-on:click ="requestForvacation" style="margin-left:-800px; margin-top:50px;background:#474A8A">Sent request</button>

    
    </div>
</template>

<script>
export default {
  data() {
    return {
      
      description : "",
      start: null,
      end : null,
      id : this.$route.params.id,
      pharmacies:{},
      choosen:""

      
    }
  },

    methods:{
typeIsSelected1 : function(event, type) { 
           this.choosen = type;
      },
        requestForvacation : function() {
            const vacation = {
            idStaff:this.id,
            start : this.start,
            end  :this.end,
            name:this.choosen
        }
        console.log(this.start);
           this.axios.post('/requestVacation/create',vacation,{ 
                        })
                .then(response => {
                       alert("Request is successfully created!");
                        console.log(response.data);
                })
                .catch(response => {
                       alert("It is not possible to create a request");
                        console.log(response);
                 }); 
         
      },
    
     
},
 mounted() {
   this.axios.get('/dermatologist/findPharmacyDermatologist/'+this.id)
        .then(response => {
                this.pharmacies = response.data;  

         }).catch(res => {
                console.log(res);
        });   
    }
}
</script>  