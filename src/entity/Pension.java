package entity;

public class Pension {
    private int id;
    private int hotelId;
    private String pension_type;

    public Pension(int hotelId, String pension_type) {
        this.hotelId = hotelId;
        this.pension_type = pension_type;
    }

    public Pension(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getPension_type() {
        return pension_type;
    }

    public void setPension_type(String pension_type) {
        this.pension_type = pension_type;
    }
}