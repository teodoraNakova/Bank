package client;

import java.util.ArrayList;

import bank.Bank;
import bank_product.Credit;
import bank_product.Depozit;

public class Client {

	private String name;
	private String address;
	private double money;
	private double salary;
	private ArrayList<Credit> listOfCredits;
	private ArrayList<Depozit> listOfDepozits;
	private Bank myBank;
	
	public Client(String name, String address, double money, double salary, Bank bank) {
		if(name != null && !name.isEmpty()){
			this.name = name;
		} else{
			this.name = "Unknown";
		}
		if(address != null && !address.isEmpty()){
			this.address = address;
		} else {
			this.address = "Unknown";
		}
		if(money > 0) {
			this.money = money;
		} else {
			this.money = 100;
		}
		if(salary > 0) {
			this.salary = salary;
		} else {
			this.salary = 200;
		}
		listOfCredits = new ArrayList<Credit>();
		listOfDepozits = new ArrayList<Depozit>();
		this.myBank = bank;
	}	
	
	public double getMoney() {
		return money;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ArrayList<Credit> getListOfCredits() {
		return listOfCredits;
	}

	public void setListOfCredits(ArrayList<Credit> listOfCredits) {
		this.listOfCredits = listOfCredits;
	}

	public void createDepozit(String name, double monthlyAmmount) {
		if(this.getMoney() > 0) {
			Depozit d = myBank.acceptDepozit(name, monthlyAmmount);
			listOfDepozits.add(d);
			this.money -= monthlyAmmount;
		}
	}
	
	public void askForCredit(String name, int period, double ammount, ArrayList<Credit> credits, double salary) {
		Credit c = myBank.giveCredit(name, period, ammount, credits, salary);
		if(c != null) {
			listOfCredits.add(c);
			this.money += c.getMonthlyPay();
		}
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", address=" + address + ", money="
				+ money + ", salary=" + salary + ", listOfCredits="
				+ listOfCredits + ", listOfDepozits=" + listOfDepozits
				+ ", myBank=" + myBank + "]";
	}
}
