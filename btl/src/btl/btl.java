package btl;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
public class btl {
public static void main(String []arg)
{
	JButton bt = new JButton(); 
	game Game = new game();
	JFrame main =new JFrame();
	main.setBounds(10, 10, 770, 630);
	main.setBackground(Color.black);
	main.setVisible(true);
	main.setResizable(false);
	main.add(Game);
	Game.setJf(main);
	main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
	int a=0;
	//a=nhap.nextInt();
}
}
