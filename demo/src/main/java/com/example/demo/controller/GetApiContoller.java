package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiContoller {
	
	@GetMapping(path = "/hello")  //http://localhost:9090/api/get/hello
	public String hello() {
		return "get hello";
	}
	
	@RequestMapping(path = "/hi", method = RequestMethod.GET) //get /post /put /delete
	public String hi() {
		return "hi";
	}
	
	// http://localhost:9090/api/get/path-variable/{name}
	@GetMapping("/path-variable/{id}")
	public String pathVariable(@PathVariable("id") String pathName) {
		System.out.println("PathVariable :"+ pathName);
		return pathName;
	}
	
	//search?q=intellj
	//&oq=intellj
	//&aqs=chrome..69i57j0i10i433j0i10l3j0i10i131i433j0i10l4.1876j0j15
	//&sourceid=chrome
	//&ie=UTF-8
	
	// ?key=value&key2=value2
	
	// http://localhost:9090/api/get/query-param?user=huvi&email=huvi@gmail.com&age=35
	@GetMapping(path = "query-param")
	public String querstParam(@RequestParam Map<String, String> queryParam) {
		StringBuilder sb = new StringBuilder();    
		
 		queryParam.entrySet().forEach( entry ->{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("\n");
			
			sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
		});
		
		return sb.toString();
	}
	
	@GetMapping("query-param02")
	public String queryParam02(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam int age) {
		return name+" "+email+" "+age;
	}
	
	@GetMapping("query-param03")
	public String queryParam03(UserRequest userRequest) { //객체는 requestparam을 선언하지 않는다.
		System.out.println(userRequest.getName());
		System.out.println(userRequest.getEmail());
		System.out.println(userRequest.getAge());
		
		return userRequest.toString();
	}
}
