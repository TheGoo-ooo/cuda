
package ch.arc.cours.lamda.c_stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.ToIntFunction;

import ch.arc.cours.lamda.c_stream.tools.Personne;
import ch.arc.cours.lamda.c_stream.tools.PersonneTools;

public class UseStream_03_mapToInt
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

		System.out.println("stream : interface fonctionel : mapToInt");

		// reduce easy
			{
			useMaptoInt1(n);
			}

		// collect easy
			{
			useMaptoInt2(n);
			useMaptoInt3(n);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		reduction / easy		*|
	\*------------------------------*/

	/**
	 * Quoi : 	 	map					reduce
	 * Comment :	Function<T1,T2> 	sum
	 *
	 * Probleme :	somme des ages
	 * Probleme :	moyenne des hauteurs
	 */
	private static void useMaptoInt1(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		// lamda dans varibale, reference methode si possible
			{
			// TODO
			ToIntFunction<Personne> age = Personne::getAge;
			ToIntFunction<Personne> hauteur = Personne::getHauteur;

			Integer sumAge = list.parallelStream().mapToInt(age).sum();
			OptionalDouble averageHauteur = list.parallelStream().mapToInt(hauteur).average();
			IntSummaryStatistics statHauteur = list.parallelStream().mapToInt(hauteur).summaryStatistics();

			// sum, average, summaryStatistics : terminal

			System.out.println("somme des ages = " + sumAge);
			System.out.println("moyenne des hauteurs = " + averageHauteur.getAsDouble());
			System.out.println("stat = " + statHauteur);
			}

		// lamda, reference methode si possible
			{
			Integer sumAge = list.parallelStream().mapToInt(Personne::getAge).sum();
			OptionalDouble averageHauteur = list.parallelStream().mapToInt(Personne::getHauteur).average();
			IntSummaryStatistics statHauteur = list.parallelStream().mapToInt(Personne::getHauteur).summaryStatistics();

			// sum, average, summaryStatistics : terminal

			System.out.println("somme des ages = " + sumAge);
			System.out.println("moyenne des hauteurs = " + averageHauteur.getAsDouble());
			System.out.println("stat = " + statHauteur);
			}
		}

	/*------------------------------*\
	|*		collect	 / easy			*|
	\*------------------------------*/

	/**
	 * Quoi : 	 	mapToInt			toArray
	 * Comment :	Function<T1,T2>
	 *
	 * Probleme :	Convertion d'une liste en tableau
	 */
	private static void useMaptoInt2(int n)
		{
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int[] tab = list.parallelStream().mapToInt(i -> i).toArray();

		System.out.println(Arrays.toString(tab));
		}

	/**
	 * Quoi : 	 	mapToInt			toArray
	 * Comment :	Function<T1,T2>
	 *
	 * Probleme :	Convertion d'une tableau en tableau
	 */
	private static void useMaptoInt3(int n)
		{
		// object
			{
			Integer[] tabObject = { 1, 2, 3, 4, 5 };
			int[] tab = Arrays.asList(tabObject).parallelStream().mapToInt(x -> x).toArray();

			System.out.println(Arrays.toString(tab));
			}

		// type simple : copy tabSource, toArray immediatement !
			{
			int[] tabSource = { 1, 2, 3, 4, 5 };
			int[] tabCopy = Arrays.stream(tabSource).toArray();

			tabSource[0] = -1; // modifie pas tabsource

			System.out.println(Arrays.toString(tabCopy));
			}

		}

	}
