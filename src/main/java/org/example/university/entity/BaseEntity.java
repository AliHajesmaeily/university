package org.example.university.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass                                              //ما نمیخوایم این ی جدول تو دیتا بیس ما باشه بلکه میخوایم کلاس پدر باشه
public class BaseEntity {                                           //چیزایی که توی همه ی انتیتی ها مشترکه میزاریم اینجا
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)              //میخایم ای دی ما بطور خودکار افزایش پیدا کنه
    private Long id;
}
