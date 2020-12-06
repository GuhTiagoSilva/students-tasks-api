package br.com.gustavo.studentstasks.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.gustavo.studentstasks.entities.TaskItem;

public class TaskItemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String title;

	private String description;

	private LocalDate deliveryDate;
	
	private TaskDTO taskDTO;
	
	public TaskItemDTO() {
		
	}

	public TaskItemDTO(Long id, String title, String description, LocalDate deliveryDate, TaskDTO taskDTO) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.deliveryDate = deliveryDate;
		this.taskDTO = taskDTO;
	}
	
	public TaskItemDTO(TaskItem taskItem) {
		this.id = taskItem.getId();
		this.title = taskItem.getTitle();
		this.description = taskItem.getDescription();
		this.deliveryDate = taskItem.getDeliveryDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public TaskDTO getTaskDTO() {
		return taskDTO;
	}

	public void setTaskDTO(TaskDTO taskDTO) {
		this.taskDTO = taskDTO;
	}
	
	

}
