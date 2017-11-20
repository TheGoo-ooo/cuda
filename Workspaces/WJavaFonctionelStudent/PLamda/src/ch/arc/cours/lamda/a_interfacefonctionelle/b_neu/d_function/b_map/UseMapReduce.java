
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.b_map;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import org.junit.Assert;

import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.b_map.tools.Maison;
import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.b_map.tools.MaisonTools;

public class UseMapReduce
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
		System.out.println("map reduce : Function binaryOperator ");

		mapReduce();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void mapReduce()
		{
		int n = 3;
		List<Maison> list = MaisonTools.create(n);

		int sum1 = version1(list);
		int sum2 = version2(list);
		int sum3 = version3(list);
		int sum4 = version4(list);

		// check
			{
			System.out.println(list);

			check(list, sum1);
			check(list, sum2);
			check(list, sum3);
			check(list, sum4);
			}
		}

	/*-------------------------------------*\
	|*	Function<T1,T2>  BinaryOperator<T> *|
	\*-------------------------------------*/

	/**
	 * somme des prix des maisons
	 *
	 * Classe Interne anonyme
	 */
	private static int version1(List<Maison> list)
		{
		Function<Maison, Integer> function = new Function<Maison, Integer>()
			{

			@Override
			public Integer apply(Maison maison)
				{
				return maison.getPrix();
				}

			};
		BinaryOperator<Integer> operator = new BinaryOperator<Integer>()
			{

				@Override
				public Integer apply(Integer t, Integer u)
					{
					return t+u;
					}
			};
		return MaisonManipulator.mapReduce(list, function, operator, 0);
		}

	/*------------------------------*\
	|*				lamda			*|
	\*------------------------------*/

	/**
	 * somme des prix des maisons
	 *
	 * lamda dans variable
	 */
	private static int version2(List<Maison> list)
		{
		Function<Maison, Integer> function = (maison) -> maison.getPrix();
		BinaryOperator<Integer> operator = (x, y) -> x+y;
		return MaisonManipulator.mapReduce(list, function, operator, 0);
		}

	/**
	 * somme des prix des maisons
	 *
	 * lamda
	 */
	private static int version3(List<Maison> list)
		{
		return MaisonManipulator.mapReduce(list, maison -> maison.getPrix(), (x,y)->x+y, 0);
		}

	/**
	 * somme des prix des maisons
	 *
	 * lamda, reference methode pour :
	 * 		prix de Maison
	 * 		sum de Integer
	 */
	private static int version4(List<Maison> list)
		{
		return MaisonManipulator.mapReduce(list, Maison::getPrix, Integer::sum, 0);
		}

	/*------------------------------*\
	|*				Tools			*|
	\*------------------------------*/

	private static void check(List<Maison> list, int sum)
		{
		System.out.println("sum prix = " + sum);

		int n = list.size();
		Assert.assertTrue(sum == n * (n + 1) / 2);
		}

	}
