package bank;

import java.util.ArrayList;
import java.util.HashMap;

import bank_product.Credit;
import bank_product.Depozit;

public class Bank {

	private String name;
	private String address;
	private HashMap<String, Credit> availableCredits = new HashMap<String, Credit>();;
	private HashMap<String, Depozit> availableDepozits = new HashMap<String, Depozit>();
	private ArrayList<Credit> allCredits = new ArrayList<Credit>();
	private ArrayList<Depozit> allDepozits = new ArrayList<Depozit>();
	private double bankMoney;
	private double moneyReserv;
	
	public Bank(String name, String address) {
		if(name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "Bank";
		}
		if(address != null && !address.isEmpty()){
			this.address = address;
		} else {
			this.address = "Unknown";
		}
		this.bankMoney = 0;
	}
	
	public void addToAvailableCredits(String name, Credit c) {
		availableCredits.put(name, c);
	}
	
	public void addToAvailableDepozits(String name, Depozit d) {
		availableDepozits.put(name, d);
	}
	
	public void setMoney(double money) {
		this.bankMoney += money;
	}
	
	public double getMoney() {
		return bankMoney;
	}
	
	public double getMoneyReserv() {
		return moneyReserv;
	}
	
	public double calculateMoneyReserv() {
		return this.bankMoney * 0.9;
	}
	
	public void setAllDepozits(ArrayList<Depozit> allDepozit) {
		allDepozits = allDepozit;
	}
	
	private void addToAllCredits(Credit c) {
		allCredits.add(c);
	}
	
	private void addToAllDepozits(Depozit d) {
		allDepozits.add(d);
	}

	public void setAllCredits(ArrayList<Credit> allCredit) {
		allCredits = allCredit;
	}
	
	public Depozit acceptDepozit(String name, double monthlyAmmount) {
		Depozit d = availableDepozits.get(name);
		d.setMonthlyAmmountPaied(monthlyAmmount);
		this.setMoney(monthlyAmmount);
		this.moneyReserv = calculateMoneyReserv();
		addToAllDepozits(d);
		return d;
	}
	
	public Credit giveCredit(String name, int period, double ammount, ArrayList<Credit> credit, double salary) {
		int payments = 0;
		for(int i = 0; i < credit.size(); i++) {
			payments += credit.get(i).getMonthlyPay();
		}
		if(payments < salary && ammount < moneyReserv) {
			Credit c = availableCredits.get(name);
			c.setMonthlyPay(ammount);
			c.setPeriod(period);
			this.bankMoney -= c.getMonthlyPay();
			this.moneyReserv = calculateMoneyReserv();
			addToAllCredits(c);
			return c;
		}
		return null;
	}

	public void printAllDepozits() {
		for(int i = 0; i < allDepozits.size(); i++) {
			Depozit d = allDepozits.get(i);
			System.out.println("Deposit: " + d.getName() + ", percent:" + d.getPercent() + ", period:" + d.getPeriod());
		}
	}
	
	public void printAllCredits() {
		for(int i = 0; i < allCredits.size(); i++) {
			Credit c = allCredits.get(i);
			System.out.println("Credit: " + c.getName() + ", percent: " + c.getPercent() + ", period:" + c.getPeriod()); 
		}
	}
	
	public void printMoneyAndMoneyReserv() {
		System.out.println("The ammount of money in the bank right now is: " + getMoney());
		System.out.println("The ammount of bank reserv is: " + getMoneyReserv());
	}
	
	
}
