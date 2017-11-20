import java.util.Random;
import java.util.Scanner;
//NOTE: this was purposely all done in the main method, it is not best practice and was done to help someone out with their homework.
public class SlotMachine {

	public static void main(String[] args) {

		System.out.println("Welcome to Slot Machine!");
		System.out.println("Please enter your starting balance:");
		Scanner k1 = new Scanner(System.in);
		int balance = k1.nextInt();

		while (true) {
			System.out.println("If you wish to pull the lever enter y");

			Scanner k2 = new Scanner(System.in);
			String ans = k2.next();
			
			System.out.println("Enter your bet land-lubber,  your current Balance is: " + balance);
			Scanner k3 = new Scanner(System.in);
			int bet= k3.nextInt();
			
			
			if (balance < bet) {
				System.out.println("NOT ENOUGH MONEY!!!: " + balance);
				break;
			} else if (!ans.equals("y")) {
				System.out.println("Your Final Balance is: " + balance);
				break;
			}
			balance = balance - bet;
			int slot0 = new Random().nextInt(6);
			int slot1 = new Random().nextInt(6);
			int slot2 = new Random().nextInt(6);
			int slot3 = new Random().nextInt(6);
			int slots[] = { slot0, slot1, slot2, slot3 };

			int count0 = 0;
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int count5 = 0;
//ignore the for, it lets me do only one switch bc of array
			for (int i = -1; slots.length - 1 > i++;) {

				switch (slots[i]) {

				case 0:
					System.out.print(" Cherry ");
					count0 = count0+1;
					break;
				case 1:
					System.out.print(" Apple ");
					count1 = count1+1;
					break;
				case 2:
					System.out.print(" Ettercap ");
					count2 = count2+1;
					break;

				case 3:
					System.out.print(" OwlBear ");
					count3 = count3+1;
					break;

				case 4:
					System.out.print(" Zombie ");
					count4 = count4+1;
					break;

				case 5:
					System.out.print(" Ghost-Pirate ");
					count5 = count5+1;
					break;

				default:
					System.out.print(" YOU BROKE IT!");
				}

			}
			System.out.println("");
			if (count0 == 4 || count1 == 4 || count2 == 4 || count3 == 4 || count4 == 4 || count5 == 4) {
				System.out.println("JACKPOT!!! +$"+ (bet*3));//this is just for user view *(n-1)
				balance = balance + (bet*4);
				System.out.println("Current Balance: " + balance);
			} else if (count0 == 3 || count1 == 3 || count2 == 3 || count3 == 3 || count4 == 3 || count5 == 3) {

				System.out.println("Big Winner $ "+(bet*2));
				balance = balance + (bet*3);
				System.out.println("Current Balance: " + balance);
			} else if (count0 == 2 || count1 == 2 || count2 == 2 || count3 == 2 || count4 == 2 || count5 == 2) {

				System.out.println("Winner +$ "+(bet*1));
				balance = balance + (bet*2);
				System.out.println("Current Balance: " + balance);
			} else {
				System.out.println("Try Again!");
				System.out.println("Current Balance: " + balance);
			}
		}

	}

}
