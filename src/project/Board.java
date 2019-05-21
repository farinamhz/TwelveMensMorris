package project;
import javax.swing.JOptionPane;
import java.math.*;

public class Board 
{
    public static int zamin[][][]=new int [3][3][3]; // (-2):not exist , (-1):no body , (0,1) : number player owner
    public static void set_zamin()
     {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    zamin[i][j][k]=-1;
                }
            }
        }
        zamin[1][1][0]=zamin[1][1][1]=zamin[1][1][2]=-2;
    }
    public boolean put_checking(int x,int y,int z)
    {
        return zamin[x][y][z]==-1;
    }
    public void put(int x,int y,int z)
    {       
        Frame.change_icon(x, y, z,Game.player_on, 0);
        zamin[x][y][z]=Game.player_on;
        Game.player[Game.player_on].checker[Game.player[Game.player_on].used_checker].x=x;
        Game.player[Game.player_on].checker[Game.player[Game.player_on].used_checker].y=y;
        Game.player[Game.player_on].checker[Game.player[Game.player_on].used_checker].z=z;
        Game.player[Game.player_on].checker[Game.player[Game.player_on].used_checker].mode=1;
        Game.player[Game.player_on].used_checker++;
        Game.player[Game.player_on].onboard_checker++;
        Frame.set_checker_remaine(Game.player[0].used_checker,Game.player[1].used_checker);
        set_weight(x, y, z, 1);
    }
    public boolean pop_checking(int x,int y,int z,int mode)
    {
        if(zamin[x][y][z]==Game.player_off)
        {
            for(int i=0;i<12;i++)
            {
                if(x==Game.player[Game.player_off].checker[i].x&&y==Game.player[Game.player_off].checker[i].y&&z==Game.player[Game.player_off].checker[i].z&&Game.player[Game.player_off].checker[i].mode==1)
                {
                    if(mode==1&&Game.player[Game.player_off].checker[i].doz_weight==0)
                        return true;
                    else if(mode==2&&Game.player[Game.player_off].checker[i].doz_weight!=0)
                        return true;
                }
            } 
        }
        return false;
    }
    public void pop(int x,int y,int z)
    {
        set_weight(x, y, z,2);
        Frame.change_icon(x, y, z,Game.player_on, 2);
        zamin[x][y][z]=-1;
        for(int i=0;i<12;i++)
        {
            if(Game.player[Game.player_off].checker[i].mode!=1)
                continue;
            if(Game.player[Game.player_off].checker[i].x==x&&Game.player[Game.player_off].checker[i].y==y&&Game.player[Game.player_off].checker[i].z==z)
                Game.player[Game.player_off].checker[i].mode=2;
        }
        Game.player[Game.player_on].onboard_checker--;        
    }
    public boolean move_checking(int x,int y,int z,int a,int b,int c)
    {
        if(zamin[x][y][z]==Game.player_on&&zamin[a][b][c]==-1)
        {
            if(x==a&&y==b&&(z-c==-1||z-c==1))
                    return true;
            else if(x==a&&z==c&&(y-b==-1||y-b==1))
                    return true;
            else if(z==c&&y==b&&(x-a==-1||x-a==1))
                    return true;
        }
        return false;
    }
    public boolean fly_checking(int x,int y,int z,int a,int b,int c)
    {
        return zamin[x][y][z]==Game.player_on&&zamin[a][b][c]==-1;
    }  
    public void move(int x,int y,int z,int a,int b,int c)
    {
        set_weight(x, y, z,3);
        Frame.change_icon(x, y, z,Game.player_on, 1);
        Frame.change_icon(a, b, c,Game.player_on, 0);
        zamin[a][b][c]=Game.player_on;
        zamin[x][y][z]=-1;
        for(int i=0;i<12;i++)
        {
            if(Game.player[Game.player_on].checker[i].mode!=1)
                continue;
            if(Game.player[Game.player_on].checker[i].x==x&&Game.player[Game.player_on].checker[i].y==y&&Game.player[Game.player_on].checker[i].z==z)
            {
                Game.player[Game.player_on].checker[i].x=a;
                Game.player[Game.player_on].checker[i].y=b;
                Game.player[Game.player_on].checker[i].z=c;        
            }
        }
        set_weight(a, b, c, 4);
    } 
    public boolean doz_checking()
    {
      int x,y,z;
      if(Game.game_mode==0)
      {
          x=Frame.x1;  y=Frame.y1;  z=Frame.z1;
      }
      else
      {
          x=Frame.x2;  y=Frame.y2;  z=Frame.z2;
      }
     for(int i=0;i<12;i++)
     {
         if(Game.player[Game.player_on].checker[i].mode!=1)
             continue;
         for(int j=i+1;j<12;j++)
         {
             if(Game.player[Game.player_on].checker[j].mode!=1)
                 continue;
             for(int k=j+1;k<12;k++)
             {
                 if(Game.player[Game.player_on].checker[k].mode!=1)
                     continue;
                 int a1,a2,a3,b1,b2,b3,c1,c2,c3;
                 a1=Game.player[Game.player_on].checker[i].x;
                 b1=Game.player[Game.player_on].checker[i].y;
                 c1=Game.player[Game.player_on].checker[i].z; 
                 a2=Game.player[Game.player_on].checker[j].x;
                 b2=Game.player[Game.player_on].checker[j].y;
                 c2=Game.player[Game.player_on].checker[j].z; 
                 a3=Game.player[Game.player_on].checker[k].x;
                 b3=Game.player[Game.player_on].checker[k].y;
                 c3=Game.player[Game.player_on].checker[k].z;
                 if((x==a1&&y==b1&&z==c1)||(x==a2&&y==b2&&z==c2)||(x==a3&&y==b3&&z==c3))
                 {
                     if(a1==a2&&a1==a3&&b1==b2&&b1==b3)
                         return true;
                     else if(a1==a2&&a1==a3&&c1==c2&&c1==c3)
                         return true;
                     else if(b1==b2&&b1==b3&&c1==c2&&c1==c3)                 
                         return true;
                 }
             }
         }
     }
     return false;
    }
    public void doz()
    {
        int mode;  // 1:pop_notdoze  2:pop_doze
        //JOptionPane.showMessageDialog(null,"Doze happened",null,2);
        while(true)
        {
            int number=0;
            for(int i=0;i<12;i++)
            if(Game.player[Game.player_off].checker[i].doz_weight==0&&Game.player[Game.player_off].checker[i].mode==1)
                number++;
            if(number!=0)
                mode=1;
            else
                mode=2;
            Frame.set_possibility(mode);
            Frame.set_icon();
            
            Frame.click_mode=2;
            String s=String.format("Please select on of %s's checkers to pop it.",Game.player[Game.player_off].name);
            Frame.setaction(Game.player[Game.player_on].name,s);
            while(Frame.click_mode!=0)
                {Game.delay(200);Frame.set_icon();}
            if(pop_checking(Frame.x1,Frame.y1,Frame.z1,mode)==true)   
                break;  
            Frame.play_music(4);
            JOptionPane.showMessageDialog(null,"Wrong selection\n try again ",null,2);
        }
        pop(Frame.x1,Frame.y1,Frame.z1);        
    }
    public static void set_weight(int x,int y,int z,int mode)
    {
        //mode 1:put  2:pop   3:move_start  4:move_end
        int t=0,r=0;
        if(mode==1)
        {
            t=Game.player_on;
            r=1;
        }
        else if(mode==2)
        {
            t=Game.player_off;
            r=-1;
        }
        else if(mode==3)
        {
            t=Game.player_on;
            r=-1;
        }
        else if(mode==4)
        {
            t=Game.player_on;
            r=1;
        }
        if(Board.zamin[0][y][z]==t&&Board.zamin[1][y][z]==t&&Board.zamin[2][y][z]==t)
        {
            for(int i=0;i<12;i++)
              {
                  if(y==Game.player[t].checker[i].y&&z==Game.player[t].checker[i].z&&Game.player[t].checker[i].mode==1)
                  {
                      Game.player[t].checker[i].doz_weight+=r;
                  }
              } 
        }
        if(Board.zamin[x][0][z]==t&&Board.zamin[x][1][z]==t&&Board.zamin[x][2][z]==t)
        {
          for(int i=0;i<12;i++)
            {
                if(x==Game.player[t].checker[i].x&&z==Game.player[t].checker[i].z&&Game.player[t].checker[i].mode==1)
                {
                    Game.player[t].checker[i].doz_weight+=r;
                }
            } 
        }
      if(Board.zamin[x][y][0]==t&&Board.zamin[x][y][1]==t&&Board.zamin[x][y][2]==t)
      {
          for(int i=0;i<12;i++)
            {
                if(y==Game.player[t].checker[i].y&&x==Game.player[t].checker[i].x&&Game.player[t].checker[i].mode==1)
                {
                    Game.player[t].checker[i].doz_weight+=r;
                }
            } 
      }  
    }
}
