package ia.facol.pso;

public class UniformFactor implements IFactor{

	private double value; 
	
	public UniformFactor(double value) {
		this.value = value;
	}
	
	@Override
	public double aplly(int interation) {
		return value;
	}

	
}
