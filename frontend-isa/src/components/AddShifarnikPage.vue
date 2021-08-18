<template>
    <div >
     <div class="sifarnikHolder">
     <button class="btn btn-dark" style="width:50%; margin-bottom:10px; margin-top:-60px;" v-on:click = "goBack"> Back to home page </button>  
     <h3>New Sifarnik: </h3>
     <br>
     <h4>About Drug: </h4>
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
                     <td> <h4> Code: </h4> </td>
                     <td>
                     <input type="text" v-model="code" :class="{'input--error':!code}" class="form-control" placeholder="Enter code"  aria-label="Enter surname" aria-describedby="addon-wrapping">
                     </td>   
                 </tr>
                 <tr>
                     <td> <h4> Recepie needed: </h4> </td>
                     <td>
                     <input type="checkbox" v-model="recepieNeeded"  aria-label="Enter email" aria-describedby="addon-wrapping">
                     </td>   
                 </tr>
                
                 <tr>
                     
                     <td> <h4> Drug type: </h4> </td>
                     <td>
                     <input type="text" v-model="drugType" class="form-control" :class="{'input--error':!drugType}" placeholder="Enter drug type"  aria-label="Enter address" aria-describedby="addon-wrapping">
                     </td>   
                 </tr>
                 <tr><!-- OVO CE BITI DROP DOWN LSTA-->
                     <td> <h4> Format: </h4> </td>
                     <td>
                      <select v-model="format" :select="format" class="form-control" placeholder="Enter phone nubmer">
                        <option value="TABLET"> Tablete </option>
                        <option value="CAPSULE"> Kapsule </option>
                        <option value="GEL"> Gel </option>
                        <option value="CREME"> Krema </option>
                        <option value="VACCINE"> Vakcina </option>
                        <option value="INJECTION"> Injection </option>
                        <option value="LIQUID"> Liquid </option>
                     </select> 
                     </td>   
                 </tr>
 
                  <tr>
                     <td> <h4> Manufacturer: </h4> </td>
                     <td>
                     <input type="text" v-model="manufacturer" :class="{'input--error':!manufacturer}" class="form-control" placeholder="Enter manufacturer"  aria-label="Enter city" aria-describedby="addon-wrapping">
                     </td>   
                 </tr>
                 <tr>
                    <td> <h4> Points: </h4> </td>
                    <td>
                    <input type="text" v-model="points" :class="{'input--error':!points}" class="form-control" placeholder="Enter points"  aria-label="Enter points" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                 <tr>
                    <td> <h4> Napomene: </h4> </td>
                    <td>
                    <input type="text" v-model="napomene" :class="{'input--error':!napomene}" class="form-control" placeholder="Enter napomena."  aria-label="Enter points" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Grade: </h4> </td>
                    <td>
                    <input type="text" v-model="grade" :class="{'input--error':!grade}" class="form-control" placeholder="Enter napomena."  aria-label="Enter points" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td> <h4> Alternatives: </h4> </td>
                    <td>
                        <multiselect

                        v-model="selected"

                        :multiple="true"

                        :options="alter">

                        </multiselect>

                  
                    </td>   
                </tr>
                 <br>
                 <tr>
                     <td  colspan="2"><h4>Specification about drug: </h4></td>
                 </tr>
                 <br>
                  <tr>
                     <td> <h4> Contraindications: </h4> </td>
                     <td>
                     <input type="text" v-model="contraindications" :class="{'input--error':!contraindications}"  class="form-control" placeholder="Enter contraindications"  aria-label="Enter phone nubmer" aria-describedby="addon-wrapping">
                     </td>   
                 </tr>
                  <tr>
                     <td> <h4> Structure: </h4> </td>
                     <td>
                     <input type="text" id="structure" v-model="structure" :class="{'input--error':!structure}" class="form-control" placeholder="Enter structure"  aria-label="Enter password" aria-describedby="addon-wrapping">
                     </td>   
                 </tr>
                  <tr>
                     <td> <h4> Recommended Dose: </h4> </td>
                     <td>
                     <input type="text" v-model="recommendedDose" :class="{'input--error':!recommendedDose}" class="form-control" placeholder="Enter recommendedDose"  aria-label="Enter password" aria-describedby="addon-wrapping">
                     </td>   
                 </tr>
                 <tr>
                    <td> <h4> Ingredients: </h4> </td>
                    <td>
                    <input type="text" v-model="ingredients" :class="{'input--error':!ingredients}" class="form-control" placeholder="Enter ingredients"  aria-label="Enter password" aria-describedby="addon-wrapping">
                    </td>   
                </tr>

                
                 <tr>
                     <td colspan="2">
                         <div id="errorMessage" > 
                         </div >
                         
                         
                     </td>
                 </tr>
                 <tr>        
                     <td colspan="2">
                         <button class = "btn btn-primary btn-xs" :disabled="!name || !code || !drugType || !format || !manufacturer || !contraindications
                         || !structure || !recommendedDose || !ingredients || !napomene || !grade"   style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" v-on:click="addShifarnik">Confirm</button>
                     
                     </td>
                 <!--
                 
                 
                 -->
                 </tr>
             </table>
         </div>
     </div>
 </div>
 </template>

 <style scoped>
    *
    {
        margin: 0 auto;
    }
    .sifarnikHolder
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
<script>
import { required } from 'vuelidate/lib/validators'
import Multiselect from 'vue-multiselect'

export default{
     components: { Multiselect },
    data()
    {
        return{
            name : "",
            code : "",
            recepieNeeded : false,
            drugType : "",
            format : "",
            manufacturer : "",

            contraindications : "",
            structure : "",
            recommendedDose : "",
            ingredients : "",
            points:"",
            alter: [],

            accessToken: localStorage.getItem('accessToken'),
            expiresIn: localStorage.getItem('expiresIn'),
            id : this.$route.params.id,
            selected: null,
            idAlternative: [],
            alternative:[],
            napoemen:"",
            grade: 0,

            
            

        }
    },
    validations:
    {
        name : {
            required            
        },
        code : {
            required            
        },        
        format : {
            required            
        },
        manufacturer : {
            required            
        },
        contraindications : {
            required            
        },
        structure : {
            required            
        },
        recommendedDose : {
            required            
        },
        ingredients:
        {
            required 
        }


    },

    methods:
    { 
        goBack: function()
        {
            window.location.href = '/SystemAdminProfile/' + this.id;
        },
        addShifarnik : function()
        {    
            //console.log(this.selected);
            this.selected.forEach(value => 
            {
                var part = value.split(':'); 
                this.idAlternative.push(part[0]);

            })
             console.log(this.idAlternative);
            const drugAndSpecInfo = 
            {
                name : this.name,
                code : this.code,
                recepieNeeded : this.recepieNeeded,
                drugType : this.drugType,
                format : this.format,
                manufacturer :this.manufacturer,
                points: this.points,
                alternatives: this.idAlternative,

                contraindications : this.contraindications,
                structure : this.structure,
                recommendedDose : this.recommendedDose,
                ingredients : this.ingredients,
                napomene: this.napomene,
                grade: this.grade
            }    
            var accessToken = localStorage.getItem('accessToken');
            console.log(drugAndSpecInfo);  
            
           this.axios.post('drug/addDrugAndSpecification', drugAndSpecInfo ,
            {
                
                headers: 
                {
                    'Authorization': `Bearer ` + accessToken
                    
                }}).then(response => 
                {                  
                    console.log(response);
                    alert("Drug and specification are successeffully added!");                                               
                   window.location.href = '/SystemAdminProfile/'+this.id;
                    
                    //Odkomentarisati ovo kad se obavi verifikacija mejla
                }).catch(res => {
                    console.log("Nije uzeo token..");
                    alert(res.response.data.message);
                });    

            }
            

              
        
    },
    mounted()
    {
        var accessToken = localStorage.getItem('accessToken');
        //console.log(accessToken.substr(1).slice(0, -1));

        
            this.axios.get('/drug/alternative',
            {
                headers: 
                {
                    'Authorization': `Bearer ` + accessToken
                }}).then(response => 
                {
                    this.alternative = response.data;
                    response.data.forEach( value => 
                    {
                        
                        this.alter.push(value.idDrug +": " +value.name);  
                    });

                    
                }).catch(res => {
                    alert(res.response.data.message);
                }); 


        
    },
    
}  
</script>
<style src="vue-multiselect/dist/vue-multiselect.min.css">