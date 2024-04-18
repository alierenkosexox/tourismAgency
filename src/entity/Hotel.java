package entity;

public class Hotel {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String star;
    private boolean carPark;
    private boolean wifi;
    private boolean pool;
    private boolean fitness;
    private boolean concierge;
    private boolean spa;
    private boolean roomService;

    public Hotel(boolean spa, boolean roomService,
                 boolean concierge, boolean fitness,
                 boolean wifi, boolean pool, boolean carPark,
                 String email, String phone, String address,
                 String name, int id, String star) {
        this.spa = spa;
        this.roomService = roomService;
        this.concierge = concierge;
        this.fitness = fitness;
        this.wifi = wifi;
        this.pool = pool;
        this.carPark = carPark;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.name = name;
        this.id = id;
        this.star = star;
    }

    public Hotel() {
    }
}
