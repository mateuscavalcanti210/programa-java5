package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> taxPayers = new ArrayList<TaxPayer>();
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char result = sc.next().charAt(0);
			sc.nextLine();
			if (result == 'i') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				TaxPayer tp = new Individual(name, anualIncome, healthExpenditures);
				taxPayers.add(tp);
			}
			else if (result == 'c') {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.print("Number of employees: ");
				int numberOfEmployee = sc.nextInt();
				TaxPayer tp = new Company(name, anualIncome, numberOfEmployee);
				taxPayers.add(tp);
			}
			else {
				System.out.println("It's just 'i' or 'c'!!!");
			}
		}
		
		double sum = 0.0;
		
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp : taxPayers) {
			System.out.println(tp);
			sum += tp.tax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", sum);
		
		sc.close();

	}

}
