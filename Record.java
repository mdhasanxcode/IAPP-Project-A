public class Record
{
    protected int id;
    public Record(int id)
    {
        this.id = id;
    }
    public boolean matches(int id)
    {
        return this.id == id;
    }
    public String toString()
    {
        return "Id: " + id;
    }
}