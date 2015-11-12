
public class Stamm {
	private int drehung;
	private int x,y;
	private int xEnde,yEnde;
	public Stamm (int drehungPar,int xPar,int yPar) {
		drehung=drehungPar;
		x=xPar;
		y=yPar;
		xEnde=(int)(10*Math.cos(x));
		yEnde=(int)(10*Math.sin(x));
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
