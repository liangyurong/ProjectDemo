<!--

列表的搜索和排序

-->

<template>
    <div>

        <!--数组的搜索过滤:根据名字来进行过滤 -->
        <input type="text" v-model="searchName">
        <ul>
            <li v-for="(p,index) in filterPersonsByName" :key="index">
                {{index}}=={{p.name}}=={{p.age}}
            </li>
        </ul>

        <br><br><br>


        <ul>
            <li v-for="(p,index) in sortPersonsByAge" :key="index">
                {{index}}=={{p.name}}=={{p.age}}
            </li>
        </ul>
        <button @click="setOrderType(0)">本来排列排序</button>
        <button @click="setOrderType(1)">根据年龄进行升序排序</button>
        <button @click="setOrderType(2)">根据年龄进行降序排序</button>
    </div>
</template>

<script>
export default {
  name: 'test5',
  data () {
    return {
      searchName: '',
      orderType: 0, //0-原本顺序 1-升序 2-降序
      persons: [  //数组。vue本身只是监视了persons数组本身的变化，没有监视数组内部数据的改变
        {name: '小明123', age: 11},
        {name: '小花333', age: 33},
        {name: '小红135', age: 55},
        {name: '小垃222', age: 22}
      ],
    }
  },
  methods: {
    setOrderType:function (orderType) {
        this.orderType=orderType;
    }
  },
  computed: {
    filterPersonsByName: function () {
      //取出相关数据
      const {searchName, persons} = this
      //最终需要返回的数组
      let fPersons
      //对persons进行过滤
      fPersons = persons.filter(p => p.name.indexOf(searchName) !== -1)  //p.name.indexOf(searchName) 返回searchName在p.name的下标位置，如果不存在则返回-1
      return fPersons
    },
    sortPersonsByAge: function () {
      //取出相关数据
      const {searchName, persons, orderType} = this
      //最终需要返回的数组
      let fPersons
      //对persons进行过滤
      fPersons = persons.filter(p => p.name.indexOf(searchName) !== -1)  //p.name.indexOf(searchName) 返回searchName在p.name的下标位置，如果不存在则返回-1
      //排序
      if (orderType !== 0) {
        fPersons.sort(function (p1, p2) { //返回负数p1在前，返回正数p2在前
          //1-升序 2-降序
          if(orderType===2){
            return p2.age-p1.age;
          }else {
            return p1.age-p2.age;
          }
        })
      }
      return fPersons
    }
  }
}
</script>

<style scoped>

</style>
