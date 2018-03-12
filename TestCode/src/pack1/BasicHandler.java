package pack1;
import java.net.*;
import java.util.*;
public class BasicHandler {
	

	
	void local_interface_info()
	{
 		Enumeration<NetworkInterface> interfaces = null;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				System.out.println(ni);
				}
       
     }  
	}
	


