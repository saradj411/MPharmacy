  <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Patient profile</label>

        <div style="background: #B0B3D6; height: 80px;">
            <button class="btn btn-danger btn-lg" style="float:left;margin-left:20px;margin:10px;margin-top:15px" v-on:click = "myProfile">Profile</button>
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px" v-on:click = "showPharmacies">Pharmacies</button>
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showReservation">Drug reservation</button>
           
                                  
        </div>

<!--PHARMACIES!-->
  <div v-if="showTable"  style="margin-left:0px;">
     <h4 style="margin:30px">PHARMACIES:</h4>    
 <div style="background: #a7c1c9; width: 700px;margin-left:300px;"  v-for="pharmacy in this.pharmacies"  v-bind:key="pharmacy.idPharm">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td><router-link :to="{ path: '/Home/'+pharmacy.idPharm}" v-slot="{href, navigate}" custom>
           <b-link style="font-size: 30px;margin-left:50px;" :href="href" @click="navigate"  elevation="1">
              {{pharmacy.name}}
            </b-link >
         </router-link></td>
      <td>Grade:{{pharmacy.avgGrade}} </td>
      </tr>
    <tr>
      <th></th>
      <td >Address  </td>   
       <td>{{pharmacy.address}}</td>

    </tr>
   
  </tbody>
</table>
           </div>

      </div>   
<!--Reservation!-->
  <div v-if="showReserveTable"  style="margin-left:0px;">
     <h4 style="margin:30px">RESERVATION:</h4>    
 <div style="background: #a7c1c9; width: 700px;margin-left:300px;"  v-for="reservation in this.reservations"  v-bind:key="reservation.idReservation">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td style="font-size:25px;font-weight:bold;">{{reservation.drug.name}}</td>
      <td>Quantity:{{reservation.quantity}} </td>
      </tr>
    <tr>
      <th></th>
      <td >Date of reservation</td>   
    <td>{{reservation.dateOfReservation | formatDate}}</td>

    </tr>
   <tr>
      <th></th>
      <td >Pick up date </td>   
    <td>{{reservation.pickUpDate | formatDate}}</td>

    </tr>
    <tr>
      <th></th>
      <td >Pharmacy</td>   
    <td>{{reservation.pharmacy.name}}</td>

    </tr>
     <tr>
      <th></th>
      <td ></td>   
    <td><button class="btn btn-danger btn-sm" v-on:click = "showRes(reservation.idReservation)">Cancel</button></td>

    </tr>
  </tbody>
</table>
           </div>

      </div> 

</div>

  


</template>

<script>
export default {
  data() {
    return {
        patient: {},

        showTable:false,
        showReserveTable:false,
        pharmacies : [],
        reservations:[],
        id : this.$route.params.id,
        jel:false

    }
  },
  
  mounted() {
    this.axios.get('/pharmacy/findAll')
        .then(response => {
                this.pharmacies = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

         this.axios.get('/reservation/findById/'+this.id)
        .then(response => {
                this.reservations = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
               
},
methods:{
     myProfile : function(){
          window.location.href = "/ProfilePatient";
      },
       showPharmacies: function(){
        this.showTable=true
        this.showReserveTable=false
       // this.showSearchPharmacy=true
      },
      showReservation:
       function(){
        this.showTable=false
        this.showReserveTable=true
       // this.showSearchPharmacy=true
      },
      showRes:
       function(date){
       this.axios.get('/reservation/getBool/'+date)
        .then(response => {
                this.jel = response.data;
                if(this.jel){
                    alert("tru je")
                    //nek otkaze ili sta vec, odvede na neku stranicu...
                }else{
                   alert("otkazivanje nije moguce") 
                }
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

      },

}
}
</script>

  