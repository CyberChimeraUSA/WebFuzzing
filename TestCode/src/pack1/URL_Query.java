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
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class URL_Query {
	
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;

	void URL_Query_init()
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
	        
	      JTextField URL_line1 = new JTextField(6);   
	      JButton Protocol_Test_Button = new JButton("Test Protocol Support"); 
	      JTextField URL_line2 = new JTextField(6);   
	      JButton web_page_dump_button = new JButton("Dump Web Page"); 
	       
	      //Panel for IP Address
	      JPanel panel = new JPanel();
	      panel.setLayout(new GridLayout(6,3));
	      panel.setBackground(Color.white);     
	      
	      panel.add(new JLabel("URL: "),BorderLayout.LINE_START); 
	      panel.add(URL_line1);
	      panel.add(Protocol_Test_Button,BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel("URL: "),BorderLayout.LINE_START); 
	      panel.add(URL_line2);
	      panel.add(web_page_dump_button,BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
	      panel.add(new JLabel(" ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel("Example: "),BorderLayout.LINE_START); 
	      panel.add(new JLabel("http://google.com ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
	      panel.add(new JLabel("ftp://google.com ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      panel.add(new JLabel(" "),BorderLayout.LINE_START); 
	      panel.add(new JLabel("telnet://google.com ")); 
	      panel.add(new JLabel(" "),BorderLayout.LINE_END); 
	      
	      Protocol_Test_Button.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	protocol_test(URL_line1.getText());
		        	        
		         }          
		      });

	      web_page_dump_button.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 web_page_dump(URL_line2.getText());
		        	        
		         }          
		      });
	      controlPanel.add(panel);
	      mainFrame.setVisible(true);  
	}
	
	
	void protocol_test(String input_URL)
	{
		//FIX-ME- add error handling for protocols
		try {
		URL u = new URL(input_URL);
		System.out.println(u.getProtocol() + " is supported");
		} catch (MalformedURLException ex) {
		String protocol = input_URL.substring(0, input_URL.indexOf(':'));
		System.out.println(protocol + " is not supported");
		}
	}
	
	void web_page_dump(String input_URL){
		

		try {
			// set default encoding
			String encoding = "ISO-8859-1";
			URL u = new URL(input_URL);
			URLConnection uc = u.openConnection();
			String contentType = uc.getContentType();
			int encodingStart = contentType.indexOf("charset=");
			
			if (encodingStart != -1) {
			   encoding = contentType.substring(encodingStart + 8);
			}
			InputStream in = new BufferedInputStream(uc.getInputStream());
			Reader r = new InputStreamReader(in, encoding);
			int c;
			
			while ((c = r.read()) != -1) {
			   System.out.print((char) c);
			}
			r.close();
			
		    } catch (MalformedURLException ex) {
			   System.err.println(input_URL + " is not a parseable URL");
			} catch (UnsupportedEncodingException ex) {
			   System.err.println(
			   "Server sent an encoding Java does not support: " + ex.getMessage());
			} catch (IOException ex) {
			   System.err.println(ex);
			}
		/*try {
		// Open the URLConnection for reading
        URL u = new URL(input_URL);
		URLConnection uc = u.openConnection();
		  try (InputStream raw = uc.getInputStream()) { // autoclose
		  InputStream buffer = new BufferedInputStream(raw);
		  // chain the InputStream to a Reader
		  Reader reader = new InputStreamReader(buffer);
		  int c;
		  while ((c = reader.read()) != -1) {
		   System.out.print((char) c);
		  }
		 }
	  } 
	 catch (MalformedURLException ex) {
		 System.err.println(input_URL + " is not a parseable URL");
		  } catch (IOException ex) {
		   System.err.println(ex);
		 } */
	
		
		
	}
	
}


