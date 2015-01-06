### 简介

这是学习JAVA的练习代码, 主要提供工具函数

### 使用

```java
/*
[
    {id: 1, name: "name1", gender: 1},
    {id: 2, name: "name2", gender: 1},
    {id: 3, name: "name1", gender: 2},
]
*/

/*
[1, 2]
*/
CollectionUtils.pluck

/*
{
    1: [
        {id: 1, name: "name1", gender: 1},
        {id: 2, name: "name2", gender: 1},
    ],
    2: [
        {id: 3, name: "name1", gender: 2},
    ]
}
*/
CollectionUtils.groupBy

/*
去重
*/
CollectionUtils.groupBy
```
