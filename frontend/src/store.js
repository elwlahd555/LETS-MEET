import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

const axios = require('axios');

export const store = new Vuex.Store({
  state: {
    uEmail: null,
    uName: null,
    isLogin: false,
    counter: 0
  },
  mutations: {
    SET_USER_AUTH_DATA(state, payload){
      state.isLogin = true;
      state.uEmail = payload['uEmail']
      state.uName = payload['uName']
    },
    SET_USER_AUTU_DATA_LOGOUT(state) {
      state.isLogin = false;
      state.uEmail = null
      state.uName = null
    }
  },
  actions: {
    LOGIN (context, user) {
      return axios
      .post(`http://localhost:8000/letsmeet/login`, user)
      .then((res) => {
        alert('로그인 되었습니다.')
        context.commit('SET_USER_AUTH_DATA', res.data)
        let token = res.data['auth-token']
        localStorage.setItem('auth-token', token)
        // axios default 헤더에 현재 token 적재
        axios.defaults.headers.common[
            'auth-token'
          ] = window.localStorage.getItem("auth-token");  
      })
    },
    LOGOUT(context) {
      context.commit('SET_USER_AUTU_DATA_LOGOUT')
      localStorage.removeItem('auth-token')
    }
    },
});