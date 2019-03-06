package web.freemarker;

import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;
import web.domain.TestDomain;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping
public class FreeMarkerC {

    @RequestMapping("/fk")
    public String goFreeMarker(ModelAndView view, HttpServletRequest request){
//        ModelAndView view = new ModelAndView("welcome!");
        view.addObject("name", "My first mvc Freemarker !");
        view.setViewName("testFk");

        TestDomain td = TestDomain.builder().name("明明").desc("nice").build();
        List<TestDomain> list = new ArrayList<TestDomain>();
        list.add(td);
        list.add(TestDomain.builder().name("AL").desc("perf").build());
        view.addObject("list", list);

        view.addObject("nums", 999);
        view.addObject("nums2", new BigDecimal("4.34"));
        view.addObject("nums3", 5L);

        view.addObject("lastUpdated", new Date());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hello", "puck");
        map.put("az", "good");
        view.addObject("map", map);

        return "testFk";
    }
}
