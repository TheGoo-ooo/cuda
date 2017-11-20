
package ch.arc.cours.lamda.g_image.tools;

import javax.swing.ImageIcon;

/**
* Les images doivent se trouver dans un jar, et le jar dans le classpth!
* Le jar doit contenir le folder ressources. A l'interieur du folder ressource doit se trouver les images aux formats (jpg, voir mieux png pour la transparance)
*/
public class MagasinImage
	{

	/*------------------------------------------------------------------*\
	|*		 Version Synchrone (bloquant)								*|
	\*------------------------------------------------------------------*/

	public static final ImageIcon LENA = ImageLoader.loadSynchroneJar("ressources/lena.png");
	public static final ImageIcon NB1 = ImageLoader.loadSynchroneJar("ressources/nb1.jpg");
	public static final ImageIcon NB2 = ImageLoader.loadSynchroneJar("ressources/nb2.jpg");
	public static final ImageIcon NB3 = ImageLoader.loadSynchroneJar("ressources/nb3.jpg");
	public static final ImageIcon TIGER = ImageLoader.loadSynchroneJar("ressources/tiger.jpg");
	public static final ImageIcon MOUNTAIN = ImageLoader.loadSynchroneJar("ressources/mountain.jpg");

	/*------------------------------------------------------------------*\
	|*		Version Assynchrone	(non bloquant)							*|
	\*------------------------------------------------------------------*/

	//
	//	public static final ImageIcon LENA = ImageLoader.loadAsynchroneJar("ressources/lena.png");
	//	public static final ImageIcon NB1 = ImageLoader.loadAsynchroneJar("ressources/nb1.jpg");
	//	public static final ImageIcon NB2 = ImageLoader.loadAsynchroneJar("ressources/nb2.jpg");
	//	public static final ImageIcon NB3 = ImageLoader.loadAsynchroneJar("ressources/nb3.jpg");
	//	public static final ImageIcon TIGER = ImageLoader.loadAsynchroneJar("ressources/tiger.jpg");
	//	public static final ImageIcon MOUNTAIN = ImageLoader.loadAsynchroneJar("ressources/mountain.jpg");

	}
