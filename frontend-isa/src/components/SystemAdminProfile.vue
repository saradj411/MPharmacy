<template>
    <div>
        <h1> Welcome {{ name }} {{ surname }} </h1>
<div class="button_holder">
    <button class = "btn btn-primary btn-xs" v-on:click = "AddShifarnikPage" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Add Sifarnik </button>
    <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Register pharmacy & pharmacy admins </button>
    <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Register dermatologist </button>          
    <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Register supplier </button>
    <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Loyality program </button>
    <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Add new system administrator </button>
    <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" > Complains </button>


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
    /*import store from './store'
    import Axios from 'axios'

Vue.prototype.$http = Axios;
const token = localStorage.getItem('accessToken')
if (token) {
  Vue.prototype.$http.defaults.headers.common['Authorization'] = token
}*/

    export default {
      data() {
        return {  
            name : "",
            surname: "", 
            token: "",
            userAuth: localStorage.getItem('accessToken'),                
           
        }
      },
      methods:{
        AddShifarnikPage : function(){
              window.location.href = "/AddShifarnikPage";
          }
        
    },
    mounted() {
        console.log("JEL UDJE DRUGI PUT TU?")

        var accessToken = localStorage.getItem('accessToken');
        var expiresIn = localStorage.getItem('expiresIn');        

        
        console.log(accessToken);
        console.log(expiresIn);
        if(accessToken != null)
        {

            console.log("TOKEN Nije istekao." );
            
            this.axios.get('/user/loggedUser', {accessToken}, {
            headers: {
                    'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
                    'Authorization': `Bearer ` + {accessToken},
                    'Access-Control-Allow-Origin': '*',
                    'Expires' : expiresIn
                }
            })
        .then(response => {
            console.log("Prosao." );
                this.name = response.data.name;
                this.surname = response.data.surname;
                
                
         }).catch(res => {   
            console.log("Greska refresh." );             
                console.log(res.response);
        });
        }
           
        
        }
         
    }
    </script>