package btl;

import java.util.*;

public class Wall {
      private ArrayList<point> wall=new ArrayList<>();
      public Wall() {
    	  for(int i=0;i<800;i+=80)
    	  {
    		  for(int j=0;j<600;j+=80)
    		  {
    			  point a = new point(i,j);
    			  wall.add(a);
    		  }
    	  }
      }
	public ArrayList<point> getWall() {
		return wall;
	}
      
}

