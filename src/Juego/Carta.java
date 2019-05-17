package Juego;

/**
  *Objetos con los que se juega al póker.
  */
public class Carta{
	

    /*
     *Dos atributos definen una carta, 
     *su valor y su palo. Ambos están 
     *representados numéricamente
     */
    
    /**
      * Valor de la carta. En la baraja francesa
      * aparecen los siguientes valores: 2, 3, 4, 
      * 5, 6, 7, 8, 9, 10, Jota, Reina, Rey, As.
      */
    private final int valor;
    
     /** 
      * Palo de la carta. En la baraja francesa
      * puede ser de picas, tréboles, corazones
      * o diamantes.
      */
    private final int palo;
    
    /**
     * Número de carta en la baraja francesa.
     */
    private final int numero;
	
    
    /**
     * Guarda los atributos valor y palo.
     * @param valor El número de la carta.
     * @param palo  El palo o tipo de carta.
     */
    public Carta(int valor, int palo){
                
        this.valor = valor;
        this.palo = palo;
        
        /*
         *El as puede representarse con el
         *número 1 o con el 14. Para su 
         *número se ocupará el 1, asi como
         *para una mano de poker con una
         *escalera del as al cinco. Para lo
         *demás se usará el 14.
         */
        
        if(valor ==14){
            
            this.numero = 13*(palo-1) + 1;  
            
        } else {
            
            this.numero = 13*(palo-1) + valor;
            
        }
        
    }
	

    /**
     * @return Valor.
     */
    public int getValor(){
        
        return this.valor;
    
    }
    
    
    /**
     * @return Palo.
     */
    public int getPalo(){
        
        return this.palo;
    
    }

    
    /**
     * @return Número.
     */
    public int getNumero(){
        
        return this.numero;
        
    }
    
    
    /**
     * @return Valor de la carta.
     */
    public String valorToString(){
        
        /*
         *Para la baraja a ocupar, los valores
         *del 11 al 14 representarán las figuras 
         *jota, reina, rey y as.
         */
        
        switch(this.valor){
            
            case(14):
                return "As";
            case(13):
                return "Rey";
            case(12):
                return "Reina";
            case(11):
                return "Jota";
            default:
                return String.valueOf(this.valor);
                
        }        
        
    }
    

    /**
     * @return Palo de la carta.
     */
    public String paloToString(){
        
        /*
         *Los palos del 1 al 4 representan los
         *palos de picas, tréboles, diamantes 
         *y corazones.
         */
        
        switch(this.palo){
            
            case(1):
                return "picas";
            case(2):
                return "tréboles";
            case(3):
                return "corazones";
            case(4):
                return "diamantes";
            default:
                return "flechas";
                
        }        
        
    }
    

    /**
     * Información de la carta 
     * usando los valores, figuras
     * y palos de la baraja francesa.
     * @return El valor y el palo de la carta.
     */
    @Override
    public String toString() {
        
        return this.valorToString() + " de " + this.paloToString();
        
    }
    
    
}