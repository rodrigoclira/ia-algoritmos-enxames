package ia.facol.pso;

import java.util.List;

public class GBestCommunication  implements ICommunicationTopology{

	@Override
	public List<Double> bestPosition(Swarm swarm, int label) {
		return swarm.getgBestPosition();
	}

}
