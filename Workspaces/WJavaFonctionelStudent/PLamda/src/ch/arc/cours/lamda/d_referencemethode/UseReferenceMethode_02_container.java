
package ch.arc.cours.lamda.d_referencemethode;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import org.junit.Assert;

import ch.arc.cours.material.Int;

public class UseReferenceMethode_02_container
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
		System.out.println("lamda : reference methode : container");

		// convertion, revision
			{
			arraytoList();
			listToArray();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		convertion 				*|
	\*------------------------------*/

	/**
	 * transformation d'un tableau en list, facile!
	 *
	 * Warning : deux versions:
	 *
	 * 			(V1)	Copie superficielle (objet partager)
	 * 			(V2)	Copie profonde (clone de tout)
	 */
	private static void arraytoList()
		{
		Int[] tab = { new Int(1), new Int(2), new Int(3) };

		System.out.println("array " + Arrays.toString(tab));

		// sans stream : Copie superficielle
			{
			List<Int> list = Arrays.asList(tab);

			System.out.println("list  " + list);
			Assert.assertTrue(isSuperficialCopy(list, tab));
			}

		// avec stream
			{
			// Copie superficielle
				{
				// Indication : collect
				List<Int> list = Arrays.stream(tab).collect(Collectors.toList());

				System.out.println("list  " + list);
				Assert.assertTrue(isSuperficialCopy(list, tab));
				}

			// Copie profonde
				{
				// Indication :
				//		step 1 : map
				//		step 2 : collect
				List<Int> list = Arrays.stream(tab).map(Int::new).collect(Collectors.toList());

				System.out.println("list  " + list);
				Assert.assertTrue(isDeapCopy(list, tab));
				}
			}

		}

	/**
	 * transformation d'une liste en tableau, plus difficile!
	 *
	 * Warning : deux versions:
	 *
	 * 			(V1)	Copie superficielle (objet partager)
	 * 			(V2)	Copie profonde (clone de tout)
	 */
	private static void listToArray()
		{
		List<Int> list = Arrays.asList(new Int(1), new Int(2), new Int(3));

		// sans stream
			{
			// v1 : Copie superficielle
				{
				Int[] tab = list.toArray(new Int[0]); // taille zero!

				System.out.println(Arrays.toString(tab));
				Assert.assertTrue(isSuperficialCopy(list, tab));
				}

			// v2 : Copie superficielle
				{
				Int[] tab = new Int[list.size()];
				list.toArray(tab);

				System.out.println(Arrays.toString(tab));
				Assert.assertTrue(isSuperficialCopy(list, tab));
				}
			}

		// avec stream
			{
			// V1 : copie superficielle
				{

				// lamda dans variable, sans reference de methode
					{
					// Indication :
					//		step 1: fabriquer generator
					//		step 2: toArray

					// generator :
					// 		input  : n la taille du tableau
					// 		output : un tableau d'Int de taille n
					IntFunction<Int[]> generator = n -> new Int[n];
					Int[] tab = list.stream().toArray(generator);

					System.out.println(Arrays.toString(tab));
					Assert.assertTrue(isSuperficialCopy(list, tab));
					}

				// lamda dans variable, avec reference de methode
					{
					IntFunction<Int[]> generator = Int[]::new;
					Int[] tab = list.stream().toArray(generator);

					System.out.println(Arrays.toString(tab));
					Assert.assertTrue(isSuperficialCopy(list, tab));
					}

				// lamda sans variable, avec reference de methode
					{
					Int[] tab = list.stream().toArray(Int[]::new);

					System.out.println(Arrays.toString(tab));
					Assert.assertTrue(isSuperficialCopy(list, tab));
					}
				}

			// V2 : copie profonde
				{
				// v2.1		lamda sans variable, sans reference methode
					{
					// Indication : comme ci-dessus, mais inserer un map qui force la copy dans le pipe de stream
					Int[] tab = list.stream().map(i -> new Int(i)).toArray(i -> new Int[i]);

					System.out.println(Arrays.toString(tab));
					Assert.assertTrue(isDeapCopy(list, tab));
					}

				// v2.2 	uniquememt reference methode
					{
					Int[] tab = list.parallelStream().map(Int::new).toArray(Int[]::new);

					System.out.println(Arrays.toString(tab));
					Assert.assertTrue(isDeapCopy(list, tab));
					}
				}
			}
		}

	/*------------------------------*\
	|*				tools			*|
	\*------------------------------*/

	/**
	 * Hyp : same size
	 * check hashCode pour voir si copie profonde ou superficielle
	 */
	private static boolean isDeapCopy(List<Int> list1, Int[] tab2)
		{
		Assert.assertTrue(list1.size() == tab2.length);
		//checkTypeCopy(list, tab);

		int i = 0;
		for(Int e1:list1)
			{
			Int e2 = tab2[i++];

			if (e1.hashCode() == e2.hashCode()) { return false; }
			}

		return true;
		}

	/**
	 * Hyp : same size
	 * check hashCode pour voir si copie profonde ou superficielle
	 */
	private static boolean isSuperficialCopy(List<Int> list1, Int[] tab2)
		{
		Assert.assertTrue(list1.size() == tab2.length);
		//checkTypeCopy(list, tab);

		int i = 0;
		for(Int e1:list1)
			{
			Int e2 = tab2[i++];

			if (e1.hashCode() != e2.hashCode()) { return false; }
			}

		return true;
		}

	/**
	 * Hyp : same size
	 * Affiche hashCode pour voir si copie profonde ou superficielle
	 */
	private static void checkTypeCopy(List<Int> list1, Int[] tab2)
		{
		Assert.assertTrue(list1.size() == tab2.length);
		int i = 0;
		for(Int e1:list1)
			{
			Int e2 = tab2[i++];

			System.out.println(e1.hashCode());
			System.out.println(e2.hashCode());
			System.out.println();
			}
		}

	}
