
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.a_math.original.b_bi;

import org.junit.Assert;

public class UseBiFunctionMath
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
		System.out.println("math : BiFunction");

		biFunction();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void biFunction()
		{
		hello();
		apply();
		}

	/*------------------------------*\
	|*		BiFunction<T1,T2,T3>	*|
	\*------------------------------*/

	/**
	 * f(x1,x2)= (x1-x2) + (x1*x2)
	 *
	 * Echauffement, simple evaluation directe
	 */
	private static void hello()
		{
		//lamda dans variable
			{
			// TODO
			BiFunctionDouble f = (x, y) -> x-y + x*y;

			Assert.assertTrue(f.apply(3d, 2d) == 7);
			}
		}

	/**
	 * h(x1,x2)= x1 - x2
	 * g(x1,x2)= x1 * x2
	 *
	 * f(x1,x2) =  h(x1,x2) + g(x1,x2)
	 */
	private static void apply()
		{
		//lamda dans variable
			{
			// TODO
			BiFunctionDouble h = (x, y) -> x - y;
			BiFunctionDouble g = (x, y) -> x * y;

			// use h and g, apply
			BiFunctionDouble f = (x, y) -> h.apply(x, y) + g.apply(x, y);

			Assert.assertTrue(f.apply(3d, 2d) == 7);
			}
		}

	}
