

<!--

目的：当我们在显示答卷的时候，可以让用户看到自己的问卷，但是不能修改自己的答卷。

做法1：使用disable，但是会变成透明的样式，不好看。

做法2：使用 style="pointer-events: none;" 。让鼠标失去焦点不能进行点击。

-->

<template>
  <el-radio-group v-model="radioGroup">
    <el-radio :label="1" style="pointer-events: none;">单选1</el-radio>
    <el-radio :label="2">单选2</el-radio>
    <el-radio :label="3">单选3</el-radio>
    <el-radio :label="4">单选4</el-radio>
  </el-radio-group>
</template>

<script>
  export default {
    name: 'disableRadio',
    data:{
      radioGroup:1
    }
  }
</script>

<style scoped>

</style>
