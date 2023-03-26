import java.util.ArrayList;

public class LogicalVolume extends Volume{
    VolumeGroup vg;
    public int size;
    public LogicalVolume(String name, int size, VolumeGroup vg){
        super(name);
        this.vg = vg;
        this.size = size;
    }


    public int getSize(){
        return size;
    }

}
