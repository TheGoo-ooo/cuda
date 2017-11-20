
package ch.arc.cours.lamda.g_image.tools;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameImage extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * BufferedImage derive de Image
	 */
	public JFrameImage(Image image)
		{
		this.image = image;

		geometry();
		control();
		appearance();
		}

	public JFrameImage(ImageIcon image)
		{
		this(image.getImage());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		this.pannel = new JPanelImage(image);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			}

		// JComponent : add
		add(pannel, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(image.getWidth(this), image.getHeight(this));
		setLocationRelativeTo(null); // frame centrer
		setResizable(false);
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private Image image;

	// Tools
	private JPanelImage pannel;

	}
