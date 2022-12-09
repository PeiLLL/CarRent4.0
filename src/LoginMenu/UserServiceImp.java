package LoginMenu;

import User.User;

import java.util.HashMap;

public class UserServiceImp implements UserService {
    UserDao userdao = new UserDaoImp();

     //判断用户名是否存在
    @Override
    public boolean isExists(String username) {
        HashMap<String, User> userMap = userdao.loadUserData();
        return userMap.containsKey(username);
    }

     //注册
    @Override
    public void regist(String username, String password,String address) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        //调用dao将user数据添加到hashmap中
        HashMap<String,User> userMap = userdao.loadUserData();
        //将新用户对象添加到userMap中
        userMap.put(user.getUsername(), user);
        //调用dao将添加后usermap保存到数据文件中
        userdao.saveUserData(userMap);
        System.out.println("注册成功");
        Login.showFirstLevelMeun();
    }

    // 登录
    @Override
    public boolean login(String username, String password) {
        //调用dao将user数据添加到hashmap中
        HashMap<String,User> userMap = userdao.loadUserData();
        if(userMap.containsKey(username)) {
            User user = userMap.get(username);
            if(user.getPassword().equals(password)) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
