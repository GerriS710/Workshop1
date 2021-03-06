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
    public double amountCalculation() {
        // determine amount for each line
        double rentalAmount = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (this.getDaysRented() > 2)
                    rentalAmount += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (this.getDaysRented() > 3)
                    rentalAmount += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }
}
