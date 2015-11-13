import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Zeichenflaeche extends JPanel {
	private int width, height;
	private ArrayList<Baum> baeume;
	public Zeichenflaeche (int widthPar,int heightPar, ArrayList<Baum> baeumePar) {
		width=widthPar;
		height=heightPar;
		baeume=baeumePar;
	}
	
	public void setBaeume (ArrayList<Baum> baeumePar) {
		baeume=baeumePar;
	}
	
	public void paint (Graphics g) {
		g.clearRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawLine(0, height/2, width, height/2);
		for (int i=0;i<baeume.size();i++) {
			Baum baum=baeume.get(i);
			for (int j=0;j<baum.getStaemme().size();j++) {
				paintStamm (g,baum.getStaemme().get(j));
			}
			for (int j=0;j<baum.getBlaetter().size();j++) {
				paintBlatt (g,baum.getBlaetter().get(j));
			}
		}
	}
	public void paintStamm (Graphics g, Stamm stamm) {
		g.setColor(Color.RED);
		g.drawLine(stamm.getX(), stamm.getY()+height/2, stamm.getxEnde(), stamm.getyEnde()+height/2);
	}
	public void paintBlatt (Graphics g, Blatt blatt) {
		g.setColor(Color.GREEN);
		g.drawOval(blatt.getX()-3, blatt.getY()-3+height/2, 7, 7);
	}
}
