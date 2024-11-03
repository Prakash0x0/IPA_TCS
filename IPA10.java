import java.util.*;
class Employee
{
    
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean transport;
    
    Employee(int id,String name,String branch,double rating,boolean transport)
    {
        this.employeeId=id;
        this.name=name;
        this.branch=branch;
        this.rating=rating;
        this.transport=transport;
    }
    
    public int getEmpId()
    {
        return this.employeeId;
    }
    public String getName()
    {
        return this.name;
        
    }
    public String getBranch()
    {
        return this.branch;
    }
    public double getRating()
    {
        return this.rating;
    }
    public boolean getTransport()
    {
       return this.transport;
    }
    
    
}
 class ToSort implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return Double.compare(b.getRating(), a.getRating());
    }
}

class Main 
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Employee[] employees=new Employee[4];
        for(int i=0;i<4;i++)
        {
            int id=sc.nextInt(); 
            sc.nextLine();
            String a=sc.nextLine();
            String b=sc.nextLine();
            double k=sc.nextDouble();
            sc.nextLine();
           boolean boo = Boolean.parseBoolean(sc.nextLine());

            employees[i]=new Employee(id,a,b,k,boo);
            
        }
       String s=sc.nextLine();
       
        int count=findcount(employees,s);
        if(count>0)
        System.out.println(count);
        else
        System.out.println("No such Employees");
        Employee fin=findEmployee(employees);
        if(fin==null)
        System.out.println("All Employess using company Transport");
        else
        {
            
            {
                System.out.println(fin.getEmpId()+"\n"+fin.getName());
            }
            
        }
        
        
        
    }
    static int  findcount(Employee[] employees,String val)
    {
        int count=0;
        for(int i=0;i<employees.length;i++)
        {
            if(employees[i].getBranch().equalsIgnoreCase(val)&&employees[i].getTransport())
            {
                count++;
                
            }
            
        }
        return count;
        
    }
    static Employee findEmployee(Employee[] employees)
    {
        ArrayList<Employee>emp=new ArrayList<Employee>();
        
        for(int i=0;i<employees.length;i++)
        {
            if(employees[i].getTransport()==false)
            {
                
                if(emp.contains(employees[i]))continue;
                else
                emp.add(employees[i]);
                
                
            }
            
        }
        Collections.sort(emp,new ToSort());
        if(emp.size()>1)
        return emp.get(1);
        else
        return null;
        
        
    }
    
}
