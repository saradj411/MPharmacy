<template>
  <div id="registration" >
        
        <div >
                    
                    <div >
                        <div>
                        <label>Name:</label>
                        <input type="text" class="form-control" v-model="name" placeholder="Enter name">
                        </div>
                    </div>
                    <div >
                        <div >
                        <label>Code:</label>
                        <input type="text" class="form-control" v-model = "code" placeholder="Enter code">
                        </div>
                    </div>
                    <div >
                        <div>
                            <label>Recipe need:</label>
                            <input type="text" class="form-control"  v-model="recipeNeed" placeholder="Enter recipe need">
                        </div>
                    </div>
                    <div >
                        <div >
                            <label>Manufacturer</label>
                            <input type="text" class="form-control" v-model="manufacturer" placeholder="Enter manufacturer">
                        </div>
                    </div>
                   
                   <div >

                        <div >
                       
                            <b-dropdown id="ddCommodity" name="ddCommodity" text="Choose drug type"  >
                                <b-dropdown-item v-for="item in this.types"  v-on:click ="typeIsSelected($event, item.drugType)" v-bind:key="item.drugType"> {{item.drugType }}</b-dropdown-item>
                            </b-dropdown> 
                        </div>
                         <div >
                            <span >{{choosenType}}</span>
                        </div>
                    </div>
                  
            </div>
                           <button class="btn btn-primary btn-lg" v-on:click = "addDrug">Add drug</button>

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
      name : "",
      code : "",
      recipeNeed : true,
      format : "",
      manufacturer :"",
      choosenType : ""  
    }
  },

    methods:{
    
      addDrug : function() {
          const medicationInfo = {
               name : this.name,
               code : this.code,
               recipeNeed : this.recipeNeed,
               format : "TABLET",
               drugType : this.choosenType,
               manufacturer : this.manufacturer,
          }
          this.axios.post('/drug/create',medicationInfo,{ 
             headers: {
             }}).then(response => {
                       alert("Lijek je dodat!");
                        console.log(response.data);
                })
                .catch(res => {
                    alert(res.response.data.message);
                 });    
      },
      typeIsSelected : function(event, type) { 
           this.choosenType = type;
      },
      
},
 mounted() {
     
    }
}
</script>  