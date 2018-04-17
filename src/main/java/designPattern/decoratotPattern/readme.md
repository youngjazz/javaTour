#装饰模式
## 特点
- 装饰者和具体组件都继承自组件类型
- 具体组件的方法不需要依赖起对象，而装饰者拥有一个组件类型对象，这样他可以装饰其他装饰者或具体组件

所谓装饰就是装饰者套在被装饰对象的外面，从而动态扩展被装饰者的功能
Java I/O中就使用了装饰者模式
InputStream 
FileInputStream StringBufferInputStream ByteArrayInputStream FilterStream

FilterStream
PushbackInputStream BufferedInputStream DataInputStream LineNumberInputStream

## 设计原则
**类应该对扩展开放，对修改关闭**。也就是添加