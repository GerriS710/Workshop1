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
    public double amountCalculation(double rentalAmount, Rental each) {
        // determine amount for each line
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (each.getDaysRented() > 2)
                    rentalAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (each.getDaysRented() > 3)
                    rentalAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }
}
