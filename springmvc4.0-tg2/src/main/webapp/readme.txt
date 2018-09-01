SpringMVCTest 讲解  

第一
@RequestMapping注解及其属性
@RequestMapping除了修饰方法, 还可来修饰类 
	1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录
	2). 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。
	 	若类定义处未标注 @RequestMapping，则方法处标记的 URL相对于 WEB 应用的根目录

@RequestMapping 除了可以使用请求 URL 映射请求外，还可以使用请求方法、请求参数及请求头映射请求
@RequestMapping 的 value、method、params 及 heads属性
分别表示请求 URL、请求方法、请求参数及请求头的映射条件，他们之间是与的关系，联合使用多个条件可让请求映射更加精确化。

第二
@RequestParam注解及其属性                                                        常用
@RequestParam 来映射请求参数. 
	value 值即请求参数的参数名 (key)
	required 该参数是否必须. 默认为 true   false:不是必须的
	defaultValue 请求参数的默认值
	
@RequestHeader注解及其属性   同@RequestParam   了解
@CookieValue  注解及其属性   同@RequestParam   了解

第三
Test testPojo

第四
Test ServletAPI

第五
处理模型数据  可以配合@SessionAttributes注解使用



SpringMVCTest2 讲解 @ModelAttribute
@ModelAttribute注解



SpringMVCTest1 讲解 REST