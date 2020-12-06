package br.com.gustavo.studentstasks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavo.studentstasks.repositories.TaskItemRepository;

@Service
public class TaskItemService {
	
	@Autowired
	private TaskItemRepository taskItemRepository;
}
