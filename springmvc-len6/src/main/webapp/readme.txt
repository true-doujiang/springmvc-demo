本工程的jar包多加了

1. 演示了员工的CRUD
2. 34.尚硅谷_佟刚_SpringMVC_数据绑定流程分析     **必须熟记于心**

   35.尚硅谷_佟刚_SpringMVC_自定义类型转换器     **必须熟记于心**
	Spring 定义了3种类型的转换器接口，实现任意一个转换 器接口都可以作为自定义转换器注册到ConversionServiceFactroyBean 中：
	–Converter<S,T>：将 S 类型对象转为 T 类型对象      **掌握**
	–ConverterFactory：将相同系列多个 “同质” Converter 封装在一 起。如果希望将一种类型的对象转换为另一种类型及其子类的对 象
	    （例如将 String 转换为 Number 及 Number 子类（Integer、Long、Double 等）对象）可使用该转换器工厂类
	–GenericConverter：会根据源类对象及目标类对象所在的宿主 类中的上下文信息进行类型转换

3.关于 <mvc:annotation-driven conversion-service="....." />
	3.1<mvc:annotation-driven /> 会自动注册
	    RequestMappingHandlerMapping
	 	RequestMappingHandlerAdapter
	 	ExceptionHandlerExceptionResolver
	 	三个bean。
	3.2还将提供以下支持:
		支持使用 ConversionService 实例对表单参数进行类型转换
		支持使用 @NumberFormat注解、@DateTimeFormat注解完成数据类型的格式化
		支持使用 @Valid注解对 JavaBean实例进行 JSR303验证 
		支持使用 @RequestBody和 @ResponseBody注解	
		
4.由 @InitBinder标识的方法,可以对 WebDataBinder对象进行初始化。
    WebDataBinder是 DataBinder 的子类，用于完成由表单字段到 JavaBean 属性的绑定
	4.1 @InitBinder方法不能有返回值，它必须声明为void。
	4.2 @InitBinder方法的参数通常是是 WebDataBinder
	
5.数据格式化	
     数据格式化从其本质上讲依然属于 “类型转换” 的范畴。
  Spring在格式化模块中定义了一个实现 ConversionService接口的FormattingConversionService 实现类，该实现类扩展
     了 GenericConversionService，因此它既具有类型转换的功能，又具有格式化的功能。
  FormattingConversionService 拥有一个FormattingConversionServiceFactroyBean 工厂类，后者用于在 Spring 上下文中构造前者。
<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
	<property name="converters">
		<set>
			<ref bean="employeeConverter" /> <!-- 注入自定义的类型转换器 -->
		</set>
	</property>	
</bean>

①支持对数字类型的属性使用 @NumberFormat 注解
②支持对日期类型的属性使用 @DateTimeFormat 注解

6.JSR 303 (一个标准)  具体看PPT90页
  JSR 303 是 Java为 Bean数据合法性校验提供的标准框架,它已经包含在 JavaEE 6.0 中 .
  JSR 303 通过在 Bean属性上标注类似于 @NotNull、@Max @Past 等标准的注解指定校验规则，并通过标准的验证接口对 Bean进行验证
	
	


7.拦截器
自定义的拦截器必须实现HandlerInterceptor接口

8.异常处理
SpringMVC通过 HandlerExceptionResolver(接口)处理程序 的异常，
包括 Handler映射、数据绑定以及目标方法执行时发生的异常。


使用了 <mvc:annotation-driven/> springMVC会装配3个HandlerExceptionResolver(接口)
ExceptionHandlerExceptionResolver  主要处理 Handler中用 @ExceptionHandler注解定义的方法。
ResponseStatusExceptionResolver    解析@ResponseStatus注解的自定义异常类
DefaultHandlerExceptionResolver	         对一些特殊的异常进行处理，比如 NoSuchRequestHandlingMethodException、HttpReques

定义自己统一异常处理:
这个SimpleMappingExceptionResolver可以在XML中显示的配置。
如果希望对所有异常进行统一处理，可以使用SimpleMappingExceptionResolver，
它将异常类名映射为视图名，即发生异常时使用对应的视图报告异常












