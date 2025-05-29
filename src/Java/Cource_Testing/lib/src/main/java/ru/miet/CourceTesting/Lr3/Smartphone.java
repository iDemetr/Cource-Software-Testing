package ru.miet.CourceTesting.Lr3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Smartphone {

    /**
     * Производитель
     */
    private String vendor;
    /**
     * Название модели
     */
    private String modelName;
    /**
     * Диагональ дисплея
     */
    private double displaySize;
    /**
     * Операционная система
     */
    private String os;
    /**
     * Толщина устройства
     */
    private double thickness;
    /**
     * 
     */
    private List<Smartphone> linkedDevices = new ArrayList<>();

    /**
     * 
     * @param vendor
     * @param modelName
     * @param displaySize
     * @param os
     * @param thickness
     */
    public Smartphone(String vendor, String modelName, double displaySize, String os, double thickness) {
	setVendor(vendor);
	setModelName(modelName);
	setDisplaySize(displaySize);
	setOs(os);
	setThickness(thickness);
    }

    /**
     * 
     * @return
     */
    public String getVendor() {
	return vendor;
    }

    /**
     * 
     * @return
     */
    public String getModelName() {
	return modelName;
    }

    /**
     * 
     * @return
     */
    public double getDisplaySize() {
	return displaySize;
    }

    /**
     * 
     * @return
     */
    public String getOs() {
	return os;
    }

    /**
     * 
     * @return
     */
    public double getThickness() {
	return thickness;
    }

    /**
     * 
     * @return
     */
    public List<Smartphone> getLinkedDevices() {
	return new ArrayList<>(linkedDevices);
    }

    /**
     * 
     * @param vendor
     */
    public void setVendor(String vendor) {
	if (vendor == null || vendor.trim().isEmpty()) {
	    throw new IllegalArgumentException("Производитель не может быть пустым");
	}
	this.vendor = vendor.trim();
    }

    /**
     * 
     * @param modelName
     */
    public void setModelName(String modelName) {
	if (modelName == null || modelName.trim().isEmpty()) {
	    throw new IllegalArgumentException("Название модели не может быть пустым");
	}
	this.modelName = modelName.trim();
    }

    /**
     * 
     * @param displaySize
     */
    public void setDisplaySize(double displaySize) {
	if (displaySize == Double.NaN || displaySize <= 0) {
	    throw new IllegalArgumentException("Диагональ дисплея должна быть положительной");
	}
	this.displaySize = displaySize;
    }

    /**
     * 
     * @param os
     */
    public void setOs(String os) {
	if (os == null || os.trim().isEmpty()) {
	    throw new IllegalArgumentException("ОС не может быть пустой");
	}
	this.os = os.trim();
    }

    /**
     * 
     * @param thickness
     */
    public void setThickness(double thickness) {
	if (thickness == Double.NaN || thickness <= 0) {
	    throw new IllegalArgumentException("Толщина корпуса должна быть положительной");
	}
	this.thickness = thickness;
    }

    /**
     * Выполняет связываение с другой моделью телефона
     * 
     * @param other
     * @throws InvalidLinkingException - если телефоны уже связаны или
     *                                 производитель/системы различны
     */
    public void linkTo(Smartphone other) throws InvalidLinkingException {
	if (this == other) {
	    throw new InvalidLinkingException("Невозможно связать смартфон с самим собой");
	}

	if (linkedDevices.contains(other)) {
	    throw new InvalidLinkingException("Смартфоны уже связаны");
	}

	boolean isSameVendor = this.vendor.equalsIgnoreCase(other.vendor);
	boolean isSameOS = this.os.equalsIgnoreCase(other.os);

	if (!isSameVendor && !isSameOS) {
	    throw new InvalidLinkingException("Связь возможна только при совпадении производителя или ОС");
	}

	this.linkedDevices.add(other);
	other.linkedDevices.add(this);
    }
}