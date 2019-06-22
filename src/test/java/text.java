
import com.yi.Interact.SignInUi;
import com.yi.Mange.Mange;
import com.yi.Mange.Net.Clien;
import com.yi.Mange.Net.NetInitUi;
import com.yi.Mange.Net.Server;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class text {
    public static void main(String[] args) throws InterruptedException {
        new Server(8080);
        Thread.sleep(1000);
        new Clien("127.0.0.1",8080);
    }
}
