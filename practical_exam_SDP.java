package practical_exam_SDP;

import java.util.*;

public class practical_exam_SDP {
	
	private static void writeArray(int[] par) {
		for(int elm : par) System.out.print(elm + " ");
		System.out.println();
	}
	
	public static int[] funcA(int[] arPar, int L, int R) {
		Random rndd = new Random();
		if (R < L + 8) {
			for(int i = 0; i < arPar.length; ++i) {
				arPar[i] = rndd.nextInt(0,19); // променя стойността на всеки един елемент от масива със случайно число от 0 - 18
			}
			System.out.printf("Array with %d random integers from 0 to 18:\n", arPar.length);
		}
		if (R > L + 7) {
			int j = 0; //започваме от нулев индекс
			do {
				int o = rndd.nextInt(L, R); //създаваме случайно число в интервала (L-граница - R-граница)
				if (o % 7 == 0) { // ако о / 7 има остатък 0 числото се записва на мястото на числото в масива
					arPar[j] = o;
					j++; // преминаваме на следващия индекс
				}
				//цикълът се изпълнява докато последното число от масива се замени с такова, което при деление със 7 има осататък 0 и е в границите(L-R)
			} while (arPar[arPar.length-1] == 0);
			System.out.printf("Array with %d random integers from %d to %d when divided by 7 with no remainder:\n", arPar.length, L, R);
		}
		return arPar;
	}
	
	
	public static int funcB(int[] arPar) {
		if(arPar.length < 2) {
			return 0;
		}
		else {
			int minDifference = Integer.MAX_VALUE;
			for (int a = 0; a + 1 < arPar.length; a++) {  //a + 1 за да не излизаме от индекс
				int min1 = arPar[a] - arPar[a+1]; // изваждаме всяко число с неговото дясностоящо
				if(minDifference > min1) {
					minDifference = min1;
				}
			}
			for (int b = 1; b < arPar.length; b++) {
				int min2 = arPar[b] - arPar[b-1]; // изваждаме всяко число с неговото лявостоящо
				if (minDifference > min2) {
					minDifference = min2;
				}
			}
			System.out.printf("The minimal difference is: %d\n", minDifference);
			return minDifference;
		}
	}
	
	
	public static void funcC(int[] arPar) {
		for (int m = 1; m + 1 < arPar.length; m++) {
			if (arPar[m-1] % 2 != 0 & arPar[m-1] < 0 & arPar[m+1] % 2 == 0 & arPar[m+1] > 0) {
				System.out.printf("Number: %d with index: %d\n", arPar[m], m);
			}
		}
			
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int sumOfArray; //ще създадем масив от толкова на брои числа
		do {
			System.out.println("Enter number between 3 and 19:");
			sumOfArray = scan.nextInt();
		} while (sumOfArray < 3 || sumOfArray > 19);
		int[] ar = new int[sumOfArray]; //масив с 0-ли
//		funcA(ar,100,20);//funcA(array, L, R) ако R < L + 8 (Проба)
//		writeArray(ar); // допълнителна функция, чрез която принтирваме масива
//		funcA(ar,3,200);//funcA(array, L, R) ако R > L + 8 (Проба)
//		writeArray(ar);
		funcA(ar,-65,55);//в така създадения масив чрез функцията от подточка а) да се записват цели числа, делящи се на седем, избирани по случаен начин от интервала [−65;+55] ;
		writeArray(ar);
		
		funcB(ar);//да се извиква функцията от подточка б), като ѝ се подава така създаденият масив, и да се извежда резултатът, върнат от функцията
		
		funcC(ar);
	
		scan.close();
		}
		

}
