package projeto.Pessoa.models;

import java.util.ArrayList;

import java.util.Scanner;

import Exceptions.models.*;

public abstract class Pessoa {
	private String name, cpf;
	private int age;
	protected static String nameNewPerson, cpfNewPerson;
	protected static int ageNewPerson;
	
	//NAME
	public String getName() {
		return name;
	}
	public void setName(String name) throws  InvalidNameException{
		
		validateName(name);
		this.name=name;
	}
	
	//VALIDATE NAME
	public static void validateName(String VName) throws InvalidNameException{
		if(VName.trim().length() < 3){
			throw new InvalidNameException("O nome deve conter ao menos 3 letras! -> Nome digitado: ", VName);
		}
	}
	
	//AGE
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) throws InvalidAgeException{
		validateAge(age);
		this.age=age;
	}
	
	//VALIDATE AGE
	public static void validateAge(Integer VAge) throws InvalidAgeException{
		if (VAge == null) {
			throw new InvalidAgeException("A idade não pode ser vazia! -> Idade digitada: ", VAge);
	
		}
		else if (VAge <0) {
			throw new InvalidAgeException("A idade deve ser maior que 0! -> Idade digitada: ", VAge);
		}
	}
	
	//CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws InvalidCpfException{
		validateCPF(cpf);	
		this.cpf=cpf;
	}
	
	//VALIDATE CPF
	public static void validateCPF(String VCpf) throws InvalidCpfException{
		if (VCpf.trim().isEmpty()) {
			throw new InvalidCpfException("O CPF não pode ser vazio! -> CPF digitado: ", VCpf);
		}
		else if ((VCpf.replaceAll("\\D", "")).length() != 11) {
			throw new InvalidCpfException("O CPF deve conter 11 digítos numéricos! -> CPF digitado: ", VCpf);
		}
	}
	
	//REGISTER PERSON (MENU)
	public static void registerPerson(Scanner keyboard) throws InvalidNameException, InvalidAgeException, InvalidCpfException{

		//REGISTER
		System.out.println("==============CADASTRO==============");
		
		//NAME
		System.out.println("Nome: ");
		nameNewPerson = keyboard.nextLine();
		validateName(nameNewPerson);

		//CPF
		System.out.println("CPF: ");
		cpfNewPerson = keyboard.nextLine();
		validateCPF(cpfNewPerson);

		//AGE
		System.out.println("Idade: ");
		ageNewPerson = keyboard.nextInt();
		validateAge(ageNewPerson);
	}

	//VIEW RECORDS
	public static void viewRecords(ArrayList<Pessoa> list1){
		for (Pessoa p : list1){
			System.out.println(p);
		}
	}
}
