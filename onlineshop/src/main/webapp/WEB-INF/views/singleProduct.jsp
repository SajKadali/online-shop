<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="conatiner">

	<!--  Bread crumb -->
	<div class="row">
	
		<div class="col-xs-12">
		
		<ol class="breadcrumb">
			<li><a href="${contextRoot}/home"> Home </a>
			<li><a href="${contextRoot}/show/all/products"> Products </a>
			<li class="active"> ${product.name}</li>
		</ol>
		</div>
	
	</div>
	
	<div class="row">
		<!--  display the product image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive" />
			</div>
		</div>
		
		<!--  display the product description -->
		<div class="col-xs-12 colsm-8">
			<h3>${product.name} </h3>
			<hr/>
			
			<p> ${product.description}</p>
			<hr/>
			
			<h4>Price: <strong> ${product.unitprice}</strong></h4>
			<hr/>
			
			<h6> Qty. Available : ${product.quantity}</h6>
			
			<c:choose> 
			<c:when test="${product.quantity} <1" >
				<a href="javascript:void(0)" class="btn btn-success disabled"> 
				<span class="glyphicon glyph-icon-shopping-cart"></span>Add to Cart</a>			 </c:when>
			 <c:otherwise>
				<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
				<span class="glyphicon glyph-icon-shopping-cart"></span>Add to Cart 
				</a>	
				
		 	</c:otherwise>
			 
			</c:choose>
			
		
			
			<a href="${contextRoot}/show/all/products" class="btn btn-primary">
				Back </a>	
					
		
		</div>
	</div>
	
	

</div>