
package ch.arc.cours.lamda.g_image.tools;

public class CalibreurInt
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public CalibreurInt(Interval<Integer> depart, Interval<Integer> arriver)
		{
		// Inputs
			{
			this.depart = depart;
			this.arriver = arriver;
			}

		create();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public int calibrer(int x)
		{
		return (int)(x * pente + translation);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void create()
		{
		int x1 = depart.getA();
		int x2 = depart.getB();

		int y1 = arriver.getA();
		int y2 = arriver.getB();

		this.pente = (y2 - y1) / (double)(x2 - x1);

		this.translation = y1 - pente * x1;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private Interval<Integer> depart;
	private Interval<Integer> arriver;

	// Tools
	private double pente;
	private double translation;

	}
