<template>
    <div>
        <h1> Welcome {{ loggedAdmin.name }} {{ loggedAdmin.surname }} ! </h1>
        <br>
<div class="button_holder">
    <button class = "btn btn-primary btn-xs" v-on:click = "AddShifarnikPage" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Add Sifarnik </button>
    <button class = "btn btn-primary btn-xs" v-on:click = "AddNewPharmacyAndTheirAdmin" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Register pharmacy & pharmacy admins </button>
    <button class = "btn btn-primary btn-xs" v-on:click = "AddDermatologistPage" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Register dermatologist </button>          
    <button class = "btn btn-primary btn-xs" v-on:click = "AddSupplierPage" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Register supplier </button>
    <button class = "btn btn-primary btn-xs" v-on:click = "AddLoyalityProgram" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Loyality program </button>
    <button class = "btn btn-primary btn-xs" v-on:click = "AddSystemAdminPage" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Add new system administrator </button>
    <button class = "btn btn-primary btn-xs" v-on:click = "ComplainsPage" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Complains </button>


</div>
        </div>
</template>
<style>
.button_holder
{    
    margin: 0 auto;  
    position: relative;
    width: 400px;
    display: inline-block;
}

</style>

<script>    

    export default {
      data() {
        return {  
            name : "",
            surname: "", 
            token: "",
            userAuth: localStorage.getItem('accessToken'), 
            id : this.$route.params.id,
            loggedAdmin: {}              
           
        }
      },
      methods:{
        AddShifarnikPage : function(){
              window.location.href = "/AddShifarnikPage/" + this.id;
          },
        AddSystemAdminPage: function()
        {
            this.$router.push('/RegisterNewPharmacy/' + this.id);
        },
        AddDermatologistPage: function()
        {
            window.location.href = '/RegisterDermatologist/' + this.id;
        },
        AddSupplierPage: function()
        {            
            window.location.href = '/RegisterNewSupplier/' + this.id;
        },
        AddLoyalityProgram: function()
        {

        },
        AddNewPharmacyAndTheirAdmin: function()
        {
            window.location.href = '/RegisterNewPharmacy/' + this.id;
        },
        ComplainsPage: function()
        {

        }

        
    },
    mounted() {
        console.log("JEL UDJE DRUGI PUT TU?")

        var accessToken = localStorage.getItem('accessToken');
        var expiresIn = localStorage.getItem('expiresIn');        

        
        console.log(accessToken);
        console.log(expiresIn);
        /*if(accessToken != null)
        {

            console.log("TOKEN Nije istekao." );
            var auth;
            this.axios.get('/user/loggedUser', {
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + {accessToken},
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : expiresIn
                }
            })
        .then(response => {
            console.log("Prosao." );
            console.log(auth );
                this.name = response.data.name;
                this.surname = response.data.surname;
                
                
         }).catch(res => {   
            console.log("Greska refresh." );             
                console.log(res.response);
        });
        }
          */
         //
        this.axios.get('user/findById/'+ this.id ,{ 
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + accessToken,
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : expiresIn
                }
            }).then(response => {

                  this.loggedAdmin = response.data;
                  console.log(this.loggedAdmin);

            }).catch(res => {
                          alert("Token expired!");
                          window.location.href = '/login';
                          console.log(res.response.data.message);
                    });
        
        }
         
    }
    </script>