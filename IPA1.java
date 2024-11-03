import java.util.*;
class Course
{
    
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;
    Course(int id,String name,String admin,int quiz,int handson)
    {
        courseId=id;
        courseAdmin=admin;
        courseName=name;
        this.quiz=quiz;
        this.handson=handson;
    }
    public int getCouseId()
    {
        return this.courseId;
    }
    public String getCourseName()
    {
        return this.courseName;
    }
    public String getCourseAdmin()
    {
        return this.courseAdmin;
    }
    public int getQuiz()
    {
        return this.quiz;
    }
    public int getHandson()
    {
        return this.handson;
    }
    
    
}

class sortby implements Comparator<Course>
{
    public int compare(Course a,Course b)
    {
        return a.getHandson()-b.getHandson();
    }
}
class Main 
{
    public static void main(String args[])
    {
        Course[] courses=new Course[4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<courses.length;i++)
        {
            int id=sc.nextInt();
            sc.nextLine();
            String a=sc.nextLine();
            String b=sc.nextLine();
            int c=sc.nextInt();
            int hand=sc.nextInt();
            
            courses[i]=new Course(id,a,b,c,hand);
        }
        
        sc.nextLine();
        String to_find=sc.nextLine(); int x=sc.nextInt();
        double k=findAvgOfQuiz(courses,to_find);
        if(k==0)
        System.out.printf("\nNo Course Found\n");
        else
        System.out.println(k);
        
       
        Course[] course=sortCourseByHandsOn(courses,x);
        if(course==null)
        System.out.println("No Course found with method attribute");
        else
        {
            for(int i=0;i<course.length;i++)
            {
                System.out.println(course[i].getCourseName());
            }
        }
        
        
        
    }
    static double findAvgOfQuiz(Course[] courses,String value)
    {
        
        double avg=0;
        int count=0;
        for(int i=0;i<courses.length;i++)
        {
           if(courses[i].getCourseAdmin().equalsIgnoreCase(value))
           {
               count++;
               avg+=courses[i].getQuiz();
               
           }
            
        }
        
        return count == 0 ? 0 : (avg / count);
    }
    

static Course[] sortCourseByHandsOn(Course[] courses,int value)
{
    ArrayList<Course> ar=new ArrayList<Course>();
    for(int i=0;i<courses.length;i++)
    {
    if(courses[i].getHandson()<value)
    ar.add(courses[i]);
   // System.out.println("------"+ar+"---------");
    
    }
    
    if(ar.isEmpty())
    return null;
    else
    {
        Collections.sort(ar,new sortby());
         Course[] toret=new Course[ar.size()];
         ar.toArray(toret);
      //  System.out.println("------"+toret.length+" -----------");
         return toret;
        
    }
    
    //return null;
    
    
}
}
