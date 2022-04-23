package nz.ac.auckland.se281.a2;

public class drink extends orders {

	
	public double findTime(int done) {
		double timing = 0;
		if (done == 0) {
            timing += 0.75;
            done = 1;
            return timing;
        }
        if (done != 0) {
            timing += 0.25;
            
        }
		return timing;
		
	}



}