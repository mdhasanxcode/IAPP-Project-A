public abstract class Room extends Record {
    protected double pricePerNight;
    protected int noOfBeds;
    protected boolean availability = true;
    protected RoomType roomType;


    public Room(int id) {
        super(id);
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getroomId(){
        return id;
    }

    @Override
    public String toString() {
        return "Room " + super.toString() + "\tRoom Type: " + roomType +"\nPrice per Night: " + pricePerNight + "\tNo of Beds: " + noOfBeds + "\tAvailability: " + availability;
    }
}
