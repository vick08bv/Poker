import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Collections;


/**
 * Conjunto de cartas que forma un jugador 
 * a partir de sus cartas de bolsillo y las cartas
 * comunales que aparecen en la mesa.
 */
public class Mano extends ConjuntoCartas{
	
    /**
     * Para comparar dos manos se usa un
     * sistema de puntuación; el puntaje de la mano 
     * se guardará aquí.
     */
    private long puntaje;
    
    /**
     * Guarda el tipo de mano que se tiene.
     * P. ej. doble par o escalera.
     */
    private int tipoDeMano;

    /**
     * Una copia de la lista de valores, pero
     * ordenados por su importancia en la mano.
     */
    private ArrayList<Integer> valoresPuntaje;
	
	
    /**
     * Constructor.  
     * @param cartas Lista de cartas. 
     */
    public Mano(ArrayList<Carta> cartas){
       
        super(cartas);
        
        this.puntaje = 0;
        this.tipoDeMano = 0;
        this.valoresPuntaje = null;
    
    }
		
	
    /**
     * Establece la lista de valores por importancia. 
     * No se reciben parámetros si están ordenados.
     */
    private void reordenarValores(){
        
        this.valoresPuntaje = 
        new ArrayList<>(
        Arrays.asList(
        this.getValoresOrden().get(0),this.getValoresOrden().get(1),
        this.getValoresOrden().get(2),this.getValoresOrden().get(3),
        this.getValoresOrden().get(4)
        ));
	
    }
	
	
    /**
     * Establece la lista de valores por importancia. 
     * Recibe los valores ya ordenados para copiarlos.
     * @param valor1 Valor más importante en la mano.
     * @param valor2
     * @param valor3
     * @param valor4
     * @param valor5 Valor menos importante en la mano.
     */
    private void reordenarValores(
    int valor1, int valor2, int valor3, int valor4, int valor5){
        
        this.valoresPuntaje = 
        new ArrayList<>(Arrays.asList(valor1,valor2,valor3,valor4,valor5));
    
    }
    
	
    /**
     * Regresa el número de veces que se repite 
     * un valor dado en la mano.
     * @param valor
     * @return Ocurrencias del valor dado.
     */
    private int ocurrencias(int valor){
        
        return Collections.frequency(this.getValoresOrden(), valor);
    
    }
	
	
    /**
     * Se asigna el tipo de mano como desconocido. 
     */
    private void iniciarCalculoMano(){
		
        this.tipoDeMano = 0;
        
    }
	
	
    /**
     * Verifica si la mano tiene una escalera y de que tipo.
     * Escalera real, escalera de color o escalera "simple".
     */
    private void sonEscaleras(){
        
        /*
         *Podemos encontrar varios tipos de 
         *escaleras, la escalera real, con valor de 1, 
         *la escalera de color, con valor de 2 
         *y la escalera, con valor de 6.
         */
	
        /*
         *Una prueba rápida: si algún valor se repite
         *en la mano, no se puede formar ninguna 
         *escalera y no se verifica nada más.
         */
        
        if(getValoresSinRepetir().size() == 5){
		
            if(
            this.getValoresOrden().equals(
            new ArrayList<>(Arrays.asList(14,5,4,3,2)))
            ){	

                /*
                 *As,2,3,4,5 es la escalera más pequeña;
                 *en este caso el valor del as se toma como uno.
                 */
                
                this.reordenarValores(5,4,3,2,1);

                if(this.getPalosSinRepetir().size() == 1){
                    
                    /*
                     *Si hay color entonces tenemos 
                     *una escalera de color.
                     */
                    
                    this.cambiarTipoDeMano(2);
                
                } else {
                    
                    /*
                     *La escalera más pequeña, del 
                     *As al 5 y sin color.
                     */
                    
                    this.cambiarTipoDeMano(6);
                }

            } else {

                /*
                 *Todas las escaleras tienen 
                 *números consecutivos, aprovechamos
                 *que los tenemos ya ordenados
                 *(en valoresOrden) para verificar esta condición.
                 */
                
                for(int i = 14;i >= 6;i--){	

                    if(
                    this.getValoresOrden().equals(
                    new ArrayList<>(Arrays.asList(i,i-1,i-2,i-3,i-4)))
                    ){

                    this.reordenarValores();
						
                        if(i == 14){
                        
                            /*
                             *La escalera más grande, del As al 10.
                             */
                            
                            if(this.getPalosSinRepetir().size() == 1){
				
                                /*
                                 *Esta es la escalera real, del As al 10
                                 *y color.
                                 */
                                
                                this.cambiarTipoDeMano(1);
							
                            } else {
		
                                /*
                                 *Escalera grande pero sin color.
                                 */
                                
                                this.cambiarTipoDeMano(6);
							
                            }
						
                        } else {
			
                            /*
                             *Para escaleras "medianas" verificamos
                             *si son de color.
                             */
                            
                            if(this.getPalosSinRepetir().size() == 1){
								
                                this.cambiarTipoDeMano(2);
							
                            } else {
								
                                this.cambiarTipoDeMano(6);		
				
                            }
						
                        }
											
                    } 
		
                }	
			
            }
		
        }		
	
    }
	
	
    /**
      * Verifica si la mano es de color (un solo palo).
      */
    private void esColor(){
		
        /*
         *Si todas las cartas son del mismo palo, 
         *entonces la mano es de color.
         */
        
        if(
        (this.getPalosSinRepetir().size() == 1) &&
        (this.tipoDeMano == 0)
        ){
			
            this.reordenarValores();
            this.cambiarTipoDeMano(5);
			
        }
		
    }

    
    /**
      * Verifica si la mano tiene un póker.
      */
    private void esPoker(){
	
        /*
         *Si sólo hay dos valores en la mano
         *y si uno de ellos se repite cuatro veces
         *entonces se tiene un póker, donde las
         *cartas más importante son las que 
         *comparten valor.
         */
        
        
        if(this.getValoresSinRepetir().size() == 2){
			
            int mayorValor = this.getValoresOrden().get(0);
            int menorValor = this.getValoresOrden().get(4);
            
            if(this.ocurrencias(mayorValor) == 4){
                
                /*
                 *Las cartas que forman póker pueden ser
                 *más grandes en valor que la quinta carta.
                 */
                
                this.reordenarValores();
                
                this.cambiarTipoDeMano(3);
				
            } else if(this.ocurrencias(menorValor) == 4){
			
                /*
                 *O pueden ser menores que ella.
                 */
                
                this.reordenarValores(
                menorValor,menorValor,menorValor,menorValor,mayorValor);
				
                this.cambiarTipoDeMano(3);

            }
		
        }

    }
	
	
    /**
      * Verifica si la mano tiene un tercia y un par.
      */
    private void esFull(){
		
        /*
         *En el full, también se cuentan con sólo
         *dos valores en la mano, pero ahora, uno
         *de ellos se repite tres veces y el otro, dos.
         */
        
        if(this.getValoresSinRepetir().size() == 2){
			
            int mayorValor = this.getValoresOrden().get(0);
            int menorValor = this.getValoresOrden().get(4);
			
            if(this.ocurrencias(mayorValor)==3){
			
                /*
                 *Se puede repetir tres veces el valor 
                 *más alto, p. ej. 8,8,8,2,2.
                 */
                
                this.reordenarValores();
                    this.cambiarTipoDeMano(4);
				
            } else if(this.ocurrencias(menorValor) == 3){
			
                /*
                 *También se puede repetir tres veces
                 el valor más bajo.
                 */
                
                this.reordenarValores(
                menorValor,menorValor,menorValor,mayorValor,mayorValor);
                this.cambiarTipoDeMano(4);
	
            }
		
        }
	
    }
	
	
     /**
      * Verifica si la mano tiene una tercia.
      */
    private void esTercia(){
        
        /*
         *En la tercia, uno de los valores
         *se repite tres veces, mientras 
         *que los otros dos no se repiten.
        */
	
        if(this.getValoresSinRepetir().size()==3){
			
            int mayorValor = this.getValoresOrden().get(0);
            int mediano = this.getValoresOrden().get(2);
            int menorValor = this.getValoresOrden().get(4);
			
            if(this.ocurrencias(mayorValor) == 3){
			
                /*
                 *Tercia del valor más alto.
                */
                
                this.reordenarValores();
                this.cambiarTipoDeMano(7);
				
            } else if(this.ocurrencias(menorValor)==3){
			
                /*
                 *Tercia del valor intermedio,
                 *el valor más alto ya no es
                 *el más importante.
                */
                
                this.reordenarValores(
                menorValor, menorValor, menorValor, 
                mayorValor,this.getValoresOrden().get(1));
                this.cambiarTipoDeMano(7);	
				
            } else if(this.ocurrencias(mediano) == 3){
			
                /*
                 *Tercia del valor más bajo.
                */
                
                this.reordenarValores(
                mediano,mediano,mediano,
                mayorValor,menorValor);
                this.cambiarTipoDeMano(7);
			
            }
		
        }
		
    }
	
	
    /**
     * Verifica si la mano tiene un boble par.
     */
    private void esDoblePar(){
		
        /*
         *Si se dan dos repeticiones de
         *valores, pero la mano no es tercia
         *entonces lo único que puede pasar
         *es que dos valores distintos se repitan 
         *dos veces y el tercero no lo haga, 
         *por lo que la mano es un doble par.
         */
        
        if(
        (this.getValoresSinRepetir().size() == 3) &&
        (this.tipoDeMano == 0)
        ){
                
            /*
             *Consideramos los tres valores existentes
             *y sus posibles acomodos en los 
             *valores ordenados, para decidir 
             *cuál es el valor más importante.
             */
            
            if (
            (this.ocurrencias(this.getValoresOrden().get(0)) == 2) &&
            (this.ocurrencias(this.getValoresOrden().get(2)) == 2) 
            ){
			
                this.reordenarValores();
                this.cambiarTipoDeMano(8);
		
            } else if (
            (this.ocurrencias(this.getValoresOrden().get(0)) == 2) &&
            (this.ocurrencias(this.getValoresOrden().get(2)) == 1) 
            ){
		
                this.reordenarValores(
                this.getValoresOrden().get(0), this.getValoresOrden().get(1), 
                this.getValoresOrden().get(3), this.getValoresOrden().get(4), 
                this.getValoresOrden().get(2)
                );
                this.cambiarTipoDeMano(8);	
		
            } else {
				
                this.reordenarValores(
                this.getValoresOrden().get(1), this.getValoresOrden().get(2), 
                this.getValoresOrden().get(3), this.getValoresOrden().get(4), 
                this.getValoresOrden().get(0)
                );
                this.cambiarTipoDeMano(8);	
				
            }
				
        }
        
    }
	

    /**
     * Verifica si la mano tiene un par.
     */
    private void esPar(){
        
        /*
         *Al igual que con el póker, el full,
         *la tercia y el doble par, cuando
         *tenemos repeticiones de valores,
         *(en el caso del par, sólo un valor 
         *se repite dos veces), hallamos el
         *acomodo de estos valores, para
         *clasificarlos por importancia.
         */
	
        if(this.getValoresSinRepetir().size() == 4){
			
            if(this.ocurrencias(this.getValoresOrden().get(0)) == 2){
			
                this.reordenarValores();
                this.cambiarTipoDeMano(9);	
				
            } else if (this.ocurrencias(this.getValoresOrden().get(1)) == 2){
			
                this.reordenarValores(
                this.getValoresOrden().get(1), this.getValoresOrden().get(2), 
                this.getValoresOrden().get(0), this.getValoresOrden().get(3), 
                this.getValoresOrden().get(4)
                );
                this.cambiarTipoDeMano(9);	
			
            } else if (this.ocurrencias(this.getValoresOrden().get(2)) == 2){
			
                this.reordenarValores(
                this.getValoresOrden().get(2), this.getValoresOrden().get(3), 
                this.getValoresOrden().get(0),this.getValoresOrden().get(1), 
                this.getValoresOrden().get(4)
                );
                this.cambiarTipoDeMano(9);
			
            } else {
			
                this.reordenarValores(
                this.getValoresOrden().get(3), this.getValoresOrden().get(4), 
                this.getValoresOrden().get(0), this.getValoresOrden().get(1), 
                this.getValoresOrden().get(2)
                );
                this.cambiarTipoDeMano(9);
			
            }
            
        }
			
    }
	
	
    /**
     * Verifica si la mano sólo tiene una carta alta.
     */
    private void esCartaAlta(){	
        
        /*
         *La mano no tiene nada
         *interesante, cuando
         *sus  cartas tienen todas 
         *valores distintos y además
         *no forman color. Los valores
         *por importancia respetan el
         *orden de mayor a menor.
         */
	
        if(this.tipoDeMano == 0){
		
                this.reordenarValores(
                this.getValoresOrden().get(0), this.getValoresOrden().get(1), 
                this.getValoresOrden().get(2), this.getValoresOrden().get(3), 
                this.getValoresOrden().get(4)
                );
            this.cambiarTipoDeMano(10);	
	
        }
    
    }
	
	
    /**
     * Cambia el tipo de mano por el que se encuentre.
     * @param tipoDeMano Tipo de mano que se ha calculado.
     */
    private void cambiarTipoDeMano(int tipoDeMano){
        
        /*
         *Los tipos de manos por clave son:
         *Escalera real = 1
         *Escalera color =2
         *Poker = 3
         *Full = 4
         *Color = 5
         *Escalera = 6
         *Tercia = 7
         *Doble par = 8
         *Par = 9
         *Carta Alta = 10
         */
        
        this.tipoDeMano = tipoDeMano;
	
    }
	

    /**
     * Ordenación de las cartas por su importancia
     * en la mano.
     * A partir de la lista de valores ya reordenados.
     */
    private void reordenarCartas(){
        
        HashSet<Integer> valoresPuntajeSinRepetir = 
        new LinkedHashSet<>(this.valoresPuntaje);
        ArrayList<Carta> cartasOrdenadas = new ArrayList<>(10);
        
        for(int valor: valoresPuntajeSinRepetir){
            
            for(Carta carta: this.cartas){
                
                if(carta.getValor() == valor){
                    
                   cartasOrdenadas.add(carta);
                    
                }
                
            }
            
        }
        
        this.cartas = cartasOrdenadas;
        
    }


    /**
     * Cálculo del tipo de mano de mano que se tiene.
     */
    public void calcularMano(){		

        /*
         *El jugador que calcule su mano
         *verá que tipo de mano tiene.
         *Le gustará ordenarlas 
         *por importancia.
         */
        
        this.iniciarCalculoMano();
        
        this.sonEscaleras();
        this.esColor();
        this.esPoker();
        this.esFull();
        this.esTercia();
        this.esDoblePar();
        this.esPar();
        this.esCartaAlta();
        
        this.reordenarCartas();
		
    }
	

    /**
     * Cálculo del puntaje de la mano.
     */
    public void establecerPuntaje(){

        /*
         *Además de tener un tipo, la mano
         *tendrá un puntaje, esto servirá para
         *que los jugadores simulados tomen 
         *sus decisiones.
         */
        
        this.calcularMano();
        
        long puntaje = 0;
				
        for(int k = 0; k<5; k++){ 
            
            puntaje += this.valoresPuntaje.get(k) *
            (long) Math.pow(14,15-k-this.tipoDeMano);
					
        }	
        
        /*
         *La puntuación de una mano se 
         *puede ver como el producto punto 
         *entre el vector de valores ordenados
         *por importancia (de mayor a menor)
         *y un vector con potencias de 14 (14
         *nos garantiza una puntuación única
         *y consistente) de la forma:
         *[14^i,14^(i-1),14^(i-2),14^(i-3),14^(i-4)]
         *donde i será más grande entre mejor 
         *sea la mano.
         */
        
        /*
         * Lista de puntuaciónes para las manos:
         * El límite superior (primer número) indica la 
         * máxima puntuación para un tipo de carta 
         * (la que cuenta con los mejores valores).
         * El límite inferior (primer número) indica la 
         * mínima puntuación para un tipo de carta 
         * (la que cuenta con los valores más bajos).
         *Escalera real:
         * 166 614 152 322 035 712 (puntaje único)
         *Escalera color:
         *   11 046 242 713 644 544
         *     4 208 097 381 637 632 
         *Poker:
         *        854 766 690 711 808
         *        122 111 213 860 608
         *Full: 
         *          61 053 287 833 216
         *            8 723 705 350 528
         *Color:
         *            4 337 095 560 896
         *            2 134 322 274 560
         *Escalera:
         *               309 793 077 888
         *               131 790 544 256
         *Tercia:
         *                 22 249 702 048
         *                   3 179 730 736
         *Doble par:
         *                   1 588 726 608
         *                      339 992 576
         *Par:
         *                      113 477 532
         *                        16 338 364
         *Carta Alta:
         *                          8 064 154
         *                          3 968 440
         */
                
        this.puntaje = puntaje;
		
    }	
	
	
    /**
     * @return Puntaje obtenido.
     */
    public long getPuntaje(){

        return this.puntaje;
	
    }		

    
    /**
     * Representación del tipo de mano
     * de acuerdo con los valores y cartas 
     * que la forman.
     * @return Cadena.
     */
    private String tipoDeManoToString(){
        
        String valorMasAlto = this.cartas.get(0).valorToString();
        String paloDeMano = this.cartas.get(0).paloToString();
          
        switch(this.tipoDeMano){
            
            case(1):
                return "Escalera real de " + paloDeMano;
            case(2):
                return "Escalera de " + paloDeMano;
            case(3):
                return "Póker de " + valorMasAlto;
            case(4):
                return "Full de " + valorMasAlto +
                " y " + this.cartas.get(3).valorToString();
            case(5):
                return "Color de " + paloDeMano;
            case(6):
                return "Escalera de " + valorMasAlto;
            case(7):
                return "Tercia de " + valorMasAlto;
            case(8):
                return "Doble par de " + valorMasAlto + 
                " y " + this.cartas.get(2).valorToString();
            case(9):
                return "Par de " + valorMasAlto;
            case(10):
                return "La carta más alta es " + valorMasAlto;
            default:
                return "";
            
        }
        
    }    
    
    /**
     * Representación del puntaje.
     * @return Puntuación "Java".
     */
    public String puntajeToString(){
        
        return String.format("\nPuntuación Java : %s\n", 
        this.puntaje);
        
    }
    
    /**
     * Representación de la mano, 
     * su tipo y las cartas que tiene.
     * @return Cadena.
     */
    @Override
    public String toString() {
        
        String mano = String.format(
        "\n%s\n", this.tipoDeManoToString()
        );
            
        mano += super.toString();
        
        return mano;
        
    }
	
    		
}	