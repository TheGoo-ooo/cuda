
package ch.arc.cours.lamda.g_image.c_transformation;

import javax.swing.ImageIcon;

import org.junit.Assert;

import ch.arc.cours.lamda.g_image.tools.CalibreurInt;
import ch.arc.cours.lamda.g_image.tools.Chrono;
import ch.arc.cours.lamda.g_image.tools.ColorTools;
import ch.arc.cours.lamda.g_image.tools.ImageTools;
import ch.arc.cours.lamda.g_image.tools.Interval;
import ch.arc.cours.lamda.g_image.tools.JFrameImage;
import ch.arc.cours.lamda.g_image.tools.MagasinImage;

public class UseTransformation_standard_01
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		System.out.println("transformation : code standard");

		ImageIcon image = MagasinImage.LENA;
		//ImageIcon image = MagasinImage.MOUNTAIN;

		int h = image.getIconHeight();
		int w = image.getIconWidth();

		new JFrameImage(image); // originale

		// Transformation
			{
			int[] tabARGB = ImageTools.toArray(image);

			transformation(tabARGB, w, h); // sur place

			new JFrameImage(ImageTools.toBufferedImage(tabARGB, w, h)); // Transformer
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * code sequentiel standard
	 * sur place
	 */
	private static void transformation(int[] tabARGB, int w, int h)
		{
		Chrono chrono = new Chrono();

		toGray(tabARGB, w, h); // sur place
		contraster(tabARGB, w, h);// sur place

		chrono.stop();
		System.out.println(chrono);
		}

	/**
	 * code sequentiel standard
	 */
	private static void toGray(int[] tabARGB, int w, int h)
		{
		int s = 0;
		for(int i = 0; i < h; i++)
			{
			for(int j = 0; j < w; j++)
				{
				int colorARGB = tabARGB[s];

				int red = ColorTools.red(colorARGB);
				int green = ColorTools.green(colorARGB);
				int blue = ColorTools.blue(colorARGB);

				int levelGray = (red + green + blue) / 3;

				//Assert.assertTrue(levelGray >= 0 && levelGray <= 255);

				tabARGB[s++] = ColorTools.toRGB(levelGray);
				}
			}
		}

	/**
	 * code sequentiel standard
	 */
	private static void contraster(int[] tabARGB, int w, int h)
		{
		Interval<Integer> minmax = minMax(tabARGB, w, h);
		amplifier(tabARGB, w, h, minmax);

		// check
			{
			Interval<Integer> minmaxAfter = minMax(tabARGB, w, h);

			System.out.println("minmax Before= " + minmax);
			System.out.println("minmax After = " + minmaxAfter);

			Assert.assertTrue(minmaxAfter.getA() == 0 && minmaxAfter.getB() == 255);
			}
		}

	/**
	 * code sequentiel standard
	 */
	private static Interval<Integer> minMax(int[] tabARGB, int w, int h)
		{
		int min = Integer.MAX_VALUE; // 255 aurait suffit!
		int max = 0;

		int s = 0;
		for(int i = 0; i < h; i++)
			{
			for(int j = 0; j < w; j++)
				{
				int colorARGB = tabARGB[s++];

				int levelGray = ColorTools.red(colorARGB); // disons, possible car image en niveau de gray

				//Assert.assertTrue(levelGray >= 0 && levelGray <= 255);

				min = Math.min(min, levelGray);
				max = Math.max(max, levelGray);
				}
			}

		Assert.assertTrue(min <= max);
		Assert.assertTrue(min >= 0 && max <= 255);

		return new Interval<Integer>(min, max);
		}

	/**
	 * code sequentiel standard
	 */
	private static void amplifier(int[] tabARGB, int w, int h, Interval<Integer> minmax)
		{
		int min = minmax.getA();
		int max = minmax.getB();
		Interval<Integer> depart = new Interval<Integer>(min, max);
		Interval<Integer> arriver = new Interval<Integer>(0, 255);
		CalibreurInt calibreur = new CalibreurInt(depart, arriver);

		int s = 0;
		for(int i = 0; i < h; i++)
			{
			for(int j = 0; j < w; j++)
				{
				int colorARGB = tabARGB[s];

				int levelGray = ColorTools.red(colorARGB);
				int levelGrayNew = calibreur.calibrer(levelGray);

				tabARGB[s++] = ColorTools.toRGB(levelGrayNew);
				}
			}
		}

	}
