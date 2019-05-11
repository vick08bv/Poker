import java.util.ArrayList;


/**
 * Conjunto de cartas que se revelan en la 
 * mesa y que puede usar cada jugador para
 * construir su mejor mano.
 */
public class CartasComunales extends ConjuntoCartas {
 
    
    /**
     * Constructor.
     * @param cartas Lista de cartas. 
     */
    public CartasComunales(ArrayList<Carta> cartas){
    
        super(cartas);
    
    }
    
    
    /**
     * En el póker existen tres rondas (o calles) 
     * en donde se revelan las cartas, el flop, 
     * el turn y el river.
     * @return La calle a la que pertenecen las cartas.
     */
    private String calleToString(){
        
        /*
         *El flop cuenta con tres cartas.
         *El turn (cuarta calle) revela una carta más.
         *Se representa con esa carta y las tres del flop.
         *El river (quinta calle) revela la última carta, pero
         *se representa con las cinco cartas en la mesa. 
        */
        
        switch(this.cartas.size()){
            
            case (3):
                return "   Flop:";
            case(4):
                return "   Turn:";
            case(5):
                return "   River:";
            default:
                return "";
            
        }
        
    }
    
    
    /**
     * @return Información de las cartas comunales. 
     */
    public String toString(){
    
        return  "\nCartas comunales\n" +
        this.calleToString() + super.toString();
    
    }
    
    
}