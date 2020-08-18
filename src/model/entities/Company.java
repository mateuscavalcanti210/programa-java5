package model.entities;

public class Company extends TaxPayer {
	
	private Integer numberOfEmployee;
	
	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployee) {
		super(name, anualIncome);
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public Double tax() {
		double tax = (numberOfEmployee > 10) ? anualIncome * 0.14 : anualIncome * 0.16;
		return tax;
	}

}
