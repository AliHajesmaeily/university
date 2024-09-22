package org.example.university.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.university.enums.Gender;

import java.util.Date;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String family;

    @Column(unique = true,nullable = true)                                // قابل آپدیت شدن نیست
    private long nationalCod;

    @Enumerated(EnumType.STRING)                                           //شیوه ی ذخیره سازی استیرینگ
    @Column(nullable = false)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)                                      // زمان نقش بستن
    @Column(nullable = false)
    private Date birthDay;

    @Column(unique = true,nullable = false,updatable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

}
