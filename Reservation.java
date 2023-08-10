public class Reservation extends Record {
    private Guest guest;
    private HotelRooms room;
    int roomId;
    
    private double totalAmount;
    private double deposit = 0;
    private double due;
    private int noOfNights;

    public Reservation(int id, Guest guest, int roomId, RoomType roomType, int noOfNights) 
    {
        super(id);
        this.guest = guest;
        this.roomId = roomId;
        this.room = new HotelRooms(roomId, roomType);
        this.noOfNights = noOfNights;

        //this.deposit = deposit;
        this.totalAmount = room.getPricePerNight()*noOfNights;
        this.due = totalAmount - deposit;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getDue() {
        return due;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setNoOfNights(int noOfNights){
        this.noOfNights = noOfNights;
        updateTransaction();
    }

    public void updateTransaction(){
        this.totalAmount = room.getPricePerNight()*getNoOfNights();
        this.due = totalAmount - deposit;
    }

    public int getNoOfNights(){
        return noOfNights;
    }

    public void setGuestName(String guestName){
        guest.setGuestName(guestName);
    }

    public void setGuestContact(int guestContact){
        guest.setGuestContact(guestContact);
    }


    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder(super.toString());
        StringBuilder sb = new StringBuilder();
        
        if (room != null) {
            sb.append("----Room Details---").append("\n----Room Id: " + roomId + "\n----Room Type: " + room.getRoomType());
        }

        sb.append("\n\n----Reserved for No of Nights: ").append(noOfNights);
        sb.append("\n\n----Transaction Details----\n----Total Amount: ").append(totalAmount);
        sb.append("\n----Deposit: ").append(deposit);
        sb.append("\n----Due: ").append(due);
        sb.append("\n\n----Guest Details----\n").append(guest.toString());
        
        return sb.toString();
    }
}
