  <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 200% 150%;  height: 2000px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Patient profile</label>

        <div style="background: #B0B3D6; height: 140px;">
          <button class="btn btn-danger btn-lg" style="float:left;margin-left:20px;margin-top:15px" v-on:click = "showPharmacies">Home</button>
            <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "myProfile">Profile</button>
           
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showReservation">Drug reservation</button>
            <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showConsultation">Consultation</button>
            <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showExamination">Examination</button>
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showRecipe">eRecipe</button>
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showCreatedDerm">Schedule Examination</button>
           
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showCreatedPharmacist">Schedule Consultation</button>
           <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "showAllDrugs">Reserve drug</button>
           
            <button class="btn btn-danger btn-lg" style="float:left;margin-top:15px;margin-left:10px" v-on:click = "writeComplaint">Complaint</button>
           
                                  
        </div>

  <div v-if="showSearchDrug"  style="background:#B0B3D6; height: 70px; margin-top: 10px">
            
      <span  style="float:right;margin:15px">
                    
          <div class="input-group mb-3">
              <input type="text" v-model="drugName" class="form-control" placeholder="Enter drug name" aria-label="Enter name" aria-describedby="addon-wrapping">
              <div class="input-group-append">
                  <button class="btn btn-info" type="button"  v-on:click = "searchName(drugName)" >Search</button>
                </div>
           </div>
      </span>
             
            
  </div>
   <div v-if="showScheduleSearch"  style="background:#B0B3D6; height: 70px; margin-top: 10px">
            
      <span  style="float:right;margin:15px">
                    
          <div class="input-group mb-6">
              <input style="width: 200px" type="date" v-model = "date" class="form-control" placeholder = "choose a date">
                <input style="width: 200px" type="time" v-model = "time" class="form-control" placeholder = "choose the time">
          <div class="input-group-append">
                  <button class="btn btn-info" type="button"  v-on:click = "searchFreePharmacy(date,time)" >Search</button>
                </div>
           </div>
      </span>
             
            
  </div>

 <div v-if="showSortPharmacies"  style="background:#B0B3D6; height: 90px; margin-top:15px;margin-left:15px;margin-right:15px;">

              <div class="column">
                 <h4 style="margin:5px">SORT PHARMACIES BY:</h4>  
                  <button class="btn btn-dark" style="float:left;margin-left:30px;" v-on:click = "sortByGradeR">GradeR</button>
            <button class="btn btn-dark" style="float:left;margin-left:10px" v-on:click = "sortByGradeO">GradeO</button>
           
           <button class="btn btn-dark" style="float:left;margin-left:10px" v-on:click = "sortByNameAscending">NameR</button>
            <button class="btn btn-dark" style="float:left;margin-left:10px" v-on:click = "sortByNameDescending">nameO</button>
            

              </div>
    </div>
    <div v-if="showSortCreatedDermatologistExamination"  style="background:#B0B3D6; height: 90px; margin-top:15px;margin-left:15px;margin-right:15px;">

              <div class="column">
                 <h4 style="margin:5px">SORT EXAMINATIONS BY:</h4>  
                  <button class="btn btn-dark" style="float:left;margin-left:20px;" v-on:click = "sortCDExamByGradeR">GradeR</button>
            <button class="btn btn-dark" style="float:left;margin-left:10px" v-on:click = "sortCDExamByGradeO">GradeO</button>
           
           <button class="btn btn-dark" style="float:left;margin-left:10px" v-on:click = "sortCDExamByPriceAscending">PriceR</button>
            <button class="btn btn-dark" style="float:left;margin-left:10px" v-on:click = "sortCDExamByPriceDescending">PriceO</button>
            

              </div>
    </div>
 <div v-if="showSortERecipes"  style="background:#B0B3D6; height: 90px; margin-top:15px;margin-left:15px;margin-right:15px;">

              <div class="column">
                 <h4 style="margin:5px">SORT eRECIPES BY:</h4>  
                  <button class="btn btn-dark" style="float:left;margin-left:20px;" v-on:click = "sortERecipeByDateR">Date Of Issue R</button>
           <button class="btn btn-dark" style="float:left;margin-left:20px;" v-on:click = "sortERecipeByDateO">Date Of Issue O</button>
          
              </div>
    </div>
    <div v-if="showSortFinishedDE"  style="background:#B0B3D6; height: 90px; margin-top:15px;margin-left:15px;margin-right:15px;">

              <div class="column">
                 <h4 style="margin:5px">SORT FINISHED EXAMINATIONS BY:</h4>  
                  <button class="btn btn-dark" style="float:left;margin-left:20px;" v-on:click = "sortFDExamByPriceR">PriceR</button>
                   <button class="btn btn-dark" style="float:left;margin-left:20px;" v-on:click = "sortFDExamByPriceO">PriceO</button>
              <button class="btn btn-dark" style="float:left;margin-left:20px;" v-on:click = "sortFDExamByDateR">DateR</button>
                   <button class="btn btn-dark" style="float:left;margin-left:20px;" v-on:click = "sortFDExamByDateO">DateO</button>
          
              </div>
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
   <tr>
      <th></th>
      <td ></td>   
        <td><button class="btn btn-danger btn-sm" v-on:click = "unsubscribe(pharmacy.idPharm)">Unsubscribe</button></td>

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
        <td style="font-size:25px">{{reservation.drugName}}</td>
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
      <td>{{reservation.pharmacyName}}</td>

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
       <td style="font-size:25px;font-weight:bold;">{{reservation.drugName}}</td>
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
    <td>{{reservation.pharmacyName}}</td>

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
        <td style="font-size:25px;font-weight:bold;">{{reservation.drugName}}</td>
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
     <td>{{reservation.pharmacyName}}</td>
    </tr>
  </tbody>
</table>
           </div>


      </div> 

<!--SCHEDULED PHARMACisct EXAMINATION!-->
  <div v-if="showPharmExam"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">Scheduled examinations:</h4>    
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
          <td>{{examination1.namePharmacy}}</td>
          

        </tr>
      
        <tr>
          <th></th>
          <td >Pharmacist:</td>   

          <td>{{examination1.nameStaff}} {{examination1.surnameStaff}} </td>

        </tr>
        <tr>
          <th></th>
          <td style="font-size:25px;">{{examination1.price}}RSD </td>
    <td><button class="btn btn-danger btn-sm" v-on:click = "cancelExamination(examination1,examination1.idExamination)">Cancel</button></td>


        </tr>

  </tbody>
</table>
           </div>


      </div> 
      <!--FINISHD PHARMACisct EXAMINATION!-->
  <div v-if="showFinishedPharm"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">Finished examinations:</h4>    
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="examination2 in this.pharmacistFinishedExamination"  v-bind:key="examination2.idExamination">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
        <tr>
        <th scope="row"></th>
      <td style="font-size:25px;font-weight:bold;">{{examination2.date | formatDate}}</td>
      <td style="font-size:25px;font-weight:bold;">{{examination2.startTime}}-{{examination2.endTime}}</td>
      </tr>
  <tr>
          <th></th>
          <td>Report:</td>
          <td>{{examination2.report}}</td>
        </tr>
        <tr>
          <th></th>
          <td>Pharmacy:</td>
          <td>{{examination2.namePharmacy}}</td>
        </tr>
      
        <tr>
          <th></th>
          <td >Pharmacist:</td>   
          <td>{{examination2.nameStaff}} {{examination2.surnameStaff}} </td>

        </tr>
        <tr>
          <th></th>
          <td style="font-size:25px;">{{examination2.price}}RSD </td>
          <td></td>

        </tr>
         <tr>
          <th></th>
          <td >Therapy: </td>
          <td></td>
        

        </tr>
         <tr>
          <th></th>
          <td >{{examination2.therapy.drug.name}}</td>
          <td >Daily dose:{{examination2.therapy.numberOfDay}}</td>
          
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
          <td>{{examination.namePharmacy}}</td>
          

        </tr>
      
        <tr>
          <th></th>
          <td >Dermatologist:</td>   

         <td>{{examination.nameStaff}} {{examination.surnameStaff}} </td>


        </tr>
        <tr>
          <th></th>
          <td style="font-size:25px;">{{examination.price}}RSD </td>
          <td><button class="btn btn-danger btn-sm" v-on:click = "cancelExamination(examination,examination.idExamination)">Cancel</button></td>


        </tr>
  </tbody>
</table>
           </div>


      </div> 

<!--finished DERMATOLOGIST EXAMINATION!-->
  <div v-if="showFinishedDerm"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">Finished examinations:</h4>    
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="examination3 in this.dermatologistFinishedExamination"  v-bind:key="examination3.idExamination">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
        <tr>
        <th scope="row"></th>
      <td style="font-size:25px;font-weight:bold;">{{examination3.date | formatDate}}</td>
      <td style="font-size:25px;font-weight:bold;">{{examination3.startTime}}-{{examination3.endTime}}</td>
      </tr>
  <tr>
          <th></th>
          <td>Report:</td>
          <td>{{examination3.report}}</td>
        </tr>
        <tr>
          <th></th>
          <td>Pharmacy:</td>
          <td>{{examination3.namePharmacy}}</td>
          

        </tr>
      
        <tr>
          <th></th>
          <td >Dermatologist:</td>   

         <td>{{examination3.nameStaff}} {{examination3.surnameStaff}} </td>


        </tr>
        <tr>
          <th></th>
          <td style="font-size:25px;">{{examination3.price}}RSD </td>
          <td></td>

        </tr>
        <tr>
          <th></th>
          <td >Therapy: </td>
          <td></td>
        

        </tr>
         <tr>
          <th></th>
          <td >{{examination3.therapy.drug.name}}</td>
          <td >Daily dose:{{examination3.therapy.numberOfDay}}</td>
          
        

        </tr>
  </tbody>
</table>
           </div>


      </div> 

       <!--eRECEPIE!-->
  <div v-if="showERecipe"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">eRECEPIE:</h4>    
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="recipe in this.recepies"  v-bind:key="recipe.idRecipe">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
        <tr>
        <th scope="row"></th>
         <td style="font-size:25px;font-weight:bold;">Code:</td>
          <td style="font-size:25px;font-weight:bold;">{{recipe.code}}</td>
      </tr>
  
        <tr>
          <th></th>
          <td>Pharmacy:</td>
          <td>{{recipe.pharmacyName}}</td>
          
 
        </tr>
      
        <tr>
          <th></th>
          <td >Issued:</td>   
          <td>{{recipe.dateOfIssue | formatDate}}</td>
          

        </tr>
        <tr>
          <th></th>
          <td >Status: </td>
          <td>{{recipe.status}}</td>
        <td></td>

        </tr>
        <tr>
          <th></th>
          <td >Drugs: </td>
          <td></td>
        <td></td>

        </tr>
         <tr v-for="cc in recipe.eRecipeDrug" v-bind:key="cc.id">
          <th></th>
          <td >{{cc.name}}-{{cc.code}}</td>
          <td>Quantity:{{cc.quantity}}</td>
        <td></td>

        </tr>
  </tbody>
</table>
           </div>


      </div> 

       <!--CREATED DERMATOLOGIST EXAMINATION!-->
  <div v-if="showCreatedDermExamination"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">Examinations:</h4>
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="ex in this.dermatologistCreatedExamination"  v-bind:key="ex.idExamination">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
        <tr>
        <th scope="row"></th>
         <td style="font-size:25px;font-weight:bold;">{{ex.date | formatDate}}</td>
          <td style="font-size:25px;font-weight:bold;">{{ex.price}}RSD</td>
      </tr>
        <tr>
          <th></th>
          <td style="font-size:25px;font-weight:bold;">{{ex.startTime}}-{{ex.endTime}}</td>
          <td><button class="btn btn-danger btn-sm" v-on:click = "schedule(ex.idExamination)">Schedule</button></td>
          

        </tr>
        <tr>
          <th></th>
          <td>Dermatologist: {{ex.nameStaff}} {{ex.surnameStaff}}</td>
          <td>Grade dermatologist: {{ex.gradeStaff}}</td>
          

        </tr>
      
       
        
  </tbody>
</table>
           </div>


      </div> 

      
       <!--ALL DRUG IN PHARMACIES !-->
  <div v-if="showDrugsInPharmacies"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">DRUGS IN PHARMACIES:</h4>
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="dr in this.drugInPharmacies"  v-bind:key="dr.id">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td>Drug:</td>
         <td>{{dr.drug.name}}</td>
      </tr>
        <tr>
        <th scope="row"></th>
        
         <td>Pharmacy:</td>
          <td>{{dr.pharmacy.name}}</td>
      </tr>
        <tr>
          <th></th>
          <td><button class="btn btn-danger btn-sm" v-on:click = "reserve(dr.id)">Reserve</button></td>
          


        </tr>
  </tbody>
</table>
           </div>


      </div> 
      <!--SEARCH DRUG!-->
  <div v-if="showSearchDrugs"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">DRUGS IN PHARMACIES:</h4>
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="dr in this.searchDrugs"  v-bind:key="dr.id">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td>Drug:</td>
         <td>{{dr.drug.name}}</td>
      </tr>
        <tr>
        <th scope="row"></th>
        
         <td>Pharmacy:</td>
          <td>{{dr.pharmacy.name}}</td>
      </tr>
        <tr>
          <th></th>
          <td><button class="btn btn-danger btn-sm" v-on:click = "reserve(dr.id)">Reserve</button></td>
          

        </tr>
  </tbody>
</table>
           </div>


      </div> 


      <!--SPROBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA  FREE PHARMACY!-->
  <div v-if="showCreatedPharmExamination"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">FREE PHARMACIES:</h4>
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="dr in this.freePharmacy"  v-bind:key="dr.id">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td>Pharmacy:</td>
         <td>{{dr.name}}</td>
      </tr>
        <tr>
        <th scope="row"></th>
        
         <td>Address:</td>
          <td>{{dr.addres}}</td>
      </tr>
       <tr>
        <th scope="row"></th>
        
         <td>Grade:</td>
          <td>{{dr.avgGrade}}</td>
      </tr>
       <tr>
        <th scope="row"></th>
        
         <td>Consultation price:</td>
          <td></td>
      </tr>
        <tr>
          <th></th>
          <td><button class="btn btn-danger btn-sm" v-on:click = "continue1(dr.idPharm)">Schedule</button></td>
          

        </tr>
  </tbody>
</table>
           </div>


      </div> 
      <!--FREEEEEEEEEEEEE STAFFFFFFFFFFFFFFFFF!-->
  <div v-if="showFreeStaff"  style="float:left;margin-left:30px;">
     <h4 style="margin:30px">FREE PHARMACISTS:</h4>
 <div style="background: #a7c1c9;margin-left:30px;"  v-for="staff in this.freeStaffs"  v-bind:key="staff.id">
      
<table  style="" id="table2" class="table" >
 
    <tbody>
      <tr>
        <th scope="row"></th>
        <td>Pharmacist:</td>
         <td>{{staff.nameStaff}} {{staff.surnameStaff}}</td>
      </tr>
        <tr>
        <th scope="row"></th>
        
         <td>Pharmacist grade:</td>
          <td>{{staff.gradeStaff}}</td>
      </tr>
     
        <tr>
          <th></th>
          <td><button class="btn btn-danger btn-sm" v-on:click = "continue2(staff.idStaff,staff.idPharm)">Schedule</button></td>
          

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

      idPharm2:null,
      date2:null,
      time2:null,
        patient: {},

        showTable:true,
        showReserveTable:false,
        showDermExam:false,
        showPharmExam:false,
        showERecipe:false,
        showCreatedDermExamination:false,
        
        showCreatedPharmExamination:false,
        showFinishedDerm:false,
        showFinishedPharm:false,
        showDrugsInPharmacies:false,
        showSearchDrugs:false,
        showSearchDrug:false,
        showScheduleSearch:false,
        showSortPharmacies:true,
        showSortCreatedDermatologistExamination:false,
        showSortERecipes:false,
        showSortFinishedDE:false,

        pharmacies : [],
        pharmacies1 : [],
        drugName:null,
        date:null,
        time:null,

        reservations:[],
        dermatologistScheduledExamination:[],
        pharmacistScheduledExamination:[],
        recepies:[],
        dermatologistCreatedExamination:[],

        freePharmacy:[],
        freeStaffs:[],
        showFreeStaff:false,

        dermatologistFinishedExamination:[],
        pharmacistFinishedExamination:[],
        drugInPharmacies:[],
        searchDrugs:[],
    

        pickedReservations:[],
        canceledReservations:[],
        id : this.$route.params.id,
        jel:false,
        jel1:false,
        poruka:""

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

         this.axios.get('/patient/findFinishedDermatologistExamination/'+this.id)
        .then(response => {
                this.dermatologistFinishedExamination = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
         this.axios.get('/patient/findFinishedPharmacistExamination/'+this.id)
        .then(response => {
                this.pharmacistFinishedExamination= response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

         this.axios.get('/erecipe/findByIdPatient/'+this.id)
        .then(response => {
                this.recepies= response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
        this.axios.get('/examination/findCreatedPharmacistExamination')
        .then(response => {
                this.dermatologistCreatedExamination= response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
        this.axios.get('/pharmacyDrugs/getAll')
        .then(response => {
                this.drugInPharmacies= response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });
               
               
},
methods:{
     myProfile : function(){
          window.location.href = "/ProfilePatient/"+this.id;
      },
      writeComplaint:function(){
          window.location.href = "/WriteComplaint/"+this.id;
      },
       showPharmacies: function(){
        this.showTable=true
        this.showReserveTable=false
        this.showDermExam=false
        this.showPharmExam=false
        this.showERecipe=false
        this.showCreatedDermExamination=false
        this.showFinishedDerm=false
        this.showFinishedPharm=false
        this.showDrugsInPharmacies=false
        this.showSearchDrug=false
        this.showSearchDrugs=false
         this.showCreatedPharmExamination=false
         this.showScheduleSearch=false
         this.showFreeStaff=false
         this.showSortPharmacies=true
         this.showSortCreatedDermatologistExamination=false
         this.showSortERecipes=false
         this.showSortFinishedDE=false
       //this.showSearchPharmacy=true
      },
      showReservation:
       function(){
        this.showTable=false
        this.showReserveTable=true
        this.showDermExam=false
        this.showPharmExam=false
         this.showERecipe=false
         this.showCreatedDermExamination=false
         this.showFinishedDerm=false
        this.showFinishedPharm=false
        this.showDrugsInPharmacies=false
        this.showSearchDrug=false
        this.showSearchDrugs=false
        this.showScheduleSearch=false
         this.showCreatedPharmExamination=false
           this.showFreeStaff=false
            this.showSortPharmacies=false
            this.showSortCreatedDermatologistExamination=false
            this.showSortERecipes=false
             this.showSortFinishedDE=false
      },
      showConsultation:
       function(){
        this.showTable=false
        this.showReserveTable=false
        this.showDermExam=false
        this.showPharmExam=true
         this.showERecipe=false
         this.showCreatedDermExamination=false
         this.showFinishedDerm=false
        this.showFinishedPharm=true
        this.showDrugsInPharmacies=false
        this.showSearchDrug=false
        this.showSearchDrugs=false
        this.showScheduleSearch=false
          this.showFreeStaff=false
         this.showCreatedPharmExamination=false
         this.showSortPharmacies=false
         this.showSortCreatedDermatologistExamination=false
         this.showSortERecipes=false
          this.showSortFinishedDE=false
      },
      showRecipe: function(){
        
         this.showCreatedPharmExamination=false
        this.showTable=false
        this.showReserveTable=false
       this.showDermExam=false
       this.showPharmExam=false
        this.showERecipe=true
        this.showCreatedDermExamination=false
        this.showFinishedDerm=false
        this.showFinishedPharm=false
        this.showDrugsInPharmacies=false
        this.showSearchDrug=false
        this.showSearchDrugs=false
        this.showScheduleSearch=false
          this.showFreeStaff=false
          this.showSortPharmacies=false
          this.showSortCreatedDermatologistExamination=false
          this.showSortERecipes=true
           this.showSortFinishedDE=false
      },
      showExamination:
       function(){
        this.showTable=false
        this.showReserveTable=false
       this.showDermExam=true
       this.showPharmExam=false
        this.showERecipe=false
        this.showCreatedDermExamination=false
        this.showFinishedDerm=true
        this.showFinishedPharm=false
        this.showDrugsInPharmacies=false
        this.showSearchDrug=false
        this.showSearchDrugs=false
        this.showScheduleSearch=false
         this.showCreatedPharmExamination=false
           this.showFreeStaff=false
           this.showSortPharmacies=false
           this.showSortCreatedDermatologistExamination=false
           this.showSortERecipes=false
            this.showSortFinishedDE=true
      },
      showCreatedDerm:
       function(){
        this.showTable=false
        this.showReserveTable=false
       this.showDermExam=false
       this.showPharmExam=false
        this.showERecipe=false
        this.showCreatedDermExamination=true
        this.showFinishedDerm=false
        this.showFinishedPharm=false
        this.showDrugsInPharmacies=false
        this.showSearchDrug=false
        this.showSearchDrugs=false
        this.showScheduleSearch=false
         this.showCreatedPharmExamination=false
           this.showFreeStaff=false
           this.showSortPharmacies=false
           this.showSortCreatedDermatologistExamination=true
           this.showSortERecipes=false
            this.showSortFinishedDE=false
      },
      showCreatedPharmacist:
      function(){
        this.showTable=false
        this.showReserveTable=false
       this.showDermExam=false
       this.showPharmExam=false
        this.showERecipe=false
        this.showCreatedDermExamination=false
        this.showFinishedDerm=false
        this.showFinishedPharm=false
        this.showDrugsInPharmacies=false
        this.showSearchDrug=false
        this.showSearchDrugs=false
        this.showScheduleSearch=true
        this.showCreatedPharmExamination=true
          this.showFreeStaff=false
          this.showSortPharmacies=
          this.showSortCreatedDermatologistExamination=false
          this.showSortERecipes=false
           this.showSortFinishedDE=false
      },
      showAllDrugs: function(){
        this.showTable=false
        this.showReserveTable=false
       this.showDermExam=false
       this.showPharmExam=false
        this.showERecipe=false
        this.showCreatedDermExamination=false
        this.showFinishedDerm=false
        this.showFinishedPharm=false
        this.showDrugsInPharmacies=true
        this.showSearchDrug=true
        this.showSearchDrugs=false
        this.showScheduleSearch=false
         this.showCreatedPharmExamination=false
           this.showFreeStaff=false
           this.showSortPharmacies=false
           this.showSortCreatedDermatologistExamination=false
           this.showSortERecipes=false
            this.showSortFinishedDE=false
      },
      canceling:
       function(res,idRes){
       this.axios.get('/reservation/getBool/'+idRes)
        .then(response => {
                this.jel = response.data;
                if(this.jel){
                   // alert("tru je")
                    //nek otkaze ili sta vec, odvede na neku stranicu...
                     this.axios.post('/reservation/canceling/'+idRes,{
                            }).then(response => {
                            this.jel = response.data;
            
                              alert("Reservation canceled!") 
                                 window.location.href = "/HomePagePatient/"+this.id;
                
                            }).catch(res => {
                                    alert("Nesto ne valja");
                                    console.log(res);
                            });
                }else{
                   alert("Cancellation is not possible!") 
                }
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

      },

      cancelExamination:
       function(examination,idEx){
       this.axios.get('/examination/getBool/'+idEx)
        .then(response => {
                this.jel1 = response.data;
               if(this.jel1){
                   //alert("tru je")
                    //nek otkaze ili sta vec, odvede na neku stranicu...

                      this.axios.post('/examination/patientCanceling/'+idEx,{

                            }).then(response => {
                            this.jel1 = response.data;
            
                              alert("Examination canceled!") 
                                 window.location.href = "/HomePagePatient/"+this.id;
                
                            }).catch(res => {
                                    alert("Nesto ne valja");
                                    console.log(res);
                            });
                }else{
                   alert("Cancellation is not possible!") 
                }
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

      },
      schedule:
       function(idExamination){
       this.axios.post('/examination/patientScheduledDermatologistExamination/'+this.id+'/'+idExamination)
        .then(response => {
                this.jel = response.data;
                alert("Examination is scheduled.Check your email!")
                window.location.href = "/HomePagePatient/"+this.id;
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });

      },
      reserve:
       function(idTab){
       
         window.location.href = "/ReserveDrug/"+idTab+"/"+this.id;
        

      },
      
       searchName: function(drugName){
           
             this.drugName = drugName
        this.axios.get('/pharmacyDrugs/getAllByName/'+ this.drugName)
          .then(response => {
              this.showDrugsInPharmacies = false;
              this.showSearchDrugs = true;
                this.searchDrugs= response.data;
                
              
          })
      },
      
      searchFreePharmacy: function(date,time){
           this.showCreatedPharmExamination=true
           this.showFreeStaff=false
             this.date = date
             this.time=time
             console.log(this.date)
             console.log(this.time)
             /* const datum = {
                date : this.date,
                startTime : this.time
                //endTime:null,
               // staff:null,
                //pharmacy:null
                
           }*/
        this.axios.post('/workTime/findAllByDate/'+this.date+"/"+this.time)
          .then(response => {
            //this.showCreatedPharmExamination
                this.freePharmacy= response.data;
               
              
          })
      },
      continue1:
        function(idPharm33){
          this.idPharm2=idPharm33
           console.log(this.date)
             console.log(this.time)
          console.log(this.idPharm2)
            const parametar={
             idPharmacy:this.idPharm2,
             date:this.date,
             time:this.time
            }
             this.axios.post('/workTime/findFreeStaffByPharmacy',parametar)
          .then(response => {
            //this.showCreatedPharmExamination
                this.freeStaffs= response.data;
                  this.showFreeStaff=true
                  this.showCreatedPharmExamination=false
                  //this.showCreatedPharmExamination=false
               
              
          })
        },
        continue2:
        function(idStaff44,idPharm44){
         
            const parametar={
             date:this.date,
             startTime:this.time,
             price:500,
             pharmacy:idPharm44,
             patient:this.id,
             staff:idStaff44

            }
             this.axios.post('/examination/patientScheduledPharmacistExamination',parametar)
          .then(response => {
            //this.showCreatedPharmExamination
               this.poruka= response.data;
               if(!this.poruka){
                 alert("prc")
               }else{
                alert("Examination is scheduled.Check your email!")
                window.location.href = "/HomePagePatient/"+this.id;
               }
               
               
              
          })
        },


        sortByGradeR: function(){
      this.axios.get('/pharmacy/sortByGradeAscending')
          .then(response => {
               console.log(response.data);
              this.pharmacies = response.data;
              
                })
                .catch(res => {
                     
                        alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
       sortByGradeO: function(){
      this.axios.get('/pharmacy/sortByGradeDescending')
          .then(response => {
               console.log(response.data);
              this.pharmacies = response.data;
              
                })
                .catch(res => {
                     
                         alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
      
     sortByNameDescending: function(){
      this.axios.get('/pharmacy/sortByNameDescending')
          .then(response => {
               console.log(response.data);
              this.pharmacies = response.data;
              
                })
                .catch(res => {
                     
                        alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
       sortByNameAscending: function(){
      this.axios.get('/pharmacy/sortByNameAscending')
          .then(response => {
               console.log(response.data);
              this.pharmacies = response.data;
              
                })
                .catch(res => {
                     
                         alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
      sortCDExamByGradeR: function(){
      this.axios.get('/examination/sortByGradeAscending')
          .then(response => {
               console.log(response.data);
              this.dermatologistCreatedExamination = response.data;
              
                })
                .catch(res => {
                     
                        alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
       sortCDExamByGradeO: function(){
      this.axios.get('/examination/sortByGradeDescending')
          .then(response => {
               console.log(response.data);
              this.dermatologistCreatedExamination = response.data;
              
                })
                .catch(res => {
                     
                         alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
      
     sortCDExamByPriceAscending: function(){
      this.axios.get('/examination/sortByPriceAscending')
          .then(response => {
               console.log(response.data);
              this.dermatologistCreatedExamination = response.data;
              
                })
                .catch(res => {
                     
                        alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
       sortCDExamByPriceDescending: function(){
      this.axios.get('/examination/sortByPriceDescending')
          .then(response => {
               console.log(response.data);
              this.dermatologistCreatedExamination = response.data;
              
                })
                .catch(res => {
                     
                         alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
      sortERecipeByDateR: function(){
      this.axios.get('/erecipe/sortByDateAscending/'+this.id)
          .then(response => {
               console.log(response.data);
              this.recepies = response.data;
              
                })
                .catch(res => {
                     
                        alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
       sortERecipeByDateO: function(){
      this.axios.get('/erecipe/sortByDateDescending/'+this.id)
          .then(response => {
               console.log(response.data);
              this.recepies = response.data;
              
                })
                .catch(res => {
                     
                         alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
      sortFDExamByPriceR: function(){
      this.axios.get('/examination/sortFinishedDEByPriceAsc/'+this.id)
          .then(response => {
               console.log(response.data);
              this.dermatologistFinishedExamination = response.data;
              
                })
                .catch(res => {
                     
                        alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
       sortFDExamByPriceO: function(){
      this.axios.get('/examination/sortFinishedDEByPriceDesc/'+this.id)
          .then(response => {
               console.log(response.data);
              this.dermatologistFinishedExamination = response.data;
              
                })
                .catch(res => {
                     
                         alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
      sortFDExamByDateR: function(){
      this.axios.get('/examination/sortFinishedDEByDateAsc/'+this.id)
          .then(response => {
               console.log(response.data);
              this.dermatologistFinishedExamination = response.data;
              
                })
                .catch(res => {
                     
                        alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
       sortFDExamByDateO: function(){
      this.axios.get('/examination/sortFinishedDEByDateDesc/'+this.id)
          .then(response => {
               console.log(response.data);
              this.dermatologistFinishedExamination = response.data;
              
                })
                .catch(res => {
                     
                         alert("Sorting is currently not possible");
                        console.log(res)
                    })
      },
      
      unsubscribe: function(idPharmacy){
        console.log(idPharmacy)
      //OVDJE POZVATI FUNKCIJU ZA ODJAVU APOTEKA
      }
         
          

}
}
</script>
