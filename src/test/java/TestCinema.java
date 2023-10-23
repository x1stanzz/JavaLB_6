import org.Exceptions.NegativeValueException;
import org.example.Cinema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
public class TestCinema {
    private Cinema cinema;
    @BeforeEach
    public void SetUp(){
        cinema = new Cinema(10, 15);
    }

    @Test
    public void TestBookSeatsSuccess(){
        Assertions.assertTrue(cinema.bookSeats(1, 2, new int[]{6,7,8}));
    }
    @Test
    public void TestDoubleBooking(){
        cinema.bookSeats(5, 5, new int[]{1,2,3});
        Assertions.assertFalse(cinema.bookSeats(5,5,new int[]{1,2,3}));
    }
    @Test
    public void TestCancelBooking(){
        cinema.bookSeats(1,2,new int[]{1,2,3});
        Assertions.assertTrue(cinema.cancelBooking(1,2,new int[]{1,2,3}));
    }
    @Test
    public void TestCancelNonExistingBooking(){
        Assertions.assertFalse(cinema.cancelBooking(1,2,new int[]{1,2,3}));
    }

    @Test
    public void TestInvalidSeatBooking(){
        Cinema cinema = new Cinema(10, 15);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cinema.bookSeats(4, 6, new int[]{16,17,18});
        });
    }
    @Test
    public void TestNegativeValueBooking(){
        Cinema cinema = new Cinema(10, 15);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cinema.bookSeats(-2, 3, new int[]{7,8,9,10});
        });
    }
    @Test
    public void TestCheckAvailabilitySuccess(){
        cinema.bookSeats(1, 2, new int[]{1, 2, 3, 4 ,5});
        Assertions.assertTrue(cinema.checkAvailability(1, 5));
    }
    @Test
    public void TestCheckAvailabilityWithInvalidInputs(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cinema.checkAvailability(0, 3);
        });
        Assertions.assertThrows(NegativeValueException.class, () -> {
            cinema.checkAvailability(3, -2);
        });
    }
    @Test
    public void TestPrintSeatingArrangementNonExistingHall(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           cinema.printSeatingArrangement(0);
        });
    }
}
