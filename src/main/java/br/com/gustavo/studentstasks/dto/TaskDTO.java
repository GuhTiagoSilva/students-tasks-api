package br.com.gustavo.studentstasks.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.gustavo.studentstasks.entities.Task;
import br.com.gustavo.studentstasks.entities.TaskItem;

public class TaskDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private List<TaskItemDTO> taskItems = new ArrayList<>();

	public TaskDTO() {

	}

	public TaskDTO(Task task, List<TaskItem> taskItems) {
		this(task);
		taskItems.forEach(taskItem -> this.taskItems.add(new TaskItemDTO(taskItem)));
	}

	public TaskDTO(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public TaskDTO(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
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

	public List<TaskItemDTO> getTaskItems() {
		return taskItems;
	}

	public void setTaskItems(List<TaskItemDTO> taskItems) {
		this.taskItems = taskItems;
	}

}
