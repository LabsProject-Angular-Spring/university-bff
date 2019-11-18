package labsproject.bff.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import labsproject.bff.entity.Faculty;
import labsproject.bff.feign.FacultyFeign;

@RestController
@RequestMapping(path="/faculty")
public class FacultyController {
	
	@Autowired
	private FacultyFeign facultyfeign;
	
	@GetMapping("/list")
	public Iterable<Faculty> getList(){
		return facultyfeign.getList();
	}
	
	@GetMapping("/{id}")
	public Faculty getById(@PathVariable Long id) {
		return facultyfeign.getById(id);
	}
	
	@PostMapping(path="/add", consumes = {"application/json"})
	public @ResponseBody String Insert (@RequestBody Map<String, Object> json) {
		try {
			facultyfeign.Insert(json);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}
	@PutMapping(path="/edit/{id}", consumes = {"application/json"})
	public @ResponseBody String Update (@RequestBody Map<String, Object> json, @PathVariable Long id) {
		try {
			facultyfeign.Update(json,id);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}
	
	
}
