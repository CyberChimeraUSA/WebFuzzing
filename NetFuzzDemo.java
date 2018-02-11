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
	      mainFrame = new JFrame("DebFuzz");
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
	      JTextField IP = new JTextField(6);   
	      JTextField Domain = new JTextField(6);   
	      JButton ResolveButton = new JButton("Resolve Domain"); 
	      JButton LocalInterfaceInfo = new JButton("Local Interface Info"); 
	      JButton IPResolve = new JButton("Resolve IP"); 
	      
	      //Panel for IP Address
	      JPanel panel = new JPanel();
	      panel.setLayout(new GridLayout(4,3)); //new
	      panel.setBackground(Color.white);     
	      
	      panel.add(new JLabel("IP Address: "),BorderLayout.LINE_START); 
	      panel.add(IP);
	      panel.add(IPResolve,BorderLayout.LINE_END);
	      
	      panel.add(new JLabel("Domain Name: "),BorderLayout.LINE_START); 
	      panel.add(Domain);
	      panel.add(ResolveButton,BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
	      panel.add(new JLabel(" ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      panel.add(LocalInterfaceInfo,BorderLayout.LINE_START); 
	      panel.add(new JLabel(" ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      


	      //Event Handler for okButton (Resolves IP and Domain Info)
	      //If NULL, prints local 
	      ResolveButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            
		             launch_handler(IP.getText(),Domain.getText());          
		         }          
		      });
	      
	      //getNetworkInterfaces
	      LocalInterfaceInfo.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
			           BasicHandler obj = new BasicHandler();
			           obj.local_interface_info(); 		        	 
		         }	
		      });
	      controlPanel.add(panel);
	      mainFrame.setVisible(true);  
	   }
	   
	   //Handler for IP and Domain Processing
	   void launch_handler(String IP,String Domain)
	   {
	           String data = "IP Address is " + IP; 
	           data +=  ", Domain is " + new String(Domain); 
	           BasicHandler obj = new BasicHandler();
	           obj.domain_processing(Domain);
		      statusLabel.setText(data); 
	   }
}






