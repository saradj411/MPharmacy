import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import Login from '../components/Login.vue'
import createDrugPage from '../components/createDrugPage.vue'
import Registration from '../components/Registration.vue'
import HomePagePatient from '../components/HomePagePatient.vue'
import ProfileAdmin from '../components/ProfileAdmin.vue'
import ProfilePatient from '../components/ProfilePatient.vue'
import updatePharmacyProfile from '../components/updatePharmacyProfile.vue'
import UpdatePatientProfil from '../components/UpdatePatientProfil.vue'
import AddAllergies from '../components/AddAllergies.vue'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import profileDermatologist from '../components/profileDermatologist.vue'
import profilePharmacist from '../components/profilePharmacist.vue'
import DermatologistsPharmacy from '../components/DermatologistsPharmacy.vue'
import PharmacistsPharmacy from '../components/PharmacistsPharmacy.vue'
import DrugPricelist from '../components/DrugPricelist.vue'
import DrugsPharmacy from '../components/DrugsPharmacy.vue'
import updateMyProfile from '../components/updateMyProfile.vue'
import updateDrug from '../components/updateDrug.vue'
import updatePharmacistProfile from '../components/updatePharmacistProfile.vue'
import updateDermatologistProfile from '../components/updateDermatologistProfile.vue'
import DermatologistPatients from '../components/DermatologistPatients.vue'
import RequestForVacation from '../components/RequestForVacation.vue'
import CreatePurchaseOrder from '../components/CreatePurchaseOrder.vue'
import SearchUser from '../components/SearchUser.vue'
import WorkCalendar from '../components/WorkCalendar.vue'
import StartExamination from '../components/StartExamination.vue'
import SystemAdminProfile from '../components/SystemAdminProfile.vue'
import AddShifarnikPage from '../components/AddShifarnikPage'
import RegisterNewSystemAdmin from '../components/RegisterNewSystemAdmin'
import moment from 'moment'

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
    },
    {
        path: '/Home/:id',
        name: 'Home',
        component: Home
      
      },
      {
        path: '/createDrugPage/:id',
        name: 'createDrugPage',
        component: createDrugPage
      },
      {
        path: '/ProfileAdmin',
        name: 'ProfileAdmin',
        component: ProfileAdmin
      }
      ,
      {
        path: '/ProfilePatient',
        name: 'ProfilePatient',
        component: ProfilePatient
      }
    ,
     
      {
        path: '/SystemAdminProfile',
        name: 'SystemAdminProfile',
        component: SystemAdminProfile
      },
      {
        path: '/updatePharmacyProfile/:id',
        name: 'updatePharmacyProfile',
        component: updatePharmacyProfile
      },
      {
        path: '/UpdatePatientProfil/:id',
        name: 'UpdatePatientProfil',
        component: UpdatePatientProfil
      },
     
      
      {

        path: '/profileDermatologist',
        name: 'profileDermatologist',
        component: profileDermatologist
      },
      {
        path: '/profilePharmacist',
        name: 'profilePharmacist',
        component: profilePharmacist
      },
      {
        path: '/login',
        name: 'Login',
        component: Login
      },
      {
        path: '/registration',
        name: 'Registration',
        component: Registration
      },
      {
        path: '/DermatologistsPharmacy/:id',
        name: 'DermatologistsPharmacy',
        component: DermatologistsPharmacy
      }
      ,
      {
        path: '/AddShifarnikPage',
        name: 'AddShifarnikPage',
        component: AddShifarnikPage
      },
      {
        path: '/PharmacistsPharmacy/:id',
        name: 'PharmacistsPharmacy',
        component: PharmacistsPharmacy
      },
      {
        path: '/DrugPricelist/:id',
        name: 'DrugPricelist',
        component: DrugPricelist
      },
      {
        path: '/DrugsPharmacy/:id',
        name: 'DrugsPharmacy',
        component: DrugsPharmacy
      },
      {
        path: '/updateMyProfile/:id',
        name: 'updateMyProfile',
        component: updateMyProfile
      }
      ,
      {
        path: '/updateDrug/:id',
        name: 'updateDrug',
        component: updateDrug
      },{
        path: '/AddAllergies/:id',
        name: 'AddAllergies',
        component: AddAllergies

      },
      {
        path: '/HomePagePatient/:id',
        name: 'HomePagePatient',
        component: HomePagePatient

      },
      {
        path: '/updatePharmacistProfile/:id',
        name: 'updatePharmacistProfile',
        component: updatePharmacistProfile

      }
      ,
      {
        path: '/updateDermatologistProfile/:id',
        name: 'updateDermatologistProfile',
        component: updateDermatologistProfile
      }
      ,
      {
        path: '/DermatologistPatients/:id',
        name: 'DermatologistPatients',
        component: DermatologistPatients
      },
      {
        path: '/RequestForVacation/:id',
        name: 'RequestForVacation',
        component: RequestForVacation
      }
      ,
      {
        path: '/CreatePurchaseOrder/:id',
        name: 'CreatePurchaseOrder',
        component: CreatePurchaseOrder
      }
      ,
      {
        path: '/SearchUser',
        name: 'SearchUser',
        component: SearchUser
      }
      ,
      {
        path: '/WorkCalendar/:id',
        name: 'WorkCalendar',
        component: WorkCalendar
      }
      
      ,
      {
        path: '/StartExamination/:id',
        name: 'StartExamination',
        component: StartExamination
      },
      {
        path:'/RegisterNewSystemAdmin',
        name: 'RegisterNewSystemAdmin',
        component: RegisterNewSystemAdmin
      }

     
      
    ]



    
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
    
  })
  
  export default router