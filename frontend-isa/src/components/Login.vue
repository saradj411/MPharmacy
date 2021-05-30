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
                        <input type="text" v-model="email" class="form-control" placeholder="Enter email" aria-label="Enter name" aria-describedby="addon-wrapping">
                        
                    </td> 
                        
                </tr>
                <tr>
                    <td> <h4> Password: </h4> </td>
                    <td>
                    <input type="password" v-model="Password" class="form-control" placeholder="Enter name"  aria-label="Enter name" aria-describedby="addon-wrapping">
                    </td>   
                </tr>
                <tr>
                    <td colspan="2"><label id="errorMessage" /></td>
                </tr>
                <tr>        
                    <td colspan="2">
                        <button class = "btn btn-primary btn-xs" style="margin:auto; margin-left:38px;background: #000;margin-top: 10px; width: 200px;" >Submit</button>
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
    .loginHolder
    {
        margin: 0 auto;
        margin-top: 50px;
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