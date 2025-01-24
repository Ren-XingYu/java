package x.y.z.mapper;

import x.y.z.model.po.UserPo;

import java.util.List;

public interface UserMapper {
    List<UserPo> selectAll();
}
