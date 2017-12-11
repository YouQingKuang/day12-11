package com.taiji.manager.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taiji.manager.sevice.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	//method=RequestMethod.POST
	
//	@GetMapping("toShow")
//	public String getUser() {
//		
//	}
	
	@RequestMapping("getPage")
	public String getPage() {
		
		String json = "{\"page\":1,\"pageSize\":3,\"filter\":{\"filters\":[{\"field\":\"loginName\",\"value\":\"sue\"},{\"field\":\"userName\",\"value\":\"sd\"}],\"logic\":\"and\"},\"sort\":[{\"field\":\"loginName\",\"dir\":\"asc\"},{\"field\":\"email\",\"dir\":\"asc\"}]}";
		
		Map searchParameters = new HashMap<String,String>();
		Map userPage = new HashMap<>();
		HashMap<String,String> filter = new HashMap<String,String>();
		try {
			searchParameters = objectMapper.readValue(json,new TypeReference<Map>() {});
			int page = (int) searchParameters.get("page");
			System.out.println(page);
			int pageSize = (int) searchParameters.get("pageSize");
			System.out.println(pageSize);
			
			filter.put("userName", "User");
			
			userPage = userService.getPage(page, pageSize, null,filter);
			System.out.println(userPage);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "userList";
	}
	
}
