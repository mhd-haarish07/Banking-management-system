package bank_data;

import java.util.Scanner;

import model.User;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		Bank bank = new Bank();

		User user = null;

		boolean admin = false;

		long userId = 0;

		System.out.println("Bank Management System");

		while (true) {

			System.out.println("Enter Whether User or Admin to login!");

			String role = sc.nextLine();

			if (role.equalsIgnoreCase("user")) {

				while (true) {

					if (user == null) {

						System.out.println("Enter the corresponding number to select the option : ");
						System.out.println("1.Login");
						System.out.println("2.Signup");

						int option = sc.nextInt();

						switch (option) {

						case 1:
							System.out.println("Enter account number : ");
							long accnum = sc.nextLong();

							System.out.println("Enter secret pin : ");
							int pin = sc.nextInt();

							user = bank.login(accnum, pin);

							if (user == null) {
								System.out.println("Enter correct username or pin!");
							} else {
								userId = user.getAccNo();
								System.out.println("Logged in as : " + user.getUserName());
							}
							System.out.println("");
							break;

						case 2:
							System.out.println("Enter name : ");
							String name = sc.next();

							System.out.println("Enter pin : ");
							int newPin = sc.nextInt();

							System.out.println("Enter initial Balance : ");
							double initAmount = sc.nextDouble();

							user = bank.createAccount(name, initAmount, newPin);
							userId = user.getAccNo();

							System.out.println("Account created : " + "\nName : " + user.getUserName()
									+ "\nAccount Number : " + user.getAccNo());

							System.out.println();
							break;

						default:
							System.out.println("Please enter correct option");

						}

					} else {

						System.out.println("Enter the corresponding number to select the option : ");
						System.out.println("1.Deposit");
						System.out.println("2.Withdraw");
						System.out.println("3.View Balance");

						int choice = sc.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Enter the amount : ");
							double amount = sc.nextDouble();
							bank.deposit(user.getAccNo(), amount);
							user = bank.getAccounts().get(userId);
							System.out.println("Current Balance : " + user.getAccDetails().getAccBal());
							System.out.println("");
							break;

						case 2:
							System.out.println("Enter the amount : ");
							double amount2 = sc.nextDouble();
							bank.withDraw(user.getAccNo(), amount2);
							user = bank.getAccounts().get(userId);
							System.out.println("Current Balance : " + user.getAccDetails().getAccBal());
							System.out.println("");
							break;

						case 3:
							System.out.println("Account balance : " + user.getAccDetails().getAccBal());
							System.out.println("");
							break;

						default:
							System.out.println("Please enter correct option");
						}
					}

				}

			} else if (role.equalsIgnoreCase("admin")) {

				while (true) {

					if (admin) {

						System.out.println("Enter the corresponding number to select the option : ");
						System.out.println("1.View Accounts");
						System.out.println("2.Delete Account");
						int choice = sc.nextInt();
						switch (choice) {
						case 1:
							bank.showAcc();
							System.out.println();
							break;

						case 2:
							System.out.println("Enter the account number of account you want to delete");
							long accNum = sc.nextLong();

							if (bank.getAccounts().containsKey(accNum)) {

								System.out.println("Do you want to delete this following account?");
								System.out.println(bank.getAccounts().get(accNum));
								System.out.println();
								System.out.println("Type yes to delete the account!");

								String cnf = sc.next();

								if (cnf.equalsIgnoreCase("yes")) {

									bank.getAccounts().remove(accNum);

									System.out.println("Account deleted!");
								} else {

									System.out.println("Account deletion cancelled!");
								}

							}
							System.out.println();
							break;

						default:
							System.out.println("Please enter correct option");
						}

					} else {

						System.out.println("Enter the secret key!");
						String key = sc.next();
						if (key.equals(bank.getKey())) {
							System.out.println("Admin Logged in!");
							admin = true;
							System.out.println();
						} else {

							System.out.println("Please enter the correct key!");
							System.out.println();
						}

					}
				}

			} else {

				System.out.println("Enter Admin or User!");
			}
		}
	}
}
