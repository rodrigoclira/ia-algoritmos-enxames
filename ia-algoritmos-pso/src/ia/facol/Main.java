package ia.facol;

import java.util.LinkedList;
import java.util.List;

import ia.facol.problems.Esphere;
import ia.facol.pso.Configuration;
import ia.facol.pso.GBestCommunication;
import ia.facol.pso.IFactor;
import ia.facol.pso.LBestCommunication;
import ia.facol.pso.LinearDecay;
import ia.facol.pso.Swarm;
import ia.facol.pso.UniformFactor;
import ia.facol.pso.Util;

public class Main {

	public static void main(String[] args) {
		int maxIteration = 300000;
		
		Configuration conf = new Configuration();
		//IFactor c = new UniformFactor(2.5);	
		
		IFactor c1 = new LinearDecay(2.5, 1, maxIteration, true);
		IFactor c2 = new LinearDecay(1.5, 1, maxIteration, false);
		IFactor inet = new LinearDecay(0.9, 0.5, maxIteration, true);
		
		conf.setC1(c1);		
		conf.setC2(c2);						
		conf.setInertialFactor(inet);		
		conf.setMaxIt(maxIteration);		
		conf.setMaxVelocity(100);
		conf.setMinVelocity(-100);
		conf.setNumberParticles(30);		
		conf.setProblem(new Esphere(30, -100, 100));		
		conf.setCommunicationTopology(new GBestCommunication());
		
		Swarm swarm = new Swarm(conf, true);
		System.out.println(swarm);
		List<Double> gBest = swarm.run();
		System.out.println(swarm);
					
	}

}
