
<template>

    <!-- 日期格式 xxxx-xx-xx xx:xx:xx  -->
    <div>
        <p>调用data的方法,获取当前时间戳:{{getNowTime()}}</p>
    </div>

</template>

<script>
export default {
  name: 'date2',
  data:function() {
    return {
      msg: 'hello,yurong333'
    }
  },
  methods: {
    getNowTime: function () {
      const today = new Date();
      const date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
      const time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      const dateTime = date +' '+ time;
      this.timestamp = dateTime;
      return this.timestamp;
    }
  }

}
</script>

<style scoped>

</style>
