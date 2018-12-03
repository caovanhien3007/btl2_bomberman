package btl;

import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;

public class boss extends MOVE {
    private int n=0;
	private Random ran=new Random();
	private boolean find=false;
	private boolean ranmove=true;
	private point pos;
	public boss(int x, int y) {
		super(x, y);
		this.setIcon(new ImageIcon("br1.png"));
		
	
	} 
	/// bre
	public void breakb() {
    	this.setIcon(new ImageIcon("bdie.png"));
    	ranmove=false;
    	this.setDown(false);
    	this.setLeft(false); 
     this.setUp(false);
     this.setRight(false);
    }
	// paint 
	public void paint(Graphics g,Component c)
	{
		if(this.isUp()) {
			if(y%40<=20)this.setIcon(new ImageIcon("br1.png") );
			else this.setIcon( new ImageIcon("bl2.png"));
		}
		if(this.isDown()) {
			if(y%40<=20)this.setIcon(new ImageIcon("bl1.png"));
			else this.setIcon( new ImageIcon("br2.png"));
		}
		if(this.isLeft()) {
			if(x%40<=20)this.setIcon(new ImageIcon("bl1.png"));
			else this.setIcon( new ImageIcon("bl2.png"));
		}
		if(this.isRight()) {
			if(x%40<=20)this.setIcon(new ImageIcon("br1.png"));
			else this.setIcon(new ImageIcon("br2.png"));
		}
	this.getIcon().paintIcon(c, g, x, y);
	}
	//move 
	public void ranMove(MOVE bomer,ArrayList<box> box,Wall wall)
	{
		if(ranmove) {
		if(this.getX()==bomer.getX()&&bomer.getX()%80==40||this.getY()==bomer.getY()&&bomer.getY()%80==40||find)
		{
			if(this.getX()==bomer.getX()&&bomer.getX()%80==40||this.getY()==bomer.getY()&&bomer.getY()%80==40)
			{
				pos=new point(bomer.getX(),bomer.getY());
				find=true;
				this.setRight(false);
				this.setDown(false);
				this.setLeft(false);
				this.setUp(false);
				n=0;
				if(this.getX()<pos.getX())this.setRight(true);
				if(this.getX()>pos.getX())this.setLeft(true);
				if(this.getY()>pos.getY())this.setUp(true);
				if(this.getY()<pos.getY())this.setDown(true);
			}else
			if(find)
			{
				if(this.getX()<pos.getX())this.setRight(true);
				if(this.getX()>pos.getX())this.setLeft(true);
				if(this.getY()>pos.getY())this.setUp(true);
				if(this.getY()<pos.getY())this.setDown(true);
				this.movewall(box, wall);
			}
			if(this.getX()==pos.getX()&&this.getY()==pos.getY())find=false;
		}else {
			if(n%8==0)
			{
				int a=ran.nextInt(4);
				if(a==0) {
					this.setDown(true);
					this.setUp(false);
				}
				if(a==1) {
					this.setLeft(true);
					this.setRight(false);
				}
				if(a==2) {
					this.setRight(true);
				this.setLeft(false);
				}
				if(a==3) {
					this.setDown(false);
					this.setUp(true);
				}
			}
			n++;
			if(n>96)n=0;
		}
		}
		}
	public void movewall(ArrayList<box> box,Wall wall)
    {
  	  for(int i=0;i<box.size();i++)
  	  {
  		  if(this.isRight()&&this.getX()+40==box.get(i).getX()&&this.getY()==box.get(i).getY()) {
  			  this.setDown(true);
  			  this.setRight(false);
  			  find=false;
  		  }
  		if(this.isDown()&&this.getY()+40==box.get(i).getY()&&this.getX()==box.get(i).getX()) {
			  this.setDown(false);
			  this.setLeft(true);
			  find=false;
		  }
  		if(this.isLeft()&&this.getX()-40==box.get(i).getX()&&this.getY()==box.get(i).getY()) {
			  this.setUp(true);
			  this.setLeft(false);
			  find=false;
		  }
  		if(this.isUp()&&this.getY()-40==box.get(i).getY()&&this.getX()==box.get(i).getX()) {
			  this.setUp(false);
			  this.setRight(true);
			  find=false;
		  }
  	  }
  	for(int i=0;i<wall.getWall().size();i++)
	  {
		  if(this.isRight()&&this.getX()+40==wall.getWall().get(i).getX()&&this.getY()==wall.getWall().get(i).getY()) {
			  this.setDown(true);
			  this.setRight(false);
			  find=false;
		  }
		if(this.isDown()&&this.getY()+40==wall.getWall().get(i).getY()&&this.getX()==wall.getWall().get(i).getX()) {
			  this.setDown(false);
			  this.setLeft(true);
			  find=false;
		  }
		if(this.isLeft()&&this.getX()-40==wall.getWall().get(i).getX()&&this.getY()==wall.getWall().get(i).getY()) {
			  this.setUp(true);
			  this.setLeft(false);
			  find=false;
		  }
		if(this.isUp()&&this.getY()-40==wall.getWall().get(i).getY()&&this.getX()==wall.getWall().get(i).getX()) {
			  this.setUp(false);
			  this.setRight(true);
		  }
	  }
    }
			}
 