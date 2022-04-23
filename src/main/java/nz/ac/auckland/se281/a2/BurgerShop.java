package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;



public class BurgerShop {
	ArrayList<String> cart = new ArrayList<String>();
	ArrayList<Float> cartPrices = new ArrayList<Float>();
	public BurgerShop() {

	}

	/**
	 * Add a burger in the cart
	 * 
	 * @param name
	 * @param price
	 */
	int burgerOrdered=0;
	double time = 0;
	int comboOrdered=0;
	public void addBurger(String name, float price) {
		// TODO TASK1
		
		cart.add(name);
		cartPrices.add(price);
		burgerOrdered+=1;
		
	}

	/**
	 * add a snack in the cart, if size is L the price should be incremented by $3
	 * if the size is XL the price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 * 
	 * @param name
	 * @param price
	 * @param size
	 */
	int snackOrdered=0;
	public void addSnack(String name, float price, SIZE size) {
		// TODO TASK1
		float extra =0;
		if (size==size.L) {
		extra=3;
		name = (name+" (L)");
		}
		if (size==size.XL) {
			extra=4;
			name = (name+" (XL)");
			}
		if (size==size.M) {
		
			name = (name+" (M)");
			}
		
		cart.add(name);
		cartPrices.add(price+extra);
		snackOrdered+=1;
		
		
	}

	/**
	 * 
	 * add a drink in the cart
	 * 
	 * if size is L the price should be incremented by $3 if the size is XL the
	 * price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 *
	 * @param name
	 * @param price
	 * @param size
	 */
	int drinkOrdered=0;
	public void addDrink(String name, float price, SIZE size) {
		// TODO TASK1
		float extra =0;
		if (size==size.L) {
			name = (name+" (L)");
			extra=3;
			}
			if (size==size.XL) {
				name = (name+" (XL)");
				extra=4;
				}
			if (size==size.M) {
			
				name = (name+" (M)");
				}
			
			cart.add(name);
			cartPrices.add(price+extra);
			drinkOrdered+=1;
			
	}

	/**
	 * print the content of the cart, or print MessagesCLI.CART_EMPTY if the cart is
	 * empty
	 *
	 *
	 */
	public void showCart() {
		// TODO TASK1
		float total = 0;
		float discount = 100;
		for (int i = 0; i < cart.size(); i++) {
			//System.out.println(cart.size());
			  System.out.println(i+" - "+cart.get(i)+": $"+String.format("%.02f", (cartPrices.get(i))));
			  total+=cartPrices.get(i);
			}
		if(cart.size()==0) {
			MessagesCLI.CART_EMPTY.printMessage();
			return;
		}
		if (total>=discount) {
			total=total*(float)0.75;
			MessagesCLI.DISCOUNT.printMessage();
		}
		//if (cart.size()<1) {
			//System.out.println("Cart is empty");
			//return;
		//}
		System.out.println("Total: $"+String.format("%.02f", total));
	}
	
	/**
	 * add a combo in the cart.
	 * 
	 * The price of a combo is the sum of all the items, but the drink would be half
	 * price. Note that in a combo, both snacks and drinks have the same size, and
	 * the combo price must consider the size (@see addSnack and addDrink methods).
	 * 
	 * @param nameBurger
	 * @param priceBurger
	 * @param nameSnack
	 * @param priceSnack
	 * @param nameDrink
	 * @param priceDrink
	 * @param size
	 */
	public void addCombo(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {
		// TODO TASK2
		if (size==size.L) {
			cartPrices.add(priceBurger+priceSnack+3+(priceDrink+3)*(float)0.5);
			cart.add("COMBO : ("+nameBurger+", "+nameSnack+" (L), "+nameDrink+" (L))");
			
		}
		if (size==size.XL) {
			cartPrices.add(priceBurger+priceSnack+4+(priceDrink+4)*(float)0.5);
			cart.add("COMBO : ("+nameBurger+", "+nameSnack+" (XL), "+nameDrink+" (XL))");
		}
		if (size==size.M) {
			cartPrices.add(priceBurger+priceSnack+(priceDrink)*(float)0.5);
			cart.add("COMBO : ("+nameBurger+", "+nameSnack+" (M), "+nameDrink+" (M))");
		}
		
		if (comboOrdered==0) {
		time+=8.75;
		comboOrdered=1;
		return;
		}
		if (comboOrdered!=0) {
			time+=1.75;
		}
	}

	/**
	 * remove the item in the cart specified by the position posCart. Note that the
	 * position of the cart start from zero. if postCart is invalid: posCart < 0 OR
	 * posCart >= size of the cart the method prints
	 * MessagesCLI.NOT_VALID_CART_POSITION
	 * 
	 * @param posCart
	 */
	public void removeItem(int posCart) {
		// TODO TASK3
	}

	/**
	 * removes all elements in the cart
	 */
	public void clearCart() {
		// TODO TASK3
	}

	/**
	 * This method confirms the order, showing the estimated pick up time. It also
	 * give a warning if there are missing opportunities for COMBO menus
	 * 
	 */
	public void confirmOrder() {
		// TODO TASK4
	}
}