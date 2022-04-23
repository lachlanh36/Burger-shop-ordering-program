package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;



public class BurgerShop {
    ArrayList < String > cart = new ArrayList < String > ();
    ArrayList < Float > cartPrices = new ArrayList < Float > ();
    public BurgerShop() {

    }

    /**
     * Add a burger in the cart
     * 
     * @param name
     * @param price
     */
    int burgerOrdered = 0;
    double time = 0;
    int comboOrdered = 0;
    public void addBurger(String name, float price) {
        // TODO TASK1

        cart.add(name);
        cartPrices.add(price);
        burgerOrdered += 1;
        burger myburger = new burger(burgerr);
        time+=myburger.findTime();
        burgerr = 1;
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
    int burgerr = 0;
    int snack = 0;
    int drink = 0;
    int snackOrdered = 0;
    public void addSnack(String name, float price, SIZE size) {
        // TODO TASK1
        float extra = 0;
        if (size == size.L) {
            extra = 3;
            name = (name + " (L)");
        }
        if (size == size.XL) {
            extra = 4;
            name = (name + " (XL)");
        }
        if (size == size.M) {

            name = (name + " (M)");
        }

        cart.add(name);
        cartPrices.add(price + extra);
        snackOrdered += 1;
        snack mysnack = new snack(snack);
        time+=mysnack.findTime();
        snack = 1;

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
    int drinkOrdered = 0;
    public void addDrink(String name, float price, SIZE size) {
        // TODO TASK1
        float extra = 0;
        if (size == size.L) {
            name = (name + " (L)");
            extra = 3;
        }
        if (size == size.XL) {
            name = (name + " (XL)");
            extra = 4;
        }
        if (size == size.M) {

            name = (name + " (M)");
        }

        cart.add(name);
        cartPrices.add(price + extra);
        drinkOrdered += 1;
        drink mydrink = new drink(drink);
        time+=mydrink.findTime();
        drink = 1;
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
            System.out.println(i + " - " + cart.get(i) + ": $" + String.format("%.02f", (cartPrices.get(i))));
            total += cartPrices.get(i);
        }
        if (cart.size() == 0) {
            MessagesCLI.CART_EMPTY.printMessage();
            return;
        }
        if (total >= discount) {
            total = total * (float) 0.75;
            MessagesCLI.DISCOUNT.printMessage();
        }
        //if (cart.size()<1) {
        //System.out.println("Cart is empty");
        //return;
        //}
        System.out.println("Total: $" + String.format("%.02f", total));
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
        if (size == size.L) {
            cartPrices.add(priceBurger + priceSnack + 3 + (priceDrink + 3) * (float) 0.5);
            cart.add("COMBO : (" + nameBurger + ", " + nameSnack + " (L), " + nameDrink + " (L))");

        }
        if (size == size.XL) {
            cartPrices.add(priceBurger + priceSnack + 4 + (priceDrink + 4) * (float) 0.5);
            cart.add("COMBO : (" + nameBurger + ", " + nameSnack + " (XL), " + nameDrink + " (XL))");
        }
        if (size == size.M) {
            cartPrices.add(priceBurger + priceSnack + (priceDrink) * (float) 0.5);
            cart.add("COMBO : (" + nameBurger + ", " + nameSnack + " (M), " + nameDrink + " (M))");
        }
        burgerr = 1;
        drink = 1;
        snack = 1;
        if (comboOrdered == 0) {
            time += 8.75;
            comboOrdered = 1;
            return;
        }
        if (comboOrdered != 0) {
            time += 1.75;
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
        if (posCart < cart.size() && posCart >= 0) {
            cartPrices.remove(posCart);
            cart.remove(posCart);
        } else {
            MessagesCLI.NOT_VALID_CART_POSITION.printMessage();
        }
    }


    /**
     * removes all elements in the cart
     */
    public void clearCart() {
        // TODO TASK3
        cartPrices.clear();
        cart.clear();
        burgerr = 0;
        snack = 0;
        drink = 0;
    }

    /**
     * This method confirms the order, showing the estimated pick up time. It also
     * give a warning if there are missing opportunities for COMBO menus
     * 
     */
    
    public double findTime(String item, float price) {
        double time = 0;

        if (item.contains("),")) {
            return time;
        }

        if (price > 4 && snack == 1 && item.contains("Burger") == false) {
            time = 0.5;
            System.out.println("hey");
        }
        if (price > 4 && snack == 0 && item.contains("Burger") == false) {
            time = 3;
            System.out.println("hel");
            snack = 1;
        }
        if (price < 5 && drink == 1) {
            time = 0.25;

        }

        if (price < 5 && drink == 0) {
            time = 0.75;
            System.out.println("hi");
            drink = 1;

        }
        if (item.contains("Burger") && burgerr == 1) {
            time = 1;
            System.out.println("hh");
        }
        if (item.contains("Burger") && burgerr == 0) {
            time = 5;
            burgerr = 1;
        }


        return time;

    }

    public int minutes(double time) {

        int t = (int)(100 * time);

        int min = t / 100;

        return min;
    }
    public int seconds(double time) {
        int t = (int)(100 * time);

        int seconds = 60 * (t % 100) / 100;
        return seconds;
    }

    public int hours(double time) {

        int t = (int)(100 * time);

        int hours = t / 3600;
        return hours;
    }



    public void confirmOrder() {
        // TODO TASK4

        if (cart.size() < 1) {
            MessagesCLI.ORDER_INVALID_CART_EMPTY.printMessage();
        }
        for (int j = 0; j < cart.size(); j++) {
            System.out.println(cart.get(j));
        }
        //for (int i=0;i<cart.size();i++) {
        //time+=findTime(cart.get(i),cartPrices.get(i));
        //}
        System.out.println(time);
        burgerr = 0;
        snack = 0;
        drink = 0;
        showCart();
        if (burgerOrdered == 1 && drinkOrdered == 1 && snackOrdered == 1) {
            MessagesCLI.MISSED_COMBO.printMessage();
            return;
        }
        System.out.println("Order confirmed! The estimated waiting time for preparing your order is: " + hours(time) + " hours " + minutes(time) + " minutes " + seconds(time) + " seconds");


        cart.clear();

    }
}