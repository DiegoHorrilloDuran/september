<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.shout.form.label.author" path="author"/>
	<acme:form-textarea code="anonymous.shout.form.label.text" path="text"/>
	<acme:form-textbox code="anonymous.shout.form.label.info" path="info"/>
	
	<acme:form-textbox code="anonymous.shout.form.label.xxx1" path="xxxis.xxx1" placeholder="dd/mm/yyyy"/>
	<acme:form-textbox code="anonymous.shout.form.label.xxx2" path="xxxis.xxx2" placeholder="yyyy/mm/dd hh:mm [en], dd/mm/AAAA hh:mm [es]"/>
	<acme:form-textbox code="anonymous.shout.form.label.xxx3.currency" path="xxxis.xxx3.currency" placeholder="EUR/USD/GBP"/>
	<acme:form-textbox code="anonymous.shout.form.label.xxx3.amount" path="xxxis.xxx3.amount" placeholder="100.00"/>
	<acme:form-checkbox code="anonymous.shout.form.label.xxx4" path="xxxis.xxx4"/>
	
	<acme:form-submit code="anonymous.shout.form.button.create" action="/anonymous/shout/create"/>
	<acme:form-return code="anonymous.shout.form.button.return"/>
</acme:form>