import Vue from "vue";
import VueRouter from "vue-router";
import Main from './views/main/Main.vue'
import Login from './views/user/Login.vue'
export default [

    {
        path : '/',
        name : 'Login',
        component : Login
    },  
    {
        path : '/main',
        name : 'Main',
        component : Main
    },
]
