<!--

知识点-props
1.子组件有一个特殊的属性props，专门用来定义父组件传递下来的参数，并且传递下来的参数只能是只读。
2.如果修改了父组件传递的值，会发生什么呢？

知识点
1.子组件中可读可写的数据只能是子组件的data定义的数据。

操作说明：
1.父组件将dataOfparent的值传递给组件的dataOfChild
2.子组件通过props获取到父组件传递的值
3.父组件传值方式：v-bind

-->

<template>
    <div>
        <child13 v-bind:dataOfChild="dataOfParent"></child13>
    </div>
</template>

<script>

import child13 from '@/子组件获取父组件数据/child13'

export default {
  name: 'parent13',
  data:function(){
    return {
      dataOfParent: '我是父组件的值'
    }
  },
  components: {
    child13
  }
}
</script>

