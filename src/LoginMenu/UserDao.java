package LoginMenu;

import User.User;

import java.util.HashMap;

public interface UserDao {
    //将数据文件中得数据读取到hashmap中
        HashMap<String, User> loadUserData();

        //将hashmap中的数据保存到数据文件中
        void saveUserData(HashMap<String, User> userMap);
    }


