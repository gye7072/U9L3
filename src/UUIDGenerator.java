import java.util.UUID;

public class UUIDGenerator {
    String Uuid;
    public UUIDGenerator(){
        UUID a = UUID.randomUUID();
        Uuid = a.toString();
    }

    public String getUuid() {
        return Uuid;
    }
}

