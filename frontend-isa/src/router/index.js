import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import createDrugPage from '../components/createDrugPage.vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import profileDermatologist from '../components/profileDermatologist.vue'
import profilePharmacist from '../components/profilePharmacist.vue'

Vue.use(VueRouter)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.filter('formatDate', function(value) {
  if (value) {
      return moment(String(value)).format('DD/MM/YYYY')
  }
});
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
      ,
      {
        path: '/profileDermatologist',
        name: 'profileDermatologist',
        component: profileDermatologist
      },
      {
        path: '/profilePharmacist',
        name: 'profilePharmacist',
        component: profilePharmacist
      }
    ]


const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
  })
  
  export default router