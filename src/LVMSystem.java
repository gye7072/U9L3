import java.util.ArrayList;
import java.io.Serializable;

//serializable interface to save progress into file
public class LVMSystem implements Serializable{
    public PhysicalHardDrive phd;
    public PhysicalVolume pv;
    public LogicalVolume lv;

    public ArrayList<PhysicalHardDrive> getPhdList() {
        return phd.getPhdList();
    }

    public ArrayList<PhysicalVolume> getPvList() {
        return pv.getPvList();
    }

    public ArrayList<LogicalVolume> getLvList() {
        return lv.getLvList();
    }



}
