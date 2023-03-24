import java.util.ArrayList;
public class VolumeGroup extends Volume {
    public PhysicalVolume pv;
    public LogicalVolume lv;
    public int size;

    public VolumeGroup(String name) {
        super(name);
    }

    public ArrayList<PhysicalVolume> getPvList() {
        return pv.getPvList();
    }

    public ArrayList<LogicalVolume> getLvList() {
        return lv.getLvList();
    }

    public int getTotalVGSize() {
        int sum = 0;
        for(int i = 0; i < getPvList().size(); i++){
            sum += pv.getPvList().get(i).getSize();
        }
        return sum;
    }
    public int getTotalFreeSpace(){
        int freeSpace = getTotalVGSize();
        for(int i = 0; i < getLvList().size(); i++){
            freeSpace -= getLvList().get(i).getSize();
        }
        return freeSpace;
    }
}
