
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.c_binaryoperator.b_reduction_arg.b_argminmax.tools;

import java.util.ArrayList;
import java.util.List;

public class VoitureTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static List<Voiture> create(int n)
		{
		List<Voiture> list = new ArrayList<Voiture>(n);

		for(int i = 0; i < n; i++)
			{
			int prix = 1000 + i;
			int poids = 100 + i;
			Voiture voiture = new Voiture(prix, poids);
			list.add(voiture);
			}

		return list;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	}
