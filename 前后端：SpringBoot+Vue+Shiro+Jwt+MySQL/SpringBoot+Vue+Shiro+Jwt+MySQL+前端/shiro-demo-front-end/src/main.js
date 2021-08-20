import Vuex from 'vuex'         //引入状态管理
import Vue from 'vue'           // vue 模块在 node_modules 中
import router from './router'   // router 即 router 文件夹里定义的路由
import App from './App.vue'     // App 即 App.vue 里定义的组件
import axios from 'axios'       // 异步请求
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from "./store";    // 存储token需要用到的

Vue.use(Vuex) ;
Vue.use(ElementUI);
Vue.config.productionTip = false;                   // 作用是阻止vue 在启动时生成生产提示。
Vue.prototype.$axios = axios;                       // 全局注册，使用方法为:this.$axios
axios.defaults.baseURL = 'http://localhost:8074';   // 配置请求的基础路径， 之后在axios的请求路径中就没必要添加

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store:store, // 存储token需要用到的
  components: { App },
  template: '<App/>'
});

/**
 * 路径拦截
 */


/**
 * 添加请求拦截器，在请求头中加token
 */
axios.interceptors.request.use(
  config => {
    if (localStorage.getItem('Authorization')) {
      console.log("有token");
      config.headers.Authorization = localStorage.getItem('Authorization');
    }else {
      console.log("没有token");
    }
    return config;
  },
  error => {
    return Promise.reject(error);
});


