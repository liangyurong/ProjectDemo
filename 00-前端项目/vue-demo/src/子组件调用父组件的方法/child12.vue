<template>
    <div>
        <button @click="sunBtn()">点击</button>
    </div>
</template>

<script>
export default {
  name: 'child12',
  props: {
    fatherMethod: {
      type: Function,
      default: null
    }
  },
  methods: {
    sunBtn: function () {
        this.fatherMethod()
    }
  }
}
</script>

<style scoped>

</style>
