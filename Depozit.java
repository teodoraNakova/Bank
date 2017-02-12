package bank_product;

public class Depozit extends BankProduct {

	private double monthlyAmmountPaied;
	
	public Depozit(String name, final double percent, int period) {
		super(name, percent);
		this.setPeriod(period);
	}
	
	public void setMonthlyAmmountPaied(double monthlyAmmountPaied) {
		this.monthlyAmmountPaied = monthlyAmmountPaied;
	}
}
