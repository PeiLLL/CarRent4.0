package LoginMenu;

import User.User;

import java.util.HashMap;

public class UserServiceImp implements UserService {
    UserDao userdao = new UserDaoImp();

     //�ж��û����Ƿ����
    @Override
    public boolean isExists(String username) {
        HashMap<String, User> userMap = userdao.loadUserData();
        return userMap.containsKey(username);
    }

     //ע��
    @Override
    public void regist(String username, String password,String address) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        //����dao��user������ӵ�hashmap��
        HashMap<String,User> userMap = userdao.loadUserData();
        //�����û�������ӵ�userMap��
        userMap.put(user.getUsername(), user);
        //����dao����Ӻ�usermap���浽�����ļ���
        userdao.saveUserData(userMap);
        System.out.println("ע��ɹ�");
        Login.showFirstLevelMeun();
    }

    // ��¼
    @Override
    public boolean login(String username, String password) {
        //����dao��user������ӵ�hashmap��
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
