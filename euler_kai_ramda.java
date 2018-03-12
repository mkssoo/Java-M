import java.io.*;
public class euler_kai_ramda {
	public static void main(String[] args) throws IOException {
		BufferedWriter f_write = new BufferedWriter(new FileWriter("euler_kai_ramda.txt",true));
		double p1,p2,p3;
		int k=6;
		double h = 0.01;
		//double l = 1; //¦Ë
		double l = Double.parseDouble(args[0]); //¦Ë
		int count=0;

		p1 = 0.01; //½é´ü
		//f_write.write("0 0.01\n");

		for(double t=0.01;t<=20;t+=h){
			//p2 = p1 + h * ( (-1*p1)+(1-Math.pow(1-p1,k))*(1-p1) );
			p2 = p1 + (h/2) * ( (-1*p1)+l*(1-Math.pow(1-p1,k))*(1-p1) );
			p3= p1 + h * ( (-1*p2)+l*(1-Math.pow(1-p2,k))*(1-p2) );

			//f_write.write(t+" "+p3+"\n");
			//if(count==2000){
			if(p3==0.4958617416383432){
				f_write.write(l+" "+p3+"\n");
				//System.out.println(l+" "+p3);
			}
			//System.out.println(p3);
			//System.out.println(t);
			p1 = p3;
			count++;
		}

		//System.out.println(p3);
		//f_write.write(l+" "+p3+"\n");
		f_write.close();
	}
}
