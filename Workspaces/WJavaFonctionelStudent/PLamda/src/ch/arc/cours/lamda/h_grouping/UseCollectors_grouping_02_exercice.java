
package ch.arc.cours.lamda.h_grouping;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ch.arc.cours.lamda.h_grouping.tools.CollectionTools;

public class UseCollectors_grouping_02_exercice
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
		System.out.println("collectors : groupingBy : exercice");

		exercice();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Contexte :	On s'intéresse au nombre de thread dans une stream parallel,
	 * 				On aimerait savoir quel thread s'occupe de travailler quel indice
	 *
	 * Output : 	Une map avec
	 * 					key = nameThread
	 * 					value = list des indices travailler par le thread
	 */
	private static void exercice()
		{
		int n = Runtime.getRuntime().availableProcessors() * 10;//Integer.MAX_VALUE;


		Function<Integer, String> nameThread = i -> Thread.currentThread().getName();

		// Indication 1 : stream range
		// Indication 2 : collect
		//
		// Problem : collect n'existe pas sur IntStream
		// Solution: convertir : IntStream to Stream<Integer> avec boxed()
		// Note : boxed est l'nverse de mapToInt
		// 			- boxed     :  IntStream       to   Stream<Integer>
		//			- mapToInt  :  Stream<Integer> to   IntStream
		Map<String, List<Integer>> mapNameIndice = IntStream.range(0, n).parallel().boxed().collect(Collectors.groupingBy(nameThread));

		CollectionTools.print("[groupingBy nameThread]", mapNameIndice);
		System.out.println("#processor =" + Runtime.getRuntime().availableProcessors());
		}

	}