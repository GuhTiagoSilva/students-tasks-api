package br.com.gustavo.studentstasks.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gustavo.studentstasks.dto.StudentDTO;
import br.com.gustavo.studentstasks.dto.TaskItemDTO;
import br.com.gustavo.studentstasks.services.TaskItemService;

@RestController
@RequestMapping(value = "/taskItems")
public class TaskItemResource {

	@Autowired
	private TaskItemService taskItemService;
	
	@PostMapping
	public ResponseEntity<TaskItemDTO> insert(@RequestBody TaskItemDTO dto) {
		dto = taskItemService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TaskItemDTO> update(@PathVariable Long id, @RequestBody TaskItemDTO dto) {
		dto = taskItemService.update(id, dto);
		return ResponseEntity.ok(dto);
	}

	@PutMapping(value = "/remove/{id}")
	public ResponseEntity<StudentDTO> delete(@PathVariable Long id) {
		taskItemService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskItemDTO> findById(@PathVariable Long id) {
		TaskItemDTO taskDTO = taskItemService.findById(id);
		return ResponseEntity.ok(taskDTO);
	}

	@GetMapping
	public ResponseEntity<List<TaskItemDTO>> findAll() {
		List<TaskItemDTO> taskDtoList = taskItemService.findAll();
		return ResponseEntity.ok(taskDtoList);
	}

	
	
}
