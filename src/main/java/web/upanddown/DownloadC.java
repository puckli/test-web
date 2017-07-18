package web.upanddown;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web.util.LogHelper;

/**
 * 
 * @author lwz
 * @since 2016-07-22
 */
@Controller
@RequestMapping("/download")
public class DownloadC {
	
	private Logger logger = LogHelper.DOWNLOAD;
	
	@RequestMapping
	public String download(HttpServletRequest req){
		
		File file = new File("files");
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if(pathname.isFile())
					return true;
				return false;
			}
		});
		
		List<String> names = new ArrayList<String>();
		if(files != null)
			for(File f : files){
				names.add(f.getAbsolutePath());
			}
		
		req.setAttribute("names", names);
		req.setAttribute("name", "testname");
		return "/upanddown/download";
	}
	
}
