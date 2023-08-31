package cn.argento.askia.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User4 {
    private Integer id;
    private String name;
    private String address;
    private int age;
    private Date birthday;
    private LocalDateTime upload;
}
