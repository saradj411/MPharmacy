<template>
<div class="regFormAdmin">
            <br>
                <h1> Register new pharmacy admin: </h1>
                
            <table style="width: 500px; margin-top:20px">
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
                        
                </tr>
                <tr>
                    <td> <h4> Surname: </h4> </td>
                    <td>
                    <input type="text" v-model="surname" :class="{'input--error':!surname}" class="form-control" placeholder="Enter surname"  aria-label="Enter surname" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Email: </h4> </td>
                    <td>
                    <input type="text" v-model="email" class="form-control" :class="{'input--error':!email}" placeholder="Enter email"  aria-label="Enter email" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
               
                <tr>
                    <td> <h4> Address: </h4> </td>
                    <td>
                    <input type="text" v-model="address" class="form-control" :class="{'input--error':!address}" placeholder="Enter address"  aria-label="Enter address" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Phone number: </h4> </td>
                    <td>
                    <input type="text" v-model="phoneNumber" :class="{'input--error':!phoneNumber}" class="form-control" placeholder="Enter phone nubmer"  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                    </td>   
                </tr>

                 <tr>
                    <td> <h4> City: </h4> </td>
                    <td>
                    <input type="text" v-model="city" :class="{'input--error':!city}" class="form-control" placeholder="Enter city"  aria-label="Enter city" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                 <tr>
                    <td> <h4> Country: </h4> </td>
                    <td>
                    <input type="text" v-model="country" :class="{'input--error':!country}"  class="form-control" placeholder="Enter country"  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Average grade: </h4> </td>
                    <td>
                    <input type="text" v-model="avgGrade" :class="{'input--error':!avgGrade}"  class="form-control" placeholder="Enter average grade"  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                    </td>   
                </tr>                 
                <tr>
                    <td colspan="2">
                        <div id="errorMessage" > 
                        </div >
                        
                        
                    </td>
                </tr>
                             
                <br>
            </table>            
             <button class = "btn btn-primary btn-xs" :disabled="!name || !surname || !email || !address || !phoneNumber || !city
                    || !country || !avgGrade"    style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" v-on:click="regAdmins">Confirm</button>
                
            
            </div>

</template>
<script>
///
import { required } from 'vuelidate/lib/validators'

export default{
    data()
    {
        return{
            name : "",
            surname : "",
            email : "",
            address : "",
            phoneNumber : "",
            city : "",
            country : "",              
            avgGrade: "",         
            staff: {},        
            errorMessage : "",           

            id : this.$route.params.id           

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
        },
        avgGrade:
        {
            required
        }


    },

    methods:
    {
        regAdmins : function()
        {   
                const pharmacyAdmin = {             
                name : this.name,
                surname : this.surname,
                email : this.email,                
                address : this.address,
                phoneNumber : this.phoneNumber,
                city : this.city,
                country : this.country,
                avgGrade: this.avgGrade          

                }
                
                console.log(pharmacyAdmin);

            this.axios.post('/adminstrator/savePharmacyAdmin', pharmacyAdmin,
            {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response => 
                {
                    alert("Successfully registered new admin.");
                    console.log(response.data);
                    this.$router.push('/RegisterNewPharmacy/'+ this.id);
                                        
                }).catch(res => {
                    if(localStorage.getItem('accessToken') === null)
                    {
                        alert("Token expired! Please login again!");
                    }
                    else
                    {
                        console.log(res.response.data.message);
                         alert("Greska. Proverite podatke.");
                    }
                    
                    
                });                    
       }                        
    },
    mounted()
    {
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