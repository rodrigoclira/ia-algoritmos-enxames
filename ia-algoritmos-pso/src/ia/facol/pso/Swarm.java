package ia.facol.pso;

import java.util.LinkedList;
import java.util.List;

public class Swarm {
	
	private List<Particle> particles;
	
	private Configuration configuration;
		
	private double bestFitness;
	
	private List<Double> gBestPosition;	
	
	private boolean debug;
	
	public Swarm(Configuration conf, boolean debug){
		this.debug = debug;		
		this.configuration = conf;
		this.bestFitness = Double.MAX_VALUE;
		this.particles = new LinkedList<Particle>();
		Particle p = null;
		for(int i = 0; i < conf.getNumberParticles(); i+=1){
			p = new Particle(conf, i);
			p.updateFitness();
			
			if (p.getFitness() < bestFitness){
				this.bestFitness = p.getFitness();
				this.gBestPosition = new LinkedList<Double>(p.getPosition());
			}
			
			this.particles.add(p);
		}
	}
	
	public List<Double> run(){
		int it = 0;
		List<Double> gBest;
		Particle currParticle = null;
		while (it < configuration.getMaxIt()){
			for (int i = 0; i < this.particles.size(); i+=1){							
				currParticle = particles.get(i);				

				gBest = configuration.getCommunicationTopology().bestPosition(this, currParticle.getLabel());								
				currParticle.updateVelocity(it, gBest);
				currParticle.updatePosition();
				currParticle.updateFitness();
				
				if (currParticle.getFitness() < this.bestFitness){
					this.bestFitness = currParticle.getFitness();
					this.gBestPosition = new LinkedList<Double>(currParticle.getPosition());
				}
			}
			
			if (debug && it % 1000 == 0){
                System.out.println("\n\nExecuting " + it); 
                System.out.println("####################################");
                System.out.println("MELHOR FITNESS " + bestFitness);                
                System.out.println("MELHOR POSICAO: ");
                for (Double d : gBestPosition){
                	System.out.print(d + " ");
                }
                System.out.println("\n####################################");
			}
			
			
			it+=1;				
			
		}
		
		return gBestPosition;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Particle p : particles){
			sb.append(p.toString());
		}
		return sb.toString();
	}

	public List<Double> getgBestPosition() {
		return gBestPosition;
	}

	public void setgBestPosition(List<Double> gBestPosition) {
		this.gBestPosition = gBestPosition;
	}

	public List<Particle> getParticles() {
		return particles;
	}

	public void setParticles(List<Particle> particles) {
		this.particles = particles;
	}

}
