

<template>
  <div>
    <div>{{drag?'拖拽中':'拖拽停止'}}</div>
    <!--使用draggable组件-->
    <draggable v-model="myArray"  chosenClass="chosen" forceFallback="true" group="people" animation="1000" @start="onStart" @end="onEnd">
      <transition-group>
        <div class="item" v-for="element in myArray" :key="element.id">{{element.name}}</div>
      </transition-group>
    </draggable>

    <button v-on:click="showall">显示所有</button>

  </div>
</template>

<style scoped>
  /*被拖拽对象的样式*/
  .item {
    padding: 6px;
    background-color: #fdfdfd;
    border: solid 1px #eee;
    margin-bottom: 10px; /** 定义上下之间的距离 */
    cursor: move;
  }
  /*选中样式*/
  .chosen {
    border: solid 2px #3089dc !important;
  }
</style>

<script>
  //导入draggable组件
  import draggable from 'vuedraggable'
  export default {
    name:'testdraggable',
    //注册draggable组件
    components: {
      draggable,
    },
    data:function(){
      return {
        drag:false,
        //定义要被拖拽对象的数组
        myArray:[
          {people:'cn',id:1,name:'www.itxst.com'},
          {people:'cn',id:2,name:'www.baidu.com'},
          {people:'cn',id:3,name:'www.taobao.com'},
          {people:'us',id:4,name:'www.google.com'}
        ]
      };
    },
    methods: {
      //开始拖拽事件
      onStart:function (){
        this.drag=true;
      },
      //拖拽结束事件
      onEnd:function (){
        this.drag=false;
      },
      showall:function () {
        let len=this.myArray.length;
        for (let i = 0; i < len; i++) {
          console.log(this.myArray[i].people+" "+this.myArray[i].id+" "+this.myArray[i].name);
        }
      }
    },
  };
</script>
