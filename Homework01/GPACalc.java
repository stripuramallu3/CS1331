import java.util.Scanner;
public class GPACalc {
	public static void main(String[] args){
		int a,b,c,d,f;
		double gpa;
		Scanner userInput = new Scanner(System.in);
		System.out.print("A Credit Hours: ");
		a = userInput.nextInt();
		System.out.print("B Credit Hours: ");
		b = userInput.nextInt();
		System.out.print("C Credit Hours: ");
		c = userInput.nextInt();
		System.out.print("D Credit Hours: ");
		d = userInput.nextInt();
		System.out.print("F Credit Hours: ");
		f = userInput.nextInt();
		gpa = ((a*4.0)+(b*3.0)+(c*2.0)+(d*1.0)+(f*0.0))/(a+b+c+d+f);
		System.out.print("GPA: " + gpa);
	}
}