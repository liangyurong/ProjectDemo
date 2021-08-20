import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router);

import login from '@/components/login'
import index from '@/components/index'
import selectCom from '@/components/select'
import addCom from '@/components/add'
import updateCom from '@/components/update'
import deleteCom from '@/components/delete'

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/index',
      name: 'index',
      component: index
    },
    {
      path: '/select',
      name: 'selectCom',
      component: selectCom
    },
    {
      path: '/add',
      name: 'addCom',
      component: addCom
    },
    {
      path: '/update',
      name: 'updateCom',
      component: updateCom
    },
     {
      path: '/delete',
      name: 'deleteCom',
      component: deleteCom
    }
  ]
});export default router;
