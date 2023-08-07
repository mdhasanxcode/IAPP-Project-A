public class Guest extends Record {
    private String guestName;
    private int guestContact;
    //private Room guestRoom;

    public Guest(int id, String guestName, int guestContact) {
        super(id);
        this.guestName = guestName;
        this.guestContact = guestContact;
        //this.guestRoom = null; // Guest room is initially not assigned
    }

    public String getGuestName() {
        return guestName;
    }

    public int getGuestContact() {
        return guestContact;
    }


    @Override
    public String toString() {
        //return super.toString() + ", Name: " + guestName + ", Contact: " + guestContact + ", Room: " + (guestRoom == null ? "Not Assigned" : guestRoom.toString());
        return "----Guest " + super.toString() + "\n----Guest Name: " + guestName + "\n----Guest Contact No: " + guestContact;
    }
}
