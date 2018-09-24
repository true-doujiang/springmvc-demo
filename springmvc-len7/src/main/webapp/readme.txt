springMVC默认转配的HandlerMapping
	1、BeanNameUrlHandlerMapping
	2、DefaultAnnotationHandlerMapping
	配置<mvc:default-servlet-handler /> <mvc:annotation-driven />后为
	1、RequestMappingHandlerMapping
	2、BeanNameUrlHandlerMapping
	3、SimpleUrlHandlerMapping  专门处理静态资源

springMVC默认转配的HandlerAdapter
	1、HttpRequestHandlerAdapter
	2、SimpleControllerHandlerAdapter
	3、AnnotationMethodHandlerAdapter
	配置<mvc:default-servlet-handler /> <mvc:annotation-driven />后为
	1、HttpRequestHandlerAdapter
	2、SimpleControllerHandlerAdapter
	3、RequestMappingHandlerAdapter


springMVC默认转配的HandlerExceptionResolver
	1、AnnotationMethodHandlerExceptionResolver
	2、ResponseStatusExceptionResolver
	3、DefaultHandlerExceptionResolver
	配置<mvc:default-servlet-handler /> <mvc:annotation-driven />后为	
	1、ExceptionHandlerExceptionResolver
	2、ResponseStatusExceptionResolver
	3、DefaultHandlerExceptionResolver
	可以显示配置                     
	1、SimpleMappingExceptionResolver	
	
	
springMVC默认转配的ViewResolver
	1、InternalResourceViewResolver
	

============================================================================
<!--  
	需要进行 Spring 整合 SpringMVC 吗 ?
	还是否需要再加入 Spring 的 IOC 容器 ?
	是否需要再 web.xml 文件中配置启动 Spring IOC 容器的 ContextLoaderListener ?
	1. 需要(最佳事件): 通常情况下, 类似于数据源, 事务, 整合其他框架都是放在 Spring 的配置文件中(而不是放在 SpringMVC 的配置文件中). 
	         实际上放入 Spring 配置文件对应的 IOC 容器中的还有 Service 和 Dao. 
	2. 不需要(不太好): 都放在 SpringMVC 的配置文件中. 也可以分多个 Spring 的配置文件, 然后使用 import 节点导入其他的配置文件
-->
<!--  
	问题: 若 Spring 的 IOC 容器和 SpringMVC 的 IOC 容器扫描的包有重合的部分, 就会导致有的 bean 会被创建 2 次.
	解决:
	1. 使 Spring 的 IOC 容器扫描的包和 SpringMVC 的 IOC 容器扫描的包没有重合的部分. 不好。
	2. 使用 exclude-filter 和 include-filter 子节点来规定只能扫描的注解
-->

<!--  
	SpringMVC 的 IOC 容器中的 bean 可以来引用 Spring IOC 容器中的 bean. 
	反过来呢 ? 反之则不行. Spring IOC 容器中的 bean 却不能来引用 SpringMVC IOC 容器中的 bean!
-->