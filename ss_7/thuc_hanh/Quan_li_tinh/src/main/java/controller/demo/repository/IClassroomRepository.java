package controller.demo.repository;

import controller.demo.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassroomRepository extends JpaRepository<ClassRoom,Integer> {
}
