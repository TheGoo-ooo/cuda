
package ch.arc.cours.material;

import org.junit.Assert;

public class HistoTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * histo regulier plat si n multiple de LIMITE
	 */
	public static int[] createDataInput(int n) // TODO cbi : faire mieux : exemple droite
		{
		int[] tab = new int[n];

		for(int i = 0; i < n; i++)
			{
			tab[i] = i % LIMITE;
			Assert.assertTrue(tab[i] >= 0 && tab[i] <= LIMITE);
			}

		return tab;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final int LIMITE = 255;
	}
