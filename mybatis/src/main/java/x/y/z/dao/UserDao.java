package x.y.z.dao;

import x.y.z.model.po.UserPo;

import java.util.List;

public interface UserDao {

    List<UserPo> selectAll();
}
