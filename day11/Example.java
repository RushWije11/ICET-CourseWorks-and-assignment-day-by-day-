import javax.swing.*;
import java.awt.*;
class Example{
	public static void main(String args[]){
		JFrame f1=new JFrame();
		f1.setSize(300,300);
		f1.setTitle("Calculator");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//3
		f1.setLocationRelativeTo(null);
		
		JButton[] buttonArray=new JButton[16];
		String[] buttonText={"7","8","9","*","4","5","6","/","1","2","3","+","0",".","=","-"};
		JPanel buttonPanel=new JPanel(new GridLayout(4,4,2,2));
		for(int i=0; i<16; i++){
			buttonArray[i]=new JButton(buttonText[i]);
			buttonArray[i].setFont(new Font("",1,20));
			buttonPanel.add(buttonArray[i]);
		}
		f1.add("Center",buttonPanel);
		
		JTextField txtDisplay=new JTextField();
		txtDisplay.setFont(new Font("",1,20));
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
		f1.add("North",txtDisplay);
		f1.setVisible(true);
	}	
}
