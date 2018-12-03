package btl;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
public class btl {
public static void main(String []arg)
{
	JButton bt = new JButton(); 
	game Game = new game(1);
	JFrame main =new JFrame();
	main.setBounds(100, 100, 770, 630);
	main.setBackground(Color.black);
	main.setResizable(false);
	main.add(Game);
	Game.setJf(main);
	main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
	
	main begin=new main(main);
	Game.setbe(begin);
   begin.setJf(begin);
   begin.setVisible(true);
	//a=nhap.nextInt();
}
}
