package br.com.gustavo.studentstasks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavo.studentstasks.entities.TaskItem;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {

}
