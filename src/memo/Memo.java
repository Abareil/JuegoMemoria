package memo;

import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

public class Memo {

	public static void main(String[] args) {



		// revisar si voy a validar repeticiones
		int ubicUsada1 = 10;
		int ubicUsada2 = 10;

		// matriz 2x6 con resultados
		int[][] matrizFacil = { { 1, 5 }, { 3, 4 }, { 2, 6 }, { 5, 6 }, { 3, 6 }, { 2, 4 } };
		int[][] matrizDificil = { { 3, 8 }, { 6, 9 }, { 1, 6 }, { 5, 9 }, { 4, 7 }, { 2, 7 } };

		// varias
		int puntaje = 0, random, dificultad, elegida, oportunidades = 3, prueba = 0;
		String seguir = "no";

		// bienvenida
		JOptionPane.showMessageDialog(null, "Bienvenido/a al Juego de Memoria. \nEmpecemos!", "Juego de memoria",
				JOptionPane.DEFAULT_OPTION, new ImageIcon(Memo.class.getResource("/img/hola.jpg")));
		// mostrar reglas
		JOptionPane.showMessageDialog(null,
				"En las imágenes hay un animalito repetido. \nCada posición tiene un número. \nTenes que memorizar sus dos posiciones \ne ingresar cada una de ellas. "
				+ "\nPresta atención!",
				"Juego de memoria", JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Memo.class.getResource("/img/reglas.jpg")));

		do {
			// elegir dificultad y validar
			do {
			dificultad = Integer.parseInt(JOptionPane.showInputDialog("Elegí la dificultad: \n1 - Nivel 1 (6 posiciones) \n2- Nivel 2 (9 posiciones)"));
			} while (!(dificultad == 1 || dificultad ==2));
			
			switch (dificultad) {
			case 1: {
				// random
				random = (int) (Math.random() * 6);
				System.out.println(random);

				// mostrar imagen x cantidad de tiempo GIF
				JOptionPane.showMessageDialog(null, "", "Juego de memoria", JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Memo.class.getResource("/img/facil" + random + ".gif")));
				while (prueba <= 2) {
				// ingreso opcion 1
				elegida = Integer.parseInt(
						JOptionPane.showInputDialog("¿Quién se repite? \nIngresa la posición numerada"));
				
				
				if (elegida == matrizFacil[random][0] || elegida == matrizFacil[random][1]) {
					JOptionPane.showMessageDialog(null, "Sumas un punto", "Juego de memoria",
							JOptionPane.DEFAULT_OPTION, new ImageIcon(Memo.class.getResource("/img/acertaste.jpg")));
					// descontar oportunidad
					oportunidades -= 1;
					// sumar 1 punto
					puntaje++;
					prueba++;
					
					//guardo ubicacin usada 1
					ubicUsada1 = elegida;
					//muestro oportunidades restantes
					JOptionPane.showMessageDialog(null, "Te quedan " + oportunidades + " oportunidades");
					
					//entro al while
					while (prueba == 1 || prueba == 2) {
						// vuelvo a preguntar
						elegida = Integer.parseInt(JOptionPane
								.showInputDialog("¿Quién se repite? \\nIngresa la posición numerada"));
						
						// valido y si acerte
						if ((elegida == matrizFacil[random][0] || elegida == matrizFacil[random][1]) && (elegida != ubicUsada1) && (elegida != ubicUsada2)) {
							// suma para salir
							prueba += 2;
							// mensaje ganaste
							JOptionPane.showMessageDialog(null, "", "Juego de memoria",
									JOptionPane.DEFAULT_OPTION,
									new ImageIcon(Memo.class.getResource("/img/ganaste_.jpg")));
							// suma puntos
							puntaje++;

							// si falle
						} else {
							// resta oportunidad
							oportunidades -= 1;
							prueba++;
							// manda msj de ups
							JOptionPane.showMessageDialog(null, "", "Juego de memoria", JOptionPane.DEFAULT_OPTION,
									new ImageIcon(Memo.class.getResource("/img/ups.jpg")));
							// muestra oportunidades restantes
							JOptionPane.showMessageDialog(null, "Te quedan " + oportunidades + " oportunidades");
						}
						ubicUsada2 = elegida;
					}
					
					//si fallo en primer intento
				} else {
					// descontar oportunidad
					oportunidades -= 1;
					JOptionPane.showMessageDialog(null, "", "Juego de memoria", JOptionPane.DEFAULT_OPTION,
							new ImageIcon(Memo.class.getResource("/img/ups.jpg")));
					prueba++;
				}
				}
				
				

				break;
			}
			case 2: {
				// random
				random = (int) (Math.random() * 6);
				System.out.println(random);
				
				// mostrar imagen x cantidad de tiempo GIF
				JOptionPane.showMessageDialog(null, "", "Juego de memoria", JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Memo.class.getResource("/img/dif" + random + ".gif")));
				while (prueba <= 2) {
				// ingreso opcion 1
				elegida = Integer.parseInt(
						JOptionPane.showInputDialog("¿Quién se repite? \nIngresa la posición numerada"));
				
				
				if (elegida == matrizDificil[random][0] || elegida == matrizDificil[random][1]) {
					JOptionPane.showMessageDialog(null, "Sumas un punto", "Juego de memoria",
							JOptionPane.DEFAULT_OPTION, new ImageIcon(Memo.class.getResource("/img/acertaste.jpg")));
					// descontar oportunidad
					oportunidades -= 1;
					// sumar 1 punto
					puntaje++;
					prueba++;
					
					//guardo ubicacin usada 1
					ubicUsada1 = elegida;
					//muestro oportunidades restantes
					JOptionPane.showMessageDialog(null, "Te quedan " + oportunidades + " oportunidades");
					
					//entro al while
					while (prueba == 1 || prueba == 2) {
						// vuelvo a preguntar
						elegida = Integer.parseInt(JOptionPane
								.showInputDialog("¿Quién se repite? \\nIngresa la posición numerada"));
						
						// valido y si acerte
						if ((elegida == matrizDificil[random][0] || elegida == matrizDificil[random][1]) && (elegida != ubicUsada1) && (elegida != ubicUsada2)) {
							// suma para salir
							prueba += 2;
							// mensaje ganaste
							JOptionPane.showMessageDialog(null, "", "Juego de memoria",
									JOptionPane.DEFAULT_OPTION,
									new ImageIcon(Memo.class.getResource("/img/ganaste_.jpg")));
							// suma puntos
							puntaje++;

							// si falle
						} else {
							// resta oportunidad
							oportunidades -= 1;
							prueba++;
							// manda msj de ups
							JOptionPane.showMessageDialog(null, "", "Juego de memoria", JOptionPane.DEFAULT_OPTION,
									new ImageIcon(Memo.class.getResource("/img/ups.jpg")));
							// muestra oportunidades restantes
							JOptionPane.showMessageDialog(null, "Te quedan " + oportunidades + " oportunidades");
						}
						ubicUsada2 = elegida;
					}
					
					//si fallo en primer intento
				} else {
					// descontar oportunidad
					oportunidades -= 1;
					JOptionPane.showMessageDialog(null, "", "Juego de memoria", JOptionPane.DEFAULT_OPTION,
							new ImageIcon(Memo.class.getResource("/img/ups.jpg")));
					prueba++;
				}
				}
				
				
				
				break;
			}
			default:
				break;
			}
			// inicializo variables para volver a jugar
			prueba = 0;
			oportunidades = 3;

			// mostrar puntaje y preguntar si desea jugar nuevamente FALTA IMAGEN
			seguir = JOptionPane.showInputDialog("Tu puntaje es: " + puntaje + "\n¿Deseas jugar de nuevo?");



		} while (seguir.equalsIgnoreCase("si"));

		JOptionPane.showMessageDialog(null, "", "Juego de memoria", JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Memo.class.getResource("/img/gracias.jpg")));

	}
}
