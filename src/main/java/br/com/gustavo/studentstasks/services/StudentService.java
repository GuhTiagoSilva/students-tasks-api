package br.com.gustavo.studentstasks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavo.studentstasks.dto.StudentDTO;
import br.com.gustavo.studentstasks.dto.TaskDTO;
import br.com.gustavo.studentstasks.entities.Student;
import br.com.gustavo.studentstasks.entities.Task;
import br.com.gustavo.studentstasks.repositories.StudentRepository;
import br.com.gustavo.studentstasks.repositories.TaskRepository;
import br.com.gustavo.studentstasks.services.exceptions.DatabaseException;
import br.com.gustavo.studentstasks.services.exceptions.ResourceNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Transactional
	public StudentDTO insert(StudentDTO studentDTO) {
		Student student = new Student();
		copyDtoToEntity(studentDTO, student);
		student = studentRepository.save(student);
		return new StudentDTO(student);
	}

	@Transactional(readOnly = true)
	public StudentDTO findById(Long id) {
		Optional<Student> student = studentRepository.findById(id).filter(x -> x.getIsActive() == true);
		Student entity = student.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found: " + id));
		return new StudentDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<StudentDTO> findAll() {
		List<Student> students = studentRepository.findAll().stream().filter(x -> x.getIsActive() == true)
				.collect(Collectors.toList());
		List<StudentDTO> studentDTOList = new ArrayList<>();
		students.forEach(student -> studentDTOList.add(new StudentDTO(student)));
		return studentDTOList;
	}

	public void delete(Long id) {
		Optional<Student> student = studentRepository.findById(id).filter(x -> x.getIsActive() == true);
		Student entity = student.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		entity.setIsActive(false);
		entity = studentRepository.save(entity);
	}

	@Transactional
	public StudentDTO update(Long id, StudentDTO dto) {
		try {
			Student student = studentRepository.getOne(id);
			copyDtoToEntity(dto, student);
			student = studentRepository.save(student);
			return new StudentDTO(student);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Not Found: " + id);
		}
	}

	private void copyDtoToEntity(StudentDTO dto, Student student) {

		student.setEmail(dto.getEmail());
		student.setGender(dto.getGender());
		student.setName(dto.getName());
		student.setPassword(dto.getPassword());
		student.setUsername(dto.getUsername());
		student.setIsActive(dto.getIsActive());

		student.getTasks().clear();

		for (TaskDTO taskDTO : dto.getTasks()) {
			Task task = taskRepository.getOne(taskDTO.getId());
			student.getTasks().add(task);
		}
	}

}
