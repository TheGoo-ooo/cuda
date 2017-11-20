
package ch.arc.cours.lamda.d_referencemethode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;

import javax.swing.JButton;

import ch.arc.cours.lamda.d_referencemethode.tools.JFrameBouton;

public class UseReferenceMethode
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
		System.out.println("lamda : reference methode");

		// methode
			{
			referenceMethode();
			}

		// constructeur
			{
			referenceConstructeurCollection();
			referenceConstructeurArray();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * click dans un JButton (swing), afficher l'event
	 */
	private static void referenceMethode()
		{
		// Classe interne anonyme
			{
			JButton button = new JButton("click");

			button.addActionListener(new ActionListener()
				{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					System.out.println(e);
					}
				});

			new JFrameBouton(button, "click classe interne anonyme");
			}

		// lamda
			{
			JButton button = new JButton("click");

			// TODO

			new JFrameBouton(button, "click lamda");
			}

		// lamda reference methode
			{
			JButton button = new JButton("click");

			// TODO

			new JFrameBouton(button, "click lamda reference methode");
			}

		}

	/**
	 * Construire une liste de bouttons depuis un tableau de string
	 * Construire un set de bouttons depuis un tableau de string
	 *
	 * Indication : map collect Collectors
	 */
	private static void referenceConstructeurCollection()
		{
		// lamda, sans reference constructeur
			{
			String[] tabLabel = { "b1", "b2", "b3", "b4" };

			// list
				{
				// TODO
				List<JButton> list = null;

				new JFrameBouton(list, "list : lamda");
				}
			}

		// lamda, reference constructeur
			{
			String[] tabLabel = { "b1", "b2", "b3", "b4" };

			// list
				{
				// TODO
				List<JButton> list = null;

				new JFrameBouton(list, "list : lamda : constructeur reference");
				}

			// set
				{
				// TODO
				Set<JButton> set = null;

				new JFrameBouton(set, "set : lamda : constructeur reference");
				}

			// array (difficile)
				{
				// voir example ci-dessous, complexe!
				}

			}
		}

	/**
	 * Construire une array de bouttons depuis un tableau de string
	 *
	 * Indication : toArray
	 */
	private static void referenceConstructeurArray()
		{
		String[] tabLabel = { "b1", "b2", "b3", "b4" };

		// lamda dans variable, sans reference de methode pour generator
			{
			// on recoit un int, on doit fabriquer un tableau de JButton
			// Indication:
			//		generator input  : taille du tableau
			//		generator output : tableau de taille n
			IntFunction<JButton[]> generator = null;
			JButton[] tab = null;

			new JFrameBouton(tab, "toArray : lamda : constructeur reference 1");
			}

		// idem ci-dessus, mais generator dans reference methode
			{
			// TODO
			IntFunction<JButton[]> generator = null;
			JButton[] tab = null;

			new JFrameBouton(tab, "toArray : lamda : constructeur reference 1");
			}

		// lamda sans variable, avec reference de methode
			{
			// TODO
			JButton[] tab = null;

			new JFrameBouton(tab, "toArray : lamda : constructeur reference 3");
			}
		}

	}
