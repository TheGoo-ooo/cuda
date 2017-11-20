
package ch.arc.cours.lamda.g_image.tools;

import org.junit.Assert;

public class Chrono
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Chrono()
		{
		start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		Assert.assertTrue(delta >= 0);

		return delta+" [ms]";
		}

	public void start()
		{
		delta=-1;
		start = System.currentTimeMillis();
		}

	/**
	 * ms
	 */
	public long stop()
		{
		stop = System.currentTimeMillis();
		delta = stop - start;
		Assert.assertTrue(delta >= 0);

		return delta;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// tools
	private long start;
	private long stop;
	// outputs
	private long delta;
	}
