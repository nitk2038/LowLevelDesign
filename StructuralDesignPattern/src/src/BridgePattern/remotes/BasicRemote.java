package BridgePattern.remotes;

import BridgePattern.devices.Device;

public class BasicRemote implements  Remote {
    protected Device device;
    public BasicRemote() {};
    public BasicRemote(Device device) {
        this.device = device;
    };

    public void power() {
        System.out.println("---power toggle---");
        if(device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeUp() {
        System.out.println("--device volume up");
        device.setVolume(device.getVolume() + 10);
    }

    public void volumeDown() {
        System.out.println("--device volume down");
        device.setVolume(device.getVolume() - 10);
    }

    public void channelUp() {
        System.out.println("channel UP");
        device.setChannel(device.getChannel() + 1);
    }

    public void channelDown() {
        System.out.println("channel DOWN");
        device.setChannel(device.getChannel() - 1);
    }
}
