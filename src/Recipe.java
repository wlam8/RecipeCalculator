

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Recipe {
	private String name;
	private ArrayList<RecipeData> ingList = new ArrayList<RecipeData>();
	private BigDecimal totalPrice = new BigDecimal("0");
	private BigDecimal salesTax = new BigDecimal("0");
	private BigDecimal wellDiscount = new BigDecimal("0");
	private BigDecimal totalCost = new BigDecimal("0");
	
	public Recipe(String name) {
		this.name = name;
	}
	
    @Override
    public String toString() {
        return name;
    }

	public void add(BigDecimal amount, Ingredient ingredient) {
		ingList.add(new RecipeData(amount, ingredient));
	}

	public void calculate() {
		totalPrice = salesTax = wellDiscount = totalCost = new BigDecimal("0");
		for (RecipeData r : ingList){
			totalPrice = totalPrice.add(r.getCost());

			//Sales tax if ingredient is not a produce
			if(!r.getIngredient().getCategory().getName().equals("Produce")){
				salesTax = salesTax.add(r.getCost());
			}
			
			//Wellness Discount if ingredient is organic
			if(r.getIngredient().isOrganic()){
				wellDiscount = wellDiscount.add(r.getCost());
			}
		}
		
		//Performing rounding calculations
		BigDecimal tax = new BigDecimal(".086");
		BigDecimal centsDivider = new BigDecimal(".07");
		salesTax = salesTax.multiply(tax)
				.divide(centsDivider, 0, RoundingMode.CEILING)
				.multiply(centsDivider);
		//salesTax = 0.07*Math.ceil(salesTax*.086/0.07);
		//salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
		wellDiscount = (wellDiscount.multiply(new BigDecimal(".05"))).setScale(2, RoundingMode.CEILING);

		totalCost = totalPrice.add(salesTax).subtract(wellDiscount);
	}
		
	public String getName() {
		return name;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public BigDecimal getSalesTax() {
		return salesTax;
	}

	public BigDecimal getWellDiscount() {
		return wellDiscount;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	public ArrayList<RecipeData> getIngList() {
		return ingList;
	}
}
