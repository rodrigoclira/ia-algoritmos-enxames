package ia.facol.problems;

import java.util.List;

public class Griewank extends Problemable {
	
	public static final String NAME = "Griewank";
	
	public Griewank(int dimensions, double lowerBound, double upperBound){
		super(NAME, dimensions,  lowerBound, upperBound);
	}
	
	/**
	 * http://www-optima.amp.i.kyoto-u.ac.jp/member/student/hedar/Hedar_files/TestGO_files/Page1905.htm
	 */
	@Override
	public Double evaluate(List<Double> gene) {
		double sum = 0;
		double product = 1;
		int count = 0;
		
		while (count < gene.size()){
			sum += Math.pow(gene.get(count), 2);
			count+=1;
		}
		sum = (1.0 / 4000) * sum;
		count = 1;
		while (count < gene.size() + 1){
			product *= Math.cos(gene.get(count - 1) / Math.sqrt(count));
			count+=1;
		}
		
		return sum + product + 1;
		
	}

}
