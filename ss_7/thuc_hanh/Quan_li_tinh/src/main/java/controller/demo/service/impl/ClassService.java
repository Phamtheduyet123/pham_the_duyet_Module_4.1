package controller.demo.service.impl;

import controller.demo.model.ClassRoom;
import controller.demo.repository.IClassroomRepository;
import controller.demo.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassService implements IClassroomService {
@Autowired
private IClassroomRepository iClassroomRepository;
    @Override
    public List<ClassRoom> findAll() {
        return iClassroomRepository.findAll();
    }
}
