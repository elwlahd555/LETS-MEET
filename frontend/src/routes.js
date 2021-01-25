import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from './views/main/Main.vue'
import Login from './views/user/Login.vue'
import Signup from './views/user/Signup.vue'


Vue.use(VueRouter)

const routes = [
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
    {   
        path: '/signup',
        name: 'Signup',
        component: Signup
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
