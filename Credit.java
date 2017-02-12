package bank_product;

public class Credit extends BankProduct {

	private double monthlyPay;
	
	public Credit(String name, final double percent) {
		super(name, percent);
	}
	
	public void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}
	
	public double getMonthlyPay() {
		return monthlyPay;
	}
	
	
}
