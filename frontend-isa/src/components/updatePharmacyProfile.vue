<template>

<div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
            <h3 style="color: #0D184F ;font-size:33px;">Welcome to the profile of the {{pharmacy.name}} pharmacy </h3>
<div style="background: #B0B3D6; height: 80px;">

            <span style="float: left; margin-top: 20px; ">

               <b-dropdown id="ddCommodity" name="ddCommodity" text="Dermatologists" style="margin-left:20px; color:white;"  >
                 <b-dropdown-item >
                                    <router-link :to="{ path: '/DermatologistsPharmacy/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">
                                    List of dermatologists
           </b-link></router-link></b-dropdown-item>


                                    <b-dropdown-item >Add dermatologist</b-dropdown-item>
                                    <b-dropdown-item >Update dermatologist</b-dropdown-item>  
    
                                </b-dropdown>      
              <b-dropdown id="ddCommodity" name="ddCommodity" text="Pharmacists" style="margin-left:50px; color:white;" >
                                    <b-dropdown-item>
                                      <router-link :to="{ path: '/PharmacistsPharmacy/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">List of pharmacists
             </b-link></router-link>
           </b-dropdown-item>
                                    <b-dropdown-item>Add pharmacist</b-dropdown-item>
                                    <b-dropdown-item >Update pharmacist</b-dropdown-item>   
   
                                </b-dropdown> 

                                <b-dropdown id="ddCommodity" name="ddCommodity" text="Drugs" style="margin-left:50px; color:white;"  >
                                    
                                    <b-dropdown-item>
                                      <router-link :to="{ path: '/DrugsPharmacy/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">List of drugs
             </b-link></router-link>
           </b-dropdown-item>

           <b-dropdown-item>

                                      <router-link :to="{ path: '/createDrugPage/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">Add drug
             </b-link></router-link>
           </b-dropdown-item>
                                    <b-dropdown-item>

                                      <router-link :to="{ path: '/DrugPricelist/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">Drug price list
             </b-link></router-link>
           </b-dropdown-item>

           

           <b-dropdown-item>

                                      <router-link :to="{ path: '/CreatePricelist/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">Create price list
             </b-link></router-link>
           </b-dropdown-item>
       
                                </b-dropdown>
 <router-link :to="{ path: '/Report/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Display of business reports</button>
               </router-link>

                                 


                                 
            </span>
                                  
        </div>

        <div style=" margin: auto; width: 50%;margin-top:45px;">

          

        </div>
       

  

  


    </div>
</template>

<script>
export default {
  data() {
    return {
      
       id : this.$route.params.id,
       pharmacy : [],
       dermatologists:[],
       pharmaciest:[],
       showP: false,
       showD: false
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
        this.axios.get('/dermatologist/getDermatologists/'+502)
        .then(response => {
                this.dermatologists = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
       
        this.axios.get('/pharmacist/getPharmacist/'+504)
        .then(response => {
                this.pharmaciest = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
    }
     ,
      methods:{
        showDermatologists: function(){
        this.showD=true,
        this.showP=false
        },
        showPharmacies : function(){
        this.showD=false,
        this.showP=true
         },
      }
   
}

</script>