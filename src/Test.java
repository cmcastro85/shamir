
public class Test {

	

	
	public void test1() {
		double[][] a = {
	            { 2, 4},
	            { 6, 1}
	        };
		double[] b = {26,23};
		Gauss gausss = new Gauss(a, b);
		double[][] sol =gausss.gaussJordan();
		gausss.show(sol);
	}
	
	public void test2() {
		double[][] a = {
	            { 8, 4,2,1},
	            { 125, 25,5,1},
	            { 343, 49,7,1},
	            { 1, 1,1,1}
	        };
		double[] b = {600,960,120,360};
		Gauss gausss = new Gauss(a, b);
		double[][] sol =gausss.gaussJordan();
		
		int i = 0;
		while (b[0] != a[0][0]*sol[0][4]+a[0][1]*sol[1][4]+a[0][2]*sol[2][4]+a[0][3]*sol[3][4]) {
			System.out.println("change");
			
			int temp = (int) (sol[i][4]);
			sol[i][4] -= 1301;
			if(b[0] == a[0][0]*sol[0][4]+a[0][1]*sol[1][4]+a[0][2]*sol[2][4]+a[0][3]*sol[3][4]) {
				break;
			}
			sol[i][4] = temp;
			i++;
		}
		gausss.show(sol);
	}
	
	public void test3() {
		double[][] a = {
	            { 64, 8,4,1},
	            { 27, 9,3,1},
	            { 512, 64,8,1},
	            { 1, 1,1,1}
	        };
		double[] b = {2,1,10,360};
		Gauss gausss = new Gauss(a, b);
		double[][] sol =gausss.gaussJordan();
		gausss.show(sol);
		
		
		
	}
	
	
	
}
