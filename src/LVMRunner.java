import java.util.Scanner;
public class LVMRunner {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        System.out.println("Welcome to the LVM system.");
        System.out.print("cmd#: ");
        String cmd = s.nextLine();
        while(!cmd.equals("exit")){
            if(cmd.contains("install-drive")){
                cmd = cmd.substring(cmd.indexOf(" "));
                PhysicalHardDrive ph1 = new PhysicalHardDrive(cmd.substring(0,cmd.indexOf(" ")), 6);
                System.out.print(ph1.getName());
                System.out.print(ph1.getSize());
            }
        }
        Volume v = new Volume("A");
        System.out.println(v.getName() + " " + v.getUUID());
        PhysicalHardDrive p = new PhysicalHardDrive("B", 3);
        System.out.println(p.getName() + " " + p.getUUID());
        System.out.println(p.getName() + " " + p.getSize());
    }
}
