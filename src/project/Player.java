package project;
public class Player 
{
    String name;
    int total_checker;
    int used_checker;
    int onboard_checker;
    boolean turn;
    int score;
    Checker checker[];
    public Player(String n)
    {
        name=n;
        score=0;
        checker=new Checker[12];
        for(int i=0;i<12;i++)
            checker[i]=new Checker();
    }
    public void setplayer_for_start()
    {
        total_checker=12;
        used_checker=0;
        onboard_checker=0;
        turn=false;
        for(int i=0;i<12;i++)
            checker[i].mode=0;
    }
}
