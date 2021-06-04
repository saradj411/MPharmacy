<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Issuing a reserved medicine</label>

        
        <div style="background:#B0B3D6; width:500px;margin-left:38px;margin-top:60px;">
                    
                    
                    <div >
                        <div>
                        <label style="font-size:22px;color:#0D184F;">Enter a unique number reservations:</label>
                        <input type="text" class="form-control" v-model="description" placeholder="Enter description">
                        </div>
                    </div>



                    
                    
                  
                  
            </div>
  
                           <button class="btn btn-primary btn-lg" style="margin-left:-920px; margin-top:50px;background:#474A8A">Confirm</button>

    
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
     

      
    }
  },

    methods:{
      
    
     
},
 mounted() {
      
    }
}
</script>  