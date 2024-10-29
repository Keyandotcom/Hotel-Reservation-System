import java.util.Scanner;

public class Main {
    private static Reservation[] reservations = new Reservation[10];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while(true){
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("[1] Add Single Room Reservation");
            System.out.println("[2] Add Double Room Reservation");
            System.out.println("[3] Check-In Guest");
            System.out.println("[4] Check-out Guest");
            System.out.println("[5] View Reservations");
            System.out.println("[6] Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice){
                case 1:
                    addReservation(1);
                    break;
                case 2:
                    addReservation(2);
                    break;
                case 3:
                    checkInReservation();
                    break;
                case 4:
                    checkOutReservation();
                    break;
                case 5:
                    viewReservations();
                    break;
                case 6:
                    System.out.println("Exiting System..");
                    return;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
    
    private static void addReservation(int roomType){
        System.out.print("\nEnter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        
        //Check if occupied
        for(Reservation res : reservations){
            if (res != null && res.roomNumber == roomNumber){
                System.out.println("Room "+ roomNumber + " is already reserved.");
                return;
                }
            }
        
        Reservation reservation = roomType == 1
                ? new SingleRoom(guestName, roomNumber)
                : new DoubleRoom(guestName, roomNumber);
        
        if (count < reservations.length){
            reservations[count++] = reservation;
            System.out.println("Reservation added for "+ guestName + " in room "+ roomNumber + ".");
        }
        else{
            System.out.println("No rooms available.");
        }
    }
    
    private static void checkInReservation() {
    System.out.print("\nEnter reservation index to check-in: ");
    int index = scanner.nextInt();
    if (index >= 0 && index < count && reservations[index] != null){
        reservations[index].checkIn();
    }
    else{
        System.out.println("Invalid reservation index.");
    }
    }
    
    private static void checkOutReservation() {
    System.out.print("\nEnter reservation index to check-out: ");
    int index = scanner.nextInt();
    if (index >= 0 && index < count && reservations[index] != null){
        reservations[index].checkOut();
    }
    else{
        System.out.println("Invalid reservation index.");
    }
    }
    
    private static void viewReservations(){
        System.out.print("\nEnter reservation index to view details: ");
        int index = scanner.nextInt();
        if(index >= 0 && index < count && reservations[index] != null){
            System.out.println(reservations[index].getDetails());
        }
        else{
            System.out.println("Invalid reservation index.");
        }
    }
}

