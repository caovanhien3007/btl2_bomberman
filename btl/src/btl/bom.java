package btl;

import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;

public class bom {
	 private  int SizeBom=2;
	  private int time =0;
      private point Bom;
      private ImageIcon icon = new ImageIcon("bb.png");
      public bom(int x,int y)
      {
    	  
    	  Bom=new point(x,y);
      } 
      
      public void bum(Wall wall)
      {
    	  if(time!=0) {
    			time++;
    			if(time>50)
    				{
    				time=0;
    				}
    			}
      }
     
      public int getSizeBom() {
  		return SizeBom;
  	}
  	public void setSizeBom(int sizeBom) {
  		SizeBom = sizeBom;
  	}
  	
      public void pBom(Graphics g,ArrayList <point> wall,ArrayList <box> box,ArrayList<boss> boss,MOVE bomer,Component c,ArrayList<item> Item)
      {
    	  if(time!=0)
  		{
    		  icon = new ImageIcon("bb.png");
  			if(time<=35)icon.paintIcon(c, g, Bom.getX(),Bom.getY());
  			else {
  				icon=new ImageIcon("rb.png") ;
  				boolean p=true;
  				//bom right
  				for(int i=0;i<SizeBom&&p;i++)
  				{
  					for(int j=0;j< wall.size()&&p;j++)
  					{
  						if(Bom.getX()+i*40==wall.get(j).getX()&&Bom.getY()==wall.get(j).getY())
  						{
  							p=false;
  						}
  					}
  					
  					for(int j=0;j< box.size()&&p;j++)
  					{
  						if(Bom.getX()+i*40==box.get(j).getX()&&Bom.getY()==box.get(j).getY())
  						{
  							p=false;
  							box.get(j).breakBox(Item);
  							if(time==50)box.remove(j);		
  							icon.paintIcon(c, g, Bom.getX()+40*i,Bom.getY());
  						}
  					}
  					
  					if(Bom.getY()==bomer.getY()&&Bom.getX()+i*40<=bomer.getX()&&Bom.getX()+i*40+40>bomer.getX()) {
  						p=false; 
 
  					bomer.setLive(false);
  					}
  					
  					for(int j=0;j<boss.size();j++)
  					{
  						if(boss.get(j).getY()==Bom.getY()&&Bom.getX()+i*40<=boss.get(j).getX()&&Bom.getX()+i*40+35>boss.get(j).getX()) {
  	  						p=false;
  	  						icon.paintIcon(c, g, Bom.getX()+40*i,Bom.getY());
  	  					boss.get(j).breakb();
  	  					if(time==50) {
  	  						boss.remove(j);
  	  						j--;
  	  					}
  	  				icon.paintIcon(c, g, Bom.getX()+40*i,Bom.getY());
  					}
  					}
  					
  					if(p) {
  						icon.paintIcon(c, g, Bom.getX()+40*i,Bom.getY());
  					}
  					
  				}
  				//       left
  				p=true;
  				for(int i=0;i<SizeBom&&p;i++)
  				{
  					for(int j=0;j< wall.size()&&p;j++)
  					{
  						if(Bom.getX()-i*40==wall.get(j).getX()&&Bom.getY()==wall.get(j).getY())
  						{
  							p=false; 
  						}
  					}
  					for(int j=0;j< box.size()&&p;j++)
  					{
  						if(Bom.getX()-i*40==box.get(j).getX()&&Bom.getY()==box.get(j).getY())
  						{
  							p=false;
  							box.get(j).breakBox(Item);
  							if(time==50)box.remove(j);
  						}
  					}
  					if(Bom.getY()==bomer.getY()&&Bom.getX()-i*40>=bomer.getX()&&Bom.getX()-i*40-40<bomer.getX()) {
  						p=false;
  						icon.paintIcon(c, g, Bom.getX()-40*i,Bom.getY());
  						bomer.setLive(false);
  					}
  					for(int j=0;j<boss.size();j++)
  					{
  						if(boss.get(j).getY()==Bom.getY()&&Bom.getX()-i*40>=boss.get(j).getX()&&Bom.getX()-35-i*40<boss.get(j).getX()) {
  	  						p=false;
  	  					icon.paintIcon(c, g, Bom.getX()-40*i,Bom.getY());
  	  				    boss.get(j).breakb();
	  					if(time==50)
  	  					{
	  						boss.remove(j);
	  						j--;
  	  					}
  					}
  					}
  					if(p) {
  						icon.paintIcon(c, g, Bom.getX()-40*i,Bom.getY());
  					}
  				}
  				// down
  				icon=new ImageIcon("ub.png") ;
  				p=true;
  				for(int i=0;i<SizeBom&&p;i++)
  				{
  					for(int j=0;j< wall.size()&&p;j++)
  					{
  						if(Bom.getX()==wall.get(j).getX()&&Bom.getY()+i*40==wall.get(j).getY())
  						{
  							p=false;
  						}
  					}
  					for(int j=0;j< box.size()&&p;j++)
  					{
  						if(Bom.getX()==box.get(j).getX()&&Bom.getY()+i*40==box.get(j).getY())
  						{
  							p=false;
  							box.get(j).breakBox(Item);
  							if(time==50)box.remove(j);
  						}
  					}
  					if(Bom.getX()==bomer.getX()&&Bom.getY()+i*40<=bomer.getY()&&Bom.getY()+40+i*40>bomer.getY()) {
  						p=false;
  						icon.paintIcon(c, g, Bom.getX(),Bom.getY()+i*40);
  						bomer.setLive(false);
  					}
  					for(int j=0;j<boss.size();j++)
  					{
  						if(boss.get(j).getX()==Bom.getX()&&Bom.getY()+i*40<=boss.get(j).getY()&&Bom.getY()+35+i*40>boss.get(j).getY()) {
  	  						p=false;
  	  						icon.paintIcon(c, g, Bom.getX(),Bom.getY()+i*40);;
  	  				       boss.get(j).breakb();
	  					   if(time==50)
  	  						{
	  						   boss.remove(j);
	  						   j--;
  	  						}
  					}
  					}
  					if(p) {
  						icon.paintIcon(c, g, Bom.getX(),Bom.getY()+i*40);
  					}
  				}
  				// up
  				p=true;
  				for(int i=0;i<SizeBom&&p;i++)
  				{
  					for(int j=0;j< wall.size()&&p;j++)
  					{
  						if(Bom.getX()==wall.get(j).getX()&&Bom.getY()-i*40==wall.get(j).getY())
  						{
  							p=false;
  						}
  					}
  					for(int j=0;j< box.size()&&p;j++)
  					{ 
  						if(Bom.getX()==box.get(j).getX()&&Bom.getY()-i*40==box.get(j).getY())
  						{
  							p=false;
  							box.get(j).breakBox(Item); 
  							if(time==50)box.remove(j);
  						}
  					}
  					if(Bom.getX()==bomer.getX()&&Bom.getY()-i*40>=bomer.getY()&&Bom.getY()-40-i*40<bomer.getY()) {
  						p=false;
  						icon.paintIcon(c, g, Bom.getX(),Bom.getY()-i*40);
  						bomer.setLive(false);
  					}
  					for(int j=0;j<boss.size();j++)
  					{
  						if(boss.get(j).getX()==Bom.getX()&&Bom.getY()-i*40>=boss.get(j).getY()&&Bom.getY()-35-i*40<boss.get(j).getY()) {
  	  						p=false;
  	  						icon.paintIcon(c, g, Bom.getX(),Bom.getY()-i*40);
  	  					  boss.get(j).breakb();
  	  					  if(time==50)
  	  						{
  	  						  boss.remove(j);
  	  						  j--;
  	  						}
  					}
  					}
  					if(p) {
  						icon.paintIcon(c, g, Bom.getX(),Bom.getY()-i*40);
  					}
  				}
  				icon=new ImageIcon("b.png") ;
  				icon.paintIcon(c, g, Bom.getX(),Bom.getY());
  			} 
  		}
      }
      
    
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public point getBom() {
		return Bom;
	}
	public void setBom(point bom) {
		Bom = bom;
	}
	
}
