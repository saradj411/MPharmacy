<template>
<div>
<h1> Supplier profile: </h1>
<br>
<form @submit.prevent>
        <table style="" id="table2" class="table" >
                <tbody>
                    <tr style="font-size:22px;color:#0D184F;">
                    
                    <td>Name:</td>
                    <td><input type="text" v-model="supplier.name" 
                                    :class="{'input--error':!supplier.name}"
                                     class="form-control"  
                                     v-bind="name"
                                     
                                    
                               aria-label="Enter phone nubmer"
                                 :disabled="isDisabled ? false : true"
                                 aria-describedby="addon-wrapping"> </td>
                    
                    </tr>
                    
                    <tr style="font-size:22px;color:#0D184F;">
                    
                    <td>Email:</td>
                   <td><input type="text" v-model="supplier.email" 
                                     class="form-control"  
                               aria-label="Enter phone nubmer"
                                 :disabled="isDisabled ? false : true"
                                 aria-describedby="addon-wrapping"> </td>
                    

                    </tr>
                    <tr style="font-size:22px;color:#0D184F;">
                    
                    <td>Phone number:</td>
                     <td><input type="text" v-model="supplier.phoneNumber" 
                                     class="form-control"  
                               aria-label="Enter phone nubmer"
                                 :disabled="isDisabled ? false : true"
                                 
                                 aria-describedby="addon-wrapping"> </td>
                    

                    </tr>
                    <tr style="font-size:22px;color:#0D184F;">
                    
                    <td>Address:</td>
                     <td><input type="text" v-model="supplier.address" 
                                     class="form-control"  
                               aria-label="Enter phone nubmer"
                                 :disabled="isDisabled ? false : true"
                                 aria-describedby="addon-wrapping"> </td>

                    </tr>
                    <tr style="font-size:22px;color:#0D184F;">
                   
                    <td>City:</td>
                     <td><input type="text" v-model="supplier.city" 
                                     class="form-control"  
                               aria-label="Enter phone nubmer"
                                 :disabled="isDisabled ? false : true"
                                 aria-describedby="addon-wrapping"> </td>
                    

                </tr>
                <tr style="font-size:22px;color:#0D184F;">
                
                <td>Country:</td>
                <td><input type="text" v-model="supplier.country" 
                                     class="form-control"  
                               aria-label="Enter phone nubmer"
                                 :disabled="isDisabled ? false : true"
                                 aria-describedby="addon-wrapping"> </td>
                
                </tr>
           </tbody>
        </table>
    </form>
              
    <button class="btn btn-primary btn-xs" @click="isDisabled = !isDisabled" :disabled="isDisabled" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" >Edit </button>
    <button class="btn btn-primary btn-xs" @click="isDisabled = !isDisabled" :disabled="!isDisabled" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" >Cancel </button>
    <button class="btn btn-primary btn-xs" @click="updateSupplier" :disabled="!isDisabled || !supplier.name || !supplier.surname || !supplier.email || !supplier.address || !supplier.phoneNumber || !supplier.city || !supplier.country" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" >Save </button>
    
    <br/>
    <div class="allorder" >
            <br><br>
            <h1> All purchase orders from pharmacies:  </h1>
            <p> {{ this.limitDate}}</p>
           
            <br>
                <div v-for="order in drug_order"
                    v-bind:key ="order.idOrder"
            >
                 <div class="order" v-if="sta(order.timeLimit)" >
                        <h2  style="font-size:22px;" class="form-control" > ID Order: {{order.idOrder }} </h2>
                        <h2  style="font-size:22px;" class="form-control">Pharmacy: {{order.pharmacyId}} - {{ order.pharmacyName }}  </h2>
                        <h3  style="font-size:22px;" class="form-control"> What we need: </h3>
                            <table  > 
                                <th style="font-size:22px;" class="form-control" > 
                                    <td style="margine:20px; width:600px; font-size:22px;" > Drug name: </td>
                                    <td style="margine:20px; width:600px; font-size:22px;"> Drug quantity: </td>
                                </th>
                                <tr v-for="o in order.drugList"
                                    v-bind:key="o.idItemOrder" class="form-control" > 
                                    <td  style="margine:20px; width:600px; font-size:22px;" > {{o.nameDrug}} </td>
                                    <td style="margine:20px; width:600px; font-size:22px;" > {{o.quantity}} pcs. </td>
                                </tr>
                            </table >

                            <h2  class="form-control " style="margine-top:30px; font-size:22px;"> Litim day: {{order.timeLimit[2]}}. {{order.timeLimit[1]}}. {{order.timeLimit[0]}}. </h2>
                             
                        </div>

                    <button  v-if="sta(order.timeLimit)" class="btn btn-primary btn-xs"  style="margin:auto; margin-left:700px; margin-top:-400px; background: #000; width: 400px; font-size:22px;" >See al offers </button>
                    <button   v-if="sta(order.timeLimit)" class="btn btn-primary btn-xs"  @click="showModal(order)" style="margin:auto; margin-left:700px;background: #000; margin-top:-350px; width: 400px; font-size:22px;" >Create new offer </button>
    
                </div>
  
    
     </div>
    <!---->  <div>
        

        <b-modal ref="my-modal" hide-footer title="New offer for: " style="width:800px;">
        <div class="d-block text-center ">            
             <!--<div v-for="order in drug_order"
                    v-bind:key ="order.idOrder">
                    <h1 v-if="order.idOrder == prosledjena"> {{ order.idOrder }}: {{order.pharmacyName - order.pharmacyId}} </h1>
            </div>--> 

           <h3>ID ORDER: {{prosledjena.idOrder}} | {{prosledjena. pharmacyId}} - {{prosledjena.pharmacyName}} </h3>
            <div>
                             <table> 
                             <th  style="font-size:22px;" class="form-control">
                                <td style="margine:20px; width:600px; font-size:22px;" > Drug name: </td>
                                    <td style="margine:20px; width:600px; font-size:22px;"> Drug quantity: </td>
                            </th >
                                <tr v-for="o in prosledjena.drugList"
                                    v-bind:key="o.idItemOrder"  class="form-control" style=" height:48px;"> 
                                    <td style="margine:20px; width:200px;  font-size:22px;"  > {{o.nameDrug}} </td>
                                    <td style="margine:20px; width:250px;  font-size:22px;" > {{o.quantity}} pcs. </td>
                                </tr>
                                <br>
                                <tr class="form-control" style=" height:48px;">
                                    <td style="margine:20px; width:600px; font-size:22px;"> Price in total: </td>
                                    <td style="margine:20px; width:600px; font-size:22px; height:30px;"> 
                                        <b-form-input type="text " size="sm" align-items="center" :class="{'input--error': !price}"
                                        v-model="price"></b-form-input>
                                    </td>                                   
                                                
                                </tr> 
                                <tr class="form-control" style=" height:48px;">
                                    <td style="margine:20px; width:600px; font-size:22px;"> Deliveri date: </td>
                                    <td style="margine:20px; width:400px; font-size:22px; height:30px;"> 
                                        <b-form-input type="date" size="sm" align-items="center"
                                        v-model="date" ></b-form-input>
                                    </td>                                   
                                                
                                </tr>


                            </table>

                            
                    </div>

        </div>
        <button class="btn btn-primary btn-xs" style="margin:auto; margin-left:40px; background: #000; margin-top:10px; width:400px;"  @click="addOffer" :disabled="!price || !date"> Add </button>
        <button class="btn btn-primary btn-xs" style="margin:auto; margin-left:40px;background: #000;  width:400px;"   @click="cancelModal"> Close </button>
        </b-modal>
    </div>
     



</div>
</template>
<script>
import { required } from 'vuelidate/lib/validators'


export default{
data()
    {
        return{
            isDisabled : false,
            
            surname : "",
            email : "",
            address : "",
            phoneNumber : "",
            city : "",
            country : "",          
            errorMessage : "",
            id : this.$route.params.id,
            supplier: {},
            drug_order: {},

            isOpen: false,
            prosledjena: [],
            price: "",
            date: "",

            limitDate: "",
            today: "",
            ogranicenje: "",


        };
    }
    ,

    validations:
    {
        name : {
            required            
        },
        surname : {
            required            
        },
        email : {
            required            
        },
        address : {
            required            
        },
        phoneNumber : {
            required            
        },
        city : {
            required            
        },
        country : {
            required            
        }


    },

    methods:    
    { 
        
         sta(timeLimit)
            {
               console.log("STAAAAAA");
               //this.limitDate = timeLimit.getMonth() + "-" +timeLimit.getDay() +"-"+ timeLimit.getFullYear();
               
             
               const datum = timeLimit.[2] + '/' + timeLimit[1]  + '/' + timeLimit[0];
               
               //var proba = new Date[timeLimit[0], timeLimit.[1] , timeLimit[2]];
               var currentDate = new Date();

               
               if(currentDate.getFullYear() <= timeLimit[0] )
               {
                   console.log( currentDate.getFullYear() + "<=" + timeLimit[0])

                   if(currentDate.getUTCDay() <= timeLimit[1])
                   {
                       console.log( currentDate.getUTCDay() + "<=" + timeLimit[1])
                       if( currentDate.getUTCMonth() <= timeLimit[2])
                       {
                             console.log( currentDate.getUTCMonth() +  "<=" + timeLimit[2])
                             console.log(currentDate);
                             console.log(datum);
                             return true;

                       }
                       else
                       {
                            return false;
                       }
                      
                   }
                   else
                   {
                       return false;
                   }
                                    
               }
               else
               {
                   return false;
               }
              
            },
        showModal(order) {
            this.prosledjena = order;
            console.log(order.idOrder);
            this.$refs['my-modal'].show()
      },
      addOffer() {

          const offerInfo = 
          {
              idOrder : this.prosledjena.idOrder,
              totalPrice : this.price,
              deliveryDate : this.date,
              idSupplier : this.id
          }


          console.log(offerInfo);
          this.axios.post('offer/newOffer', offerInfo,
            {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response => 
                {
                    this.$refs['my-modal'].hide()
                    alert("Successfully added offer! ");
                    console.log(response.data);
                    this.$refs['my-modal'].hide()                   
                }).catch(res => {
                    alert(res.response.data.message);
                });  

       
      },
      cancelModal() {
        // We pass the ID of the button that we want to return focus to
        // when the modal has hidden
        this.date = "";
        this.price = "";

        this.$refs['my-modal'].toggle('#toggle-btn')
      },

        updateSupplier : function()
        {
            console.log(this.supplier.name);
                
            const supplierUpdate = 
            {
                id: this.supplier.id,
                name : this.supplier.name,
                surname : this.supplier.surname,
                email : this.supplier.email,                
                address : this.supplier.address,
                phoneNumber : this.supplier.phoneNumber,
                city : this.supplier.city,
                country : this.supplier.country
            }          
            console.log(supplierUpdate);  

            this.axios.post('user/updateUser', supplierUpdate,
            {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response => 
                {
                    alert("Successfully update user");
                    console.log(response.data);                    
                    this.isDisabled = false;                    
                }).catch(res => {
                    alert(res.response.data.message);
                });     
            } 
        
    },
    mounted()
    {
             
            var currentDate = new Date();
            this.limitDate = currentDate;

            console.log("Day " + currentDate.getUTCDay()) ;
            console.log("Month " + currentDate.getMonth());
            console.log("year " + currentDate.getFullYear());
            console.log(currentDate);

        this.axios.get('user/findById/'+ this.id ,{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.supplier = response.data;
                  console.log(this.supplier);

            }).catch(res => {
                          alert("Token expired!");
                          window.location.href = '/login';
                          console.log(res.response.data.message);
                    });


        this.axios.get('drugOrder/getAllDrugOrder',{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : localStorage.getItem('expiresIn')
                }
            }).then(response => {

                  this.drug_order = response.data;
                  console.log(this.drug_order);
                 console.log("ISPIS");

            }).catch(res => {
                        console.log(localStorage.getItem('expiresIn'));
                          //alert("Token expired!");
                          window.location.href = '/login';
                          console.log(res.response.data.message);
                    });
    }
    
}  
</script>

<style>
    .table
    {
        width:500px;
    }
    .allorder{
        margin: 0 auto;    
        width: 1000px;
        height: 500px;
    }

    .order
    {
        
        margin: 20px;
        width:600px;
        height: fit-content;
        background-color: #dbdbdb;
        font-size:22px;
        padding: 10px;
    }

    .input--error{
    border-color:red;
    }

    .modal-dialog
    {
        width:1000px;
    }
/*.modal {
  width: 500px;
  margin: 0px auto;
  padding: 20px;
  background-color: red;
  border-radius: 2px;
  box-shadow: 0 2px 8px 3px;
  transition: all 0.2s ease-in;
  font-family: Helvetica, Arial, sans-serif;
}

.fadeIn-enter {
  opacity: 0;
}

.fadeIn-leave-active {
  opacity: 0;
  transition: all 0.2s step-end;
}

.fadeIn-enter .modal,
.fadeIn-leave-active.modal {
  transform: scale(1.1);
}
button {
  padding: 7px;
  margin-top: 10px;
  background-color: green;
  color: white;
  font-size: 1.1rem;
}

.overlay {
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: #00000094;
  z-index: 999;
  transition: opacity 0.2s ease;
}
*/
</style>