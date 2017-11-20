
package ch.arc.cours.lamda.g_image.a_pink;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

import ch.arc.cours.lamda.g_image.tools.Chrono;
import ch.arc.cours.lamda.g_image.tools.ImageTools;
import ch.arc.cours.lamda.g_image.tools.JFrameImage;

public class UseImagePink
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
		int w = 1200;
		int h = w;

		BufferedImage image = createImage(w, h);

		new JFrameImage(image);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static BufferedImage createImage(int w, int h)
		{
		Chrono chrono = new Chrono();

//		int[] tabARGB = createArrayPixel_v1(w, h);
//		int[] tabARGB = createArrayPixel_v2(w, h);
		int[] tabARGB = createArrayPixel_v3(w, h);

		chrono.stop();
		System.out.println("[Pink] : "+chrono);

		return ImageTools.toBufferedImage(tabARGB, w, h);
		}

	/**
	 * code standard
	 * sans stream
	 * sequentiel
	 */
	private static int[] createArrayPixel_v1(int w, int h)
		{
		ColorieurPink colorieur = new ColorieurPink(w, h);

		// code standard v1 (i,j)
		//					{
		//					int[] tab = new int[w * h];
		//
		//					int s = 0;
		//					for(int i = 0; i < h; i++)
		//						{
		//						for(int j = 0; j < w; j++)
		//							{
		//							tab[s++] = colorieur.colorIJ(i, j);
		//							}
		//						}
		//
		//					return tab;
		//					}

		// code standard v2 (s)
			{
			int[] tab = new int[w * h];

			for(int s = 0; s < w * h; s++)
				{
				tab[s] = colorieur.color(s);
				}

			return tab;
			}

		}

	/**
	 * IntStream
	 * parallel (plus performant ssi grande image)
	 * modify tab
	 */
	private static int[] createArrayPixel_v2(int w, int h)
		{
		ColorieurPink colorieur = new ColorieurPink(w, h);

		int[] tab = new int[w * h];

		// Parallel is slower in this case.
		//Stream.iterate(0, i -> i = i+1).limit(w * h).mapToInt(Integer::valueOf).forEach(i -> tab[i] = colorieur.color(i));
		IntStream.range(0, w*h).forEach(i -> tab[i] = colorieur.color(i));

		return tab;
		}

	/**
	 * IntStream
	 * parallel (plus performant ssi grande image)
	 * create tab with toArray
	 */
	private static int[] createArrayPixel_v3(int w, int h)
		{
		ColorieurPink colorieur = new ColorieurPink(w, h);

		//parallel plus lent dans ce cas.
		int[] tab = IntStream.range(0, w*h).map(colorieur::color).toArray();

		return tab;
		}

	}
