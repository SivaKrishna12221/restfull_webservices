package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;

public interface ITouristServiceMgmt {

	public String enrollTouristData(Tourist tourist);
	public List<Tourist> fetchTouristData() throws TouristNotFoundException;
	public Tourist fetchTouristDataById(Integer id)
			throws TouristNotFoundException;
	public String modifyTouristData(Tourist tourist)
			throws TouristNotFoundException;
	public String removeTouristData(Integer id) throws TouristNotFoundException;
	// partial updating//if you want to update data means adding some amount of
	// data
	public String updateBudgetByPercentage(Integer Id, Float hikeper)
			throws TouristNotFoundException;

}
