import java.util.ArrayList;

public class Testgebiet {
	public ArrayList <Baum> baeume;
	private Screen screen;
	public Testgebiet () {
		erstelleErsteBaeume (100);
		screen=new Screen(baeume);
		for (int i=0;i<10000;i++) {
			turn();
			System.out.println ("Generation: "+i);
		}
	}
	public void turn () {
		ArrayList <Baum> neueGeneration = new ArrayList<Baum> ();
		for (int i=0;i<baeume.size();i++) {
			Baum baum = baeume.get(i);
			int energie=0;
			for (int j=0;j<baum.getBlaetter().size();j++) {
				Blatt blatt = baum.getBlaetter().get(j);
				if (blatt.getY()>=0) {
					energie=energie+6;
				}
				energie--;
			}
			for (int j=0;j<baum.getStaemme().size();j++) {
				energie--;
			}
			for (int j=0;i<energie;i++) {
				neueGeneration.add(baum.erzeugeNachkommen());
			}
		}
		for (int i=0;i<neueGeneration.size();i++) {
			neueGeneration.get(i).setOrt(i*10);
			neueGeneration.get(i).erstelleBaum();;
		}
		baeume=neueGeneration;
		screen.uebergebeBaume(baeume);
	}
	
	public void erstelleErsteBaeume (int anzahl) {
		baeume=new ArrayList<Baum> ();
		for (int i=0;i<anzahl*10;i=i+10) {
			ArrayList<Gen> gene = new ArrayList<Gen> ();
			for (int j=0;j<((int)(20*Math.random()));j++) {
				Gen gen=new Gen((int)(Math.random()*10),(int)(Math.random()*360),(int)(Math.random()*20));
				gene.add(gen);
			}
			baeume.add(new Baum (gene,i));
		}
	}
}
