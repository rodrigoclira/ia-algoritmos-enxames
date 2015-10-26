package ia.facol.pso;

public class LinearDecay implements IFactor{
	
	private double startValue;
	
	private double endValue;
	
	private int maxIteration;
	
	private boolean decay;
	
	public LinearDecay(double startValue, double endValue, int maxIteration, boolean decay){
		this.startValue = startValue;
		this.endValue = endValue;
		this.maxIteration = maxIteration;
		this.decay = decay;
	}

	@Override
	public double aplly(int iteration) {
		int mul = 1;
		if (decay){
			mul = -1;
		}
		
		return this.startValue + mul * iteration * this.endValue/(this.maxIteration);
	}

}
