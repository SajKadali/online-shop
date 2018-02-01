$(function(){
	
	// solving active menu problem
	switch(menu) {
	
	case 'About Us' 	: $('#about').addClass('active');
							break;
							
	case 'Contact Us'	: $('#contact').addClass('active');
							break;
							
	case 'All Products'	: $('#listProducts').addClass('active');
							break;						
							
	case 'Manage Products'	: $('#manageProducts').addClass('active');
							break;	
	
	default 			:  if(menu == 'Home') break;
							$('#listProducts').addClass('active');
							$('#_a'+menu).addClass('active');
							break;	
	
	}
	
	// code for jQuery dataTable
	
	var $table = $('#productListTable');
						
	// execute this code only where we have the table
	
	if($table.length) {
		
		console.log("Inside the table");
		
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else{
			jsonUrl = window.contextRoot + '/json/data/category/' +window.categoryId+ '/products';
		}
		
		$table.DataTable ({
			
			lengthMenu: [[3,5,10,-1] , ['3 Records',' 5 Records', '10 Records', ' All records']],
			pageLength: 5,
			ajax: {
					url:jsonUrl,
					dataSrc: ''
				
			},
			columns: [
			          {
							data : 'code',
							
							mRender: function(data,type,row){
								  
							 return '<img src="' +window.contextRoot+ '/resources/images/' + data + '.jpg" class="dataTableImg">'
							}
							},
			          {
			        	  data : 'name'
			          },
			          
			          {
			        	  data : 'brand'
			          },
			          
			          {
			        	  data : 'unitprice'
			          },
			          
			          {
			        	  data : 'quantity',
			        		  mRender: function(data,type,row){
			        		  
			        			  if(data < 1) {
			        				  
			        				  return '<span style="color:red"> Out of stock! </span>'
			        			  }
			        			  else return data;
			        		  }
			          },
			          
			          {
			        	  data : 'id',
			        	  bSortable: false,
			        	  mRender: function(data,type,row){
			        		  
			        		  var str = '';
			        		  str += '<a href="'+ window.contextRoot+ '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span> View </a> &#160';
			        		  
			        		  if(row.quantity <1) {
			        			
				        		  str += '<a href="javascript:"' + ' class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span>> Add to Cart </a>';
			        			  
			        		  }
			        		  else {
			        		  
			        			  str += '<a href="'+ window.contextRoot+ '/cart/add/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>> Add to Cart </a>';
			        		  }
			        		  
			        		  return str;
			          
			        	  }
			          }
			          ]
	});
		
	}	
	// dismissing the alert after 3 seconds
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeOut(function(){
			$alert.fadeOut('slow');
		}, 3000)
	}
	
	/*$('.switch input[type = "checkbox"]').change(function(){
		
		var checkbox = $(this);
		
		var checked = checkbox.prop('checked');
		
		var dMsg = (checked)? 'You want to activate this product?':
								'You want to deactivate this product?';
		
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			
			size: 'medium',
			title: 'Product activation & deactivation',
			message: dMsg,
			callback: function(confirmed){
				
				if(confirmed){
					
					console.log(value);
					bootbox.alert({
						size: 'medium',
						title: 'Information',
						message: 'You are going to perform operation on product'+ value
					});
				}
				else{
					
					checkbox.prop('checked', !checked);
					
				}	
			}
			});
			
			
	});*/
	
	/****************************************/
	
			// dataTable for admin
	
	/****************************************/
	
	var $adminProductsTable = $('#adminProductsTable');
	
	// execute this code only where we have the table
	
	if($adminProductsTable.length) {
		
		console.log("Inside the adminProductTable");
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
			
		$adminProductsTable.DataTable ({
			
			lengthMenu: [[10, 30, 50,-1] , ['10 Records',' 30 Records', '50 Records', ' All records']],
			pageLength: 30,
				ajax: {
							url:jsonUrl,
							dataSrc: ''
						
							},
			columns: [
				          { data : 'id' 
				        	  
				          },
			          			          
				          {
							data : 'code',
							
								mRender: function(data,type,row){
									  
								 return '<img src="' +window.contextRoot+ '/resources/images/' + data + '.jpg" class="adminDataTableImg">'
								}
							},
							
				          {
				        	  data : 'name'
				          },
			          
				          {
				        	  data : 'brand'
				          },
			          
			                  
				          {
				        	  data : 'quantity',
				        		  mRender: function(data,type,row){
				        		  
				        			  if(data < 1) {
				        				  
				        				  return '<span style="color:red"> Out of stock! </span>'
				        			  }
				        			  else return data;
				        		  }
				          },
				          
				          {
				        	  data : 'unitprice',
					        	  mRender: function(data,type,row){
					        		  
					        		  		return '&#8377;' + data
					        	  }
				          },
			          
				          {
				        	  data : 'active' ,
				        	  bsortable: false,
				        	  
					        	  mRender: function(data,type,row){
					        		   
					        		  
					        		  var  str = '';
					        		  str+= '<label class="switch" >';
					        		  if(data){
					        			  
					        			  str+= '<input type="checkbox" checked value="' + row.id + '"/>' ;
					        		  }
					        		  else {
					        			  
					        			  str+= '<input type="checkbox"  value="' + row.id + '"/>';
					        		  }
										
										str+= ' <span class="slider round"></span>	</label> ';
										
										return str ;
					        	  	}  	
				          
				        	  },
				        	  
				        	  {
				        		  data : 'id',
					        	  bSortable: false,
						        	  mRender: function(data,type,row){
						        		  
						        		  var str = '';
						        		  str+= '<a href="'+ window.contextRoot + '/manage/'+ data  + '/product" class="btn btn-warning">';
											str+= '<span class="glyphicon glyphicon-pencil" > </span> </a>';
											
											return str;
						        	  }	  
				        	  }
				             ],
			          
			         initComplete: function() {
				
			        	  var api = this.api();
			        	  api.$('.switch input[type = "checkbox"]').change(function(){
			        			
			        			var checkbox = $(this);
			        			
			        			var checked = checkbox.prop('checked');
			        			
			        			var dMsg = (checked)? 'You want to activate this product?':
			        									'You want to deactivate this product?';
			        			
			        			var value = checkbox.prop('value');
			        			
			        			bootbox.confirm({
			        				
			        				size: 'medium',
			        				title: 'Product activation & deactivation',
			        				message: dMsg,
			        				callback: function(confirmed){
			        					
			        					if(confirmed){
			        						console.log(value);
			        						
			        						var activationUrl = window.contextRoot +'/manage/product/' + value + '/activation';
			        						$.post(activationUrl, function(data){
			        							
			        							bootbox.alert({
				        							size: 'medium',
				        							title: 'Information',
				        							message: data
				        						});
			        						});
			        					}
			        					else{
			        						checkbox.prop('checked', !checked);
			        					}	
			        				}
			        				});
			        			});
			        					
			          		}
									
	});
		
	}
	
})