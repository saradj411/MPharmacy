 <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center"></label>

        <div style="background: #B0B3D6; height: 80px;">

           
                                  
        </div>

<div style="margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F;font-size:35px;">Update drug</h3>
            
    <form>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Name:</label>
                        <input type="text" class="form-control" v-model = "drug.name" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Code:</label>
                        <input type="text"  class="form-control" v-model = "drug.code">
                        </div>
                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Recipe need::</label>
                        
                        <input type="text"  class="form-control" v-model= "drug.recipeNeed" >
                        </div>
                        <div class="form-group col-md-6">
                        <label style="color: #0D184F">Manufacturer:</label>
                        <input type="text" class="form-control" v-model= "drug.manufacturer" >
                        
                        </div>
                    </div>
                      
                      
                      
                      <div class="form-row">
                        <div class="form-group col-md-6">
                         <label style="color: #0D184F">Old drug type : {{drug.drugType}}</label>
 <div >

                        <div style="color:#0D184F;">
                       
                            <b-dropdown id="ddCommodity"  name="ddCommodity" text="Choose new drug type"  >
                                <b-dropdown-item  v-for="item in this.types" v-on:click ="typeIsSelected($event, item.drugType)" v-bind:key="item.drugType"> {{item.drugType }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                         <div >
                            <span >{{choosenType}}</span>
                        </div>
                    </div>
                      
                        </div>


                         <div class="form-group col-md-6">
                        <label style="color: #0D184F">Old drug format : {{drug.format}}</label>
                        <div >

                        <div style="color:#0D184F;">
                       
                            <b-dropdown id="ddCommodity"  name="ddCommodity" text="Choose new drug format"  >
                                <b-dropdown-item  v-for="item in this.formats" v-on:click ="typeIsSelected1($event, item.format)" v-bind:key="item.format"> {{item.format }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                         <div >
                            <span >{{choosenFormat}}</span>
                        </div>
                    </div>
                        </div>
                        
                    </div>
                     
                    <button class="btn btn-primary btn-lg" v-on:click = "update" style="background:#474A8A">Change</button>

                </form>



</div>

  

    </div>
</template>

<script>
export default {
  data() {
    return {
       types: [
          { drugType: 'BLOOD' },
          { drugType: 'HUMAN' },
          { drugType: 'BIOLOGICAL' },
          { drugType: 'HERBAL' },
          { drugType: 'HOMEOPATIC' },
          { drugType: 'TRADICIONAL' },
      ],
      formats: [
          { format: 'CAPSULE' },
          { format: 'LIQUID' },
          { format: 'INJECTION' },
          { format: 'VACCINE' },
          { format: 'CREME' },
          { format: 'GEL' },
          { format: 'TABLET' },

      ],
      
       id : this.$route.params.id,
       drug : {},
       nesto:{},

    name : "",
    code : "",
    recipeNeed : "",
    drugType : "",
    format : "",
    manufacturer : "",
    choosenFormat : "" ,
    choosenType : ""   
 
       
    }
  },
  mounted() {
        this.axios.get('/drug/findById/'+this.id)
        .then(response => {
                this.drug = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
       
    },
    methods:
    
    {
     update: function(){
      if(this.choosenFormat ==""){
          this.choosenFormat=this.drug.format;
      }
       if(this.choosenType ==""){
          this.choosenType=this.drug.drugType;
      }
    const adminInfo = {
                    idDrug : this.drug.idDrug,
                    name: this.drug.name,
                    code : this.drug.code,
                    recipeNeed: this.drug.recipeNeed,
                    drugType: this.choosenType,
                    format : this.choosenFormat,  
                    manufacturer:this.drug.manufacturer

        } 
        this.axios.post('/drug/updateDrug',adminInfo,{
      }).then(response => { 
               this.nesto=response.data;
                alert("Changes have been saved!");
                window.location.href = "/updateDrug/"+this.id;
          }).catch(res => {
                      alert("neceeee!");

                       console.log(res);
                 });
      },
      typeIsSelected1 : function(event, type) { 
           this.choosenFormat = type;
      },typeIsSelected : function(event, type) { 
           this.choosenType = type;
      }
}
   
}

</script>