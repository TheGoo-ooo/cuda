
package ch.arc.cours.lamda.g_image.b_rippling;

import org.junit.Assert;

import ch.arc.cours.lamda.g_image.tools.ColorTools;
import ch.arc.cours.lamda.g_image.tools.Colorieur_A;

public class ColorieurRippling extends Colorieur_A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public ColorieurRippling(int w, int h)
		{
		super(w, h);
		Assert.assertTrue(w == h);

		this.dim2 = w / (double)2;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public int colorIJ(int i, int j)
		{
		double t = 1; // para animation pas use ici

		// cf TP rippling pdf serveur ftp.
		double top = Math.cos(dij(i, j)-t/7);
		double divisor = dij(i, j)/ 10 + 1;

		double intensity=128+127*(top/divisor);

		int levelGray = (int)intensity;
		Assert.assertTrue(levelGray >= 0 && levelGray < 255);

		return ColorTools.toRGB(levelGray);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private double dij(int i, int j)
		{
		double fi = i - dim2;
		double fj = j - dim2;

		return Math.sqrt(Math.pow(fi, 2) + Math.pow(fj, 2));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private double dim2;

	}
