package project;
import javax.swing.*;
public class Project 
{
    public static void main(String[] args) 
    {
        while(true)
        {
            Frame s=new Frame();
            Game game=new Game("Test");
            String n1,n2;
            while((n1=JOptionPane.showInputDialog("Player 1\n What is your name?"))==null||n1.equals(""));
            while((n2=JOptionPane.showInputDialog("Player 2\n What is your name?"))==null||n2.equals(n1)||n2.equals(""));   
            game.setPlayer(0,new Player(n1));
            game.setPlayer(1,new Player(n2));
            while(true)
            {
                game.start();
                while(game.finish_checking()==-1)
                {
                    game.change_turn();
                    game.game_mode_seter();
                    game.game_mode_checker();
                    if(game.board.doz_checking()==true)
                    {
                        Frame.play_music(3);
                        game.board.doz();
                    }
                    if(Frame.newgame==true||Frame.newround==true)
                        break;
                }
                if(Frame.newround==true)
                {
                    Frame.newround=false;
                    continue;
                }
                if(Frame.newgame==true)
                {
                    Frame.newgame=false;
                    break;
                }
                game.finish();
                int a;
                do
                {
                    a=JOptionPane.showConfirmDialog(null,"Do you want to start next round?");
                }while(a==JOptionPane.CANCEL_OPTION);
                if(a==JOptionPane.NO_OPTION)
                    break;
            }
             int a;
             do
             {
                a=JOptionPane.showConfirmDialog(null,"Do you want to start new game?\nYes : New Game\nNo : Quit");
             }while(a==JOptionPane.CANCEL_OPTION);
             if(a==JOptionPane.NO_OPTION)
                System.exit(0);
             else
                Frame.f.setVisible(false);
        }
    }
}
