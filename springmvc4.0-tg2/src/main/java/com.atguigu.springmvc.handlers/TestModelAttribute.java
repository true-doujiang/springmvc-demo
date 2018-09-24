package com.atguigu.springmvc.handlers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.atguigu.springmvc.entities.User;
import org.springframework.web.bind.annotation.support.HandlerMethodInvoker;

/**
 * org.springframework.web.HttpSessionRequiredException: Expected session attribute 'user'
 * A handler 目标方法的入参 用@ModelAttribute(value = "user")修饰了  而且没有@ModelAttribute getUser() 则目标方法就会
 * 看A handler 有没有被@SessionAttributes(value={"user"}) 修饰
 *  若修饰了就会从HttpSession中获取相对应的key，找不到就会上面的抛异常，尴尬了
 *  若没有修饰则会用反射创建一个新对象作为目标方法的入参，反而没事
 *
 *  演示：
 *  1 把@ModelAttribute getUser()注释
 *  2 Controller 添加@SessionAttributes(value={"user"})
 *  3 testModelAttribute(@ModelAttribute(value="user")User user)  key必须与@SessionAttributes 的可以相同
 */
//@SessionAttributes(value={"user"}) //与@ModelAttribute一起演示异常
@RequestMapping("/springmvc")
@Controller
public class TestModelAttribute {


	private static final String SUCCESS = "model";

	/** @ModelAttribute用法：
     *
	 * 1. @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC调用!
	 *
	 * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO类型的 入参, 其 value 属性值有如下的作用:
	 * 		1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
	 * 		2). SpringMVC 会以 value 为 key, POJO 类型的对象为 value, 存入到 request 中. (也是就是说可以在jsp中使用${requestScope.key})
	 */
	@ModelAttribute   //很重要的
	public void getUser(
	        @RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
        //HandlerMethodInvoker
		System.out.println("@ModelAttribute注解的 method");

		if(id != null){
			User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
			System.out.println("模拟从数据库中获取对象: " + user);
			map.put("user", user); //key跟目标方法的形参类型首字母小写一致也OK.
			//map.put("abc", user);
		}
	}

	/**
	 * 运行流程:
	 * 1. 执行 @ModelAttribute 注解修饰的方法: 从数据库中取出对象, 把对象放入到了 Map中. 键为:user
	 * 2. SpringMVC 从 Map中取出 User对象,并把表单的请求参数赋给该 User对象的对应属性.
	 * 3. SpringMVC 把上述对象传入目标方法的参数.
	 * 注意: 在 @ModelAttribute 修饰的方法中,放入到 Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致!
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){ //(@ModelAttribute("abc")User user)
		System.out.println("目标方法执行修改操作: " + user);
		return SUCCESS;
	}

	/** SpringMVC 确定目标方法 POJO 类型入参的过程               implicitModel指定是 BindingAwareModelMap
	 * 1.确定一个 key:
	 * 	 1).若目标方法的 POJO 类型的参数木有使用 @ModelAttribute 作为修饰, 则 key 为 POJO 类名第一个字母的小写
	 * 	 2).若使用了  @ModelAttribute 来修饰, 则 key 为 @ModelAttribute 注解的 value 属性值.
     *
	 * 2.在 implicitModel中查找 key对应的对象, 若存在,则作为入参传入
	 * 	 1).若在 @ModelAttribute 标记的方法中在Map中保存过,且 key和 1 确定的 key一致, 则会获取到.
     *
	 * 3.若 implicitModel中不存在 key对应的对象,则检查当前的 Handler是否使用 @SessionAttributes 注解修饰,
	 * 	   若使用了该注解, 且 @SessionAttributes 注解的 value 属性值中包含了 key, 则会从 HttpSession中来获取 key所
	 *   对应的 value值, 若存在则直接传入到目标方法的入参中. 若不存在则将抛出异常. ---抛异常了----
     *
	 * 4.若 Handler没有标识 @SessionAttributes 注解或 @SessionAttributes 注解的 value值中不包含 key,则
	 *   会通过反射来创建 POJO类型的参数,传入为目标方法的参数
     *
	 * 5. SpringMVC会把 key和 POJO类型的对象保存到 implicitModel中,进而会保存到 request中.
	 */


	 /** 源代码分析的流程           implicitModel指定是 BindingAwareModelMap
	 1. 调用 @ModelAttribute 注解修饰的方法. 实际上把 @ModelAttribute 方法中 Map 中的数据放在了 implicitModel 中.
	 2. 解析请求处理器的目标参数, 实际上该目标参数来自于 WebDataBinder对象的 target属性
	 	1)创建 WebDataBinder对象:
	  	  	①. 确定 objectName属性:
	 		         若传入的 attrName 属性值为 "", 则 objectName 为类名第一个字母小写.
	  	                      注意:attrName. 若目标方法的 POJO 属性使用了 @ModelAttribute 来修饰, 则 attrName 值即为 @ModelAttribute 的value属性值
	  	  	②. 确定 target属性:
	  		         在 implicitModel中查找 attrName对应的属性值.若存在,ok
	  	                     若不存在: 则验证当前 Handler 是否使用了 @SessionAttributes 进行修饰, 若使用了, 则尝试从 Session中
	  		         获取 attrName 所对应的属性值. 若 session中没有对应的属性值,则抛出了异常.
	  	                     若 Handler没有使用 @SessionAttributes 进行修饰, 或 @SessionAttributes 中没有使用 value 值指定的 key和 attrName相匹配, 则通过反射创建了 POJO对象
	  	 2)SpringMVC 把表单的请求参数赋给了 WebDataBinder 的 target 对应的属性.
	     3)SpringMVC 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel.近而传到 request域对象中.
	 	 4)把 WebDataBinder的 target作为参数传递给目标方法的入参.
	 */


}
