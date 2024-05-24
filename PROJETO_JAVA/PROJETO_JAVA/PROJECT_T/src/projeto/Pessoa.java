package projeto;

public abstract class Pessoa {

	private String name;
	private int age;
	
	//NAME
	public String getName() {
		return name;
	}
	public void setName(String name) throws NomeInvalidoException {
		if(name.length() < 3 || name.trim().isEmpty()){
			throw new NomeInvalidoException();
		}
		else{
			this.name = name;
		}
	}
	
	//AGE
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws IdadeInvalidaException {
		if(age < 0){
			throw new IdadeInvalidaException();
		}
		else{
			this.age= age;
		}
	}
	
	

}
