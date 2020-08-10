package com.acat.listdemo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acat.listdemo.entity.Human;

@Controller
public class ListController {
	
	public List<Human> fakeRepositoryHumanList() {
		List<Human> lists = new ArrayList<>();
		Human obj1 = new Human();
		obj1.setWeight(12);
		
		Human obj2 = new Human();
		obj2.setWeight(23);
		
		Human obj3 = new Human();
		obj3.setWeight(100);
		
		Human obj4 = new Human();
		obj4.setWeight(18);
		
		lists.add(obj1);
		lists.add(obj2);
		lists.add(obj3);
		lists.add(obj4);
		return lists;
	}

	@GetMapping("/")
	public String showList(Model model) {
		model.addAttribute("humans", fakeRepositoryHumanList());
		model.addAttribute("byWeightDesc", Comparator.comparing(Human::getWeight).reversed());
		return "show-lists";
	}
}
