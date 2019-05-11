import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

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
     * @param numeroJugadores Cantidad de jugadores que inician la partida.
     * @param dineroInicial Dinero inicial que tendrá cada jugador.
     * @param apuestaMinima Apuesta durante las primeras 
     * dos  rondas de cada mano.
     * @param limiteApuesta Apuesta durante las últimas dos
     * rondas de cada mano.
     */
    public Juego(int numeroJugadores, int dineroInicial, 
    int apuestaMinima, int limiteApuesta){

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
        new JugadorHumano(Juego.apodos.get(0), 0, 0, dineroInicial));
                
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
        ArrayList<Integer> jugadoresActivos = new ArrayList<>(22);
        
        //Posiciones desocupadas.
        ArrayList<Integer> jugadoresEliminados = new ArrayList<>(5);
        
        for(Jugador jugador: this.jugadores){
            
            /*
             *Se añaden los jugadores, al principio
             *todos están activos.
             */
            jugadoresOriginales.add(jugador);
            jugadoresActivos.add(jugador.numeroJugador);
            
        }
        
        /*
         * El crupier cobra la cuota.
         */
        this.crupier.fijarCuota(this.jugadores, this.apuestaMinima);
        
        System.out.print("\nEl Crupier reparte las cartas\n");
        
        /*
         * Reparto de cartas.
         */
        this.crupier.repartirCartas(jugadores);
        
        /*
         * Desarrollo de cada una de las rondas
         * de apuestas.
         */
        for(int ronda = 0; ronda < 4; ronda++){
                   
            this.crupier.desarrollarMano(
            this.apuestaMinima, this.limiteApuesta, ronda, 
            this.jugadores, jugadoresActivos
            );
            
        }
        
         //Determinación del jugador ganador.
        
        this.determinarGanador(jugadoresActivos);
        
        System.out.printf("\nEl ganador de la mano es: %s %s",this.jugadores.get(this.ganadorDeMano), 
        this.jugadores.get(this.ganadorDeMano).getMejorMano());
        
        //Pago del dinero en el bote al ganador.
        this.pagarApuesta();
        
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
        
        int numeroJugadores = 22;
        int dineroInicial = 100;
        int apuestaMinima = 10;
        int limiteApuesta = 20;
        int ganador = -1;
        
        //Nuevo Juego
        Juego juego = new Juego(numeroJugadores, dineroInicial, 
        apuestaMinima, limiteApuesta);
        
        //Contador de manos.
        int mano = 0;
        
        while(true){
            
            //Se juegan manos hasta que el jugador gane o pierda.
            if(juego.terminarJuego() != 0){
                break;
            }
            
            System.out.printf("\nMano número: %d\n", mano);
        
            //Se juega la mano actual.
            juego.jugarMano();
            
            mano++;
            
        }
        
        //Termino del juego
        if (juego.terminarJuego() == -1){
            
            System.out.println("Perdiste");
            
        } else {
            
            System.out.println("Felicidades ¡ganaste!");
            
        }
        
        
    }
       
	
}