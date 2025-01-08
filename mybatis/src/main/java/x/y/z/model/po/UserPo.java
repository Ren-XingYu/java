package x.y.z.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserPo {
    private Long id;

    private String username;

    private String password;

    private String gender;

    private String address;
}
