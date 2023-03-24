import java.util.ArrayList;

public class LogicalVolume extends Volume{
    VolumeGroup vg;
    public int size;
    public static ArrayList<LogicalVolume> lvList = new ArrayList<LogicalVolume>();
    public LogicalVolume(String name, int size, VolumeGroup vg){
        super(name);
        lvList.add(this);
        this.vg = vg;
    }

    public static ArrayList<LogicalVolume> getLvList() {
        return lvList;
    }

    public int getSize(){
        return size;
    }

}
