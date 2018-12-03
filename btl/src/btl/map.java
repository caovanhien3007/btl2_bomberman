package btl;
import java.util.*;
public class map {
    public map(ArrayList<boss> boss,ArrayList<box> box,int n)
    {
    	if(n==2) {
    		 box.add(new box(40,120,0));
    		 box.add(new box(40,160,0));
    		 box.add(new box(0,360,2));
    		 box.add(new box(40,320,0));
    		 box.add(new box(40,360,0));
    		 box.add(new box(40,400,0));
    		 box.add(new box(80,200,0));
    		 box.add(new box(120,40,0));
    		 box.add(new box(120,80,0));
    		 box.add(new box(120,480,0));
    		 box.add(new box(200,200,0));
    		 box.add(new box(200,240,0));
    		 box.add(new box(200,280,0));
    		 box.add(new box(240,200,0));
    		 box.add(new box(280,200,0));
    		 box.add(new box(280,240,2));
    		 box.add(new box(280,280,0));
    		 box.add(new box(240,280,0));
    		 box.add(new box(280,440,3));
    		 box.add(new box(680,560,1));
    		 box.add(new box(520,520,0));
    		 box.add(new box(600,440,0));
    		 box.add(new box(680,360,0));
    		 box.add(new box(440,400,0));
    		 box.add(new box(440,120,0));
    		 box.add(new box(480,120,0));
    		 box.add(new box(520,120,0));
    		 box.add(new box(520,160,2));
    		 box.add(new box(520,200,0));
    		 box.add(new box(480,200,0));
    		 box.add(new box(440,200,0));
    		 box.add(new box(440,160,0));
    		 boss.add(new boss(280,400));
    		 boss.add(new boss(640,520));
    		 boss.add(new boss(320,120));
    		 boss.add(new boss(560,360));
    		 boss.add(new boss(80,280));
    	}
    if(n==1) {
   	 box.add(new box(240,280,0));
   	 box.add(new box(200,280,3));
   	box.add(new box(200,200,2));
   	box.add(new box(600,440,1));
   	boss.add(new boss(560,360));
	 boss.add(new boss(80,280));

    }
    }
}
