/**
 * Jugador simulado por la máquina.
 */
public class JugadorMaquina extends Jugador{
    
    
    /**
     * Constructor.
     * @param apodo Apodo que tendrá el jugador, elegido al azar.
     * @param numeroJugador Número con que empieza, al azar.
     * @param tipoJugador Tipo de jugador, al azar.
     * @param dinero Dinero inicial que tendrá.
     */
    public JugadorMaquina(
    String apodo, int numeroJugador, 
    int tipoJugador, int dinero
    ){
            
        super(apodo, numeroJugador, tipoJugador, dinero);        
             
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
   @Override
    public int jugar(int ronda, int apuesta, 
    int numeroJugadoresActivos){
        
        /*
         * Si el jugador se queda sin dinero en medio de 
         * la mano se le da la indicación de seguir, por la
         * opción que tiene de ganar la mano.
         * Si los demás jugadores se han retirado de la mano,
         * se quedará esperando que se revelen todas las 
         * cartas comunales para recibir su bote.
         */
        
        
        if((this.dinero == 0)||
        (numeroJugadoresActivos == 1)){
            
            return this.apostar();
            
        }
        
        /*
         * Para tomar decisiones, el jugador toma
         * en cuenta la información que tiene, sobre
         * sus cartas y sobre el dinero que tiene.
         */
        
        long puntajeAlcanzado = 0;
        long puntajeMaximoPosible = 0;
        int cifrasPuntaje = 0;
        int cifrasMaximo = 0;
        
        double estimulo = 0;
        double estimuloPuntaje = 0;

        /* 
         * El tipo de jugador que tiene asignado (1-10), 
         * determinará cómo va a jugar; más arriesgado
         * entre mayor sea este número.
         * El estimulo por el tipo de jugador 
         * tiene un rango que va de 0.5 a 5.
        */
        double estimuloTipoJugador = this.getTipoJugador()/2;
        
        /*
         * Rango para el estimulo por el dinero inicial: de 0 a 5.
         */
        double estimuloDinero = 
        5*(this.dinero/this.dineroInicial);

        /*
         * El rango para el estimulo por la apuesta sería de 0 a 5. 
         */
        double estimuloApuesta = 
        200*(apuesta/this.dinero);
        
        if(estimuloApuesta > 5){
            estimuloApuesta = 5;
        }
        
        if(this.getCartasTotales().cartas.isEmpty()){
            
            /*
            Rangos del estimulo (preflop): de 8.5 a 9.4
            */
            
            puntajeAlcanzado = 250*this.getParCartas().getPuntaje();
            puntajeMaximoPosible = (long) Math.pow(10, 12); 
            
        } else {
        
            puntajeAlcanzado = this.getMejorMano().getPuntaje();
            puntajeMaximoPosible = this.calcularPuntajeMaximo();
            
        }
        
        cifrasPuntaje = (int) (Math.log10(puntajeAlcanzado) ) + 1;
        cifrasMaximo = (int) (Math.log10(puntajeMaximoPosible) ) + 1;
        
        /*
        Suma ponderada de las puntuaciones reales y máxima
        posible en sus formas reducidas (número de cifras más 
        sus dos primeras cifras sobre 100. Ej. 67839 en su forma
        reducida vale 5.67 ).
        Rango para ambos puntajes, de 7.39 a 18.16. 
        */
        
        estimuloPuntaje = 
        9*(cifrasPuntaje + 
        ((puntajeAlcanzado) / (Math.pow(10, cifrasPuntaje))));
     
        estimuloPuntaje += 
        (cifrasMaximo + 
        ((puntajeMaximoPosible) / (Math.pow(10, cifrasMaximo))));
        
        estimuloPuntaje /= 10;
                
        
        /*Suma del puntaje del par de cartas entre 100000.
        Rango de 0.86 a 6.04
        */
        
        estimuloPuntaje += this.getParCartas().getPuntaje()/100000;

        /*
        Rango para el estimulo total: de 16.7 a 43.6
        */
        estimulo = estimuloPuntaje + estimuloTipoJugador +
        estimuloDinero + estimuloApuesta;

        /**
         * Estimulo azaroso que depende del tipo de jugador (-10,10)
         */ 
        estimulo += (Math.random()-Math.random())*this.getTipoJugador();
            
        System.out.println(estimulo);
        
        /* 
         * Si el estimulo que recibe el jugador no supera el 
         * umbral de 25, se va a retirar.
         */
        
        if(estimulo < 20 ){

            return this.retirarse();

        } else {

            return this.apostar();
            
        }
        
    }
    
    
    
    /**
     * Información del jugador.
     * @return Cadena.
     */
    @Override
    public String toString(){
        
        String cadena = 
        String.format(
        "\nJugador en la posición %d: %s",
        this.numeroJugador,this.apodo);
        
        cadena += 
        String.format("\nDinero actual: %d\n", this.dinero);
               
        return cadena;
        
    }

             
}