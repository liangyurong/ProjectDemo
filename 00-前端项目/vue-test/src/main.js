// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import moment from 'moment' //导入文件
Vue.prototype.$moment = moment;//赋值使用
moment.locale('zh-cn');//需要汉化

//引入element ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

//引入vuedraggable
import draggable from 'vuedraggable'


Vue.use(ElementUI)
Vue.use(draggable)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
