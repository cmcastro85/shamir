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
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escriba el tamaño de la matriz a resolver.");
		int n = sc.nextInt();
		
		double[][] a = new double[n][n];
		
		double[] b = new double[n];
		
		for(int i = 0;i<n;i++) {
			System.out.println("Escriba el siguiente punto separado por un espacio");
			int x = sc.nextInt();
		    int p = sc.nextInt();
		    b[i] = p;
			for(int j = n-1; j>=0; j--) {
				a[i][j] = (int) Math.pow(x, j);
			}
		}
		
		
	    sc.close();
	    Gauss gauss = new Gauss(a, b);
	     
	    
	    double[][] sol = gauss.gaussJordan();
	     
	    gauss.show(sol);
	    */
		double[][] a = {
	            {  64, 16, 4, 1},
	            {  27,  9, 3, 1},
	            {   8,  4, 2, 1},
	            {   1,  1, 1, 1}
	        };
		double[] b = {427, 171, 53, 13};
		Gauss gauss = new Gauss(a, b);
		double[][] sol = gauss.gaussJordan();
		
		gauss.show(sol);
	}
}
