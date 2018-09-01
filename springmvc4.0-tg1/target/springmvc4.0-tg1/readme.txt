最简单的helloword程序

	这样就足够了
	
	<!-- 配置自定扫描的包 , 这个注解有上面那个注解的功能了 -->
	<context:component-scan base-package="com.atguigu.springmvc"/>

	<!-- 配置视图解析器: 如何把 handler 方法返回值解析为实际的物理视图 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/views/"></property>
		<property name="suffix" value=".jsp"></property>
	</bean>