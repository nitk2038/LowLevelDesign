package BridgePattern.remotes;

import BridgePattern.devices.Device;

public class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Adv remote: mute volume");
        device.setVolume(0);
    }
}