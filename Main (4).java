import java.util.*;
class Player
{
    private int playerId;
    private String skill;
    private String level;
    private int points;
    
    Player(int id,String skil,String level,int point)
    {
        this.playerId=id;
        this.skill=skil;
        this.level=level;
        this.points=point;
    }
    public int get_playerId()
    {
        return this.playerId;
    }
    public String get_skill()
    {
        return this.skill;
    }
    public String get_level()
    {
        return this.level;
    }
    public int get_points()
    {
        return this.points;
    }
    
    
}
class Main 
{
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        Player[] players=new Player[4];
        for(int i=0;i<4;i++)
        {
        int id=sc.nextInt();
        sc.nextLine();
        String a=sc.nextLine();
        String b=sc.nextLine();
        int point=sc.nextInt();
        
        players[i]=new Player(id,a,b,point);
        
        }
        sc.nextLine();
        String temp=sc.nextLine();
        String temm=sc.nextLine();
        int res=findPointsForGivenSkill(players,temp);
        if(res>0)
        System.out.println(res);
        else
        System.out.println("The given Skill is not available");
        
        
        //----------------------------------------------------------
        Player[] player=getPlayerBasedOnLevel(players,temm,temp);
        
        if(player!=null)
        {
            for(int i=0;i<player.length;i++)
            System.out.println(player[i].get_playerId());
            
        }
        else
        {
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
        
    }
    static int findPointsForGivenSkill(Player[] players,String skill)
    {
        int point=0;
        for(int i=0;i<players.length;i++)
        {
            if(players[i].get_skill().equalsIgnoreCase(skill))
            point+=players[i].get_points();
            
        }
        return point;
    }
    static Player[] getPlayerBasedOnLevel(Player[] players,String level,String skill)
    {
        ArrayList<Player>to_ret=new ArrayList<Player>();
       for(int i=0;i<players.length;i++)
       {
           if(players[i].get_skill().equalsIgnoreCase(skill) && players[i].get_level().equalsIgnoreCase(level) && players[i].get_points()>=20)
           {
               to_ret.add(players[i]);
               
           }
           
       }
       
       if(to_ret.size()>0)
       {
           Player[] emp=new Player[to_ret.size()];
           to_ret.toArray(emp);
           return emp;
           
       }
       else
       {
           return null;
       }
       
       
    }
}