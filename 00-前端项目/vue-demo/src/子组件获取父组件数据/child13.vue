<!--

-->
<template>
    <div>
      <label style="width: 100px">{{dataOfChild}}</label>
    </div>
</template>

<script>
export default {
  name: 'child13',
  props: {   //子组件通过props来接收父组件传来的值
    dataOfChild: { //还可设置传递过来的类型和默认值等(此例子中规定默认值为：默认值,类型为String)
      type: String
    }
  },
}
</script>

