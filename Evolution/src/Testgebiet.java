import java.util.ArrayList;
import java.util.Collections;

public class Testgebiet {
	public ArrayList <Baum> baeume;
	private static int anzahlBaeume;
	private Screen screen;
	public Testgebiet () {
		anzahlBaeume=100;
		erstelleErsteBaeume (anzahlBaeume);
		//testBaum();
		screen=new Screen(baeume);
		
		for (int i=0;i<10000;i++) {
			turn();
			System.out.println ("Generation: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void turn () {
		ArrayList <Baum> neueGeneration = new ArrayList<Baum> ();
		for (int i=0;i<baeume.size();i++) {
			Baum baum = baeume.get(i);
			int energie=0;
			for (int j=0;j<baum.getBlaetter().size();j++) {
				Blatt blatt = baum.getBlaetter().get(j);
				if (blatt.getY()<=0) {
					energie=energie+((-blatt.getY()+1)/4);
				}
				energie--;
			}
			for (int j=0;j<baum.getStaemme().size();j++) {
				energie--;
			}
			baum.setEnergie(energie);
		}
		Collections.sort(baeume);
		System.out.println ("groesste "+baeume.get(0).getEnergie());
		System.out.println ("kleinste "+baeume.get(99).getEnergie());
		for (int i=0;i<anzahlBaeume;i=i+2) {
			Baum baum = baeume.get(i);
			Baum neuerBaum=baum.erzeugeNachkommen();
			neuerBaum.setOrt(i*10);
			neueGeneration.add(neuerBaum);
			neuerBaum=baum.erzeugeNachkommen();
			neuerBaum.setOrt((i+1)*10);
			neueGeneration.add(neuerBaum);

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
	public void testBaum () {
		baeume=new ArrayList<Baum> ();
		ArrayList<Gen> gene = new ArrayList<Gen> ();
		gene.add(new Gen (0,270,1));
		gene.add(new Gen (0,270,1));
		baeume.add(new Baum (gene, 100));
		
		
		
	}
}
