import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'

Vue.use(VueRouter)

const routes = [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome
    } ,
    {
        path: '/Home/:id',
        name: 'Home',
        component: Home
      }
    ]
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })
  
  export default router