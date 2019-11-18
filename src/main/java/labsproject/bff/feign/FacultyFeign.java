package labsproject.bff.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import labsproject.bff.entity.Faculty;


@FeignClient(name = "university-api", url = "http://localhost:10010")

public interface FacultyFeign {
	@GetMapping("/faculty/list")
	public List<Faculty> getList();
	
	@GetMapping("/faculty/{id}")
	public Faculty getById(@PathVariable Long id);
	
	@PostMapping(path="faculty/add", consumes = {"application/json"})
	public @ResponseBody String Insert (@RequestBody Map<String, Object> json);
	
	@PutMapping(path="faculty/edit/{id}", consumes = {"application/json"})
	public @ResponseBody String Update (@RequestBody Map<String, Object> json, @PathVariable Long id);
}
