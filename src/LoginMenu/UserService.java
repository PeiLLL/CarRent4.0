package LoginMenu;
    public interface UserService {
        //�ж��û����Ƿ��Ѿ�����
        boolean isExists(String username);
        //ע��һ���û�
        void regist(String username, String password,String address);
         //��¼
        boolean login(String username, String password);

}
