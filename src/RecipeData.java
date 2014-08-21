

import java.math.BigDecimal;
import java.math.RoundingMode;


public class RecipeData {
	private BigDecimal amount;
	private Ingredient ingredient;
	private BigDecimal cost;
	public RecipeData(BigDecimal amount, Ingredient ingredient) {
		this.amount = amount;
		this.ingredient = ingredient;
		cost = ingredient.getCost().multiply(amount).divide(ingredient.getAmount(), 2, RoundingMode.CEILING);
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public BigDecimal getCost() {
		return cost;
	}
}
