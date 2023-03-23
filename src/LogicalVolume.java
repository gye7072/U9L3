public class LogicalVolume extends Volume{
    VolumeGroup vg;
    public LogicalVolume(String name, VolumeGroup vg){
        super(name);
        this.vg = vg;
    }

    public int getSize(){
        return 1;
    }

}
