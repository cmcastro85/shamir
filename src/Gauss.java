public class Gauss {

	private double[][] matrix;
	
	private  int n;
	
	public Gauss(double[][] m, double[] b) {
		n = b.length;
    	
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
     * Se resta alpha veces todo menos la fila i y la columna j
     * Se deja en cero todo lo que no sea el pivote dentro de la columna q
     * 
     * @param f fila del pivote
     * @param c columna del pivote
     */
    private void pivot(int f, int c) {

        for (int i = 0; i < n; i++) {
            double alpha = matrix[i][c] / matrix[f][c];
            for (int j = 0; j <= n; j++) {
                if (i != f && j != c) matrix[i][j] -= (alpha * matrix[f][j]);
            }
        }

        for (int i = 0; i < n; i++)
            if (i != f) matrix[i][c] = 0.0;

        for (int j = 0; j <= n; j++)
            if (j != c) {
            	matrix[f][j] /= matrix[f][c];
            	matrix[f][j] %= 1301;
            }
        matrix[f][c] = 1.0;
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
