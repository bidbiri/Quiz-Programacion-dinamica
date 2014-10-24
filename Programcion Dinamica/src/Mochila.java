
import java.io.*; 
public class Mochila 
{ 
  private int v[]; // Vector de Valores de los objetos (Beneficio). 
  private int w[]; // Vector de Pesos de los objetos. 
  private int soluciones[][]; // Matriz solución. 
  private int peso, Nelementos; // Peso máximo y Número de objetos 
  private BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
 
  /**  Constructor de la Clase Mochila. Se encarga de inicializar las variables 
   * Nelementos   Numero de objetos de los que disponemos. 
   * peso         Peso máximo que podemos llevar en la mochila. 
   */ 
  public Mochila(int Nelementos, int peso) 
  { 
    this.Nelementos = Nelementos; 
    this.peso = peso + 1; 
    soluciones = new int[Nelementos][peso + 1]; 
    v = new int[Nelementos]; 
    w = new int[Nelementos]; 
  } 
 
 
  /** Método rellenarValores: Da valor a los diferentes objetos de la mochila. 
   *IOException Error de entrada. 
   */ 
  public void rellenarValores() throws IOException 
  { 
    for (int i = 0; i < v.length; i++) 
    { 
      System.out.println("Introduzaca el valor del objeto: " + (i + 1) + "\n"); 
      v[i] = Integer.parseInt(br.readLine()); 
    } 
  } 
 
 
  /** 
   * Método rellenarPesos: Pone los pesos de cada uno de los objetos que tenemos. 
   * IOException error de entrada. 
   */ 
  public void rellenarPesos() throws IOException 
  { 
    for (int i = 0; i < w.length; i++) 
    { 
      System.out.println("Introduzaca el peso del objeto: " + (i + 1) + "\n"); 
      w[i] = Integer.parseInt(br.readLine()); 
    } 
  } 
 
 
  /** Método Mochila: Calcula el máximo valor de los de los objetos 
   *  incluidos en la mochila, sin superar la capacidad máxima. 
   *  soluciones[Nelementos-1][peso-1] Devolvemos el valor 
   *  máximo de los objetos que hemos introducido. 
   */ 
  public int Mochila() 
  { 
    for (int i = 0; i < Nelementos; i++) 
    { 
      soluciones[i][0] = 0; 
      for (int j = 0; j < peso; j++) 
      { 
        if ( (i == 0) && (j < w[i])) 
          soluciones[i][j] = 0; // soluciones[0][j] si i=0 y j>=0 
        else if (i == 0) 
          soluciones[i][j] = v[i]; //soluciones[0][j]=v[0] cuando j>=w[0]; 
        else if (j < w[i]) // si (j-w[i]) < 0 el máximo será el otro término 
          soluciones[i][j] = soluciones[i - 1][j]; 
        else 
        { 
          //Podemos utlizar esto o lo que es lo mismo llamar a la funcion maximo 
          // pero las dos cosas hacen lo mismo 
          /*soluciones[i][j] = 
              soluciones[i - 1][j] > (soluciones[i - 1][j - w[i]] + v[i]) ? 
              soluciones[i - 1][j] : (soluciones[i - 1][j - w[i]] + v[i]);*/ 
          soluciones[i][j]=maximo(i,j); 
        } 
      } 
    } 
    //La solución a nuestro problema esta en esta posición de la matriz. 
    return soluciones[Nelementos - 1][peso - 1]; 
  } 
 
 
  /** 
   * Metodo que calcula el maximo de 2 valores 
   * i int 
   * j int 
   * devuelve el maximo 
   */ 
  private int maximo(int i,int j) 
  { 
    int x = soluciones[i - 1][j]; 
    int y = v[i] + soluciones[i - 1][j - w[i]]; 
    if (x > y) 
      return x; 
    else 
      return y; 
  } 
 
 
  /** MostrarMatriz: Muestra la matriz que hemos planteado teóricamente para 
   * resolver el problema. 
   */ 
  public void MostrarMatriz() 
  { 
    for (int i = 0; i < Nelementos; i++) 
    { 
      for (int j = 0; j < peso; j++) 
        System.out.print(soluciones[i][j] + " "); 
      System.out.println(); 
    } 
 
  } 
 
  public static void main (String args[]) throws IOException{
	  System.out.println("--Implementación del problema de la mochila con programación dinámica--");
	  int numeroElementos=5;
	  int pesoMaximo=15;
	  Mochila problema = new Mochila(numeroElementos, pesoMaximo);
	  problema.rellenarValores();
	  problema.rellenarPesos();
	  problema.Mochila();
	  System.out.println("Matriz de solución: ");
	  problema.MostrarMatriz();
	  
  }
  
  
}