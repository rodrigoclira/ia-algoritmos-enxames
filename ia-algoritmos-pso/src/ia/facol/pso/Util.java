package ia.facol.pso;

public class Util {

	/*
	 * http://stackoverflow.com/questions/4403542/how-does-java-do-modulus-calculations-with-negative-numbers
	 */
	public static int myModulus(int value, int mod){
		int r = value % mod;
		if (r < 0)
		{
		    r += mod;
		}
		return r;
	}

}
