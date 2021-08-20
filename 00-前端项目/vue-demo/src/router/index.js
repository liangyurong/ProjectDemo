import Vue from 'vue'
import Router from 'vue-router'
import demo from '@/components/demo'
import demo1 from '@/模板语法/demo1'

import test1 from '@/class与style绑定/test1'

import myradio from '@/v-for删除自定义组件/myradio'
import mysurvey from '@/v-for删除自定义组件/mysurvey'

import bindtest1 from '@/v-bind与v-on/bindtest1'
import vontest1 from '@/v-bind与v-on/vontest1'

import listtest1 from '@/列表渲染/listtest1'
import listtest2 from '@/列表渲染/listtest2'

import if1 from '@/条件渲染/if1'

import radio1 from '@/子组件修改值后向父组件传值/radio1'
import checkbox1 from '@/子组件修改值后向父组件传值/checkbox1'
import parent1 from '@/子组件修改值后向父组件传值/parent1'

import child11 from '@/通过点击按钮触发子组件向父组件传值/child11'
import parent11 from '@/通过点击按钮触发子组件向父组件传值/parent11'

import child12 from '@/子组件调用父组件的方法/child12'
import parent12 from '@/子组件调用父组件的方法/parent12'

import child13 from '@/子组件获取父组件数据/child13'
import parent13 from '@/子组件获取父组件数据/parent13'

import testdraggable from '@/拖曳组件/testdraggable'

import radiotest1 from '@/element/radiotest1'
import disableRadio from '@/element/disableRadio'

import date1 from '@/日期/date1'
import date2 from '@/日期/date2'

import form1 from '@/表单/form1'

import compute1 from '@/计算属性和监视/compute1'

import getheightauto from '@/浏览器相关/getheightauto'


import modal from '@/模态框-子组件获取父组件传值/modal'
import tousemodal from '@/模态框-子组件获取父组件传值/tousemodal'

import tableandpage from '@/table/tableandpage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/demo',
      name: 'demo',
      component: demo
    },
    {
      path: '/demo1',
      name: 'demo1',
      component: demo1
    },
    {
      path: '/test1',
      name: 'test1',
      component: test1
    },
    {
      path: '/myradio',
      name: 'myradio',
      component: myradio
    },
    {
      path: '/mysurvey',
      name: 'mysurvey',
      component: mysurvey
    },
    {
      path: '/bindtest1',
      name: 'bindtest1',
      component: bindtest1
    },
    {
      path: '/vontest1',
      name: 'vontest1',
      component: vontest1
    },
    {
      path: '/listtest1',
      name: 'listtest1',
      component: listtest1
    },
    {
      path: '/listtest2',
      name: 'listtest2',
      component: listtest2
    },
    {
      path: '/radio1',
      name: 'radio1',
      component: radio1
    },
    {
      path: '/checkbox1',
      name: 'checkbox1',
      component: checkbox1
    },
    {
      path: '/parent1',
      name: 'parent1',
      component: parent1
    },
    {
      path: '/child11',
      name: 'child11',
      component: child11
    },
    {
      path: '/parent11',
      name: 'parent11',
      component: parent11
    },
    {
      path: '/child12',
      name: 'child12',
      component: child12
    },
    {
      path: '/parent12',
      name: 'parent12',
      component: parent12
    },
    {
      path: '/child13',
      name: 'child13',
      component: child13
    },
    {
      path: '/parent13',
      name: 'parent13',
      component: parent13
    },
    {
      path: '/testdraggable',
      name: 'testdraggable',
      component: testdraggable
    },
    {
      path: '/date1',
      name: 'date1',
      component: date1
    },
    {
      path: '/date2',
      name: 'date2',
      component: date2
    },
    {
      path: '/if1',
      name: 'if1',
      component: if1
    },
    {
      path: '/form1',
      name: 'form1',
      component: form1
    },
    {
      path: '/compute1',
      name: 'compute1',
      component: compute1
    },
    {
      path: '/radiotest1',
      name: 'radiotest1',
      component: radiotest1
    },
    {
      path: '/disableRadio',
      name: 'disableRadio',
      component: disableRadio
    },
    {
      path: '/getheightauto',
      name: 'getheightauto',
      component: getheightauto
    },
    {
      path: '/modal',
      name: 'modal',
      component: modal
    },
    {
      path: '/tousemodal',
      name: 'tousemodal',
      component: tousemodal
    },
    {
      path:'/tableandpage',
      name:'tableandpage',
      component:tableandpage
    },
  ]
})
