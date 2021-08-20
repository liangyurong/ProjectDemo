<!--

v-bind:label="",里面不能是字母，不知道为什么

-->

<template>
  <div>

    <el-button @click="test">test</el-button>
    <el-radio-group v-model="radioGroup" @change="changeHandler">
      <el-radio v-bind:label='1'>单选1</el-radio>
      <el-radio v-bind:label="2">单选2</el-radio>
      <el-radio v-bind:label='3'>单选3</el-radio>
      <el-radio v-bind:label='4'>单选4</el-radio>
    </el-radio-group>

  </div>
</template>

<script>
  export default {
    name: 'radiotest1',
    data: function () {
      return {
        radioGroup: '1' // v-model 绑定的值，这个值是label里的内容，表示默认选中的值
      }
    },
    methods: {
      test: function () {
        console.log(this.radioGroup)
      },
      changeHandler: function (value) {
        console.log(value)
      }
    },
    computed: {},
    mounted () {
    }

  }
</script>

<style scoped>

</style>


