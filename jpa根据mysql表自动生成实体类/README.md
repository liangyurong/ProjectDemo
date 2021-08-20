
### 说明

总的来说，目前只能生成实体类。dao,service,impl层的代码只能自己手写。

### 步骤

1. 建立好maven项目之后，建立三层文件夹，com.lyr.demo。然后在demo文件夹下面新建entity文件夹。

2. 在右边栏目的database中，连接mysql。

3. 连接成功之后，可以看到数据库下面的表。

4. 将鼠标移动到表名，右键："scripted Extensions" -> "generate POJOs.groovy" -> 选择实体类要生成的位置 -> 点击ok即可。
