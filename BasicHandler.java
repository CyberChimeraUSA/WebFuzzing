package pack1;
import java.net.*;
import java.util.*;
public class BasicHandler {
	
	void domain_processing(String domain) 
	{
		
		try {
			InetAddress[] addresses = InetAddress.getAllByName(domain);
			for (InetAddress address : addresses) {
			System.out.println(address);
			}
			} catch (UnknownHostException ex) {
			  System.out.println("Could not find " + domain);
			}
		
		Enumeration<NetworkInterface> interfaces = null;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				System.out.println(ni);
				}
		
	}

}
