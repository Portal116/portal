package com.myboot02.myboot02.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myboot02.myboot02.mapper.UserProfileMapper;
import com.myboot02.myboot02.model.DataObject;
import com.myboot02.myboot02.model.UserProfile;

@RestController
public class HelloController {

//	String[] name = { "kim", "lee", "park", "choi", "jung" };
//	String[] email = { "kim01@naver.com", "lee@mail.com", "park@gmail.com", "choi@daum.net", "jung@mail.com" };
//	private Map<String, UserProfile> userMap;
	
	private UserProfileMapper mapper;

	public HelloController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}

//	@PostConstruct // 서블릿이 실행되지 마자 해당 메소드 수행해라
//	private void init() {
//		userMap = new HashMap<String, UserProfile>();
//		userMap.put("1", new UserProfile("1", "홍길동1", "111", "서울1"));
//		userMap.put("2", new UserProfile("2", "홍길동2", "112", "서울2"));
//		userMap.put("3", new UserProfile("3", "홍길동3", "113", "서울3"));
//		userMap.put("4", new UserProfile("4", "홍길동4", "114", "서울4"));
//		userMap.put("5", new UserProfile("5", "홍길동5", "115", "서울5"));
//	}

//	UserProfile에 있는 자료 조회
	@RequestMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
//		return userMap.get(id);
		return mapper.getUserProfile(id);
	}

//	UserProfile에 있는 모든 자료 조회
	@RequestMapping("/user/all")
	public List<UserProfile> getUserAllProfile() {
//		return new ArrayList<UserProfile>(userMap.values());
		return mapper.getUserAllProfile();
	}

//	UserProfile에 새로운 내용 추가
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
			@RequestParam("phone") String phone, @RequestParam("address") String address) {
//		UserProfile userProfile = new UserProfile(id, name, phone, address);
//		userMap.put(id, userProfile);
		mapper.postUserProfile(id, name, phone, address);
	}

//	UserProfile 내용 수정
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
			@RequestParam("phone") String phone, @RequestParam("address") String address) {
//		UserProfile userProfile = userMap.get(id);
//		userProfile.setName(name);
//		userProfile.setPhone(phone);
//		userProfile.setAddress(address);
		mapper.putUserProfile(id, name, phone, address);
	}

//	UserProfile 삭제
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
//		userMap.remove(id);
		mapper.deleteUserProfile(id);
	}

//	// 브라우저에서 아이디로 요청을 함 이이디는 배열의 인덱스값으로 함 즉 1이 입력되면 1번인덱스의 lee와 lee의 메일이 출력
//	@RequestMapping("/{id}")
//	public DataObject index2(@PathVariable int id) {
//		return new DataObject(id, name[id], email[id]);
//	}

//	@RequestMapping("/{num}")
//	public String index(@PathVariable int num) {
//		int sum = 0;
//		for (int i = 0; i < num; i++) {
//			sum += i;
//		}
//		return "total : 0 ~ " + num + "까지의 합입니다 " + sum;
//	}

}
