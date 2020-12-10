package br.com.gustavo.studentstasks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gustavo.studentstasks.dto.TaskItemDTO;
import br.com.gustavo.studentstasks.entities.Task;
import br.com.gustavo.studentstasks.entities.TaskItem;
import br.com.gustavo.studentstasks.repositories.TaskItemRepository;
import br.com.gustavo.studentstasks.repositories.TaskRepository;
import br.com.gustavo.studentstasks.services.exceptions.ResourceNotFoundException;

@Service
public class TaskItemService {

	@Autowired
	private TaskItemRepository taskItemRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Transactional
	public TaskItemDTO insert(TaskItemDTO dto) {
		TaskItem taskItem = new TaskItem();
		copyDtoToEntity(taskItem, dto);
		taskItem.setIsActive(true);
		taskItem = taskItemRepository.save(taskItem);
		return new TaskItemDTO(taskItem, taskItem.getTask());
	}

	@Transactional
	public TaskItemDTO update(Long id, TaskItemDTO dto) {
		try {
			TaskItem taskItem = taskItemRepository.getOne(id);

			if (taskItem.getIsActive() == false)
				throw new ResourceNotFoundException("Entity Not Found");
			
			copyDtoToEntity(taskItem, dto);
			taskItem = taskItemRepository.save(taskItem);
			return new TaskItemDTO(taskItem, taskItem.getTask());

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional
	public void delete(Long id) {
		try {
			TaskItem taskItem = taskItemRepository.getOne(id);
			taskItem.setIsActive(false);
			taskItem = taskItemRepository.save(taskItem);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional(readOnly = true)
	public TaskItemDTO findById(Long id) {
		Optional<TaskItem> optional = taskItemRepository.findById(id).filter(x -> x.getIsActive() == true);
		TaskItem entity = optional.orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
		return new TaskItemDTO(entity, entity.getTask());
	}

	@Transactional(readOnly = true)
	public List<TaskItemDTO> findAll() {
		List<TaskItem> taskItems = taskItemRepository.findAll().stream().filter(x -> x.getIsActive() == true)
				.collect(Collectors.toList());
		List<TaskItemDTO> taskItemDtoList = new ArrayList<>();
		taskItems.forEach(item -> taskItemDtoList.add(new TaskItemDTO(item)));
		return taskItemDtoList;

	}

	private void copyDtoToEntity(TaskItem taskItem, TaskItemDTO dto) {

		Optional<Task> task = null;

		if (dto.getTaskDTO() != null) {
			task = taskRepository.findById(dto.getTaskDTO().getId());
			Task entity = task.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
			taskItem.setDeliveryDate(dto.getDeliveryDate());
			taskItem.setDescription(dto.getDescription());
			taskItem.setIsActive(dto.getIsActive());
			taskItem.setTitle(dto.getTitle());
			taskItem.setTask(entity);

		} else {
			taskItem.setDeliveryDate(dto.getDeliveryDate());
			taskItem.setDescription(dto.getDescription());
			taskItem.setIsActive(dto.getIsActive());
			taskItem.setTitle(dto.getTitle());
		}
	}

}
