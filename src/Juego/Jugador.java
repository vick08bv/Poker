package Juego;

import Juego.ConjuntoCartas;
import Juego.CartasComunales;
import Juego.CartasBolsillo;
import Juego.Carta;
import Juego.Baraja;
import java.util.ArrayList;


/**
 * Jugador que participa en el juego.
 */
public abstract class Jugador{
	
    /**
     * Apodo con el que se conoce al jugador.
     */
    public final String apodo;
    
    /**
     * Número de jugador y posición en la mesa
     * que ocupa.
     */
    public int numeroJugador;
    
    /**
     * Tipo de jugador; define cómo jugará, 
     * nunca cambia.
     */
    private final int tipoJugador;
    
    /**
     * Dinero con que empieza el juego.
     */
    public int dineroInicial;
    
    /**
     * Dinero que posee.
     */
    public int dinero;
    
    /**
     * Dinero que tiene apostado en la mano.
     */
    public int dineroApostado;
    
    /**
     * Cartas personales que posee.
     */
    private CartasBolsillo parCartas;
    
    /**
     * Unión de las cartas que tiene y 
     * de las comunales.
     */
    private ConjuntoCartas cartasTotales;
    
    /**
     * Mejor combinación de 5 cartas que
     * puede formar.
     */
    private Mano mejorMano;

    
    /**
     * Constructor.
     * @param apodo Apodo que tendrá el jugador.
     * @param numeroJugador Número con que empieza
     * @param tipoJugador Tipo de jugador.
     * @param dinero Dinero inicial que tendrá.
     */
    public Jugador(String apodo, int numeroJugador, 
    int tipoJugador, int dinero){
	
        this.apodo = apodo;
        this.numeroJugador = numeroJugador;
        
        this.tipoJugador = tipoJugador;
        
        this.dineroInicial = dinero;
        this.dinero = dinero;
        
        /*
         * Los conjuntos de cartas se quedan vacíos, 
         * durante el juego, se le brindarán las cartas.
         */
        
        this.parCartas = new CartasBolsillo (new ArrayList<>(2));
        this.cartasTotales = new ConjuntoCartas (new ArrayList<>(7));
        this.mejorMano = new Mano (new ArrayList<>(5));
	
    }
	
	
    /**
     * Cambia la posición del jugador en la mesa.
     * @param nuevoNumero Número que tendrá.
     */
    public void setNumeroJugador(int nuevoNumero){
        
        this.numeroJugador = nuevoNumero;
        
    }
	
	
    /**
     * Cambia la posición del jugador en la mesa.
     * @param posicionesLibres Lista de posiciones 
     * desocupadas en la mesa.
     */
    public void setNumeroJugador(ArrayList<Integer> posicionesLibres){
        
        /*
         * De acuerdo con la lista de jugadores eliminados
         * se calcula la nueva posición que debe tomar el
         * jugador, recorriéndose cada vez que haya una
         * posición disponible antes que la de él.
         */
        
        int jugadoresYaEliminados = 0;
		
        for(int posicion: posicionesLibres){
            
            if(posicion-jugadoresYaEliminados < this.numeroJugador){
		
                this.numeroJugador--;	
		
                jugadoresYaEliminados++;
			
            }
        
        }
				
    }
    
    
    /**
     * Actualiza el dinero del jugador.
     * @param dinero Nueva cantida de 
     * dinero que tendrá.
     */
    public void setDinero(int dinero){
        
        this.dinero = dinero;
        
    }
    
    
    /**
     * Actualiza el dinero del jugador.
     * @param dinero Cantidad de dinero que
     * el jugador apuesta o gana.
     * @param accion Apostar o ganar el bote.
     */
    public void setDinero(int dinero, String accion){
        
        switch (accion) {
            case "Apuesta":
                this.dinero -= dinero;
                break;
            case "Gana":
                this.dinero += dinero;
                break;
        }
        
    }
    
    
    /**
     * Se actualiza el dinero apostado en la mano.
     * @param dinero Dinero que tiene apostado.
     */
    public void setDineroApostado(int dinero){
        
        this.dineroApostado = dinero;
        
    }
    
    
    /**
     * Se actualiza el dinero apostado en la mano.
     * @param dinero Dinero que apuesta.
     * @param accion Apuesta.
     */
    public void setDineroApostado(int dinero, String accion){
        
        this.dineroApostado += dinero;
    
    }
    

    /**
     * Borra las cartas personales.
     */
    public void setParCartas(){
        
        this.parCartas.cartas.clear();
        
    }
		
    
    /**
     * Cambia las cartas personales.
     * @param parCartas Cartas que recibe del crupier.
     */
    public void setParCartas(CartasBolsillo parCartas){
		
        this.parCartas = parCartas;
		
    }
    
    
    /**
     * Borra las cartas totales.
     */
    public void setCartasTotales(){
        
        this.cartasTotales.cartas.clear();
        
    }

    /**
     * Establece las cartas totales con
     * las que dispone el jugador.
     * @param cartasAbiertas Cartas comunales
     * reveladas en la mesa.
     */
    public void setCartasTotales(CartasComunales cartasAbiertas){
		
        this.cartasTotales.cartas.clear();
        
        this.cartasTotales.cartas.add(this.parCartas.cartas.get(0));
        this.cartasTotales.cartas.add(this.parCartas.cartas.get(1));
		
        for(Carta cartaComunal: cartasAbiertas.cartas){	
            
            this.cartasTotales.cartas.add(cartaComunal);	
	
        }
		
    }
	
    
    /**
     * Borra la mejor mano.
     */
    public void setMejorMano(){
        
        this.mejorMano.cartas.clear();
        
    }
    
    
    /**
     * Calcula todas las combinaciones
     * de manos posibles de entre las cartas
     * totales que posee.
     * @return Lista con las manos posibles.
     */
    public ArrayList<Mano> calcularManosPosibles(){
                
        ArrayList<Mano> manosPosibles = new ArrayList<>(25); 
        ArrayList<Carta> manoActual = new ArrayList<>(5);
        
        /*
         * De las cartas totales que posee el jugador, 
         * tomar 5 de ellas le forma una posible mano. 
         * Debe considerar todas las posibilidades
         * (hasta 21 para el river).
         */
        
        for(int h=0; h < (cartasTotales.cartas.size()-4); h++){
            for(int i = h+1; i < (cartasTotales.cartas.size()-3); i++){
                for(int j = i+1; j < (cartasTotales.cartas.size()-2); j++){
                    for(int k = j+1; k < (cartasTotales.cartas.size()-1); k++){
                        for(int l = k+1; l < cartasTotales.cartas.size(); l++){
						
                            manoActual.clear();
                            
                            manoActual.add(cartasTotales.cartas.get(h));
                            manoActual.add(cartasTotales.cartas.get(i));
                            manoActual.add(cartasTotales.cartas.get(j));
                            manoActual.add(cartasTotales.cartas.get(k));
                            manoActual.add(cartasTotales.cartas.get(l));
                            
                            manosPosibles.add(new Mano(manoActual));
							
                        } 
                    }		
                }
            }	
        }
        
        return manosPosibles;
        
    }
    

    /**
     * Calcula la mano con mejor puntuación.
     */
    public void elegirMejorMano(){
        
        ArrayList<Mano> manosPosibles = this.calcularManosPosibles(); 
        
        int indiceMayor = 0;
        long puntajeMayor = 0;
        long puntajeActual = 0;
	
        /*
         * Para todas las manos posibles que puede
         * formar el jugador, les calcula su puntaje.
         */
        
        for(int m = 0; m < manosPosibles.size(); m++){
			
            manosPosibles.get(m).establecerPuntaje();
            puntajeActual = 
            manosPosibles.get(m).getPuntaje();
			
            /*
             * Cada que encuentra un puntaje más alto
             * considera es mano como la mejor.
             */
            
            if(puntajeActual >= puntajeMayor){
		
                puntajeMayor = puntajeActual;
                indiceMayor = m;
            
            }
			
       }
        
        /*
         * Se queda con la mejor mano.
         */
        
        this.mejorMano =  manosPosibles.get(indiceMayor);	
    
    }
    
    
    /**
     * Calcula el puntaje máximo que puede
     * alcanzar en la mano.
     * @return Puntaje máximo alcanzado.
     */
    public long calcularPuntajeMaximo(){
        
        /*
         * Cuando aún faltan por revelarse
         * dos cartas (o una) en la mesa, el jugador 
         * se adelanta para ver las posibilidades
         * de que su mano actual mejore.
         */
        
        Baraja cartasBaraja = new Baraja(Baraja.barajaFrancesa());
        
        long puntajeActual = 0;
        long mejorPuntaje = 0;
        
        if(this.cartasTotales.cartas.size() == 5){
            
            /*
            * Si faltan dos cartas por revelarse, el jugador 
            * toma en cuenta todas las cartas que no 
            * han salido, es decir, las que no tiene o están
            * en la mesa. Considera como suyas  las
            * combinaciones de estas cartas dos a dos 
            * para ver cuáles le sirven y cuánto puede 
            * mejorar su puntuación.
            */
            
            for(int i = 0; i < cartasBaraja.cartas.size() - 1; i++){
                for(int j = 0; j < cartasBaraja.cartas.size(); j++){

                    if(
                    (this.cartasTotales.cartas.contains(cartasBaraja.cartas.get(i))) ||
                    (this.cartasTotales.cartas.contains(cartasBaraja.cartas.get(j)))
                    ){  } else {
                        
                        this.cartasTotales.cartas.add(cartasBaraja.cartas.get(i));
                        this.cartasTotales.cartas.add(cartasBaraja.cartas.get(j));
                        
                        this.elegirMejorMano();
                        
                        puntajeActual = this.mejorMano.getPuntaje();
                        
                        if(puntajeActual > mejorPuntaje){
                            mejorPuntaje = puntajeActual;
                        }
                        
                        this.cartasTotales.cartas.remove(cartasBaraja.cartas.get(i));
                        this.cartasTotales.cartas.remove(cartasBaraja.cartas.get(j));
                        
                    }
 
                }

            }
            
            /*
             * Después de que analiza sus posibilidades,
             * retoma su mano actual para segui tomando
             * decisiones.
             */
            
            this.elegirMejorMano();
            
            return mejorPuntaje;
            
        } else if (this.cartasTotales.cartas.size() == 6){
            
            /*
            * Si faltan sólo una carta por revelarse, el jugador 
            * toma en cuenta todas las cartas que no 
            * han salido, es decir, las que no tiene o están
            * en la mesa. Considera como suyas cada carta
            * para ver cuáles le sirven y cuánto puede 
            * mejorar su puntuación.
            */
            
            for(int i = 0; i < cartasBaraja.cartas.size() - 1; i++){
                
                if(
                (this.cartasTotales.cartas.contains(cartasBaraja.cartas.get(i)))
                ){  } else {
                    
                    this.cartasTotales.cartas.add(cartasBaraja.cartas.get(i));
                    
                    this.elegirMejorMano();
                    
                    puntajeActual = this.mejorMano.getPuntaje();
                        
                    if(puntajeActual > mejorPuntaje){
                            mejorPuntaje = puntajeActual;
                        }
                    
                    this.cartasTotales.cartas.remove(cartasBaraja.cartas.get(i));
                    
                }
                
            }
            
            /*
             * Después de que analiza sus posibilidades,
             * retoma su mano actual para segui tomando
             * decisiones.
             */
            
            this.elegirMejorMano();
            
            return mejorPuntaje;
   
        } else {
            
            /*
             * Cuando el river ya se reveló ya no hay
             * más opciones y no puede mejorar su 
             * mano aún más.
             */
            
            return this.mejorMano.getPuntaje();
        }

    }
    
            
    /**
     * El jugador se retira de la mano actual.
     * @return Indicación de retirarse.
     */
    public int retirarse() {
        
        System.out.printf("\nJugador en la posición %d, "
        + "%s, se retira de la mano.\n",this.numeroJugador,this.apodo);
        
        return 0;
    }
    
    
    /**
     * El jugador sigue en la mano actual.
     * @return Indicación de apostar para seguir jugando. 
     */
    public int apostar() {
        
        System.out.printf("\nJugador en la posición %d,  "
        + "%s, hace su apuesta.\n",this.numeroJugador,this.apodo);

        return 1;
        
    }
    
 
    /**
     * El jugador decide apostar o retirarse 
     * cuando llegue su turno de jugar.
     * @param ronda Ronda actual que juega.
     * @param apuesta Apuesta que debe hacer 
     * para seguir en la mano.
     * @param numeroJugadoresActivos 
     * Número de jugadores que siguen en la mano.
     * @return Decisión que ha tomado.
     */
    public abstract int jugar(int ronda, 
    int apuesta, int numeroJugadoresActivos);
    
    
    /**
     * @return Par de cartas del jugador.
     */
    public CartasBolsillo getParCartas(){
        
        return this.parCartas;
        
    } 
    
    
    /**
     * 
     * @return Cartas totales del jugador.
     */
    public ConjuntoCartas getCartasTotales(){
        
        return this.cartasTotales;
        
    }
    
    
    /**
     * @return Mejor mano del jugador.
     */
    public Mano getMejorMano() {
        
        return this.mejorMano;
        
    }
    
    
    /**
     * @return Tipo de jugador.
    */
    public int getTipoJugador(){
        
        return this.tipoJugador;
        
    }
    
    /**
     * Información del estado del jugador.
     * @return Cadena.
     */
    public abstract String toString();
    
		
}