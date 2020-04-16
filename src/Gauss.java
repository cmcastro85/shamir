public class Gauss {

	private double[][] matrix;
	
	private  int n;
	
	private double[][] m;
	
	private double[] b;
	
	private static final int PRIME = 1301 ; 
	
	public Gauss(double[][] m, double[] b) {
		n = b.length;
		
		this.b = b;
		this.m = m;
    	
    	matrix = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	matrix[i][j] = m[i][j];            	
            }
        }
        
        for (int i = 0; i < n; i++) {
        	matrix[i][n] = b[i];
        }
	}
	
	

	/**
	 * Intercambia la fila 1 con la fila 2
	 * @param fila1
	 * @param fila2
	 */
    private void swap(int fila1, int fila2) {
    	double[] temp = matrix[fila1];
        matrix[fila1] = matrix[fila2];
        matrix[fila2] = temp;
    }
    
    /**
     * Usar el pivote para realizar eliminación gaussiana.
     * Se resta alpha veces tdo menos la fila i y la columna j
     * Se deja en cero tdo lo que no sea el pivote dentro de la columna q
     * 
     * @param f fila del pivote
     * @param c columna del pivote
     */
    private void pivot(int f, int c) {
        for (int i = 0; i < n; i++) {
        	//calcula el inverso modular del pivote
        	int inverse = modInverse((int) matrix[f][c], PRIME);
        	//calcula el alpha 
            int alpha = (int) ((matrix[i][c] * inverse) % PRIME);
            //Se resta alpha veces la fila del pivote a las demas
            for (int j = 0; j <= n; j++) {
                if (i != f && j != c) {
                	matrix[i][j] = (matrix[i][j] - alpha * matrix[f][j]) % PRIME;
                	if (matrix[i][j] <0) {
                		matrix[i][j] += PRIME; 

                	}
                }
            }
        }
        // Deja en 0 la columna del pivote
        for (int i = 0; i < n; i++)
            if (i != f) matrix[i][c] = 0;
        
        //divide la fila del pivote por el valor de este
        for (int j = 0; j <= n; j++)
            if (j != c) {
            	int inverse = modInverse((int) matrix[f][c], PRIME);
            	matrix[f][j] *= inverse;
            	matrix[f][j] %= PRIME;
            	}
        matrix[f][c] = 1;
    }
    
    // Function to find modular inverse of a  
    // under modulo m Assumption: m is prime 
    private int modInverse(int a, int m) 
    { 
        return power(a, m - 2, m);
    }
    
    // To compute x^y under modulo m 
    private int power(int x, int y, int m)  
    { 
        if (y == 0) 
            return 1; 
          
        int p = power(x, y / 2, m) % m; 
        p = (p * p) % m; 
      
        if (y % 2 == 0) 
            return p; 
        else
            return (x * p) % m; 
    }
    
    private void fixer() {
		int i = 0;
		while (i<b.length) {
			int j = 0;
			while(j < b.length) {
				int temp1 = (int) matrix[i][4];
				int temp2 = (int) matrix[j][4];
				if(i == j) {
					matrix[i][4] -= 1301;
				}
				else {
					matrix[i][4] -= 1301;
					matrix[j][4] -= 1301;
				}
				if(b[0] == m[0][0]*matrix[0][4]+m[0][1]*matrix[1][4]+m[0][2]*matrix[2][4]+m[0][3]*matrix[3][4]) {
					break;
				}
				matrix[i][4] = temp1;
				matrix[j][4] = temp2;
				j++;
			}
			i++;
		}
	}
    
    /**
     * Gauss-Jordan elimination.
     * @return
     */
    public double[][] gaussJordan() {
    	
        for (int p = 0; p < n; p++) {
            
            int max = p;
            for (int i = p+1; i < n; i++) {
                if (Math.abs(matrix[i][p]) > Math.abs(matrix[max][p])) {
                    max = i;
                }
            }

            swap(p, max);

            pivot(p, p);
        }
        fixer();
    	return matrix;
    }
    
    public void show(double[][] sol) {
    	for (int i = 0; i < n; i++) {
	    	 for (int j = 0; j < n; j++) {
	    		 StdOut.printf("%8.3f ", sol[i][j]);
	    		 }
	    	 StdOut.printf("| ");
	         for (int j = n; j < n+1; j++) {
	        	 StdOut.printf("%8.3f\n", sol[i][j]);
	        	 }
	     }
	     StdOut.println();
    }

}
