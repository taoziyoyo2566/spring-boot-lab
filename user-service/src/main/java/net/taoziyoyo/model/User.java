package net.taoziyoyo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // 添加序列化版本号

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 确保类型为 Integer，与数据库中的 INTEGER 类型匹配

    private String name;
    private String email;
}