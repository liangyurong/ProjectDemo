<!--
当watch的是一个Object类型的数据，如果这个对象内部的某个值发生了改变，并不会触发watch动作！
watch默认情况下，不监测内部嵌套数据的变动。但是很多情况下，我们是需要监测的！



-->

<template>
    <div>
        <div>
            <span>radio-title</span><input v-model="title">
        </div>
    </div>

</template>

<script>
export default {
  name: 'radio',
  props: {  //要让子组件使用父组件的数据，需要通过子组件的 props 选项
    valueSentToChild: {
      type: Object,
    },
    index: {
      type: Number
    }
  },
  data: function () { //组件的data必须是一个函数，这样子每个组件才能单独拥有一份data的独立拷贝
    return {
      title: this.valueSentToChild.title // 将父组件中的title数据传递给子组件的title属性
    }
  },
  watch: { //watch是监视数据的变化，一旦有变化，就触发下面的方法，将子组件的数据传递给父组件
    title: function () {
      this.$emit('sentDataToFather',this.index,this.title); // 将子组件的数据传递给父组件.
    }
  }
}
</script>

<style scoped>

</style>
