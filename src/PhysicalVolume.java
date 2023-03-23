import java.util.ArrayList;

public class PhysicalVolume extends Volume{
    PhysicalHardDrive h;
    public static ArrayList<PhysicalVolume> pv = new ArrayList<PhysicalVolume>();
    public PhysicalVolume(String name, PhysicalHardDrive hardDrive){
        super(name);
        pv.add(this);
        h = hardDrive;
    }

    public int getSize(){
        return h.getSize();
    }

}
