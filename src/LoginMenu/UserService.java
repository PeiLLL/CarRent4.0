package LoginMenu;
    public interface UserService {
        //判断用户名是否已经存在
        boolean isExists(String username);
        //注册一个用户
        void regist(String username, String password,String address);
         //登录
        boolean login(String username, String password);

}
