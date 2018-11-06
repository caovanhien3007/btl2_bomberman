package bom;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class main {
	public static void main(String []arg)
	{
		JButton bt = new JButton();
		game Game = new game();
		JFrame main =new JFrame();
		main.setBounds(10, 10, 905, 700);
		main.setBackground(Color.red);
		main.setVisible(true);
		main.setResizable(false);
		main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
		main.add(Game);
		Scanner nhap =new Scanner (System.in);
		int a=0;
		//a=nhap.nextInt();
		Game.setStart(4);
		
		
	}
	
}
