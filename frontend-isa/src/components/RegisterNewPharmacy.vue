<template>
   <div >
    <div class="loginHolder">
    
    <br>
        <div class="userInfo">
        <h1 >Register new pharmacy: </h1>
        <br>
            <table id="loginTable">
                <tr>
                    <td><h4 > Name: </h4> </td>
                    <td>
                        <input type="text"
                         v-model="name" 
                         class="form-control"
                          placeholder="Enter name"
                           aria-label="Enter name" 
                           aria-describedby="addon-wrapping"
                           :class="{'input--error':!name}">
                    </td> 
                        <td></td> 
                </tr>
                <tr>
                    <td> <h4> Address: </h4> </td>
                    <td>
                    <input type="text" v-model="address" class="form-control" :class="{'input--error':!address}" placeholder="Enter address"  aria-label="Enter address" aria-describedby="addon-wrapping">
                    </td>   <td></td> 
                </tr>  <tr>
                    <td> <h4> City: </h4> </td>
                    <td>
                    <input type="text" v-model="city" :class="{'input--error':!city}" class="form-control" placeholder="Enter city"  aria-label="Enter city" aria-describedby="addon-wrapping">
                    </td>   <td></td> 
                </tr>
                 <tr>
                    <td> <h4> Country: </h4> </td>
                    <td>
                    <input type="text" v-model="country" :class="{'input--error':!country}"  class="form-control" placeholder="Enter country"  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                    </td>  <td></td>  
                </tr>
                <tr>
                    <td> <h4> Desription: </h4> </td>
                    <td>
                    <input type="text" v-model="description" class="form-control" :class="{'input--error':!description}" placeholder="Enter description"  aria-label="Enter email" aria-describedby="addon-wrapping">
                    </td>  <td></td>  
                </tr>
               
                
                <tr>
                    <td> <h4> Average Grade: </h4> </td>
                    <td>
                    <input type="text" v-model="avgGrade" :class="{'input--error':!avgGrade}" class="form-control" placeholder="Enter average grade "  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                    </td> 
                    <td></td>  
                </tr>
                <tr>
                            <td> <h4>Select pharmacist:</h4></td>
                            <td>                               
                                    <select class="form-control" v-model="pharmacyAdmin" :class="{'input--error':!pharmacyAdmin}" placeholder="Select pharmacy" >                                       
                                        <option
                                        v-for="admin in this.pharmaciesAdmins" 
                                        v-bind:key="admin.id"
                                        v-bind:value="admin"                                    
                                         :selected="admin == '<the default value you want>'">
                                        {{ admin.id }} : {{admin.name}} {{ admin.surname }} - [{{admin.address}}, {{admin.city}}]  </option>
                                      </select>
                            </td>
                            <td> 
                             <button class = "btn btn-primary btn-xs"
                        style="margin:auto; background: #000; margin-left:10px; width: 180px;" 
                        v-on:click="addNewAdmin">Or create new admin</button>
                
                            
                            </td>
                        </tr>
                                
                <tr>
                    <td colspan="2">
                        <div id="errorMessage" > 
                        </div >
                        
                        
                    </td>
                </tr>
                
            </table>
            <br>
            <button class = "btn btn-primary btn-xs" :disabled="!name || !address || !description || !city
                    || !country || !avgGrade  || pharmacyAdmin.selected"    style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;"
                     v-on:click="registerAdmin">Confirm</button>
            
            
        </div>
    </div>
</div>
</template>
<script> 
import { required } from 'vuelidate/lib/validators'

export default{
    data()
    {
        return{
            
            name : "",
            address : "",
            phoneNumber : "",
            city : "",
            country : "", 
            description: "",
            avgGrade: "",
            pharmacyAdmin: {},
            id : this.$route.params.id,
            pharmaciesAdmins : []

        }
    },
    validations:
    {
        name : {
            required            
        },
        surname : {
            required            
        },
        
        address : {
            required            
        },
        
        city : {
            required            
        },
        country : {
            required            
        },
        description:
        {
            required
        },
        avgGrade:
        {
            required
        }


    },

    methods:
    {
        addNewAdmin : function()
        {
           window.location.href = '/RegisterAdminPharamcyPage/' + this.id;         
        },
        registerAdmin : function()
        {   
                const phamracyInfo = { 
            
                name : this.name,                            
                address : this.address,                
                city : this.city,
                country : this.country,
                avgGrade: this.avgGrade,
                description: this.description,
                idPharmacyAdmin: this.pharmacyAdmin.id

                }
            console.log( phamracyInfo );

            this.axios.post('pharmacy/register', phamracyInfo,
            {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response =>                 {
                    
                    alert("Successfully registered new pharmacy.");
                    console.log(response.data);
                    this.$router.push('/SystemAdminProfile/' + this.id);                    
                }).catch(res => {
                    console.log(phamracyInfo.pharmacyAdmin);

                    if(phamracyInfo.idPharmacyAdmin == null)
                    {
                        alert("Please, select admin of the pharmacy!");
                    }else
                    {                        
                        console.log(res.response.data.message);
                        alert("Greska. Proverite podatke.");
                    }
                    
                    
                });                     
       }                        
    },
    mounted()
    {
        this.axios.get('/adminstrator/findAll')
        .then(response => {
                this.pharmaciesAdmins = response.data;
                
         }).catch(res => {
                alert("Error!");
                console.log(res);
        });   

    }
    
}  
</script>


<style scoped>
    *
    {
        margin: 0 auto;
    }
    .loginHolder
    {
        margin: 0 auto;
        margin-top: 80px;
    }
    .userInfo
    {
        margin: 0 auto;
        display: block;
        
        width: 600px;
        height: 450px;
    }
    .workTime
    {

    }
    #loginTable
    {
        margin: 0 auto;
        width: 700px;
       
        padding: 50px;
    }
    
.input--error{
    border-color:red;
    }
.regFormAdmin
{
    margin-top: 20px;

}

</style>