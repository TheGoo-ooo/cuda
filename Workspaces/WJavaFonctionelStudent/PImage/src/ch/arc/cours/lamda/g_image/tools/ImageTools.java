
package ch.arc.cours.lamda.g_image.tools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;

public class ImageTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				toBuffered		*|
	\*------------------------------*/

	public static BufferedImage toBufferedImage(int[] tabARGB, int w, int h)
		{
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		image.setRGB(0, 0, w, h, tabARGB, 0, w);

		return image;
		}

	public static BufferedImage toBufferedImage(Image image)
		{
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return bufferedImage;
		}

	public static BufferedImage toBufferedImage(ImageIcon imageIcon)
		{
		return toBufferedImage(imageIcon.getImage());
		}

	/*------------------------------*\
	|*				toArray			*|
	\*------------------------------*/

	/**
	 * int argb
	 */
	public static int[] toArray(BufferedImage bufferedImage)
		{
		DataBuffer buffer = bufferedImage.getRaster().getDataBuffer();

		return ((DataBufferInt)buffer).getData();
		}

	/**
	 * int argb
	 */
	public static int[] toArray(Image image)
		{
		return toArray(toBufferedImage(image));
		}

	/**
	 * int argb
	 */
	public static int[] toArray(ImageIcon imageIcon)
		{
		return toArray(toBufferedImage(imageIcon.getImage()));
		}

	//	public static byte[] getByte(BufferedImage bufferedImage)
	//		{
	//		DataBuffer buffer = bufferedImage.getRaster().getDataBuffer();
	//
	//		return ((DataBufferByte)buffer).getData();
	//		}
	//
	//	public static byte[] getByte(Image image)
	//		{
	//		return getByte(toBufferedImage(image));
	//		}

	//	public static byte[] getByte(ImageIcon imageIcon)
	//		{
	//		return getByte(toBufferedImage(imageIcon.getImage()));
	//		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
