# IO
- Input /Output 都是以内存为中心
- InputStream/OutputStream 是最基本的两种IO流，都是有顺序的，最小单位为字节
- Reader/Writer表示字符流，最小单位是char
- 同步IO，等待数据返回才执行后续代码，本节都是来自java.io包内提供的同步IO

## 1. File对象
**(1) 文件和目录**   
File对象既可以表示目录，也可以表示文件。创建File对象本身不涉及IO操作，调用方法时才涉及  
**(2) 创建和删除文件**  
方法：`createNewFile()` `delete()`,返回布尔值;创建临时文件`createTempFile（）`  
```
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // File f = new File("D:\\Untitled.m");
        File f = File.createTempFile("tmp-", ".txt");
        f.deleteOnExit();//JVM退出时自动删除
        System.out.println(f.getAbsolutePath());
        System.out.println(f.isFile());
    }
}
```
**（3）遍历文件和目录**  
遍历：`file.listFiles()`，可以过滤
如果`File`方法表示目录，可以用相关方法创建和删除目录  
**（4）Path**


## 2.InputStream
`InputStream()`是一个java.io中的抽象类  
最重要的方法就是`int read()` 如果读到末尾，返回-1,其两个实现类需要掌握：  
- `FileInputStream`实现了文件流输入
- `ByteArrayInputStream` 在内存中模拟字节流输入，常用于测试 

总是使用`try(resource){...}`来保证`InputStream`正确关闭