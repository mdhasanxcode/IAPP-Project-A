import java.util.*;
import java.text.*;
public class In
{   
    private static Scanner in = new Scanner(System.in); 
    public static String nextLine()
    {   
        return in.nextLine();
    }

    public static int nextInt()
    {   
        int i = in.nextInt();
        in.nextLine();
        if(i < 0){
            System.out.println("You have entered negeative number. Please try again!");
            nextInt();
        }
        return i;
    }
    public static double nextDouble()
    {   
        double d = in.nextDouble();
        in.nextLine();
        if(d < 0.0){
            System.out.println("You have entered negeative number. Please try again!");
            nextDouble();
        }
        return d;   
    }


    public static boolean nextBool()
    {   
        boolean b = in.nextBoolean();
        if(b != true || b != false){
            System.out.println("Invalid input. Please try again!");
            nextBool();
        }
        return b;
    }

    // Read Integer
    // public static int readInt(String message)
    // {
    //     System.out.print("Please enter " + message + ": ");
    //     return In.nextInt();
    // }

    public static int readInt(String message) {
        int value = 0;
        boolean validInput = false;
    
        do {
            System.out.print("Please enter " + message + ": ");
            String input = nextLine();
    
            try {
                value = Integer.parseInt(input);
                if(value < 0) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    continue;
                }
                else validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!validInput);
    
        return value;
    }
    

    // Read Double
    public static double readDouble(String message)
    {
        System.out.print("Please enter " + message + ": ");
        return In.nextDouble();
    }

    // Read Charechter
    // public static char readChar()
    // {   
    //     return in.nextLine().charAt(0); 
    // } 

    public static char readChar() {
        String input = nextLine();
        while (input.isEmpty()) {
            System.out.print("Invalid input!!\nPlease enter valid option: ");
            input = nextLine();
        }
        return input.charAt(0);
    }
    

    // Read Upper Charechter
    public static char readUpperChar()
    {   
        try{
            char read =  in.nextLine().toUpperCase().charAt(0); 
            return read;
        }
        catch (StringIndexOutOfBoundsException s){
            return 'N';
        }
    }
    
    //Read String
    public static String readString(String message)
    {
        System.out.print("Please enter " + message + ": ");
        
        String input =  In.nextLine();
        while(input.trim().isEmpty() == true){
            System.out.print("!!!Invalid input!!!\nPlease enter " + message + ": ");
            input = In.nextLine();
        }
        return input;
    }

    //Read Boolean
    public static boolean readBool(String message)
    {
        System.out.print("Please enter " + message + ": ");
        return In.nextBool();
    }

    

    // Format
    public static String format(double amount)
    {   
        DecimalFormat formatter = new DecimalFormat("###,##0.00");
        return formatter.format(amount); 
    }

    public static RoomType askRoomType()
    {
        RoomType selectedRoomType = null;
        System.out.println("Please select from the follwing Categories of Rooms: ");

        for (RoomType roomType : RoomType.values()) {
            System.out.println(roomType.getCategory() + ". " + roomType.name());
        }

        // System.out.println("Please choose a room category: ");
        // int choice = nextInt();
        int choice = readInt("Room Category");

        while (choice > 5 || choice < 1){
            System.out.println("Invalid input. Please enter a valid integer.");
            choice = readInt("Room Category");
        }

        for (RoomType roomType : RoomType.values()) {
            if (roomType.getCategory() == choice) {
                selectedRoomType = roomType;
                break;
            }
        }

        if (selectedRoomType == null) {
            System.out.println("Invalid input. Please try again.");
            askRoomType();
        }

        //System.out.println("You selected: " + selectedRoomType);
        return selectedRoomType;
    }

        // Read Option
        public static char readOption(String message)
        {
            System.out.print("Please enter " + message + ": ");
            return In.readChar();
        }
        
        // default option || if there is any invalid option
        public static void error()
        {
            System.out.println("No action found. Try again");
        }

}
