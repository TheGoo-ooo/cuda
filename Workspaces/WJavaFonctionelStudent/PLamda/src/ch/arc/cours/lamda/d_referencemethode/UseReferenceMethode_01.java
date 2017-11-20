
package ch.arc.cours.lamda.d_referencemethode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import org.junit.Assert;

import ch.arc.cours.material.Joueur;
import ch.arc.cours.material.Maison;

public class UseReferenceMethode_01
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
		System.out.println("lamda : reference methode");

		// static
			{
			methodeStaticMath();
			methodeStaticInteger();
			}

		// non static
			{
			methodeNonStaticMaison();
			sort();
			}

		// constructeur
			{
			constructeurInteger();
			constructeurJoueur();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Static			*|
	\*------------------------------*/

	private static void methodeStaticMath()
		{
		// classe interne anonyme
			{
			Function<Double, Double> f = new Function<Double, Double>()
				{

				@Override
				public Double apply(Double t)
					{
					return Math.abs(t);
					}
				};

			Assert.assertTrue(f.apply(-1d) == 1);
			}

		// lamda reference
			{
			// TODO
			Function<Double, Double> f = x -> Math.abs(x);

			Assert.assertTrue(f.apply(-1d) == 1);
			}

		// lamda reference methode
			{
			// TODO
			Function<Double, Double> f = null;

			Assert.assertTrue(f.apply(-1d) == 1);
			}
		}

	/**
	 * sum des nombres paires
	 */
	private static void methodeStaticInteger()
		{
		// lamda
			{
			Integer[] tab = { 1, 2, 3, 4, 5, 6, 7, 8 };

			// TODO
			Integer sumPaire = Arrays.stream(tab).filter(x -> x%2 == 0).mapToInt(Integer::valueOf).sum();

			Assert.assertTrue(sumPaire == 2 + 4 + 6 + 8);
			}

		// lamda reference methode:
		//		isPaire
		//		add
			{
			Integer[] tab = { 1, 2, 3, 4, 5, 6, 7, 8 };


			Integer sumPaire = Arrays.stream(tab).filter(x -> x%2 == 0).reduce(0, Integer::sum);

			Assert.assertTrue(sumPaire == 2 + 4 + 6 + 8);
			}
		}

	/*------------------------------*\
	|*			non	Static			*|
	\*------------------------------*/

	/**
	 * sum des prix des maisons
	 */
	private static void methodeNonStaticMaison()
		{

		// lamda
			{
			Maison[] tab = { new Maison(1, 10, 100), new Maison(2, 20, 200) }; // prix piece surface

			Integer prixTotal = Arrays.stream(tab).mapToInt(Maison::getPrix).sum();

			Assert.assertTrue(prixTotal == 3);
			}

		// lamda reference methode (prix)
			{
			Maison[] tab = { new Maison(1, 10, 100), new Maison(2, 20, 200) }; // prix piece surface

			Integer prixTotal = null;

			//Assert.assertTrue(prixTotal == 3);
			}
		}

	/**
	 * tri d'un tableau de string
	 */
	private static void sort()
		{
		// sans stream
			{
			// classe interne anonyme
				{
				String[] tab = { "maison", "banane", "Meteo", "repas" };

				System.out.println("avant : " + Arrays.asList(tab));

				Comparator<String> comparator = new Comparator<String>()
					{

					@Override
					public int compare(String s1, String s2)
						{
						return s1.compareToIgnoreCase(s2);
						}
					};
				Arrays.sort(tab, comparator); // sur place

				System.out.println("après : " + Arrays.toString(tab));
				}

			// lamda
				{
				String[] tab = { "maison", "banane", "Meteo", "repas" };

				Arrays.parallelSort(tab, (a, b) -> a.compareToIgnoreCase(b));

				System.out.println("après : " + Arrays.toString(tab));
				}

			// lamda  sans stream,  tri parallel, reference methode
				{
				String[] tab = { "maison", "banane", "Meteo", "repas" };

				Arrays.parallelSort(tab, String::compareToIgnoreCase);
				System.out.println("après : " + Arrays.toString(tab));
				}

			}

		// avec stream,  tri parallel, reference methode
			{
			String[] tab = { "maison", "banane", "Meteo", "repas" };

			Arrays.stream(tab).parallel().sorted(String::compareToIgnoreCase);

			System.out.println("après : " + Arrays.toString(tab));
			}
		}

	/*------------------------------*\
	|*				Constructeur	*|
	\*------------------------------*/

	/**
	 * Construire une liste de nombres depuis un tableau de string
	 *
	 * Indication : map collect Collectors
	 */
	private static void constructeurInteger()
		{
		String[] tabString = { "1", "2", "3", "4" };

		// list
			{
			// lamda
				{
				try
					{

					List<Integer> list = Arrays.stream(tabString).map(s -> new Integer(s)).collect(Collectors.toList());

					System.out.println(list);
					}
				catch (Exception e)
					{
					System.out.println("impossible");
					}
				}

			// lamda , reference methode
				{
				try
					{

					List<Integer> list = Arrays.stream(tabString).map(Integer::new).collect(Collectors.toList());

					System.out.println(list);
					}
				catch (Exception e)
					{
					System.out.println("impossible");
					}
				}
			}

		// array
			{
			// lamda, avec variable
				{
				try
					{
					// TODO
					// Indication globale :
					//		step 1 : map
					// 		step 2 : toArray
					// Indication generator :
					//		generator input  : n la taille du tableau
					//		generator output : un tableau de n joueur
					IntFunction<Integer[]> generatorArray = null;
					Function<String, Integer> stringToInteger = null;

					Integer[] tabInteger = null;

					System.out.println(Arrays.toString(tabInteger));
					}
				catch (Exception e)
					{
					System.out.println("impossible");
					}
				}

			// reference methode, avec variable
				{
				try
					{
					IntFunction<Integer[]> generatorArray = n -> new Integer[n];
					Function<String, Integer> stringToInteger = Integer::new;

					Integer[] tabInteger = Arrays.stream(tabString).map(stringToInteger).toArray(generatorArray);

					System.out.println(Arrays.toString(tabInteger));
					}
				catch (Exception e)
					{
					System.out.println("impossible");
					}
				}

			// reference methode, sans variable
				{
				try
					{
					Integer[] tabInteger = Arrays.stream(tabString).map(Integer::new).toArray(Integer[]::new);

					System.out.println(Arrays.toString(tabInteger));
					}
				catch (Exception e)
					{
					System.out.println("impossible");
					}
				}
			}
		}

	/**
	 * Construire une liste de joueur depuis un tableau de nom
	 *
	 * Indication : map collect Collectors
	 */
	private static void constructeurJoueur()
		{
		String[] tabName = { "bob", "marc", "alice", "claire" };

		// list
			{

			// lamda, sans variable
				{
				// TODO
				List<Joueur> listJoueur = null;

				incrementerGain(listJoueur, 99);
				System.out.println(listJoueur);
				}

			// reference methode, sans variable
				{
				// TODO
				List<Joueur> listJoueur = null;

				incrementerGain(listJoueur, 99);
				System.out.println(listJoueur);
				}
			}

		// array
			{
			// lamda, avec variable
				{
				// TODO
				// Indication globale :
				//		step 1 : map
				// 		step 2 : toArray
				// Indication generator :
				//		generator input  : n la taille du tableau
				//		generator output : un tableau de n joueur
				IntFunction<Joueur[]> generatorArray = null;
				Function<String, Joueur> nameToJoueur = null;

				Joueur[] tabJoueur = null;

				incrementerGain(Arrays.asList(tabJoueur), 99);
				System.out.println(Arrays.toString(tabJoueur));
				}

			// reference methode, avec variable
				{
				// TODO
				IntFunction<Joueur[]> generatorArray = null;
				Function<String, Joueur> nameToJoueur = null;

				Joueur[] tabJoueur = null;

				incrementerGain(Arrays.asList(tabJoueur), 99);
				System.out.println(Arrays.toString(tabJoueur));
				}

			// reference methode, sans variable
				{
				// TODO
				Joueur[] tabJoueur = null;

				incrementerGain(Arrays.asList(tabJoueur), 99);
				System.out.println(Arrays.toString(tabJoueur));
				}
			}

		}

	private static void incrementerGain(Iterable<Joueur> iterableJoueur, int gain)
		{
		// avec stream, en parallel
			{
			// TODO,
			// indication : see chapter c_stream, next sub chapter iterable
			}
		}

	}
