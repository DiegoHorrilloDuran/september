<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.customisation-parameter.form.label.spamwords" path="spamwords" readonly="true"/>
	<acme:form-textbox code="administrator.customisation-parameter.form.label.threshold" path="threshold" readonly="true"/>
	
	<jstl:if test="${canUpdate}">	
		<acme:form-submit code="administrator.customisation-parameter.form.button.update" action="/administrator/user-account/update"/>
	</jstl:if>
		
  	<acme:form-return code="administrator.user-account.form.button.return"/>
</acme:form>
