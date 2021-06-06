  <template>
  <div  id="registration" style="background-image: url(https://image.freepik.com/free-photo/pharmacists-showing-medicine-bottle-discussing-prescription-drug-pharmacy_8087-2630.jpg);background-repeat: no-repeat;
  
     background-size: 150% 111%;  height: 1100px">
                     <label style="color:#474A8A;font-size:35px;" align = "center">Drug orders</label>

        <div style="background: #B0B3D6; height: 80px;">

                  <button class = "btn btn-primary btn-l" v-on:click = "showAllOrders" style="margin-left:10px; margin-top:20px;background:#474A8A " >List of all drug orders</button>
                  <button class = "btn btn-primary btn-l" v-on:click = "showMyOrders" style="margin-left:10px; margin-top:20px;background:#474A8A " >List of your drug orders</button>

        </div>




 <!--Lista svih narudzbenica -->
<div v-if="showAll">

        <div  style="width:650px;margin-left:420px;margin-top:60px;"  >
                                 <label style="color:#474A8A;font-size:35px;" align = "center">List of all drug orders</label>

                   <form>
                      <table style="background:#B0B3D6;" v-for="d in this.orderdrugs"  v-bind:key="d.idOrder" id="table2" class="table" > 

                       <tbody>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Drug order</td>   
    </tr>  
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Order items:</td>   
       <td>
           <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "stavke(d.idOrder)" >Show</button>
     </td>  
    </tr>
     <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Time limit:</td>   
       <td>{{d.timeLimit| formatDate}}</td>  
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Offers:</td>   
       <td>
           <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "ponude(d.idOrder)" >Show</button>
     </td>  
    </tr>
   

 
  </tbody>
</table>
                                   </form>
      


        </div>
        </div>





 <!--Lista mojih narudzbenica -->
<div v-if="showMyAll">

        <div  style="width:650px;margin-left:420px;margin-top:60px;"  >
                                 <label style="color:#474A8A;font-size:35px;" align = "center">List of your drug orders</label>
                                 <label style="color:#474A8A;font-size:35px;" align = "center">You can accept any of the offers for your order</label>

                                  


                   <form>
                      <table style="background:#B0B3D6;" v-for="d in this.myOrders"  v-bind:key="d.idOrder" id="table2" class="table" > 

                       <tbody>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Drug order</td>   
    </tr>  
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Order items:</td>   
       <td>
           <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "stavkeMoje(d.idOrder)" >Show</button>
     </td>  
    </tr>
     <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Time limit:</td>   
       <td>{{d.timeLimit| formatDate}}</td>  
    </tr>
    <tr style="font-size:22px;color:#0D184F;">
      <th></th>
      <td >Offers:</td>   
       <td>
           <button class="btn btn-info" style="background: #474A8A;color:white" type="button" v-on:click = "ponudeMoje(d.idOrder)" >Show</button>
     </td>  
    </tr>
   

 
  </tbody>
</table>
                                   </form>
      


        </div>
        </div>








<!--Order Item--->
        <div v-if="showItem" style="width:500px;margin-left:420px;margin-top:60px;"  >
                   <form>
                      <table style="background:#B0B3D6;" v-for="d in this.orderitems"  v-bind:key="d.id" id="table2" class="table" > 

                       <tbody>
                           <tr style="font-size:22px;color:#0D184F;">
                        <th></th>
                        <td>Drug</td>
                        
                        <td> {{d.drug.name}}</td>
                        
                        </tr>
               <tr style="font-size:22px;color:#0D184F;">
                        <th></th>
                        <td>Quantity</td>
                        
                        <td> {{d.quantity}}</td>
                        
                        </tr>
                        <tr>
      </tr>
                                               </tbody>

       </table>
                  <button class="btn btn-info" style="background: #474A8A;color:white;margin-left:50px;" type="button" v-on:click = "back" >Back</button>

                   </form>
        </div>





<!--offers--->
        <div v-if="showOffer" style="width:500px;margin-left:420px;margin-top:60px;"  >
                   <form>
                      <table style="background:#B0B3D6;" v-for="d in this.offers"  v-bind:key="d.id" id="table2" class="table" > 

                       <tbody>
                             <tr style="font-size:22px;color:#0D184F;">
                                <th></th>
                                <td >Offer</td>   
                                </tr>
                           <tr style="font-size:22px;color:#0D184F;">
                        <th></th>
                        <td>Price</td>
                         <td> {{d.price}}</td>
                        
                        </tr>
               <tr style="font-size:22px;color:#0D184F;">
                        <th></th>
                        <td>Delivery date</td>
                        
                        <td> {{d.deliveryDate | formatDate}}</td>
                        
                        </tr>
                        <tr>
      </tr>
                                               </tbody>

       </table>
                  <button class="btn btn-info" style="background: #474A8A;color:white;margin-left:50px;" type="button" v-on:click = "back" >Back</button>

                   </form>

 
 
 
                       
        </div>


<!--moje offers--->
        <div v-if="showMyOffer" style="width:500px;margin-left:420px;margin-top:60px;"  >
                   <form>
<div v-for="d in this.offers"  v-bind:key="d.id">
                      <table style="background:#B0B3D6;"  id="table2" class="table" > 

                       <tbody>
                             <tr style="font-size:22px;color:#0D184F;">
                                <th></th>
                                <td >Offer</td>   
                                </tr>
                           <tr style="font-size:22px;color:#0D184F;">
                        <th></th>
                        <td>Price</td>
                         <td> {{d.price}}</td>
                        
                        </tr>
               <tr style="font-size:22px;color:#0D184F;">
                        <th></th>
                        <td>Delivery date</td>
                        
                        <td> {{d.deliveryDate | formatDate}}</td>
                        
                        </tr>
                        <tr>

                           
      </tr>

                                               </tbody>


       </table>
                                      <button class="btn btn-info" style="background: #474A8A;color:white;margin-left:10px;" type="button" v-on:click = "accept(d.idOffer)" >Accept</button>
                                                                   <button class="btn btn-info" style="background: #474A8A;color:white;margin-left:50px;" type="button" v-on:click = "back" >Back</button>

</div>

                   </form>

 
 
 
                       
        </div>



   </div>
</template>

<script>
export default {
  data() {
    return {
        orderdrugs:{},
        orderitems:{},
        showAll:true,
        showItem:false,
        showOffer:false,
        showMyOffer:false,
        showMyAll:false,
        id : this.$route.params.id,

        offers:{},
        myOrders:{}



    }
  },
  
  mounted() {
      this.axios.get('/drugOrder/findAll',{ 
             
         }).then(response => {
               this.orderdrugs=response.data;


         }).catch(res => {
                       alert("ne valja.");
                       console.log(res);
        });

         this.axios.get('/drugOrder/findAllByAdmin/'+this.id,{ 
                
            }).then(response => {
                this.myOrders=response.data;
              
            }).catch(res => {
                        alert("ne valja.");
                        console.log(res);
            });
            
    
                            
                 
},
  methods:{

        stavke: function(data){


                this.showAll = false;
                this.showItem = true;
                this.showOffer = false;
                this.showMyAll=false;
                this.showMyOffer=false;


                this.axios.get('/drugOrder/findOrderItem/'+data,{ 
                       
                            }).then(response => {
                                this.orderitems=response.data;

                            }).catch(res => {
                                        alert("ne valja.");
                                        console.log(res);
                            });


      },
      stavkeMoje: function(data){
                this.showAll = false;
                this.showItem = true;
                this.showOffer = false;
                this.showMyAll=false;
                this.showMyOffer=false;


                this.axios.get('/drugOrder/findOrderItem/'+data,{ 
                       
                            }).then(response => {
                                this.orderitems=response.data;

                            }).catch(res => {
                                        alert("ne valja.");
                                        console.log(res);
                            });


      },
      ponudeMoje: function(data){
                this.showAll = false;
                this.showItem = false;
                this.showMyOffer = true;
                this.showMyAll=false;
                this.showOffer=false;


                this.axios.get('/offer/findOfferByIdOrder/'+data,{ 
                       
                            }).then(response => {
                                this.offers=response.data;

                            }).catch(res => {
                                        alert("ne valja.");
                                        console.log(res);
                            });


      },
      
      ponude: function(data){
                this.showAll = false;
                this.showItem = false;
                this.showOffer = true;
                this.showMyOffer=false;
                this.showMyAll=false;

                this.axios.get('/offer/findOfferByIdOrder/'+data,{ 
                       
                            }).then(response => {
                                this.offers=response.data;

                            }).catch(res => {
                                        alert("ne valja.");
                                        console.log(res);
                            });


      },
      accept: function(data){
                

                this.axios.get('/offer/chooseOffer/'+data+'/'+this.id,{ 
                       
                            }).then(response => {
                                this.offers=response.data;
                                alert("Offer is accept!");

                            })
                                            .catch(response => {
                                                alert(response.response.data.message);
                                                    console.log(response);
                                            }); 


      },

      
      showAllOrders: function(){
        this.showAll=true,
        this.showItem=false,
        this.showOffer=false,
        this.showMyAll=false
        this.showMyOffer=false
      },
      showMyOrders: function(){
                this.showMyAll=true,
                this.showAll=false,
                this.showItem=false,
                this.showOffer=false
                this.showMyOffer=false
            
      },
      
      back: function(){
        this.showAll=true,
        this.showItem=false,
        this.showOffer=false ,
        this.showMyAll=false   ,
        this.showMyOffer=false
        
        
      },

      
      
}
}
</script>

<style>
.tab{
    width : 5px;
}
</style>


  