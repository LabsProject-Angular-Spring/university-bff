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

import labsproject.bff.entity.Lab;
import labsproject.bff.feign.LabFeign;


@RestController
@RequestMapping(path="/lab")
public class LabController {
	
	@Autowired
	private LabFeign labfeign;
	
	@GetMapping("/list")
	public Iterable<Lab> getList(){
		return labfeign.getList();
	}
	
	@GetMapping("/{id}")
	public Lab getById(@PathVariable Long id) {
		return labfeign.getById(id);
	}
	
	@PostMapping(path="/add", consumes = {"application/json"})
	public @ResponseBody String Insert (@RequestBody Map<String, Object> json) {
		try {
			labfeign.Insert(json);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}
	@PutMapping(path="/edit/{id}", consumes = {"application/json"})
	public @ResponseBody String Update (@RequestBody Map<String, Object> json, @PathVariable Long id) {
		try {
			labfeign.Update(json,id);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}
	
}
