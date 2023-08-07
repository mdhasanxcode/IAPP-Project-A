public class HotelRooms extends Room{

    public HotelRooms(int id, RoomType roomType) {
        super(id+100);

        if(roomType == RoomType.Single) {
            this.roomType = roomType;
            this.noOfBeds = 1;
            this.pricePerNight = 100;
        }

        else if (roomType == RoomType.Double){
            this.roomType = roomType;
            this.noOfBeds = 2;
            this.pricePerNight = 150;
        }
        
        if(roomType == RoomType.JuniorSuite) {
            this.roomType = roomType;
            this.noOfBeds = 3;
            this.pricePerNight = 200;
        }

        else if (roomType == RoomType.HoneymoonSuite){
            this.roomType = roomType;
            this.noOfBeds = 4;
            this.pricePerNight = 250;
        }

        else if (roomType == RoomType.PresidentialSuite){
            this.roomType = roomType;
            this.noOfBeds = 4;
            this.pricePerNight = 300;
        }
    }


    
    
    
}