package web.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class FreeMarkerC {

    @RequestMapping("/fk")
    public ModelAndView goFreeMarker(ModelAndView mv, HttpServletRequest request){
        mv.setViewName("welcome");
        ModelAndView view = new ModelAndView("welcome!");
        view.addObject("name", "My first mvc Freemarker !");
        view.setViewName("testFk");
        return view;
    }
}
