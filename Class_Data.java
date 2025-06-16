class Student{
    String name="Pavan";
    int roll=283;
    String branch="EEE";
    float cgpa=7.93f;
}
class Employee{
    String name="Manoj";
    String role="java";
    int id=1205;
    float salary=400000.78f;
}
class Main{
    public static void main(String args[]){
        Student s=new Student();
        System.out.println("Name :"+s.name);
        System.out.println("Roll :"+s.roll);
        System.out.println("Branch :"+s.branch);
        System.out.println("Cgpa :"+s.cgpa);
        System.out.println();
        
        Employee e=new Employee();
        System.out.println("Name :"+e.name);
        System.out.println("Role :"+e.role);
        System.out.println("Id :"+e.id);
        System.out.println("Salary :"+e.salary);
    }
}