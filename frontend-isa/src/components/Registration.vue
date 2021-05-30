<template>
   <div >
    <div class="loginHolder">
    <h1 >Register patient: </h1>
    <br>
        <div class="loginDiv">
            <table id="loginTable">
                <tr>
                    <td><h4 > Name: </h4> </td>
                    <td>
                        <input type="text" v-model="name" class="form-control" placeholder="Enter name" aria-label="Enter name" aria-describedby="addon-wrapping">
                        
                    </td> 
                        
                </tr>
                <tr>
                    <td> <h4> Surname: </h4> </td>
                    <td>
                    <input type="text" v-model="surname" class="form-control" placeholder="Enter surname"  aria-label="Enter surname" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Email: </h4> </td>
                    <td>
                    <input type="text" v-model="email" class="form-control" placeholder="Enter email"  aria-label="Enter email" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Password: </h4> </td>
                    <td>
                    <input type="password" v-model="password" class="form-control" placeholder="Enter password"  aria-label="Enter password" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Address: </h4> </td>
                    <td>
                    <input type="text" v-model="address" class="form-control" placeholder="Enter address"  aria-label="Enter address" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Phone number: </h4> </td>
                    <td>
                    <input type="text" v-model="phoneNumber" class="form-control" placeholder="Enter phone nubmer"  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                    </td>   
                </tr>

                 <tr>
                    <td> <h4> City: </h4> </td>
                    <td>
                    <input type="text" v-model="city" class="form-control" placeholder="Enter city"  aria-label="Enter city" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                 <tr>
                    <td> <h4> Country: </h4> </td>
                    <td>
                    <input type="text" v-model="country" class="form-control" placeholder="Enter country"  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td colspan="2"><label id="errorMessage" /></td>
                </tr>
                <tr>        
                    <td colspan="2">
                        <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" v-on:click="registerPatient">Confirm</button>
                    </td>
                
                </tr>
            </table>
        </div>
    </div>
</div>
</template>
<script> 
export default{
    data()
    {
        return{
            name : "",
            surname : "",
            email : "",
            password : "",
            address : "",
            phoneNumber : "",
            city : "",
            country : ""
            

        }
    },

    methods:
    {
        registerPatient : function()
        {
            const patientInfo = 
            {
                name : this.name,
                surname : this.surname,
                email : this.email,
                password : this.password,
                address : this.address,
                phoneNumber : this.phoneNumber,
                city : this.city,
                country : this.country
            }

            this.axios.post('user/savePatient', patientInfo,
            {
                headers: 
                {
                    
                }}).then(response => 
                {
                    alert("Successfully registered new patient. Please check your email for verification!");
                    console.log(response.data);
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


<style>
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
    
</style>