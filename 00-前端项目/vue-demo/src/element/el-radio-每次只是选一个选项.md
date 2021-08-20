
关键在与:label，需要是独一无二的
```text
     <el-form-item v-for="(item,index) in options" :key="index">
          <el-radio-group v-model="radioSex">
            <!--单个选项-->
            <el-radio  :label="item.orderById"></el-radio>
          </el-radio-group>
     </el-form-item>
```
