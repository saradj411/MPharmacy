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
    <!-- MODALNI DIALOG ZA RESETOVANJE LOZINJE --> 

    <b-modal ref="my-modal" hide-footer title="First time login, please change your password!" style="width:800px;">
        <div class="d-block text-center ">     
        <h1> {{ this.user.email }}</h1>
        <table>
            <tr class="form-control" style="height:60px;  width:460px;">
                <td style="font-size:20px; width:260px;" > New password: </td>
                <td> <b-form-input type="password" size="sm" align-items="center"
                                        v-model="newPassword"
                                        style=" width:220px; font-size:22px;" ></b-form-input></td> 
             </tr>

             <tr class="form-control" style="height:60px;">
                <td style="font-size:20px; width:220px;" > New password repeat: </td>
                <td> <b-form-input type="password" size="sm" align-items="center"
                                        v-model="newPasswordRepeat"
                                        style=" width:220px; font-size:22px;" ></b-form-input></td> 
             </tr>
        </table>       
             
        </div>
        <button class="btn btn-primary btn-xs" style="margin:auto; margin-left:40px; background: #000; margin-top:10px; width:400px;"  @click="changePassword(newPassword)" :disabled="!newPassword || !newPasswordRepeat || newPassword!=newPasswordRepeat"> Reset password </button>
        <button class="btn btn-primary btn-xs" style="margin:auto; margin-left:40px;background: #000;  width:400px;"   @click="cancelModal"> Close </button>
        </b-modal>






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
            user: [],

            newPassword: "",
            newPasswordRepeat: ""
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
                                    console.log("Nasao usera sa tim emailom");
                                   
                                        this.user = response.data;   
                                                             
                                }).catch(res => {                                     
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
                this.showModal(this.user);
                
            }
            else
            {
                
                const loginInfo = 
                {
                    username: this.username,
                    password: this.password
                }
                console.log("USER za login: " + loginInfo);
                

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
                                    console.log("ENABLE: " + response.data.accountEnabled);

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
        },
        showModal() {           
            this.$refs['my-modal'].show()
            },

        changePassword(newPassword) {

        console.log("POZVALO CHABGE PASS");
          console.log(newPassword);
          console.log(this.user.email);

          const newPassInfo = 
          {
              username: this.user.email,
              password: newPassword
          }

        console.log("PATIENT INFO:");
          console.log(newPassInfo);
          this.axios.post('/user/changePassword', newPassInfo,
            {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response => 
                {
                    this.$refs['my-modal'].hide()
                    alert("Successfully changed password!");

                    //PREVISE ALI DA RADI


                        this.axios.post('/user/login', newPassInfo, {
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
                                    console.log("ENABLE: " + response.data.accountEnabled);
                                    console.log("ROLA: " + response.data.authorityRole);
                                    
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









                    console.log(response.data);

                }).catch(res => {
                    alert(res.response.data.message);
                }); 

       
      },
      cancelModal() {
        // We pass the ID of the button that we want to return focus to
        // when the modal has hidden
        this.newPassword = "";
        this.newPasswordRepeat = "";

        this.$refs['my-modal'].toggle('#toggle-btn')
      },

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