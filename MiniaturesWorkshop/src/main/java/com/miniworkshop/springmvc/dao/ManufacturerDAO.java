package com.miniworkshop.springmvc.dao;

import java.util.List;

import com.miniworkshop.springmvc.model.Manufacturer;

public interface ManufacturerDAO {

	Manufacturer findManufacturerById(int id);

	Manufacturer findManufacturerByName(String manufacturerName);

	void saveManufacturer(Manufacturer manufacturer);

	void updateManufacturer(Manufacturer manufacturer);

	void deleteManufacturerById(String manufacturerId);

	void deleteManufacturerByName(String manufacturerName);

	List<Manufacturer> findAllManufacturers();

}