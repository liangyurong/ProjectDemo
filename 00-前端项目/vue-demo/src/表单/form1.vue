
<!--

:model 等同于 v-bind:model

实现功能：表单验证

-->

<template>
    <div>
        <el-form :model="userInfo" :rules="rules" ref="loginForm">
            <el-form-item prop="username">
                <el-input type="text" v-model="userInfo.username" ></el-input>
            </el-form-item>

            <el-form-item prop="password">
                <el-input v-model="userInfo.password" type="password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-checkbox name="type" v-model="userInfo.remember">
                    <span>记住密码</span>
                </el-checkbox>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login('loginForm')">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
  name: 'form1',
  data() {
    return {
      userInfo: {
        username: '',
        password: '',
        remember: false
      },
      rules : {
        username : [{ required: true, message: '请输入用户名', trigger: 'blur' }],
        password : [{ required: true, message: '请输入密码', trigger: 'blur' }]
      }
    };
  },
  methods: {
    login(formName){
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>

</style>
