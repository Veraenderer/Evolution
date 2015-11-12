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
		neueDNA.add(new Gen (typ, drehung, advance));
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
