import java.net.*;
public class InetAddressTest{
	public static void main(String[] args) throws Exception{
		InetAddress ip=InetAddress.getByName("www.sina.com.cn");
		System.out.println("新浪是否可到达："+ip.isReachable(2000));
		System.out.println(ip.getHostAddress());
		InetAddress local=InetAddress.getByAddress(new byte[]{127,0,0,1});
		System.out.println("本机是否可到达："+local.isReachable(5000));
		System.out.println(local.getCanonicalHostName());
	}
}
