import java.util.ArrayList;

public class Gen {
	private int typ;
	private int drehung;
	private int advance;
	public Gen (int typPar, int drehungPar,int advancePar) {
		typ=typPar;
		drehung=drehungPar;
	}
	public void mutate (ArrayList <Gen> neueDNA) {
		int neuerTyp=typ;
		int neueDrehung=drehung;
		int neuesAdvance=advance;
		if (Math.random()<0.1) {
			neueDrehung=drehung-(int)(Math.random()*30)+15;
		}
		if (Math.random()<0.01) {
			neuerTyp=(int)(Math.random()*10);
		}
		if (Math.random()<0.1) {
			neuesAdvance=advance-(int)(Math.random()*4)+2;
		}
		neueDNA.add(new Gen (neuerTyp, neueDrehung, neuesAdvance));
		if (Math.random()<0.01) {
			neueDNA.add(new Gen (neuerTyp, neueDrehung, neuesAdvance));
		}
	}
	public Typ getTyp () {
		int i = typ%3;
		if (i==0) {
			return Typ.STAMM;
		}
		else if (i==1) {
			return Typ.BLATT;
		}
		else {
			return Typ.NICHTS;
		}
	}
	public int getDrehung () {
		return drehung%360;
	}
	public int getAdvance () {
		return advance;
	}
}
