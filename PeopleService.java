package com.example.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository pr;
	
	
	
	public List<People> getPeople() {
		return pr.findAll();
	}



	public void register(People people) {
		pr.save(people);
	}



	public void deleteperson(int peopleid) {
		pr.deleteById(peopleid);
	}



	public People getPerson(int peopleid) {
		People p = pr.findById(peopleid).get();
		return p;
	}
	
	
	
}
