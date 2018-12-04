package btl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.*;
public class game extends JPanel implements KeyListener, ActionListener {
	private int level;
	private boolean Starst=false;
	private Timer time;
	private MOVE bomer =new MOVE(40,40);
	private bom Bom=new bom(1,1);
	private ArrayList<box> box =new ArrayList<>();
	private Wall wall=new Wall();
	private ArrayList<boss> boss= new ArrayList<>();
	private JFrame jf=null; 
	private main be=null; 
	private ArrayList<item> Item=new ArrayList<>();
	private ImageIcon icon = new ImageIcon("vic.jpg");
	private map map;
	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}
	public void setbe(main jf) {
		this.be = jf;
	}

	public game(int a) { 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		 time =new Timer(50, this);
		 level=a;
		 map=new map(boss,box,a);
	  
	//    	wall.getWall().add(new point(360,120));
	  //  	wall.getWall().add(new point(280,120));
	}
	
	public void paint(Graphics g)
	{	
		
		g.setColor(Color.MAGENTA); 
		
		g.fillRect(0, 0, 1000, 1000);
		
		
		for(int i=0;i<box.size();i++)
		{
			box.get(i).pBox(g,this);	
		}	
		for(int i=0;i<Item.size();i++)
		{
			if(Item.get(i).getName()==1) {
			    icon = new ImageIcon("ưin.png");
				icon.paintIcon(this, g, Item.get(i).getPos().getX(), Item.get(i).getPos().getY());			}
			if(Item.get(i).getName()==2) {
			    icon = new ImageIcon("sizb.png");
				icon.paintIcon(this, g, Item.get(i).getPos().getX(), Item.get(i).getPos().getY());
			}
			if(Item.get(i).getName()==3) {
				icon = new ImageIcon("spe.png");
				icon.paintIcon(this, g, Item.get(i).getPos().getX(), Item.get(i).getPos().getY());
			}
		}
		Bom.pBom(g,wall.getWall(),box,boss,bomer,this,Item);
		bomer.paint(this,g);
		for(int i=0;i<boss.size();i++)
		{
			boss.get(i).paint(g,this);
			if(boss.get(i).getX()==bomer.getX()&&boss.get(i).getY()-35<bomer.getY()&&bomer.getY()<boss.get(i).getY()+35) {
				bomer.setLive(false);
			}
			if(boss.get(i).getY()==bomer.getY()&&boss.get(i).getX()-35<bomer.getX()&&bomer.getX()<boss.get(i).getX()+35)
				bomer.setLive(false);
		}
		
		g.setColor(Color.BLACK);
		for(int i=0;i<wall.getWall().size();i++)
		{
			ImageIcon icon = new ImageIcon("wall.png");
			icon.paintIcon(this, g, wall.getWall().get(i).getX(), wall.getWall().get(i).getY());
		}
		if(!Starst)
		{    
			time.stop();
			 icon = new ImageIcon("ok.jpg");
			 icon.paintIcon(this, g,120 , 200);
		}
		if(!bomer.isLive()||bomer.isWin())
			{
			time.stop();
		if(bomer.isWin()) {
			icon = new ImageIcon("vic.jpg");
			icon.paintIcon(this, g,120 , 200);
		}
		if(!bomer.isLive())
		{
			icon = new ImageIcon("die.png");
			icon.paintIcon(this, g,0 , 0);
		}
			}
		g.dispose();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stu
		time.start();
		
		bomer.move(wall.getWall(),box);
		for(int i=0;i<Item.size();i++)
		{
			if(Item.get(i).getPos().getX()==bomer.getX()&&Item.get(i).getPos().getY()==bomer.getY())
			{
				          Item.get(i).efItem(Bom, bomer);
                          Item.remove(i);
			//	i++;				
			}
		}
		for(int i=0;i<boss.size();i++)
		{
			boss.get(i).ranMove(bomer,box,wall);
			boss.get(i).move(wall.getWall(), box);
		}
		
		Bom.bum(wall);
		repaint();
	}
    
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_A&&!bomer.isLive())
		{
			jf.setVisible(false);
		game Game =new game(level); 
		jf.setContentPane(Game);
		Game.setJf(jf);
		Game.setbe(be);
		jf.setVisible(true);
		
		}
		if(e.getKeyCode()==KeyEvent.VK_N&&bomer.isWin())
		{
			jf.setVisible(false);
		game Game =new game(level+1); 
		jf.setContentPane(Game);
		Game.setJf(jf);
		Game.setbe(be);
		jf.setVisible(true);
		
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			{
			time.start();
			Starst=true;
			}
		
		if(e.getKeyCode()==KeyEvent.VK_P&&Starst)Starst=false;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			bomer.setRight(true);
			bomer.setLeft(false);
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			bomer.setLeft(true);
			bomer.setRight(false);
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			bomer.setUp(true);
			bomer.setDown(false);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			bomer.setDown(true);
			bomer.setUp(false);
					}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE&&Bom.getTime()==0)
		{
			Bom.getBom().setX(((bomer.getX()+20)/40)*40);
			Bom.getBom().setY(((bomer.getY()+20)/40)*40);
			
		Bom.setTime(1);
	
		} 
		
		if(e.getKeyCode()==KeyEvent.VK_Q&&!this.Starst)
		{
			jf.setVisible(false);
			game Game = new game(1);
			JFrame main =new JFrame();
			main.setBounds(100, 100, 770, 630);
			main.setBackground(Color.black);
			main.setResizable(false);
			main.add(Game);
			Game.setJf(main);
			main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
			
			 be=new main(main);
			Game.setbe(be);
		   be.setJf(be);
			be.setVisible(true);
		   
		} 
		
		}
    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
