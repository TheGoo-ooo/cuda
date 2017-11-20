
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.a_math.custom.compose;

import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.a_math.custom.Function_I;

public class FunctionCompose
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * (h 0 g)(x) = h(g(x))
	 *
	 * classe interne anonyme
	 */
	public static Function_I composition1(Function_I h, Function_I g)
		{
		Function_I function = new Function_I()
			{

			@Override
			public double value(double x)
				{
				return h.value(g.value(x));
				}
			};
		return function;
		}

	/**
	 * (h 0 g)(x) = h(g(x))
	 *
	 * lamda dans variable
	 */
	public static Function_I composition2(Function_I h, Function_I g)
		{
		Function_I function = x -> h.value(g.value(x));
		return function;
		}

	/**
	 * (h 0 g)(x) = h(g(x))
	 *
	 * lamda
	 */
	public static Function_I composition3(Function_I h, Function_I g)
		{
		return x -> h.value(g.value(x));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
