import java.util.ArrayList;


/**
  * Conjunto con todas las cartas con las
  * que se juega. En 
  * el póker, es la baraja francesa.
  */
public class Baraja extends ConjuntoCartas{
	
    
    /** 
     *Crea una lista de cartas con 
     *las cartas de  la baraja francesa. 
     * @return ArrayList de cartas.
     */
    public static ArrayList<Carta> barajaFrancesa(){
        
        /*
         *Una baraja inglesa o francesa 
         *se compone de 52 cartas divididas 
         *en 4 palos, con 13 cartas cada uno.
         */

        ArrayList<Carta> naipes = new ArrayList<>(52);
        
        for(int valor = 2; valor <= 14; valor++){	
            
            for(int palo = 1; palo <= 4; palo++){
		
                naipes.add(new Carta(valor, palo));
            
            }
        
        }	
        
        return naipes;
	
    }

    
    /**
     * Constructor. Guarda todas las cartas.
     * @param cartas Lista con cartas. 
     */
    public Baraja(ArrayList <Carta> cartas){
        
        super(cartas);
        
    }
    
    
    /**
     * Representación de todas las 
     * cartas que componen la baraja.
     * @return Cadena. 
     */
    @Override
    public String toString() {
        return "\nBaraja con 52 cartas\n" + super.toString(); 
    }
    
    	
}	