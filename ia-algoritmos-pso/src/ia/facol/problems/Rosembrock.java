package ia.facol.problems;

import java.util.List;

public class Rosembrock extends Problemable{
	
	public static final String NAME = "Rosembrock";
	
	public Rosembrock(int dimensions, double lowerBound, double upperBound){
		super(NAME, dimensions,  lowerBound, upperBound);
	}
	
	/**
	 * http://www-optima.amp.i.kyoto-u.ac.jp/member/student/hedar/Hedar_files/TestGO_files/Page2537.htm
	 */
	@Override
	public Double evaluate(List<Double> gene) {
		double sum = 0;
		int count = 0;
		double xi1, xi;
		
		while (count < gene.size() -1){
			xi1 = gene.get(count+1);
			xi = gene.get(count);
			
			sum += 100 *  Math.pow(Math.pow(xi, 2) - xi1, 2) + Math.pow(xi - 1, 2);  
			count += 1;
		}
		
		return sum;
	}

}
