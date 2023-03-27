import java.util.*;

public class LVMSystem {
    private ArrayList<PhysicalHardDrive> drives = new ArrayList<PhysicalHardDrive>();
    private ArrayList<LogicalVolume> lvs = new ArrayList<LogicalVolume>();

    private ArrayList<PhysicalVolume> pvs = new ArrayList<PhysicalVolume>();

    private ArrayList<VolumeGroup> vgs = new ArrayList<VolumeGroup>();
    public void installDrive(String name, int size) {
        PhysicalHardDrive drive = new PhysicalHardDrive(name, size);
        drives.add(drive);
        System.out.println("Drive " + drive.getName() + " installed");
    }

    public void listDrives() {
        if (drives.isEmpty()) {
            System.out.println("No drives are installed.");
        } else {
            for (int i = 0; i < drives.size(); i++) {
                System.out.println(drives.get(i).getName() + " [" + drives.get(i).getSize() + "G]" + " [" + drives.get(i).getUUID() + "]");
            }
        }
    }

    private PhysicalHardDrive findDrive(String name) {
        for (PhysicalHardDrive drive : drives) {
            if (drive.getName().equals(name)) {
                return drive;
            }
        }
        return null;
    }

    public void createPv(String name, String driveName) {
        PhysicalHardDrive drive = findDrive(driveName);
        if (drive == null) {
            System.out.println("Drive not found: " + driveName);
        } else {
            PhysicalVolume pv = new PhysicalVolume(name, drive);
            pvs.add(pv);
            System.out.println(pv.getName() + " created");
        }
    }

    public void listPvs() {
        for (int i = 0; i < pvs.size(); i++) {
            System.out.println(pvs.get(i).getName() + ":" + " [" + pvs.get(i).getSize() + "G] " + "[" + pvs.get(i).getUUID() + "]");
        }
    }

    private PhysicalVolume findPV(String name) {
        for (PhysicalVolume pv : pvs) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }


    public void createVg(String vgName, String pvName) {
        PhysicalVolume pv = findPV(pvName);
        if (pv == null) {
            System.out.println("Physical volume not found: " + pvName);
        } else {
            VolumeGroup vg = new VolumeGroup(vgName);
            vg.addPv(pv);
            vgs.add(vg);
            System.out.println(vg.getName() + " created");
        }
    }

    private VolumeGroup findVG(String name) {
        for (VolumeGroup vg : vgs) {
            if (vg.getName().equals(name)) {
                return vg;
            }
        }
        return null;
    }


    public void vgExtend(String vgName, String pvName) {
        VolumeGroup vg = findVG(vgName);
        PhysicalVolume pv = findPV(pvName);
        if (vg == null || pv == null) {
            System.out.println("Volume Group not found: " + vgName + " or Physical volume not found: " + pvName);
        } else {
            vg.addPv(pv);
            System.out.println(pvName + " added to " + vg.getName());
        }
    }

    public void listVgs() {
        for (int i = 0; i < vgs.size(); i++) {
            String str = "";
            for (int j = 0; j < vgs.get(i).getPvs().size(); j++) {
                str += vgs.get(i).getPvs().get(j).getName();
                if (j != vgs.get(i).getPvs().size() - 1) {
                    str += ",";
                }
            }
            System.out.println(vgs.get(i).getName() + ":" + " total:[" + vgs.get(i).getTotalSize() + "G] "
                    + "available:[" + vgs.get(i).getFreeSize() + "G] " + "[" + str + "]" + " [" + pvs.get(i).getUUID() + "]");
        }
    }

    public void createLv(String lvName, int size, String vgName) {
        VolumeGroup vg = findVG(vgName);
        if (vg == null || size > vg.getFreeSize() || vg.getName().equals(lvName)) {
            System.out.println(lvName + " creation failed");
        }
        else{
            LogicalVolume lv = new LogicalVolume(lvName, size, vg);
            vg.addLv(lv);
            System.out.println(lvName + " " + size + "G" + " " + vgName);
            System.out.println(lvName + " created");
        }
    }

    public void listLvs() {
        for (int i = 0; i < vgs.size(); i++) {
            for (int j = 0; j < vgs.get(i).getLvs().size(); j++) {
                System.out.println(vgs.get(i).getLvs().get(j).getName() + ":" + " [" + vgs.get(i).getLvs().get(j).getSize() +
                        "G] " + "[" + vgs.get(i).getName() + "]" + " [" + vgs.get(i).getLvs().get(j).getUUID() + "]");
            }
        }
    }
}


