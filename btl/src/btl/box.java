package btl;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class box {
	private  ImageIcon icon = new ImageIcon("box.png");
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
    public void pBox(Graphics g,Component c)
    {
    	icon.paintIcon(c, g, x, y);
    }
    public void breakBox(ArrayList<item> Item) {
    	if(this.ni&&this.Item.getName()!=0)
    	{
    		this.Item.setPos(new point (this.x,this.y));
    		Item.add(this.Item);
    		this.ni=false;
    		
    	}
     icon = new ImageIcon ("box2.png");
    
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
