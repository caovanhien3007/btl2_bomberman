package btl;

import java.util.*;

import javax.swing.ImageIcon;

import java.awt.*;

public class MOVE { 
	private boolean live =true;
	private ImageIcon icon = new ImageIcon("down1.png");
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	private boolean Win=false;
	
	public boolean isWin() {
		return Win;
	}
	public void setWin(boolean win) {
		Win = win;
	}
	private int spe=5;
	public int getSpe() {
		return spe;
	}
	public void setSpe(int spe) {
		this.spe = spe;
	}
	private boolean right =false;
	private boolean left=false;
	private boolean up=false;
	private boolean down=false;
	protected int x;
	protected int y;
	
	//
	
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public MOVE(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	//     move
	public void move(ArrayList<point> wall,ArrayList<box> box)
	{
		//move right
		if(this.right) { 
			boolean m=true;
			if(y%40==0) {
			for(int i=0;i<wall.size()&&m==true;i++)
			{
				if(x+40==wall.get(i).getX()&&y==wall.get(i).getY())
				{
					
					m=false;
				}				
			}
			for(int i=0;i<box.size()&&m==true;i++)
			{
				if(x+40==box.get(i).getX()&&y==box.get(i).getY())
				{
					
					m=false;
				}				
			}
			if(m) {
			x=x+spe;
			if(x>720)x=x-spe;
			if(x%40==0)right=false;
			}else right=false;
			}
		}
		//move left
		if(this.left) {
			boolean m=true;
			if(y%40==0) {
			for(int i=0;i<wall.size()&&m==true;i++)
			{
				if(x-40==wall.get(i).getX()&&y==wall.get(i).getY())
				{
					m=false;	
				}				
			}
			for(int i=0;i<box.size()&&m==true;i++)
			{
				if(x-40==box.get(i).getX()&&y==box.get(i).getY())
				{
					m=false;	
				}				
			}
			if(m) {
			x=x-spe;
			if(x<0)x=x+spe;
			if(x%40==0)left=false;
			}else left=false;
			}
		}
		//move up
		if(this.up) {
			boolean m=true;
			if(x%40==0)
			{
			for(int i=0;i<wall.size()&&m==true;i++)
			{
				if(y-40==wall.get(i).getY()&&x==wall.get(i).getX())
				{
					m=false;
				}				
			}
			for(int i=0;i<box.size()&&m==true;i++)
			{
				if(y-40==box.get(i).getY()&&x==box.get(i).getX())
				{
					m=false;
				}				
			}
			if(m) { 
			y=y-spe;
			if(y<0)y=y+spe;
			if(y%40==0)up=false;
			}else up=false;
		}
		}
		// move down
		if(this.down) {
			boolean m=true;
			if(x%40==0) {
			for(int i=0;i<wall.size()&&m==true;i++)
			{
				if(y+40==wall.get(i).getY()&&x==wall.get(i).getX())
				{
					m=false;
				}				
			}
			for(int i=0;i<box.size()&&m==true;i++)
			{
				if(y+40==box.get(i).getY()&&x==box.get(i).getX())
				{
					m=false;
				}				
			}
			if(m) {
			y=y+spe;
			if(y>560)y=y-spe;
			if(y%40==0)down=false;
			}else down=false;
		}
	}}
	// paint   
	public void paint(Component c,Graphics g)
	{
		if(up) {
			if(y%40<=20)icon = new ImageIcon("up1.png");
			else icon= new ImageIcon("up2.png");
		}
		if(down) {
			if(y%40<=20)icon =new ImageIcon("down1.png");
			else icon= new ImageIcon("down2.png");
		}
		if(left) {
			if(x%40<=20)icon =new ImageIcon("left1.png");
			else icon= new ImageIcon("left2.png");
		}
		if(right) {
			if(x%40<=20)icon =new ImageIcon("right1.png");
			else icon= new ImageIcon("right2.png");
		}
		icon.paintIcon(c, g, x, y);
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
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
