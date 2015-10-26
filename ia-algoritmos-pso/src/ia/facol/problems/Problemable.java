package ia.facol.problems;

import java.util.List;

/**
 * 
 * @author rcls
 *
 * 
 * 
 * Interface usada para definir um problema.
 */

public abstract class Problemable{
	private Double upperBound;
	private Double lowerBound;
	private int dimensions;
	private String name;
	
	public Problemable(String name, int dimensions, Double lowerBound, Double upperBound){
		setLowerBound(lowerBound);
		setUpperBound(upperBound);
		setDimensions(dimensions);
		setName(name);
	}
	
	public abstract Double evaluate(List<Double> gene);
	
	public Double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Double lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	public Double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return String.format("%s-%dd ( %.2f, %.2f )", this.getName(), this.dimensions, this.getLowerBound(), this.getUpperBound());
	}

	public int getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}

}
