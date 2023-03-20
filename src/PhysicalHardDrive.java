public class PhysicalHardDrive extends Volume {
    int size;
    public static int count;

    public PhysicalHardDrive(String name, int size){
        super(name);
        this.size = size;
        count++;
    }

    public int getSize(){
        return size;
    }
}
