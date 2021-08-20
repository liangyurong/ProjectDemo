<!--

v-for
    1.后端返回数据，前端可以使用v-for进行获取

实现：
    1.遍历数组
    2.遍历对象

vue的splice方法，可以实现增删改三个操作

-->


<template>
    <div>

        <!--<ul>和<li>标签：将 <ul> 标签与 <li> 标签一起使用，创建无序列表。-->
        <ul>
            <li v-for="(p,index) in persons" :key="index">
                姓名： {{p.name}}  年龄： {{p.age}}
                <button @click="deletePerson(index)">删除</button>
                <button @click="updatePerson(index,{name:'cat',age:999})">更新</button>
            </li>
        </ul>

        <!--在数组中的某个位置获取对象-->
        <ul>
             <li v-for="(value,key) in persons[2]" :key="value">
                {{key}} : {{value}}
             </li>
        </ul>

        <!--循环获取到对象的属性-->
        <ul>
            <li v-for="(value,key) in student" :key="value">
                {{key}} : {{value}}
            </li>
        </ul>

        <!--循环获取到返回的信息-->
        <ul>
            <li v-for="(value,key) in result" :key="value">
                {{key}} : {{value}}
            </li>
        </ul>

    </div>
</template>

<script>
export default {
  name: 'test4',
  data:function(){ //可以使用后端返回的数据代替
    return {
      persons: [  //数组。vue本身只是监视了persons数组本身的变化，没有监视数组内部数据的改变
        {name: '小明', age: 11},
        {name: '小花', age: 22},
        {name: '小红', age: 33},
        {name: '小垃圾', age: 44}
      ],
      student:{
        name:"对象名字",
        age:"对象年龄",
        password:"123456"
      },
      result:{
        code:0,
        msg:"成功，您获取到了我的信息",
        data:{
          "name": "丁丽",
          "idNo": "511323198808313068"
        }
      }
    }
  },
  methods:{
    deletePerson:function (index) {
      //从persons数组中删除指定index位置的person
      this.persons.splice(index,1);
    },
    updatePerson:function (index,newPerson) {//从persons数组中更新指定index位置的person
      // this.persons[index]=newPerson; //并没有改变person本身，因此数据没有刷新
      this.persons.splice(index,1,newPerson);
    }
  }
}
</script>

<style scoped>

</style>
