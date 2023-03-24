import java.util.ArrayList;
public class PhysicalHardDrive extends Volume {
    int size;
    public static ArrayList<PhysicalHardDrive> phdList = new ArrayList<PhysicalHardDrive>();

    public PhysicalHardDrive(String name, int size){
        super(name);
        this.size = size;
        phdList.add(this);
    }

    public ArrayList<PhysicalHardDrive> getPhdList() {
        return phdList;
    }

    public int getSize(){
        return size;
    }
}
