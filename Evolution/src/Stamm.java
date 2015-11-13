
public class Stamm {
	private int drehung;
	private int x,y;
	private int xEnde,yEnde;
	public Stamm (int drehungPar,int xPar,int yPar) {
		drehung=drehungPar;
		x=xPar;
		y=yPar;
		xEnde=x+(int)(10*Math.cos(Math.toRadians(drehungPar)));
		yEnde=y+(int)(10*Math.sin(Math.toRadians(drehungPar)));
	}
	public int getDrehung() {
		return drehung;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getxEnde() {
		return xEnde;
	}
	public int getyEnde() {
		return yEnde;
	}
	
}
