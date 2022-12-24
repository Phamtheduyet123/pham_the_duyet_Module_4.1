package com.example.demo.reponsitory;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public interface IBookReponsitory extends JpaRepository<Book,Integer> {
    List<Book> findAllByNamebookContaining(String name);
    //    @Query(value = "select s from student s where s.nameStudent like :name")
//    List<Student> searchName(@Param("name") String name);

    //Các truy vấn mà thay đổi dữ liệu thì cần dùng 2 annotation bên dưới
//    @Modifying
    @Query(value="select * from book where namebook like :name",nativeQuery=true)
    List<Book> searchName(@Param("name")String name);

}
