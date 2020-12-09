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
import br.com.gustavo.studentstasks.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {

	@Autowired
	private StudentService studentService;

	@PostMapping()
	public ResponseEntity<StudentDTO> insert(@RequestBody StudentDTO dto) {
		dto = studentService.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(uri).body(dto);

	}
	
	@PutMapping(value = "/remove/{id}")
	public ResponseEntity<StudentDTO> delete (@PathVariable Long id){
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentDTO dto) {
		dto = studentService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
		StudentDTO studentDTO = studentService.findById(id);
		return ResponseEntity.ok().body(studentDTO);
	}

	@GetMapping
	public ResponseEntity<List<StudentDTO>> findAll() {
		List<StudentDTO> studentDTOList = studentService.findAll();
		return ResponseEntity.ok().body(studentDTOList);
	}

}
