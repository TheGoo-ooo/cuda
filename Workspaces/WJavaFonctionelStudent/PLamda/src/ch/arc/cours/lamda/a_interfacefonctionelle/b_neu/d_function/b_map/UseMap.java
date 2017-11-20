
package ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.b_map;

import java.util.List;
import java.util.function.ToIntFunction;

import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.b_map.tools.Maison;
import ch.arc.cours.lamda.a_interfacefonctionelle.b_neu.d_function.b_map.tools.MaisonTools;

public class UseMap
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
		System.out.println("map : Function");

		mapping();
		}

	private static void mapping()
		{
		int n = 3;
		List<Maison> list = MaisonTools.create(n);

		System.out.println(list);

		printSurface(list);
		printPrix(list);
		printPiece(list);

		printSurfaceInt(list);
		printPrixInt(list);
		printPieceInt(list);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			Function<T1,T2>		*|
	\*------------------------------*/

	private static void printSurface(List<Maison> list)
		{
		// version : classe interne anonyme dans variable
			{

			}

		// Version : lamda dans variable
			{
			/*
			Function<Maison, Integer> =
			MaisonManipulator.mapPrint(list, function);
			*/
			}

		// Version : lamda
			{
			MaisonManipulator.mapPrint(list, (maison)-> maison.getSurface());
			}

		// Version : lamda : reference fonction
			{
			MaisonManipulator.mapPrint(list,  Maison::getSurface);
			}
		}

	private static void printPiece(List<Maison> list)
		{
		// Version : lamda
			{
			MaisonManipulator.mapPrint(list, (maison) -> maison.getNbPiece());
			}

		// Version : lamda : reference fonction
			{
			MaisonManipulator.mapPrint(list, Maison::getNbPiece);
			}
		}

	private static void printPrix(List<Maison> list)
		{
		// Version : lamda
			{
			MaisonManipulator.mapPrint(list, maison -> maison.getPrix());
			}

		// Version : lamda : reference fonction
			{
			MaisonManipulator.mapPrint(list, Maison::getPrix);
			}
		}

	/*------------------------------*\
	|*		ToIntFunction<T>		*|
	\*------------------------------*/

	private static void printSurfaceInt(List<Maison> list)
		{
		// Version : lamda dans variable
			{
			ToIntFunction<Maison> function = maison -> maison.getSurface();
			MaisonManipulator.mapPrintInt(list, function);
			}

		// Version : lamda
			{
			MaisonManipulator.mapPrintInt(list, maison -> maison.getSurface());
			}

		// Version : lamda : reference fonction
			{
			MaisonManipulator.mapPrintInt(list, Maison::getSurface);
			}
		}

	private static void printPieceInt(List<Maison> list)
		{
		// Version : lamda
			{
			MaisonManipulator.mapPrintInt(list, maison -> maison.getNbPiece());
			}

		// Version : lamda : reference fonction
			{
			MaisonManipulator.mapPrintInt(list,  Maison::getNbPiece);
			}
		}

	private static void printPrixInt(List<Maison> list)
		{
		// Version : lamda
			{
			MaisonManipulator.mapPrintInt(list, maison->maison.getPrix());
			}

		// Version : lamda : reference fonction
			{
			MaisonManipulator.mapPrintInt(list, Maison::getPrix);
			}
		}

	}
