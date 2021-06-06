import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import App from './App.vue'
//import VueCharts from 'hchs-vue-charts'

import router from './router'
import 'chart.js'
import 'hchs-vue-charts'
import vuetify from './plugins/vuetify';

//https://www.youtube.com/watch?v=kXVvkWjL0ek


Vue.use(window.VueCharts)
//Vue.use(VueCharts) //bilo windows.

Vue.config.productionTip = false

Vue.use(VueAxios, axios)
const baseURL = 'http://localhost:8083';
if (typeof baseURL !== 'undefined') {
  Vue.axios.defaults.baseURL = baseURL;
}
new Vue({
  router,
  vuetify,
  render: h => h(App),
}).$mount('#app')
