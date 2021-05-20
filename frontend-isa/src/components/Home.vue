<template>

  <div id="registration">
        
        <p>jhsjasjha</p>
  <div class = "col md-8">
        

        <div class = "container" v-if="welcomePageShow">
                          <h1 style="font-size:50px;font-weight:bold;" align = "center">{{pharmacy.name}}</h1>

      
      <div class="row" style = "margin: auto;">
                    <div style="font-size:25px;" class="row">Ocjena: {{pharmacy.avgGrade}}</div>
        </div>
        <div class="row" style = "margin: auto;">
                        <h3 style="font-size:25px;" align = "center">O nama:</h3>
                    <div style="font-size:30px;">{{pharmacy.description}}</div>
        </div>
             
        </div>
        <div>
            <button name="dodaj lijek"></button>

        </div>


</div>

    </div>
</template>

<script>
export default {
  data() {
    return {
      
       id : this.$route.params.id,
       pharmacy : [],
       
       welcomePageShow : true
       
       
       
    }
  },
  mounted() {
        this.axios.get('/pharmacy/findById/'+this.id)
        .then(response => {
                this.pharmacy = response.data;
                 
       
         }).catch(res => {
                alert("Ne valja");
                console.log(res);
        });
       
    }
     ,
      methods:{
    
      
      }
   
}

</script>