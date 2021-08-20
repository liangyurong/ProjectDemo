<template>

  <transition name="modal-fade">
    <el-container class="modal-backdrop">
      <div>
        <label>{{childOfId}}</label>
        <el-button @click="close">关闭</el-button>
      </div>
    </el-container>
  </transition>

</template>

<script>
  export default {
    name: 'modal',
    props: {
      childOfId: {
        type: String,
      }
    },
    data:function(){
      return{
      }
    },
    methods: {
      // 传递给父组件去关闭
      close() {
        this.$emit('close');
      },
    },
  };
</script>

<style>

  /** 模态框样式 */
  .modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.6);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index:999 !important;  /** 当该模态框出现的时候，置于最顶层*/
  }

  .modal-fade-enter, .modal-fade-leave-to {
    opacity: 0;
  }
  .modal-fade-enter-active, .modal-fade-leave-active {
    transition: opacity .5s ease;
  }

</style>
