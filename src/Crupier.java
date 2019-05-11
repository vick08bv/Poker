import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Anfitrión y encargado de dirigir el juego.
 */
public class Crupier{
    
    /**
     * Posición del botón en la mesa, que determina
     * el rol de turnos.
     */
    public int posicionBoton;
    
    /**
     * Dinero en la mesa, recogido de las apuestas.
     */
    public int dineroEnBote;
    
    /**
     * Baraja del juego.
     */
    private Baraja baraja;
    
    /**
     * Cartas reveladas en la segunda ronda de apuestas.
     */
    private CartasComunales flop;
    
    /**
     * Cartas en la tercera ronda de apuestas.
     */
    private CartasComunales turn;
    
    /**
     * Cartas en la cuarta ronda de apuestas.
     */
    private CartasComunales river;
    
    
    /**
     * Constructor. No se reciben argumentos.
     */
    public Crupier(){
	
        this.baraja = new Baraja(Baraja.barajaFrancesa());
        this.posicionBoton = 0;
        this.dineroEnBote = 0;
        
    }
    
    /**
     * Permuta aleatoriamentelas cartas.
     */
    private void barajar(){
        
        Collections.shuffle(this.baraja.cartas);
        Collections.shuffle(this.baraja.cartas);
	
    }
			
    
    /**
     * Recibe la lista de jugadores en la partida, elimina
     * a quiénes se quedan sin dinero.
     * @param jugadores Jugadores en la partida.
     * @return Lista de jugadores aún con dinero.
     */
    public ArrayList<Jugador> declararJugadoresActivos(
    ArrayList<Jugador> jugadores){
        
        ArrayList<Jugador> jugadoresActivos = new ArrayList<>(20);
        
        for(Jugador jugador: jugadores){
        
            if (jugador.dinero > 0){
				
                    jugadoresActivos.add(jugador);
			
            }
        
        }
        
        return jugadoresActivos;
        
    }
    
    
    /**
     * El crupier hace una lista de las posiciones libres, 
     * por la pronta eliminación de los jugadores.
     * @param jugadores Jugadores que participaron en
     * la última mano de la partida.
     * @return Lista de posiciones libres.
     */
    public ArrayList<Integer> liberarPosiciones(ArrayList<Jugador> jugadores){
        
         /*
         *Después de terminar una mano, el crupier ve 
         *qué jugadores se quedaron sin dinero para 
         *checar los posibles cambios en las posiciones
         *de los jugadores en la mesa.
         */
		
        ArrayList<Integer>posicionesLibres = new ArrayList<>(5);
		
        for(Jugador jugador: jugadores){
			
            if(jugador.dinero == 0){
				
                posicionesLibres.add(jugador.numeroJugador);
                
                System.out.printf("\n%s se ha quedado sin dinero, "
                + "queda eliminado\n", jugador.apodo);

            }
            
        }		
		
        return posicionesLibres;
	
    }
	
    
    /**
     * Reacomodo del botón de acuerdo al despeje de la mesa.
     * @param posicionesLibres Posiciones que se han desocupado.
     * @param numeroJugadoresActivos Jugadores aún en juego.
     */
    public void rotarBoton(ArrayList<Integer> posicionesLibres, 
    int numeroJugadoresActivos){

        /*
         *El botón rota como los jugadores, pero al final
         * se desplaza una posición más, indicando que, en
         * cada mano, el primero en jugar es un jugador
         * distinto.
         */
        
        int posicionesRecorridas = 0;
		
        for(int posicionLibre: posicionesLibres){
			
            if(posicionLibre-posicionesRecorridas < this.posicionBoton){
				
                this.posicionBoton--;
                posicionesRecorridas++;
			
            }
		
        }
		
    this.posicionBoton = ( this.posicionBoton + 1) % numeroJugadoresActivos;
		
    }
    
  
    /**
     * Se retiran todas las cartas de la mesa al finalizar la mano.
     * @param jugadores Jugadores en el juego.
     */
    public void recogerMesa(ArrayList<Jugador> jugadores){
        
        for(Jugador jugador: jugadores){
            
            jugador.setParCartas();
            jugador.setMejorMano(); 
            jugador.setCartasTotales();
        
        }
        
    }
          

    /**
     * Reordenación de los jugadores activos en la mesa.
     * @param jugadoresActivos Jugadores que seguirán jugando.
     * @param jugadoresOriginales Jugadores que jugaron la última
     * partida.
     */
    public void reordenarMesa(ArrayList<Jugador> jugadoresActivos, 
    ArrayList<Jugador> jugadoresOriginales){
        
        /*
         * En este método, el crupier con la lista de jugadores 
         * originales y con la de jugadores activos al final de la mano 
         * (todos los aún tienen dinero), rota el botón, 
         * asigna un nuevo número a los jugadores y
         * recoge las cartas de la mesa.
         */
		
        ArrayList<Integer> posicionesLibres = 
        this.liberarPosiciones(jugadoresOriginales);
		
        this.rotarBoton(posicionesLibres, jugadoresActivos.size());

        for(Jugador jugador: jugadoresActivos){
			
            jugador.setNumeroJugador(posicionesLibres);
            
        }
        
        this.recogerMesa(jugadoresOriginales);
        
        this.dineroEnBote = 0;
	
    }

    
    /**
     * Paga del dinero en el bote al jugador ganador.
     * @param ganador Jugador que ha ganado la mano.
     */
    public void pagar(Jugador ganador){
        
        ganador.setDinero(this.dineroEnBote, "Gana");
        
        this.dineroEnBote = 0;
        
    }
    
    
    /**
     * Cobro de una cuota a los jugadores antes de empezar la mano.
     * @param jugadores Jugadores que jugarán la mano.
     * @param apuesta Cuota a cobrar.
     */
    public void fijarCuota(ArrayList<Jugador> jugadores, int apuesta){
        
        /*
         * El cobro de couta es una manera de impedir que el jugador
         * se retire ventajosamente de todas las manos.
         */
        
        for(Jugador jugador: jugadores){
        
            if(jugador.dinero < apuesta){

                this.dineroEnBote += jugador.dinero;

                jugador.setDinero(0);

                jugador.setDineroApostado(apuesta, "Sube");               

            } else {

                this.dineroEnBote += apuesta;

                jugador.setDinero(apuesta, "Apuesta");

                jugador.setDineroApostado(apuesta, "Sube");

            }
        
        }
        
    }
    
    
    /**
     * Reparto de las cartas a cada jugador.
     * @param jugadores Jugadores en la partida.
     */
    public void repartirCartas(ArrayList<Jugador> jugadores){
        
        //Barajeo.
        
        this.barajar();
        
        /*
         * Reparto de las cartas a cada jugador, las primeras 
         * dos al primero, las siguientes dos al segundo, etc.
         */
        
        for(Jugador jugador: jugadores){
            
            jugador.setParCartas(
            new CartasBolsillo(
            new ArrayList<>(
            Arrays.asList(
            this.baraja.cartas.get(2*jugador.numeroJugador), 
            this.baraja.cartas.get((2*jugador.numeroJugador) + 1)       
            ))));
            
            jugador.getParCartas().establecerPuntaje();
            
        }
        
        /*
         *Las siguientes cartas en aparecer, sin contar
         *los descartes, serán las comunales.
         */
        
        this.flop = new CartasComunales(
        new ArrayList<>(
        Arrays.asList(
        this.baraja.cartas.get(2*jugadores.size() + 1), 
        this.baraja.cartas.get(2*jugadores.size() + 2), 
        this.baraja.cartas.get(2*jugadores.size() + 3)
        )));
		
        this.turn = new CartasComunales(
        new ArrayList<>(
        Arrays.asList(
        this.baraja.cartas.get(2*jugadores.size() + 1), 
        this.baraja.cartas.get(2*jugadores.size() + 2), 
        this.baraja.cartas.get(2*jugadores.size() + 3), 
        this.baraja.cartas.get(2*jugadores.size() + 5)
        )));
		
        this.river = new CartasComunales(
        new ArrayList<>(
        Arrays.asList(
        this.baraja.cartas.get(2*jugadores.size() + 1), 
        this.baraja.cartas.get(2*jugadores.size() + 2), 
        this.baraja.cartas.get(2*jugadores.size() + 3), 
        this.baraja.cartas.get(2*jugadores.size() + 5), 
        this.baraja.cartas.get(2*jugadores.size() + 7)
        )));		
        
    }
    
    
    /**
     * Cálculo de la mejor mano de entre los jugadores.
     * @param jugadores Jugadores en la mano.
     * @return Posición del jugador con la mejor mano.
     */
    public int calcularMejorMano(ArrayList<Jugador> jugadores){
		
        /*
         *Así como cada jugador calcula su mejor 
         *mano, el crupier debe determinar cuál 
         *es la mejor de las que tienen los jugadores.
         */
        
        int mejorPosicion = 0;
        long puntajeMayor = 0;
        long puntajeActual = 0;
	
        /*
         * Cálculo similar al que realiza cada jugador
         * para determinar su mejor mano.
         */
        
        for(Jugador jugador: jugadores){
           
            puntajeActual = jugador.getMejorMano().getPuntaje();
			
            if(puntajeActual > puntajeMayor){
                
                puntajeMayor = puntajeActual;
                mejorPosicion = jugador.numeroJugador;
			
            }
			
        }		
        
        return mejorPosicion;
	
    }
    
    
    /**
     * Cálculo de la mejor mano de entre los jugadores 
     * activos al final de las rondas de apuestas.
     * @param jugadores Jugadores en la mano.
     * @param posicionesActivas Posiciones con jugadores
     * que no han abandonado.
     * @return Posición del jugador en activo con la mejor mano.
     */
    public int calcularMejorMano(
    ArrayList<Jugador> jugadores, ArrayList<Integer> posicionesActivas){
		
        /*
         * Cálculo de la mejor mano, pero sólo entre los jugadores 
         * que tienen una posición activa al final de las rondas de
         * apuestas.
         */
        
        /*
         *Si no hay jugadores activos, no hay ganador.
         */
        if(posicionesActivas.isEmpty()){
            
            return -1;
            
        }
        
        int mejorPosicion = posicionesActivas.get(0);
        long puntajeMayor = 0;
        long puntajeActual = 0;
		
        for(Jugador jugador: jugadores){
            
            if(posicionesActivas.contains(jugador.numeroJugador)){

                puntajeActual = jugador.getMejorMano().getPuntaje();

                if(puntajeActual > puntajeMayor){

                    puntajeMayor = puntajeActual;
                    mejorPosicion = jugador.numeroJugador;

                }
    
            }
			
        }		
	
        return mejorPosicion;
	
    }
    
    
    /**
     * Desarrollo una ronda de apuestas.
     * @param apuestaMinima Apuesta que debe 
     * hacer cada jugador para seguir en la mano.
     * @param ronda Ronda a disputarse.
     * @param jugadores Jugadores en la partida.
     * @param posicionesActivas Posiciones en las
     * que los jugadores siguen en la mano.
     * @param primeroEnJugar Jugador con el primer turno.
     */
    private void desarrollarRonda(
    int apuestaMinima, int ronda,
    ArrayList<Jugador> jugadores, 
    ArrayList<Integer> posicionesActivas,  
    int primeroEnJugar){
        
        int posicion = 0;
        
        /*
         * Turno será el que vaya rotando para 
         * que cada jugador juegue.
         */
        int turno = primeroEnJugar;

        /*
         *Decisión que toma cada jugador.
         * 1 para apostar y 0 para retirarse.
         */
        int decision = -1;
        
        /*
         * Cada jugador va a decidir una sola vez en la ronda.
         * Así que el límite de jugadas es el número de jugadores
         * activos.
         */
        int limiteJugadas = posicionesActivas.size();

        for(int numeroDecisiones = 0; 
        numeroDecisiones < limiteJugadas; 
        numeroDecisiones++){
            
            //Posicion del jugador actual en la lista de jugadores activos.
            posicion = posicionesActivas.indexOf(turno);
            
            //Si el jugador está activo, juega.
            
            //if(posicionesActivas.contains(jugadores.get(turno).numeroJugador)){
            if(posicionesActivas.contains(turno)){    
                try {
                    Thread.sleep(800);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
                
                //El jugador decide que hacer y juega.
                decision = jugadores.get(turno).jugar(
                ronda, apuestaMinima, posicionesActivas.size());
                
                try {
                    Thread.sleep(800);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
                
                //Si el jugador se retira, se elimina de las posiciones activas.
                if(decision == 0){
                    
                    posicionesActivas.remove(posicionesActivas.indexOf(turno));
                    posicion--;
                
                } else {
                
                    /*
                    *Si el jugador apuesta pero su dinero es menor a la apuesta
                    * mínima, entonces se manda todo su dinero al bote.
                    */ 
                    if( jugadores.get(turno).dinero < apuestaMinima){
                        
                        this.dineroEnBote += jugadores.get(turno).dinero;
                        
                        jugadores.get(turno).setDinero(0);
                        
                        jugadores.get(turno).setDineroApostado(apuestaMinima, "Sube");               
                        
                    } else {
                        
                        this.dineroEnBote += apuestaMinima;
                        
                        jugadores.get(turno).setDinero(apuestaMinima, "Apuesta");
                        
                        jugadores.get(turno).setDineroApostado(apuestaMinima, "Sube");
                        
                    }
                
                }
                
                                
                System.out.printf("\nDinero en el bote: %d.\n", this.dineroEnBote);
                
            } else {
                numeroDecisiones--;
            }
            
            
            //El turno se le da al siguiente jugador activo.
            turno = posicionesActivas.get((posicion+1) % posicionesActivas.size());
            
        }
        
    }
    
    
    /**
     * Desarrollo de una ronda de apuestas.
     * @param apuestaMinima Apuesta mínima del juego.
     * @param limiteApuesta  Límite de apuesta del juego.
     * @param ronda Ronda de apuestas actual.
     * @param jugadores Jugadores en la patida.
     * @param posicionesActivas Números de los jugadores 
     * aún activos en la mano.
     */
    public void desarrollarMano(
    int apuestaMinima, int limiteApuesta, int ronda, 
    ArrayList<Jugador> jugadores, 
    ArrayList<Integer> posicionesActivas){
        
        /*
         * Se escoge al primer jugador en jugar.
         */
        
        int primeroEnJugar =
        (this.posicionBoton+1) % jugadores.size();
        
        /*
         * Dependiendo de la ronda de apuestas actual
         * el crupier realizará distintas acciones.
         */
        
        switch(ronda){
            
            /*
             * Para las primeras dos rondas
             * la apuesta es la mínima.
             */
            
            case(0):        
                
                /*
                 *Una vez que los jugadores tienen su
                 * par de cartas, lo miran.
                 */
                
                System.out.print("\nEmpieza la mano.\n");
                
                for(Jugador jugador: jugadores){
                    
                    jugador.getParCartas().getPuntaje();
                    
                }

                //Se desarrolla la ronda preflop.
                
                try {
                    Thread.sleep(1000);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
                
                this.desarrollarRonda(
                apuestaMinima, ronda,
                jugadores, posicionesActivas,
                primeroEnJugar
                );
            
                break;
                
            case(1):
                
                //El crupier revela el flop.

                System.out.print("\nEl crupier revela el flop\n");
                
                System.out.print(this.flop);
                
                for(Jugador jugador: jugadores){
                    

                     //Los jugadores ven el flop.
                    
                    jugador.setCartasTotales(this.flop);
                    
                    jugador.elegirMejorMano();
                    
                }
                
                try {
                    Thread.sleep(1000);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
                
                //Se desarrolla el juego post flop.
                
                this.desarrollarRonda(
                apuestaMinima, ronda,
                jugadores, posicionesActivas,
                primeroEnJugar
                );
                
                break;
                
            /*
             *Para las últimas dos ronda de apuestas, 
             *la apuesta es la máxima.
             */    
                
            case(2):
                
                //El crupier revela el turn.
                
                System.out.print("\nEl crupier revela el turn\n");
                    
                System.out.print(this.turn);
                
                for(Jugador jugador: jugadores){
                    
                    //Los jugadores ven el turn.
                    
                    jugador.setCartasTotales(this.turn);
                    
                    jugador.elegirMejorMano();
                    
                }
                
                try {
                    Thread.sleep(1000);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
                
                //Se desarrolla la tercera ronda de apuestas.
                
                this.desarrollarRonda(
                limiteApuesta, ronda, 
                jugadores, posicionesActivas,
                primeroEnJugar
                );
                
                break;
                
            case(3):
                
                //El crupier revela el river.
                                
                System.out.print("\nEl crupier revela el river\n");
                
                System.out.print(this.river);
                
                for(Jugador jugador: jugadores){
                    
                    //Los jugadores ven el river.
                    
                    jugador.setCartasTotales(this.river);
                    
                    jugador.elegirMejorMano();
                    
                }
                
                //Se desarrolla la última ronda de apuestas.
                
                try {
                    Thread.sleep(1000);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
                
                this.desarrollarRonda(
                limiteApuesta, ronda, 
                jugadores, posicionesActivas,
                primeroEnJugar
                );

                break;   
                 
        }

    }	

}