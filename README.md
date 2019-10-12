# 项目：mydap
1. 字典表加载到内存：com.hzk.mydap.dict.service.DictService

2. 测试字典表：com.hzk.mydap.MydapApplication

3. 多数据源：
    1. 导包
    2. 配置：application.properties

    3. mapper/*.xml：编写
    4. 接口
    5. 使用

    6. 数据源配置：
        ```
        注解：@MapperScan(basePackages = MasterDataSourceConfig.PACKAGES, sqlSessionFactoryRef = "masterSqlSessionFactory")
        分别指定接口和xml位置
        配置数据源、事务、SqlSessionFactory
        ```
