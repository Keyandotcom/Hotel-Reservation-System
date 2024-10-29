class SingleRoom extends Reservation implements Reservable {
    
    public SingleRoom(String guestName, int roomNumber){
        super(guestName, roomNumber);
    }
    
    @Override
    public void checkIn(){
        if (checkInStatus.equals("Checked-In")){
            System.out.println("Guest is already checked in");
        }
        else{
        checkInStatus = "Checked-In";
        System.out.println(guestName + " has checked into Single Room "+ roomNumber);
    }
}
    
    @Override
    public void checkOut(){
        if (checkInStatus.equals("Not Checked-In")){
            System.out.println("Guest is not checked in");
        }
        else{
        checkInStatus = "Not Checked-In";
        System.out.println(guestName + " has checked-out into Single Room "+ roomNumber);
    }
    }
    
    @Override
    public String getDetails() {
    return "Single Room - Guest: " + guestName + ", Room "+ roomNumber +", "+ checkInStatus;
    }
}

