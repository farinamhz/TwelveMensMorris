package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class Frame 
{
    public static JFrame f;
    public static boolean possibility [][][]=new boolean [3][3][3];
    JMenu file,about;
    JMenuItem new_game,next_round,exit,about_game,history_game,game_rules;
    public static JButton A1,A2,A3,A4,A5,A6,A7,A8,B1,B2,B3,B4,B5,B6,B7,B8,C1,C2,C3,C4,C5,C6,C7,C8;
    public static JLabel zamin,Player1,player2,name,name1,name2,score,score1,score2,checker,checker1,checker2,remain1,remain2,action,action1,action2,turn,turn1,turn2,action3,action4;
    public static JLabel w20,w21,w22,w12,w2,w1,w0,w10,w120,w121,w122,w112,w102,w101,w100,w110,w220,w221,w222,w212,w202,w201,w200,w210;
    public static int click_mode; // mode 0: no action , mode 1: put , mode 2: pop , mode 3: move start , mode 4: move end
    public static boolean click_permission=false,newgame=false,newround=false;
    public static int x1,y1,z1,x2,y2,z2,k1,k2,k3; //مختصات مبدا و مقصد
    Frame()
    {
        f=new JFrame("Twelve men's morris");
        f.setSize(2000,1500);
        f.setLayout(null);
        f.setDefaultCloseOperation(3);
        JMenuBar menu=new JMenuBar();
        file=new JMenu("File");
        about=new JMenu("About");
        new_game=new JMenuItem("New Game");
        next_round=new JMenuItem("New Round");
        about_game=new JMenuItem("About Game");
        history_game=new JMenuItem("History of Game");
        game_rules=new JMenuItem("Rules");
        exit=new JMenuItem("Exit");
        zamin=new JLabel(new ImageIcon("pic\\Board.png"));
        zamin.setBounds(700, 300, 399, 368);
        Player1=new JLabel("Player 1");
        Player1.setBounds(1450, 230, 50, 50);
        player2=new JLabel("Player 2");
        player2.setBounds(1600, 230, 50, 50);
        name=new JLabel("Name :");
        name.setBounds(1300, 280, 50, 50);
        score=new JLabel("Score :");
        score.setBounds(1300, 330, 50, 50);
        turn=new JLabel("Turn :");
        turn.setBounds(1300, 380, 50, 50);
        checker=new JLabel("Checker remaine :");
        checker.setBounds(1300, 425,150, 80);
        name1=new JLabel();
        name1.setBounds(1460, 230, 50, 150);
        name2=new JLabel();
        name2.setBounds(1610, 230, 50, 150);
        score1=new JLabel();
        score1.setBounds(1465, 280, 50, 150);
        score2=new JLabel();
        score2.setBounds(1615, 280, 50, 150);
        turn1=new JLabel(new ImageIcon("pic\\000.png"));
        turn1.setBounds(1450, 380, 40, 40);
        turn2=new JLabel(new ImageIcon("pic\\111.png"));
        turn2.setBounds(1600, 380, 40, 40);
        checker1=new JLabel(new ImageIcon("pic\\turn111.png"));
        checker1.setBounds(1450, 440, 50, 50);
        checker2=new JLabel(new ImageIcon("pic\\turn222.png"));
        checker2.setBounds(1600, 440, 50, 50);
        remain1=new JLabel("12");
        remain1.setBounds(1467, 455, 20, 20);
        remain2=new JLabel("12");
        remain2.setBounds(1617, 455, 20, 20);
        action=new JLabel("Action :");
        action.setBounds(1300, 500, 50, 50);
        action1=new JLabel("name :");
        action1.setBounds(1460, 500, 300, 50);
        action2=new JLabel(new ImageIcon("pic\\action.png"));
        action2.setBounds(1450, 510, 300, 30);
        action3=new JLabel(new ImageIcon("pic\\action.png"));
        action3.setBounds(1450, 540, 300, 30);
        action4=new JLabel();
        action4.setBounds(1460, 530, 300, 30);
        
        w20=new JLabel(new ImageIcon("pic\\w20.png"));
        w20.setBounds(718,311,44, 44);
        w21=new JLabel(new ImageIcon("pic\\w21.png"));
        w21.setBounds(880,311,44, 44);
        w22=new JLabel(new ImageIcon("pic\\w22.png"));
        w22.setBounds(1041,311,44, 44);
        w12=new JLabel(new ImageIcon("pic\\w12.png"));
        w12.setBounds(1041,461,44, 44);
        w2=new JLabel(new ImageIcon("pic\\w2.png"));
        w2.setBounds(1041,611,44, 44);
        w1=new JLabel(new ImageIcon("pic\\w1.png"));
        w1.setBounds(880,611,44, 44);
        w0=new JLabel(new ImageIcon("pic\\w0.png"));
        w0.setBounds(718,611,44, 44);
        w10=new JLabel(new ImageIcon("pic\\w10.png"));
        w10.setBounds(718,461,44, 44);
        
        w120=new JLabel(new ImageIcon("pic\\w120.png"));
        w120.setBounds(772,361,44, 44);
        w121=new JLabel(new ImageIcon("pic\\w121.png"));
        w121.setBounds(880,361,44, 44);
        w122=new JLabel(new ImageIcon("pic\\w122.png"));
        w122.setBounds(987,361,44, 44);
        w112=new JLabel(new ImageIcon("pic\\w112.png"));
        w112.setBounds(987,461,44, 44);
        w102=new JLabel(new ImageIcon("pic\\w102.png"));
        w102.setBounds(987,561,44, 44);
        w101=new JLabel(new ImageIcon("pic\\w101.png"));
        w101.setBounds(880,561,44, 44);
        w100=new JLabel(new ImageIcon("pic\\w100.png"));
        w100.setBounds(772,561,44, 44);
        w110=new JLabel(new ImageIcon("pic\\w110.png"));
        w110.setBounds(772,461,44, 44);
        
        w220=new JLabel(new ImageIcon("pic\\w220.png"));
        w220.setBounds(826,411,44, 44);
        w221=new JLabel(new ImageIcon("pic\\w221.png"));
        w221.setBounds(880,411,44, 44);
        w222=new JLabel(new ImageIcon("pic\\w222.png"));
        w222.setBounds(933,411,44, 44);
        w212=new JLabel(new ImageIcon("pic\\w212.png"));
        w212.setBounds(934,461,44, 44);
        w202=new JLabel(new ImageIcon("pic\\w202.png"));
        w202.setBounds(933,511,44, 44);
        w201=new JLabel(new ImageIcon("pic\\w201.png"));
        w201.setBounds(879,511,44, 44);
        w200=new JLabel(new ImageIcon("pic\\w200.png"));
        w200.setBounds(826,511,44, 44);
        w210=new JLabel(new ImageIcon("pic\\w210.png"));
        w210.setBounds(826,461,44, 44);
        
        A1=new JButton(new ImageIcon("pic\\20.png"));
        A1.setBounds(720,313,40, 40);
        A2=new JButton(new ImageIcon("pic\\21.png"));
        A2.setBounds(882,313,40, 40);
        A3=new JButton(new ImageIcon("pic\\22.png"));
        A3.setBounds(1043,313,40, 40);
        A4=new JButton(new ImageIcon("pic\\12.png"));
        A4.setBounds(1043,463,40, 40);
        A5=new JButton(new ImageIcon("pic\\2.png"));
        A5.setBounds(1043,613,40, 40);
        A6=new JButton(new ImageIcon("pic\\1.png"));
        A6.setBounds(882,613,40, 40);
        A7=new JButton(new ImageIcon("pic\\0.png"));
        A7.setBounds(720,613,40, 40);
        A8=new JButton(new ImageIcon("pic\\10.png"));
        A8.setBounds(720,463,40, 40);
        
        B1=new JButton(new ImageIcon("pic\\120.png"));
        B1.setBounds(774,363,40, 40);
        B2=new JButton(new ImageIcon("pic\\121.png"));
        B2.setBounds(882,363,40, 40);
        B3=new JButton(new ImageIcon("pic\\122.png"));
        B3.setBounds(989,363,40, 40);
        B4=new JButton(new ImageIcon("pic\\112.png"));
        B4.setBounds(989,463,40, 40);
        B5=new JButton(new ImageIcon("pic\\102.png"));
        B5.setBounds(989,563,40, 40);
        B6=new JButton(new ImageIcon("pic\\101.png"));
        B6.setBounds(882,563,40, 40);
        B7=new JButton(new ImageIcon("pic\\100.png"));
        B7.setBounds(774,563,40, 40);
        B8=new JButton(new ImageIcon("pic\\110.png"));
        B8.setBounds(774,463,40, 40);
        
        C1=new JButton(new ImageIcon("pic\\220.png"));
        C1.setBounds(828,413,40, 40);
        C2=new JButton(new ImageIcon("pic\\221.png"));
        C2.setBounds(882,413,40, 40);
        C3=new JButton(new ImageIcon("pic\\222.png"));
        C3.setBounds(935,413,40, 40);
        C4=new JButton(new ImageIcon("pic\\212.png"));
        C4.setBounds(936,463,40, 40);
        C5=new JButton(new ImageIcon("pic\\202.png"));
        C5.setBounds(935,513,40, 40);
        C6=new JButton(new ImageIcon("pic\\201.png"));
        C6.setBounds(881,513,40, 40);
        C7=new JButton(new ImageIcon("pic\\200.png"));
        C7.setBounds(828,513,40, 40);
        C8=new JButton(new ImageIcon("pic\\210.png"));
        C8.setBounds(828,463,40, 40);
        
        A1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=2; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        A2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=1; k2=2; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }  
            }
        });
        A3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=2; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        A4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=1; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        A5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=0; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        A6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=1; k2=0; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        A7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=0; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        A8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=1; k3=0;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        
        B1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=2; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        B2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=1; k2=2; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        B3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=2; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        B4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=1; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        B5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=0; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        B6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=1; k2=0; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        B7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=0; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        B8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=1; k3=1;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        
        C1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=2; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        C2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=1; k2=2; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        C3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=2; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        C4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=1; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        C5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=2; k2=0; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        C6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=1; k2=0; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        C7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=0; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        C8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                k1=0; k2=1; k3=2;
                if(click_mode==1||click_mode==2||click_mode==3)
                {
                    x1=k1; y1=k2; z1=k3;
                    click_mode=0;
                }
                else if(click_mode==4)
                {
                    x2=k1; y2=k2; z2=k3;
                    click_mode=0;
                }
            }
        });
        
        new_game.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                Frame.play_music(5);
                newgame=true;
            }
        });
        next_round.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                Frame.play_music(5);
                newround=true;
            }
        });
        about_game.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                Frame.play_music(5);
                JOptionPane.showMessageDialog(null,new ImageIcon("pic\\about_game.png"),"About",1);
            }
        });
        history_game.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                Frame.play_music(5);
                JOptionPane.showMessageDialog(null,new ImageIcon("pic\\history_game.png"),"History",1);                
            }
        });
        game_rules.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                Frame.play_music(5);
                int a,t=1;
                do
                {
                    String s=String.format("pic\\rules_%d.png",t);
                    a=JOptionPane.showConfirmDialog(null,new ImageIcon(s),"Rules",1);
                    t++;
                }while(a==JOptionPane.YES_OPTION&&t<10);    
            }
        });
        exit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) 
            {
                Frame.play_music(5);
                System.exit(0);
            }
        });
        f.add(w20);f.add(w21);f.add(w22);f.add(w12);f.add(w2);f.add(w1);f.add(w0);f.add(w10);f.add(w120);f.add(w121);f.add(w122);f.add(w112);
        f.add(w102);f.add(w101);f.add(w100);f.add(w110);f.add(w220);f.add(w221);f.add(w222);f.add(w212);f.add(w202);f.add(w201);f.add(w200);f.add(w210);
        f.add(zamin);f.add(Player1);f.add(player2);f.add(name);f.add(score);f.add(turn);f.add(remain1);f.add(remain2);
        f.add(checker);f.add(name1);f.add(name2);f.add(score1);f.add(score2);f.add(action4);f.add(action3);
        f.add(turn1);f.add(turn2);f.add(checker1);f.add(checker2);f.add(action);f.add(action1);f.add(action2);
        f.add(A1);f.add(A2);f.add(A3);f.add(A4);f.add(A5);f.add(A6);f.add(A7);f.add(A8);
        f.add(B1);f.add(B2);f.add(B3);f.add(B4);f.add(B5);f.add(B6);f.add(B7);f.add(B8);
        f.add(C1);f.add(C2);f.add(C3);f.add(C4);f.add(C5);f.add(C6);f.add(C7);f.add(C8);
        file.add(new_game);file.add(next_round);about.add(about_game);about.add(history_game);about.add(game_rules);file.add(about);file.add(exit);
        menu.add(file);f.add(menu);
        f.setJMenuBar(menu);
        set_possibility(6);
        f.setVisible(true);
    }
    public static void change_icon(int x,int y,int z,int player,int mode)
    {
        //mode 0: put  1: move  2: pop  3: seting
        String address_icon;
        int address=x+10*y+100*z;
        if(mode==3)
        {
            if(Board.zamin[x][y][z]==0)
                address_icon=String.format("pic\\00.png");
            else if(Board.zamin[x][y][z]==1)
                address_icon=String.format("pic\\11.png");
            else
                address_icon=String.format("pic\\%d.png",address);
        }
        else if(mode==0)
            address_icon=String.format("pic\\%d%d.png",player,player);
        else
            address_icon=String.format("pic\\%d.png",address);            
        
        if(address==20)
             A1.setIcon(new ImageIcon(address_icon));
        if(address==21)
             A2.setIcon(new ImageIcon(address_icon));
        if(address==22)
             A3.setIcon(new ImageIcon(address_icon));
        if(address==12)
             A4.setIcon(new ImageIcon(address_icon));
        if(address==2)
             A5.setIcon(new ImageIcon(address_icon));
        if(address==1)
             A6.setIcon(new ImageIcon(address_icon));
        if(address==0)
             A7.setIcon(new ImageIcon(address_icon));
        if(address==10)
             A8.setIcon(new ImageIcon(address_icon));
        if(address==120)
             B1.setIcon(new ImageIcon(address_icon));
        if(address==121)
             B2.setIcon(new ImageIcon(address_icon));
        if(address==122)
             B3.setIcon(new ImageIcon(address_icon));
        if(address==112)
             B4.setIcon(new ImageIcon(address_icon));
        if(address==102)
             B5.setIcon(new ImageIcon(address_icon));
        if(address==101)
             B6.setIcon(new ImageIcon(address_icon));
        if(address==100)
             B7.setIcon(new ImageIcon(address_icon));
        if(address==110)
             B8.setIcon(new ImageIcon(address_icon));
        if(address==220)
             C1.setIcon(new ImageIcon(address_icon));
        if(address==221)
             C2.setIcon(new ImageIcon(address_icon));
        if(address==222)
             C3.setIcon(new ImageIcon(address_icon));
        if(address==212)
             C4.setIcon(new ImageIcon(address_icon));
        if(address==202)
             C5.setIcon(new ImageIcon(address_icon));
        if(address==201)
             C6.setIcon(new ImageIcon(address_icon));
        if(address==200)
             C7.setIcon(new ImageIcon(address_icon));
        if(address==210)
             C8.setIcon(new ImageIcon(address_icon));
        if(mode==1||mode==0)
            play_music(0);
        if(mode==2)
            play_music(1);
    }
    public static void set_icon()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    if((i==1&&j==1&&k==0)||(i==1&&j==1&&k==1)||(i==1&&j==1&&k==2))
                        continue;
                    change_icon(i, j, k, 10, 3);
                }
            }
        }
    }
    public static void setname(String s1,String s2)
    {
        name1.setText(s1);
        name2.setText(s2);
    }
    public  static void setscore(String s1,String s2)
    {
        score1.setText(s1);
        score2.setText(s2);
    }
    public static void setaction(String s1,String s2)
    {
        String str=String.format("%s : ", s1);
        action1.setText(str);
        action4.setText(s2);
    }
    public static void set_checker_remaine(int x1,int x2)
    {
        String s1=String.format("%d",12-x1),s2=String.format("%d",12-x2);
        remain1.setText(s1);
        remain2.setText(s2);
    }
    public static void setturn(boolean a)
    {
        if(a==true)
        {
         turn1.setIcon(new ImageIcon("pic\\000.png"));
         turn2.setIcon(new ImageIcon("pic\\111.png"));
        }
        else
        {
         turn1.setIcon(new ImageIcon("pic\\111.png"));
         turn2.setIcon(new ImageIcon("pic\\000.png"));
        }
    }
    
    public static void set_frame()
    {
     for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    change_icon(i, j, k,0, 6);
                }
            }
        }   
    }
    public static void set_possibility(int mode)
    {
        //mode 0:put 1:pop_notdoze  2:pop_doze 3:move_start 4:move_end 5:fly_end 6:start
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                    possibility[i][j][k]=false;
            }
        }  
        if(mode==1)
        {
            for(int t=0;t<12;t++)
            {
                if(Game.player[Game.player_off].checker[t].doz_weight==0&&Game.player[Game.player_off].checker[t].mode==1)
                    possibility[Game.player[Game.player_off].checker[t].x][Game.player[Game.player_off].checker[t].y][Game.player[Game.player_off].checker[t].z]=true;
            }
        }
        else if(mode==2)
        {
            for(int t=0;t<12;t++)
            {
                if(Game.player[Game.player_off].checker[t].doz_weight!=0&&Game.player[Game.player_off].checker[t].mode==1)
                    possibility[Game.player[Game.player_off].checker[t].x][Game.player[Game.player_off].checker[t].y][Game.player[Game.player_off].checker[t].z]=true;
            }   
        }
        else if(mode==4)
        {
            int x=Frame.x1,y=Frame.y1,z=Frame.z1;
            if(x-1>=0&&Board.zamin[x-1][y][z]==-1)
                possibility[x-1][y][z]=true;
            if(x+1<3&&Board.zamin[x+1][y][z]==-1)
                possibility[x+1][y][z]=true;
            if(y-1>=0&&Board.zamin[x][y-1][z]==-1)
                possibility[x][y-1][z]=true;
            if(y+1<3&&Board.zamin[x][y+1][z]==-1)
                possibility[x][y+1][z]=true;
            if(z-1>=0&&Board.zamin[x][y][z-1]==-1)
                possibility[x][y][z-1]=true;
            if(z+1<3&&Board.zamin[x][y][z+1]==-1)
                possibility[x][y][z+1]=true;
        }
        else
        {
           for(int i=0;i<3;i++)
            {
             for(int j=0;j<3;j++)
             {
                 for(int k=0;k<3;k++)
                 {
                     if(mode==0)
                     {
                         if(Board.zamin[i][j][k]==-1)
                             possibility[i][j][k]=true;
                     }
                     else if(mode==3)
                     {
                         if(Board.zamin[i][j][k]==Game.player_on)
                             possibility[i][j][k]=true;
                         else
                             possibility[i][j][k]=false;
                     }
                     else if(mode==5)
                     {
                         if(Board.zamin[i][j][k]==-1)
                             possibility[i][j][k]=true;
                     }
                 }
             }
            }
        }
        
        if(possibility[0][2][0]==true)
            w20.setVisible(true);
        else
            w20.setVisible(false);
        if(possibility[1][2][0]==true)
            w21.setVisible(true);
        else
            w21.setVisible(false);
        if(possibility[2][2][0]==true)
            w22.setVisible(true);
        else
            w22.setVisible(false);
        if(possibility[2][1][0]==true)
            w12.setVisible(true);
        else
            w12.setVisible(false);
        if(possibility[2][0][0]==true)
            w2.setVisible(true);
        else
            w2.setVisible(false);
        if(possibility[1][0][0]==true)
            w1.setVisible(true);
        else
            w1.setVisible(false);
        if(possibility[0][0][0]==true)
            w0.setVisible(true);
        else
            w0.setVisible(false);
        if(possibility[0][1][0]==true)
            w10.setVisible(true);
        else
            w10.setVisible(false);
        
        if(possibility[0][2][1]==true)
            w120.setVisible(true);
        else
            w120.setVisible(false);
        if(possibility[1][2][1]==true)
            w121.setVisible(true);
        else
            w121.setVisible(false);
        if(possibility[2][2][1]==true)
            w122.setVisible(true);
        else
            w122.setVisible(false);
        if(possibility[2][1][1]==true)
            w112.setVisible(true);
        else
            w112.setVisible(false);
        if(possibility[2][0][1]==true)
            w102.setVisible(true);
        else
            w102.setVisible(false);
        if(possibility[1][0][1]==true)
            w101.setVisible(true);
        else
            w101.setVisible(false);
        if(possibility[0][0][1]==true)
            w100.setVisible(true);
        else
            w100.setVisible(false);
        if(possibility[0][1][1]==true)
            w110.setVisible(true);
        else
            w110.setVisible(false);
        
        if(possibility[0][2][2]==true)
            w220.setVisible(true);
        else
            w220.setVisible(false);
        if(possibility[1][2][2]==true)
            w221.setVisible(true);
        else
            w221.setVisible(false);
        if(possibility[2][2][2]==true)
            w222.setVisible(true);
        else
            w222.setVisible(false);
        if(possibility[2][1][2]==true)
            w212.setVisible(true);
        else
            w212.setVisible(false);
        if(possibility[2][0][2]==true)
            w202.setVisible(true);
        else
            w202.setVisible(false);
        if(possibility[1][0][2]==true)
            w201.setVisible(true);
        else
            w201.setVisible(false);
        if(possibility[0][0][2]==true)
            w200.setVisible(true);
        else
            w200.setVisible(false);
        if(possibility[0][1][2]==true)
            w210.setVisible(true);
        else
            w210.setVisible(false);
    }
    public static void play_music(int mode)
    {
        String str=String.format("music\\%d.au",mode);
        try{
             InputStream test = new FileInputStream(str);
             AudioStream t=new AudioStream(test);
             AudioPlayer.player.start(t);
        }
        catch(Exception e3){System.err.println("Not found victory.au");}
    }
   
}