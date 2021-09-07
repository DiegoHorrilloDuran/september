<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.shout.list.label.moment" path="moment" width="10%"/>
	<acme:list-column code="anonymous.shout.list.label.author" path="author" width="10%"/>
	<acme:list-column code="anonymous.shout.list.label.text" path="text" width="20%"/>
	<acme:list-column code="anonymous.shout.list.label.info" path="info" width="20%"/>
	<acme:list-column code="anonymous.shout.list.label.xxx1" path="xxxis.xxx1" width="10%"/>
	<acme:list-column code="anonymous.shout.list.label.xxx2" path="xxxis.xxx2" width="10%"/>
	<acme:list-column code="anonymous.shout.list.label.xxx3" path="xxxis.xxx3" width="10%"/>
	<acme:list-column code="anonymous.shout.list.label.xxx4" path="xxxis.xxx4" width="10%"/>
</acme:list>