<!--显示所有问卷的列表，可以编辑，收集问卷，统计问卷，删除问卷-->
<template>

      <el-container class="table-style">
        <!--问卷信息，问卷的编辑，收集，查看，分析，删除-->
        <el-main>
          <el-table v-bind:data="tableData" border size="medium" style="width: 100%;" :header-cell-style="{background:'#EDEDED'}">
            <el-table-column align="center" prop="title" label="问卷" width="400" ></el-table-column>
            <el-table-column align="center" prop="createTime" label="日期"></el-table-column>
            <el-table-column align="center" prop="answerNum" label="答卷"></el-table-column>
            <el-table-column align="center" prop="surveyState" label="状态"></el-table-column>
            <el-table-column align="center" prop="operate" label="操作" width="400">
              <template slot-scope="scope">
                <el-button @click="editSurvey(scope.row)" type="text">编辑问卷</el-button>
                <el-button @click="collectAnswerData(scope.row)" type="text">收集问卷</el-button>
                <el-button @click="lookAnswerData(scope.row)" type="text">查看答卷</el-button>
                <el-button @click="analyzeSurvey(scope.row)" type="text">分析问卷</el-button>
                <el-button @click="deleteSurvey(scope.row)" type="text">删除问卷</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-main>
        <!--分页-->
        <el-pagination big background style="text-align: center" @current-change="handleCurrentChange" :page-size="this.pageSize" layout="total, prev, pager, next" :total="this.totalNum"></el-pagination>
    </el-container>

</template>

<script>

  export default {
    name: 'tableandpage',
    data: function () {
      return {
        pageSize: 7,
        totalPage: 0,
        totalNum: 0,
        tableData: [],
      }
    },
    methods: {
      // 创建问卷
      createSurvey: function () {
       console.log("createSurvey");
      },
      // 编辑问卷
      editSurvey: function (row) {
        console.log("editSurvey");
      },
      // 查看所有的答卷数据
      lookAnswerData: function (row) {
        console.log("lookAnswerData");
      },
      // 收集答卷
      collectAnswerData: function (row) {
        console.log("collectAnswerData");
      },
      // 分析问卷
      analyzeSurvey: function (row) {
        console.log("analyzeSurvey");
      },
      // 删除问卷
      deleteSurvey: function (row) {
        console.log("deleteSurvey");
      },
      handleCurrentChange(val) {
        console.log("当前页是第"+val+"页");
        // 在此处加载不同页的数据
    },
    mounted: function () {

    },
  }
  }
</script>

<style scoped>


</style>
