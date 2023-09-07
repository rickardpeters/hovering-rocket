public class StateAndReward {

	
	/* State discretization function for the angle controller */
	public static String getStateAngle(double angle, double vx, double vy) {

		String state;
		
		int discretizedAngle = discretize2(angle,4,-Math.PI, Math.PI);
		
		if (discretizedAngle == 0) {
			state = "quadrant0";
		} else if (discretizedAngle == 1) {
			state = "quadrant1";
		} else if (discretizedAngle == 2) {
			state = "quadrant2";
		} else {
			state = "quadrant3";
		}

		return state;
	}

	/* Reward function for the angle controller */
	public static double getRewardAngle(double angle, double vx, double vy) {
		
		double reward = Math.PI - Math.abs(angle); //Ju mer han riktar sig rakt upp, desto högre poäng!
		
		return reward;
	}

	/* State discretization function for the full hover controller */
	public static String getStateHover(double angle, double vx, double vy) {

		/* TODO: IMPLEMENT THIS FUNCTION */

		String state;
		
		int discretizedAngle = discretize2(angle,4,-Math.PI, Math.PI);
		int discretizedVx = discretize2(vx, 2, -10, 10);
		int discretizedVy = discretize2(vy, 2, -10, 10);
		
		
		//Kanske bängt för blir sjukt mycket states.
		if (discretizedAngle == 0 && discretizedVx == 0 && discretizedVy == 0) {
			state = "state1";
		} else if (discretizedAngle == 0 && discretizedVx == 1 && discretizedVy == 0) {
			state = "state2";
		} else if (discretizedAngle == 0 && discretizedVx == 1 && discretizedVy == 1) {
			state = "state3";
		} else if (discretizedAngle == 0 && discretizedVx == 0 && discretizedVy == 1) {
			state = "state4";
			
		} else if (discretizedAngle == 1 && discretizedVx == 0 && discretizedVy == 0) {
			state = "state5";
		} else if (discretizedAngle == 1 && discretizedVx == 1 && discretizedVy == 0) {
			state = "state6";
		} else if (discretizedAngle == 1 && discretizedVx == 1 && discretizedVy == 1) {
			state = "state7";
		} else if (discretizedAngle == 1 && discretizedVx == 0 && discretizedVy == 1) {
			state = "state8";
		
		} else if (discretizedAngle == 2 && discretizedVx == 0 && discretizedVy == 0) {
			state = "state9";
		} else if (discretizedAngle == 2 && discretizedVx == 1 && discretizedVy == 0) {
			state = "state10";
		} else if (discretizedAngle == 2 && discretizedVx == 1 && discretizedVy == 1) {
			state = "state11";
		} else if (discretizedAngle == 2 && discretizedVx == 0 && discretizedVy == 1) {
			state = "state12";
		
		} else if (discretizedAngle == 3 && discretizedVx == 0 && discretizedVy == 0) {
			state = "state13";
		} else if (discretizedAngle == 3 && discretizedVx == 1 && discretizedVy == 0) {
			state = "state14";
		} else if (discretizedAngle == 3 && discretizedVx == 1 && discretizedVy == 1) {
			state = "state15";
		} else {
			state = "state16";
		}
		
		return state;
	}

	/* Reward function for the full hover controller */
	public static double getRewardHover(double angle, double vx, double vy) {
		
		double reward = Math.PI + 20 - Math.abs(angle) - Math.abs(vx) - Math.abs(vy); //ju mer han riktar sig rakt upp, samt håller låg hastighet i båda riktningarna, desto mer godis

		return reward;
	}

	// ///////////////////////////////////////////////////////////
	// discretize() performs a uniform discretization of the
	// value parameter.
	// It returns an integer between 0 and nrValues-1.
	// The min and max parameters are used to specify the interval
	// for the discretization.
	// If the value is lower than min, 0 is returned
	// If the value is higher than min, nrValues-1 is returned
	// otherwise a value between 1 and nrValues-2 is returned.
	//
	// Use discretize2() if you want a discretization method that does
	// not handle values lower than min and higher than max.
	// ///////////////////////////////////////////////////////////
	public static int discretize(double value, int nrValues, double min,
			double max) {
		if (nrValues < 2) {
			return 0;
		}

		double diff = max - min;

		if (value < min) {
			return 0;
		}
		if (value > max) {
			return nrValues - 1;
		}

		double tempValue = value - min;
		double ratio = tempValue / diff;

		return (int) (ratio * (nrValues - 2)) + 1;
	}

	// ///////////////////////////////////////////////////////////
	// discretize2() performs a uniform discretization of the
	// value parameter.
	// It returns an integer between 0 and nrValues-1.
	// The min and max parameters are used to specify the interval
	// for the discretization.
	// If the value is lower than min, 0 is returned
	// If the value is higher than min, nrValues-1 is returned
	// otherwise a value between 0 and nrValues-1 is returned.
	// ///////////////////////////////////////////////////////////
	public static int discretize2(double value, int nrValues, double min,
			double max) {
		double diff = max - min;

		if (value < min) {
			return 0;
		}
		if (value > max) {
			return nrValues - 1;
		}

		double tempValue = value - min;
		double ratio = tempValue / diff;

		return (int) (ratio * nrValues);
	}

}
