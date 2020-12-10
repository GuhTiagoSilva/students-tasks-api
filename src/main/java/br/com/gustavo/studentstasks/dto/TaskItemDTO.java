package br.com.gustavo.studentstasks.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.gustavo.studentstasks.entities.Task;
import br.com.gustavo.studentstasks.entities.TaskItem;

public class TaskItemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String title;

	private String description;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date deliveryDate;
	
	private TaskDTO task;
	
	private Boolean isActive;
	
	public TaskItemDTO() {
		
	}

	public TaskItemDTO(Long id, String title, String description, Date deliveryDate, TaskDTO taskDTO, Boolean isActive) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.deliveryDate = deliveryDate;
		this.task = taskDTO;
		this.isActive = isActive;
	}
	
	public TaskItemDTO(TaskItem taskItem) {
		this.id = taskItem.getId();
		this.title = taskItem.getTitle();
		this.description = taskItem.getDescription();
		this.deliveryDate = taskItem.getDeliveryDate();
		this.isActive = taskItem.getIsActive();
		this.task = new TaskDTO(taskItem.getTask());
		
	}
	
	public TaskItemDTO (TaskItem taskItem, Task task) {
		this(taskItem);
		this.task = new TaskDTO(task);
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public TaskDTO getTaskDTO() {
		return task;
	}

	public void setTaskDTO(TaskDTO taskDTO) {
		this.task = taskDTO;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	

}
