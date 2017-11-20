
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.a_math.original.c_mixte;

import java.util.function.Function;

import org.junit.Assert;

public class UseMixte
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
		System.out.println("math : Function : mixte");

		exerciceSyntaxe();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/


	/**
	 * f(x) = cos(x)*cos(x)+sin(x)*sin(x)
	 */
	private static void exerciceSyntaxe()
		{
		// lamda dans variable
			{
			// TODO
			Function<Double, Double> cos = x -> Math.cos(x);
			Function<Double, Double> sin = x -> Math.sin(x);

			// TODO use MixteTools
			Function<Double, Double> cos2 = MixteTools.prod(cos, cos);
			Function<Double, Double> sin2 = MixteTools.prod(sin, sin);
			Function<Double, Double> f = MixteTools.add(cos2, sin2);

			Assert.assertTrue(f.apply(Math.PI) == 1);
			Assert.assertTrue(f.apply(Math.PI / 2) == 1);
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
