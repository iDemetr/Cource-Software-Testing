package ru.miet.CourceTesting.Lr4;

import ru.miet.CourceTesting.Lr3.Smartphone;

/**
 * 
 */
public class AndroidSmartphone extends Smartphone {
    private String androidVersion;
    private boolean hasNFC;
    private boolean isNFCEnable;

    public AndroidSmartphone(String vendor, String modelName, double displaySize, double thickness,
	    String androidVersion, boolean hasNFC) {
	super(vendor, modelName, displaySize, "Android", thickness);
	setAndroidVersion(androidVersion);
	setHasNFC(hasNFC);
	updateStateNFC(false);
    }

    public String getAndroidVersion() {
	return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
	this.androidVersion = androidVersion;
    }

    public boolean isHasNFC() {
	return hasNFC;
    }

    public void setHasNFC(boolean hasNFC) {
	this.hasNFC = hasNFC;
    }

    private void updateStateNFC(boolean state) {
	isNFCEnable = state;
    }

    public boolean getStateNFC() {
	return isNFCEnable;
    }

    public void enableNFC() {
	if (hasNFC) {
	    System.out.println("NFC включен на " + getModelName());
	    updateStateNFC(!isNFCEnable);
	} else {
	    System.out.println("Устройство не поддерживает NFC.");
	}
    }
}
