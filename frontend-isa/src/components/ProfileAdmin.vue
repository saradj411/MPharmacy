  <template>
  <div  id="registration">
        <div style="background: #B0B3D6; height: 90px;">
            
             <span style="float: left; margin-top: 20px;">
                               
                <a class = "btn btn-primary btn-xs" style="background:#474A8A" href="/updatePharmacyProfile">Update pharmacy</a>
                                    
             </span>
                                  
        </div>

        <label style="color:#474A8A;font-size:35px;" align = "left"><u>Admin of pharmacy {{pharmacy.name}}</u></label>

        <div style=" margin: auto; width: 50%;margin-top:45px;">
            <h3 style="color: #0D184F"></h3>
                <form>
                        <h3 style="color:#474A8A;font-size:24px;" align = "center">About me:</h3>

                    <div >
                        <div  style="color:#474A8A">
                        <label>Name:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.name}}</p>
                        </div>
                        <div  style="color:#474A8A">
                        <label>Surname:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.surname}}</p>
                        </div>
                    </div>
                    <div >
                        <div  style="color:#474A8A">
                        <label>Email:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.email}}</p>
                        </div>
                        <div  style="color:#474A8A">
                        <label>Phone number:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.phoneNumber}}</p>
                        </div>
                    </div>
                      <div style="color:#474A8A">
                        <div >
                        <label>Country:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.address}}</p>
                        </div>
                        <div  style="color:#474A8A">
                        <label>Town:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.country}}</p>
                        </div>
                    </div>
                     <div >
                        <div  style="color:#474A8A">
                        <label>Street:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.city}}</p>
                        </div>
                        <div style="color:#474A8A">
                        <label>Password:</label>
                        <p style="font-size:25px;font-weight:bold;">{{user.password}}</p>
                        </div>
                    </div>
                   
                    <div style="height:30px;"></div>
                </form>

        </div>

       

       

    </div>
</template>

<script>
export default {
  data() {
    return {
        user: {
                name : "",
                surname : "",
                email : "",
                password : "",
                address : "",
                phoneNumber :"",
                city : "",
                country : ""
    },
    pharmacy : {}
    }
  },
  
  mounted() {
        this.axios.get('/user/findById/'+502,{ 
             
         }).then(response => {
               this.user=response.data;

         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
                 });
    
                            
                 
},
  methods:{
}
}
</script>

<style>
.tab{
    width : 5px;
}
</style>


  