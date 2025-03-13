package com.atapia.api_PaymentSystems.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tcourses")
@Getter
@Setter
public class TCourse implements Serializable {
    @Id
    @Column(name = "idCourse")
    private UUID idCourse;

    @Column(name = "codCourse", unique = true)
    private String codCourse;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "credits")
    private int credits;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "idTeacher")
    private TTeacher teacher;

    @Column(name = "maxStudents")
    private int maxStudents;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "course")
    private List<TEnrollment> enrollments;

}
