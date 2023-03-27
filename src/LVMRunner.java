import java.util.*;
public class LVMRunner {

    public static PhysicalHardDrive phd;
    public static PhysicalVolume pv;
    public static LogicalVolume lv;
    public static LVMSystem lvm = new LVMSystem();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the LVM system.");
        String cmd = "";
        while (!cmd.equals("exit")) {
            System.out.print("cmd#: ");
            cmd = s.nextLine();
            String[] str = cmd.split(" ");
            if (str[0].equals("install-drive")) {
                if (str.length != 3) {
                    System.out.println("Invalid command format. Please use: install-drive [drive_name] [size]");
                } else {
                    String driveName = str[1];
                    int size = Integer.parseInt(str[2].substring(0, str[2].length() - 1));
                    lvm.installDrive(driveName, size);
                }
            } else if (str[0].equals("list-drives")) {
                lvm.listDrives();
            } else if (str[0].equals("pvcreate")) {
                if (str.length != 3) {
                    System.out.println("Invalid command format. Please use: pvcreate [pv_name] [drive_name]");
                } else {
                    String pvName = str[1];
                    String drive = str[2];
                    lvm.createPv(pvName, drive);
                }
            } else if (str[0].equals("pvlist")) {
                lvm.listPvs();
            } else if (str[0].equals("vgcreate")) {
                if (str.length != 3) {
                    System.out.println("Invalid command format. Please use: vgcreate [vg_name] [pv_name]");
                } else {
                    String vgName = str[1];
                    String pv = str[2];
                    lvm.createVg(vgName, pv);
                }
            } else if (str[0].equals("vgextend")) {
                if (str.length != 3) {
                    System.out.println("Invalid command format. Please use: vgextend [vg_name] [pv_name]");
                } else {
                    String vg = str[1];
                    String newPV = str[2];
                    lvm.vgExtend(vg, newPV);
                }
            } else if (str[0].equals("vglist")) {
                lvm.listVgs();
            } else if (str[0].equals("lvcreate")) {
                if (str.length != 4) {
                    System.out.println("Invalid command format. Please use: lvcreate [lv_name] [size] [vg_name]");
                } else {
                    String lvName = str[1];
                    int lvSize = Integer.parseInt(str[2].substring(0, str[2].length() - 1));
                    String vgForLV = str[3];
                    lvm.createLv(lvName, lvSize, vgForLV);
                }
            }else if (str[0].equals("lvlist")) {
                lvm.listLvs();
            } else if(str[0].equals("exit")) {
                System.exit(0);
            } else{
                System.out.println("Invalid command.");
            }
        }
    }

}

