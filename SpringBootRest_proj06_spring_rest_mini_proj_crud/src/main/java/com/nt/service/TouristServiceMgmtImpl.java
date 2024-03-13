package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.repo.CustomTouristRepository;

@Service("service")
public class TouristServiceMgmtImpl implements ITouristServiceMgmt {

	@Autowired
	private CustomTouristRepository tourRepo;
	@Override
	public String enrollTouristData(Tourist tourist) {
		int id = tourRepo.save(tourist).getTid();
		return id + ": tourist is Addedd successfully";
	}
	@Override
	public List<Tourist> fetchTouristData() throws TouristNotFoundException {

		List<Tourist> list = tourRepo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));

		if (list.isEmpty()) {
			throw new TouristNotFoundException("data not found");
		}
		return list;

	}
	@Override
	public Tourist fetchTouristDataById(Integer id)
			throws TouristNotFoundException {
		Optional<Tourist> opt = tourRepo.findById(id);
		if (opt.isEmpty()) {
			throw new TouristNotFoundException("tourist not found exception");
		} else {
			return opt.get();
		}

	}
	@Override
	public String modifyTouristData(Tourist tourist)
			throws TouristNotFoundException {

		int id = tourist.getTid();
		Optional<Tourist> opt = tourRepo.findById(id);
		if (opt.isPresent()) {
			Tourist tour = tourRepo.save(tourist);
			return tour.getTid() + ": tourist modify successfully";
		} else {
			throw new TouristNotFoundException(id + ":tourist not found");
		}
	}
	@Override
	public String removeTouristData(Integer id)
			throws TouristNotFoundException {
		Optional<Tourist> opt = tourRepo.findById(id);
		if (opt.isPresent()) {
			tourRepo.deleteById(id);
			return id + ": id  tourist data is deleted successfully ";
		} else {
			throw new TouristNotFoundException(id + ":is not found ");
		}
	}
	@Override
	public String updateBudgetByPercentage(Integer Id, Float hikeper)
			throws TouristNotFoundException {
		Optional<Tourist> opt = tourRepo.findById(Id);
		if (opt.isPresent()) {
			Tourist tourist = opt.get();
			Double budget = tourist.getBudget()
					+ tourist.getBudget() * hikeper / 100;
			tourist.setBudget(budget);
			return Id + ": budget is updated successfully .Now the budget is=>"
					+ budget;
		} else {
			throw new TouristNotFoundException(Id + ": not found");
		}
	}
}
