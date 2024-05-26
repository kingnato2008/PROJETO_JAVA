package projeto.Cliente.models;

import java.util.Scanner;

import Exceptions.models.InvalidAgeException;
import Exceptions.models.InvalidCodeException;
import Exceptions.models.InvalidCpfException;
import Exceptions.models.InvalidNameException;
import projeto.Pessoa.interfaces.IPessoa;
import projeto.Pessoa.models.Pessoa;

import java.util.ArrayList;

import java.util.Iterator;

public class Cliente extends Pessoa implements IPessoa{
	private String email;
	private int codCliente;

	public Cliente() {

	}
	public Cliente(String name, String cpf, int age, int codCliente, String email) throws InvalidNameException, InvalidAgeException, InvalidCpfException{
		setName(name);
		setAge(age);
		setCpf(cpf);
		setCodCliente(codCliente);
		setEmail(email);
	}

	//EMAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws InvalidNameException{
		if(email.endsWith("@gmail.com") || email.endsWith("@outlook.com")){
			this.email = email;
		}
		else{
			throw new InvalidNameException("Não foi possível identificar o domínio do e-mail ", email);
		}
	}

	//COD
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) throws InvalidNameException{
		findExistentCodCliente();
		this.codCliente = codCliente;
	}

	//MENU
	public static void viewMenu() {
		System.out.println("\nDigite:");
		System.out.println("C para Cadastrar");
		System.out.println("E para excluir");
		System.out.println("S para sair");
	}

	//REGISTER COSTUMER
	public static void registerCustomer(Scanner keyboard, ArrayList<Pessoa> list1) throws InvalidNameException, InvalidAgeException, InvalidCpfException {
		Pessoa.registerPerson(keyboard);

		//CODE
		System.out.println("Código: ");
		int codNewCustomer = keyboard.nextInt();
		keyboard.nextLine(); //Consume new line

		//EMAIL
		System.out.println("Email: ");
		String email = keyboard.nextLine();

		//NEW CUSTOMER
		Cliente newCostumer=new Cliente(nameNewPerson, cpfNewPerson, ageNewPerson, codNewCustomer, email);
		//ADD
		list1.add(newCostumer);
	}

	//DELETE CUSTOMER (MENU)
	public static void deleteCustomer(ArrayList<Pessoa> list1, Scanner keyboard) {
		Cliente.viewRecords(list1);

		System.out.println("\nCódigo do cliente que deseja excluir: ");
		int codRemoveCustomer=keyboard.nextInt();

		Cliente.findDeleteCustomer(list1, codRemoveCustomer);
		keyboard.nextLine();
	}
	//FIND COSTUMER (DELETE COSTUMER)
	public static void findDeleteCustomer(ArrayList<Pessoa> list1, int codRemoveCustomer) {
		Iterator<Pessoa> iterator = list1.iterator();

		while(iterator.hasNext()) {
			Pessoa p = iterator.next();

			if (p instanceof Cliente) {
				Cliente c = (Cliente)p;

				if (c.getCodCliente() == codRemoveCustomer) {
					iterator.remove();
					System.out.println("Cliente removido com sucesso!");
					break;
				}
			}
		}
	}

	public static void findExistentCodCliente(ArrayList<Pessoa> list1) throws InvalidCodeException {
		Iterator<Pessoa> iterator = list1.iterator();

		while(iterator.hasNext()) {
			Pessoa p = iterator.next();

			if (p instanceof Cliente) {
				Cliente c = (Cliente)p;

				if (c.getCodCliente() == ((Cliente) p).getCodCliente()) {
					throw new InvalidCodeException("Já existe um cliente com este código. Tente novamente.", c.codCliente);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "==============DADOS-CLIENTE==============\n" +
				"Nome: " + getName() + "\n" +
				"CPF: " + getCpf() + "\n" +
				"Idade: " + getAge() + "\n" +
				"Código: " + codCliente + "\n" +
				"Email: " + email;
	}

	@Override
	public String viewData() {
		return toString();
	}
}
