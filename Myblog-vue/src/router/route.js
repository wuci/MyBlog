import BdSearch from '@/components/BdSearch'
import Company from '@/components/company/Company'
import Login from '@/components/Login'
import BlogIndex from '@/components/blog/BlogIndex'
import Index from '@/components/blog/Index'
import About from '@/components/blog/About'
import GrowUp from '@/components/blog/GrowUp'
import Study from '@/components/blog/Study'
import LeaveMessage from '@/components/blog/LeaveMessage'
import Css from '@/components/blog/study/Css'
import Java from '@/components/blog/study/Java'
import Javascript from '@/components/blog/study/Javascript'
import SpringBoot from '@/components/blog/study/SpringBoot'
import VuePage from '@/components/blog/study/VuePage'
import MobileIndex from '@/components/MobileIndex'
const route = [{
    path: '/',
    name: 'BdSearch',
    component: BdSearch
  }, {
    path: '/company',
    name: 'company',
    component: Company
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },{
    path:'/mobile',
    name: 'mobile',
    component: MobileIndex
  } ,{
    path: '/blog',
    name: 'BlogIndex',
    component: BlogIndex,
    meta: {
      allowBack: false,
      title: 'MC博客首页'
    },
    children: [{
        path: 'index',
        name: 'index',
        component: Index
      },
      {
        path: 'about',
        name: 'About',
        component: About
      }, {
        path: 'growUp',
        name: 'GrowUp',
        component: GrowUp
      }, {
        path: 'Css',
        name: 'Css',
        component: Css
      }, {
        path: 'Java',
        name: 'Java',
        component: Java
      }, {
        path: 'Javascript',
        name: 'Javascript',
        component: Javascript
      }, {
        path: 'SpringBoot',
        name: 'SpringBoot',
        component: SpringBoot
      }, {
        path: 'VuePage',
        name: 'VuePage',
        component: VuePage
      }, {
        path: 'leaveMessage',
        name: 'LeaveMessage',
        component: LeaveMessage
      }
    ]
  }
]
export default route
