import Vue from "vue"
import VueRouter from "vue-router"
import Main from '@/views/main/Main'
import Login from '@/views/user/Login'
import KakaoCallback from '@/views/user/KakaoCallback'
import Signup from '@/views/user/Signup'
import { store } from "./store"
import MyPage from '@/views/user/MyPage';
import UserInfoChange from '@/views/user/UserInfoChange';
import MakeMeeting from '@/views/makemeeting/MakeMeeting'
import MeetingRoom from '@/views/meetingroom/MeetingRoom'

Vue.use(VueRouter)
Vue.use(store)

const onlyAuthUser = function usercheck (to, from, next){
    if (store.state.isLogin === false) {
        alert('로그인이 필요한 페이지입니다.')
        router.push({ name: 'Login'});
    } else {
        next();
    }
}

const routes = [
    {
        path : '/login',
        name : 'Login',
        component : Login
    },  
    {
        path : '/main',
        name : 'Main',
        beforeEnter: onlyAuthUser,
        component : Main,
    },
    {
        path : '/makemeeting',
        name : 'MakeMeeting',
        beforeEnter: onlyAuthUser,
        component : MakeMeeting
    },
    {   
        path: '/signup',
        name: 'Signup',
        component: Signup
    },
    {   
        path: '/mypage',
        name: 'MyPage',
        beforeEnter: onlyAuthUser,
        component : MyPage,
        // component: () => import('@/views/user/MyPage.vue')
    },
    {
        path: '/userinfochange',
        name: 'UserInfoChange',
        beforeEnter: onlyAuthUser,
        component: UserInfoChange
    },
    {
        path: '/kakaocallback',
        name: 'KakaoCallback',
        component: KakaoCallback
    },
    { 
        path: '/meetingroom/:id', 
        name: 'MeetingRoom',
        beforeEnter: onlyAuthUser,
        component: MeetingRoom,
        props: true
    }
  ]
  
  const router = new VueRouter({
    base: process.env.BASE_URL,
    // mode: 'history',
    routes
  })

export default router
