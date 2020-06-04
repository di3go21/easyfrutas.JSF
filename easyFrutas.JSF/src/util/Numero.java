package util;


public class Numero {
	
	public static double dosDecimales(String st) {
		st=st.replace(',', '.');

		double dob = Double.valueOf(st);
		dob = ((double)Math.round(dob*100))/100;
		return dob;
		}

	public static double dosDecimales(double db) {

		double dob = Double.valueOf(db);
		dob = ((double)Math.round(dob*100))/100;
		return dob;
		}
	
	public static double dosDecimales(double db,double db2) {

		double dob = ((Double)db)*((Double)db2);
		dob = ((double)Math.round(dob*100))/100;
		return dob;
		}


	public static void main(String[] args) {
		double a=0.993;
		
		System.out.println(dosDecimales(a,1));
		
		
		
	}
	
}
