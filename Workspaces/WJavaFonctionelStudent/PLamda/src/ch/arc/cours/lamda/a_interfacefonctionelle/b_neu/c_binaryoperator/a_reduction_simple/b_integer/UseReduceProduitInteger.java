
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.c_binaryoperator.a_reduction_simple.b_integer;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

import org.junit.Assert;

import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.c_binaryoperator.a_reduction_simple.NumberTools;

public class UseReduceProduitInteger
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
		System.out.println("reduce : IntBinaryOperator : product");

		reduceProduit();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void reduceProduit()
		{
		int n = 4;
		int[] tab = NumberTools.create(n);

		int produit1 = version1(tab);
		int produit2 = version2(tab);
		int produit3 = version3(tab);

		// check
			{
			System.out.println(Arrays.toString(tab));
			System.out.println("product = " + produit1);
			System.out.println("product = " + produit2);
			System.out.println("product = " + produit3);

			int produitTrue = 24;
			Assert.assertTrue(produit1 == produitTrue);
			Assert.assertTrue(produit2 == produitTrue);
			Assert.assertTrue(produit3 == produitTrue);
			}
		}

	/*------------------------------*\
	|*	IntBinaryOperator<T>		*|
	\*------------------------------*/

	/**
	 * classe interne anonyme
	 */
	private static int version1(int[] tab)
		{
		IntBinaryOperator operator = new IntBinaryOperator()
			{

			@Override
			public int applyAsInt(int left, int right)
				{
				return left * right;
				}

			};
		return NumberManipulatorInteger.reduce(tab, operator, 1);
		}

	/**
	 * lamda dans variable
	 */
	private static int version2(int[] tab)
		{
		return NumberManipulatorInteger.reduce(tab, (x, y) -> x * y, 1);
		}

	/**
	 * lamda
	 */
	private static int version3(int[] tab)
		{
		return NumberManipulatorInteger.reduce(tab, (x, y) -> x * y, 1);
		}

	}
