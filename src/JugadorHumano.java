/**
 * Jugador controlado por el usuario.
 */
public class JugadorHumano extends Jugador{
        
    
    /**
     * Constructor.
     * @param apodo Apodo del usuario.
     * @param numeroJugador Número que ocupa en la mesa,
     * otorgado al azar.
     * @param tipoJugador Tipo de jugador, siempre es 0 (Humano).
     * @param dinero Dinero con que empieza el juego.
     */
    public JugadorHumano(String apodo, int numeroJugador, 
    int tipoJugador, int dinero){
                   
        super(apodo, numeroJugador, tipoJugador, dinero);
        
    }
      
   
    /**
     * El usuario decide que hacer en su turno.
     * @param ronda Ronda en que se encuentra.
     * @param apuesta Apuesta por hacer para seguir en la mano.
     * @param numeroJugadoresActivos Jugadores activos en la mesa.
     * @return Decisión del usuario.
     */
    @Override
    public int jugar(int ronda, int apuesta, int numeroJugadoresActivos){
        
        int decision  = 0;
        
        /*
         * Si el usuario se queda sin dinero en medio de 
         * la mano se le da la indicación de seguir, por la
         * opción que tiene de ganar la mano.
         * Si los demás jugadores se han retirado de la mano,
         * se quedará esperando que se revelen todas las 
         * cartas comunales para recibir su bote.
         */
        
        if((this.dinero == 0)||
        (numeroJugadoresActivos == 1)){
            
            return this.apostar();
            
        } else {
        
            /*
             * El jugador toma la opción que desee.
             */
        
            System.out.printf("\nRonda: %d\n", ronda);
            System.out.printf("\nTu dinero: %d\n", this.dinero);
            System.out.printf("\nTienes que apostar:  %d    \n ", apuesta);

            if(Math.random() > 0.5){
                
                return this.apostar();
                
            } else {
                
                return this.retirarse();
                
            }
            
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
        "\n%s, tu posición en la mesa: %d",
        this.apodo, this.numeroJugador);
        
        cadena += 
        String.format("\nTienes %d de dinero\n", this.dinero);
        
        cadena += this.getParCartas().toString();
               
        return cadena;
        
    }

    
}