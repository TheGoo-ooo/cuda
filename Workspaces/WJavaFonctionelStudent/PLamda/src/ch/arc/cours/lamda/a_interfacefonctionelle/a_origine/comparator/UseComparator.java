
package ch.arc.cours.lamda.a_interfacefonctionelle.a_origine.comparator;

import java.util.Arrays;
import java.util.Comparator;

import ch.arc.cours.lamda.a_interfacefonctionelle.a_origine.comparator.tools.Banane;
import ch.arc.cours.lamda.a_interfacefonctionelle.a_origine.comparator.tools.BananeTools;

public class UseComparator
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
		int n = 5;

		version1(n);
		version2(n);
		version3(n);

		// Version lamda
			{
			version4(n);
			version4Bis(n);
			version5(n);
			version5Bis(n);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void version1(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Comparator<Banane> comparator = new ComparatorSeparer();

		BananeTools.print("Before", tab);

		Arrays.sort(tab, comparator); // sur place

		BananeTools.print("After", tab);
		}

	private static void version2(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Comparator<Banane> comparator = new Comparator<Banane>()
			{

			@Override
			public int compare(Banane b1, Banane b2)
				{
				return Integer.compare(b1.getPoids(), b2.getPoids());
				}
			};

		Arrays.sort(tab, comparator); // sur place

		BananeTools.print("After", tab);
		}

	private static void version3(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Arrays.sort(tab, new Comparator<Banane>()
			{

			@Override
			public int compare(Banane b1, Banane b2)
				{
				return Integer.compare(b1.getPoids(), b2.getPoids());
				}
			}); // sur place

		BananeTools.print("After", tab);
		}

	/*------------------------------*\
	|*		Version lamda			*|
	\*------------------------------*/

	/**
	 * lamda avec typage
	 * lamda dans variable
	 */
	private static void version4(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Comparator<Banane> comparator = (Banane b1, Banane b2) -> { return Integer.compare(b1.getPoids(), b2.getPoids());};// return => {} et ; obligatoire
		//Comparator<Banane> comparator = (Banane b1, Banane b2) -> Integer.compare(b1.getPoids(), b2.getPoids()); 			// return facultatif, remove {}

		Arrays.sort(tab, comparator);// sur place

		BananeTools.print("After", tab);
		}

	/**
	 * lamda avec typage
	 */
	private static void version4Bis(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		Arrays.sort(tab, (Banane b1, Banane b2) -> {return Integer.compare(b1.getPoids(), b2.getPoids());}); 	// return => {} et ; obligatoire
		//Arrays.sort(tab, (Banane b1, Banane b2) -> Integer.compare(b1.getPoids(), b2.getPoids()));			 // return facultatif, remove {}

		BananeTools.print("After", tab);
		}

	/**
	 * lamda sans typage
	 * lamda dans variable
	 */
	private static void version5(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		//Comparator<Banane> comparator = (b1, b2) -> {return Integer.compare(b1.getPoids(), b2.getPoids());};
		Comparator<Banane> comparator = (b1, b2) -> Integer.compare(b1.getPoids(), b2.getPoids()); // return facultatif, remove {}

		Arrays.sort(tab, comparator); // sur place

		BananeTools.print("After", tab);
		}

	/**
	 * lamda sans typage
	 */
	private static void version5Bis(int n)
		{
		Banane[] tab = BananeTools.createTab(n);

		//Arrays.sort(tab, (b1, b2) -> {return Integer.compare(b1.getPoids(), b2.getPoids());}); // sur place
		Arrays.sort(tab, (b1, b2) -> Integer.compare(b1.getPoids(), b2.getPoids())); // sur place

		BananeTools.print("After", tab);
		}

	}
