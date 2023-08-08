public class Hotel
{
    private Reservations reservations = new Reservations();
    // private Rooms rooms = new Rooms();
    //Constructor
    public Hotel()
    {
        System.out.println("Welcome to Hotel Del Luna!!");
        
        //help();
        menu();
    }

    
    private void help()
    {
        System.out.println("\n1 to see available rooms");
        System.out.println("2 to add a new Reservation");
        System.out.println("3 to see all the reservations");
        System.out.println("4 to update existing Reservation by reservation Id");
        System.out.println("5 to cancel a reservation");
        System.out.println("6 to exit");
        System.out.println("? to see the menu!\n");
    }


    
    // MENU
    private void menu()
    {
        help();
        char option = readOption();
        switch (option)
        {
            case '1': showAvailableRooms(); break;
            case '2': addReservation(); break;
            case '3': showAllReservations(); break;
            case '4': updateReservation(); break;
            case '5': cancelReservation(); break;
            case '6': exit(); return;
            case '?': menu();; break;
            default: error();
        }
    }
    
    // Read Option
    private char readOption()
    {
        System.out.print("Please enter your choice (1, 2, 3, 4, 5, 6, ?): ");
        return In.readChar();
    }
    
    // default option || if there is any invalid option
    private void error()
    {
        System.out.println("No action found. Try again");
        menu();
    }

    
    
    // 1st Option
    private void showAvailableRooms(){
        reservations.showAvailableRooms();
        menu();
    }
    
    
    // 2nd Option;
    private void addReservation()
    {
        reservations.addReservation();
        menu();
    }
    
    // 3rd Option:
    private void showAllReservations(){
        reservations.showAllReservations();
        menu();
    }
    
    // 4th Option;
    private void updateReservation()
    {
        reservations.updateReservation();
        //System.out.println("Pass");
        menu();
    }
    
    
    // 5th Option;
    private void cancelReservation()
    {
        //reservations.cancel();
        System.out.println("Pass");
        menu();
    }
    
    
    // 6th Option;
    private void exit() {
        System.out.println("Exiting the program. Goodbye!");
    }
    
    
    private void searchGuest()
    {
        //reservations.update();
        System.out.println("Pass");
        menu();
    }
    
    
    
}