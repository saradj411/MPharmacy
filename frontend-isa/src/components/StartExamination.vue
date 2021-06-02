<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Examination</label>

 <div v-if="showExamination">       
        <div style="background:#B0B3D6; width:900px;height:700px;margin-left:38px;margin-top:60px;">
                    

                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="margine-left:5px;font-size:22px;color:#0D184F;">Name drug:</label>
                        <input type="text" style="margin-left:20px;" class="form-control" v-model="name" placeholder="Enter name">
                        </div>
                        <div class="form-group col-md-6">
                        <button class="btn btn-info" style="width:200px;font-size:22px;height:45px;margin-top:35px;background:#474A8A;color:white;" type="button" v-on:click = "examination" >See specification</button>
                        </div>

                    </div>


                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="font-size:22px;color:#0D184F;">Checking drug availability:</label>
                        </div>
                        <div class="form-group col-md-6">
                        <button class="btn btn-info" style="font-size:22px;height:45px;margin-top:5px;width:200px;background:#474A8A;color:white;" type="button" v-on:click = "check" >Check</button>
                      </div>
                        
                    </div>

                    <div class="form-row" v-if="showAltervative">
                        
                        <div class="form-group col-md-6">
                        <button class="btn btn-info" style="font-size:18px;height:100px;margin-top:5px;width:280px;color:white;" type="button" v-on:click = "alternativeDrugs" >Click to see alternative drugs that the patient is not allergic to</button>
                        </div>

                        <div v-if="showAllAlternative" class="form-group col-md-6" >            
                           <div style="color:#0D184F;">
                       
                            <b-dropdown id="ddCommodity" style="font-size:22px;height:45px;margin-top:5px;width:200px;background:#474A8A;color:white;"  name="ddCommodity" text="Drugs "  >
                                <b-dropdown-item  v-for="item in this.alternative" v-on:click ="typeIsSelected1($event, item.name)" v-bind:key="item.name"> {{item.name }}</b-dropdown-item>
                            </b-dropdown> 
                          </div>
                          
                      <div>
                          <span style="font-size:22px;color:#474A8A;">{{choosenDrug}}</span>
                      </div>
                   </div>
                        
                        
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="font-size:22px;color:#0D184F;">Checking for drug allergy:</label>
                        </div>
                        <div class="form-group col-md-6">
                        <button class="btn btn-info" style="font-size:22px;height:45px;margin-top:5px;width:200px;background:#474A8A;color:white;" type="button" v-on:click = "checkAlergy" >Check</button>
                      </div>
                        
                    </div>


                   <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="font-size:22px;color:#0D184F;">Schedule new examination :</label>
                        </div>
                        <div class="form-group col-md-6">
                        <button class="btn btn-info" style="font-size:22px;height:45px;margin-top:5px;width:200px;background:#474A8A;color:white;" type="button" v-on:click = "newExamination" >Shedule </button>
                        </div>
                        
                    </div>

                    

                    

                    <div class="form-row">                    
                      <div class="form-group col-md-6">
                        <label style="font-size:22px;color:#0D184F;">Duration of therapy:</label>
                        <input type="number" style="margin-left:20px;" class="form-control" v-model="numberOfDay" placeholder="Enter number">   
                      </div>
                    </div> 







                      <div class="form-row">                    
                      <div class="form-group col-md-6">
                        <label style="font-size:22px;color:#0D184F;">Report:</label>
                        <input type="text" style="margin-left:20px;" class="form-control" v-model="report" placeholder="Enter report">   
                      </div>
                    </div> 
                    </div>
          <button class="btn btn-primary btn-lg" v-on:click ="sheduleExamination" style="margin-left:-800px;height:50px; margin-top:50px;background:#474A8A">Save changes</button>
</div>

  

  <!--SPECIFIKACIJA-->
   <div   v-if="showSpecification" style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;" >
                   <form>
                  <label style="font-size:28px;color:#0D184F;margine-left:20px;">Specification</label >
                      <table style="" id="table2" class="table" > 
                       <tbody>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Structure:</td>   
       <td>{{specification.structure}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Contraindications:</td>   
       <td>{{specification.contraindications}}</td>
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Recommended dose:</td>   
       <td>{{specification.recommendedDose}}</td>
    </tr>
<tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td>Ingredients:</td>   
       <td v-for="d in this.sastojci"  v-bind:key="d.name">{{d.name}}</td>
    </tr>
  </tbody>
                        </table>
                                                   <button class="btn btn-primary btn-lg" v-on:click ="back" style="margin-left:10px; margin-top:50px;background:#474A8A">Back</button>

                </form>
      
      
        </div>


<!--novi predleddd-->

 <div v-if="showNew" style="background:#B0B3D6; width:650px;margin-left:38px;margin-top:60px;">
                                      <label style="font-size:30px;color:#0D184F;margine-left:20px;">Schedule new examination</label >

                    <div >
                        <div>
                        <label style="font-size:22px;color:#0D184F;">Date:</label>
                        <input type="date" class="form-control" v-model="date" placeholder="Enter description">
                        </div>
                    </div>
                    <div >
                        <div >
                        <label style="font-size:22px;color:#0D184F;">Start time:</label>
                        <input type="time" class="form-control" v-model = "start" placeholder="Enter start date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">End time:</label>
                            <input type="time" class="form-control"  v-model="end" placeholder="Enter end date">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label style="font-size:22px;color:#0D184F;">Price:</label>
                            <input type="number" class="form-control"  v-model="price" placeholder="Enter price">
                        </div>
                    </div>
                                               <button class="btn btn-primary btn-lg" v-on:click ="shedule" style="margin-left:10px; margin-top:50px;background:#474A8A">Shedule</button>

            </div>
  








                      


    
    </div>
</template>

<script>
export default {
  data() {
    return {
        name:"",
        specification:{},
        id : this.$route.params.id,
        pacijent:{},
        showSpecification:false,
        sastojci:[].showSpecification,
        showNew:false,
        showExamination:true,
        pregled:{},
        date :null,
        start: null,
        end : null,
        pharmacy:{},
        staff:{},
        price:"",
        numberOfDay:"",
        alternative:{},
        showAltervative:false,
        showAllAlternative:false,
        choosenDrug:"",
        report:""
        
    }
  },

  methods:{

  sheduleExamination(){
        this.axios.get('/patient/checkAllergy/'+this.pacijent.id+'/'+this.name)
        .then(response => {
                this.jeste = response.data;
                if(this.jeste){
                  alert("The patient is allergic to the drug.Take another drug! ")
                }else{


                        this.axios.get('pharmacyDrugs/checkAvalibility/'+this.pharmacy.idPharm+'/'+this.name)
                       .then(response => {
                             this.jes = response.data;
                             if(this.jes){            ///znaci ako lijek postoji u apoteci moze se propisati                    
                                    const info = {
                                                idPatient: this.pacijent.id,
                                                idStaff: this.staff.id,
                                                idPharm : this.pharmacy.idPharm,
                                                date : this.date,
                                                start : this.start,
                                                end : this.end,
                                                price:this.price,
                                                report:this.report,
                                                name:this.name,
                                                numberOfDay:this.numberOfDay

                                            }
                                            this.axios.post('/examination/finished',info,{ 
                                        headers: {
                                        }}).then(response => {
                                                  alert("Examination is successfully created!");
                                                    console.log(response.data);
                                        
                                            })
                                            .catch(response => {
                                                alert(response.response.data.message);
                                                    console.log(response);
                                                    alert("nece");
                                            });    


                             }else{
                               const info = {
                                                idPatient: this.pacijent.id,
                                                idStaff: this.staff.id,
                                                idPharm : this.pharmacy.idPharm,
                                                date : this.date,
                                                start : this.start,
                                                end : this.end,
                                                price:this.price,
                                                report:this.report,
                                                name:this.choosenDrug,
                                                numberOfDay:this.numberOfDay

                                            }
                                            this.axios.post('/examination/finished',info,{ 
                                        headers: {
                                        }}).then(response => {
                                                  alert("Examination is successfully created!Alternative drug");
                                                    console.log(response.data);
                                        
                                            })
                                            .catch(response => {
                                                alert(response.response.data.message);
                                                    console.log(response);
                                                    alert("nece");
                                            }); 


                             }
        
                        }).catch(res => {
                             console.log(res);
                         });
                         
                }

                
                
         }).catch(res => {
                console.log(res);
        });

         
         


   },


    shedule : function(){
          const infoExamination = {
                    idPatient: this.pacijent.id,
                    idStaff: this.staff.id,
                    idPharm : this.pharmacy.idPharm,
                    date : this.date,
                    start : this.start,
                    end : this.end,
                    price:this.price   
                }
             this.axios.post('/examination/create',infoExamination,{ 
             headers: {
             }}).then(response => {
                      alert("Examination is successfully created!");
                        console.log(response.data);
                        this.showNew = false;
                        this.showExamination = true;
             
                })
                .catch(response => {
                    alert(response.response.data.message);
                        console.log(response);
                 });    
      },


     alternativeDrugs: function(){

        this.axios.get('/pharmacyDrugs/findAlternative/'+this.pharmacy.idPharm+'/'+this.pacijent.id+'/'+this.name)
        .then(response => {
                this.alternative = response.data;
                this.showAllAlternative = true;

                
                
         }).catch(res => {
                console.log(res);
        });

     },




      newExamination : function(){
          //window.location.href = "/Examination/"+this.pacijent.idUser;
          this.showNew = true;
          this.showExamination = false;


      },
      back : function(){
          //window.location.href = "/Examination/"+this.pacijent.idUser;
          this.showNew = false;
          this.showExamination = true;
          this.showSpecification = false;


      },
      checkAlergy: function(){
          this.axios.get('patient/findAllergyById/'+this.pacijent.id+'/'+this.name)
        .then(response => {
                this.sastojci = response.data;
                alert(response.data);
        
         }).catch(res => {
                console.log(res);
        });
        
      },
      check: function(){
        
        this.axios.get('/pharmacyDrugs/findDrugsByIdPharm/'+this.pharmacy.idPharm+'/'+this.name)
        .then(response => {
                this.sastojci = response.data;
                if(response.data=="The drug is not available at the pharmacy"){
                   this.showAltervative = true;
                }

                alert(response.data);
                 
       
         }).catch(res => {
                console.log(res);
        });

      },

      typeIsSelected1 : function(event, type) { 
           this.choosenDrug = type;
      },
      examination: function(){
        
      this.axios.get('/specification/getSpec/'+this.name)
        .then(response => {
                this.specification = response.data;
                this.showSpecification = true;
                this.showExamination = false;
                 
       
         }).catch(res => {
                alert("The drug does not exist in the pharmacy!");
                console.log(res);
        });

        this.axios.get('/specification/getIngredients/'+this.name)
        .then(response => {
                this.sastojci = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });

        
    

      },
      
    
},
 mounted() {
    this.axios.get('/examination/findPatientById/'+this.id)
        .then(response => {
                this.pacijent = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });


       
        

        this.axios.get('/examination/findExamination/'+this.id)
        .then(response => {
                this.pregled = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });

        this.axios.get('/examination/findStaff/'+this.id)
        .then(response => {
                this.staff = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });

        this.axios.get('/examination/findPharmacy/'+this.id)
        .then(response => {
                this.pharmacy = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });

    
    },
    
    
    /* this.axios.get('/specification/getIngredients/'+this.name)
        .then(response => {
                this.sastojci = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
    */
    
}
</script>  