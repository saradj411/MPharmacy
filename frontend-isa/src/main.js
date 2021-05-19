import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from './App.vue'

import router from './router'
import 'chart.js'
//import 'hchs-vue-charts'

//Vue.use(window.VueCharts)

Vue.config.productionTip = false
Vue.use(VueAxios, axios)
const baseURL = 'http://localhost:8083';
if (typeof baseURL !== 'undefined') {
  Vue.axios.defaults.baseURL = baseURL;
}
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
