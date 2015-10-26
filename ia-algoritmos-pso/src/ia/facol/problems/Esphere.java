package ia.facol.problems;

import java.util.List;

public class Esphere extends Problemable{
	public static final String NAME = "Esphere";
	
	public Esphere(int dimensions, double lowerBound, double upperBound){
		super(NAME, dimensions,  lowerBound, upperBound);
	}
	
	/**
	 * http://www-optima.amp.i.kyoto-u.ac.jp/member/student/hedar/Hedar_files/TestGO_files/Page1113.htm
	 */
	public Double evaluate(List<Double> gene){
		double sum = 0.0;
		for (Double value : gene){
			sum += value * value;
		}
		
		return sum; 
	}

}
