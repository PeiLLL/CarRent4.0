package LoginMenu;

import User.User;

import java.util.HashMap;

public interface UserDao {
    //�������ļ��е����ݶ�ȡ��hashmap��
        HashMap<String, User> loadUserData();

        //��hashmap�е����ݱ��浽�����ļ���
        void saveUserData(HashMap<String, User> userMap);
    }


