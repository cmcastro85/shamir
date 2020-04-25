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
	
	private static void input() {
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
		
		gauss(a,b,n);
	    
	}
	
	private static void gauss(double a[][], double b[],int n) {
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
			System.out.println("Menu: \n 1. Oprima 1 para ingresar los puntos manualmente \n "
					+ "2. Oprima 2 para probar los puntos"
					+ "(2,600), (5, 960), (7, 120), (1,360) \n"
					+ " 3. Oprima 3 para probar los puntos "
					+ "(4,2), (3, 1), (8, 10), (1,360) \n"
					+ " 4. Oprima 4 para salir.");
			int o = sc.nextInt();
			switch(o) {
			case 1: 
				input();
				break;
			case 2: 
				int x1 = 2;
				int x2 = 5;
				int x3 = 7;
				int x4 = 1;
				
				double[][] a = {
			            {  Math.pow(x1, 3),  Math.pow(x1, 2), Math.pow(x1, 1), 1},
			            {  Math.pow(x2, 3),  Math.pow(x2, 2), Math.pow(x2, 1), 1},
			            {  Math.pow(x3, 3),  Math.pow(x3, 2), Math.pow(x3, 1), 1},
			            {  Math.pow(x4, 3),  Math.pow(x4, 2), Math.pow(x4, 1), 1}
			        };
				double[] b = {600, 960, 120, 360};
				gauss(a,b,4);
				break;
			case 3:
				x1 = 4;
				x2 = 3;
				x3 = 8;
				x4 = 1;
				
				double[][] c = {
			            {  Math.pow(x1, 3),  Math.pow(x1, 2), Math.pow(x1, 1), 1},
			            {  Math.pow(x2, 3),  Math.pow(x2, 2), Math.pow(x2, 1), 1},
			            {  Math.pow(x3, 3),  Math.pow(x3, 2), Math.pow(x3, 1), 1},
			            {  Math.pow(x4, 3),  Math.pow(x4, 2), Math.pow(x4, 1), 1}
			        };
				double[] d = {2, 1, 10, 360};
				gauss(c,d,4);
				break;
			case 4:
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
