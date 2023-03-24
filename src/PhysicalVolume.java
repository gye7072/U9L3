import java.util.ArrayList;

public class PhysicalVolume extends Volume{
    PhysicalHardDrive h;
    public static ArrayList<PhysicalVolume> pvList = new ArrayList<PhysicalVolume>();
    public PhysicalVolume(String name, PhysicalHardDrive hardDrive){
        super(name);
        pvList.add(this);
        h = hardDrive;
    }

    public ArrayList<PhysicalVolume> getPvList() {
        return pvList;
    }

    public int getSize(){
        return h.getSize();
    }

}
