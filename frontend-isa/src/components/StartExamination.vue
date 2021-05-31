<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Examination</label>

        
        <div style="background:#B0B3D6; width:650px;height:480px;margin-left:38px;margin-top:60px;">
                    

                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="margine-left:5px;font-size:22px;color:#0D184F;">Name drug:</label>
                        <input type="text" style="margin-left:20px;" class="form-control" v-model="name" placeholder="Enter name">
                        </div>
                        <div class="form-group col-md-6">
                        <button class="btn btn-info" style="width:200px;font-size:22px;height:45px;margin-top:35px;background:#474A8A;color:white;" type="button" v-on:click = "examination" >Specification</button>
                        </div>

                    </div>


                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="font-size:22px;color:#0D184F;">Checking drug availability:</label>
                        </div>
                        <div class="form-group col-md-6">
                        <button class="btn btn-info" style="font-size:22px;height:45px;margin-top:5px;width:200px;background:#474A8A;color:white;" type="button" v-on:click = "newExamination" >Check</button>
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
                        <input type="number" style="margin-left:20px;" class="form-control" v-model="name" placeholder="Enter number">   
                      </div>
                    </div> 
<div class="form-row">                    
                      <div class="form-group col-md-6">
                        <label style="font-size:22px;color:#0D184F;">Report:</label>
                        <input type="text" style="margin-left:20px;" class="form-control" v-model="name" placeholder="Enter name">   
                      </div>
                    </div> 
                    </div>
                                               <button class="btn btn-primary btn-lg" style="margin-left:-800px;height:50px; margin-top:50px;background:#474A8A">Save changes</button>



  

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
        pregled:{},
        date :null,
        start: null,
        end : null,
        pharmacy:{},
        staff:{},
        price:""     
        
    }
  },

    methods:{




    shedule : function(){
          const infoExamination = {
                    idPatient: this.pacijent.idUser,
                    idStaff: this.staff.idUser,
                    idPharm : this.pharmacy.idPharm,
                    date : this.date,
                    start : this.start,
                    end : this.end,
                    price:this.price   
                }
                console.log("probaaaaaj "+this.pharmacy.idPharm);
                console.log("probaaaaaj "+this.pacijent.idUser);
                console.log("probaaaaaj "+this.staff.idUser);

             this.axios.post('/examination/create',infoExamination,{ 
             headers: {
             }}).then(response => {
                      alert("Examination is successfully created!");
                        console.log(response.data);
                })
                .catch(response => {
                    alert(response.response.data.message);
                        console.log(response);
                 });    
      },







      newExamination : function(){
          //window.location.href = "/Examination/"+this.pacijent.idUser;
          this.showNew = true;


      },


      examination: function(){
        
      this.axios.get('/specification/getSpec/'+this.name)
        .then(response => {
                this.specification = response.data;
                this.showSpecification = true;
                 
       
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