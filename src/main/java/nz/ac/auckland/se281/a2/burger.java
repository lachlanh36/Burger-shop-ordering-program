package nz.ac.auckland.se281.a2;

public class burger extends orders {

	
	public burger(int done) {
		// TODO Auto-generated constructor stub
	}

	public double findTime() {
		double timing = 0;
		if (done == 0) {
            timing += 5;
            done = 1;
            return timing;
        }
		else {
            timing += 1;
            return timing;
        }
		
		
	}



}
