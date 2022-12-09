package LoginMenu;

import User.User;

import java.io.*;
import java.util.HashMap;

public class UserDaoImp implements UserDao{

    //将hashMap中的数据保存到用户数据文件中
@Override
public HashMap<String, User> loadUserData() {
    File file = new File("D:/user.data.txt");
    try {
        if(!file.exists()) {
            HashMap<String, User> userMap = new HashMap<String, User>();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(userMap);
            oos.close();
            return userMap;
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HashMap<String, User> userMap = (HashMap<String, User>)ois.readObject();
        ois.close();
        return userMap;
    } catch (Exception e) {
        System.out.println("文件里没有对象");
        e.printStackTrace();
    }
    System.out.println(3);
    return null;
}

    //将hashMap中的数据保存文件中
    @Override
    public void saveUserData(HashMap<String, User> userMap) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/user.data.txt"));
            oos.writeObject(userMap);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
