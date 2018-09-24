package com.atguigu.springmvc.json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;

@Controller
public class JsonContrller {

	@Autowired
	private EmployeeDao employeeDao;


    //*********************************************//
    /**1. 加入 jar 包：
     jackson-annotations-2.1.5.jar
     jackson-core-2.1.5.jar
     jackson-databind-2.1.5.jar
     *	2. 编写目标方法，使其返回 JSON 对应的对象或集合
     *	3. 在方法上添加 @ResponseBody 注解
     */
    @ResponseBody	//加我就可以返回json数据
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }


    /**
     * 原理讲解
     */
	//HttpMessageConverter接口 有很多的实现类 默认有6个 PPT 104页
	//HttpOutputMessage  
	//HttpInputMessage  
	
	/**看文档107页
	 * 使用 HttpMessageConverter<T> 将请求信息转化并绑定到处理方法的入 
	 * 参中或将响应结果转为对应类型的响应信息，Spring 提供了两种途径：
	 * 修饰入参类型			     修饰返回值类型
	 * 使用 @RequestBody  / @ResponseBody 
	 * 使用 HttpEntity<T> / ResponseEntity<T>   本例 T是字节数组 所以是下载的效果
	 */
	//第一种方式    下载效果
	@RequestMapping(value="/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpEntity<String> param, HttpSession session)
            throws IOException{
		System.out.println(param);
		
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
		byte [] buffer = new byte[in.available()];
		in.read(buffer);
		
		HttpHeaders headers = new HttpHeaders();
        //加这个响应头就是下载，不加直接把内容输出到浏览器
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		HttpStatus statusCode = HttpStatus.OK;
		
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(buffer, headers, statusCode);
		return response;
	}
	
	//第二种方式
	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")   
	public String testHttpMessageConverter(@RequestBody String body){
        /**
         * @RequestBody修饰的String类型参数  所以把接收的参数都变成String类型的了，就算是文件也是
         * 老师演示的效果是的   我的body就接收不到任何参数
         */
        System.out.println("-----1-----");
		System.out.println(body);
        System.out.println("------2----");
		//方法被@ResponseBody修饰，方法的返回值有事String类型，所以直接把string输出到浏览器
		return "helloworld! " + new Date();  
	}

    @RequestMapping(value = "/handler14", method = RequestMethod.POST)
    public String handle14(@RequestBody String requestBody) {
        System.out.println("------1----");
        System.out.println(requestBody);
        System.out.println("------2----");
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/handler15")
    public byte[] handle15() {
        try {
	        Resource resource = new ClassPathResource("httpmessageconvert.txt");
            byte[] filedata = FileCopyUtils.copyToByteArray(resource.getInputStream());
            return filedata;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/handler16")
    public String handle16(HttpEntity<String> entity) {
        System.out.println(entity.getHeaders().getContentLength());
        System.out.println("------1----");
        System.out.println(entity);
        System.out.println("------2----");
        return "success";
    }


    /**
     *
     * @return
     */
    @RequestMapping(value = "/handler17")
    public ResponseEntity<byte[]> handle17() {
        try {
            Resource resource = new ClassPathResource("httpmessageconvert.txt");
            byte[] filedata = FileCopyUtils.copyToByteArray(resource.getInputStream());

            HttpHeaders headers = new HttpHeaders();
            //加这个响应头就是下载，不加直接把内容输出到浏览器
            headers.add("Content-Disposition", "attachment;filename=httpmessageconvert.txt");

            ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(filedata, headers, HttpStatus.OK);
            return response;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
