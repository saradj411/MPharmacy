  <template>
  <div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Pharmacist profile</label>

        <div style="background: #B0B3D6; height: 80px;">

            <span style="float: left; margin-top: 20px;">
                  <router-link :to="{ path: '/updatePharmacistProfile/'+user.id}" v-slot="{href, navigate}" custom>

                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A " :href="href" @click="navigate" elevation="1">Update profile</button>
               </router-link>
            </span>
             <span style="float: left; margin-top: 20px;">
                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A" v-on:click = "clients">Reviewed clients </button>
                     </span>

<span style="float: left; margin-top: 20px;">
                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A" v-on:click = "profile">Clients </button>
                     </span>
<span style="float: left; margin-top: 20px;">         
                              
                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A" v-on:click = "requestForvacation">Request for vacation</button>
                     </span>
                     <span style="float: left; margin-top: 20px;">         
                              
                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A" v-on:click = "inssuing">Issuing the reserved drug</button>
                     </span>
                     <span style="float: left; margin-top: 20px;">
                     <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A" v-on:click = "ShowAllDrugs">Show All Drugs</button>
                     </span>
                     <span style="float: left; margin-top: 20px;">
                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A" v-on:click = "erec">Create eRecepie</button>
                     </span>
<span style="float: left; margin-top: 20px;">
                  <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background:#474A8A" v-on:click = "logOut">Log out</button>
                     </span>
                     

                     
                <span style="float: left; margin-top: 20px;">
                          <b-dropdown id="ddCommodity" name="ddCommodity" text="Counseling" style="margin-left:33px; color:white;"  >
                                        
                                        <b-dropdown-item>
                                          <router-link :to="{ path: '/SearchUserPharmacist/'+user.id}" v-slot="{href, navigate}" custom>
              <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">Search user
                </b-link></router-link>
              </b-dropdown-item>
                                        <b-dropdown-item>
                                          <router-link :to="{ path: '/WorkCalendarPharmacist/'+user.id}" v-slot="{href, navigate}" custom>
              <b-link style="font-size:20px;color:black;" :href="href" @click="navigate"  elevation="1">Work calendar
                </b-link></router-link>
              </b-dropdown-item>
                                    </b-dropdown> 
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
    id: this.$route.params.id,
    pharmacy : {}
    }
  },
  
  mounted() {
    



        this.axios.get('pharmacist/findById/'+this.id,{ 
             
         }).then(response => {
               this.user=response.data;
         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
    
                            
                 
},
  methods:{
     profile : function(){
          window.location.href = '/Clients';
        },
        clients : function(){
          window.location.href = '/ReviewedClientsPharmacist/'+this.id;
        },
        requestForvacation : function(){
          window.location.href = '/RequestForVacationPharmacist/'+this.id;
        },
        
        inssuing : function(){
          window.location.href = '/InssuingDrug/'+this.id;
        },
        erec: function()
        {
          window.location.href = '/createERecepie/'+this.id;
        },
        logOut: function()
      {
        localStorage.removeItem('accessToken');
        localStorage.removeItem('expiresIn');
         window.location.href = "/";

      },
       ShowAllDrugs: function()
        {
             window.location.href = '/AllDrugs/' + this.id;
               
        },
        
}
}
</script>

<style>
.tab{
    width : 5px;
}
</style>


  