package btl;

import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;


public class box {
	private Color c= Color.BLUE;
	private int x;
	private int y;
	private item Item=new item();
	private boolean ni=true; 
    public box(int x,int y,int i)
    { 
    	this.x=x;
    	this.y=y;
    	this.Item.setName(i);
    }
    public void pBox(Graphics g)
    {
    	
    		g.setColor(c);
    		g.fillOval(x, y, 40, 40);
    	
    }
    public void breakBox(ArrayList<item> Item) {
    	if(this.ni&&this.Item.getName()!=0)
    	{
    		this.Item.setPos(new point (this.x,this.y));
    		Item.add(this.Item);
    		this.ni=false;
    		
    	}
    	c= Color.BLACK;
    
    }
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
    
}
