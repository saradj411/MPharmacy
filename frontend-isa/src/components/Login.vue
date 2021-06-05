<template>
<div >
    <div class="loginHolder">
    <h1>Welcome to login page!</h1>
    <h6>Enter your email and password.</h6>
    <br>
        <div class="loginDiv">
           
            <table id="loginTable">
                <tr>
                    <td><h4 > Email: </h4> </td>
                    <td>
                        <input type="text" v-model="username" 
                        class="form-control" :class="{'input--error':!username}" 
                        placeholder="Enter email" aria-label="Enter name" 
                        aria-describedby="addon-wrapping"
                        v-on:change="emailChecked(username)">
                        
                    </td> 
                        
                </tr>
                <tr>
                    <td> <h4> Password: </h4> </td>
                    <td>
                    <input type="password" v-model="password" 
                    :class="{'input--error':!password}" 
                    class="form-control" placeholder="Enter name"  
                    aria-label="Enter name" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td colspan="2"><label id="errorMessage" /></td>
                </tr>
                <tr>        
                    <td colspan="2">
                        <button class = "btn btn-primary btn-xs"
                        :disabled="!username || !password"
                        v-on:click="userForLogin"
                        style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" >Submit</button>
                    </td>
                
                </tr>
            </table>           
            
        </div>
    </div>
</div>
    
</template>


<style>
    *
    {
        margin: 0 auto;
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

    .input--error
    {
    border-color:red;
    }
    
</style>

<script>
import { required } from 'vuelidate/lib/validators'

export default
{
    data()
    {

        return{
            username: "",
            password: "",
            user: []
        }
    },
    validations:
    {
        username:
        {
            required
        },
        password:
        {
            required
        }
    },
    methods:
    {   emailChecked: function(username)
        {
            this.axios.get('/user/findByEmail/'+ username)
                                .then(response => {
                                    console.log()
                                        this.user = response.data;   
                                                             
                                }).catch(res => {
                                       // alert("User doesnt exists!");
                                        console.log(res);
                                }); 
                                
                                
                        console.log("STA:" + this.user.email);
        },

        userForLogin: function()
        {
            console.log("USER");  
            console.log(this.user.email);           
  

            if(this.user.accountEnabled == false)
            {
                alert("AC DIS");
            }
            else
            {
                
                const loginInfo = 
                {
                    username: this.username,
                    password: this.password
                }
                

               this.axios.post('/user/login', loginInfo, {
                    headers: 
                    {          
                         
                        
                    }}).then(response => 
                    {                        
                        localStorage.setItem('accessToken', response.data.accessToken);
                        localStorage.setItem('expiresIn', new Date(new Date().getTime() + response.data.expiresIn).getTime());
                        this.axios.defaults.headers.common['Authorization'] = 'Bearer ' + response.data.accessToken;
                        //console.log(response.data);
                                
                                this.axios.get('/user/loggedUser', {
                                headers: 
                                {          
                                    //'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                                    
                                }}).then(response => 
                                {    
                                    console.log("ENABLE: " +response.data.accountEnabled);

                                    if(response.data.authorityRole === "ROLE_ADMIN")
                                    {
                                        console.log("USAO ADMIN");
                                        console.log(response.data);
                                        this.$router.push('SystemAdminProfile/' + response.data.id);
                                        //DODATI ZA ID ADMINA
                                    }
                                    else if(response.data.authorityRole === "ROLE_PATIENT")
                                    {
                                            this.$router.push('HomePagePatient/'+ response.data.id);
                                    }
                                    else if(response.data.authorityRole === "ROLE_PHARMACY_ADMIN")
                                    {
                                        
                                            this.$router.push('ProfileAdmin' /*+ response.data.id*/);
                                    }
                                    else if(response.data.authorityRole === "ROLE_PHARMACIST")
                                    {
                                        console.log("USAO U ROLE_PHARMACIST");
                                            //this.$router.push('HomePagePatient/'+ response.data.id);
                                            this.$router.push('profilePharmacist' /*+ response.data.id*/);
                                    }
                                    else if(response.data.authorityRole === "ROLE_DERMATOLOGIST")
                                    {
                                        console.log("USAO U DERMATOLOGA")
                                            //this.$router.push('HomePagePatient/'+ response.data.id);
                                            this.$router.push('profileDermatologist' /*+ response.data.id*/);
                                    }
                                    else if(response.data.authorityRole === "ROLE_SUPPLIER")
                                    {
                                        console.log('Supplier');
                                        console.log(response.data);
                                        this.$router.push('SupplierHomePage/'+ response.data.id);
                                    }
                                    else
                                    {
                                        console.log(response.data);
                                        alert("User has no authority!");
                                    }
                                   
                                    
                                    
                                    //Odkomentarisati ovo kad se obavi verifikacija mejla
                                }).catch(res => {                 
                                    
                                    console.log("GRESKA");
                                    console.log(res.response);
                                    this.errorMessage = res.response.data.message;
                                });                        
                        
                        
                        

                       //this.$router.push('SystemAdminProfile');
                        
                        
                        //Odkomentarisati ovo kad se obavi verifikacija mejla
                    }).catch(res => { 
                        if(res.response.status === 401)
                           alert("Wrong password or email.");
                        
                        console.log(res.response);
                        this.errorMessage = res.response.data.message;
                       
                    });    
                /*this.$store.dispatch('login', loginInfo)
                    .then(() => this.$router.push('SystemAdminProfile'))
                    .catch(err => console.log(err))*/
                }
        }
    },
    mounted()
    {

        if(localStorage.getItem('accessToken') != null)
        {
            localStorage.clear();
        }
    }
    
}

</script>