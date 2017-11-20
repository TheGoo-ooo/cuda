
package ch.arc.cours.lamda.c_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.Assert;

import ch.arc.cours.lamda.c_stream.tools.Personne;
import ch.arc.cours.lamda.c_stream.tools.PersonneTools;

public class UseStream_07_parallel
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

		System.out.println("stream : parallel");

		//		list(n);
		//		array();
		//		iterable(n);

		exercice();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				List			*|
	\*------------------------------*/

	/**
	 * Quoi : 	 	filter			mapToInt	sum
	 * Comment :	Predicate<T> 	age			sum
	 *
	 * Probleme :	somme des hauteur des personnes dont age > 50
	 * Contrainte : stream parallel
	 */
	private static void list(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		System.out.println(list);

		// lamda dans varibale, reference methode si possible
			{
			Predicate<Personne> ageBigger50 = personne -> personne.getAge() > 50;
			ToIntFunction<Personne> hauteur = Personne::getAge;

			int sumHauteur = list.parallelStream().filter(ageBigger50).mapToInt(hauteur).sum();

			System.out.println("sumHauteur avec age >50  : " + sumHauteur);
			}
		}

	/*------------------------------*\
	|*				Array			*|
	\*------------------------------*/

	/**
	 * Quoi : 	 	reduce
	 * Comment :	BinaryOperator
	 *
	 * Probleme :	somme entiers in [1,9]
	 * Contrainte : stream parallel
	 */
	private static void array()
		{
		Integer[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int sum = Arrays.stream(tab).parallel().reduce(0, Integer::sum);

		// check
			{
			int n = tab.length;
			int sumTrue = n * (n + 1) / 2;
			Assert.assertTrue(sum == sumTrue);
			}
		}

	/*------------------------------*\
	|*				Iterable		*|
	\*------------------------------*/

	/**
	 * Quoi : 	 	filter			mapToInt	sum
	 * Comment :	Predicate<T> 	age			sum
	 *
	 * Probleme :	somme des hauteur des personnes dont age > 50
	 */
	private static void iterable(int n)
		{
		List<Personne> list = PersonneTools.create(n);
		work(list);
		}

	private static void work(Iterable<Personne> iterable)
		{
		boolean isParallel = true;
		Stream<Personne> stream = StreamSupport.stream(iterable.spliterator(), isParallel);

		Assert.assertTrue(stream.isParallel() == isParallel);

		int sumHauteur = stream.filter(p -> p.getAge() > 50).mapToInt(Personne::getHauteur).sum();

		System.out.println("sumHauteur avec age >50  : " + sumHauteur);
		}

	/*------------------------------*\
	|*				exercice		*|
	\*------------------------------*/

	/**
	 * Question : 	Combien de thread utilisé dans un stream parallel?
	 *
	 * Indications :
	 *
	 * 				stream parallel de [1,Integer.MAX_VALUE],
	 * 				recupérer nom des threads,
	 * 				les collecter dans un set,
	 * 				regarder la taille du set
	 *
	 */
	private static void exercice()
		{
		int n = Integer.MAX_VALUE;

		IntFunction<String> nameThread = i -> Thread.currentThread().getName();
		Set<String> setThreadName = IntStream.range(0, n).parallel().mapToObj(nameThread).collect(Collectors.toSet());

		// Afficher name thread, un seul par ligne
		// Stream sequentiel, reference methode
		setThreadName.stream().forEach(System.out::println);

		System.out.println("#Thread    = " + setThreadName.size());
		System.out.println("#processor = " + Runtime.getRuntime().availableProcessors());
		}

	}
