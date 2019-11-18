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

import labsproject.bff.entity.Lab;


@FeignClient(name = "university-api", url = "http://localhost:10010")

public interface LabFeign {
	@GetMapping("/lab/list")
	public List<Lab> getList();
    
	@GetMapping("/lab/{id}")
	public Lab getById(@PathVariable Long id);
	
	@PostMapping(path="lab/add", consumes = {"application/json"})
	public @ResponseBody String Insert (@RequestBody Map<String, Object> json);
	
	@PutMapping(path="lab/edit/{id}", consumes = {"application/json"})
	public @ResponseBody String Update (@RequestBody Map<String, Object> json, @PathVariable Long id);
}
