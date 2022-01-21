# ClasspathLibrariesParser

Parses the .classpath file (from Eclipse JDT) from any given Eclipse project directory.

Example of .classpath file:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8">
		<attributes>
			<attribute name="module" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/ant-contrib.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.antlr-2.7.6.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.edu.oswego.cs.dl.util.concurrent-1.3.4.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.javassist-3.3.0.ga.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.javax.persistence-1.0.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.javax.servlet.jsp.jstl-1.1.2.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.javax.transaction-1.1.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.net.sf.cglib-2.1.3.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.aopalliance-1.0.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.commons.beanutils-1.7.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.commons.codec-1.3.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.commons.collections-3.2.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.commons.digester-1.8.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.commons.lang-2.1.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.commons.logging-1.1.1.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.log4j-1.2.15.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.taglibs.standard-1.1.2.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.tiles-2.0.5.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.tiles.core-2.0.5.osgi.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.apache.tiles.jsp-2.0.5.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.dom4j-1.6.1.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.hibernate-3.2.6.ga.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.hibernate.annotations-3.3.0.ga.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.hibernate.annotations.common-3.3.0.ga.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.hibernate.ejb-3.3.1.ga.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.hsqldb-1.8.0.9.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.jboss.util-2.0.4.GA.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.objectweb.asm-1.5.3.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.objectweb.asm.attrs-1.5.3.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/com.springsource.org.ognl-2.6.9.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/jaxb-api-2.1.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/jaxb-impl-2.1.9-osgi.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/junit-4.0.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.aop-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.beans-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.binding-2.0.3.RELEASE.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.context-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.context.support-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.core-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.jdbc-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.js-2.0.3.RELEASE.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.orm-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.security-2.0.2.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.security.acls-2.0.2.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.security.taglibs-2.0.2.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.transaction-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.web-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.web.servlet-2.5.5.A.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/org.springframework.webflow-2.0.3.RELEASE.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/servlet-api-2.3.jar"/>
	<classpathentry kind="lib" path="WebContent/WEB-INF/lib/dkparq.jar"/>
	<classpathentry kind="output" path="WebContent/WEB-INF/classes"/>
</classpath>
```
