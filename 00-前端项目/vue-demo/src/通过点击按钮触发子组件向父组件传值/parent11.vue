<!--

子组件向父组件传值-通过点击按钮触发。

1.子组件通过this.$emit方法向父组件传递childdata,触发的时间是send方法
2.父组件监听子组件触发的send事件，然后调用父组件自身的parentMethod方法

缺点：需要点击按钮才能去获取子组件的数值

-->


<template>
    <div>
        <!--监听子组件触发的事件-->
        <child11 v-on:send = "parentFunction"></child11>
    </div>
</template>

<script>

import child11 from '@/通过点击按钮触发子组件向父组件传值/child11'

export default {
  name: 'parent11',
  components:{
    child11
  },
  methods: {
    parentFunction(msg){
      console.log('子组件传过来的值是：',msg)
    }
  }
}
</script>

