import Vue from 'vue'
import Router from 'vue-router'
import route from '@/router/route.js'
import ElementUI from 'element-ui';
import ts from 'tesla-ui'
import 'tesla-ui/dist/index.css'
Vue.use(Router)
Vue.use(ts)
Vue.use(ElementUI)
const router = new Router({
  routes: route,
})
export default router
