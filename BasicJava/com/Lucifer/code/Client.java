import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 18:13
 */
//Nio的客户端
class NioClient{

    public static void main(String[] args)throws Exception {
        System.out.println("客户端已经启动");
        //创建socket通道
        SocketChannel sChannel1 = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));
        //切换为异步非阻塞
        sChannel1.configureBlocking(false);
        //指定缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(new Date().toString().getBytes());
        //切换读取模式
        buffer.flip();
        sChannel1.write(buffer);
        buffer.clear();
        //关闭通道
        sChannel1.close();
    }
}

//Nio的服务端
class NioServer{

    public static void main(String[] args)throws Exception {
        System.out.println("服务器端已经启动");
        //创建通道
        ServerSocketChannel sChannel1 = ServerSocketChannel.open();
        //设置异步
        sChannel1.configureBlocking(false);
        //绑定链接
        sChannel1.bind(new InetSocketAddress(8080));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器中，并且监听已经接受到时间
        sChannel1.register(selector, SelectionKey.OP_ACCEPT);
        //轮询获取已经准备就绪的事件
        while (selector.select()>0){
            //获取当前选择器 有注册器已经监听到事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                //获取准备"就绪"事件
                SelectionKey sk = it.next();
                //判断事件准备"就绪"
                if(sk.isAcceptable()){
                    //若"接收"就绪，获取客户端连接
                    SocketChannel socketChannel = sChannel1.accept();
                    //设置为阻塞
                    socketChannel.configureBlocking(false);
                    //将通道注册到服务器上
                    sChannel1.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //获取当前选择器"就绪"状态通道
                    SocketChannel socketChannel = (SocketChannel)sk.channel();
                    //读取数据
                    int length = 0;
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while ((length = socketChannel.read(byteBuffer))>0){
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(),0,length));
                        byteBuffer.clear();
                    }
                }
                it.remove();
            }

        }
    }

}
public class Client {


}
