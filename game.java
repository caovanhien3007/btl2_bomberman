package bom;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


import javax.swing.*;
public class game extends JPanel implements KeyListener, ActionListener {
    private ImageIcon title;
	private Timer time;
	private int x;
	private int y;
	private int xb;
	private int yb;
	private boolean left =false;
	private boolean right =false;
	private boolean up =false;
	private boolean down =false;
	private int lengthS=0;
	private int move =0;
	private Random ran =new Random();
	private int xpos = ran.nextInt(33)*25+25;
	private int ypos = ran.nextInt(23)*25+75;
	private JButton bt = new JButton();
	private int Start =0;
	private int  ti;
	private int bom=0;
	
	public game() {
		//setLayout(null);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		 time =new Timer(50, this);
		 
		//
	
         
	}
	
	public int getStart() {
		return Start;
	}

	public void setStart(int start) {
		this.Start = start;
	}

	public void paint(Graphics g)
	{
		if(Start==0) time.stop();
		if(move==0)
		{
			x=50;
			y=100;
		}
				
				title =new ImageIcon("nền.png");
				
				title.paintIcon(this, g, 0, 0);
				
				
				if(x%10==0)g.setColor(Color.red);
				else g.setColor(Color.green);
					g.fillRect( x, y, 25,25);
				
				
				
				if(lengthS>=1)
				{
					g.setColor(Color.blue);
					g.fillRect(xb, yb, 25, 25);
					
					
				}
					
				if(bom>1)
				{
					if(xpos>=xb-25&&xpos<xb+50&&move!=0&&ypos>=yb-25&&ypos<yb+50)
					{
						
						xpos = ran.nextInt(33)*25+25;
						ypos = ran.nextInt(22)*25+75; 
					}
					g.setColor(Color.yellow);
					g.fillRect(xb-25, yb-25, 75, 75);
					
					
					
				}
				g.setColor(Color.yellow);
				g.fillRect( xpos, ypos,25,25);
				
				g.dispose();
				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//if(move==0)
		time.start();
		if(bom>1) {
			bom--;
			if(bom==1) {
				repaint();
				bom=0;
			}
			
		}
		if(lengthS==1)
		{
			ti--;
			
			if(ti==0)
			{ 
				lengthS=0;
				bom=6;
				repaint();
			}
			
		}
		if(right)
		{
			if(x!=850)
			x=x+5;
			repaint();
			if(x%25==0)right=false;
		}
		if(left)
		{
			if(x!=25)
			x=x-5;
			if(x%25==0)left=false;
			repaint();
		}
		if(down)
		{
			if(y!=625)
			y=y+5;
			if(y%25==0)down=false;
			repaint();
		}
		if(up)
		{
			if(y!=75)
			y=y-5;
			if(y%25==0)up=false;
			repaint();
		}
	}

	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

   //  private KeyEvent c ;

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if(Start!=0)time.start();
		if(e.getKeyCode()==KeyEvent.VK_SPACE&&lengthS==0)
		{
			lengthS=1;
			xb=x;
			yb=y;
			ti=30;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			move++;
			right =true;
			if(!left) {
				right = true;
			}else {
				right = false;
			}
			 
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			move++;
			left =true;
			if(!right) {
				left = true;
			}else {
				left = false;
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			move++;
			up=true;
			if(!down) {
				up = true;
			}else {
				up = false;
			}
			
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			move++;
			down =true;
			if(!up) {
				down = true;
			}else {
				down = false;
			}
			
		}
		
	}
    
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
