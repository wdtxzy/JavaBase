

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 22:40
 */
public class NioDemo01 {

    @Test
    public void test002()throws IOException{
        long startTime = System.currentTimeMillis();
        //创建管道
        FileChannel inChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(""),StandardOpenOption.READ,StandardOpenOption.WRITE);
        //定义映射文件
        MappedByteBuffer inMappedByte = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedByte = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());
        //直接对缓冲区操作
        byte[] dsf = new byte[inMappedByte.limit()];
        inMappedByte.get(dsf);
        outMappedByte.put(dsf);
        inChannel.close();
        outChannel.close();
        long endTime = System.currentTimeMillis();
        System.out.println("操作直接缓冲区耗时间："+(endTime-startTime));

    }

    @Test
    public void test001()throws IOException{
        long startTime = System.currentTimeMillis();
        //读入流
        FileInputStream fst = new FileInputStream("");
        //写入流
        FileOutputStream fos = new FileOutputStream("");
        //创建通道
        FileChannel inChannel = fst.getChannel();
        FileChannel outChannel = fos.getChannel();
        //分配制定大小缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (inChannel.read(buf)!=-1){
            //开启读取模式
            buf.flip();
            //将数据写入到通道中
            outChannel.write(buf);
            buf.clear();
        }
        //关闭通道
        inChannel.close();
        outChannel.close();
        fos.close();
        fst.close();
        long endTime = System.currentTimeMillis();
        System.out.println("操作非直接缓冲区耗时间："+(endTime-startTime));
    }
}
