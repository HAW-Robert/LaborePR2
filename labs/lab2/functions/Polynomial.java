package labs.lab2.functions;




public class Polynomial {

	private double[] coefficients; 

	public Polynomial(double a0) {
		this(new double[] {a0});
	}
	public Polynomial(double a0, double a1) {
		this(new double[] {a0,a1});
	}
	public Polynomial(double a0, double a1, double a2) {
		this(new double[] {a0,a1,a2});
	}

	public Polynomial (double[] coefficients) {
		 
		this.coefficients = new double[coefficients.length];
		for (int i=0; i<coefficients.length; i++) {
			this.coefficients[i] = coefficients[i];
		}
			
		normalize();
	}

	
	public double evaluate(double x) {
		double result =0.0;
		double xN = 1.0;

		for (int i=0; i<coefficients.length; i++) {
			result += coefficients[i]*xN;
			xN *= x;
		}
		return result;
	}

	private void normalize() {
		int k=0; 
		int l = coefficients.length-1;

		while (l>k && coefficients[l-k]==0.0) {
			k++;
		}
		if (k>0) {
			double[] newCoeffs = new double[l-k+1];
			for (int i=0; i<newCoeffs.length; i++) {
				newCoeffs[i] = coefficients[i];
			}
			coefficients = newCoeffs;
		}
	}

	public int getDegree() {
		normalize();

		return coefficients.length-1;
	}


	public void print() {
		System.out.println(this);
	}

	public String toString() {
		normalize();
		String result = "f(x) = ";
		for (int i=0; i<coefficients.length; i++) {
			if (i>0 && coefficients[i]>=0) {
				result += "+";
			}
			result += coefficients[i];
			if (i>0) {
				result += "*x^"+i;
			}
		}
		return result;
	}

	public double[] getCoefficients() {
		return coefficients;
	}
}
