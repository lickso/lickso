import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class TestController {
    @Autowired
    Test userSV;
    /**
     * 查询所有用户
     *
     * @author yangsheng
     */
    @RequestMapping("/qryAllUser")
    @ResponseBody
    public void qryAllUser() {
       userSV.test();
    }
}
