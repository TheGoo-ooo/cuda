
package ch.arc.cours.lamda.g_image.a_pink;

import java.awt.Color;

import ch.arc.cours.lamda.g_image.tools.Colorieur_A;

public class ColorieurPink extends Colorieur_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ColorieurPink(int w, int h)
		{
		super(w, h);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public int colorIJ(int i, int j)
		{
		return Color.PINK.getRGB();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}

