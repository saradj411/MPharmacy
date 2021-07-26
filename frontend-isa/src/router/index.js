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
import RequestForVacation from '../components/RequestForVacation.vue'
import CreatePurchaseOrder from '../components/CreatePurchaseOrder.vue'
import SearchUser from '../components/SearchUser.vue'
import WorkCalendar from '../components/WorkCalendar.vue'
import StartExamination from '../components/StartExamination.vue'
import AnnualReport from '../components/AnnualReport.vue'
import QuarterReport from '../components/QuarterReport.vue'
import QuarterReportDrug from '../components/QuarterReportDrug.vue'
import AnnualReportDrug from '../components/AnnualReportDrug.vue'
import MonthDrugReport from '../components/MonthDrugReport.vue'
import MonthExaminationReport from '../components/MonthExaminationReport.vue'
import IncomeReport from '../components/IncomeReport.vue'
import SheduleExamination from '../components/SheduleExamination.vue'
import WorkCalendarPharmacist from '../components/WorkCalendarPharmacist.vue'
import StartCounseling from '../components/StartCounseling.vue'
import SearchUserPharmacist from '../components/SearchUserPharmacist.vue'
import Clients from '../components/Clients.vue'
import ReviewedClientsDermatologist from '../components/ReviewedClientsDermatologist.vue'
import ReviewedClientsPharmacist from '../components/ReviewedClientsPharmacist.vue'
import RequestForVacationPharmacist from '../components/RequestForVacationPharmacist.vue'
import InssuingDrug from '../components/InssuingDrug.vue'
import SystemAdminProfile from '../components/SystemAdminProfile.vue'
import AddShifarnikPage from '../components/AddShifarnikPage'
import RegisterNewSystemAdmin from '../components/RegisterNewSystemAdmin'
import ReserveDrug from '../components/ReserveDrug'
import RegisterDermatologist from '../components/RegisterDermatologist'
import RegisterNewPharmacy from '../components/RegisterNewPharmacy'
import RegisterAdminPharamcyPage from '../components/RegisterAdminPharamcyPage'
import AcceptRejectVacation from '../components/AcceptRejectVacation'
import CreatePricelist from '../components/CreatePricelist'
import UpdatePricelist from '../components/UpdatePricelist'
import ActionAndPromotion from '../components/ActionAndPromotion'
import DrugOrders from '../components/DrugOrders'
import Report from '../components/Report'

import AddPharmacist from '../components/AddPharmacist'
import AddDermatologist from '../components/AddDermatologist'

import WriteComplaint from '../components/WriteComplaint.vue'
import RegisterNewSupplier from '../components/RegisterNewSupplier'
import SupplierHomePage from '../components/SupplierHomePage'
import Complains from '../components/Complains'

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
        path: '/ProfileAdmin/:id',
        name: 'ProfileAdmin',
        component: ProfileAdmin
      }
      ,
      {
        path: '/ProfilePatient/:id',
        name: 'ProfilePatient',
        component: ProfilePatient
      }
    ,
     
      {
        path: '/SystemAdminProfile/:id',
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
        path: '/StartCounseling/:id',
        name: 'StartCounseling',
        component: StartCounseling
      },
     
      
      {

        path: '/profileDermatologist/:id',
        name: 'profileDermatologist',
        component: profileDermatologist
      },
      {

        path: '/SearchUserPharmacist/:id',
        name: 'SearchUserPharmacist',
        component: SearchUserPharmacist
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
        path: '/AddShifarnikPage/:id',
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
        path: '/SearchUser/:id',
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
        path: '/WorkCalendarPharmacist/:id',
        name: 'WorkCalendarPharmacist',
        component: WorkCalendarPharmacist
      }
      
      ,
      {
        path: '/StartExamination/:id',
        name: 'StartExamination',
        component: StartExamination
      },
      {
        //registracija admina za apoteke
        path:'/RegisterAdminPharamcyPage/:id',
        name: 'RegisterAdminPharamcyPage',
        component: RegisterAdminPharamcyPage
      },
      {
        path: '/RegisterDermatologist/:id',
        name: 'RegisterDermatologist',
        component: RegisterDermatologist
      },      
      {
        //registracija nove apoteke
        path: '/RegisterNewPharmacy/:id',
        name: 'RegisterNewPharmacy',
        component: RegisterNewPharmacy
      },               
      {
        //registracija nove apoteke
        path: '/RegisterNewSystemAdmin/:id',
        name: 'RegisterNewSystemAdmin',
        component: RegisterNewSystemAdmin
      },
      {
        path:'/ReserveDrug/:id/:idPatient',
        name: 'ReserveDrug',
        component: ReserveDrug
      }
      ,
      {
        path: '/SheduleExamination/:id',
        name: 'SheduleExamination',
        component: SheduleExamination
      },
      {
        path: '/Clients',
        name: 'Clients',
        component: Clients
      }
      ,
      {
        path: '/ReviewedClientsDermatologist/:id',
        name: 'ReviewedClientsDermatologist',
        component: ReviewedClientsDermatologist
      }
      ,
      {
        path: '/ReviewedClientsPharmacist/:id',
        name: 'ReviewedClientsPharmacist',
        component: ReviewedClientsPharmacist
      },
      {
        path: '/RequestForVacationPharmacist/:id',
        name: 'RequestForVacationPharmacist',
        component: RequestForVacationPharmacist
      },
      {
        path: '/InssuingDrug/:id',
        name: 'InssuingDrug',
        component: InssuingDrug
      },
      {
        path: '/AcceptRejectVacation/:id',
        name: 'AcceptRejectVacation',
        component: AcceptRejectVacation
      }
      ,
      {
        path: '/CreatePricelist/:id',
        name: 'CreatePricelist',
        component: CreatePricelist
      },
      {
        path: '/UpdatePricelist/:id',
        name: 'UpdatePricelist',
        component: UpdatePricelist
      }
      ,
      {
        path: '/ActionAndPromotion/:id',
        name: 'ActionAndPromotion',
        component: ActionAndPromotion
      }
      ,
      {
        path: '/DrugOrders/:id',
        name: 'DrugOrders',
        component: DrugOrders
      },
      {
        path: '/Report/:id',
        name: 'Report',
        component: Report
      }
      
,{      
        path: '/AnnualReport/:id',
        name: 'AnnualReport',
        component: AnnualReport
      },
      {
        path: '/QuarterReport/:id',
        name: 'QuarterReport',
        component: QuarterReport
      }
      ,
      {
        path: '/QuarterReportDrug/:id',
        name: 'QuarterReportDrug',
        component: QuarterReportDrug
      },
      {
        path: '/AnnualReportDrug/:id',
        name: 'AnnualReportDrug',
        component: AnnualReportDrug
      },
      {
        path: '/MonthDrugReport/:id',
        name: 'MonthDrugReport',
        component: MonthDrugReport
      },
      {
        path: '/MonthExaminationReport/:id',
        name: 'MonthExaminationReport',
        component: MonthExaminationReport
      },
      {
        path: '/IncomeReport/:id',
        name: 'IncomeReport',
        component: IncomeReport
      },
      {
        path: '/AddPharmacist/:id',
        name: 'AddPharmacist',
        component: AddPharmacist
      },
      {
        path: '/AddDermatologist/:id',
        name: 'AddDermatologist',
        component: AddDermatologist
      },{
        path: '/WriteComplaint/:id',
        name: 'WriteComplaint',
        component: WriteComplaint
      },
      {
        path: '/RegisterNewSupplier/:id',
        name: 'RegisterNewSupplier',
        component: RegisterNewSupplier
      },
      {
        path: '/SupplierHomePage/:id',
        name: 'SupplierHomePage',
        component: SupplierHomePage

      },
      {
        path: '/Complains/:id',
        name: 'Complains',
        component: Complains

      }

      
      


    ]
    
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
    
  })
  
  export default router
