
package ch.arc.cours.lamda.g_image.tools;

import java.awt.Color;

public class ColorTools
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	/**
	 * opaque
	 */
	public static int toRGB(int levelGray)
		{
		//Assert.assertTrue(levelGray >= 0 && levelGray < 255);

		return (ALPHA_OPAQUE << 24) | (levelGray << 16) | (levelGray << 8) | levelGray;

		//return new Color(levelGray,levelGray,levelGray).getRGB();
		}

	/**
	 * opaque
	 */
	public static int toRGB(int r, int g, int b)
		{
		//		Assert.assertTrue(r >= 0 && r < 255);
		//		Assert.assertTrue(g >= 0 && g < 255);
		//		Assert.assertTrue(b >= 0 && b < 255);

		return (ALPHA_OPAQUE << 24) | (r << 16) | (g << 8) | b;

		//return new Color(r,g,b).getRGB();
		}

	/**
	 * opaque ssi alpha = 255
	 */
	public static int alpha(int argb)
		{
		 return new Color(argb).getAlpha();
		//return argb >> 24 & 0xFF;
		}

	public static int red(int argb)
		{
		//return new Color(argb).getRed();
		return argb >> 16 & 0xFF;
		}

	public static int green(int argb)
		{
		// return new Color(argb).getGreen();
		return argb >> 8 & 0xFF;
		}

	public static int blue(int argb)
		{
		// return new Color(argb).getBlue();
		return argb & 0xFF;
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

	/**
	 * opaque ssi alpha = 255
	 */
	private static final int ALPHA_OPAQUE = 255;
	}
