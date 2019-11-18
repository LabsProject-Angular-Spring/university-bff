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

import labsproject.bff.entity.Building;
import labsproject.bff.feign.BuildingFeign;


@RestController
@RequestMapping(path="/building")
public class BuildingController {
	
	@Autowired
	private BuildingFeign buildingFeign;
	
	@GetMapping("/list")
	public Iterable<Building> getList(){
		return buildingFeign.getList();
	}
	
	@GetMapping("/{id}")
	public Building getById(@PathVariable Long id) {
		return buildingFeign.getById(id);
	}
	
	@PostMapping(path="/add", consumes = {"application/json"})
	public @ResponseBody String Insert (@RequestBody Map<String, Object> json) {
		try {
			buildingFeign.Insert(json);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}
	@PutMapping(path="/edit/{id}", consumes = {"application/json"})
	public @ResponseBody String Update (@RequestBody Map<String, Object> json, @PathVariable Long id) {
		try {
			buildingFeign.Update(json,id);
			return "Saved";	
		}
		catch(Exception ex){
			return "Error: "+ex;	
		}			
	}
	
	
}
