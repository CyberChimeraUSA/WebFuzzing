package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Encoder {
	
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   
	void Encoder_Init() {
	 mainFrame = new JFrame("DebFuzz-URL Encoder");
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
     
     headerLabel.setText("Encoder & Decoder");
     
     JTextField EncodeString = new JTextField(6);   
     JButton EncodeButton = new JButton("Encode"); 
     JTextField DecodeString = new JTextField(6);   
     JButton DecodeButton = new JButton("Decode"); 
     
     JPanel panel = new JPanel();
     panel.setLayout(new GridLayout(3,3));
     panel.setBackground(Color.white);    
     
     panel.add(new JLabel("Enter String: "),BorderLayout.LINE_START); 
     panel.add(EncodeString);
     panel.add(EncodeButton,BorderLayout.LINE_END); 
     
     panel.add(new JLabel("Enter String: "),BorderLayout.LINE_START); 
     panel.add(DecodeString);
     panel.add(DecodeButton,BorderLayout.LINE_END); 
     
     panel.add(new JLabel(" "),BorderLayout.LINE_START); 
     panel.add(new JLabel(" ")); 
     panel.add(new JLabel(" "),BorderLayout.LINE_END); 
     
     EncodeButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
   
        	 try {
        		System.out.println(URLEncoder.encode(EncodeString.getText(),"UTF-8"));
        	 } catch (UnsupportedEncodingException ex) {
        		 throw new RuntimeException("Broken VM does not support UTF-8");
        	 }
        	 
         }          
      });
     
     DecodeButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
   
        	 try {
        		 String output = URLDecoder.decode(DecodeString.getText(), "UTF-8");
        		 System.out.println(output);
        	 } catch (UnsupportedEncodingException ex) {
        		 throw new RuntimeException("Broken VM does not support UTF-8");
        	 }
        	 
         }          
      });
     
     controlPanel.add(panel);
     mainFrame.setVisible(true); 
	}
}
