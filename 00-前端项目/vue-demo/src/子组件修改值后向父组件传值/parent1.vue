<!--

v-on:getFromChild="getChild",需要放在子组件<radio></radio>才能生效。

下面这种形式是不能生效的。
<div v-bind:mychild="item.com" v-on:getFromChild="getChild"></div>


ref 有三种用法：
　　1、ref 加在普通的元素上，用this.ref.name 获取到的是dom元素
　　2、ref 加在子组件上，用this.ref.name 获取到的是组件实例，可以使用组件的所有方法。
　　3、如何利用 v-for 和 ref 获取一组数组或者dom 节点

v-bind:xxx="XXX" 简写：:xxx="XXX"

-->


<template>
    <div>

        <button @click="addradio">添加radio</button>
        <button @click="addcheckbox">添加checkbox</button>

        <div>
            <div v-for="(item,index) in questions" :key="item.myid">
               <!-- 父组件向子组件传递的数据是valueSentToChild -->
                <radio
                        v-if="item.qutype===0"
                        v-bind:valueSentToChild="item"
                        v-bind:index="index"
                        @sentDataToFather="getTitleFromChild"> //父组件监听子组件的sentDataToFather方法，然后调用自己的getTitleFromChild方法获取到子组件最近更新的值
                </radio>

                <checkbox
                        v-else-if="item.qutype===1"
                        v-bind:valueSentToChild="item"
                        v-bind:index="index"
                        @sentDataToFather="getTitleFromChild">
                </checkbox>
            </div>
        </div>

        <button @click="printAllData">输出所有的组件值</button>

    </div>
</template>

<script>

// 形成父子关系，必须让父组件引入子组件
import radio from '@/子组件修改值后向父组件传值/radio1'
import checkbox from '@/子组件修改值后向父组件传值/checkbox1'

export default {
  name: 'parent1',
  //使用子组件
  components: {
    checkbox,
    radio,
  },
  data: function () {
    return {
      questions: [
        {
          myid: 0,
          qutype: 0,
          title: '初始值title'
        },
        {
          myid: 1,
          qutype: 1,
          title: '初始值title'
        }
      ]
    }
  },
  methods: {
    // 从子组件中获取值
    getTitleFromChild: function (index, data) {
      this.questions[index].title = data
    },
    // 添加一个radio组件
    addradio: function () {
      let size = new Date().getTime()
      var json = {
        myid: size,
        qutype: 0,
        title: '初始值title'
      }
      this.questions.push(json)
    },
    // 添加一个radio组件
    addcheckbox: function () {
      let size = new Date().getTime()
      var json = {
        myid: size,
        qutype: 1,
        title: '初始值title'
      }
      this.questions.push(json)
    },
    // 输出父组件当前所有的组件情况
    printAllData: function () {
      let size = this.questions.length;
      for (let i = 0; i < size; i++) {
        console.log("问题id："+this.questions[i].myid);
        console.log("问题code："+this.questions[i].qutype);
        console.log("问题title："+this.questions[i].title);
      }
    },
  }
}
</script>
