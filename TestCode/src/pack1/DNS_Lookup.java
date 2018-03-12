package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.net.*;
//import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DNS_Lookup {
	
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	
		void DNS_Lookup_Init()
		{
			 mainFrame = new JFrame("DebFuzz-URL Query");
		      mainFrame.setSize(800,800);
		      mainFrame.setLayout(new GridLayout(3, 1));

		      headerLabel = new JLabel("",JLabel.CENTER );
		      statusLabel = new JLabel("",JLabel.CENTER);        
		      statusLabel.setSize(350,100);
		      
		      //FIX-ME, dont want to close entire program, just window
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
		      
		      headerLabel.setText("Query URL");      
		        
		      JTextField URL = new JTextField(6);   
		      JButton Protocol_Test_Button = new JButton("Resolve DNS"); 

		     
		      //Panel for IP Address
		      JPanel panel = new JPanel();
		      panel.setLayout(new GridLayout(3,3));
		      panel.setBackground(Color.white);     
		      
		      panel.add(new JLabel("Enter URL: "),BorderLayout.LINE_START); 
		      panel.add(URL);
		      panel.add(Protocol_Test_Button,BorderLayout.LINE_END); 

		      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
		      panel.add(new JLabel(" ")); 
		      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
		      
		      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
		      panel.add(new JLabel(" ")); 
		      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
		      
		      
		      
		      Protocol_Test_Button.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 DNS_Lookup_method(URL.getText());
       
			         }          
			      });
		      


		      controlPanel.add(panel);
		      mainFrame.setVisible(true);  
		}
		
		void DNS_Lookup_method(String URL)
		{
			try {
				InetAddress[] addresses = InetAddress.getAllByName( URL);
				for (InetAddress address : addresses) {
				System.out.println(address);
				}
				} catch (UnknownHostException ex) {
				  System.out.println("Could not find " +  URL);
				}
			
			
		}
}
