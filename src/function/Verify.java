package function;

import agSystem.UserVerify;

public class Verify {

    UserVerify s = new UserVerify();

    //登录成功与否的验证
    public void verifyRoot(String a, String b) {
        s.verifyRootWithSQL(a, b);
    }

    //客户登录与否验证
    public void verifyUser(String a, String b) {
        s.verifyUserWithSQL(a, b);
    }

    //是否注册成功
    public void verifyRegister(String a) {
        s.verifyRegisterWithSQL(a);
    }

}