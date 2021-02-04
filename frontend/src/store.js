import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import createPersistedState from 'vuex-persistedstate'
export const store = new Vuex.Store({
  plugins: [
    // storage 에 넣어준당
    createPersistedState()
  ],
  state: {
    uEmail: null,
    uName: null,
    isLogin: false,
  },
  // getters: {
  //   get_user_name(state){
  //     return state.uName
  //   },
  //   get_user_email(state){
  //     return state.uEmail
  // }
  mutations: {
    SET_USER_AUTH_DATA(state, payload){
      state.isLogin = true;
      state.uEmail = payload['uEmail']
      state.uName = payload['uName']
    },
    SET_USER_AUTU_DATA_LOGOUT(state) {
      state.isLogin = false;
      state.email = null
      state.name = null
    }
  },
  actions: {
    
    // LOGIN (context, user) {
    //   return axios
    //   .post(`http://localhost:8000/letsmeet/login`, user)
    //   .then((res) => {
    //     let token = res.data['auth-token']
    //     if (token === undefined) {
    //       alert('비밀번호가 틀렸습니다.')
    //     }
    //     else {
    //       alert('로그인 되었습니다.')
    //       context.commit('SET_USER_AUTH_DATA', res.data)
    //       localStorage.setItem('auth-token', token)
    //       // axios default 헤더에 현재 token 적재
    //       axios.defaults.headers.common['auth-token'] = window.localStorage.getItem("auth-token");
    //       return true
    //     }
    //   })
    LOGOUT(context) {
      context.commit('SET_USER_AUTU_DATA_LOGOUT')
      localStorage.removeItem('auth-token')
    }
    },
});