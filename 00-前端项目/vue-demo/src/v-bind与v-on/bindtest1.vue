
<!--

知识点
1、本小节知识点主要是v-bind的应用。
2、button本身具有title属性，如果想要双向绑定某个数据，比如绑定buttonValOne，可以使用v-bind:title来绑定某个值。
3、如果只是单纯将某个属性值显示在按钮上，比如buttonValTwo，则使用{{buttonValTwo}}。本质是在标签内部显示某个属性值。

:data="" 等同于 v-bind:date=""

-->

<template>
    <div>
        <button v-bind:title="buttonValOne">将鼠标放到按钮上，可现实title的属性值</button>
        <button>{{buttonValTwo}}</button>
    </div>
</template>

<script>
export default {
  name: 'bindTest1',
  data () {
    return{
      buttonValOne:'helloworld',
      buttonValTwo:'hello',
    }
  },
  methods: {

  },
  computed:{

  }

}
</script>

<style scoped>

</style>
