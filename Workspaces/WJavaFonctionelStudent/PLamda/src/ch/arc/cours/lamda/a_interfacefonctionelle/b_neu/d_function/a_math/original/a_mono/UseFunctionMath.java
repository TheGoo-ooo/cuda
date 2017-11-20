
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.a_math.original.a_mono;

import java.util.function.Function;

import org.junit.Assert;

public class UseFunctionMath
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
		System.out.println("math : Function");

		function();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void function()
		{
		apply();
		compose();
		andThen();

		methodeReference();
		}

	/*------------------------------*\
	|*		Function<T1,T2>			*|
	\*------------------------------*/

	/**
	 * h(x)= 2*x
	 * g(x)= x+1
	 *
	 * f(x) = h(x)+g(x)
	 */
	private static void apply()
		{
		//lamda dans variable
			{
			// TODO
			Function<Double, Double> h = x -> 2*x;
			Function<Double, Double> g = x -> x+1;

			// TODO apply, f define with h and g
			Function<Double, Double> f = x -> h.apply(x) + g.apply(x);

			Assert.assertTrue(f.apply(2d) == 7);
			}
		}

	/**
	 * h(x)= x+1
	 * g(x)= x*x
	 *
	 * f(x) = (x*x) + 1 = (g o h) (x)= h(g(x))
	 */
	private static void compose()
		{
		// lamda dans variable
			{
			// TODO
			Function<Double, Double> h = x -> x+1;
			Function<Double, Double> g = x -> x*x;

			// TODO compose, f define with h and g
			Function<Double, Double> f = x -> h.apply(g.apply(x));

			Assert.assertTrue(f.apply(2d) == 5);
			}
		}

	/**
	 * f(x) = 2(x+1)
	 */
	private static void andThen()
		{
		// lamda dans variable
			{
			// TODO
			Function<Double, Double> h = x -> 2 * x;
			Function<Double, Double> g = x -> x + 1;

			// TODO andThen, f define with h and g
			Function<Double, Double> f = x -> h.apply(g.apply(x));

			Assert.assertTrue(f.apply(2d) == 6);
			}
		}

	/**
	 * f(x) = sqrt(cos(x))
	 */
	private static void methodeReference()
		{
		// lamda dans variable
			{
			// TODO
			Function<Double, Double> h = x -> Math.sqrt(x);
			Function<Double, Double> g = x -> Math.cos(x);

			// f define with h and g
			Function<Double, Double> f = t -> h.apply(g.apply(t));

			Assert.assertTrue(isEquals(f.apply(2 * Math.PI), 1));
			}

		// lamda dans variable : reference methode
			{
			// TODO, reference methode
			Function<Double, Double> h = Math::sqrt;
			Function<Double, Double> g = Math::cos;

			// TODO
			// f define with h and g
			Function<Double, Double> f = t -> h.apply(g.apply(t));
			Assert.assertTrue(isEquals(f.apply(2 * Math.PI), 1));
			}
		}

	/*------------------------------*\
	|*				tools			*|
	\*------------------------------*/

	private static boolean isEquals(double x1, double x2)
		{
		final double epsilon = 1e-6;
		return Math.abs(x1 - x2) < epsilon;
		}

	}
