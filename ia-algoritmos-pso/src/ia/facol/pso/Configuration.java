package ia.facol.pso;


import ia.facol.problems.Problemable;

public class Configuration {	
	
	private int numberParticles;
	
	private Problemable problem;
	
	private IFactor c1;
	
	private IFactor c2;
	
	private IFactor inertialFactor;
	
	private double minVelocity;
	
	private double maxVelocity;

	private ICommunicationTopology communicationTopology;
	
	private int maxIt;
	
	public int getNumberParticles() {
		return numberParticles;
	}

	public void setNumberParticles(int numberParticles) {
		this.numberParticles = numberParticles;
	}

	public Problemable getProblem() {
		return problem;
	}

	public void setProblem(Problemable problem) {
		this.problem = problem;
	}

	public IFactor getC1() {
		return c1;
	}

	public void setC1(IFactor c1) {
		this.c1 = c1;
	}

	public IFactor getC2() {
		return c2;
	}

	public void setC2(IFactor c2) {
		this.c2 = c2;
	}

	public IFactor getInertialFactor() {
		return inertialFactor;
	}

	public void setInertialFactor(IFactor inertialFactor) {
		this.inertialFactor = inertialFactor;
	}

	public double getMinVelocity() {
		return minVelocity;
	}

	public void setMinVelocity(double minVelocity) {
		this.minVelocity = minVelocity;
	}

	public double getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(double maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	public ICommunicationTopology getCommunicationTopology() {
		return communicationTopology;
	}

	public void setCommunicationTopology(ICommunicationTopology communicationTopology) {
		this.communicationTopology = communicationTopology;
	}

	public int getMaxIt() {
		return maxIt;
	}

	public void setMaxIt(int maxIt) {
		this.maxIt = maxIt;
	}

}
