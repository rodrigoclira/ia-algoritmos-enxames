package ia.facol.pso;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Particle {
	
	private Configuration configuration;
	
	private List<Double> position;
	
	private List<Double> velocity;
	
	private double fitness;
	
	private int label;
	
	private List<Double> pbest;
	
	private double pBestFitness;
	
	private Random random;
	
	public Particle(Configuration c, int label){
		this.configuration = c;
		this.random = new Random();
		this.label  = label;
		this.position = new LinkedList<Double>();
		this.velocity = new LinkedList<Double>();
		double value;
		
		for (int i = 0; i < configuration.getProblem().getDimensions(); i+=1){
			
			value = random.nextDouble() * 
					(configuration.getProblem().getUpperBound() - configuration.getProblem().getLowerBound()) 
					+ configuration.getProblem().getLowerBound(); 

			position.add(value);
			
			value = random.nextDouble() * 
					(configuration.getMaxVelocity() - configuration.getMinVelocity()) + configuration.getMinVelocity();
			
			velocity.add(value);			
		}
		
		pbest = new LinkedList<Double>(position);
		pBestFitness = Double.MAX_VALUE;
		fitness = Double.MAX_VALUE;
		
	}
	
	
	public void updatePosition(){
		int pos = 0;
		
		while (pos < velocity.size()){ 
			position.set(pos, position.get(pos) + velocity.get(pos) );
			
			if (position.get(pos)  < configuration.getProblem().getLowerBound()){				
				position.set(pos, configuration.getProblem().getLowerBound());
				velocity.set(pos, - velocity.get(pos));
				
			}else if (position.get(pos) > configuration.getProblem().getUpperBound()){				
				position.set(pos, configuration.getProblem().getUpperBound());
				velocity.set(pos, - velocity.get(pos));
				
			}			
			pos+=1;
		}
	}
	
	public void updateVelocity(int iteration, List<Double> gbest){
		int pos = 0;
		double initFactor = 0.0;
		double veloc = 0.0;
		while ( pos < position.size()){
			initFactor = configuration.getInertialFactor().aplly(iteration);
			veloc = velocity.get(pos)  * initFactor + 
					configuration.getC1().aplly(iteration) * random.nextDouble() * (pbest.get(pos) - position.get(pos)) + 
					configuration.getC2().aplly(iteration) * random.nextDouble() * (gbest.get(pos) - position.get(pos));
			
			velocity.set(pos, veloc);
			if (veloc > configuration.getMaxVelocity()){
				velocity.set(pos, configuration.getMaxVelocity());
			}else if (veloc < configuration.getMinVelocity()){
				velocity.set(pos, configuration.getMinVelocity());
			}
			
			pos+=1;
		}
		
	}
	
	
	private String  printIndividuos(List<Double> list){
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for (Double g : list){
			sb.append(" " + g);
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	public String toString(){
		String st = null;
				
		st = String.format("(%05d) | FIT = %05.25f | POS = %s | VEL = %s | PBEST = %s\n", this.label, this.getFitness(), printIndividuos(this.position), printIndividuos(velocity), printIndividuos(pbest));
		
		return st;
	}
	
	public void updateFitness(){
		this.fitness = this.configuration.getProblem().evaluate(this.position);
		
		if (this.fitness < this.pBestFitness){
			this.pBestFitness  = this.fitness;
			this.pbest = new LinkedList<Double>(position);			
		}		
	}


	public Configuration getConfiguration() {
		return configuration;
	}


	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}


	public List<Double> getPosition() {
		return position;
	}


	public void setPosition(List<Double> position) {
		this.position = position;
	}


	public List<Double> getVelocity() {
		return velocity;
	}


	public void setVelocity(List<Double> velocity) {
		this.velocity = velocity;
	}


	public double getFitness() {
		return fitness;
	}


	public void setFitness(double fitness) {
		this.fitness = fitness;
	}


	public int getLabel() {
		return label;
	}


	public void setLabel(int label) {
		this.label = label;
	}


	public List<Double> getPbest() {
		return pbest;
	}


	public void setPbest(List<Double> pbest) {
		this.pbest = pbest;
	}


	public double getpBestFitness() {
		return pBestFitness;
	}


	public void setpBestFitness(double pBestFitness) {
		this.pBestFitness = pBestFitness;
	}


	public Random getRandom() {
		return random;
	}


	public void setRandom(Random random) {
		this.random = random;
	}
		
}
