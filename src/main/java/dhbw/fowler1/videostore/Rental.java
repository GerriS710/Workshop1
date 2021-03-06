package dhbw.fowler1.videostore;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }
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
}
