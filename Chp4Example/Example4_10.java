//判断奖学金例程
class Student{
	String name;
	static final String classNumber="0811";
	private double average;
	private int salary;
	public String getName(){return name;}
	public String getClassNumber(){return classNumber;}
	public double getAverage(){return average;}
	public int getSalary(){return salary;}
	public Student(String n,double a,int s){
		name=n;
		average=a;
		salary=s;
	}
}
public class Example4_10{
	public static void main(String args[]){
		Student[] stu=new Student[4];
		stu[0]=new Student("Mary",95,50000);
		stu[1]=new Student("John",78,30000);
		stu[2]=new Student("Bill",84,10000);
		stu[3]=new Student("Rose",67,40000);
		System.out.println("Class Number:"+Student.classNumber);
		for(int i=0;i<stu.length;i++){
			Student s=stu[i];
			System.out.println("Name:"+s.getName()+"|Average:"+s.getAverage()+"|salary:"+s.getSalary());}
		boolean b=false;
		for(int i=0;i<stu.length;i++){
			Student s=stu[i];
			if(s.getAverage()>=95||s.getSalary()<=12000)System.out.println(s.getName()+"获得奖学金");
			b=true;}
		if(b!=true)System.out.println("无人获得奖学金！");			
	}
}
