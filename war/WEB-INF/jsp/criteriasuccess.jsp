<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<body>
<h2>Search Results</h2>
 
 <h4>Search Word : ${commandSearchCriteria.searchWord}</h4>

 
 <h4>Matched Items : </h4>
<c:choose>
  <c:when test='${not empty items}'>
   <c:forEach items="${items}" var="item">
     <a href="<c:out value="${item.href}"/>"><c:out value="${item.title}"/></a><br><br>
   </c:forEach>
  </c:when>
  <c:otherwise>
   <p>Matched Item not found.</p>
  </c:otherwise>
</c:choose>
<br/>
 Go back to <a href="<c:url value="home.htm"/>">Home</a>
</body>
</html>