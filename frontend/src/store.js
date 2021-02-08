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
    uImageid: null,
    uNo: null,
    uSalt: null,
  },
  mutations: {
    SET_USER_AUTH_DATA(state, payload){
      state.isLogin = true;
      state.uEmail = payload['uEmail']
      state.uName = payload['uName']
      state.uNo = payload['uNo']
      state.uImageid = payload['uImageId']
      state.uSalt = payload['uSalt']
      console.log(state.uSalt)
    },
    SET_USER_AUTH_DATA_LOGOUT(state) {
      state.isLogin = false
      state.email = null
      state.name = null
      state.uNo = null
      state.uImageid= null
      state.uSalt = null
    },
    SET_USER_NAME(state, uName) {
      state.uName = uName
    },
    SET_USER_IMAGE(state, uImageid) {
      state.uImageid = uImageid
    }

  },
  actions: {
    FETCH_USER_NAME(context, uName){
      context.commit('SET_USER_NAME', uName)
    },
    FETCH_USER_IMAGE(context, uImageid){
      context.commit('SET_USER_IMAGE', uImageid) 
    },
    LOGOUT(context) {
      context.commit('SET_USER_AUTH_DATA_LOGOUT')
      localStorage.removeItem('auth-token')
    },
    DELETE_ACCOUNT(context) {
      context.commit('SET_USER_AUTH_DATA_LOGOUT')
      localStorage.removeItem('auth-token')
    }
    }
});