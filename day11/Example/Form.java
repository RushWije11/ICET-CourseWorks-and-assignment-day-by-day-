import javax.swing.*;
import java.awt.*;

class AddStudentForm extends JFrame{
	AddStudentForm(){
		setSize(400,300);
		setTitle("Add Student Form");
		setDefaultCloseOperation(Calculator.EXIT_ON_CLOSE);//3
		setLocationRelativeTo(null);
		
		JLabel label=new JLabel();
		label.setText("Add Student Form");
		label.setFont(new Font("",1,25));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		add("North",label);
		
		JPanel P1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnAddStudent =new JButton();
		btnAddStudent.setText("Add");
		btnAddStudent.setFont(new Font("",1,25));
		P1.add(btnAddStudent);
		JButton btnCancel =new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setFont(new Font("",1,25));
		P1.add(btnCancel);
		
		add("South",P1);
		
		
		JPanel labelPanel=new JPanel(new GridLayout(4,1));
		
		JLabel lblId=new JLabel("Student Id");
		lblId.setFont(new Font("",1,20));
		labelPanel.add(lblId);
		
		JLabel lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		JLabel lblPrfMarks=new JLabel("PRF Marks");
		lblPrfMarks.setFont(new Font("",1,20));
		labelPanel.add(lblPrfMarks);
		
		JLabel lblDbmsMarks=new JLabel("DBMS Marks");
		lblDbmsMarks.setFont(new Font("",1,20));
		labelPanel.add(lblDbmsMarks);
		
		add("West", labelPanel);
		
		JPanel txt =new JPanel(new GridLayout(4,1));
		
		JTextField sid_Text=new JTextField(4);
		sid_Text.setFont(new Font("",1,20));
		JPanel sid_Textt =new JPanel(new FlowLayout(FlowLayout.LEFT));
		sid_Textt.add(sid_Text);
		
		
		txt.add(sid_Textt);
		
		JTextField nameText=new JTextField(8);
		nameText.setFont(new Font("",1,20));
		
		JPanel nameTextt =new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextt.add(nameText);
		
		txt.add(nameTextt);
		
		JTextField prfMarksText=new JTextField(3);
		prfMarksText.setFont(new Font("",1,20));
		JPanel prfMarksTextt =new JPanel(new FlowLayout(FlowLayout.LEFT));
		prfMarksTextt.add(prfMarksText);
		
		

		txt.add(prfMarksTextt);
		
		JTextField dbmsMarksText=new JTextField(3);
		dbmsMarksText.setFont(new Font("",1,20));
		JPanel dbmsMarksTextt =new JPanel(new FlowLayout(FlowLayout.LEFT));
		dbmsMarksTextt.add(dbmsMarksText);
		
		
		txt.add(dbmsMarksTextt);
		
		add("Center",txt);
		
	}
	
}
class Form {
	public static void main(String[] args){
		new AddStudentForm().setVisible(true);
		
	}
}
