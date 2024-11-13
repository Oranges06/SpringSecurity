package top.oranges.service.impl;

import top.oranges.entity.User;
import top.oranges.mapper.UserMapper;
import top.oranges.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oranges
 * @since 2024-11-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
