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
//import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Header_Dump {
	
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;

	
	   void Header_Init()
	     {

		      mainFrame = new JFrame("DebFuzz-Header Dump");
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
		      
		      headerLabel.setText("Dump Header");      

		       
		      JTextField HTTP_Address = new JTextField(6);   
		      JButton HTTP_Header_Retrieve = new JButton("Query Header"); 
		      
		      //Panel for IP Address
		      JPanel panel = new JPanel();
		      panel.setLayout(new GridLayout(3,3));
		      panel.setBackground(Color.white);     
		      
		      panel.add(new JLabel("Enter Address: "),BorderLayout.LINE_START); 
		      panel.add(HTTP_Address);
		      panel.add(HTTP_Header_Retrieve,BorderLayout.LINE_END); 
		      
		      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
		      panel.add(new JLabel(" ")); 
		      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
		      
		      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
		      panel.add(new JLabel(" ")); 
		      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
		      
		      HTTP_Header_Retrieve.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	HeaderDump(HTTP_Address.getText());
			        	        
			         }          
			      });
		      
	
		      controlPanel.add(panel);
		      mainFrame.setVisible(true);  
		
		
	}
		void HeaderDump(String input_URL)
		{
			try {
				URL u = new URL(input_URL);
				URLConnection uc = u.openConnection();
				
				System.out.println("Entered URL: " + uc.getURL());

			       Map<String, List<String>> headers = uc.getHeaderFields();
			        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
			        for (Map.Entry<String, List<String>> entry : entrySet) {
			            String headerName = entry.getKey();
			            System.out.print( headerName);
			            List<String> headerValues = entry.getValue();
			            for (String value : headerValues) {
			                System.out.print("  " + value);
			            }
			            System.out.println();
			        }
				
			    } catch (MalformedURLException ex) {
				  System.err.println(input_URL + " is not a URL I understand");
				} catch (IOException ex) {
				  System.err.println(ex);
				}
				System.out.println();
		}

}
