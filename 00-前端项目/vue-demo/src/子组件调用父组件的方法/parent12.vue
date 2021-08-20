
<!--

父组件把方法传入子组件中，在子组件里直接调用这个方法

然后直接在父组件中点击按钮，就能够调用相关的父组件方法了

-->


<template>

    <div>
        <child12 v-bind:fatherMethod="print" ></child12>
    </div>

</template>

<script>
import child12 from '@/子组件调用父组件的方法/child12'
export default {
  name: 'parent12',
  components:{
    child12
  },
  methods:{
    print:function () {
      console.log("子组件调用父组件的方法");
    }
  }

}
</script>

<style scoped>

</style>
