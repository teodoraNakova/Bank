package bank_product;

public abstract class BankProduct {

	private String name;
	private final double percent;
	private int period;
	private double availabiltyLv;
	
	public BankProduct(String name, final double percent) {
		this.name = name;
		this.percent = percent;
	}
	
	public int getPeriod() {
		return period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPercent() {
		return percent;
	}

	@Override
	public String toString() {
		return "BankProduct [name=" + name + ", percent=" + percent
				+ ", period=" + period + ", availabiltyLv=" + availabiltyLv
				+ "]";
	}
	
	
}
