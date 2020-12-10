package br.com.gustavo.studentstasks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavo.studentstasks.dto.TaskDTO;
import br.com.gustavo.studentstasks.dto.TaskItemDTO;
import br.com.gustavo.studentstasks.entities.Task;
import br.com.gustavo.studentstasks.entities.TaskItem;
import br.com.gustavo.studentstasks.repositories.TaskItemRepository;
import br.com.gustavo.studentstasks.repositories.TaskRepository;
import br.com.gustavo.studentstasks.services.exceptions.ResourceNotFoundException;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskItemRepository taskItemRepository;

	@Transactional
	public TaskDTO insert(TaskDTO dto) {

		Task task = new Task();
		copyDtoToEntity(task, dto);
		task = taskRepository.save(task);
		return new TaskDTO(task, task.getTaskItems());
	}

	@Transactional
	public TaskDTO update(Long id, TaskDTO dto) {
		try {
			Task task = taskRepository.getOne(id);

			if (task.getIsActive() == false) 
				throw new ResourceNotFoundException("Entity Not Found");
			
			
			copyDtoToEntity(task, dto);
			task = taskRepository.save(task);
			return new TaskDTO(task, task.getTaskItems());

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional
	public void delete(Long id) {
		Optional<Task> optional = taskRepository.findById(id).filter(x -> x.getIsActive() == true);
		Task task = optional.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		task.setIsActive(false);
		task = taskRepository.save(task);
	}

	@Transactional(readOnly = true)
	public TaskDTO findById(Long id) {
		Optional<Task> optional = taskRepository.findById(id).filter(x -> x.getIsActive() == true);
		Task task = optional.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new TaskDTO(task);
	}

	@Transactional(readOnly = true)
	public List<TaskDTO> findAll() {
		List<Task> tasks = taskRepository.findAll().stream().filter(task -> task.getIsActive() == true)
				.collect(Collectors.toList());
		List<TaskDTO> taskDtoList = new ArrayList<>();
		tasks.forEach(dto -> taskDtoList.add(new TaskDTO(dto)));
		return taskDtoList;
	}

	private void copyDtoToEntity(Task entity, TaskDTO dto) {

		entity.setIsActive(dto.getIsActive());
		entity.setTitle(dto.getTitle());
		entity.getTaskItems().clear();
		
		for(TaskItemDTO taskItemDTO : dto.getTaskItems()) {
			Optional<TaskItem> optional = taskItemRepository.findById(taskItemDTO.getId());
			TaskItem taskItem = optional.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
			entity.getTaskItems().add(taskItem);
		}

	}

}
