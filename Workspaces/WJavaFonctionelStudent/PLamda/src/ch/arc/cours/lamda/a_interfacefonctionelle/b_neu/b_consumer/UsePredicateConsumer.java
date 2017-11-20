
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.b_consumer;

import java.util.function.Consumer;
import java.util.function.Predicate;

import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.a_predicate.tools.Homme;
import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.a_predicate.tools.HommeTools;

public class UsePredicateConsumer
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
		System.out.println("foreach & filter: Consumer & Predicate");

		foreachFilter();
		}

	private static void foreachFilter()
		{
		int n = 5;

		version1(n);

		// lamda
			{
			version2(n);
			version3(n);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*	Predicate<T> & Consumer<T>	*|
	\*------------------------------*/

	/**
	 * Opposer le poids de l'homme, dont la hauteur est > 20
	 *
	 * Classe interne anonyme dans variable
	 */
	private static void version1(int n)
		{
		Iterable<Homme> iterable = HommeTools.create(n);

		System.out.println("Before  : " + iterable + "\n");

		Predicate<Homme> predicate = new Predicate<Homme>()
			{

				@Override
				public boolean test(Homme homme)
					{
					return homme.getHauteur() >20;
					}

			};
		/*Consumer<Homme> consumer = new Consumer<Homme>()
			{

				@Override
				public void accept(Homme homme)
					{
					// TODO Auto-generated method stub

					}};*/

		System.out.println("After 1 : " + iterable);
		}

	/**
	 * Opposer le poids de l'homme, dont la hauteur est > 20
	 *
	 * lamda dans variable
	 */
	private static void version2(int n)
		{
		Iterable<Homme> iterable = HommeTools.create(n);

		Predicate<Homme> predicate = homme -> homme.getHauteur() > 20;
		Consumer<Homme> consumer = homme -> homme.opposePoids();

		HommeManipulator.filterForeach(iterable, predicate, consumer);

		System.out.println("After 2 : " + iterable);
		}

	/**
	 * Opposer le poids de l'homme, dont la hauteur est > 20
	 *
	 * lamda
	 */
	private static void version3(int n)
		{
		Iterable<Homme> iterable = HommeTools.create(n);

		HommeManipulator.filterForeach(iterable, homme -> homme.getHauteur() >20, homme -> homme.opposePoids());

		System.out.println("After 3 : " + iterable);
		System.out.println(iterable);
		}

	}
