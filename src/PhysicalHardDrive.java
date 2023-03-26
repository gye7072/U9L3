import java.util.ArrayList;
public class PhysicalHardDrive extends Volume {
    int size;

    public PhysicalHardDrive(String name, int size){
        super(name);
        this.size = size;
    }

    public int getSize(){
        return size;
    }
}
