import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 14:46
 * 缓冲区
 * ByteBuffer
 * LongBuffer
 * IntegerBuffer
 * FloatBuffer
 * DoubleBuffer
 */
public class BufferTest {

    @Test
    public void test001() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        String str = "abcd";
        byteBuffer.put(str.getBytes());
        //开启读的模式
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,2);
        byteBuffer.mark();//打印标记
        System.out.println(new String(bytes, 0, 2));
        System.out.println(byteBuffer.position());
        System.out.println("---------------------");
        byteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes, 2, 2));
        System.out.println(byteBuffer.position());
        System.out.println("---------------------");
        byteBuffer.get(bytes,2,2);
        System.out.println(new String(bytes, 0, 2));
        byteBuffer.reset();//还原到mark位置
        System.out.println(byteBuffer.position());
    }

}
