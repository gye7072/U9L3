import java.util.UUID;
public class Volume {
    String name;
    String UUID;

    public Volume(String name){
        this.name = name;
        UUIDGenerator u = new UUIDGenerator();
        UUID = u.getUuid();
    }

    public String getName(){
        return name;
    }

    public String getUUID(){
        return UUID;
    }


}
