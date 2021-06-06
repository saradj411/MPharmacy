<template>
   <div >
    <div class="loginHolder">
    <h1 >Add new admin of the system: </h1>
    <br>
        <div class="loginDiv">
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
                    <td colspan="2">
                        <div id="errorMessage" > 
                        </div >
                        
                        
                    </td>
                </tr>
                <br>
                <tr>        
                    <td colspan="2">
                        <button class = "btn btn-primary btn-xs"  :disabled="!name || !surname || !email || !address || !phoneNumber || !city
                        || !country"  style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" v-on:click="registerAdmin">Confirm</button>
                    
                    </td>
                
                </tr>
            </table>
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
            surname : "",
            email : "",
            address : "",
            phoneNumber : "",
            city : "",
            country : "",          
            errorMessage : "",
            id : this.$route.params.id,
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
        }


    },

    methods:
    {
        registerAdmin : function()
        {
            console.log(this.name);
                         
                console.log("Prosao");
                document.getElementById("errorMessage").innerHTML  = 'Succeseffully!';
                
                const patientInfo = 
            {
                name : this.name,
                surname : this.surname,
                email : this.email,                
                address : this.address,
                phoneNumber : this.phoneNumber,
                city : this.city,
                country : this.country
            }            

            this.axios.post('user/saveAdmin', patientInfo,
            {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response => 
                {
                    alert("Successfully registered new admin. Email verification is send to " + this.email);
                    console.log(response.data);
                    this.$router.push('/SystemAdminProfile/'+ this.id);                    
                }).catch(res => {
                    alert(res.response.data.message);
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
        margin-top: 100px;
    }
    .loginDiv
    {
        margin: 0 auto;
        display: block;
        
        width: 600px;
        height: 300px;
    }
    #loginTable
    {
        margin: 0 auto;
        width: 500px;
       
        padding: 50px;
    }
    
.input--error{
    border-color:red;
    }

</style>