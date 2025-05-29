package ru.miet.CourceTesting.Lr4;

import ru.miet.CourceTesting.Lr3.Smartphone;

/**
 * 
 */
public class IOSSmartphone extends Smartphone {
    private String iosVersion;
    private boolean hasFaceID;
    private boolean isFaceIDEnable;

    public IOSSmartphone(String vendor, String modelName, double displaySize, double thickness, String iosVersion,
	    boolean hasFaceID) {
	super(vendor, modelName, displaySize, "iOS", thickness);
	setIosVersion(iosVersion);
	setHasFaceID(hasFaceID);
	updateStateFaceID(false);
    }

    public String getIosVersion() {
	return iosVersion;
    }

    public void setIosVersion(String iosVersion) {
	this.iosVersion = iosVersion;
    }

    public boolean isHasFaceID() {
	return hasFaceID;
    }

    public void setHasFaceID(boolean hasFaceID) {
	this.hasFaceID = hasFaceID;
    }

    private void updateStateFaceID(boolean state) {
	isFaceIDEnable = state;
    }

    public boolean getStateFaceID() {
	return isFaceIDEnable;
    }

    public void enableFaceID() {
	if (hasFaceID) {
	    System.out.println("Face ID включен на " + getModelName());
	    updateStateFaceID(!isFaceIDEnable);
	} else {
	    System.out.println("Устройство не поддерживает Face ID.");
	}
    }
}
