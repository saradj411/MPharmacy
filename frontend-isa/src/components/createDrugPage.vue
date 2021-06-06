<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Add drug</label>

        
        <div style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;">
                    
                    <div >
                        <div>
                        <label style="font-size:22px;color:#0D184F;">Name:</label>
                        <input type="text" class="form-control" v-model="name" placeholder="Enter name">
                        </div>
                    </div>
                    <div >
                        <div >
                        <label style="font-size:22px;color:#0D184F;">Code:</label>
                        <input type="text" class="form-control" v-model = "password" placeholder="Enter code">
                        </div>
                    </div>
                    

<div >
                        <div >
                            <label style="font-size:22px;color:#0D184F;">Quantity:</label>
                            <input type="number" class="form-control" v-model="quantity" placeholder="Enter quantity">
                        </div>
                    </div>


                    <div >
                        <div >
                            <label style="font-size:22px;color:#0D184F;">Manufacturer:</label>
                            <input type="text" class="form-control" v-model="manufacturer" placeholder="Enter manufacturer">
                        </div>
                    </div>
                    
                  
                   <div >

                        <div style="color:#0D184F;">
                       
                            <b-dropdown id="ddCommodity"  name="ddCommodity" text="Choose drug type"  >
                                <b-dropdown-item  v-for="item in this.types" v-on:click ="typeIsSelected($event, item.drugType)" v-bind:key="item.drugType"> {{item.drugType }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                         <div >
                            <span >{{choosenType}}</span>
                        </div>
                    </div>

                    <div >

                        <div style="color:#0D184F;">
                       
                            <b-dropdown id="ddCommodity" name="ddCommodity" text="Choose drug format"  >
                                <b-dropdown-item v-for="item in this.formats"  v-on:click ="typeIsSelected1($event, item.format)" v-bind:key="item.format"> {{item.format }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                         <div >
                            <span >{{choosenFormat}}</span>
                        </div>
                    </div>
                  
            </div>
  
                           <button class="btn btn-primary btn-lg" v-on:click ="addDrug" style="margin-left:-800px; margin-top:50px;background:#474A8A">Add drug</button>

    
    </div>
</template>

<script>
export default {
  data() {
    return {
      types: [
          { drugType: 'BLOOD' },
          { drugType: 'HUMAN' },
          { drugType: 'BIOLOGICAL' },
          { drugType: 'HERBAL' },
          { drugType: 'HOMEOPATIC' },
          { drugType: 'TRADICIONAL' },
      ],
      formats: [
          { format: 'CAPSULE' },
          { format: 'LIQUID' },
          { format: 'INJECTION' },
          { format: 'VACCINE' },
          { format: 'CREME' },
          { format: 'GEL' },
          { format: 'TABLET' },

      ],
      name : "",
      password : "",
      manufacturer :"",
      nesto:"",
      choosenType : ""  ,
      choosenFormat : ""  ,
      quantity:"",
      id : this.$route.params.id,
      pharmacy:{},
      idPharm:""

    }
  },

    methods:{
    
      addDrug : function() {
          const medicationInfo = {
               name : this.name,
               password : this.password,
               drugType : this.choosenType,
               format : this.choosenFormat,  
               manufacturer : this.manufacturer,
               quantity : this.quantity,
               idPharm:this.id

          }
          this.axios.post('/drug/createDrug',medicationInfo,{ 
             headers: {
             }}).then(response => {
                       alert("Drug is added!");
                        this.nesto=response.data;
                        console.log(response.data);
                })
                .catch(res => {
                    console.log(res.response.data.message);
                 });    
      },
      typeIsSelected : function(event, type) { 
           this.choosenType = type;
      },
      typeIsSelected1 : function(event, type) { 
           this.choosenFormat = type;
      }
},
 mounted() {
     this.axios.get('/pharmacy/findById/'+this.id)
        .then(response => {
                this.pharmacy = response.data;

                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
    }
}
</script>  