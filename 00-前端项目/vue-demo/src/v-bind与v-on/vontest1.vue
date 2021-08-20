<!--

v-on
    1.绑定事件监听器。事件类型由参数指定。表达式可以是一个方法的名字或一个内联语句，如果没有修饰符也可以省略。
    2.用在普通元素上时，只能监听原生 DOM 事件。用在自定义元素组件上时，也可以监听子组件触发的自定义事件。

v-on:click一般写成@click

-->


<template>
    <div>
        <h2>1、绑定监听</h2>
        <button @click="test1">test1</button>
        <button @click="test2('yurong333')">test2</button>
        <button @click="test3($event)">test3按钮</button>
        <button @click="test4(123,$event)">这是test4按钮</button>

        <h2>2、事件修饰符</h2>
        <div style="width: 200px;height: 200px;background: red;" @click="test5">
            <div style="width: 100px;height: 100px;background: blue;" @click.stop="test6"></div>
            <!--如果不使用@click.stop，则点击里面，弹出inner，再弹出out-->
        </div>

        <!--@click.prevent：阻止跳转事件-->
        <a href="http://www.baidu.com" @click.prevent="test7">阻止点击跳转到百度</a>
        <br>
        <a href="http://www.baidu.com">点击直接跳转到百度</a>

        <h2>3、按键修饰符</h2>
        <input type="text" @keyup="test8">  <!--按enter键才弹出内容-->
        <br>
        <input type="text" @keyup.enter="test9"> <!--不写方法，直接声明按enter，因为你可能记不住enter对应的是什么-->
        <br>
        <input type="text" @keyup.space="test10"> <!--按空格键弹出内容-->

    </div>
</template>

<script>
export default {
  name: 'test6',
  data () {
    return {}
  },
  methods: {
    test1: function () {
      alert('test1')
    },
    test2: function (msg) {
      alert(msg)
    },
    test3: function (event) {
      alert(event.target.innerHTML)//innnerHTML
    },
    test4: function (num, event) {
      alert(num + '==' + event.target.innerHTML)
    },
    test5: function () {
      alert('out')
    },
    test6: function () {
      alert('inner')
    },
    test7: function () {
      alert('您进行了一次点击操作')
    },
    test8: function (event) {
      if(event.keyCode==13){ //enter键对应13
        alert(event.target.value)
      }
    },
    test9: function (event) {
        alert(event.target.value)
    },
    test10: function (event) {
      alert(event.target.value)
    }
  }

}
</script>

<style scoped>

</style>
