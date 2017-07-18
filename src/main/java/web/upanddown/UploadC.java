package web.upanddown;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author lwz
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadC {
	
	@RequestMapping(value = {"/img"})
	public String upload(MultipartFile file, String str){
		
		System.out.println(str);
		
		return "";
	}
	
	
	@RequestMapping(value = {"/upc"})
	public String upc(){
		
		System.out.println("hello");
		
		return "/upload/up.jsp";
	}
	
}
