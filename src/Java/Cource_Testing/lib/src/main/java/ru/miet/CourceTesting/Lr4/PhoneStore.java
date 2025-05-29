package ru.miet.CourceTesting.Lr4;

import java.util.ArrayList;
import java.util.List;

import ru.miet.CourceTesting.Lr3.Smartphone;

/**
 * 
 */
public class PhoneStore {
    protected String storeName;
    protected List<Smartphone> smartphones;
    protected List<Smartphone> selledSmartphones;
    protected List<ServiceCenter> certifiedServiceCenter;

    public PhoneStore(String storeName) {
	this.storeName = storeName;
	smartphones = new ArrayList<>();
	selledSmartphones = new ArrayList<>();
	certifiedServiceCenter = new ArrayList<>();
    }

    public String getStoreName() {
	return storeName;
    }

    public void setStoreName(String storeName) {
	if (storeName == null || storeName.trim().isEmpty()) {
	    throw new IllegalArgumentException("Название продавца не может быть пустым");
	}
	this.storeName = storeName;
    }

    public List<Smartphone> getSmartphones() {
	return smartphones;
    }

    public List<Smartphone> getSelledSmartphones() {
	return selledSmartphones;
    }

    public void pushServiceCenter(ServiceCenter sc) {
	if (sc == null) {
	    throw new IllegalArgumentException("Сервисный центр не может быть null");
	}
	certifiedServiceCenter.add(sc);
    }

    public List<ServiceCenter> getCertifiedServiceCenter() {
	return certifiedServiceCenter;
    }

    public void addSmartphone(Smartphone smartphone) {
	if (smartphone == null) {
	    throw new IllegalArgumentException("Смартфон не может быть null");
	}
	smartphones.add(smartphone);
    }

    public void sellSmartphone(Smartphone smartphone) {
	if (smartphone == null) {
	    throw new IllegalArgumentException("Смартфон не может быть null");
	}
	if (!smartphones.contains(smartphone)) {
	    throw new IllegalArgumentException("Смартфон не принадлежит магазину");
	}
	smartphones.remove(smartphone);
	selledSmartphones.add(smartphone);
    }
}
