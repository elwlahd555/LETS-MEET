import Vue from "vue"
import VueRouter from "vue-router"
import Main from '@/views/main/Main'
import Login from '@/views/user/Login'
import Signup from './views/user/Signup'
import MakeMeeting from '@/views/makemeeting/MakeMeeting'

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
        path : '/makemeeting',
        name : 'MakeMeeting',
        component : MakeMeeting
    },
    {   
        path: '/signup',
        name: 'Signup',
        component: Signup
    }
  ]
  
  const router = new VueRouter({
    base: process.env.BASE_URL,
    // mode: 'history',
    routes
  })

export default router
