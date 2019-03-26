import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 20:28
 * netty框架的服务端
 */
class ServertHandler extends SimpleChannelHandler {
    //通道关闭时触发
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelClosed(ctx, e);
        System.out.println("channelClosed");
    }

    //必须要建立连接，关闭通道的时候才会触发
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelDisconnected(ctx, e);
        System.out.println("channelDisconnect");
    }

    //接受出现的异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        super.exceptionCaught(ctx, e);
        System.out.println("exceptionCaught");
    }

    //接受客户端数据
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.messageReceived(ctx, e);
        System.out.println("messageReceived");
        System.out.println("服务器向客户端回复的内容：" + e.getMessage());
    }
}

public class NettyServer {

    public static void main(String[] args) {
        //创建对象
        ServerBootstrap serverBootStrap = new ServerBootstrap();
        //创建两个线程池 第一个监听端口号，nio监听
        ExecutorService boos = Executors.newCachedThreadPool();
        ExecutorService wook = Executors.newCachedThreadPool();
        //将线程放入工程
        serverBootStrap.setFactory(new NioServerSocketChannelFactory(boos, wook));
        //设置管道工程
        serverBootStrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                //传输数据时直接为String类型
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                //设置监听类
                pipeline.addLast("serverHandler",new ServertHandler());
                return pipeline;
            }

        });
        serverBootStrap.bind(new InetSocketAddress(8080));
        System.out.println("服务端项目已经启动");

        while (true){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("每隔一秒打印一下");
        }
    }
}
