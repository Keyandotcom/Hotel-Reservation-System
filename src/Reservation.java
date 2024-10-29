abstract class Reservation {
    protected String guestName;
    protected int roomNumber;
    protected String checkInStatus = "Not Checked-in";
    
    public Reservation(String guestName, int roomNumber){
        this.guestName = guestName;
        this.roomNumber = roomNumber;
    }
    
    public abstract void checkIn();
    public abstract void checkOut();
    public abstract String getDetails();
}
