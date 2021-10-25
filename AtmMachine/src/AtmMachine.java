import java.util.Scanner;

public class AtmMachine {
	private double totalBal = 100;
	Scanner input = new Scanner(System.in);

	public int userAccount() {
		System.out.println("Enter your account number: ");
		int account;
		account = input.nextInt();
		return account;
	}

	public int userPin() {
		System.out.println("Enter your pin:");
		int pin;
		pin = input.nextInt();
		return pin;
	}

	public void startAtm() {
		userAccount();
		userPin();
		drawMainMenu();
	}

	public void drawMainMenu() {
		int selection;
		System.out.println("\n ATM main menu");
		System.out.println("1- View Account Balance");
		System.out.println("2- Withdraw funds");
		System.out.println("3- Add funds");
		System.out.println("4- Terminate transaction");
		System.out.print("Choice: ");
		selection = input.nextInt();
		switch (selection) {
		case 1:
			viewAccountInfo();
			break;
		case 2:
			withdraw();
			break;
		case 3:
			addFunds();
			break;
		case 4:
			System.out.println("Thak you for using this ATM!!! goodbye");
			break;
		default:
			System.out.println("It's not choiceble number or other thing please chechk what you write. ");
		}

	}

	public void viewAccountInfo() {
		System.out.println("Acount Information");
		System.out.println("\t--Total Balance:      $" + "totalBal");
		drawMainMenu();

	}

	public void deposit(int depAmount) {
		System.out.println("\\n***Please insert your money now...***");
		totalBal = totalBal + depAmount;
	}

	public void checkNsf(int withdrawAmount) {
		if (totalBal - withdrawAmount < 0)
			System.out.println("\n***ERROR!!! Insufficient funds in you account***");
		else {
			totalBal = totalBal - withdrawAmount;
			System.out.println("\n*** Please take your money now...***");
		}
	}

	public void addFunds() {
		int addSelection;
		System.out.println("Deposit funds:");
		System.out.println("1 - $10");
		System.out.println("2 - $20");
		System.out.println("3 - $50");
		System.out.println("4 - $100");
		System.out.println("5 - Back to main menu");
		System.out.println("Choice: ");
		addSelection = input.nextInt();
		switch (addSelection) {
		case 1:
			deposit(10);
			drawMainMenu();
			break;
		case 2:
			deposit(20);
			drawMainMenu();
			break;
		case 3:
			deposit(50);
			drawMainMenu();
			break;
		case 4:
			deposit(100);
			drawMainMenu();
			break;
		case 5:
			drawMainMenu();
			break;

		}
	}

	public void withdraw() {
		int withdrawSelection;
		System.out.println("Withdraw money:");
		System.out.println("1 - $10");
		System.out.println("2 - $20");
		System.out.println("3 - $50");
		System.out.println("4 - $100");
		System.out.println("5 - Back to main menu");
		System.out.println("Choice: ");
		withdrawSelection = input.nextInt();
		switch (withdrawSelection) {
		case 1:
			checkNsf(10);
			drawMainMenu();
			break;
		case 2:
			checkNsf(20);
			drawMainMenu();
			break;
		case 3:
			checkNsf(50);
			drawMainMenu();
			break;
		case 4:
			checkNsf(100);
			drawMainMenu();
			break;
		case 5:
			drawMainMenu();
			break;

		}
	}

	public static void main(String args[]) {
		AtmMachine myAtm = new AtmMachine();
		myAtm.startAtm();
	}

}
