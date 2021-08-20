<template>
    <div>
        <div>
            <span>checkbox-title:</span><input v-model="title">
        </div>
    </div>

</template>

<script>
export default {

  name: 'checkbox',

  // 子组件通过props接收父组件传递的值
  props: {
    valueSentToChild: {
      type: Object
    },
    index: {
      type: Number
    }
  },

  data: function () {
    return {
      title: this.valueSentToChild.title,
    }
  },

  watch: {
    title: function () {
      // 向父组件传值(只要title变化了，就能够向父组件传值)
      this.$emit('sentDataToFather', this.index, this.title)
    }
  }

}
</script>
