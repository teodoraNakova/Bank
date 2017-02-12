package demo;

import java.util.Random;

import client.Client;
import bank.Bank;
import bank_product.Credit;
import bank_product.Depozit;

public class Demo {

	public static void main(String[] args) {
		Random r = new Random();
		
		Depozit shortDepozit = new Depozit("Short deposit", 3, 3);
        Depozit longDepozit = new Depozit("Long deposit", 5, 12);
              
        Credit homeCredit = new Credit("Home Credit", 6);
        Credit consumerCredit = new Credit("Consumer credit", 10);  
        
        Bank obb = new Bank("OBB", "Sofia");
        
        obb.addToAvailableCredits("Home credit", homeCredit);
        obb.addToAvailableCredits("Consumer credit", consumerCredit);
        
        obb.addToAvailableDepozits("Short deposit", shortDepozit);
        obb.addToAvailableDepozits("Long deposit", longDepozit);
        
        Client [] clients = new Client[10];
        for(int i = 0; i < 10; i++) {
        	int randomMoney = r.nextInt(1000) + 1;
        	int randomSalary = r.nextInt(1500) + 500;
        	int randomIndex = r.nextInt(21) + 80;
        	Client c = new Client("Random client", "Random address", randomMoney, randomSalary, obb);
        	clients[i] = c;
        	if(r.nextBoolean()) {
        		c.createDepozit("Short deposit", c.getMoney() * randomIndex / 100);
        	}
        	c.createDepozit("Long deposit", c.getMoney() * randomIndex / 100);  	
        }
        
        obb.printMoneyAndMoneyReserv();
        
        for(int i = 0; i < clients.length; i++) {
        	if(r.nextBoolean()) {
        		clients[i].askForCredit("Home credit", 6, 100, clients[i].getListOfCredits(), clients[i].getSalary());
        		continue;
        	}
        	clients[i].askForCredit("Consumer credit", 7, 200, clients[i].getListOfCredits(), clients[i].getSalary());
        }
        
        for(int i = 0; i < clients.length; i++) {
        	System.out.println(clients[i]);
        }
        obb.printAllDepozits();
        obb.printAllCredits(); 
        obb.printMoneyAndMoneyReserv();
	}

}
