package model.entities;

public class Individual extends TaxPayer {
	
	private Double healthExpenditures;
	
	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		double tax = (anualIncome < 20000.00) ? anualIncome * 0.15 : anualIncome * 0.25;
		tax = (healthExpenditures > 0) ? tax - healthExpenditures * 0.5 : tax;
		return tax;
	}

}
