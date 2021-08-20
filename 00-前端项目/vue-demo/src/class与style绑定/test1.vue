<!--

class与style的值应该是动态的值。

class与style都是去控制样式的

关于class操作步骤
    1.在vue的组件当中，而不是在html当中
    2.在定义了class之后，需要去<style scoped></style>里面去写样式

关于style的操作
    1.可以直接在标签里面进行操作。
    2.（推荐做法）也可以直接在<style scoped></style>中写。

-->


<template>

<div>

    <!--更改颜色-->
    <p class="classSetColor">这是使用class设置的颜色字体</p><br>

    <p style="color: #42b983">这是使用style设置的颜色字体</p><br>

    <button class="classSetButtonColor" >这是使用class设置的颜色按钮</button><br><br>

    <button style="color: red">这是使用style设置的颜色按钮</button><br>

</div>

</template>

<script>
export default {
  name: 'test',
}
</script>

<style scoped>

 .classSetColor{
     color: red;
 }

 .classSetButtonColor{
     color: blue;
     width: 300px;
     height: 40px;
 }

</style>
