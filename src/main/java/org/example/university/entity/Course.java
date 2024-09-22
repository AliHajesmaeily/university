package org.example.university.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Course extends BaseEntity {

    @Column(unique = true, nullable = false)                        //یونیک هست و قابلیت خلی بودن ندارد
    private int code;

    @Column(nullable = false)
    private String title;                                             //عنوان

    @Column(nullable = false)
    private int units;                                                //واحدها

    @ManyToOne
    @JoinColumn(name = "professor_id")                             // هر درس میتونه یک پروفسور داشته باشه و هر پروفسور چند درس
    private Professor professor;                                    // professor_id ما توجدول کورس ی ستون داریم که قراره آی دی پروفسور رو نگهداری کنه و اسمش

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(                                                              //وقتی چند به چند داریم جدول واسط باید درست کنیم
            name = "Course_Student",                                        //نام جدول واسط
            joinColumns = {@JoinColumn(name = "course_id")},                 //نام ستونی که آی دی کورس رونگهداری میکنه
            inverseJoinColumns = {@JoinColumn (name = "student_id")}         //برای استیودنت هم استیودنت آی دی باشه
    )
    private Set<Student> students = new HashSet<>();         //دانشجو مها نمیتونن تکراری باشن پس بهتره از ست استفاده کنیم


}
