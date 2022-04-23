package nz.ac.auckland.se281.a2;

public class snack extends orders {
	int done;
	
	public snack(int done) {
		this.done=done;
		// TODO Auto-generated constructor stub
	}

	public double findTime() {
		double timing = 0;
		if (this.done == 0) {
            timing += 3;
            this.done = 1;
            return timing;
        }
        if (this.done != 0) {
            timing += 0.5;
            
        }
		return timing;
		
	}



}