import java.util.Scanner;

/**
 * 
 */


/**
 * @author camilo
 *
 */
public class Main {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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
				System.out.println(a[i][j]);
				pow--;
			}
		}
		
		
	    sc.close();
	    Gauss gauss = new Gauss(a, b);
	     
	    
	    double[][] sol = gauss.gaussJordan();
	     
	    gauss.show(sol);
	   
		
	
		int x1 = 4;
		int x2 = 3;
		int x3 = 8;
		int x4 = 1;
		
		double[][] c = {
	            {  Math.pow(x1, 3),  Math.pow(x1, 2), Math.pow(x1, 1), 1},
	            {  Math.pow(x2, 3),  Math.pow(x2, 2), Math.pow(x2, 1), 1},
	            {  Math.pow(x3, 3),  Math.pow(x3, 2), Math.pow(x3, 1), 1},
	            {  Math.pow(x4, 3),  Math.pow(x4, 2), Math.pow(x4, 1), 1}
	        };
		double[] d = {2, 1, 10, 360};
		
		Gauss gauss2 = new Gauss(c, d);
		double[][] sol2 = gauss2.gaussJordan();
		
		gauss2.show(sol2);
		
	}
}
