package com.xielei.jta1.entity2;

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
 * @date 2019/07/29
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prod")
public class Prod {
    
    @Id
    private Integer id;
    
    private String name;
    
}
