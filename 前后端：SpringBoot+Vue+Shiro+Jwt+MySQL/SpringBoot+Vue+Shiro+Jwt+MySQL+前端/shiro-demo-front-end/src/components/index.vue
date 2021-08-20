<template>
  <el-container>

    <!--实现权限级别控制的按钮-->
    <div v-for="(item,index) in this.permissionsArr" :key="index">
      <el-button v-if="item==='user:select'" type="primary" @click="selectBtn">查询按钮</el-button>
      <el-button v-if="item==='user:add'" type="primary" @click="addBtn">增加按钮</el-button>
      <el-button v-if="item==='user:update'" type="primary" @click="updateBtn">更新按钮</el-button>
      <el-button v-if="item==='user:delete'" type="danger" @click="deleteBtn">删除按钮</el-button>
    </div>




  </el-container>
</template>

<script>
  export default {
    name: "index",
    data: function () {
      return {
        userId:'',
        permissionsArr: [],
        rolesArr: [],
      }
    },
    methods: {
      selectBtn: function () {
        this.$axios({
          method: "get",
          url: "/select",
        }).then(response => {
          console.log(response.data);
        }).catch(error => console.log(error, "error"));
      },
      addBtn: function () {
        this.$axios({
          method: "get",
          url: "/add",
        }).then(response => {
          console.log(response.data);
        }).catch(error => console.log(error, "error"));
      },
      updateBtn: function () {
        this.$axios({
          method: "get",
          url: "/update",
        }).then(response => {
          console.log(response.data);
        }).catch(error => console.log(error, "error"));
      },
      deleteBtn: function () {
        this.$axios({
          method: "get",
          url: "/delete",
        }).then(response => {
          console.log(response.data);
        }).catch(error => console.log(error, "error"));
      },
      getUserInfo: function (userId) {

        this.$axios({
          method:"get",
          url:"/getUserInfoById?id="+userId,
        }).then(response=>{
          console.log(response.data);
          if(0===response.data.code){
            this.rolesArr=[];
            this.permissionsArr=[];
            let userData = response.data.data;
            // 获取角色
            let rSize = userData.roles.length;
            for (let i = 0; i < rSize; i++) {
              this.rolesArr[i] = userData.roles[i];
            }
            // 获取权限
            let pSize = userData.permissions.length;
            for (let i = 0; i < pSize; i++) {
              this.permissionsArr[i] = userData.permissions[i];
            }
          }else{
            console.log(response.data.msg);
          }
        }).catch(error => console.log(error, "error"));
      }
    },
    created: function () {
      this.userId = this.$route.query.id;
      this.getUserInfo(this.userId);
    }

  }
</script>
<style scoped>

</style>
