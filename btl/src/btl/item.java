package btl;

public class item {

	private int name;
	
	private point pos;
	
	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public point getPos() {
		return pos;
	}

	public void setPos(point pos) {
		this.pos = pos;
	}
    public void efItem(bom Bom,MOVE bomer)
    {
    	if(this.name==1)bomer.setWin(true);
    	if(this.name==2)Bom.setSizeBom(Bom.getSizeBom()+1);
    	if(this.name==3)bomer.setSpe(10);
    }
    
}
