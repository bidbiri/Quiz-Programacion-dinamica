
public class Problemas {
	public Problemas(){}
	
	
	//El problema de las monedas con programaci�n din�mica
	public int Minima_devolucion(int cantidad_devuelta, int[]  monedas){
		  
		  
		  //Se crea la matriz de devoluciones
		  int[][]  matriz_cambio = new int[monedas.length+1][cantidad_devuelta+1];
		  
		 //Se rellena la primera columna de ceros
		 for(int i = 0; i < monedas.length; i++)
		     matriz_cambio[i][0] = 0;
		  
		 //La primera fila menos la primera columna un n�mero alto
		 for(int j = 1; j <= cantidad_devuelta; j++)
		     matriz_cambio[0][j] = 999999;
		  
		 for(int i = 1; i <= monedas.length ; i++)
		    for(int j = 1; j <= cantidad_devuelta; j++){
		     if(monedas[i-1] > j ){
		       //Si la moneda es superior a la cantidad a devolver
		       matriz_cambio[i][j] = matriz_cambio[i-1][j]; 
		     }else{
		       //Si la moneda no es superior a la cantidad a devolver
		     
		       //Calcular cual es el m�nimo de estas dos posiciones
		       int minimo = 0; //Se guarda aqu� el m�nimo
		     
		      if(matriz_cambio[i-1][j] < matriz_cambio[i][j - monedas[i-1]] + 1){
		        minimo = matriz_cambio[i-1][j];
		      }else{
		        minimo = matriz_cambio[i][j - monedas[i-1]] + 1;
		      }
		      //Se guarda m�nimo
		      matriz_cambio[i][j] = minimo;
		    }
		   }
		  

		 return matriz_cambio[monedas.length][cantidad_devuelta];
		}
	
	
public static void main (String args[]){
	Problemas problemas= new Problemas();
	int monedas[]={1,4,6};
	int cantidad_devuelta=8;
	System.out.println("--Implementaci�n del problema de las monedas con programaci�n din�mica--");
	System.out.println("Monedas: ");
	for(int i=0;i<monedas.length;i++)
		{System.out.print(monedas[i]+" ");}
	System.out.println("\nEl n�mero m�nimo de monedas requeridas para devolver la cantidad "+cantidad_devuelta+" es: "+problemas.Minima_devolucion(cantidad_devuelta,monedas));

	
}



}
