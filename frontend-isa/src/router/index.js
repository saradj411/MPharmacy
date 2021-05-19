import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import createDrugPage from '../components/createDrugPage.vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'


Vue.use(VueRouter)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

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
      },
      {
        path: '/createDrugPage',
        name: 'createDrugPage',
        component: createDrugPage
      }
    ]


const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })
  
  export default router