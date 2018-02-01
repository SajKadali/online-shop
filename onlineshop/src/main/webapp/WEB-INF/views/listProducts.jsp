<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<div class="row">
	
		<!-- To display side bar  -->
		<div class="col-md-3">
		<%@include file="./shared/sidebar.jsp" %>
		</div>
		
		<!--  To display the actual products -->
				<div class="col-md-9">
		
			<!--  Added breadcrumb component -->
			
					 <div class="row"> 
					
							<div class="col-lg-12">
								<c:if test = "${userClickAllProducts == true}">
								<script>
										window.categoryId = '';
									</script>
									
									<ol class="breadcrumb">
									
										<li> <a href="${contextRoot}/home">Home </a></li>
										<li class="active"> All Products </li>
									
									</ol>
								</c:if>
								
								<c:if test = "${userClickCategoryProducts == true}">
									<script>
										window.categoryId = '${category.id}';
									</script>
									
									<ol class="breadcrumb">
									
										<li> <a href="${contextRoot}/home">Home </a></li>
										<li class="active"> Category</li>
										<li class="active"> ${category.name}</li>
										
									</ol>
								</c:if>
							
							</div>
							</div>
							
							
							<div class="row">
							 
								 <div class="col-m-12" >
								 
									 <table id="productListTable" class="table table-striped table-bordered"  style="width:500px">
									 
										 <thead>
										  <tr>
										  	  <th> &#10;</th>
											  <th> Name</th>
											  <th> Brand </th>
											  <th> Price </th>
											  <th> Qty. Available </th>
											  <th> </th>
										 </tr>
										 </thead>
									 
									  <tfoot>
										  <tr>
										  	  <th>&#10; </th>
										  	  <th> Name</th>
											  <th> Brand </th>
											  <th> Price </th>
											  <th> Qty. Available </th>
											  <th> </th>
											  </tr>
										 </tfoot>
									 </table>
									 </div>
								 </div> 
						
				
			</div>	
			
		
	</div>
	
	
	
	</div>
	
