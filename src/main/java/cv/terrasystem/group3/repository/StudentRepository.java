package cv.terrasystem.group3.repository;

import cv.terrasystem.group3.model.DataBean;
import cv.terrasystem.group3.model.PayloadResponse;
import cv.terrasystem.group3.model.Student;
import cv.terrasystem.group3.utils.Utils;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.List;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<Student> {
    public Student findByName(String name){
        return find("name", name).firstResult();
    }

    public List<Student> findAllStudent() {
        return listAll();
    }
    public PayloadResponse save(Student student) {
        persist(student);
        if(isPersistent(student)) {
            return Utils.payloadResponse(DataBean.builder()
                    .code(0)
                    .message("Student Persisted with Success")
                    .payload(student)
                    .build());
        }else {
            return Utils.payloadResponse(DataBean.builder()
                            .code(1)
                            .message("Student not persisted")
                            .error(true)
                            .build());
        }
    }
}
