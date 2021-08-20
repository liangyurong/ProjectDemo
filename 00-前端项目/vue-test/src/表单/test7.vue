<!--

使用v-model(双向数据绑定)收集表单数据。

功能：填写完之后，点击注册，弹出表单所有内容

-->

<!--

span标签

标签定义及使用说明
    1、<span> 用于对文档中的行内元素进行组合。
    2、<span> 标签没有固定的格式表现。当对它应用样式时，它才会产生视觉上的变化。如果不对 <span> 应用样式，那么 <span> 元素中的文本与其他文本不会任何视觉上的差异。
    3、<span> 标签提供了一种将文本的一部分或者文档的一部分独立出来的方式。
    4、被 <span> 元素包含的文本，您可以使用 000-CSS 对它定义样式，或者使用 JavaScript 对它进行操作。

-->

<template>
    <div id="formDemo">
        <form action="/xxx" @submit.prevent="handleSubmit">
            <span>用户名：</span>
            <input type="text" v-model="username"><br>

            <span>密码：</span>
            <input type="password" v-model="password"><br>

            <span>性别：</span>
            <input type="radio" id="female" value="女" v-model="sex"> <!--给个默认值：女-->
            <label for="female">女</label>
            <input type="radio" id="male" value="男" v-model="sex">
            <label for="male">男</label><br>

            <span>爱好：</span>
            <input type="checkbox" id="basketball" value="篮球" v-model="likes">
            <label for="basketball">篮球</label>
            <input type="checkbox" id="football" value="足球" v-model="likes">
            <label for="football">足球</label>
            <input type="checkbox" id="volleyball" value="排球" v-model="likes">
            <label for="volleyball">排球</label><br>

            <span>城市：</span>
            <select v-model="selectCityId">
                <option value="">未选择</option>
                <option :value="city.id" v-for="(city,index) in allCitys" :key="index">{{city.name}}</option><!--  使用:value，才不会被当做文本，而是被当做id  -->
            </select><br>

            <span>介绍：</span>
            <textarea rows="10" v-model="desc"></textarea><br><br>

            <input type="submit" value="注册">

        </form>
    </div>
</template>

<script>
export default {
  name: 'test7',
  data () {
    return {
      username: '',
      password: '',
      sex: '女', //默认选中女
      likes: [],
      allCitys: [
        {
          id: 1, name: '上海'
        },
        {
          id: 2, name: 'sz'
        },
        {
          id: 3, name: 'beijing'
        },
        {
          id: 4, name: 'gz'
        }
      ],
      selectCityId: '2', //如果希望某个城市被选中，则输入对应的城市id
      desc: ''

    }
  },
  methods: {
    handleSubmit: function () {
      alert(
        this.username+" "+"\n"+
        this.password+" "+"\n"+
        this.sex+" "+"\n"+
        this.likes+" "+"\n"+
        this.selectCityId+" "+"\n"+
        this.desc
      )
    }
  },
  computed: {}

}
</script>

<style scoped>

</style>
