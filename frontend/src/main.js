import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import { store } from "./store"
import router from './routes'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueGeolocationApi from 'vue-geolocation-api'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)
Vue.use(VueGeolocationApi/*, { ...options } */)
Vue.config.productionTip = false

new Vue({
  vuetify,
  router,
  store: store,
  router, 
  render: h => h(App)
}).$mount('#app')
