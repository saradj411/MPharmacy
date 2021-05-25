  <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 200% 150%;  height: 2000px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Patient profile</label>

        <div style="background: #B0B3D6; height: 80px;">
          <button class="btn btn-danger btn-lg" style="float:left;margin-left:20px;margin-top:15px" v-on:click = "showPharmacies">Home</button>
            <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "myProfile">Profile</button>
           
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showReservation">Drug reservation</button>
            <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showConsultation">Consultation</button>
            <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showExamination">Examination</button>
           
                                  
        </div>

<!-- all PHARMACIES!-->
  <div v-if="showTable"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">ALL PHARMACIES:</h4>    
 <div style="background: #a7c1c9; width: 500px;margin-left:50px;"  v-for="pharmacy in this.pharmacies"  v-bind:key="pharmacy.idPharm">
      
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
      <!--PHARMACIES TO WHICH YOU SUBSCRIBE-->
  <div v-if="showTable"  style="float:right;margin-left:30px;">
     <h4 style="margin-bottom:30px;margin-top:30px;margin-right:60px">PHARMACIES TO WHICH YOU SUBSCRIBE:</h4>    
 <div style="background: #a7c1c9; width: 500px;margin-right:50px;"  v-for="pharmacy in this.pharmacies1"  v-bind:key="pharmacy.idPharm">
      
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
<!--ACTUAL Reservation!-->
  <div v-if="showReserveTable"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">ACTUAL RESERVATION:</h4>    
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="reservation in this.reservations"  v-bind:key="reservation.idReservation">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
        <tr>
        <th scope="row"></th>
        <td style="font-size:25px;font-weight:bold;">Pick up to:</td>
      <td style="font-size:25px;font-weight:bold;">{{reservation.pickUpDate | formatDate}}</td>
      </tr>
      <tr>
        <th scope="row"></th>
        <td style="font-size:25px">{{reservation.drug.name}}</td>
      <td style="font-size:25px;">Quantity:{{reservation.quantity}} </td>
      </tr>
    <tr>
      <th></th>
      <td >Date of reservation</td>   
    <td>{{reservation.dateOfReservation | formatDate}}</td>

    </tr>
  
    <tr>
      <th></th>
      <td >Pharmacy</td>   
    <td>{{reservation.pharmacy.name}}</td>

    </tr>
     <tr>
      <th></th>
      <td ></td>   
    <td><button class="btn btn-danger btn-sm" v-on:click = "canceling(reservation,reservation.idReservation)">Cancel</button></td>

    </tr>
  </tbody>
</table>
           </div>


      </div> 
      <!-- canceled Reservation!-->
  <div v-if="showReserveTable"  style="float:left;margin-left:170px;">
     <h4 style="margin:30px">CANCELED RESERVATION:</h4>    
 <div style="background: #a7c1c9;"  v-for="reservation in this.canceledReservations"  v-bind:key="reservation.idReservation">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td style="font-size:25px;font-weight:bold;">{{reservation.drug.name}}</td>
      <td style="font-size:25px;">Quantity:{{reservation.quantity}} </td>
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
     
  </tbody>
</table>
           </div>


      </div> 
         <!--Reservation!-->
  <div v-if="showReserveTable"  style="float:right;margin-right:30px;">
     <h4 style="margin:30px">PICKED UP RESERVATION:</h4>    
 <div style="background: #a7c1c9; margin-right:30px;"  v-for="reservation in this.pickedReservations"  v-bind:key="reservation.idReservation">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td style="font-size:25px;font-weight:bold;">{{reservation.drug.name}}</td>
      <td style="font-size:25px;">Quantity:{{reservation.quantity}} </td>
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
  </tbody>
</table>
           </div>


      </div> 

<!--SCHEDULED PHARMACisct EXAMINATION!-->
  <div v-if="showPharmExam"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">SCHEDULED EXAMINATION:</h4>    
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="examination1 in this.pharmacistScheduledExamination"  v-bind:key="examination1.idExamination">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
        <tr>
        <th scope="row"></th>
      <td style="font-size:25px;font-weight:bold;">{{examination1.date | formatDate}}</td>
      <td style="font-size:25px;font-weight:bold;">{{examination1.startTime}}-{{examination1.endTime}}</td>
      </tr>
  
        <tr>
          <th></th>
          <td>Pharmacy:</td>
          <td>{{examination1.pharmacy.name}}</td>
          

        </tr>
      
        <tr>
          <th></th>
          <td >Dermatologist:</td>   
          <td>{{examination1.staff.name}} {{examination1.staff.surname}} </td>

        </tr>
        <tr>
          <th></th>
          <td style="font-size:25px;">{{examination1.price}}RSD </td>
          <td></td>

        </tr>
  </tbody>
</table>
           </div>


      </div> 
      <!--SCHEDULED DERMATOLOGIST EXAMINATION!-->
  <div v-if="showDermExam"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">SCHEDULED EXAMINATION:</h4>    
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="examination in this.dermatologistScheduledExamination"  v-bind:key="examination.idExamination">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
        <tr>
        <th scope="row"></th>
      <td style="font-size:25px;font-weight:bold;">{{examination.date | formatDate}}</td>
      <td style="font-size:25px;font-weight:bold;">{{examination.startTime}}-{{examination.endTime}}</td>
      </tr>
  
        <tr>
          <th></th>
          <td>Pharmacy:</td>
          <td>{{examination.pharmacy.name}}</td>
          

        </tr>
      
        <tr>
          <th></th>
          <td >Dermatologist:</td>   
          <td>{{examination.staff.name}} {{examination.staff.surname}} </td>

        </tr>
        <tr>
          <th></th>
          <td style="font-size:25px;">{{examination.price}}RSD </td>
          <td></td>

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

        showTable:true,
        showReserveTable:false,
        showDermExam:false,
        showPharmExam:false,

        pharmacies : [],
        pharmacies1 : [],

        reservations:[],
        dermatologistScheduledExamination:[],
        pharmacistScheduledExamination:[],


        pickedReservations:[],
        canceledReservations:[],
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
         this.axios.get('/patient/findActionPharmacy/'+this.id)
        .then(response => {
                this.pharmacies1 = response.data;
                
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

         this.axios.get('/reservation/findPickedById/'+this.id)
        .then(response => {
                this.pickedReservations = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
        this.axios.get('/reservation/findCanceledById/'+this.id)
        .then(response => {
                this.canceledReservations = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
         this.axios.get('/patient/findSheduledDermatologistExamination/'+this.id)
        .then(response => {
                this.dermatologistScheduledExamination = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
         this.axios.get('/patient/findSheduledPharmacistExamination/'+this.id)
        .then(response => {
                this.pharmacistScheduledExamination= response.data;
                
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
        this.showDermExam=false
        this.showPharmExam=false
       //this.showSearchPharmacy=true
      },
      showReservation:
       function(){
        this.showTable=false
        this.showReserveTable=true
        this.showDermExam=false
        this.showPharmExam=false
      },
      showConsultation:
       function(){
        this.showTable=false
        this.showReserveTable=false
        this.showDermExam=false
        this.showPharmExam=true
      },
      showExamination:
       function(){
        this.showTable=false
        this.showReserveTable=false
       this.showDermExam=true
       this.showPharmExam=false
      },
      canceling:
       function(res,date){
       this.axios.get('/reservation/getBool/'+date)
        .then(response => {
                this.jel = response.data;
                if(this.jel){
                   // alert("tru je")
                    //nek otkaze ili sta vec, odvede na neku stranicu...
                     this.axios.post('/reservation/canceling',res,{
                            }).then(response => {
                            this.jel = response.data;
            
                              alert("otkazanoo") 
                
                
                            }).catch(res => {
                                    alert("Nesto ne valja");
                                    console.log(res);
                            });
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

  