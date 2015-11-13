import java.util.ArrayList;

public class Baum {
	private ArrayList <Gen> dna;
	private int ort;
	private int age;
	private int energie;
	private ArrayList <Stamm> staemme;
	private ArrayList <Blatt> blaetter;
	public Baum (ArrayList<Gen> dnaPar,int ortPar) {
		dna=dnaPar;
		ort=ortPar;
		energie=0;
		age=1;
		erstelleBaum();
	}
	public Baum erzeugeNachkommen () {
		Baum nachkomme;
		ArrayList<Gen> neueDNA=new ArrayList<Gen> ();
		//ToDo Iterator
		for (int i=0;i<dna.size();i++) {
			dna.get(i).mutate(neueDNA);
		}
		nachkomme= new Baum (neueDNA, ort);
		return nachkomme;
	}
	public ArrayList<Gen> getDNA () {
		return dna;
	}
	public ArrayList<Stamm> getStaemme () {
		return staemme;
	}
	public ArrayList<Blatt> getBlaetter () {
		return blaetter;
	}
	public int getAge () {
		return age;
	}
	public void alter () {
		age++;
	}
	public void setEnergie (int energiePar) {
		energie=energiePar;
	}
	public void setOrt (int ortPar) {
		ort=ortPar;
	}
	public int getEnergie () {
		return energie;
	}
	public void erstelleBaum () {
		int x=ort;
		int y=0;
		int pointer=-1;
		staemme = new ArrayList<Stamm>();
		blaetter = new ArrayList<Blatt>();
		for (int i=0; i<dna.size();i++) {
			Gen gen=dna.get(i);
			int advance = pointer+gen.getAdvance();
			if (staemme.size()==0||(advance<0)) {
				x=ort;
				y=0;
				pointer=-1;
			}
			else if (advance>=staemme.size()) {
				pointer=staemme.size()-1;
				x=staemme.get(pointer).getX();
				y=staemme.get(pointer).getY();
			}
			else {
				pointer=advance;
				x=staemme.get(pointer).getX();
				y=staemme.get(pointer).getY();
			}
			if (gen.getTyp()==Typ.BLATT) {
				blaetter.add(new Blatt(x,y));
			}
			else if (gen.getTyp()==Typ.STAMM) {
				staemme.add(new Stamm (gen.getDrehung(),x,y));
			}
		}
	}
}
