import java.util.Scanner;

/**
 * 
 */


/**
 * @author camilo
 *
 */
public class Main {

	private static Scanner sc;
	
	private static void gauss() {
		System.out.println("Escriba el tamaño de la matriz a resolver.");
		int n = sc.nextInt();
		
		double[][] a = new double[n][n];
		
		double[] b = new double[n];
		
		for(int i = 0;i<n;i++) {
			System.out.println("Escriba un punto ( f(x), x )  separados por un espacio");
			int x = sc.nextInt();
		    int p = sc.nextInt();
		    b[i] = p;
		    int pow =n-1;
			for(int j = 0; j<n; j++) {
				a[i][j] = (int) Math.pow(x, pow);
				pow--;
			}
		}
		
		
	    Gauss gauss = new Gauss(a, b);
	     
	    
	    double[][] sol = gauss.gaussJordan();
	    
	    gauss.show(sol);
	    System.out.println("El secreto es " + sol[n-1][n]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		boolean l = true;
		while(l) {
			System.out.println("Menu: \n 1. Oprima 1 para continuar \n 2. Oprima 2 para salir");
			int o = sc.nextInt();
			switch(o) {
			case 1: 
				gauss();
				break;
			case 2: 
				l = false;
			    sc.close();
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		}
	}
}
