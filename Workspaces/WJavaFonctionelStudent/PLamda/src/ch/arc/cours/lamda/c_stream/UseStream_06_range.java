
package ch.arc.cours.lamda.c_stream;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class UseStream_06_range
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
		System.out.println("IntStream range");

		boucleByStream();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void boucleByStream()
		{
		int n = 3;

		// code de base
			{
			for(int i = 0; i < n; i++)
				{
				System.out.println(i);
				}
			}

		// lamda dans variable
			{
			IntConsumer afficher = i -> System.out.println(i);
			IntStream.range(0, n).forEach(afficher);
			// [0,n[
			}

		// IntStream lamda reference methode
			{
			IntStream.range(0, n).forEach(System.out::println);
			}

		// lamda, stream infini
			{
			IntStream.iterate(0, i -> i++).limit(n).forEach(System.out::println);
			}

		}

	}
