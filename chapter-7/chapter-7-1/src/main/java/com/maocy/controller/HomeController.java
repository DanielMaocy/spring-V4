package com.maocy.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	/**
	 * 主页
	 * @Title: home
	 * @Description: 
	 * @Author: maocy
	 * @Date: 2019年5月22日 上午10:36:52
	 * @return
	 */
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	/**
	 * 上传文件
	 * @Title: upload
	 * @Description: 
	 * @Author: maocy
	 * @Date: 2019年5月22日 上午10:42:33
	 * @param profile
	 * @return
	 */
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(MultipartFile profile) {
		System.out.println(profile.getName());
		System.out.println(profile.getOriginalFilename());
		System.out.println(profile.getContentType());
		System.out.println(profile.isEmpty());
		System.out.println(profile.getSize());
		try {
			profile.transferTo(new File("/data/files/" + profile.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "home";
	}
}
