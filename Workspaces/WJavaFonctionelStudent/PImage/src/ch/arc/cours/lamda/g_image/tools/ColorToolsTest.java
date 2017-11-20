
package ch.arc.cours.lamda.g_image.tools;

import java.awt.Color;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColorToolsTest
	{
	/*------------------------------------------------------------------*\
		 |*							Constructeurs							*|
		 \*------------------------------------------------------------------*/

	@Before
	public void before()
		{
		// rien
		}

	@After
	public void after()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
		 |*							Methodes Public							*|
		 \*-----------------------------------------------------------------*/

	@Test
	public void testToInt()
		{
		final int n = 255;

		for(int levelGray = 0; levelGray <= n; levelGray++)
			{
			Assert.assertTrue(ColorTools.toRGB(levelGray) == new Color(levelGray, levelGray, levelGray).getRGB());
			}
		}

	@Test
	public void testFromInt()
		{
		final int n = 255;
		for(int a = 0; a <= n; a++)
			{
			for(int r = 0; r <= n; r++)
				{
				for(int g = 0; g <= n; g++)
					{
					for(int b = 0; b <= n; b++)
						{
						int argb = new Color(r, g, b,a).getRGB();

						Assert.assertTrue(ColorTools.alpha(argb) == new Color(argb).getAlpha());
						Assert.assertTrue(ColorTools.red(argb) == new Color(argb).getRed());
						Assert.assertTrue(ColorTools.green(argb) == new Color(argb).getGreen());
						Assert.assertTrue(ColorTools.blue(argb) == new Color(argb).getBlue());
						}
					}
				}
			}
		}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	}
