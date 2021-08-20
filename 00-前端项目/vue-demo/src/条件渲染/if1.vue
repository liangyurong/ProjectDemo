<!--
知识点：v-if  v-else  v-show

v-else：里面是不用写条件的
-->
<template>
    <div>

        <!--前端的if else的代码逻辑就是这样-->
        <p v-if="isSussessful">成功</p>
        <p v-else>失败</p>

        <!--一般不会这么使用，只是给个示例-->
        <button @click="isSussessful=!isSussessful">点击按钮，isSussessful的属性将变成相反</button>

        <!--使用v-show的代码示例-->
        <p v-show="isSussessful">成功</p>
        <p v-show="!isSussessful">失败</p>

    </div>
</template>

<script>
export default {
  name: 'if1',
  data: function () {
    return {
      isSussessful: true  // true:显示成功 false：显示失败
    }
  },
  methods () {

  }
}
</script>

<style scoped>

</style>
