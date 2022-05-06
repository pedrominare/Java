package com.project.gauss_seidel;

/*
 * Let's define some private fields for the incomplete matrix and for the coefficient vector...
 */
public class GaussSeidel {
	private double[][] A;
	private double[] b;
	
	/*
	 * Now I create a new constructor that takes as argument an incomplete matrix and a coefficient vector. Let it throw an exception,
	 * if one of the arguments is NULL or if they don't have the same order...
	 */
	public GaussSeidel(double[][] A, double[] b) {
		if (A == null || b == null) {
			throw new NullPointerException();
		}
		
		if (A.length != b.length) {
			throw new IllegalArgumentException();
		}
		
		this.A = A;
		this.b = b;
	}
	
	/*
	 * Creating a method to check whether the linear system can be solved applying the Gauss-Seidel method
	 */
	
	public boolean converges() {
		/*
		 * The Gauss-Seidel method can't converge if the incomplete matrix A is not a diagonally dominant matrix.
		 * So, each element of the diagonal of the matrix must be less than the sum of the values of its own row.
		 */
		for (int i = 0; i < A.length; i++) {
			double diagonal = Math.abs(A[i][i]);
			double tmpSum = 0;
			
			for (int j = 0; j < A.length; j++) {
				if (i != j)
					tmpSum += Math.abs(A[i][j]);
				if (tmpSum >= diagonal)
					return false;
			}
		}
		return true;
	}
	
	public double[] solveSystem(int precision) {
		if (!converges()) //if the converges() method returns false, just notify the user since it could still converge.
			System.err.println("The solution couldn't converge ! Please try again later xD");
		
		double[] x = initialize(new double[A.length]);
		for (int k = 0; k < precision; k++) // precision of the solution.
			for (int i = 0; i < A.length; i++) {
				double x0 = 0;
				for (int j = 0; j < A.length; j++)
					if (i != j) {
						x0 += A[i][j]*x[j];
						//System.out.println("The element x0 is:" + x[0]);
					}
				x[i] = (b[i] - x0)/A[i][i]; // bi-x0/aii
				//System.out.println("The element is x" + i);
				//System.out.println(" which is " + x[i]);
			}
		return x;
	}
	
	private double[] initialize(double[] ds) {
		for (int i = 0; i < ds.length; i++) {
			ds[i] = 0;
		}
		return ds;
	}
}