  <template>
  <div style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Patient profile</label>

        <div style="background: #B0B3D6; height: 80px;">

            <span style="float: left; margin-top: 20px;margin-left:15px;">
              <div class="input-group mb-3">
                    <div >
                       
                            <b-dropdown id="ddCommodity" name="ddCommodity" text="Choose allergy"  >
                                <b-dropdown-item v-for="drug in this.drugs" 
                                 v-on:click ="typeIsSelected($event, drug.name,drug.idDrug)" v-bind:key="drug.idDrug"> {{drug.name }}</b-dropdown-item>
                            </b-dropdown> 
                        </div><div class="input-group-append">
                       <button class="btn btn-info" type="button"  v-on:click = "addAllergy(drug)" >Add allergy</button>
                        <span >{{choosenType}}</span>
                    </div>
              </div>
                     
            </span>
                                  
        </div>
        <div>
<h3 style="color: #0D184F">Allergies:</h3>
<div style=" float:left; width: 800px;margin-top:25px;margin-left:200px;" v-for="drug in this.user.allergies"  v-bind:key="drug.idDrug">
    
        <table style="" id="table2" class="table" >
                <tbody>
                    <tr style="font-size:22px;color:#050505;">
                    <th scope="row"></th>
                    <td>{{drug.name}} </td>
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
        user: {},
    pharmacy : {},
    showTable:true,
    drugs:{},
    choosenType : "" ,
    drug:null
    }
  },
  
  mounted() {
        this.axios.get('patient/findById/'+507,{ 
             
         }).then(response => {
               this.user=response.data;
         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
    
              this.axios.get('/drug/findAll')
        .then(response => {
                this.drugs = response.data;
                
         }).catch(res => {
                alert("Nesto ne valja");
                console.log(res);
        });              
                 
},
  methods:{
      typeIsSelected : function(event, name,id) { 
           this.choosenType = name;
           this.drug=id
      },
      addAllergy: function(drug){
           
             this.drug = drug
      this.axios.get('/patient/addAllergy/'+ this.drug+"/"+508)
          //.then(response => {
             // this.showTable = false;
              
              
         // })
      }
}
}
</script>

  