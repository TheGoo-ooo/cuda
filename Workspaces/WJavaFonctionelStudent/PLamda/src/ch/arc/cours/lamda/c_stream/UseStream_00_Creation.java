
package ch.arc.cours.lamda.c_stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Assert;

public class UseStream_00_Creation
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
		System.out.println("Stream : array list set concatenation");

		// obtenir un stream
		useList1();
		useList2();

		useArray1();

		useConcatenation1();

		// see too
		//	UseIterable
		//	UseInfinite (advanced)
		// 	UseParallel
		}



	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				List			*|
	\*------------------------------*/

	/**
	 * fabrication stream et count
	 */
	private static void useList1()
		{
		List<Integer> list = Arrays.asList(1, 2, 3);

		// v1 (avec variable explicite stream)
			{
			Stream<Integer> stream = list.stream();

			long count = stream.count();
			// count : terminal, impossible employer stream ensuite

			Assert.assertTrue(count == list.size());
			}

		// v2 (sans varaible explicite stream)
			{

			long count = list.stream().count();
			// count : terminal, impossible employer stream ensuite

			Assert.assertTrue(count == list.size());
			}
		}

	/**
	 * fabrication stream et count partielle
	 *
	 * Quoi: 		recuperation des parties des elements de la stream
	 * 				Donner le début : skip
	 * 				Donner le nombre d'élment à pendre en partant du stream coupé : limit
	 *
	 * Comment : 	skip, limit,count
	 */
	private static void useList2()
		{
		List<Integer> list = Arrays.asList(1, 2, 3,4,5,6);

		int skip = 3; // saute 3 elements
		int limit = 2; // puis garde 2 elements
		// => [4,5]

		// v1 : avec methode stream de list
			{
			long count=  list.stream().skip(skip).limit(limit).count();
			// skip  : non terminal, stream-in -> stream-out
			// limit : non terminal, stream-in -> stream-out
			// count : terminal, impossible employer stream ensuite

			Assert.assertTrue(count == limit);
			}
		}

	/*------------------------------*\
	|*				Array			*|
	\*------------------------------*/

	/**
	 * fabrication stream et count
	 */
	private static void useArray1()
		{
		Integer[] tab = { 1, 2, 3 };

		// v1 : avec methode stream de Arrays
			{
			long count = Arrays.stream(tab).count();
			// count : terminal, impossible employer stream ensuite

			Assert.assertTrue(count == tab.length);
			}
		}

	/*------------------------------*\
	|*				concat			*|
	\*------------------------------*/


	private static void useConcatenation1()
		{
		// Container
		Integer[] tab = { 1, 2, 3 };
		List<Integer> list=Arrays.asList(4,5,6);
		Set<Integer> set=new HashSet<Integer>(3);
		set.add(7);
		set.add(8);
		set.add(9);

		// Stream
		Stream<Integer> streamTab= Arrays.stream(tab);
		Stream<Integer> streamList= list.stream();
		Stream<Integer> streamSet= set.stream();

		// Concatenation
		Stream<Integer> streamAll=Stream.concat(streamTab, streamList);
		streamAll=Stream.concat(streamAll, streamSet);

		// Check
		Assert.assertTrue(streamAll.count() == tab.length+ list.size()+set.size());
		}

	}
