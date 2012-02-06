<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 <head>
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>
 
<body>
<h2>Please fill your criteria.</h2>
 
<form:form method="POST" commandName="CommandSearchCriteria">
<%-- display errors on the top of the page too --%>
<form:errors path="*" cssClass="errorblock" element="div"/>
<table>
<tr>
<td>Search word(s):</td> <!-- path corresponds to var defined in commandsearchcriteria.java -->
<td><form:input path="searchWord" /></td>
<td><form:errors path="searchWord" cssClass="error" /></td>
</tr>
<tr>
<td>Regions : </td>
<td>
<form:checkboxes path="regions" items="${webregionList}"/>
</td>
<td><form:errors path="regions" cssClass="error" /></td>
</tr>
<tr>
<td>Categories : </td>
<td>
<%-- don't know how to use multiple referencedata --%>
<%--form:checkboxes path="categories" items="${webcategoryList}"/--%>
<form:checkbox path="categories" value="baby"/>Baby 
<form:checkbox path="categories" value="toy"/>Toy
</td>
<td><form:errors path="categories" cssClass="error" /></td>
</tr>
<tr>
<td colspan="3"><input type="submit" /></td>
</tr>
</table>
</form:form>
 <a href="<c:url value="criteriaform.htm"/>">Home</a>
</body>
</html>