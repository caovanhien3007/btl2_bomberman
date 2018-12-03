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
	
	private boolean Starst=true;
	private Timer time;
	private MOVE bomer =new MOVE(40,40);
	private bom Bom=new bom(1,1);
	private ArrayList<box> box =new ArrayList<>();
	private Wall wall=new Wall();
	private ArrayList<boss> boss= new ArrayList<>();
	private JFrame jf=null; 
	private ArrayList<item> Item=new ArrayList<>();
	
	public JFrame getJf() {
		return jf;
	}

	public void setJf(JFrame jf) {
		this.jf = jf;
	}

	public game() { 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		 time =new Timer(50, this);
	   boss.add(new boss(440,520));
		boss.add(new boss(320,120));
		boss.add(new boss(120,520));
		box.add(new box(280,520,3)); 
	    box.add(new box(120,200,1));
	    box.add(new box(280,360,2));
	    	box.add(new box(440,440,0));
	//    	wall.getWall().add(new point(360,120));
	  //  	wall.getWall().add(new point(280,120));
	}
	
	public void paint(Graphics g)
	{	
		g.setColor(Color.MAGENTA); 
		
		g.fillRect(0, 0, 1000, 1000);
		
		
		for(int i=0;i<box.size();i++)
		{
			box.get(i).pBox(g);	
		}	
		for(int i=0;i<Item.size();i++)
		{
			if(Item.get(i).getName()==1) {
				g.setColor(Color.RED);
				g.drawRect(Item.get(i).getPos().getX(), Item.get(i).getPos().getY(), 40, 40);
			}
			if(Item.get(i).getName()==2) {
				g.setColor(Color.GREEN);
				g.drawRect(Item.get(i).getPos().getX(), Item.get(i).getPos().getY(), 40, 40);
			}
			if(Item.get(i).getName()==3) {
				g.setColor(Color.BLACK);
				g.drawRect(Item.get(i).getPos().getX(), Item.get(i).getPos().getY(), 40, 40);
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
		if(!bomer.isLive())
			{
			time.stop();
		
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
                          Item.remove(i);
			//	i++;				
			}
		}
		for(int i=0;i<boss.size();i++)
		{
			boss.get(i).ranMove(bomer,box,wall);
			boss.get(i).move(wall.getWall(), box);
		}
		
		System.out.println(Item.size());
		Bom.bum(wall);
		repaint();
	}
    
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_A&&!bomer.isLive())
		{
			jf.setVisible(false);
		game	Game =new game(); 
		jf.setContentPane(Game);
		Game.setJf(jf);
		jf.setVisible(true);
		
		System.out.print("dfsdfsf");
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER&&Starst)time.start();
		
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
			Bom.getBom().setX((bomer.getX()/40)*40);
			Bom.getBom().setY((bomer.getY()/40)*40);
			
		Bom.setTime(1);
	
		} 
		
		if(e.getKeyCode()==KeyEvent.VK_N)
		{
			Bom.setSizeBom(Bom.getSizeBom()+1);
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