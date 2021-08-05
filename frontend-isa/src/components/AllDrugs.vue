<template>
<div>
    <h1> All drugs: </h1>
    <div class="container" >  
  <div class="col-sm" style="margin-bottom:5px;" v-for="drug in this.drugs" v-bind:key="drug.idDrug">
    <div>
    </div>

            <div class="container">
                <div class="row">
                    <div class="col-sm">
                        <div class="row">
                                <div class="col-sm">
                            Name: 
                            </div>
                            <div class="col-sm">
                                {{drug.name}}
                                </div>                               
                        </div>
                         <div class="row">
                                <div class="col-sm">
                            Type:
                            </div>
                            <div class="col-sm">
                                 {{drug.drugType}}
                                </div>                               
                        </div>
                         <div class="row">
                                <div class="col-sm">
                            Grade:
                            </div>
                            <div class="col-sm">
                                 {{drug.grade}}
                                </div>                               
                        </div>

                    
                    
                    
                    
                    
                    
                    
                    
                    
                    </div>
                    <div class="col-sm">
                        <div class="row" v-for="p in drug.pharmaciesAndPriceDTO" v-bind:key="p.name">
                                  <div class="col-sm">
                            {{p.name}} <br>
                            {{p.address}}, {{p.city}}
                            </div>
                            <div class="col-sm">
                                 {{p.price}} din
                                </div>                                
                        </div>

                  
                  
                    </div>
                
                </div>
            </div>



   
    </div>
    </div>

</div>
</template>

<script>
export default {
      data() {
        return {              
            userAuth: localStorage.getItem('accessToken'), 
            id : this.$route.params.id,
            drugs: []
                        
           
        }
      },
      methods:{
          
    },
    mounted() {
     var accessToken = localStorage.getItem('accessToken');
    this.axios.get('drug/drugsInfo/',{ 
            headers: {                    
                    'Authorization': `Bearer ` + accessToken,
                    
                }
            }).then(response => {

                  this.drugs = response.data;
                  console.log(this.drugs);

            }).catch(res => {
                          alert("Token expired!");
                          window.location.href = '/login';
                          console.log(res.response.data.message);
                    });


        
        }       


       
        
         
    }

</script>

<style>
.container
{
  
}
.col-sm
{
    border-style:solid;
}

</style>