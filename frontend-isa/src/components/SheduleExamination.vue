<template>
  <div id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
       <label style="color:#0D184F;font-size:35px;" align = "left">Examination</label>

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
                            <label style="font-size:22px;color:#0D184F;">Pharmacy:</label>
                            <input type="number" class="form-control"  v-model="pharmacy" placeholder="Enter pharmacy">
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
        showNew:true,
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
      shedule : function(){
          const infoExamination = {
                    idPatient: this.id,
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

    
},
 mounted() {

    },
    
    
    
}
</script>  