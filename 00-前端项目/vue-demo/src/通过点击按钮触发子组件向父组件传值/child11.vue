<template>
    <div>
        <button @click="sendDataToParent">向父组件传值</button>
    </div>
</template>

<script>
export default {
  name: 'child11',
  data(){
    return{
      childdata:'childOfData'
    }
  },
  methods:{
    sendDataToParent(){
      //$emit（even,value）even 是一个函数，value 是传给父组件的值
      this.$emit('send',this.childdata)
    }
  }
}
</script>
