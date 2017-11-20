
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.a_math.original.c_mixte;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MixteTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * use op ci-dessous
	 */
	public static Function<Double, Double> add(Function<Double, Double> h, Function<Double, Double> g)
		{
		// lamda dans variable
			{
			BiFunction<Double, Double, Double> bifu = (t, u) -> t + u;
			Function<Double, Double> function = MixteTools.op(h, g, bifu);
			}

		// lamda
			{
			return MixteTools.op(h, g, (t, u) -> t + u);
			}
		}

	/**
	 * use op ci-dessous
	 */
	public static Function<Double, Double> prod(Function<Double, Double> h, Function<Double, Double> g)
		{
		// lamda dans variable
			{
			Function<Double, Double> function = MixteTools.op(h, g, (x, y) -> x * y);
			}

		// lamda
			{
			return MixteTools.op(h, g, (x, y) -> x * y);
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
			return t1 -> op.apply(h.apply(t1), g.apply(t1));
			}
		}

	}
