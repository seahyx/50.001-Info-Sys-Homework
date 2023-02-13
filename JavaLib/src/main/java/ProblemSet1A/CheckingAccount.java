package ProblemSet1A;

public class CheckingAccount extends Account {
	public CheckingAccount(int id, double balance) {
		super(id, balance);
	}

	public void withdraw(double amount) {
		if (getBalance() <= -5000) {
			System.out.println("over limit");
			return;
		}
		super.withdraw(amount);
	}
}
