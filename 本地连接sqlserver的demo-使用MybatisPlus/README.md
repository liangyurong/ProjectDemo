
### 说明

1. 使用MyBatis-Plus连接本地sql server的demo.
2. MP：单个查询，批量查询
3. MP：单个删除，批量删除
4. MP：分页插件
5. MP: 乐观锁插件


### sql server的依赖

连接sql server ， 只需要引入这两个依赖，不需要下载什么jar包

```txt
        <!--for SqlServer-->
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>sqljdbc4</artifactId>
            <version>4.0</version>
        </dependency>
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>8.1.0.jre8-preview</version>
        </dependency>
```
        
### 分页插件

需要配置一个分页插件的Bean，然后就可以直接使用了。

```txt
@Configuration
public class MPConfig {

    /**
     * 配置分页插件。配置完之后，就可以直接使用。在TestPagination.java中进行测试。
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
```
