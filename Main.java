import java.util.*;

class Employee
{
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;
    
    Employee(int id,String name,int age,char gender,double sal)
    {
        employeeId=id;
        employeeName=name;
        this.age=age;
        this.gender=gender;
        salary=sal;
    }
    public void set_empid(int id)
    {
        this.employeeId=id;
    }
    public void set_empName(String  name)
    {
        this.employeeName=name;
        
    }
   public  void set_empage(int age)
    {
        
        this.age=age;
    }
   public void set_gender(char c)
    {
        this.gender=c;
    }
  public   void set_salary(double sal)
    {
        this.salary=sal;
    }
    
    public int get_empid()
    {
        return this.employeeId;
    }
    public String get_empName()
    {
        return this.employeeName;
    }
    public int get_age()
    {
        return this.age;
    }
    public char get_gender()
    {
        return this.gender;
    }
    public double get_salary()
    {
        return this.salary;
    }
}
public class Main
{
	public static void main(String[] args) {
	   Scanner sc= new Scanner(System.in);
	  int  n= sc.nextInt();
	  Employee[] employees=new Employee[n];
	  for(int i=0;i<n;i++)
	  {
	      int id=sc.nextInt();
	      sc.nextLine();
	      String name=sc.nextLine();
	      int age=sc.nextInt();sc.nextLine();
	      char gender=sc.nextLine().charAt(0);
	      double sal=sc.nextDouble();
	   employees[i]= new Employee(id,name,age,gender,sal); 
	  }
	   int empage=sc.nextInt();
	  //====================================================
	  Employee[] res=getEmployeeWithSecondSal(employees);
	  if(res.length>0)
	  {
	      for(int i=0;i<res.length;i++)
	      System.out.println(res[i].get_empid()+"#"+res[i].get_empName());
	      
	  }
	  else
	  {
	     System.out.println("Null");
	  }
	  
	int count=countEmployeesBasesdOnAge(employees,empage);
    	System.out.println(count);
	}
	//============================================================================================
	
	static Employee[] getEmployeeWithSecondSal(Employee[] employees)
	{
	       
	       ArrayList<Double> ar=new ArrayList<Double>();
	    if(employees.length<2)
	    {
	        return null;
	    }
	    else
	    {
	        for(int i=0;i<employees.length;i++)
	        {
	            if(ar.contains(employees[i].get_salary()))
	            {
	                continue;
	                
	            }
	            else
	            {
	                ar.add(employees[i].get_salary());
	                
	            }
	            
	        }
	        
	        Collections.sort(ar);
	        
	        
	    }
	    
	    ArrayList<Employee>temp=new ArrayList<Employee>();
	    for(int i=0;i<employees.length;i++)
	    {
	        if(employees[i].get_salary()==ar.get(1))
    	       temp.add(employees[i]);
	        
	        
	    }
	    
	    if(temp.isEmpty())
	    return null;
	    else
	    {
	        Employee[] to_send=new Employee[temp.size()];
	        return temp.toArray(to_send);
	    }
	}
	
	static int countEmployeesBasesdOnAge(Employee[] employees,int age)
	{
	    int count=0;
	    for(int i=0;i<employees.length;i++)
	    {
	       if(employees[i].get_age()==age)
	       count++;
	    }
	    return count;
	    
	    
	    
	}
}