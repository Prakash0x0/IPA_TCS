import java.util.*;
class Employee
{
    private int id;
    private String name;
    private String designation;
    private double salary;
    
    
    Employee(int id,String name,String deg,double sal)
    {
        this.id=id;
        this.name=name;
        designation=deg;
        salary=sal;
    }
    public int get_id()
    {
        return id;
    }
    public String get_name()
    {
        return name;
    }
    public String get_designation()
    {
        return designation;
    }
    public double get_salary()
    {
        return salary;
    }
}
class Company
{
    private String companyName;
    private Employee[] employees;
    private int numemployees;
    Company(String companyName,Employee[] employees,int numemployees)
    {
        this.companyName=companyName;
        this.employees=employees;
        this.numemployees=numemployees;
    }
    public String getCompanyName()
    {
        return this.companyName;
    }
    public Employee[] getEmpArr()
    {
        return this.employees;
    }
    public int getNumEmp()
    {
       return this.numemployees;
    }
    
    public double getAvgSal()
    {
        int count=0;
        for(int i=0;i<employees.length;i++)
        {
            count+=this.employees[i].get_salary();
            
        }
        return count/this.numemployees;
        
        
        
        
        
    }
    public double getMaxSal()
    {
        double max=-1;
        for(int i=0;i<employees.length;i++)
        {
            if(this.employees[i].get_salary()>max)
            max=this.employees[i].get_salary();
        }
       return max; 
    }
    public Employee[] getEmployeesDesignation(String des)
    {
       ArrayList<Employee>to_ret=new ArrayList<Employee>();
       for(int i=0;i<employees.length;i++)
       {
           if(this.employees[i].get_designation().equalsIgnoreCase(des))
           to_ret.add(employees[i]);
       }
       Employee[] to=new Employee[to_ret.size()];
       return to_ret.toArray(to);
    }
}
class Main 
{
   public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
       String company_name= sc.nextLine();
       int num_emp=sc.nextInt();
              Employee[] e=new Employee[num_emp];
       for(int i=0;i<num_emp;i++)
       {
           
           int id=sc.nextInt();
           sc.nextLine();
           String empName=sc.nextLine();
           String empDesig=sc.nextLine();
           double sal=sc.nextDouble();
         e[i]=new  Employee(id,empName,empDesig,sal);
       }
      Company c=new  Company(company_name,e,num_emp);
        
        System.out.println("Average Salary: "+c.getAvgSal());
        System.out.println("Max Salary: "+c.getMaxSal());
        sc.nextLine();
        //-------------------------------------------------------------------------------------------------
        String Desig=sc.nextLine();
        Employee[] show=c.getEmployeesDesignation(Desig);
        System.out.println("Employees with Desiganation:"+Desig);
        for(int i=0;i<show.length;i++)
        if(show[i].get_designation().equalsIgnoreCase(Desig))
        System.out.println("ID: "+show[i].get_id()+" Name:  "+show[i].get_name()+" Desiganation: "+show[i].get_designation()+"  Salary: "+show[i].get_salary());
        
   }
        
}
