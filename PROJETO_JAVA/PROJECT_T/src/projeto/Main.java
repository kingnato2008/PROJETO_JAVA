package projeto;


import java.util.ArrayList;


import java.util.Scanner;

import Exceptions.models.*;
import projeto.Cliente.models.Cliente;
import projeto.Pessoa.models.Pessoa;

public class Main {
	public static void main(String[] args) throws InvalidNameException, InvalidAgeException, InvalidCpfException, InvalidCodeException, InvalidEmailException {
		//LIST
		ArrayList<Pessoa> list1 = new ArrayList<Pessoa>();
		//SCANNER
		Scanner keyboard=new Scanner(System.in);
		
		while(true) {	
			
			//MENU
			Cliente.viewMenu();
			String option = keyboard.nextLine();
			
			if (option.equalsIgnoreCase("S")) {
				System.out.println("\nTchau!");
				break;
			}
			else if (option.equalsIgnoreCase("C")) {
				boolean tf=false;
				do{
					try {
						Cliente.registerCustomer(keyboard, list1);
						tf=false;
					}
					catch(InvalidNameException e) {
						System.out.println(e.getMessage());
						tf=true;
					}
					catch(InvalidAgeException e) {
						System.out.println(e.getMessage());
						tf=true;
					}
					catch(InvalidCpfException e) {
						System.out.println(e.getMessage());
						tf=true;
					}
				}
				while(tf==true);
				
			}
			else if (option.equalsIgnoreCase("E")) {
				Cliente.deleteCustomer(list1, keyboard);
			}
			else{
				System.out.println("Tecla inválida, tente novamente");
			}
		}
		
		keyboard.close();
		
	}
}
