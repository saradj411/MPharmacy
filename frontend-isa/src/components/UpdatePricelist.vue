<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Create pricelist:</label>

        
        <div style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;">
                    
                    
                   <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">Drug:</label>
                            <input type="text" class="form-control"  v-model="cjenovnik.drug.name" placeholder="Enter drug">
                        </div>
                    </div>

                    <div >
                        <div >
                        <label style="font-size:22px;color:#0D184F;">Start date:</label>
                        <input type="date" class="form-control" v-model = "cjenovnik.start" placeholder="Enter start date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">End date:</label>
                            <input type="date" class="form-control"  v-model="cjenovnik.end" placeholder="Enter end date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">Price:</label>
                            <input type="number" class="form-control"  v-model="cjenovnik.price" placeholder="Enter price">
                        </div>
                    </div>
            </div>
  
                           <button class="btn btn-primary btn-lg" v-on:click ="updatePricelist" style="margin-left:-800px; margin-top:50px;background:#474A8A">Sent request</button>

    
    </div>
</template>

<script>
export default {
  data() {
    return {
      
      start: null,
      end : null,
      id : this.$route.params.id,
      pharmacies:{},
      price:null,
      name:"",
      cjenovnik:{}
     

      
    }
  },

    methods:{
      
      updatePricelist : function() {
            const info = {
                    name:this.name,
                    start : this.start,
                    end  :this.end,
                    price:this.price
        }

        this.axios.post('/drugPricelist/update/'+this.id,info,{ 
                        })
                .then(response => {
                       alert("Pricelist updated!");
                        console.log(response.data);
                })
                .catch(response => {
                       alert("Updating is not possible!");
                        console.log(response);
                 }); 
         
      },
        
     
    },
    mounted() {
        this.axios.get('/drugPricelist/findById/'+this.id)
        .then(response => {
                this.cjenovnik = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
       

    }
}
</script>  