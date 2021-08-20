<!-- <transition> 过渡动画 -->
<template>
  <div id="app">
    <button @click="showModal">Open Modal!</button>
    <modal v-bind:childOfId="parentOfId"  v-show="isModalVisible" @close="closeModal" ></modal>
  </div>
</template>

<script>

  import modal from '@/模态框-子组件获取父组件传值/modal'

  export default {
    name: 'tousemodal',
    components: {
      modal,
    },
    data:function () {
      return {
        isModalVisible: false,
        parentOfId: '112358',
      }
    },
    methods: {
      showModal () {
        this.isModalVisible = true
      },
      closeModal () {
        this.isModalVisible = false
      },

    },
  }
</script>


