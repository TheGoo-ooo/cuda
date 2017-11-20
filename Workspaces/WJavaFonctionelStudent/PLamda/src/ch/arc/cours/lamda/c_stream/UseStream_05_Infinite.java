
package ch.arc.cours.lamda.c_stream;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class UseStream_05_Infinite
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
		System.out.println("Stream Infinite");

		// stream infini
			{
			useInfinite();
			boucleByStream();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Apprentissage
	 *
	 * 		stream pour afficher les 10 premiers nombres paires
	 */
	private static void useInfinite()
		{
		int n = 10;

		// code de base
			{
			for(int i = 0; i < n; i = i + 2)
				{
				System.out.println(i);
				}
			}

		// stream : lamda dans variable, sans reference methode
			{
			UnaryOperator<Integer> op = i -> i + 2;
			Stream<Integer> stream = Stream.iterate(0, op);

			stream.limit(n / 2).forEach(i -> System.out.println(i));
			}

		// stream : reference methode, une seule ligne
			{
			Stream.iterate(0, x -> x+2).limit(n/2).forEach(System.out::println);
			}

		}

	/**
	 * Exercice:
	 *
	 * 		stream pour remplacer boucle
	 *
	 * 		rappel : stream.limite(n)
	 */
	private static void boucleByStream()
		{
		int n = 4;

		// code de base
			{
			for(int i = 0; i < n; i++)
				{
				System.out.println(i);
				}
			}

		// stream : lamda dans variable, sans reference methode
			{
			UnaryOperator<Integer> op = x -> x++;
			Stream.iterate(0, op).limit(n).forEach(System.out::println);

			}

		// stream : lamda dans variable, reference methode, une seule ligne
			{
			Stream.iterate(0, i -> i++).limit(n).forEach(System.out::println);
			}

		}

	}
