public class LVMRunner {
    public static void main(String[] args) {
        Volume v = new Volume("A");
        System.out.println(v.getUUID());
        PhysicalHardDrive p = new PhysicalHardDrive("B", 3);
        System.out.println(p.getUUID());
        System.out.println(p.getSize());
    }
}
