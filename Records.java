import java.util.*;

public class Records
{
    protected int id = 0;
    protected LinkedList<Record> records = new LinkedList<Record>();
        
    public Records(){}

    public void add(Record record)
    {
        records.add(record);   
        //System.out.println(record.toString() + " added");
    }
    public Record find(int id)
    {   
        for (Record record : records)
        {   
            if (record.matches(id))
                return record;  
        }
        return null;    
    }
    public void show()
    {
        System.out.println(toString());
    }

    
    
    public String toString()
    {
        String s = "";
        for (Record record : records)
            s += "\n" + record.toString();
        return s;
    }
}
