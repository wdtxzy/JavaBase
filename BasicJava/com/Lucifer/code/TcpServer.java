import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 11:56
 * TCP的服务端
 */
public class TcpServer {

    public static void main(String[] args)throws IOException {
        System.out.println("tcp协议服务器端启动");
        //创建服务器连接
        ServerSocket serverSocket = new ServerSocket(8080);
        //接收客户端请求，阻塞功能
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        //将字节流转换成String类型
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String result = new String(bytes,0,len);
        System.out.println("服务器接收到客户端内容："+result);
        serverSocket.close();
    }
}
