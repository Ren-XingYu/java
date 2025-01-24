package x.y.z.springboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response<T> {
    private String code;

    private String message;

    private T data;
}
