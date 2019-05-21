package project;

import javax.swing.JOptionPane;
public class Game 
{
    String name,n3;
    public static int game_mode; // mode 0: put , mode 1: move , mode 2: fly
    public static int player_on,player_off; // on: player turn true , off: player turn false
    public static Player player[];
    Board board=new Board();
    public Game(String n)
    {
        name=n;
        player=new Player[2];
    }
    public void setPlayer(int x,Player p)
    {
        player[x]=p;
    }
    public void start()
    {
        game_mode=0;
        player[0].turn=false;
        player[1].turn=false;
        player[0].setplayer_for_start();
        player[1].setplayer_for_start();
        Board.set_zamin();
        Frame.set_frame();
        Frame.setname(player[0].name,player[1].name);
        String s1=String.format("%d",player[0].score),s2=String.format("%d",player[1].score);
        Frame.setscore(s1,s2);
    }
    public void finish()
    {    
        Frame.play_music(2);
        n3=String.format("%s win!!",Game.player[Game.player_on].name);
        JOptionPane.showMessageDialog(null,"Game finish\n"+n3,null,2);
        player[player_on].score++;
        String s1=String.format("%d",player[0].score),s2=String.format("%d",player[1].score);
        Frame.setscore(s1,s2);
    }
    public void change_turn()
    {
        if(player[0].turn==false)
        {
            player[0].turn=true;            
            player[1].turn=false;
            player_on=0;
            player_off=1;
            Frame.setturn(true);
        }
        else
        {
            player[0].turn=false;
            player[1].turn=true;
            player_on=1;
            player_off=0;
            Frame.setturn(false);
        }
    }
    public void game_mode_seter()
    {
        if(player[0].used_checker==12&&player[1].used_checker==12)
        {
            if(player[player_off].onboard_checker==4)
                game_mode=2;
            else
                game_mode=1;
        }
        else
            game_mode=0;
    }
    public void game_mode_checker()
    {
        if(game_mode==0)
        {
            Frame.setaction(player[player_on].name,"Please select correct place to put your checker");
            while(true)
            {
                Frame.set_possibility(0);
                Frame.click_mode=1;                
                while(Frame.click_mode!=0)
                    {delay(200);Frame.set_icon();}
                if(board.put_checking(Frame.x1,Frame.y1,Frame.z1)==true)   
                    break;  
                Frame.play_music(4);
                JOptionPane.showMessageDialog(null,"Wrong selection\n try again ",null,2);
            }
            board.put(Frame.x1,Frame.y1,Frame.z1);
        }
        else if(game_mode==1||game_mode==2)
        {
            if(game_mode==2)
            {
                Frame.play_music(6);
                JOptionPane.showMessageDialog(null,"Flying mode",null,2);
            }
            Frame.setaction(player[player_on].name,"Please move one of your checker");                
            while(true)
            {
                Frame.set_possibility(3);
                Frame.click_mode=3;
                while(Frame.click_mode!=0)
                    {delay(200);Frame.set_icon();}
                if(game_mode==1)
                    Frame.set_possibility(4);
                else
                    Frame.set_possibility(5);
                Frame.click_mode=4;
                while(Frame.click_mode!=0)
                    {delay(200);Frame.set_icon();}
                if(board.move_checking(Frame.x1,Frame.y1,Frame.z1,Frame.x2,Frame.y2,Frame.z2)==true && game_mode==1)
                    break;
                if(board.fly_checking(Frame.x1,Frame.y1,Frame.z1,Frame.x2,Frame.y2,Frame.z2)==true && game_mode==2)
                    break;
                Frame.play_music(4);
                JOptionPane.showMessageDialog(null,"Wrong action\n try again ",null,2);
            }
            board.move(Frame.x1,Frame.y1,Frame.z1,Frame.x2,Frame.y2,Frame.z2);
        }   
    }
    public int finish_checking()
    {
        if(game_mode!=0)
        {
            if(player[player_on].onboard_checker<3)
                return player_on;
        }
        return -1;
    }
    public static void delay(int x)
    {
        try {
            Thread.sleep(x);
            } catch (InterruptedException ie) {
            ie.printStackTrace();}
    }
}
