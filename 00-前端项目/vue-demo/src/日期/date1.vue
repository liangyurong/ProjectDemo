<!--

知识点：日期表达式

-->

<template>
    <div>
        <h2>显示日期的时间</h2>
        <p>{{nowDate}}</p>
    </div>
</template>

<script>

let moment = require("moment")// 引入moment

export default {

  name: 'date1',

  data:function() {
    return {
      nowDate:new Date().getTime()// 获取时间戳
    }
  },
  created(){
    // 定义日期格式
    this.nowDate = moment(this.nowDate).format('YYYY-MM-DD HH:mm:ss')
    // this.nowDate = moment(this.nowDate).format('YYYY-MM-DD')
  },
  methods: {
  },
  computed: {}

}
</script>

<style scoped>

</style>
