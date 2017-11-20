
package ch.arc.cours.lamda.h_grouping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ch.arc.cours.lamda.h_grouping.tools.CollectionTools;
import ch.arc.cours.lamda.h_grouping.tools.VoyageurTools;
import ch.arc.cours.material.Voyageur;

public class UseCollectors_grouping_01_example
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
		System.out.println("collectors : groupingBy : example");

		// groupingBy
			{
			useCollectToMap1();
			useCollectToMap2();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		grouping				*|
	\*------------------------------*/

	/**
	 * Probleme   :	regrouper les voyageurs par ville
	 *
	 * Contrainte : output dans Map avec:
	 * 						- key   = Ville
	 *                      - value = List voyageur
	 */
	private static void useCollectToMap1()
		{
		Voyageur[] tabVoyageur = VoyageurTools.create();

		CollectionTools.println("data input", tabVoyageur);

		// code standard :  groupingBy city
			{
			Map<String, List<Voyageur>> mapCityVoyageur = new HashMap<String, List<Voyageur>>();

			for(Voyageur voyageur:tabVoyageur)
				{
				String city = voyageur.getCity();

				if (!mapCityVoyageur.containsKey(city))
					{
					mapCityVoyageur.put(city, new LinkedList<Voyageur>());
					}

				mapCityVoyageur.get(city).add(voyageur);
				}

			// check
			CollectionTools.println("[groupingBy city] : standard", mapCityVoyageur);
			}

		// stream Collectors : groupingBy city
			{
			Function<Voyageur, String> city = Voyageur::getCity; // classifieur de regroupement

			Map<String, List<Voyageur>> mapCityVoyageur = Arrays.stream(tabVoyageur).collect(Collectors.groupingBy(city));

			// check
			CollectionTools.println("[groupingBy city] : stream", mapCityVoyageur);
			}

		}

	/**
	 * Probleme   :	Nombre de Voyageur par ville
	 *
	 * Contrainte : output dans Map avec:
	 * 						- key= ville
	 *                      - value= nombre de voyageur dans cette ville
	 */
	private static void useCollectToMap2()
		{
		Voyageur[] tabVoyageur = VoyageurTools.create();

		CollectionTools.println("data input", tabVoyageur);

		// code standard :
			{
			Map<String, AtomicInteger> mapCityVoyageurCount = new HashMap<String, AtomicInteger>();

			for(Voyageur voyageur:tabVoyageur)
				{
				String city = voyageur.getCity();

				if (!mapCityVoyageurCount.containsKey(city))
					{
					mapCityVoyageurCount.put(city, new AtomicInteger(0));
					}

				AtomicInteger compteur = mapCityVoyageurCount.get(city); // recuperation de la value depuis la key
				compteur.incrementAndGet(); // AtomicInteger est alterable, Integer ne l'était pas!
				}

			// check
			CollectionTools.print("[groupingBy City et VoyageurCount] : standard", mapCityVoyageurCount);
			}

		// code stream : lamda dans variable
			{
			Function<Voyageur, String> city = Voyageur::getCity; // classifier
			Collector<Voyageur, ?, Long> countVoyageur = Collectors.counting();// downstream

			Map<String, Long> mapCityVoyageurCount = Arrays.stream(tabVoyageur).collect(Collectors.groupingBy(city, countVoyageur));

			// check
			CollectionTools.print("[groupingBy City et VoyageurCount] : stream", mapCityVoyageurCount);
			}

		// code stream : sans variable
			{
			Map<String, Long> mapCityVoyageurCount = Arrays.stream(tabVoyageur).collect(Collectors.groupingBy(Voyageur::getCity, Collectors.counting()));

			// check
			CollectionTools.print("[groupingBy City et VoyageurCount] : stream", mapCityVoyageurCount);
			}

		}

	}
