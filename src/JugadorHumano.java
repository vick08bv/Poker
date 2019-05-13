import java.util.Scanner;
/**
 * Jugador controlado por el usuario.
 */
public class JugadorHumano extends Jugador{
        
    static Scanner lector;
    
    static {
        
        lector = new Scanner(System.in);
        
    }
    
    
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
        
        String decision  = "";
        
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
            
            if(numeroJugadoresActivos == 1){
            
                System.out.print("\nTus rivales se han retirado "
                + "de la mano. \nVas a ganarla.\n");
                
                try {
                    Thread.sleep(300);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
            
            } else {
                
                System.out.println("\nTe has quedado sin dinero\n"
                + "pero aún puedes ganar la mano\ny permanecer "
                + "en el juego, \nespera el resultado");

                try {
                    Thread.sleep(300);
                } catch (Exception e){
                    System.out.println("Ocurrió un error");
                }
                
            }
            
            return this.apostar();
            
        } else {
        
            /*
             * El jugador toma la opción que desee.
             */

            System.out.print(this.toString());
            System.out.printf("\nJuega. Presiona enter para apostar.\n");
            System.out.printf("\nIngresa cualquier indicación para retirarte.\n");
             System.out.printf("\nIngresa As para abandonar.\n");
            
            decision = (String) JugadorHumano.lector.nextLine();

            if(decision.equals("As")){
                
                System.exit(0);
                
                return 1;
                
            } else if (decision.equals("")){
                
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
        
        cadena += 
        String.format("\nTus cartas son: %s\n",
        this.getParCartas().toString());
               
        return cadena;
        
    }

    
}