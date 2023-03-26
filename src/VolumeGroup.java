import java.lang.reflect.Array;
import java.util.*;

public class VolumeGroup extends Volume {
    public ArrayList<PhysicalVolume> pvs = new ArrayList<PhysicalVolume>();
    public ArrayList<LogicalVolume> lvs = new ArrayList<LogicalVolume>();

    public VolumeGroup(String name) {
        super(name);
    }

    public void addPv(PhysicalVolume pv) {
        pvs.add(pv);
    }

    public ArrayList<PhysicalVolume> getPvs() {
        return pvs;
    }

    public ArrayList<LogicalVolume> getLvs() {
        return lvs;
    }

    public void addLv(LogicalVolume lv) {
        lvs.add(lv);
    }


    public int getTotalSize() {
        int totalSize = 0;
        for (PhysicalVolume pv : pvs) {
            totalSize += pv.getSize();
        }
        return totalSize;
    }

    public int getFreeSize() {
        int freeSize = getTotalSize();
        for (LogicalVolume lv : lvs) {
            freeSize -= lv.getSize();
        }
        return freeSize;
    }
}