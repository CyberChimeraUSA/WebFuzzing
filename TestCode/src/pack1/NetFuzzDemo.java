package pack1;


import java.awt.*;
import java.awt.event.*;
//import java.net.NetworkInterface;
//import java.net.SocketException;
//import java.util.Enumeration;
//import java.net.*;
//import java.util.*;
import javax.swing.*;

public class NetFuzzDemo {
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;

	   public NetFuzzDemo(){
	      prepareGUI();
	   }
	   public static void main(String[] args){
	      NetFuzzDemo swingLayoutDemo = new NetFuzzDemo();  
	      swingLayoutDemo.showBorderLayoutDemo();       
	   }
	   private void prepareGUI(){
	      mainFrame = new JFrame("DebFuzz Main");
	      mainFrame.setSize(800,800);
	      mainFrame.setLayout(new GridLayout(3, 1));

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        
	      statusLabel.setSize(350,100);
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	   
	   private void showBorderLayoutDemo(){
	      headerLabel.setText("Fuzzer");      
	      JButton LocalInterfaceInfo = new JButton("Local Interface Info"); 
	      JButton URLQuery = new JButton("Query URL"); 
	      JButton HeaderDump = new JButton("Dump Header");
	      JButton Encoder = new JButton("Encode/Decode String");
	      JButton DNS_Lookup = new JButton ("DNS Lookup");
	      
	      //Panel for IP Address
	      JPanel panel = new JPanel();
	      panel.setLayout(new GridLayout(4,3)); //new
	      panel.setBackground(Color.white);     
	      
	      panel.add(LocalInterfaceInfo,BorderLayout.LINE_START); 
	      panel.add(URLQuery); 
	      panel.add((HeaderDump),BorderLayout.LINE_END); 
	      
	      panel.add(Encoder,BorderLayout.LINE_START); 
	      panel.add(DNS_Lookup); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
	      panel.add(new JLabel(" ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
	      panel.add(new JLabel(" ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      
	      DNS_Lookup.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 DNS_Lookup dns_obj = new DNS_Lookup();
		        	 dns_obj.DNS_Lookup_Init();
		     
		                   
		         }          
		      });

	         
	      //getNetworkInterfaces
	      LocalInterfaceInfo.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
			           BasicHandler obj = new BasicHandler();
			           obj.local_interface_info(); 		        	 
		         }	
		      });
	      
	      URLQuery.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 statusLabel.setText("Hello URL Query"); 
		        	 URL_Query Query_Obj = new URL_Query();
		        	 Query_Obj.URL_Query_init();
		         }	
		      });
	      
	      
	      HeaderDump.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 statusLabel.setText("Hello Header Dump"); 
		        	 Header_Dump Header_Dump_Obj = new Header_Dump();
		        	 Header_Dump_Obj.Header_Init();

		         }	
		      });
	      Encoder.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 Encoder EncodeObj = new Encoder();
		        	 EncodeObj.Encoder_Init();

		         }	
		      });
	      
	      controlPanel.add(panel);
	      mainFrame.setVisible(true);  
	   }
	   

}






