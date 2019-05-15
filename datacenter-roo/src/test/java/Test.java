import com.bean.User;
import com.dao.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test {

    @Autowired
    IUserDAO userDAO;

    public void test(){
        List<User> user = userDAO.qryAll();
        System.out.println("用户长度："+user.size());
    }


    @org.junit.Test
    public void te1(){
        userDAO.qryAll();
        System.out.println("用户长度："+userDAO.qryAll().size());
    }
}
