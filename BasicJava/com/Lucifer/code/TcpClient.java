import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 12:04
 * TCP的客户端
 */
public class TcpClient {

    public static void main(String[] args)throws IOException {
        System.out.println("socket tcp 客户端启用");
        Socket socket = new Socket("127.0.0.1",8000);
        OutputStream outputStream =socket.getOutputStream();
        outputStream.write("I am the most handsome person in my class".getBytes());
        socket.close();
    }
}
