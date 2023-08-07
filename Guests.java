import java.util.LinkedList;

public class Guests {
    private LinkedList<Guest> guestsList = new LinkedList<>();

    public Guests() {}

    public void add(Guest guest) {
        guestsList.add(guest);
    }

    public Guest find(int id) {
        for (Guest guest : guestsList) {
            if (guest.matches(id)) {
                return guest;
            }
        }
        return null;
    }

    public void showAllGuests() {
        if (guestsList.isEmpty()) {
            System.out.println("No guests found.");
        } else {
            System.out.println("All Guests:");
            for (Guest guest : guestsList) {
                System.out.println(guest.toString());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Guest guest : guestsList) {
            sb.append("\n").append(guest.toString());
        }
        return sb.toString();
    }
}
