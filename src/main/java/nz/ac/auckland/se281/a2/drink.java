package nz.ac.auckland.se281.a2;

public class drink extends orders {
	int done;
	
	public drink(int done) {
		this.done=done;
		// TODO Auto-generated constructor stub
	}

	public double findTime() {
		double timing = 0;
		if (this.done == 0) {
            timing += 0.75;
            this.done = 1;
            return timing;
        }
        if (this.done != 0) {
            timing += 0.25;
            
        }
		return timing;
		
	}



}