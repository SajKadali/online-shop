<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>
    
    <script type="text/javascript">
    	window.menu = '${title}';
    	window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
        <!-- Bootstrap Readable Theme -->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
    
            <!-- Bootstrap DataTables -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">

  </head>

  <body>
	<div class="wrapper">
    <!-- Navigation -->
   <%@include file="./shared/navbar.jsp" %>

    <!-- Page Content -->
    <div class="content">
   <c:if test = "${userClickHome == true }" >
    <%@include file="home.jsp" %>
    </c:if> 
       
    
    <c:if test="${userClickAbout == true}" >
    <%@include file="about.jsp" %>
    </c:if>
    <c:if test="${userClickContact == true}" >
    <%@include file="contact.jsp" %>
    </c:if>
    
    <c:if test="${userClickAllProducts == true  or userClickCategoryProducts == true}" >
    <%@include file="listProducts.jsp" %>
    </c:if>
    
    <c:if test="${userClickShowProduct == true}" >
    <%@include file="singleProduct.jsp" %>
    </c:if>
    
    <c:if test="${userClickManageProducts == true}" >
    <%@include file="manageProducts.jsp" %>
    </c:if>
    
    </div>
    <!-- Footer -->
   <%@include file="./shared/footer.jsp" %>
   
   <!--  jQuery -->
    <script src="${js}/jquery.js"></script>
    
     <!--  jQuery Validator -->
    <script src="${js}/jquery.validate.js"></script>
    
    
     <!-- Bootstrap core JavaScript -->
    <script src="${js}/bootstrap.bundle.min.js"></script>
    
    <!--  DataTable plugin -->
    <script src="${js}/jquery.dataTables.js"></script>
    
        <!--  DataTables Bootstrap script -->
    <script src="${js}/dataTables.bootstrap.js"></script>
    
     <!--  DataTables Boot box script -->
    <script src="${js}/bootbox.min.js"></script>
    
    
     <script src="${js}/myapp.js"></script>
    
	</div>
  </body>

</html>