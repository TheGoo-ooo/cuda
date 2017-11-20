
package ch.arc.cours.lamda.f_sequential_to_parralel;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ch.arc.cours.lamda.f_sequential_to_parralel.tools.Worker;

public class UseSequentialToParallel_01_container
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
		System.out.println("sequentiel to parallel");

		//sequentialToParralel1();
		sequentialToParralel2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void sequentialToParralel1()
		{
		int n = 10;

		// sequentiel : code standad
			{
			System.out.println("sequentiel");

			for(int i = 0; i < n; i++)
				{
				Worker.work(i);
				}
			}

		// parallel : stream infinite
			{
			System.out.println("\nparallel 1");

			Stream.iterate(0, i -> i + 1).limit(n).parallel().forEach(Worker::work);
			}

		// parallel : IntStream range
			{
			System.out.println("\nparallel 2");

			IntStream.range(0, n).parallel().forEach(Worker::work);
			// range [0,n[
			}
		}

	private static void sequentialToParralel2()
		{
		int n = 5;

		// sequentiel : code standad
			{
			System.out.println("sequentiel");

			double[] tab = new double[n];

			for(int i = 0; i < n; i++)
				{
				tab[i] = Math.PI;
				}

			System.out.println(Arrays.toString(tab));
			}

		// parallel : stream infinite
			{
			System.out.println("\nparallel 1");

			double[] tab = new double[n];

			Stream.iterate(0,  i-> i+1).limit(n).parallel().forEach(i -> tab[i] = Math.PI);
			// Indication : Stream
			// Indication : iterate
			// Indication : foreach

			System.out.println(Arrays.toString(tab));
			}

		// parallel : IntStream range
			{
			System.out.println("\nparallel 2");

			double[] tab = new double[n];

			IntStream.range(0, n).parallel().forEach(i -> tab[i] = Math.PI);
			// Indication : IntStream
			// Indication : range [0,n[
			// Indication : foreach

			System.out.println(Arrays.toString(tab));
			}

		// parallel : IntStream range
			{
			System.out.println("\nparallel 3");

			// Indication : mapToDouble
			// Indication : toArray
			double[] tab = IntStream.range(0, n).parallel().mapToDouble(x -> Math.PI).toArray();

			System.out.println(Arrays.toString(tab));
			}

		}

	}
