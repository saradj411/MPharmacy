<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
     <div>
<label style="color:#0D184F;font-size:35px;margine-left:50px" align = "left">Create drug order:</label>
</div>
        <div  style=" background:#B0B3D6;width:500px;margin-left:38px;margin-top:60px;">
                    
                   
                    

                    <div>
                        <div>
                                                        <label style="font-size:22px;color:#0D184F;">Pharmacy drugs:</label>

                            <b-dropdown id="ddCommodity" name="ddCommodity" text="choose drug"
                                        class = "btn btn-link btn-lg" style="font-size:20px;color:black;">
                            
                                            <b-dropdown-item v-for="medicine in this.drugs" v-bind:key="medicine.idDrug"
                                            v-on:click = "selektovani($event, medicine)"> 
                                            {{ medicine.name}}
                                            </b-dropdown-item>
                                            <b-dropdown-item>

                                      <router-link :to="{ path: '/createDrugPage/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size:15px;color:blue;" :href="href" @click="navigate"  elevation="1">Add new drug
             </b-link></router-link>
           </b-dropdown-item>
                                    </b-dropdown> 
                                      <label style="font-size:22px;color:#0D184F;">{{selectedMedication.name}}</label>

                        </div>

                        <div >
                            <label style="font-size:22px;color:#0D184F;">Quantity:</label>
                            <input type="number" class="form-control" v-model = "quantity" placeholder="Enter quantity">
                        </div>
                        <div >
                            <label style="font-size:22px;color:#0D184F;">Time limit:</label>
                            <input type="date" class="form-control" v-model = "timeLimit" placeholder="Enter date">
                        </div>
            </div>


                                            
            </div>

            <button class="btn btn-primary btn-lg" v-on:click ="addNewMedicine" style="margin-left:-950px; margin-top:20px;background:#474A8A">Order drug </button>

            <div v-if="showTable" style=" background:#B0B3D6;width:500px;height:0px;margin-left:38px;margin-top:60px;" >
                <form >
                    <label style="font-size:28px;color:#0D184F;margine-left:20px;">List of drugs ordered </label >
                                            <table  class="table">

                                                <thead>
                                                    <tr>
                                                <th>Medicine name</th>
                                                <th>Quantity</th>
                                                </tr>
                                                
                                                </thead>
                                                <tbody>
                                                <tr v-for="med in medicationQuantityList" :key="med.id">
                                                    <td>{{med.drug.name}}</td>
                                                    <td>{{med.quantity}}</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                    <button class="btn btn-primary btn-lg"  v-on:click="createDrugOrder" style="margin-left:10px; margin-top:20px;background:#474A8A">Create order</button>
</form>
                                        </div>
                                        

                                      

    
    </div>
</template>

<script>
export default {
  data() {
    return {
      
      description : "",
      timeLimit: null,
      id : this.$route.params.id,
      showTable: false ,
      medicationQuantityList:[],
      drugs:{},
       selectedMedication : {},
       quantity:"",
       user:{},
       pharmacy:{},
       drug:{},
    


      
    }
  },

    methods:{

        createDrugOrder : function(){
          const order = {
                    orderItemDTO: this.medicationQuantityList,
                    timeLimit: this.timeLimit,
                    id : this.id,
                    //processed : false//ceka ponude za narudjbenicu ,false
                };
                console.log("time "+this.timeLimit);
                console.log("admin je"+this.id);
                
            this.axios.post('/drugOrder/create',order,{ 
             headers: {
             }}).then(response => {
                       console.log(response.data);
                       console.log("Purchase order successfully created!");   
                       alert("Purchase order successfully created!"); 
                })
                .catch(response => {
                        alert(response);
                 });    
      },
      selektovani : function(event, medicine) {
            this.selectedMedication = medicine;
            console.log(event);
      }
    ,

       addNewMedicine : function(){
               this.showTable = true;
               const medicineWithQuantity = {
                    drug: this.selectedMedication,
                    quantity: this.quantity,
                    };
                    console.log(this.quantity);
                this.medicationQuantityList.push(medicineWithQuantity)//orderItemDTO
      },
           
     
},
 mounted() {
      this.axios.get('/adminstrator/findById/'+this.id,{ 
             
         }).then(response => {
               this.user=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
        });

        this.axios.get('/adminstrator/findPharm/'+this.id,{ 
             
         }).then(response => {
               this.pharmacy=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
        });
        
        this.axios.get('/pharmacy/getDrugsPharmacy/'+501)
        .then(response => {
                this.drugs = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });

     
    }
}
</script>  