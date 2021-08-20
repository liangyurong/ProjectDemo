<!--

computed 计算属性示例

v-bind 强制数据绑定

v-bind: 可以直接使用: 代替

绑定事件监听

-->
<template>

    <div>
        <h2>双大括号表达式:{{msg}}</h2>
        <h2>双大括号表达式:{{msg.toUpperCase()}}</h2> <!-- 大写 -->

        <p>调用data的方法,获取当前时间戳:{{getNowTime()}}</p>


        <p>使用在线图片1</p><img v-bind:src="imgUrl"  height="50" width="50">   <!--需要使用v-bind:来修饰src,如果单纯使用src，则不能加载图-->
        <p>使用在线图片2</p><img :src="imgUrl" height="50" width="50">  <!-- 省略表达也是可以的，比如 :src -->

        <!--  绑定事件监听，使用v-on  -->
        <br>
        <button v-on:click="test1">按钮1</button>

        <!--  绑定事件监听，可以使用@click代替v-on:click  -->
        <br>
        <button @click="test4">按钮4</button>

        <!--  绑定事件监听，使用v-on，可以设定弹出的字符串  -->
        <br>
        <button v-on:click="test2('弹出这个字符串')">按钮2</button>

        <!--  绑定事件监听，使用v-on ，可以弹出data里面的数据 -->
        <br>
        <button v-on:click="test3(msg)">按钮3</button>

    </div>

</template>

<script>
export default {
  name: 'demo1',
  data () {
    return {
      msg: 'hello,yurong333',
      imgUrl:'https://vue3js.cn/docs/logo.png'
    }
  },
  methods: {
    getNowTime: function () { //返回当前时间 ，格式为xxxx-xx-xx xx:xx:xx
      const today = new Date();
      const date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
      const time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      const dateTime = date +' '+ time;
      this.timestamp = dateTime;
      return this.timestamp;
    },
    test1:function () {
       alert("hei!!!羽绒111")
    },
    test2:function (content) {
      alert(content)
    },
    test3:function (content) {
      alert(content)
    },
    test4:function () {
      alert("hei!!!yurong444")
    }

  }

}
</script>

<style scoped>

</style>
