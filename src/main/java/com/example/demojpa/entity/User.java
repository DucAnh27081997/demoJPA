package com.example.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "UUID")
    private String id;

    @Column(name = "AUTHOR_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private AuthorStatus status;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HASH_CODE", unique = true)
    private String hashCode;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode

    @JoinTable(name = "user_rule",  //Tạo ra một join Table tên là "user_rule"
            joinColumns = @JoinColumn(name = "user_id"), // Trong đó, khóa ngoại chính là user_id trỏ tới class hiện tại (User)
            inverseJoinColumns = @JoinColumn(name = "rule_id")) //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Rule)

    private List<Rule> rules;

    public void addRule(Rule rule) {
        if (this.rules == null) {
            this.rules = new ArrayList<>();
        }
        this.rules.add(rule);
    }

    //@ManyToMany : dùng để nói rằng Entity User sẽ có mối quan hệ nhiều nhiều với Rule

    //@JoinTable : mình chỉ ra table trung gian dùng để kết nối 2 bảng như ta thảo luận ở mục 1 trong phần database.
    // Khi 2 tables quan hệ nhiều nhiều thì mình thêm một bảng trung gian.
    // Trong bài này bảng trung gian mình có tên là user_rule.
    // Trong @JoinTable có 3 tham số sau:


}
