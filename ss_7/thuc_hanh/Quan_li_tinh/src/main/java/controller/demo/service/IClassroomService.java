package controller.demo.service;

import controller.demo.model.ClassRoom;

import java.util.List;

public interface IClassroomService {
    List<ClassRoom> findAll();
}
