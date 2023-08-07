public enum RoomType {
    Single(1),
    Double(2),
    JuniorSuite(3),
    HoneymoonSuite(4),
    PresidentialSuite(5);

    private final int category;

    RoomType(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }
}
