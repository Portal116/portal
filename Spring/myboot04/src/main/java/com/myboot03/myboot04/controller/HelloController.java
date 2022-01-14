package com.myboot03.myboot04.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myboot03.myboot04.repositories.MyDataRepository;

@Controller
public class HelloController {

	@Autowired
	MyDataRepository repository;

	@PostConstruct
	public void init() {
		MyData d1 = new MyData();
		d1.setName("kim");
		d1.setAge(30);
		d1.setEmail("k@naver.com");
		d1.setMemo("this is my data");
		repository.saveAndFlush(d1);

		MyData d2 = new MyData();
		d2.setName("lee");
		d2.setAge(40);
		d2.setEmail("l@naver.com");
		d2.setMemo("this is my data2");
		repository.saveAndFlush(d2);

		MyData d3 = new MyData();
		d3.setName("park");
		d3.setAge(50);
		d3.setEmail("p@naver.com");
		d3.setMemo("this is my data3");
		repository.saveAndFlush(d3);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "this is sample content");

		Iterable<MyData> list = repository.findAll();
		mav.addObject("datalist", list);

		return mav;
	}

//	form post 요청시 처리할 메소드 구현
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("formModel") MyData mydata, @PathVariable("id") Long id,
			ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata");
		Optional<MyData> data = repository.findById(id);
		mav.addObject("formModel", data);

		Iterable<MyData> list = repository.findByIdIs(id);
		mav.addObject("datalist", list);

		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") Long id, ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "delete mydata");
		Optional<MyData> data = repository.findById(id);
		mav.addObject("formModel", data);

		Iterable<MyData> list = repository.findByIdIs(id);
		mav.addObject("datalist", list);

		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView remove(@RequestParam Long id, ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}
