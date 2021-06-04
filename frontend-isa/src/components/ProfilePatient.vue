  <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Patient profile</label>

        <div style="background: #B0B3D6; height: 80px;">

            <span style="float: left; margin-top: 20px;margin-left:15px;">
                   <router-link :to="{ path: '/UpdatePatientProfil/'+user.id}" v-slot="{href, navigate}" custom>
                        <b-link class = "btn btn-primary btn-xs" 
                        style="margin:auto; background:#474A8A " 
                        :href="href" @click="navigate"  elevation="1"> Update profile</b-link >
                  </router-link>

                  <router-link :to="{ path: '/AddAllergies/'+user.id}" v-slot="{href, navigate}" custom>
                        <b-link class = "btn btn-primary btn-xs" 
                        style="margin:auto; background:#474A8A " 
                        :href="href" @click="navigate"  elevation="1">Allergies</b-link >
                  </router-link>
            </span>
                                  
        </div>

<div style=" float:left;margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F">About you</h3>
            
    <form>
        <table style="" id="table2" class="table" >
                <tbody>
                    <tr style="font-size:22px;color:#0D184F;">
                    <th ></th>
                    <td>Name:</td>
                    <td>{{user.name}} {{user.surname}}</td>
                    
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
                    <th ></th>
                    <td>Address:</td>
                    <td>{{user.address}}</td>

                    </tr>
                    <tr style="font-size:22px;color:#0D184F;">
                    <th></th>
                    <td>City:</td>
                    <td>{{user.city}} </td>
                    

                </tr>
                <tr style="font-size:22px;color:#0D184F;">
                <th></th>
                <td>Country:</td>
                <td>{{user.country}} </td>
                

                </tr>
           </tbody>
        </table>
    </form>

</div>

       <!--LOYALTY PROGRAM!-->
 <div style=" float:right;margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F">Loyalty program</h3>
            
   <form>
       <table style="" id="table2" class="table" >
         <tbody>
            <tr style="font-size:22px;color:#0D184F;">
            <th ></th>
            <td>Points:</td>
            <td>{{user.points}}</td>
            
            </tr>
    
            <tr style="font-size:22px;color:#0D184F;">
            <th></th>
            <td>Loyalty category:</td>
            <td>{{user.loyaltyCategory}} </td>
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
        user: {},
    pharmacy : {},
    id : this.$route.params.id,
    }
  },
  
  mounted() {
        this.axios.get('patient/findOneById/'+this.id,{ 
             
         }).then(response => {
               this.user=response.data;
         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
    
                            
                 
},
  methods:{
}
}
</script>

  