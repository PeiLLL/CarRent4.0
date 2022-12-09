package LoginMenu;

import User.User;

import java.io.*;
import java.util.HashMap;

public class UserDaoImp implements UserDao{

    //��hashMap�е����ݱ��浽�û������ļ���
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
        System.out.println("�ļ���û�ж���");
        e.printStackTrace();
    }
    System.out.println(3);
    return null;
}

    //��hashMap�е����ݱ����ļ���
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
