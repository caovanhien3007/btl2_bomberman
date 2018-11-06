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
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon title;
	private Timer time;
	private int[] sneakX=new int [750];
	private int[] sneakY=new int [750];
	private boolean left =false;
	private boolean right =false;
	private boolean up =false;
	private boolean down =false;
	private int lengthS=3;
	private int move =0;
	private Random ran =new Random();
	private int xpos = ran.nextInt(33)*25+25;
	private int ypos = ran.nextInt(23)*25+75;
	private JButton bt = new JButton();
	private int Start =0;
	
	public game() {
		//setLayout(null);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		 time =new Timer(150, this);
		 
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
			sneakX[2]=50;
			sneakX[1]=75;
			sneakX[0]=100;
			sneakY[2]=100;
			sneakY[1]=100;
			sneakY[0]=100;

		}
				
				title =new ImageIcon("nền.png");
				
				title.paintIcon(this, g, 0, 0);
				
				
				g.setColor(Color.red);
				g.fillRect( sneakX[0], sneakY[0], 25,25);
				for(int a=0;a< lengthS ;a++ )
				{
					if(a==0&& right)
					{
						g.setColor(Color.red);
						g.fillRect( sneakX[a], sneakY[a], 25,25);
					}
					if(a==0&& left)
					{
						g.setColor(Color.red);
						g.fillRect( sneakX[a], sneakY[a], 25,25);
						//title.paintIcon(this, g, sneakX[a], sneakY[a]);
					}
					if(a==0&& up)
					{
						g.setColor(Color.red);
						g.fillRect( sneakX[a], sneakY[a], 25,25);
						//title.paintIcon(this, g, sneakX[a], sneakY[a]);
					}
					if(a==0&& down)
					{
						g.setColor(Color.red);
						g.fillRect( sneakX[a], sneakY[a], 25,25);
//						title.paintIcon(this, g, sneakX[a], sneakY[a]);
					}
					if(a!=0)
					{
						g.setColor(Color.red);
						g.fillRect( sneakX[a], sneakY[a], 25,25);
//						title.paintIcon(this, g, sneakX[a], sneakY[a]);
					}
					
				}
				if(xpos==sneakX[0]&&ypos==sneakY[0]&&move!=0)
				{
					lengthS++;
					xpos = ran.nextInt(33)*25+25;
					ypos = ran.nextInt(22)*25+75;
				}
				g.setColor(Color.yellow);
				g.fillRect( xpos, ypos,25,25);
				for(int i=1;i<lengthS;i++)
				{
					if(sneakX[i] == sneakX[0]&&sneakY[i]==sneakY[0])
					{
						g.setColor(Color.blue);
						g.setFont(new Font("arial",Font.BOLD,50));
						g.drawString("Scores "+lengthS, 200,200 );
					move=0;
					lengthS=3;
					left=false;
					right=false;
					up=false;
					down=false;
					time.stop();
					}
				}
				
				g.dispose();
				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//if(move==0)
		time.start();
		if(right)
		{
			for(int r = lengthS-1;r>=0;r--)
			{
				sneakY[r+1]=sneakY[r];
			}
			for(int r=lengthS;r>=0;r--)
			{
				if(r==0) {
					sneakX[r]=sneakX[r]+25;
				}else
				{
					sneakX[r]=sneakX[r-1];
				}
				if(sneakX[r]>850)
				{
					sneakX[r]=25;
				}
			}
			right=false;
			repaint();
		}
		if(left)
		{
			for(int r = lengthS-1;r>=0;r--)
			{
				sneakY[r+1]=sneakY[r];
			}
			for(int r=lengthS;r>=0;r--)
			{
				if(r==0) {
					sneakX[r]=sneakX[r]-25;
				}else
				{
					sneakX[r]=sneakX[r-1];
				}
				if(sneakX[r]<25)
				{
					sneakX[r]=825;
				}
			}
			left=false;
			repaint();
		}
		if(down)
		{
			for(int r = lengthS-1;r>=0;r--)
			{
				sneakX[r+1]=sneakX[r];
			}
			for(int r=lengthS;r>=0;r--)
			{
				if(r==0) {
					sneakY[r]=sneakY[r]+25;
				}else
				{
					sneakY[r]=sneakY[r-1];
				}
				if(sneakY[r]>625)
				{
					sneakY[r]=75;
				}
			}
			down=false;
			repaint();
		}
		if(up)
		{
			for(int r = lengthS-1;r>=0;r--)
			{
				sneakX[r+1]=sneakX[r];
			}
			for(int r=lengthS;r>=0;r--)
			{
				if(r==0) {
					sneakY[r]=sneakY[r]-25;
				}else
				{
					sneakY[r]=sneakY[r-1];
				}
				if(sneakY[r]<75)
				{
					sneakY[r]=625;
				}
			}
			up=false;
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
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			move++;
			right =true;
			if(!left) {
				right = true;
			}else {
				right = false;
			}
			up=false;
			down =false; 
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
			up=false;
			down =false; 
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
			right=false;
			left =false; 
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
			right=false;
			left =false; 
		}
		
	}
    
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
