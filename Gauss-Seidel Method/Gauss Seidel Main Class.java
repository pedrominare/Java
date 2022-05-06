package com.project.gauss_seidel;

public class MainClass_Gauss_Seidel {

	public static void main(String[] args) {
		double[][] A = { {16, 3}, {7, -11} }; // A matrix
		double[] b = {11, 13}; // b matrix
		
		//double[][] A = { {10, 3, -2}, {2, 8, -1}, {1, 1, 5} }; // A matrix
	    //double[] b = {57, 20, -4}; // b matrix
				
		
		GaussSeidel solver = new GaussSeidel(A, b);
		double[] x = solver.solveSystem(100); // 100 = precision
		
		//Matrix A
		
		
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}

	}

}