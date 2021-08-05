<template>
<div>
<button class="btn btn-dark" style="width:50%; margin-bottom:10px; margin-top:-60px;" v-on:click = "goBack"> Back to home page </button>  
    <h2> Add point to over examintaions: </h2>
    <h5> There are just examinations without points. </h5>
    <table  class="table table-bordered">
    <tr>
        <th scope="col"> Date of over examination </th>
        <th scope="col"> Patient </th>
        <th scope="col"> Points </th>
        <th scope="col"> Type of examination </th>
        <th scope="col"> Patient type </th>
    </tr>
    <tr v-for="overE in this.overExamination" v-bind:key="overE.idExamination" scope="row">    
        <td> {{overE.date[2]}}.{{overE.date[1]}}.{{ overE.date[0] }}</td>
        <td> {{overE.patient.name}} {{overE.patient.surname}}</td>
        <!--<td scope="col" ><input class="form-control" type="text" v-model="overE.pointsForExamination"></td>-->
        <td scope="col"><input type="text" class="form-control" v-model="overE.pointsForExamination"></td>
        <td> <p v-if="overE.type === 'DERMATOLOGIST_EXAMINATION'"> Dermatologist examintaion</p> <p v-if="overE.type ===  'PHARMACIST_EXAMINATION'"> Pharmacist examintaion </p></td>
        <td>{{ overE.patient.loyaltyCategory }}</td>
        <td scope="col" ><button class="btn btn-dark" style="width:100%;" v-on:click = "changePoints(overE.idExamination, overE.pointsForExamination)"> Set points </button> </td>
    </tr>
    </table >

    <h2> Change loyality scale for users: </h2> 
    <table class="table table-bordered"> 
    <tr scope="row"> 
        <th scope="col"> Name</th>
        <th scope="col">Points lower than </th>
        <th scope="col"> How many percent lower price </th>
    </tr> 

    <tr scope="row"> 
        <td scope="col"> Bronze points: </td>
        <td scope="col"> <input class="form-control" type="text" v-model="bronzePoint"></td>
        <td scope="col"> <input class="form-control" type="text" v-model="bronzePercent"  placeholder="%"></td>
    </tr>
     <tr scope="row"> 
        <td scope="col"> Silver points: </td>
        <td scope="col"> <input class="form-control" type="text" v-model="silverPoint"></td>
        <td scope="col"> <input class="form-control" type="text" v-model="silverPercent"  placeholder="%"></td>
    </tr>
     <tr scope="row"> 
        <td scope="col"> Gold points: </td>
        <td scope="col"> <input class="form-control" type="text" v-model="goldPoint" ></td>
        <td scope="col"> <input class="form-control" type="text" v-model="goldPercent" placeholder="%"> </td>
    </tr>
    <tr scope="row">
    <td scope="col"></td>
    <td scope="col"> <button class="btn btn-dark" style="width:100%;" v-on:click = "saveNewLoyalityProgram">Save new loyality program</button> </td>
    <td scope="col"></td>
    </tr>
    </table>

</div>
</template>

<script>
export default
{
    data()
    {
         return{
            overExamination: [],
            bronzePoint: "",
            bronzePercent: "",
            silverPercent: "",
            silverPoint: "",
            goldPercent: "",
            goldPoint:"",
            poeni:0,
            id: this.$route.params.id
        }

    },
    methods:
    {
        goBack: function()
        {
            window.location.href = '/SystemAdminProfile/' + this.id;
        },
         getAllOverExamination: function()
        {
            this.axios.get('/examination/getAllOverExamination',{
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response => 
                {
                  this.overExamination = response.data;                                     
                }).catch(res => {
                    if(localStorage.getItem('accessToken') === null)
                    {
                        alert("Please login again.");
                         window.location.href = '/login';
                    }
                    else
                    {
                        console.log(res.response.data.message);
                        alert("Greska. Mozda nemate pristup ovoj stranici!");
                    }
                   
                    
                });  
        },
        saveNewLoyalityProgram: function()
        {
            console.log("AA");
            const loyalityInfo = 
            {
                pointsToRegular: this.bronzePoint,
                pointsToSilver: this.silverPoint,
                pointsToGold: this.goldPoint,
                percentBronse: this.bronzePercent,
                percentSilver: this.silverPercent,
                percentGold: this.goldPercent,
            };


            this.axios.post('/loyality/save', loyalityInfo, {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response =>{
                          console.log(response.data);  
                          this.bronzePercent = "";
                          this.bronzePoint = "";
                          this.silverPercent = "";
                          this.silverPoint = "";
                          this.goldPercent = "";
                          this.goldPoint = "";
                          alert("Successeffully defined loyality program.");                          
                }).catch(res => {
                    if(localStorage.getItem('accessToken') === null)
                    {
                        alert("Please login again.");
                         window.location.href = '/login';
                    }
                    else
                    {
                        console.log(res.response.data.message);
                        alert("Greska. Mozda nemate pristup ovoj stranici!");
                    }
                   
                    
                }); 


        },
        changePoints: function(idEx,pointsForExamination)
        {
            console.log(idEx);
            console.log(pointsForExamination);

            const examPoint = 
            {
                idExamination: idEx,
                points: pointsForExamination
            }

            this.axios.post('/examination/saveExamPoints', examPoint, {
                headers: 
                {
                    'Authorization': `Bearer ` + localStorage.getItem('accessToken')
                }}).then(response =>                 {
                          console.log(response.data);  
                          this.getAllOverExamination();  
                                                 
                }).catch(res => {
                    if(localStorage.getItem('accessToken') === null)
                    {
                        alert("Please login again.");
                         window.location.href = '/login';
                    }
                    else
                    {
                        console.log(res.response.data.message);
                        alert("Greska. Mozda nemate pristup ovoj stranici!");
                    }
                   
                    
                }); 
                

        },
       



    },
     mounted()
    {
        this.getAllOverExamination(); 
    }

}


</script>