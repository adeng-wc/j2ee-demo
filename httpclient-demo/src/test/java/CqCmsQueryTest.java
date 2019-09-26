import com.adeng.http.demo.ServiceResponse;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.adeng.http.demo.HttpClientUtil.doPost;

/**
 * @author hzwengcheng 2019-09-02 17:52
 */
public class CqCmsQueryTest {


    public static void main(String[] args) throws Exception {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);

        while (true) {
            fixedThreadPool.submit(() -> {
                String cqCmsQuery = "https://cq-cms.8.163.com/cq/cms/group/query";

                try {
                    ServiceResponse serviceResponse = doPost(cqCmsQuery, "");
                    System.out.println(JSONObject.toJSONString(serviceResponse));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
