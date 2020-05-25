package br.com.angular.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Integer id;
    private String name;
    private String bio;
    private Integer age;
}
