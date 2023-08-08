public class Reservations extends Records {
    private Guests guests = new Guests();
    private Rooms rooms = new Rooms();
    private int reservationId = 1; // Initialize the reservation ID to 1

    
    
    
    
    
    // There are 4 methods in this Class
    // 1. addReservation()
    // 2. showAvailableRooms || Reservation.showAvailableRooms which calls showAvailableRooms from Rooms
    // 3. showAllReservations
    // 4. updateReservations
    
    
    // 1. addReservation()
    public void addReservation() {
        // CODE RELATED TO GUESTS FOR RESERVATION /////////////////////////////////////////////////////////
        // (1) Get guest details from the user
        String guestName = In.readString("Guest Name");
        int guestContact = In.readInt("Guest Contact No");
        Guest newGuest = new Guest(++reservationId, guestName, guestContact);
        guests.add(newGuest);



        // CODE RELATED TO ROOMS FOR RESERVATION/////////////////////////////////////////////////////////

        // (1) Ask for room type and number of nights from the user
        RoomType roomType = In.askRoomType();
        // (2) Find an available room of the specified type
        HotelRooms availableRoom = rooms.findAvailableRoom(roomType);
        
        
        while (availableRoom == null) {
            System.out.println("\nSorry, Currently We do not have any " + roomType + " Type Room available!\n");
            roomType = In.askRoomType();
            availableRoom = rooms.findAvailableRoom(roomType);
        }
        
        
        int noOfNights = In.readInt("No of Nights");
        
        while(noOfNights < 1){
            System.out.println("!!Please input valid number!!");
            noOfNights = In.readInt("No of Nights");
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        // CODE RELATED TO RESERVATION////////////////////////////////////////////////////////////////
        
        // (1) Create a new reservation and update the hotel room's availability
        Reservation newReservation = new Reservation(reservationId, newGuest, availableRoom.getroomId(), roomType, noOfNights);
        availableRoom.setAvailability(false);
        // (2) Add the reservation to the list of records
        add(newReservation);
        System.out.println("\nReservation added successfully!\n");
        System.out.println("--------Reservation details--------\n" + newReservation.toString()+"\n-----------------------------------");
    }

    // 2. showAvailableRooms
    public void showAvailableRooms(){
        rooms.showAvailableRooms();
    }

    // 3. showAllReservations
    public void showAllReservations() {
        if (records.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("------------------All Reservations------------------");
            
            int i = 1;
            for (Record record : records) {
                if (record instanceof Reservation) {
                    System.out.println("\n----------------------------" + "Reservation "+ i);
                    Reservation reservation = (Reservation) record;
                    System.out.println(reservation.toString());
                    i++;
                }
            }
            System.out.println("----------------------  xxxx  ----------------------");
        }
    }

    
    // 4. cancelReservations
    public void cancelReservation(){
        
    }
}
