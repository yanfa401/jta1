package com.xielei.jta1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 描述：
 *
 * @author xielei
 * @date 2019/07/28
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    
    @Id
    private Integer id;
    
    private String name;
    
    private Integer age;
}
