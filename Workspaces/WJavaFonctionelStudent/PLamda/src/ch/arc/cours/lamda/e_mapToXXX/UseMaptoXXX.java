
package ch.arc.cours.lamda.e_mapToXXX;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * map : 	  extraction
 *
 * mapToXXX : fabrication de XXX
 *
 * mapToInt : IntStream bine plus pratique que Stream<Integer>
 */
public class UseMaptoXXX
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
		System.out.println("lamda : mapToXXX");

		mapToInt();
		mapToObj();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				mapToInt		*|
	\*------------------------------*/

	/**
	 * Quoi : 	 	mapToInt			toArray
	 * Comment :	Function<T1,T2>
	 *
	 * Probleme :	Convertion d'une liste en tableau
	 */
	private static void mapToInt()
		{
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		int[] tab = list.parallelStream().mapToInt(x -> x).toArray();

		System.out.println(Arrays.toString(tab));
		}

	/*------------------------------*\
	|*				mapToObj		*|
	\*------------------------------*/

	/**
	 * Question 1: 	Combien de thread utilisé dans un stream parallel?
	 * Question 2: 	Afficher le nom de ces threads
	 *
	 * Indications:
	 *
	 * 				Step 1 : stream parallel de [0,Integer.MAX_VALUE[
	 * 				Step 2 : Recupérer nom des threads (mapToObj)
	 * 				Step 3 : Les collecter dans un set,
	 * 				Step 4: Regarder la taille du set
	 *
	 * 				mapToObj
	 * 					 - sert à fabriquer le nom des threads
	 * 					 - requiert IntFunction<T>
	 */
	private static void mapToObj()
		{
		int n = Integer.MAX_VALUE;

		IntFunction<String> nameThread = i -> Thread.currentThread().getName();
		Set<String> setThreadName = IntStream.range(0, Integer.MAX_VALUE).parallel().mapToObj(nameThread).collect(Collectors.toSet());
		// [0,n[

		// Afficher namethread, un seul par ligne
		setThreadName.forEach(System.out::println);

		System.out.println("#Thread    = " + setThreadName.size());
		System.out.println("#processor = " + Runtime.getRuntime().availableProcessors());
		}

	}
