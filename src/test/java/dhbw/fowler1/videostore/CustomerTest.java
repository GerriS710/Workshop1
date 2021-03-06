package dhbw.fowler1.videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Arthur Dent");
    }

    @Test
    public void statementRentRegularMovieForOneDay() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 1));

        String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" +
                "Killer Klowns from Outer Space: 1<BR>\n" +
                "<P>You owe <EM>2.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>";
        assertEquals(expected, customer.htmlStatement());
    }

    @Test
    public void statementRentNewReleaseMovieForOneDay() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 1));

        String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" +
                "Awesome New Release: 1<BR>\n" +
                "<P>You owe <EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>";
        assertEquals(expected, customer.htmlStatement());
    }

    @Test
    public void statementRentChildrensMovieForOneDay() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDRENS, 1));

        String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" +
                "Cars: 1<BR>\n" +
                "<P>You owe <EM>1.5</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>";
        assertEquals(expected, customer.htmlStatement());
    }

    @Test
    public void statementRentChildrensMovieForFourDays() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDRENS, 4));

        String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" +
                "Cars: 1<BR>\n" +
                "<P>You owe <EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>";
        assertEquals(expected, customer.htmlStatement());
    }

    @Test
    public void statementRentRegularMovieForThreeDays() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 3));

        String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" +
                "Killer Klowns from Outer Space: 1<BR>\n" +
                "<P>You owe <EM>3.5</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>";
        assertEquals(expected, customer.htmlStatement());
    }

    @Test
    public void statementRentNewReleaseMovieForTwoDays() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 2));

        String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" +
                "Awesome New Release: 2<BR>\n" +
                "<P>You owe <EM>6.0</EM><P>\n" +
                "On this rental you earned <EM>2</EM> frequent renter points<P>";
        assertEquals(expected, customer.htmlStatement());
    }

    @Test
    public void rentOneOfEachTypeForFourDays() throws Exception {
        int daysRented = 4;
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, daysRented));
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, daysRented));
        customer.addRental(getRental("Cars", Movie.CHILDRENS, daysRented));

        String expected = "<H1>Rentals for <EM>Arthur Dent</EM></H1><P>\n" +
                "Killer Klowns from Outer Space: 1<BR>\n" +
                "Awesome New Release: 2<BR>\n" +
                "Cars: 1<BR>\n" +
                "<P>You owe <EM>20.0</EM><P>\n" +
                "On this rental you earned <EM>4</EM> frequent renter points<P>";
        assertEquals(expected, customer.htmlStatement());
    }

    private Rental getRental(String title, int priceCode, int daysRented) {
        Movie movie = new Movie(title, priceCode);
        return new Rental(movie, daysRented);
    }
}