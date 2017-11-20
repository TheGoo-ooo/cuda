
package ch.arc.cours.lamda.f_sequential_to_parralel;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Assert;

public class UseSequentialToParallel_02_math
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
		System.out.println("sequentiel to parallel : Math");

		addVectoriel();
		dotProd();
		factoriel();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * addition vectorielle parallele
	 */
	private static void addVectoriel()
		{
		// Data
		int n = 5;

		Integer[] v1 = { 1, 2, 3, 4, 5 };
		Integer[] v2 = { 10, 20, 30, 40, 50 };

		Assert.assertTrue(v1.length == n && v2.length == n);

		// sequentiel : code standad
			{
			System.out.println("\nsequentiel");

			Integer[] sum = new Integer[n];
			for(int i = 0; i < n; i++)
				{
				sum[i] = v1[i] + v2[i];
				}

			System.out.println(Arrays.toString(sum));
			}

		// parallel : stream : v1
			{
			System.out.println("\nparallel v1");

			Integer[] tabSum = new Integer[n];

			// Indication 1 : range [0,n[
			// Indication 2 : foreach
			// Indication 3 : mettre resultat dans tabSum deja existant
			IntStream.range(0, n).forEach(i -> tabSum[i] = v1[i] + v2[i]);

			System.out.println(Arrays.toString(tabSum));
			}

		// parallel : stream : v2
			{
			System.out.println("\nparallel v2");

			//Integer[] tabSum = new Integer[n];

			// Indication 1 : range [0,n[
			// Indication 2 : mapToLong
			// Indication 3 : toArray

			long[] tabSum = IntStream.range(0, n).parallel().mapToLong(i -> v1[i] + v2[i]).toArray(); // tout sur cette ligne

			System.out.println(Arrays.toString(tabSum));
			}
		}

	/**
	 * produit scalaire parallele
	 */
	private static void dotProd()
		{
		// Data
		int n = 5;

		Integer[] v1 = { 1, 2, 3, 4, 5 };
		Integer[] v2 = { 10, 20, 30, 40, 50 };

		Assert.assertTrue(v1.length == n && v2.length == n);

		// sequentiel : code standad
			{
			System.out.println("\nsequentiel");

			long tabSum = 0;
			for(int i = 0; i < n; i++)
				{
				tabSum += v1[i] * v2[i];
				}

			System.out.println("produit scalaire = " + tabSum);
			}

		// parallel : stream
			{
			System.out.println("\nparallel");

			// TODO
			// Indication 1 : range [0,n[
			// Indication 2 : mapToLong
			// Indication 3 : sum
			long produitScalaire = IntStream.range(0, n).parallel().mapToLong(i -> v1[i] * v2[i]).sum(); // tout sure cette ligne

			System.out.println("produit scalaire = " + produitScalaire);
			}
		}

	/**
	 * Factorielle paralelle
	 */
	private static void factoriel()
		{
		int n = 4;

		// sequentiel : code standad
			{
			System.out.println("\nsequentiel");

			long facto = 1;
			for(int i = 1; i <= n; i++)
				{
				facto *= i;
				}

			System.out.println("facto= " + facto);
			Assert.assertTrue(facto == 1 * 2 * 3 * 4);
			}

		// parallel : stream
			{
			System.out.println("\nparallel");

			// Indication 1 : range [1,n+1[
			// Indication 2 : reduce
			long facto = IntStream.range(1, n+1).parallel().reduce(1, (x, y) -> x*y);

			System.out.println("facto= " + facto);
			Assert.assertTrue(facto == 1 * 2 * 3 * 4);
			}
		}

	}
