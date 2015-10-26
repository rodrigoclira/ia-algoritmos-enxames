package ia.facol.pso;

import java.util.LinkedList;
import java.util.List;

public class LBestCommunication implements ICommunicationTopology{

	@Override
	public List<Double> bestPosition(Swarm swarm, int label) {

		return lbest( swarm.getParticles().get(Util.myModulus((label - 1), swarm.getParticles().size()))
					, swarm.getParticles().get(Util.myModulus((label + 1), swarm.getParticles().size())) 
					);
	}

	private List<Double> lbest(Particle p1, Particle p2){
		if (p1.getFitness() < p2.getFitness()){
			return new LinkedList<Double>(p1.getPosition());
		}else{
			return new LinkedList<Double>(p2.getPosition());
		}
	}
	
	
}
