
package ch.arc.cours.lamda.g_image.tools;

public class Interval<T>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Interval(T a, T b)
		{
		this.a = a;
		this.b = b;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(a);
		stringBuilder.append(",");
		stringBuilder.append(b);
		stringBuilder.append("]");
		return stringBuilder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public T getA()
		{
		return this.a;
		}

	public T getB()
		{
		return this.b;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private T a;
	private T b;

	}
