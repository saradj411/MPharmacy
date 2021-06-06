<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Define action and promotion:</label>

        
        <div style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;">
                    
                    
                   <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">Text:</label>
                            <input type="text" class="form-control"  v-model="text" placeholder="Enter text">
                        </div>
                    </div>

                    <div >
                        <div >
                        <label style="font-size:22px;color:#0D184F;">Start date:</label>
                        <input type="date" class="form-control" v-model = "startDate" placeholder="Enter start date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">End date:</label>
                            <input type="date" class="form-control"  v-model="endDate" placeholder="Enter end date">
                        </div>
                    </div>
                    
            </div>
  
                           <button class="btn btn-primary btn-lg" v-on:click ="createAction" style="margin-left:-800px; margin-top:50px;background:#474A8A">Confirm</button>

    
    </div>
</template>

<script>
export default {
  data() {
    return {
      
      startDate: null,
      endDate : null,
      id : this.$route.params.id,
      pharmacies:{},
      price:null,
      text:"",
      pharmacy:{}
     

      
    }
  },

    methods:{
      
        createAction : function() {

            const info = {
                    text:this.text,
                    startDate : this.startDate,
                    endDate  :this.endDate,
                    idPham:this.pharmacy.idPharm
        }
            console.log("ee"+this.text);
            console.log("ee"+this.startDate);
            console.log("ee"+this.endDate);
                        console.log("ee"+this.pharmacy.idPharm);


        this.axios.post('/actionAndPromotion/create',info,{ 
                        })
                .then(response => {
                       alert("Action and promotion created!");
                        console.log(response.data);
                })
                .catch(response => {
                       alert("it is not possible to define an action and promotion!");
                        console.log(response);
                 }); 
         
      },
    
     
    },
    mounted() {

        this.axios.get('/adminstrator/findPharm/'+this.id)
        .then(response => {
                this.pharmacy = response.data;
                console.log(this.pharmacy.idPharm);
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });

    }
}
</script>  