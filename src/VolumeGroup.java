import java.util.ArrayList;
public class VolumeGroup extends Volume {
    public PhysicalVolume[] pv;
    public LogicalVolume[] lv;
    public int size;

    public VolumeGroup(String name, PhysicalVolume[] pv, LogicalVolume[] lv) {
        super(name);
        this.pv = pv;
        this.lv = lv;
    }

    public int getTotalVGSize() {
        return pv.length * pv[0].getSize();
    }
    public int getTotalFreeSpace(){
        int sum = 0;
        for(int i = 0; i < lv.length; i++){
            //
        }
        return getTotalVGSize();
    }
}
