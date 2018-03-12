import java.io.*;
public class euler {
	public static void main(String[] args) throws IOException {

		BufferedWriter f_write = new BufferedWriter(new FileWriter("euler.txt"));
		double p1,p2;
		int k=6;
		double h = 0.01;

		p1 = 0.01;
		f_write.write("0 0.01\n");
		for(double t=0.01;t<=20;t+=h){

			p2 = p1 + h * ( (-1*p1)+(1-Math.pow(1-p1,k))*(1-p1) );

			f_write.write(t+" "+p2+"\n");
			System.out.println(p2);
			p1 = p2;
		}
		f_write.close();
	}
}
