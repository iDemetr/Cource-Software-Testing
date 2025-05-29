package ru.miet.CourceTesting.Lr7;

import java.util.List;

import ru.miet.CourceTesting.Lr3.Smartphone;
import ru.miet.CourceTesting.Lr4.PhoneStore;

public class PhoneStoreEx extends PhoneStore {

    public PhoneStoreEx(String storeName) {
	super(storeName);
	// TODO Auto-generated constructor stub
    }

    List<Smartphone> getSmartphonesByOS(String os) {
	return smartphones.stream().filter(x -> x.getOs() == os).toList();
    }
}