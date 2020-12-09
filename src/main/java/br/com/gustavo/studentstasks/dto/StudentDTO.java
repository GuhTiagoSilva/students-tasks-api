package br.com.gustavo.studentstasks.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.gustavo.studentstasks.entities.Student;
import br.com.gustavo.studentstasks.entities.Task;

public class StudentDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String username;

	private String password;

	private String email;

	private Boolean gender;
	
	private Boolean isActive;

	private List<TaskDTO> tasks = new ArrayList<>();

	public StudentDTO() {

	}

	public StudentDTO(Student student) {
		this.id = student.getId();
		this.name = student.getName();
		this.username = student.getUsername();
		this.password = student.getPassword();
		this.email = student.getEmail();
		this.gender = student.getGender();
		this.isActive = student.getIsActive();
	}

	public StudentDTO(Long id, String name, String username, String password, String email, Boolean gender, Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.isActive = isActive;
	}

	public StudentDTO(Student student, List<Task> tasks) {
		this(student);
		tasks.forEach(task -> this.tasks.add(new TaskDTO(task)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	public List<TaskDTO> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<TaskDTO> tasks) {
		this.tasks = tasks;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
