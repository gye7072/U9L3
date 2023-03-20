public class PhysicalVolume extends Volume{
    PhysicalHardDrive h;
    public PhysicalVolume(String name, PhysicalHardDrive hardDrive){
        super(name);
        h = hardDrive;
    }

    public int getSize(){
        return h.getSize();
    }
}
