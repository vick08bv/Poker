package Juego;

import Juego.Crupier;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Juego de póker texas hold'em con limite de apuestas.
 */
public class Juego{

    /**
     * Crupier del juego.
     */
    public Crupier crupier;
    
    /**
     * Apodos disponibles para los jugadores.
     */
    public static ArrayList<String> apodos;
    
    /**
     * Lista de jugadores en la partida.
     */
    public ArrayList<Jugador> jugadores;
    
    /**
     * Dinero inicial para todos los jugadores.
     */
    public int dineroInicial;
    
    /**
     * Apuesta mínima.
     */
    public int apuestaMinima;
    
    /**
     *Límite de las apuestas.
     */
    public int limiteApuesta;
    
    /**
     * Posición del ganador de cada mano.
     */
    public int ganadorDeMano;

    
    /**
     * Elección de los apodo para asignarlos 
     * al azar a los jugadores.
     */
    static {
	
        apodos = 
        new ArrayList<>(
        Arrays.asList(
        "Harrison Fold", "Harry Poker", "Check Norris", "Morgan Freecard", 
        "Woody Allin", "Barack Omaha", "Usain Fold", "George  Push",    
        "Mucked Jackson", "Amarillo Slim", "The Duchess of Poker", "Andy Beal",
        "Chip Reese", "Mr. Vegas", "Wizard", "El Matador",
        "The Professor", "Evybabee", "No Home Jerome", "The Tiger Woods of Poker",
        "Big Papa", "The Godfather", "Texas DollyTreetop", "Orient Express", 
        "Jeff Harman", "The Flying Finn", "The Gran Oldman of Poker", "The Ambasaador of Poker", 
        "The Pokerbrat", "BlackHorse", "Captain Tom", "DevilFish", 
        "Fossilman", "The Mouth", "Kid Poker", "Mad Genius", 
        "The Mathematician", "The Great Danish", "Gigabet", "The Greek", 
        "The Prince of Poker", "Puggy", "Dream Crusher", "The Club", 
        "Eskimo", "Luckbox", "Cowboy", "The Shark", 
        "Sailor", "Stingray", "Owl", "The Magician", 
        "MurphDog", "Johnny World", "Whatta player", "Bet Scarborough", 
        "Dot Com", "Doom", "Iosell Stallin", "The Thunder", 
        "LeFlop James", "Jesus", "Pitbull", "Paul Club", 
        "Kid Poker", "Shark Tale", "Chris Moneymaker", "The Young Gun of Poker", 
        "The Gentleman", "The Rook", "The Knight", "The Main Event", 
        "Deep Blue", "Libratus", "Capablanca", "Gauss", 
        "Isacc Newtop", "Andrew NGun", "Bill Gains", "Pocket Parker", 
        "The Wolf of Five Street"
        ));		
	
        Collections.shuffle(apodos);
        Collections.shuffle(apodos);
		
    }

    
    /**
     * Constructor del juego
     * @param apodoJugador Apodo del usuario en el juego.
     * @param numeroJugadores Cantidad de jugadores que inician la partida.
     * @param dineroInicial Dinero inicial que tendrá cada jugador.
     * @param apuestaMinima Apuesta durante las primeras 
     * dos  rondas de cada mano.
     * @param limiteApuesta Apuesta durante las últimas dos
     * rondas de cada mano.
     */
    public Juego(String apodoJugador, int numeroJugadores, 
    int dineroInicial, int apuestaMinima, int limiteApuesta){

        /*
         *El juego se inicia con 2 y hasta con 22, 
         *jugadores, de los cuales uno estará 
         *controlado por el usuario.
         */
        
        /*
         *Objeto random para asignar tipos de jugadores
         * al azar.
         */
        Random tipoAleatorio = new Random();
           
        ArrayList<Jugador> jugadores = new ArrayList<>(numeroJugadores);
		
        this.crupier = new Crupier();
        
        this.dineroInicial = dineroInicial;
        this.apuestaMinima = apuestaMinima;
        this.limiteApuesta = limiteApuesta;

        this.ganadorDeMano = -1;

        //Se crea al jugador humano.
        jugadores.add(
        new JugadorHumano(apodoJugador, 0, 0, dineroInicial));
                
        for(int i = 1; i < numeroJugadores; i++){

            /*
             *Se crean los demás jugadores
             *(controlados por la máquina).
             */
            
            jugadores.add(
            new JugadorMaquina(
            Juego.apodos.get(i), i, tipoAleatorio.nextInt(10) +1, dineroInicial));	
		
        }
        
        this.jugadores = jugadores;
        
        //Ordenación aleatoria de los jugadores en la mesa.
        Collections.shuffle(this.jugadores);
        Collections.shuffle(this.jugadores);
        
        for(Jugador jugador: this.jugadores){
            
            jugador.setNumeroJugador(this.jugadores.indexOf(jugador));
            
        }
			
    }
	
	
    /**
     * Se determina al ganador de la mano,
     * al que tenga la mejor mano de entre 
     * los jugadores activos.
     * @param posicionesActivas Posiciones 
     * de los jugadores en activo.
     */
    public void determinarGanador(ArrayList<Integer> posicionesActivas){		
        
        /*
         *El ganador de la mano será el 
         *que tenga la mejor combinación 
         *de cartas, el crupier se encargará
         *de verificarlo.
         */
        this.ganadorDeMano =  
        crupier.calcularMejorMano(this.jugadores);
        
        if(posicionesActivas.contains(this.ganadorDeMano)){
            
        } else {
            
            /*
             * Si el jugador con la mejor mano ya se retiró 
             * se considera la mejor mano de los que están
             * activos.
             */
            this.ganadorDeMano = 
            this.crupier.calcularMejorMano(
            this.jugadores, posicionesActivas);
            
        }
	
    }	
	
    /**
     * Se llama al crupier para que pague la apuesta.
     */
    public void pagarApuesta(){
        
        this.crupier.pagar(this.jugadores.get(this.ganadorDeMano));
        
    }
    
    /**
     * Desarrollo de cada mano de la partida.
     */
    public void jugarMano(){
        
        /*Las rondas de juego serán:
         *
         *Antes de cualquier ronda, se deposita un poco
         *al bote.
         *
         *Preflop: Ronda 0: Empieza el jugador a la izquierda
         *del jugador con el botón.
         *Las apuestas son de apuesta mínima.
         *
         *Flop: Ronda 1: Ronda donde se revelan
         *las primeras cartas comunales.
         *
         *Turn: Ronda 2: A partir de esta ronda se juga con
         *la apuesta grande(el límite de apuesta).
         *
         *River: Ronda 3: Última ronda antes de revelar las 
         *cartas de los jugadores.
         */
        
        //Jugadores en la mano actual.
        ArrayList<Jugador> jugadoresOriginales = new ArrayList<>(20);
        
        //Jugadores activos.
        ArrayList<Integer> posicionesActivas = new ArrayList<>(22);
        
        //Posiciones desocupadas.
        ArrayList<Integer> jugadoresEliminados = new ArrayList<>(5);
        
        for(Jugador jugador: this.jugadores){
            
            /*
             *Se añaden los jugadores, al principio
             *todos están activos.
             */
            jugadoresOriginales.add(jugador);
            
        }
        
        /*
         * Se añaden las posiciones activas de acuerdo
         * a los turnos de juego.
         */
        
        for(int i = 0; i < this.jugadores.size(); i++){
            
            posicionesActivas.add(
            jugadores.get(
            (this.crupier.posicionBoton+1+i) % jugadores.size()
            ).numeroJugador);
            
        }
        
        /*
         * El crupier cobra la cuota.
         */
        
        this.crupier.fijarCuota(this.jugadores, this.apuestaMinima);
        
        System.out.printf("\nLos jugadores pondrán %d en el bote.\n",
        this.apuestaMinima);
        
        try {
            Thread.sleep(1500);
        } catch (Exception e){
            System.out.println("Ocurrió un error");
        }
        
        System.out.printf("\nLos jugadores en la mano son:\n");
        
        for(int posicion: posicionesActivas){
            
            try {
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println("Ocurrió un error");
            }
            
            System.out.print(jugadores.get(posicion));
            
        }
        
        try {
            Thread.sleep(1500);
        } catch (Exception e){
            System.out.println("Ocurrió un error");
        }
        
        System.out.print("\nEl Crupier repartirá las cartas.\n");
        
        /*
         * Reparto de cartas.
         */
        this.crupier.repartirCartas(this.jugadores);
        
        try {
            Thread.sleep(1500);
        } catch (Exception e){
            System.out.println("Ocurrió un error");
        }
        
        for(Jugador jugador: this.jugadores){
            if(jugador.getTipoJugador() == 0){
                System.out.print(jugador.toString());
            }   
        }
        
        /*
         * Desarrollo de cada una de las rondas
         * de apuestas.
         */
        for(int ronda = 0; ronda < 4; ronda++){
                   
            this.crupier.desarrollarMano(
            this.apuestaMinima, this.limiteApuesta, ronda, 
            this.jugadores, posicionesActivas
            );
            
            try {
                Thread.sleep(1500);
            } catch (Exception e){
                System.out.println("Ocurrió un error");
            }
            
        }
        
         //Determinación del jugador ganador.
        
        this.determinarGanador(posicionesActivas);
        
        try {
            Thread.sleep(1500);
        } catch (Exception e){
            System.out.println("Ocurrió un error");
        }
        
          
        //Pago del dinero en el bote al ganador.
        this.pagarApuesta();
        
        System.out.printf("\nEl ganador de la mano es: %s %s",
        this.jugadores.get(this.ganadorDeMano), 
        this.jugadores.get(this.ganadorDeMano).getMejorMano());
        
        try {
            Thread.sleep(1500);
        } catch (Exception e){
            System.out.println("Ocurrió un error");
        }
        
        //Actualización de los jugadores activos.
        this.jugadores = this.crupier.declararJugadoresActivos(this.jugadores);
        
        //Se reordena la mesa después de terminar la mano.
        this.crupier.reordenarMesa(this.jugadores, jugadoresOriginales);
        
    }
    
    /**
     * Verificación del termino del juego.
     * @return Indicación sobre el estado del usuario.
     */
    public int terminarJuego(){
        
        int numeroUsuariosActivo = 0;
        int numeroJugadores = 0;
        
        /*
         * Se cuenta el número de jugadores que siguen
         * con dinero en la partida después de cada mano.
         */
        for (Jugador jugador: this.jugadores){
            
            if(jugador.getTipoJugador() == 0){
                numeroUsuariosActivo++;
            }
            
            numeroJugadores++;
            
        }
        
        /*
         *Si el jugador que controla el usuario ya perdió su dinero
         *se indica que se ha acabado el juego.
         */
        if(numeroUsuariosActivo == 0){
            
            return -1;
            
        }
        
        /*
         * Si sólo hay un jugador, entonces debe ser el usuario,
         * pues sigue activo y se manda la indicaciónd de que
         * ha ganado el juego.
         */
        if(numeroJugadores == 1){
            
            return 1;
            
        }
        
        /*
         * Indica que no ha terminado el juego.
         */
        return 0;
      
    }
    
    
    
    /**
     * Creación de un juego nuevo.
     * @param args Argumentos.
     */
    public static void main(String[] args){
        
        Scanner scaner = new Scanner(System.in);
        
        String apodoJugador = "";
        String numeroJugadores = "2";
        String dineroInicial = "";
        String apuestaMinima = "";
        String limiteApuesta = "";
        int ganador = -1;
        
        try {
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Ocurrió un error");
            }
        
        System.out.printf("\n   Juego de Póker\n "
                + "\n   Texas Hold'em.\n"
                + "\n     Bienvenido\n");
        
        try {
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Ocurrió un error");
            }
        
        System.out.printf("\nIngresa tu apodo de jugador:\n");
        
        apodoJugador = (String) scaner.nextLine();
        
        
        System.out.printf("\nIngresa el número de jugadores:\n");

        numeroJugadores = (String) scaner.nextLine();
        
        while(true){
        
            while(true){

                try {
                    Integer.parseInt(numeroJugadores);
                        break;
                } catch (NumberFormatException excepcion) {
                    
                    System.out.printf("\nDebes ingresar un número del 2 al 22.\n");
                    
                    numeroJugadores = (String) scaner.nextLine();
                    
                }
                
            }
            
                            
            if ((Integer.parseInt(numeroJugadores) < 2) ||  
                (Integer.parseInt(numeroJugadores) > 22)){ 
                
                System.out.printf("\nDebes ingresar un número del 2 al 22.\n");
                
                numeroJugadores = (String) scaner.nextLine();

            }   else {
 
                break;
                
            }
        
        }

        
        System.out.printf("\nIngresa el dinero inicial de los jugadores:\n");

        dineroInicial = (String) scaner.nextLine();
        
        while(true){
        
            while(true){

                try {
                    Integer.parseInt(dineroInicial);
                        break;
                } catch (NumberFormatException excepcion) {
                    
                    System.out.printf("\nDebes ingresar un número del 10 al 1 000 000.\n");

                    dineroInicial = (String) scaner.nextLine();
                    
                }
                
            }
            
                            
            if ((Integer.parseInt(dineroInicial) < 10) ||  
                (Integer.parseInt(dineroInicial) > 1000000)){ 
                 
                    System.out.printf("\nDebes ingresar un número del 10 al 1 000 000.\n");

                    dineroInicial = (String) scaner.nextLine();

            }   else {
 
                break;
                
            }
        
        }
        
        
        System.out.printf("\nIngresa la apuesta mínima de los jugadores:\n");

        apuestaMinima = (String) scaner.nextLine();
        
        while(true){
        
            while(true){

                try {
                    Integer.parseInt(apuestaMinima);
                        break;
                } catch (NumberFormatException excepcion) {
                    
                    System.out.printf("\nDebes ingresar un número del 1 al %s:\n", 
                    Integer.parseInt(dineroInicial)-2);
                    
                    apuestaMinima = (String) scaner.nextLine();
                    
                }
                
            }
            
                            
            if ((Integer.parseInt(apuestaMinima) < 1) ||  
                (Integer.parseInt(apuestaMinima) >
                 Integer.parseInt(dineroInicial) -2 )){ 
                                    
                    System.out.printf("\nDebes ingresar un número del 1 al %s:\n", 
                    Integer.parseInt(dineroInicial)-2);
                    
                    apuestaMinima = (String) scaner.nextLine();

            }   else {
 
                break;
                
            }
        
        }
        
        
        System.out.printf("\nIngresa la apuesta grande de los jugadores:\n");

        limiteApuesta = (String) scaner.nextLine();
        
        while(true){
        
            while(true){

                try {
                    Integer.parseInt(limiteApuesta);
                        break;
                } catch (NumberFormatException excepcion) {
                    
                    System.out.printf("\nDebes ingresar un número del %s al %s:\n", 
                    Integer.parseInt(apuestaMinima)+1,Integer.parseInt(dineroInicial)-1);
   
                    limiteApuesta = (String) scaner.nextLine();

                }
                
            }
            
                            
            if ((Integer.parseInt(limiteApuesta) < 
                  Integer.parseInt(apuestaMinima)+1) ||  
                (Integer.parseInt(limiteApuesta) > 
                 Integer.parseInt(dineroInicial)-1 )){ 
                 
                    System.out.printf("\nDebes ingresar un número del %s al %s:\n", 
                    Integer.parseInt(apuestaMinima)+1,Integer.parseInt(dineroInicial)-1);
   
                    limiteApuesta = (String) scaner.nextLine();


            }   else {
 
                break;
                
            }
        
        }
        
        
        //Nuevo Juego
        Juego juego = new Juego(
        apodoJugador, Integer.parseInt(numeroJugadores),  
        Integer.parseInt(dineroInicial), Integer.parseInt(apuestaMinima), 
        Integer.parseInt(limiteApuesta));
        
        //Contador de manos.
        int mano = 1;
        
        while(true){
            
            //Se juegan manos hasta que el jugador gane o pierda.
            if(juego.terminarJuego() == 1){
                break;
            }
            
            System.out.printf("\n\n%s\n\n", "*******************");
            
            try {
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Ocurrió un error");
            }
            
            System.out.printf("\n  Mano número: %d\n", mano);
            
            try {
                Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Ocurrió un error");
            }
        
            //Se juega la mano actual.
            juego.jugarMano();
            
            try {
            Thread.sleep(2000);
            } catch (Exception e){
            System.out.println("Ocurrió un error");
            }
            
            mano++;
            
        }
        
        try {
            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println("Ocurrió un error");
        }

        //Termino del juego
        if (juego.terminarJuego() == -1){
            
            System.out.println("\nHas perdido tu dinero.\n");
            
        } else {
            
            System.out.println("\nFelicidades ¡ganaste!\n");
            
        }
        
        
    }
       
	
}