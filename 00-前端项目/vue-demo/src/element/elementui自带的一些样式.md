

问题：使用el-container，el-header这些东西，会自动有一些外边距，内边距。

解决：去app.vue，添加以下代码

```text
<style>
    body{
      padding: 0;
      margin: 0;
    }
</style>
```
