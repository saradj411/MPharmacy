  <template>
  <div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Pharmacy administrator profile</label>

        <div style="background: #B0B3D6; height: 80px;">

            <span style="float: left; margin-top: 20px;">
               <router-link :to="{ path: '/updatePharmacyProfile/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Update pharmacy</button>
               </router-link>
               <router-link :to="{ path: '/updateMyProfile/'+user.id}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Update profile</button>
               </router-link>
               


               <router-link :to="{ path: '/ActionAndPromotion/'+user.id}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Define action and promotion</button>
               </router-link>


                <router-link :to="{ path: '/CreatePurchaseOrder/'+user.id}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Create drug order </button>
               </router-link>

                <router-link :to="{ path: '/DrugOrders/'+user.id}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Drug orders</button>
               </router-link>

  <router-link :to="{ path: '/AcceptRejectVacation/'+user.id}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Accept/reject vacation</button>
               </router-link>



            </span>
                                  
        </div>

        <div style=" margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F">About you</h3>
            
                <form>
                      <table style="" id="table2" class="table" >
                       <tbody>
    <tr style="font-size:22px;color:#0D184F;">
      <th ></th>
      <td>Name:</td>
      <td>{{user.name}} </td>
    
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th ></th>
      <td>Address:</td>
      <td>{{user.address}}</td>

    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td>Surname:</td>
      <td>{{user.surname}} </td>
     
    </tr>
     <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td>Email:</td>
      <td>{{user.email}} </td>
     

    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td>Phone number:</td>
      <td>{{user.phoneNumber}} </td>
     

    </tr>
    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td>Country:</td>
      <td>{{user.country}} </td>
      
     

    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td>City:</td>
      <td>{{user.city}} </td>
     

    </tr>
    
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td>Pharmacy:</td>
      <td>{{pharmacy.name}} </td>
     

    </tr>
  </tbody>
                        </table>
                </form>

        </div>

       

       

    </div>
</template>

<script>
export default {
  data() {
    return {
        user: {
                
    },
    pharmacy : {
             idPharm:"",
             name: "",
             address: "",
             description: "opis 1",
             avgGrade :""

    }
    }
  },
  
  mounted() {
        this.axios.get('/adminstrator/findById/'+503,{ 
             
         }).then(response => {
               this.user=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
        });
        this.axios.get('/adminstrator/findPharm/'+503,{ 
             
         }).then(response => {
               this.pharmacy=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
        });
        
            
    
                            
                 
},
  methods:{
}
}
</script>

<style>
.tab{
    width : 5px;
}
</style>


  