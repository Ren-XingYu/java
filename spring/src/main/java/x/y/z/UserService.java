package x.y.z;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class UserService {

    @Value("${name}")
    private String name;

    public void show() {
        System.out.println("userService show name=" + name);
    }
}
