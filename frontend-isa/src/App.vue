<template>
  <div id="app">
    <!--<img alt="Vue logo" src="./assets/logo.png">!-->
    <content transition="slide-x-transition">
            <router-view></router-view>
        </content>
   <!-- <HelloWorld msg="Welcome to Your Vue.js App"/>!-->
  </div>
</template>
<!-- 
<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>
!-->
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #500c45ab;
  margin-top: 60px;
}

#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #502c2c;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
