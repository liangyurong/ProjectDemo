<template>
  <el-container>
    <el-form label-width="100px" class="demo-ruleForm">
      <el-form-item label="账户名">
        <el-input v-model="user.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="loginBtn">提交</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</template>

<script>

  import {mapMutations} from "vuex"; // 存储后端返回的token需要用到的

  export default {
    name: 'login',
    data: function () {
      return {
        user: {
          username: '',
          password: ''
        },
        permissions:[

        ],
        roles:[

        ],
      }
    },
    methods: {
      ...mapMutations( // 存储后端返回的token需要用到的
        ['saveLoginToken']
      ),
      loginBtn: function () {

        let config = {
          headers: {
            'Content-Type': 'application/json'
          }
        };
        this.$axios({
          method: "post",
          url: "/login",
          data:this.user,
        }).then(response => {

          if (0 === response.data.code) {

            let v=this;
            v.userToken= response.data.data.token;                 // 获取后端传递的token值
            v.saveLoginToken({ Authorization:v.userToken }); // 将token值保存到vuex中

            this.$router.push({
                path:"index",
                query:{
                  id:response.data.data.user.id // id是传递给下一个页面的参数
                }
              }
            );
          }else{
            console.log("oh ! login fail...");
          }
        })

      }
    }

  }
</script>
