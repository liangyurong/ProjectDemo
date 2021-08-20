<!--

什么是计算属性？

根据set和get方法，可以实现数据的双向绑定

-->


<template>

    <div>
        姓氏：<input type="text" v-model="firstName"><br>
        名字：<input type="text" v-model="lastName"><br>

        单项绑定：<input type="text" v-model="fullName"><br>

        使用双括号调用：<p>{{fullName}}</p><br>

        使用computed双向绑定firstName：<input type="text" v-model="firstNameCom"><br>
        使用computed双向绑定lastName：<input type="text" v-model="lastNameCom"><br>

    </div>

</template>

<script>
export default {
  name: 'test1',

  data () {
    return {
      firstName: '我的姓氏',
      lastName: '你的名字',
    }
  },
  methods: {},
  computed: {
    firstNameCom: { //双向绑定
      get () {
        return this.firstName
      },
      set (val) {
        this.firstName = val
      }
    },
    lastNameCom: { //双向绑定
      get () {
        return this.lastName
      },
      set (val) {
        this.lastName = val
      }
    },
    fullName:function () {
        return this.firstName+" "+this.lastName;
    }
  }

}
</script>

<style scoped>

</style>
