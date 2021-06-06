<template>
   <div >
    <div class="loginHolder">
    
    <br>
        <div class="userInfo">
        <h1 >Register new dermatologist: </h1>
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
                <tr>        
                    <td colspan="2">
                        
                    </td>
                
                </tr>
                <br>
            </table>

            <div class="workTime">
            <h1>Work time (Optional): </h1>
            <br>
                    <table id="loginTable">
                        <tr>
                            <td> <h4>Date:</h4> </td>
                            <td><input type="date" v-model="date" class="form-control"></td>
                        </tr>
                        <tr>
                            <td> <h4>Start Time:</h4></td>
                            <td><b-form-timepicker v-model="startTime" locale="en"></b-form-timepicker></td>
                        </tr>

                        <tr>
                            <td> <h4>End Time:</h4></td>
                            <td><b-form-timepicker v-model="endTime" locale="en"></b-form-timepicker></td>
                        </tr>

                        <tr>
                            <td> <h4>Select pharmacy:</h4></td>
                            <td>                               
                                    <select class="form-control" v-model="pharmacyID" placeholder="Select pharmacy" >                                       
                                        <option
                                        v-for="pharmacy in this.pharmacies" 
                                        v-bind:key="pharmacy.idPharm"
                                        v-bind:value="pharmacy"                                    
                                         :selected="pharmacy == '<the default value you want>'">
                                        {{pharmacy.idPharm}}: {{ pharmacy.name }} - {{ pharmacy.address }} </option>
                                      </select>
                            </td>
                        </tr>
                    
                    </table>
                    <br>
                    <button class = "btn btn-primary btn-xs" :disabled="!name || !surname || !email || !address || !phoneNumber || !city
                    || !country || !avgGrade"    style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" v-on:click="registerDerm">Confirm</button>
                
            </div>
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

            date: "",
            startTime: "",
            endTime: "",   
            avgGrade: "",         
            staff: {},        
            errorMessage : "",
            pharmacyID: {},

            id : this.$route.params.id,
            pharmacies : []

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
        registerDerm : function()
        {   
                const dermInfo = { 
            
                name : this.name,
                surname : this.surname,
                email : this.email,                
                address : this.address,
                phoneNumber : this.phoneNumber,
                city : this.city,
                country : this.country,
                avgGrade: this.avgGrade,
                date: this.date,
                startTime: this.startTime,
                endTime: this.endTime,
                pharmacyID: this.pharmacyID.idPharm 

                }
            console.log( dermInfo );

            this.axios.post('/dermatologist/saveDermatologist', dermInfo,
            {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken'),
                    'Expires' : localStorage.getItem('expiresIn'),
                    //'Content-Type' : 'application/json; charset=utf-8'
                }}).then(response => 
                {
                    alert("Successfully registered new dermatologist.");
                    console.log(response.data);
                    this.$router.push('/SystemAdminProfile/'+this.id);                    
                }).catch(res => {
                    console.log(res.response.data.message);
                    alert("Greska. Proverite podatke.");
                    
                });                     
       }                        
    },
    mounted()
    {
        this.axios.get('/pharmacy/findAll')
        .then(response => {
                this.pharmacies = response.data;
                
         }).catch(res => {
                alert("Apoteke nisu pronadjene!");
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
        width: 500px;
       
        padding: 50px;
    }
    
.input--error{
    border-color:red;
    }

</style>