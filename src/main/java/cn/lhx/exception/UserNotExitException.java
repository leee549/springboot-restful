package cn.lhx.exception;

/**
 * @author lee549
 * @date 2020/3/18 11:48
 */
public class UserNotExitException extends RuntimeException {
    public UserNotExitException(){
        super("该用户不存在！");
    }
}
