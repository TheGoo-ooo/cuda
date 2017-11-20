
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.a_predicate;

import java.util.function.Predicate;

import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.a_predicate.tools.Homme;
import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.a_predicate.tools.HommeTools;

public class UsePredicate
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
		System.out.println("filter : Predicate");

		filter();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void filter()
		{
		int n = 10;

		version1(n);

		// lamda
			{
			version2(n);
			version3(n);
			}
		}

	/*------------------------------*\
	|*			Predicate<T>		*|
	\*------------------------------*/

	/**
	 * homme dont hauteur > 20
	 *
	 * classe interne anonyme
	 * use HommeManipulator
	 */
	private static void version1(int n)
		{
		Iterable<Homme> iterable = HommeTools.create(n);

		System.out.println("Before  : "+iterable);

		Predicate<Homme> predicate = new Predicate<Homme>()
					{

						@Override
						public boolean test(Homme t)
							{
							if(t.getHauteur()>20) {
								return true;
								}
							return false;
							}

					};

		Iterable<Homme> iterableFiltrer = HommeManipulator.filter(iterable,  predicate);

		System.out.println("After 1 : "+iterableFiltrer);
		}

	/**
	 * homme dont hauteur > 20
	 *
	 * lamda dans variable
	 */
	private static void version2(int n)
		{
		Iterable<Homme> iterable = HommeTools.create(n);

		// DONE

		Predicate<Homme> predicate = homme -> homme.getHauteur()>20;

		Iterable<Homme> iterableFiltrer = HommeManipulator.filter(iterable, predicate);


		System.out.println("After 2 : "+iterableFiltrer);
		}

	/**
	 * homme dont hauteur > 20
	 *
	 * lamda
	 */
	private static void version3(int n)
		{
		Iterable<Homme> iterable = HommeTools.create(n);

		// DONE
		Iterable<Homme> iterableFiltrer =
				HommeManipulator.filter(iterable, homme -> homme.getHauteur()>20);


		System.out.println("After 3 : "+iterableFiltrer);
		}

	}
