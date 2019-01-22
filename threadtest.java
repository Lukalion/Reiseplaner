
public class threadtest extends Thread {
	private GUI g;
	public threadtest(GUI h) {
		this.g = h;
	this.start();
	}
	public void run() {
		while(true) {
			int h = g.getHeight();
			int w = g.getWidth();
			double h1 = (double)h/2;
			double w1 =(double) w/2;
			h = (int)h1;
			w = (int)w1;
			g.Ueberschrift.setLocation(w, h);
			break;
				
		}
	}

}
