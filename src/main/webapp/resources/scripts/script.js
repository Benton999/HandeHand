$(document).ready(function(){
			
			$('#contact-form dd').click(function(){
				$(this).prev('dt').hide();
			}); 
			
			$("#panel1").hide();
			$("#panel2").hide();
			$("#panel3").hide();
								   
			$(".slide1").click(function(){
				$("#panel1").slideToggle("slow");
				$(".btn-slide1").toggleClass("active");
				return false;
			});
			
			$(".slide2").click(function(){
				$("#panel2").slideToggle("slow");
				$(".btn-slide2").toggleClass("active");
				return false;
			});
			
			$(".slide3").click(function(){
				$("#panel3").slideToggle("slow");
				$(".btn-slide3").toggleClass("active");
				return false;
			});
		});