
## 说明

这是JPA实现级联操作的demo。

为了实现方便，就没有写service和impl层，直接写了dao层。（理解级联操作的思路就好）

### 数据库说明

在application.properties中配置您对应的数据库信息。

无需在mysql数据库设计表。运行该项目，则自动生成数据库表。

## 注意点

- 在被维护的一方，比如Survey，添加所有的问题，一定要添加  @ToString.Exclude。

否则报错：$HibernateProxy$Bo3T1LuZ.toString(Unknown Source) ~[classes/:na]
```txt
    @OneToMany(mappedBy = "survey",cascade=CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private List<Question> questions=new LinkedList<>();
```

## 关系说明

一个问卷有多个题目

一个题目有多个选项

### 级联删除

删除问卷，会把相关的问题和选项都删除。

### 级联更新

目前的思路实现是新增一个问题，把以前的无关问题全部删除。详情看TestController的test6.

如果你想更新部分问题，又不想把以前的无关问题删除。
1.这个想法的思路我暂时这么实现。
2.获取以前的问题。
3.使用survey.getQuestions().clear();删除全部的问题
4.将以前的问题进行修改，再重新生成问题

### 级联查询

根据问卷id，能够查询全部的问题和选项

### 级联标签

CascadeType.PRESIST 级联持久化（保存）操作（持久保存拥有方实体时，也会持久保存该实体的所有相关数据。）

CascadeType.REMOVE 级联删除操作（删除一个实体时，也会删除该实体的所有相关数据。）

CascadeType.MERGE 级联更新（合并）操作（将分离的实体重新合并到活动的持久性上下文时，也会合并该实体的所有相关数据。）

CascadeType.REFRESH 级联刷新操作 （只会查询获取操作）

CascadeType.ALL 包含以上全部级联操作
