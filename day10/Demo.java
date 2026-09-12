import java.util.*;
class Student{
	private String id;
	private String name;
	private int prfMark;
	private int dbmsMark;
	
	Student(String id, String name, int prfMark, int dbmsMark){
		this.id=id;
		this.name=name;
		this.prfMark=prfMark;
		this.dbmsMark=dbmsMark;
	}
	public String getStudentDetails(){
		return id+"\t"+name+"\t"+prfMark+"\t"+dbmsMark;
	}
	public int getPrfMarks(){
		return prfMark;
	}
	public String getId(){
		return id;
	}
}
class Demo{	
	public static Student[] studentArray=new Student[]{
		new Student("S001","Nimal",56,78),
		new Student("S002","Anil",67,78),
		new Student("S003","Bimal",89,78),
		new Student("S004","Amal",99,98),
		new Student("S005","Rani",19,18),
	};
	
	public static void searchStudent(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Student ID : ");
		String stID=input.next();
		int index=indexOf(stID);
		if(index!=-1){
			System.out.println(studentArray[index].getStudentDetails());
		}
	}
	
	public static boolean removeStudent(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Student ID : ");
		String stID=input.next();
		int index=indexOf(stID);
		if(index>=0 && index<studentArray.length){
			for (int i = index; i < studentArray.length-1; i++)	{
				studentArray[i]=studentArray[i+1];
			}
			Student[] tempStudentArray=new Student[studentArray.length-1];
			for (int i = 0; i < tempStudentArray.length; i++){
				tempStudentArray[i]=studentArray[i];
			}
			studentArray=tempStudentArray;
			return true;
		}
		return false;
	}
	public static int indexOf(String stId){
		for(int i=0; i<studentArray.length; i++){
			if(studentArray[i].getId().equalsIgnoreCase(stId)){
				return i;
			}
		}
		return -1;
	}
	public static void addStudent(){
		String id="S0001";
		String name="Niroth";
		int prfMark=67;
		int dbmsMark=77;
		
		Student s1=new Student(id,name,prfMark,dbmsMark);
		extendsStudentArray();
		studentArray[studentArray.length-1]=s1;
	}
	public static void extendsStudentArray(){
		Student[] tempStudentArray=new Student[studentArray.length+1];
		for (int i = 0; i < studentArray.length; i++){
			tempStudentArray[i]=studentArray[i];
		}
		studentArray=tempStudentArray;
	}
	public static void printStudents(){
		System.out.println("StID\tName\tPRF\tDBMS");
		System.out.println("============================");
		for (int i = 0; i < studentArray.length; i++){
			Student s1=studentArray[i];
			System.out.println(s1.getStudentDetails());
		}
	}
	public static void bestInPrf(){
		Student[] tempStudentArray=new Student[studentArray.length];
		for (int i = 0; i < studentArray.length; i++){
			tempStudentArray[i]=studentArray[i];
		}
		//sorting
		for(int i=studentArray.length-1; i>0; i--){
			for(int j=0;j<i; j++){
				if(tempStudentArray[j].getPrfMarks()<tempStudentArray[j+1].getPrfMarks()){
					Student tempStudent=tempStudentArray[j];
					tempStudentArray[j]=tempStudentArray[j+1];
					tempStudentArray[j+1]=tempStudent;
				}
			}
		}
		System.out.println("StID\tName\tPRF\tDBMS");
		System.out.println("============================");
		for (int i = 0; i < tempStudentArray.length; i++){
			Student s1=tempStudentArray[i];
			System.out.println(s1.getStudentDetails());
		}
	}
	public static void main(String args[]){
		printStudents();
		System.out.println();
		bestInPrf();
		System.out.println();
		searchStudent();
		System.out.println();
		removeStudent();
		printStudents();
	}	
}


