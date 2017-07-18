package web.upanddown;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import web.domain.CVSDomain;
import web.upanddown.cvsutil.CsvUtil;
import web.upanddown.cvsutil.DownloadTaskNumManager;

/**
 * 导出cvs格式文件
 * @author lwz
 * @since 2016-05-25
 */
@Controller
@RequestMapping("/cvsExport")
public class CVSExport {
	Logger logger = LoggerFactory.getLogger(CVSExport.class);
	
	private static final String CSV_HEADER = "name,desc";
	private static final String CSV_TITLE = "XXXX Report"; 
	
	@Value("${domain.name}")
	private String domainName;
	
	@RequestMapping(value = {"/page"})
	public String page(){
		
		return "/upanddown/cvs";
	}
	
	@RequestMapping(value = {"/export"})
	public void cvsExport(HttpServletResponse response){
		try{
			response.setCharacterEncoding("UTF-8");
			BufferedWriter writer = new BufferedWriter(response.getWriter());
			if (!DownloadTaskNumManager.GetInst().incrementNum()) {
				writer.write(getJsAlertString("后台系统正在处理其他报表，请稍后重试"));
				logger.error("CVSExport:error,后台系统正在处理其他报表，请稍后重试");
				writer.flush();
				writer.close();
				return;
			}else{
				String fileName = CSV_TITLE + ".csv";
				response.setContentType("application/octet-stream; charset=UTF-8");
				response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
				
				writer.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }, "UTF-8"));
				writer.write(CSV_TITLE);
				writer.write(CsvUtil.CSV_LINE);
				writer.write(CSV_HEADER);
				writer.write(CsvUtil.CSV_LINE);
				
				for(CVSDomain d : testData()){
					writer.write(d.csvString());
					writer.write(CsvUtil.CSV_LINE);
				}
				writer.flush();
				writer.close();
				return;
			}
			
		} catch (Exception e){
			logger.error("CVSExport:error,ex={}", e);
		}
		
	}
	
	private String getJsAlertString(String msg){
		return "<script type=\"text/javascript\">alert('"+msg+"')</script>";
	}
	
	private List<CVSDomain> testData(){
		List<CVSDomain> list = new ArrayList<CVSDomain>(2);
		CVSDomain a = new CVSDomain();
		a.setName("hello").setDesc("名字");
		CVSDomain b = new CVSDomain();
		b.setName("world").setDesc("成都");
		list.add(a);
		list.add(b);
		return list;
	}
}
