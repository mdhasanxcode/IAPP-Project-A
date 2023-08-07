public class Rooms extends Records
{
    public Rooms(){
        make10HotelRooms();
    }

    public void make10HotelRooms(){
        int i = 1;
        add(new HotelRooms(i, RoomType.Single));
        add(new HotelRooms(++i, RoomType.Single));
        add(new HotelRooms(++i, RoomType.Double));
        add(new HotelRooms(++i, RoomType.Double));
        add(new HotelRooms(++i, RoomType.JuniorSuite));
        add(new HotelRooms(++i, RoomType.JuniorSuite));
        add(new HotelRooms(++i, RoomType.HoneymoonSuite));
        add(new HotelRooms(++i, RoomType.HoneymoonSuite));
        add(new HotelRooms(++i, RoomType.PresidentialSuite));
        add(new HotelRooms(++i, RoomType.PresidentialSuite));
    }


    public void showAvailableRooms() {
        System.out.println("Available Hotel Rooms:\n");
        for (Record record : records) {
            if (record instanceof HotelRooms) {
                HotelRooms room = (HotelRooms) record;
                if (room.isAvailable()) {
                    System.out.println(room.toString()+"\n");
                }
            }
        }
    }

    public HotelRooms findAvailableRoom(RoomType roomType) {
        for (Record record : records) {
            if (record instanceof HotelRooms) {
                HotelRooms room = (HotelRooms) record;
                if (room.getRoomType() == roomType && room.isAvailable()) {
                    return room;
                }
            }
        }
        return null;
    }
    
    
}