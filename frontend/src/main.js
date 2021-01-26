import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import { store } from "./store"
import router from './routes'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueGeolocationApi from 'vue-geolocation-api'
import 'bootstrap-css-only/css/bootstrap.min.css'
import 'mdbvue/lib/css/mdb.min.css'
import '@fortawesome/fontawesome-free/css/all.min.css'


Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(VueGeolocationApi/*, { ...options } */)
Vue.config.productionTip = false

new Vue({
  vuetify,
  store: store,
  router, 
  render: h => h(App)
}).$mount('#app')
