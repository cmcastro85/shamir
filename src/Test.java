
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
