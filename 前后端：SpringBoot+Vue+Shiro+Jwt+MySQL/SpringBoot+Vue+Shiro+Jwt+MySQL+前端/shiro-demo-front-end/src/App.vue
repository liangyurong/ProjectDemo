<template>
  <div id="app">
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
  export default {
    name:'App',
    provide () {
      return {
        reload: this.reload
      }
    },
    data () {
      return {
        isRouterAlive: true
      }
    },
    methods: {
      reload () { // 为了防止页面刷新的时候白屏，特地设置了这个reload方法。只需要在对应的组件里面写上 inject: ['reload']，就可以使用this.reload()
        this.isRouterAlive = false;
        this.$nextTick(function() {
          this.isRouterAlive = true
        })
      }
    },

    //下面是解决刷新页面丢失vuex数据
    mounted() {
      if (window.localStorage.getItem("list") ) {
        this.$store.replaceState(Object.assign({}, this.$store.state,JSON.parse(window.localStorage.getItem("list"))))
      }
      window.addEventListener("beforeunload",()=>{
        window.localStorage.setItem("list",JSON.stringify(this.$store.state))
      })
    }

  };
</script>

<style>
  /** elmentui会默认有一些padding，因此在此设置 */
  body{
    padding: 0;
    margin: 0;
  }

</style>

