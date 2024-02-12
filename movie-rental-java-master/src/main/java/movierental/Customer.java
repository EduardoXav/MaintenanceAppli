package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = addHeaderLine();

        for (Rental rental : rentals) {
            frequentRenterPoints += Rental.frequentRenterPoints(rental);
            result += showFiguresForThisRental(rental, Rental.determineAmounts(rental));
            totalAmount += Rental.determineAmounts(rental);
        }

        // add footer lines
        result += addFooterLines(totalAmount, frequentRenterPoints);

        return result;
    }

    private String addHeaderLine() {
        return "Rental Record for " + getName() + "\n";
    }

    private static String addFooterLines(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\n"
                + "You earned " + frequentRenterPoints + " frequent renter points";
    }

    private static String showFiguresForThisRental(Rental rental, double thisAmount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
    }

}
