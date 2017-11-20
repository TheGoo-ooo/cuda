
package ch.arc.cours.tools;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static <T> Stream<T> stream(final Iterable<T> iterable)
		{
		return toStream(iterable, false);
		}

	public static <T> Stream<T> parallelStream(final Iterable<T> iterable)
		{
		return toStream(iterable, true);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static <T> Stream<T> toStream(final Iterable<T> iterable, final boolean isParallel)
		{
		return StreamSupport.stream(iterable.spliterator(), isParallel);
		}
	}
