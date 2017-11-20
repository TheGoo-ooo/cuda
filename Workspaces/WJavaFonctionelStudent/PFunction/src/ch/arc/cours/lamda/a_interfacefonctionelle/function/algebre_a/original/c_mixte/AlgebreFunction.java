
package ch.arc.cours.lamda.a_interfacefonctionelle.function.algebre_a.original.c_mixte;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AlgebreFunction
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * use methode private op ci-dessous
	 */
	public static Function<Double, Double> add(Function<Double, Double> h, Function<Double, Double> g)
		{
		// lamda dans variable
			{
			// TODO
			}

		// lamda
			{
			// TODO
			return null;
			}
		}

	/**
	 * use methode private op ci-dessous
	 */
	public static Function<Double, Double> prod(Function<Double, Double> h, Function<Double, Double> g)
		{
		// lamda dans variable
			{
			// TODO
			}

		// lamda
			{
			// TODO
			return null;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*		Function<T1,T2>			*|
	|*		BiFunction<T1,T2,T3>	*|
	\*------------------------------*/

	/**
	 * f= h op g
	 * f(x) = h(x) op g(x)
	 *
	 * examples:
	 * 		op = +
	 * 		op = *
	 */
	private static <T1, T2> Function<T1, T2> op(Function<T1, T2> h, Function<T1, T2> g, BiFunction<T2, T2, T2> op)
		{
		// lamda
			{
			// TODO
			return null;
			}
		}

	}
