
<!--

myradio.vue和mysurvey.vue是一起工作的

介绍：mysurvey每次可以

作用：每次删除只是删除对应的一个组件

如果没有设置唯一的myid，那么每次删除，就会把最后的一个组件给删除.(myid的设置只是提供了一个思路)

-->

<template>
    <div>
        <div>
            <button v-on:click="addNewRadio">addNewRadio</button>
        </div>
        <hr>
         <div v-for="(item,index) in radioComponents" :key="item.myid">
             <li v-bind:is="item.myComponent"></li>
             <button v-on:click="delRadio(index)">delRadio</button>
             <hr>
         </div>
    </div>
</template>

<script>

import myradio from '@/v-for删除自定义组件/myradio'

export default {
  name: 'mysurvey',
  components: {
    myradio
  },
  data () {
    return {
      radioComponents: [
      ]
    }
  },
  methods: {
    addNewRadio:function(){
      let size = new Date().getTime();
      var json={
        myid:size,
        myComponent:myradio
      };
      this.radioComponents.push(json);
    },
    delRadio:function (index) {
      this.radioComponents.splice(index, 1);
    }
  }

}
</script>

<style scoped>

</style>
