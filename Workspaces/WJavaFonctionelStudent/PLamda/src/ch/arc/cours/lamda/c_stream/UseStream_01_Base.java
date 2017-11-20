
package ch.arc.cours.lamda.c_stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Assert;

import ch.arc.cours.lamda.c_stream.tools.Personne;
import ch.arc.cours.lamda.c_stream.tools.PersonneTools;

public class UseStream_01_Base
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

		System.out.println("stream : interface fonctionel :  classique");

		usePredicate(n);
		useConsumer(n);
		usePredicateConsumer(n);

		useBinaryOperator();

		usePredicateBinaryOperator();
		useFunctionBinaryOperator(n);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Quoi : 	 	Filter
	 * Comment :	Predicate<T>
	 *
	 * Probleme :	nombre de personne dont l'age est > 50
	 */
	private static void usePredicate(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		System.out.println("Avant : " + list);

		// TODO
		Predicate<Personne> ageBigger50 = personne -> personne.getAge() > 50;

		long count = list.stream().filter(ageBigger50).count();
		// count : terminal, interdit employer stream apres

		System.out.println("age > 50 : " + count);
		}

	/**
	 * Quoi : 	 	forEach
	 * Comment :	Consumer<T>
	 *
	 * Probleme :	incrementer de 1 l'age des personnes
	 */
	private static void useConsumer(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		// lamda dans variable
			{
			Consumer<Personne> incAge = personne -> personne.incAge();

			list.stream().forEach(incAge);

			// forEach : terminal, interdit employer stream apres, sur place
			}

		// lamda reference methode
			{
			list.stream().forEach(Personne::incAge);

			// forEach : terminal, interdit employer stream apres,sur place
			}

		System.out.println("Apres : " + list);
		}

	/**
	 * Quoi : 	 	filter				forEach
	 * Comment :	Predicate<T>		Consumer<T>
	 *
	 * Probleme :	incrementer de 1 l'age des personnes > 50
	 */
	private static void usePredicateConsumer(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		// lamda dans variable, reference methode si possible
			{
			Predicate<Personne> ageBigger50 = personne -> personne.getAge() > 50;
			Consumer<Personne> incAge = personne -> personne.incAge();

			list.stream().filter(ageBigger50).forEach(incAge);

			// filter : non terminal stream-in, stream-out
			// forEach : terminal , sur place, interdit employer stream apres, sur place
			}

		System.out.println("Apres : " + list);
		}

	/**
	 * Quoi : 	 	reduce
	 * Comment :	BinaryOperator<T>
	 *
	 * Probleme :	somme des elements de la liste
	 */
	private static void useBinaryOperator()
		{
		List<Integer> list = Arrays.asList(1, 2, 3);

		// lamda
			{
			BinaryOperator<Integer> add = (x, y) -> x+y;
			Integer sum = list.stream().reduce(0, add);
			// reduce : terminal, interdit employer stream apres

			Assert.assertTrue(sum == 1 + 2 + 3);
			}

		// lamda, reference methode
			{
			Integer sum = list.stream().reduce(0, (x, y)->x+y);
			// reduce : terminal, interdit employer stream apres

			Assert.assertTrue(sum == 1 + 2 + 3);
			}
		}

	/**
	 * Quoi : 	 	filter			reduce
	 * Comment :	Predicate<T> 	BinaryOperator<T>
	 *
	 * Probleme :	somme des elements paires de la liste
	 */
	private static void usePredicateBinaryOperator()
		{
		List<Integer> list = Arrays.asList(1, 2, 3, 4);

		// TODO
		Predicate<Integer> ispaire = i -> i%2 == 0;

		// lamda,reference methode
			{

			Integer sum = list.stream().filter(ispaire).reduce(0, (x,y)->x+y);
			// filter : non terminal stream-in, stream-out
			// reduce : terminal, interdit employer stream apres

			Assert.assertTrue(sum == 2 + 4);
			}
		}

	/**
	 * Quoi : 	 	map					reduce
	 * Comment :	Function<T1,T2> 	BinaryOperator<T>
	 *
	 * Probleme :	somme des ages
	 */
	private static void useFunctionBinaryOperator(int n)
		{
		List<Personne> list = PersonneTools.create(n);

		Function<Personne, Integer> age = Personne::getAge;
		Integer sum = list.stream().map(age).reduce(0, Integer::sum);
		// map    : non terminal, stream-in, stream-out
		// reduce : terminal, interdit employer stream apres

		System.out.println("somme des ages = " + sum);

		// see next chapter : mapToInt!
		}


	}
