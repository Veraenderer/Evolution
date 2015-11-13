import java.util.ArrayList;

import javax.swing.JFrame;


public class Screen extends JFrame {
	private int width,height;
	private Zeichenflaeche zeichenflaeche;
	public Screen (ArrayList<Baum> baeumePar) {
		width=1600;
		height=800;
		zeichenflaeche=new Zeichenflaeche (width,height,baeumePar);
		setSize(width, height);
		setLayout(null);
		zeichenflaeche.setBounds(0,0,width,height);
		add (zeichenflaeche);
		zeichenflaeche.repaint();
		setVisible (true);
	}
	public void uebergebeBaume (ArrayList<Baum> baeumePar) {
		zeichenflaeche.setBaeume(baeumePar);
		zeichenflaeche.repaint();
	}
}
