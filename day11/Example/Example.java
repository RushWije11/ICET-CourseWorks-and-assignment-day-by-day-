import javax.swing.*;
import java.awt.*;
class Calculator extends JFrame{
	private JButton buttonArray;
	private JTextField txtDisplay;
	
	Calculator(){
		setSize(300,300);
		setTitle("Calculator");
		setDefaultCloseOperation(Calculator.EXIT_ON_CLOSE);//3
		setLocationRelativeTo(null);
		JButton[] buttonArray=new JButton[16];
		String[] buttonText={"7","8","9","*","4","5","6","/","1","2","3","+","0",".","=","-"};
		JPanel buttonPanel=new JPanel(new GridLayout(4,4,2,2));
		for(int i=0; i<16; i++){
			buttonArray[i]=new JButton(buttonText[i]);
			buttonArray[i].setFont(new Font("",1,20));
			buttonPanel.add(buttonArray[i]);
		}
		add("Center",buttonPanel);
		
		txtDisplay=new JTextField();
		txtDisplay.setFont(new Font("",1,20));
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
		add("North",txtDisplay);
		setVisible(true);
	}
}
class Example{
	public static void main(String args[]){
		Calculator c1=new Calculator();
		c1.setVisible(true);
	}	
}
//Calculator IS-A JFrame
