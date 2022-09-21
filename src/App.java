import java.lang.module.ResolutionException;
import java.util.Scanner;

public class App {

    static final String PIEDRA = "piedra";
    static final String PAPEL = "papel";
    static final String TIJERAS = "tijeras";

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String eleccionJugador1 = "";
        String eleccionJugador2 = "";
        String seguirJugando = "";

        boolean fin = false;

        while(!fin) {

            try {

                System.out.println("Jugador 1 introduce eleccion (piedra/papel/tijeras)");
                eleccionJugador1 = Choose();

                System.out.println("Jugador 2 introduce eleccion (piedra/papel/tijeras)");
                eleccionJugador2 = Choose();

            } catch (InvalidChoiceException e) {
                
                System.out.println("Eleccion invalida, volviendo a empezar...");
                continue;
                
            }

            System.out.println(CheckPlay(eleccionJugador1, eleccionJugador2));
           
            System.out.println("¿Quieres seguir jugando? (S/n)");
            seguirJugando = in.next();

            if(seguirJugando.toLowerCase().equals("n")) fin = true;
        }
    }

    public static String CheckPlay(String eleccionJugador1, String eleccionJugador2) {

        if((eleccionJugador1.equals(PIEDRA) && eleccionJugador2.equals(TIJERAS)) ||
           (eleccionJugador1.equals(PAPEL) && eleccionJugador2.equals(PIEDRA)) ||
           (eleccionJugador1.equals(TIJERAS) && eleccionJugador2.equals(PAPEL))) {

            return "Jugador 1 gana.";

        } else if((eleccionJugador2.equals(PIEDRA) && eleccionJugador1.equals(TIJERAS)) ||
                  (eleccionJugador2.equals(PAPEL) && eleccionJugador1.equals(PIEDRA)) ||
                  (eleccionJugador2.equals(TIJERAS) && eleccionJugador1.equals(PAPEL))) {

            return "Jugador 2 gana.";

        } else {

            return "Empate.";
        }
    }

    public static String Choose() throws InvalidChoiceException {
    
        String choice = "";
        choice = in.next();
            
        if(choice.toLowerCase().equals(PIEDRA) ||
           choice.toLowerCase().equals(PAPEL) ||
           choice.toLowerCase().equals(TIJERAS)) {

            return choice;

        } else {

            throw new InvalidChoiceException("Eleccion invalida.");
        }
     }

    public static class InvalidChoiceException extends Exception {

        public InvalidChoiceException(String msg) {
            super(msg);
        }
    }
}


