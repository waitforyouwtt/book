1.创建项目启动报错：Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
  解决方案：
    在启动类修改，如下：@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

2.    