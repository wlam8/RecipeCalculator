

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ReciCalc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNewIngMeasurement;
	private JTextField txtNewIngName;
	private JTextField txtNewIngAmount;
	private JTextField txtNewIngPrice;
	private JTextField txtNewReciName;
	private JTextField txtAddIngToReciAmt;
	private JTextField txtAddCategory;
	
	private static ArrayList<Category> listCategory = new ArrayList<Category>();
	private static ArrayList<Ingredient> listIngredient = new ArrayList<Ingredient>();
	private static ArrayList<Recipe> listRecipe = new ArrayList<Recipe>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReciCalc frame = new ReciCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReciCalc() {
		setTitle("Recipe Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel tabIngredients = new JPanel();
		tabbedPane.addTab("Ingredients", null, tabIngredients, null);
		tabIngredients.setLayout(null);
		
		JPanel tabRecipes = new JPanel();
		tabbedPane.addTab("Recipes", null, tabRecipes, null);
		tabRecipes.setLayout(null);
		
		final JComboBox<Recipe> comboBox_1 = new JComboBox<Recipe>();
		comboBox_1.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
		comboBox_1.setBounds(400, 162, 124, 20);
		tabRecipes.add(comboBox_1);
		
		final JComboBox<Ingredient> comboBox_2 = new JComboBox<Ingredient>();
		comboBox_2.setModel(new DefaultComboBoxModel(listIngredient.toArray()));
		comboBox_2.setBounds(400, 187, 124, 20);
		tabRecipes.add(comboBox_2);
		
		final JComboBox<Recipe> comboBox_4 = new JComboBox<Recipe>();
		comboBox_4.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
		comboBox_4.setBounds(400, 365, 124, 20);
		tabRecipes.add(comboBox_4);
		
		final JComboBox<Category> comboBox_3 = new JComboBox<Category>();
		comboBox_3.setBounds(400, 279, 124, 20);
		tabIngredients.add(comboBox_3);
		comboBox_3.setModel(new DefaultComboBoxModel(listCategory.toArray()));
		
		JLabel lblNewIngredient = new JLabel("New Ingredient");
		lblNewIngredient.setBounds(296, 116, 228, 14);
		tabIngredients.add(lblNewIngredient);
		
		JLabel lblAddCategory = new JLabel("Add Category");
		lblAddCategory.setBounds(276, 36, 114, 14);
		tabIngredients.add(lblAddCategory);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(276, 169, 103, 14);
		tabIngredients.add(lblAmount);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(276, 225, 103, 14);
		tabIngredients.add(lblPrice);
		
		JLabel lblMeasurementoptional = new JLabel("Measurement\r\n(Optional)");
		lblMeasurementoptional.setBounds(276, 197, 123, 14);
		tabIngredients.add(lblMeasurementoptional);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(276, 141, 103, 14);
		tabIngredients.add(lblName);
		
		JLabel lblOrganic = new JLabel("Organic");
		lblOrganic.setBounds(276, 252, 103, 14);
		tabIngredients.add(lblOrganic);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(276, 282, 114, 14);
		tabIngredients.add(lblCategory);
		
		txtNewIngMeasurement = new JTextField();
		txtNewIngMeasurement.setBounds(400, 194, 124, 20);
		tabIngredients.add(txtNewIngMeasurement);
		txtNewIngMeasurement.setColumns(10);
		
		txtNewIngName = new JTextField();
		txtNewIngName.setBounds(400, 138, 124, 20);
		tabIngredients.add(txtNewIngName);
		txtNewIngName.setColumns(10);
		
		txtNewIngAmount = new JTextField();
		txtNewIngAmount.setBounds(400, 166, 124, 20);
		tabIngredients.add(txtNewIngAmount);
		txtNewIngAmount.setColumns(10);
		
		txtNewIngPrice = new JTextField();
		txtNewIngPrice.setBounds(400, 222, 124, 20);
		tabIngredients.add(txtNewIngPrice);
		txtNewIngPrice.setColumns(10);
		
		final JCheckBox chckbxIsOrganic = new JCheckBox("");
		chckbxIsOrganic.setBounds(400, 249, 97, 23);
		tabIngredients.add(chckbxIsOrganic);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 256, 434);
		tabIngredients.add(scrollPane_2);
		
		final JTextArea txtrIngredientsList = new JTextArea();
		txtrIngredientsList.setEditable(false);
		scrollPane_2.setViewportView(txtrIngredientsList);
		
		JButton btnPrintIngredients = new JButton("Print Ingredients");
		btnPrintIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					StringBuilder ingredientsTxt = new StringBuilder();
					
					for(Category c : listCategory){
						ingredientsTxt.append(c.getName());
						
						for(Ingredient i : listIngredient){
							if(i.getCategory().equals(c)){
								ingredientsTxt.append("\n  " + i.getAmount() + " ");
								ingredientsTxt.append(i.getMeasurement());
								if(i.isOrganic())
									ingredientsTxt.append("Organic ");
								ingredientsTxt.append(i.getName() + " - $" + i.getCost());
							}
						}
						ingredientsTxt.append("\n\n");
					}
					
					txtrIngredientsList.setText(ingredientsTxt.toString());
				}catch(Exception ex){}
			}
		});
		btnPrintIngredients.setBounds(276, 396, 248, 49);
		tabIngredients.add(btnPrintIngredients);
		
		JButton btnAddIngredient_1 = new JButton("Add Ingredient");
		btnAddIngredient_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String name = txtNewIngName.getText();
					String amount = txtNewIngAmount.getText();
					String measurement = txtNewIngMeasurement.getText();
					String price = txtNewIngPrice.getText();
					boolean isOrganic = chckbxIsOrganic.isSelected();
					Category category = (Category) comboBox_3.getSelectedItem();

					//check whether name is empty
					if(!name.trim().equals("")){
						//check whether measurement is empty
						if(measurement.trim().equals(""))
							listIngredient.add(new Ingredient(isOrganic, category, new BigDecimal(amount), name, new BigDecimal(price)));	
						else
							listIngredient.add(new Ingredient(isOrganic, category, new BigDecimal(amount), measurement, name, new BigDecimal(price)));	
					}
					else
						txtrIngredientsList.setText("Name cannot be empty");

				}catch(NumberFormatException ex){
					txtrIngredientsList.setText("Amount and Price must be in decimal format");
				}/*catch(NullPointerException ex){
					txtrIngredientsList.setText("Category not selected");
				}*/

				
				comboBox_1.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
				comboBox_2.setModel(new DefaultComboBoxModel(listIngredient.toArray()));
				comboBox_3.setModel(new DefaultComboBoxModel(listCategory.toArray()));
				comboBox_4.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
			}
		});
		btnAddIngredient_1.setBounds(276, 310, 123, 23);
		tabIngredients.add(btnAddIngredient_1);
		
		JLabel lblPrintAllIngredients = new JLabel("Print All Ingredients");
		lblPrintAllIngredients.setBounds(296, 371, 228, 14);
		tabIngredients.add(lblPrintAllIngredients);
		
		txtAddCategory = new JTextField();
		txtAddCategory.setBounds(400, 33, 124, 20);
		tabIngredients.add(txtAddCategory);
		txtAddCategory.setColumns(10);
		
		JButton btnNewCategory = new JButton("New Category");
		btnNewCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(!txtAddCategory.getText().trim().equals(""))
						listCategory.add(new Category(txtAddCategory.getText().trim()));
					else
						txtrIngredientsList.setText("Name cannot be empty");
				}catch(Exception ex){}

				comboBox_1.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
				comboBox_2.setModel(new DefaultComboBoxModel(listIngredient.toArray()));
				comboBox_3.setModel(new DefaultComboBoxModel(listCategory.toArray()));
				comboBox_4.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
			}
		});
		btnNewCategory.setBounds(276, 61, 123, 23);
		tabIngredients.add(btnNewCategory);
		
		JLabel lblNewCategory = new JLabel("New Category");
		lblNewCategory.setBounds(296, 11, 94, 14);
		tabIngredients.add(lblNewCategory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 256, 434);
		tabRecipes.add(scrollPane);
		
		final JTextArea txtrRecipesList = new JTextArea();
		txtrRecipesList.setEditable(false);
		scrollPane.setViewportView(txtrRecipesList);
		
		JLabel lblNewRecipe = new JLabel("New Recipe");
		lblNewRecipe.setBounds(304, 11, 220, 14);
		tabRecipes.add(lblNewRecipe);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(276, 36, 46, 14);
		tabRecipes.add(lblName_1);
		
		txtNewReciName = new JTextField();
		txtNewReciName.setBounds(400, 33, 124, 20);
		tabRecipes.add(txtNewReciName);
		txtNewReciName.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(!txtNewReciName.getText().trim().equals(""))
						listRecipe.add(new Recipe(txtNewReciName.getText().trim()));
					else
						txtrRecipesList.setText("Name cannot be empty");
				}catch(Exception ex){}

				comboBox_1.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
				comboBox_2.setModel(new DefaultComboBoxModel(listIngredient.toArray()));
				comboBox_3.setModel(new DefaultComboBoxModel(listCategory.toArray()));
				comboBox_4.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
			}
		});
		btnCreate.setBounds(276, 61, 123, 23);
		tabRecipes.add(btnCreate);
		
		JLabel lblAddIngredients = new JLabel("Add Ingredients to Recipe");
		lblAddIngredients.setBounds(304, 137, 220, 14);
		tabRecipes.add(lblAddIngredients);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setBounds(276, 165, 46, 14);
		tabRecipes.add(lblRecipe);
		
		JLabel lblIngredient = new JLabel("Ingredient");
		lblIngredient.setBounds(276, 190, 68, 14);
		tabRecipes.add(lblIngredient);
		
		JLabel lblAmount_1 = new JLabel("Amount");
		lblAmount_1.setBounds(276, 215, 46, 14);
		tabRecipes.add(lblAmount_1);
		
		txtAddIngToReciAmt = new JTextField();
		txtAddIngToReciAmt.setBounds(400, 212, 124, 20);
		tabRecipes.add(txtAddIngToReciAmt);
		txtAddIngToReciAmt.setColumns(10);
		
		JButton btnAddIngredient = new JButton("Add");
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Recipe recipe = (Recipe) comboBox_1.getSelectedItem();
					Ingredient ingredient = (Ingredient) comboBox_2.getSelectedItem();
					String amt = txtAddIngToReciAmt.getText();
					recipe.add(new BigDecimal(amt), ingredient);
				}catch(NumberFormatException ex){
					txtrRecipesList.setText("Input must be in decimal format");
				}catch(NullPointerException ex){
					txtrRecipesList.setText("Recipe or Ingredient not selected");
				}

				
				comboBox_1.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
				comboBox_2.setModel(new DefaultComboBoxModel(listIngredient.toArray()));
				comboBox_3.setModel(new DefaultComboBoxModel(listCategory.toArray()));
				comboBox_4.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
			}
		});
		btnAddIngredient.setBounds(276, 240, 123, 23);
		tabRecipes.add(btnAddIngredient);
		
		JLabel lblPrintRecipe = new JLabel("Print Recipe Costs");
		lblPrintRecipe.setBounds(304, 340, 220, 14);
		tabRecipes.add(lblPrintRecipe);
		
		JLabel lblRecipe_1 = new JLabel("Recipe");
		lblRecipe_1.setBounds(276, 368, 46, 14);
		tabRecipes.add(lblRecipe_1);
		
		JButton btnPrintRecipe = new JButton("Print Recipe");
		btnPrintRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//Get recipe to print out from combo box
					Recipe r = (Recipe) comboBox_4.getSelectedItem();
					
					StringBuilder recipesTxt = new StringBuilder(r.getName());
					r.calculate();
					
					for(RecipeData ingredientData : r.getIngList()){
						recipesTxt.append("\n  " + ingredientData.getAmount() +  " ");
						recipesTxt.append(ingredientData.getIngredient().getMeasurement());
						if(ingredientData.getIngredient().isOrganic())
							recipesTxt.append("Organic ");
						recipesTxt.append(ingredientData.getIngredient().getName() + " - $");
						recipesTxt.append(ingredientData.getCost());
					}
					
					recipesTxt.append(
							"\n\n  Total Price: $" + r.getTotalPrice() + 
							"\n  Sales Tax: $" + r.getSalesTax() +
							"\n  Wellness Discount: $" + r.getWellDiscount() +
							"\n  Total Cost: $" + r.getTotalCost()
							);
					
					txtrRecipesList.setText(recipesTxt.toString());
				}catch(Exception ex){}
			}
		});
		btnPrintRecipe.setBounds(276, 396, 248, 49);
		tabRecipes.add(btnPrintRecipe);
		
		JPanel tabTests = new JPanel();
		tabbedPane.addTab("Test", null, tabTests, null);
		tabTests.setLayout(null);
		
		JButton btnAddTestIngredients = new JButton("Add Test Ingredients");
		btnAddTestIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listRecipe.clear();
				listIngredient.clear();
				listCategory.clear();

				listCategory.add(new Category("Produce"));
				listCategory.add(new Category("Meat/Poultry"));
				listCategory.add(new Category("Pantry"));
				
				listIngredient.add(new Ingredient(true, listCategory.get(0), new BigDecimal("1"), "clove", "Garlic", new BigDecimal("0.67")));
				listIngredient.add(new Ingredient(false, listCategory.get(0), new BigDecimal("1"), "Lemon", new BigDecimal("2.03")));
				listIngredient.add(new Ingredient(false, listCategory.get(0), new BigDecimal("1"), "cup", "Corn", new BigDecimal("0.87")));

				listIngredient.add(new Ingredient(false, listCategory.get(1), new BigDecimal("1"), "Chicken Breast", new BigDecimal("2.19")));
				listIngredient.add(new Ingredient(false, listCategory.get(1), new BigDecimal("1"), "slice", "Bacon", new BigDecimal("0.24")));

				listIngredient.add(new Ingredient(false, listCategory.get(2), new BigDecimal("1"), "ounce", "Pasta", new BigDecimal("0.31")));
				listIngredient.add(new Ingredient(true, listCategory.get(2), new BigDecimal("0.5"), "cup", "Olive Oil", new BigDecimal(".96")));
				listIngredient.add(new Ingredient(false, listCategory.get(2), new BigDecimal("1"), "cup", "Vinegar", new BigDecimal("1.26")));
				listIngredient.add(new Ingredient(false, listCategory.get(2), new BigDecimal("1"), "teaspoon", "Salt", new BigDecimal("0.16")));
				listIngredient.add(new Ingredient(false, listCategory.get(2), new BigDecimal("1"), "teaspoon", "Pepper", new BigDecimal("0.17")));


				listRecipe.add(new Recipe("Salad Dressing"));
				listRecipe.get(0).add(new BigDecimal("1"), listIngredient.get(0));
				listRecipe.get(0).add(new BigDecimal("1"), listIngredient.get(1));
				listRecipe.get(0).add(new BigDecimal(".75"), listIngredient.get(6));
				listRecipe.get(0).add(new BigDecimal(".75"), listIngredient.get(8));
				listRecipe.get(0).add(new BigDecimal(".5"), listIngredient.get(9));
				
				listRecipe.add(new Recipe("Healthy Chicken Breast"));
				listRecipe.get(1).add(new BigDecimal("1"), listIngredient.get(0));
				listRecipe.get(1).add(new BigDecimal("4"), listIngredient.get(3));
				listRecipe.get(1).add(new BigDecimal(".5"), listIngredient.get(6));
				listRecipe.get(1).add(new BigDecimal(".5"), listIngredient.get(7));

				listRecipe.add(new Recipe("Pasta Fiesta"));
				listRecipe.get(2).add(new BigDecimal("1"), listIngredient.get(0));
				listRecipe.get(2).add(new BigDecimal("4"), listIngredient.get(2));
				listRecipe.get(2).add(new BigDecimal("4"), listIngredient.get(4));
				listRecipe.get(2).add(new BigDecimal("8"), listIngredient.get(5));
				listRecipe.get(2).add(new BigDecimal(".33333"), listIngredient.get(6));
				listRecipe.get(2).add(new BigDecimal("1.25"), listIngredient.get(8));
				listRecipe.get(2).add(new BigDecimal(".75"), listIngredient.get(9));
				
				comboBox_1.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
				comboBox_2.setModel(new DefaultComboBoxModel(listIngredient.toArray()));
				comboBox_3.setModel(new DefaultComboBoxModel(listCategory.toArray()));
				comboBox_4.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
			}
		});
		btnAddTestIngredients.setBounds(153, 64, 220, 77);
		tabTests.add(btnAddTestIngredients);
		
		JButton btnDeleteAllData = new JButton("Delete All Data");
		btnDeleteAllData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listRecipe.clear();
				listIngredient.clear();
				listCategory.clear();
				comboBox_1.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
				comboBox_2.setModel(new DefaultComboBoxModel(listIngredient.toArray()));
				comboBox_3.setModel(new DefaultComboBoxModel(listCategory.toArray()));
				comboBox_4.setModel(new DefaultComboBoxModel(listRecipe.toArray()));
			}
		});
		btnDeleteAllData.setBounds(153, 209, 220, 77);
		tabTests.add(btnDeleteAllData);
		
	}
}
