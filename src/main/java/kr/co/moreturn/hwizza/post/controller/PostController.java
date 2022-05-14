package kr.co.moreturn.hwizza.post.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

	
	@PostMapping("/")
	public ResponseEntity<Object> post(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
