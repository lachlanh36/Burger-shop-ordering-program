package nz.ac.auckland.se281.a2;

public class snack extends orders {

	
	public double findTime(int done) {
		double timing = 0;
		if (done == 0) {
            timing += 3;
            done = 1;
            return timing;
        }
        if (done != 0) {
            timing += 0.5;
            
        }
		return timing;
		
	}



}