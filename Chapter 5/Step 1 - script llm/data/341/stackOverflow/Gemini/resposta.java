import java.util.*;

public class Pizza {

    private Pizza(Base base, Set<Topping> toppings) {
        this.base = base;
        this.toppings = toppings;
    }

    public static PizzaBuilder createBuilder(Base pizzaBase) {
        return new PizzaBuilder(new Pizza(pizzaBase, null));
    }

    public static class PizzaBuilder {

        private PizzaBuilder(Pizza pizza) {
            this.pizza = pizza;
        }

        public PizzaBuilder addTopping(Topping topping) {
            Set<Topping> toppings = null;
            if (pizza.toppings == null) {
                toppings = new LinkedHashSet<>(); 
            }else {
                toppings = new LinkedHashSet<>(pizza.toppings);
            }
            toppings.add(topping);
            return new PizzaBuilder(new Pizza(pizza.base, toppings));
        }

        public Pizza build() {
            return pizza;
        }

        private final Pizza pizza;
    }

    public Collection<Topping> getToppings() {
        return Collections.unmodifiableSet(toppings);
    }

    enum Base {
        DEEP_PAN, THIN
    }

    enum Topping {
        MOZZARELLA, TOMATO, ANCHOVIES, PEPPERONI
    }

    private final Base base;
    private final Set<Topping> toppings;

}
