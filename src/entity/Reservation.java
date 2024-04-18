package entity;

import java.time.LocalDate;
import java.util.Locale;

public class Reservation {
    private int id;
    private int roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;
    private int guestCount;
    private String guestName;
    private String guestPhone;
    private String guestEmail;
    private String guestCitizenId;

    public Reservation() {

    }
}
