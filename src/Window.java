import java.awt.*;
import java.awt.event.*;

public class Window {
    
public static void main(String[] args) {
		 
		//Homepage
		Frame homeFrame = new Frame ("Homepage");
		Button createBtn,depositBtn,withdrawBtn,statementBtn;
		Label title;
        Panel p1 = new Panel();
        Panel p2 = new Panel();

		
		createBtn = new Button("Create account");
		depositBtn = new Button("Deposit money");
		withdrawBtn = new Button("Withdraw money");
		statementBtn = new Button("Check statement");
		
		title = new Label("Bank of Vinu");
		title.setForeground(SystemColor.textHighlight);
		title.setFont(new Font("Tahoma", Font.BOLD, 15));
	
        homeFrame.setLayout(new BorderLayout());
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(2,2));
		p1.setSize(new Dimension(400, 200));
        
//		zero.addActionListener( //anono class
//				
//				new ActionListener() {
//					
//					public void actionPerformed(ActionEvent x) {
//						
//						String read;
//						
//						read = zero.getLabel();
//						inZero = Integer.parseInt(read);
//					
//						T1.setText(read);
//					}
//
//				}
//			);
		
        homeFrame.add(p1, BorderLayout.NORTH);
        homeFrame.add(p2, BorderLayout.CENTER);
		
		//Frame settings
		p1.add(title);
		p2.add(createBtn);
		p2.add(depositBtn);
		p2.add(withdrawBtn);
		p2.add(statementBtn);		


		homeFrame.setSize(400,400);
		homeFrame.setTitle("Homepage");
		homeFrame.setBackground(Color.GRAY);
		homeFrame.setVisible(true);
 
		
		
		//createAccPage
		Frame createFrame = new Frame ("Create Account");
		Button createAccBtn;
		Label nameAcc,addAcc,accNo;
		TextField nameAccT,addAccT,accNoT;
        Panel pc1 = new Panel();
        Panel pc2 = new Panel();
        Panel pc3 = new Panel();
        Panel pc4 = new Panel();

		
		createAccBtn = new Button("Create account");
		
		nameAccT = new TextField();
		addAccT = new TextField();
		accNoT = new TextField();
		
		nameAcc = new Label("Name:");
		addAcc = new Label("Address:");
		accNo = new Label("Account number:");
	
        createFrame.setLayout(new BorderLayout());
        pc1.setLayout(new FlowLayout());
        pc2.setLayout(new FlowLayout());
        pc3.setLayout(new FlowLayout());
        pc4.setLayout(new FlowLayout());
        
//		zero.addActionListener( //anono class
//				
//				new ActionListener() {
//					
//					public void actionPerformed(ActionEvent x) {
//						
//						String read;
//						
//						read = zero.getLabel();
//						inZero = Integer.parseInt(read);
//					
//						T1.setText(read);
//					}
//
//				}
//			);
		
        createFrame.add(pc1, BorderLayout.NORTH);
        createFrame.add(pc2, BorderLayout.CENTER);
        createFrame.add(pc3, BorderLayout.SOUTH);
//        createFrame.add(pc4, BorderLayout.SOUTH);
		
		//Frame settings
		pc1.add(nameAcc);
		pc1.add(nameAccT);
		pc2.add(addAcc);
		pc2.add(addAccT);
		pc3.add(accNo);
		pc3.add(accNoT);	
		pc3.add(createAccBtn);

		nameAccT.setPreferredSize( new Dimension( 100, 24 ) );
		addAccT.setPreferredSize( new Dimension( 100, 24 ) );
		accNoT.setPreferredSize( new Dimension( 100, 24 ) );
		
		createFrame.setSize(400,140);
		createFrame.setTitle("Homepage");
		createFrame.setBackground(Color.GRAY);
		createFrame.setVisible(true);
//		
//		Frame depositFrame = new Frame ("Deposit");
//		Frame withdrawFrame = new Frame ("Withdraw");
//		Frame statementFrame = new Frame ("Bank Statement");
//		TextField T1;
		Button zero,one,two,three,four,five,six,seven,eight,nine,plus,minus,times,equal,C,divide;
//		Operations E;
		

	}
}
