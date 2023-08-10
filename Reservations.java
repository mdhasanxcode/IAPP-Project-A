public class Reservations extends Records {
    private Guests guests = new Guests();
    private Rooms rooms = new Rooms();
    private int reservationId = 0;
    private int guestId = 0;
    private String guestName;
    private int guestContact;
    //private int noOfNights;
    
    
    
    
    
    // There are 4 methods in this Class
    // 1. addReservation()
    // 2. showAvailableRooms || Reservation.showAvailableRooms which calls showAvailableRooms from Rooms
    // 3. showAllReservations
    // 4. updateReservations
    
    
    // 1. addReservation()
    public void addReservation() {
        // CODE RELATED TO GUESTS FOR RESERVATION /////////////////////////////////////////////////////////
        // (1) Get guest details from the user
        askGuestName();
        askGuestContact();
        Guest newGuest = new Guest(++guestId, guestName, guestContact);
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
        // (3) No of Nights
        int noOfNights = askNoOfnights();
        ////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        // CODE RELATED TO RESERVATION////////////////////////////////////////////////////////////////
        
        // (1) Create a new reservation and update the hotel room's availability
        Reservation newReservation = new Reservation(++reservationId, newGuest, availableRoom.getroomId(), roomType, noOfNights);
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
            System.out.println("\n---------------No reservations found---------------\n");
        } else {
            System.out.println("------------------All Reservations------------------");
            
            
            for (Record record : records) {
                if (record instanceof Reservation) {
                    System.out.println("\n----------------------------" + "Reservation ID: "+ record.id);
                    Reservation reservation = (Reservation) record;
                    System.out.println(reservation.toString());
                }
            }
            System.out.println("----------------------  xxxx  ----------------------");
        }
    }

    
    // 4. updateReservations
    public void updateReservation() {

        // (1) Ask which reservation
        System.out.println("\n---------------- Update Reservation ----------------\n");
        int requiredReservationId = In.readInt("Reservation ID");
        
        // (2) Find the reservation by ID
        Reservation reservationToUpdate = findReservation(requiredReservationId);
        
        if (reservationToUpdate == null) {
            System.out.println("Reservation with ID " + requiredReservationId + " not found.\n");
            return;
        }


        // (3) Update the reseravtion
        ///// After reservation is found
        ///// (1) Display options
        displayUpdateOption();
        ///// (2) Update details
        updateDetails(reservationToUpdate);
        ///// (3) Update More details?
        char more = updateMoreDetails();
        while(more == 'Y'){
            displayUpdateOption();
            updateDetails(reservationToUpdate);
            more = updateMoreDetails();
        }
    }



    // 5. cancelReservations
    public void cancelReservation() {
        System.out.println("\n---------------- Cancel Reservation ----------------\n");
        int requiredReservationId = In.readInt("Enter the reservation ID: ");
        
        // Find the reservation by ID 
        // and make it reservation to cancel
        Reservation reservationToCancel = findReservation(requiredReservationId);
        
        
        if (reservationToCancel == null) {
            System.out.println("Reservation with ID " + requiredReservationId + " not found.");
            return;
        }
        
        // Update room availability
        Room roomToCancel = reservationToCancel.getRoom();
        if (roomToCancel != null) {
            //roomToCancel.setAvailability(true);
            System.out.println("\n\nRoom to cancel:\n" + roomToCancel.toString());

            
            // Find the room in the Rooms records and update its availability
            for (Record roomRecord : rooms.records) {
                if (roomRecord instanceof HotelRooms && roomRecord.matches(roomToCancel.getroomId())) {
                    HotelRooms canceledRoom = (HotelRooms) roomRecord;
                    canceledRoom.setAvailability(true);
                    break;
                }
            }
        }
        
        // Remove reservation from the list
        records.remove(reservationToCancel);
        
        System.out.println("\n---------------- Reservation canceled successfully! ----------------\n");
    }




    // Methods for Guest Object Making
    // (1) Guest info 1
    public void askGuestName(){
        guestName = In.readString("Guest Name");
    }
    // (1) Guest info 1
    public void askGuestContact(){
        guestContact = In.readInt("Guest Contact No");
    }
    // (3) Guest Info 3
    public int askNoOfnights(){
        int noOfNights = In.readInt("No of Nights");
        
        while(noOfNights < 1){
            System.out.println("!!Please input valid number!!");
            noOfNights = In.readInt("No of Nights");
        }
        return noOfNights;
    }


    // Support mehods for Update Reservation
    // (1) Update Guest Name
    public void updateGuestName(Reservation reservation){
        askGuestName();
        reservation.setGuestName(guestName);
        System.out.println("\n---------- Reservation updated successfully! ----------\n");

    }
    // (2) Update Guest Contact NO
    public void updateGuestContact(Reservation reservation){
        askGuestContact();
        reservation.setGuestContact(guestContact);

        System.out.println("\n---------- Reservation updated successfully! ----------\n");
    }
    // (3) update no of nights
    public void updateNoOfnights(Reservation reservation){
        int nights = askNoOfnights();
        reservation.setNoOfNights(nights);
        
        // Find the reservation (by reservationId) in reservations records and update its toatlAmount and due.
        

        System.out.println("\n---------- Reservation updated successfully! ----------\n");

    }






    // Support methods for upadteReservations
    // (0) Find Reservation by Id
    private Reservation findReservation(int requiredReservationId){
        Reservation soughtReservation = null;
        for (Record record : records) {
            if (record instanceof Reservation && record.matches(requiredReservationId)) {
                soughtReservation = (Reservation) record;
                //System.out.println("\n\nReservation to cancel:\n" + reservationToCancel.toString());
                return soughtReservation;
            }
        }
        return soughtReservation;
        // BE CAREFUL WHILE USING THIS!! 
        // YOU MAY FIND NULL RESERVATION IF THAT RESERVATON IS NOT FOUND!!
    }

    

    // (1) Update Details Shower
    public void displayUpdateOption(){
        System.out.println("\nWhich information do you want to update?");
        System.out.println("1. Guest Name.");
        System.out.println("2. Guest contact number.");
        System.out.println("3. No of nights for the reservation.");
    }

    // Update Details Doer
    public void updateDetails(Reservation reservation){
        char option = In.readOption("your choice (1, 2, 3)");
        switch (option)
        {
            case '1': updateGuestName(reservation); break;
            case '2': updateGuestContact(reservation); break;
            case '3': updateNoOfnights(reservation); break;
            default: In.error(); updateDetails(reservation);; 
        }
    }

    // (3) More update Asker
    public char updateMoreDetails(){
        System.out.print("Do you want to update more details? (y/n): ");
        char more = In.readUpperChar();
        return more;
    }   

}
