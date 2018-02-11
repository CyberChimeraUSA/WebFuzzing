package pack1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingLayoutDemo {
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;

	   public SwingLayoutDemo(){
	      prepareGUI();
	   }
	   public static void main(String[] args){
	      SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();  
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
	      JButton okButton = new JButton("Launch!"); 
	      JButton LocalHostInfo = new JButton("LocalHost Info"); 
	      
	      //Panel for IP Address
	      JPanel panel = new JPanel();
	      panel.setBackground(Color.white);
	      panel.setSize(300,300);
	      BorderLayout layout = new BorderLayout();
	      layout.setHgap(10);
	      layout.setVgap(10);
	      panel.setLayout(layout);        
	      panel.add(new JLabel("IP Address: "),BorderLayout.LINE_START); 
	      panel.add(IP,BorderLayout.LINE_END);
	      
	      //Panel for Domain
	      JPanel panel1 = new JPanel();
	      panel1.setBackground(Color.white);
	      panel1.setSize(300,300);
	      BorderLayout layout1 = new BorderLayout();
	      layout1.setHgap(10);
	      layout1.setVgap(10);
	      panel1.add(new JLabel("Domain Name: "),BorderLayout.LINE_START); 
	      panel1.add(Domain,BorderLayout.LINE_END);
	
	     //Panel for Launch Button
	      JPanel panel2 = new JPanel();
	      panel2.setBackground(Color.white);
	      panel2.setSize(300,300);
	      BorderLayout layout2 = new BorderLayout();
	      layout2.setHgap(10);
	      layout2.setVgap(10);
	      panel2.add(okButton,BorderLayout.LINE_START); 

	      //Panel for LocalHostInfo
	      BorderLayout layout3 = new BorderLayout();
	      JPanel panel3 = new JPanel();
	      panel3.setLayout(layout3);
	      panel3.add(LocalHostInfo,BorderLayout.EAST);

	      
	      //Event Handler for Button
	      okButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            statusLabel.setText("Ok Button clicked.");
		             launch_handler(IP.getText(),Domain.getText());
		           
		         }          
		      });

	      controlPanel.add(panel);
	      controlPanel.add(panel1);
	      controlPanel.add(panel2);
	      controlPanel.add(panel3,BorderLayout.SOUTH);
	      
	      mainFrame.setVisible(true);  
	   }
	   //Handler for IP and Domain Processing
	   void launch_handler(String IP,String Domain)
	   {
		      JPanel panelfxn = new JPanel();
		      panelfxn.setBackground(Color.white);
		      panelfxn.setSize(300,300);
		      BorderLayout layoutfxn = new BorderLayout();
		      layoutfxn.setHgap(10);
		      layoutfxn.setVgap(10);
		      
	           String data = "IP Address is " + IP; 
	           data +=  ", Domain is " + new String(Domain); 
		      
	           BasicHandler obj = new BasicHandler();
	           obj.domain_processing(Domain);
	           
		      statusLabel.setText(data); 
		      //panelfxn.add(new JLabel("Hello World "),BorderLayout.LINE_START); 
		      controlPanel.add(panelfxn);   
	   }
}






