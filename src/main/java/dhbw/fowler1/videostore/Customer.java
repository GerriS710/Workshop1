package dhbw.fowler1.videostore;

import java.util.Enumeration;
import java.util.Vector;


public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = each.amountCalculation(thisAmount, each);

            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints ++;

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }
<<<<<<< HEAD
=======
    public double amountCalculation(double rentalAmount, Rental eachRental) {
        // determine amount for each line
        switch (eachRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (eachRental.getDaysRented() > 2)
                    rentalAmount += (eachRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += eachRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (eachRental.getDaysRented() > 3)
                    rentalAmount += (eachRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }
>>>>>>> 8573d460a8b15d45aac8e61491786971bf085581

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}
