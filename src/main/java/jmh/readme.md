Java微基准测试框架JMH的使用
参考 https://mp.weixin.qq.com/s/XzBqsTSBAANboyB48GFV4A

pom.xml添加JMH框架依赖
```xml
    <!-- JMH-->
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-core</artifactId>
        <version>1.21</version>
    </dependency>
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-generator-annprocess</artifactId>
        <version>1.21</version>
        <scope>provided</scope>
    </dependency>
```