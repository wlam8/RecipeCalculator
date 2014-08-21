

import java.math.BigDecimal;


public class Ingredient {
	private boolean isOrganic;
	private Category category;
	private BigDecimal amount;
	private String measurement;
	private String name;
	private BigDecimal cost;

	public Ingredient(boolean isOrganic, Category category, BigDecimal amount, String name, BigDecimal cost) {
		this.isOrganic = isOrganic;			
		this.category = category;			
		this.amount = amount;
		this.measurement = "";			
		this.name = name;			
		this.cost = cost;			
	}

	public Ingredient(boolean isOrganic, Category category, BigDecimal amount, String measurement, String name, BigDecimal cost) {
		this.isOrganic = isOrganic;			
		this.category = category;			
		this.amount = amount;			
		this.measurement = measurement + " of ";			
		this.name = name;			
		this.cost = cost;			
	}
	
    @Override
    public String toString() {
        return name;
    }

	public boolean isOrganic() {
		return isOrganic;
	}

	public Category getCategory() {
		return category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getMeasurement() {
		return measurement;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getCost() {
		return cost;
	}

}
//category