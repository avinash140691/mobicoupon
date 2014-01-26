// JavaScript Document


function val(){
	var valStatus = true;
	
	
	
	
	$('.password').keyup(function() {
	    $('span.password_empty').hide();	    
	    var inputVal = $(this).val();
	    var numericReg = /^[A-Za-z0-9 ]{6,20}$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {  	
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 132px;" class="empty password_empty">Enter 6 to 20 Charaters</span>');	  
	       return valStatus;
	    }
	});
	
	
	$('.name_r').keyup(function() {
	    $('span.name_empty').hide();	    
	    var inputVal = $(this).val();
	    var numericReg = /^[A-Za-z ]{3,20}$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {  	
	    	valStatus = false;
	    	$('.name_r').focus();
	       $(this).after('<span class="empty name_empty">Enter 3 to 20 Charaters</span>');	  
	       return valStatus;
	    }
	});
	
	$('.desg_r').keyup(function() {
	    $('span.desg_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[A-Za-z ]{2,20}$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 128px;" class="empty desg_empty">Enter 2 to 20 Charaters</span>');	    
	       return valStatus;
	    }
	});
	$('.dep_r').keyup(function() {
	    $('span.dep_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[A-Za-z ]{2,20}$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	status = false;
	       $(this).after('<span style="margin-left: 128px;" class="empty dep_empty">Enter 2 to 20 Charaters</span>');	 
	       return valStatus;
	    }
	});
	$('.cname_r').keyup(function() {
	    $('span.cname_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[A-Za-z ]{2,20}$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 97px;" class="empty cname_empty">Enter 2 to 20 Charaters</span>');	 
	       return valStatus;
	    }
	});
	$('.ll_r').keyup(function() {
	    $('span.ll_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /[0-9]/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 146px;" class="empty ll_empty">Enter only Numbers</span>');	 
	       return valStatus;
	    }
	});	
	
	$('.mn_r').keyup(function() {
	    $('span.mn_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[0-9]{10,12}$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 146px;" class="empty mn_empty">Enter 10 to 12 Numbers Only</span>');
	       return valStatus;
	    }
	});	
	$('.cmail_r').keyup(function() {
	    $('span.cmail_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 83px;" class="empty cmail_empty">Enter Email ID Properly</span>');
	       return valStatus;
	    }
	});	
	$('.amail_r').keyup(function() {
	    $('span.amail_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 83px;" class="empty amail_empty">Enter Email ID Properly</span>');	
	       return valStatus;
	    }
	});	
	$('.url_r').keyup(function() {
	    $('span.url_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[a-zA-Z0-9\-\.]+\.(com|org|net|mil|edu|COM|ORG|NET|MIL|EDU)$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 142px;" class="empty url_empty">Enter URL Properly</span>');	
	       return valStatus;
	    }
	});	
	$('.pcn_r').keyup(function() {
	    $('span.pcn_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /[0-9]/;	  
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 39px;" class="empty pcn_empty">Enter only Numbers</span>');	
	       return valStatus;
	    }
	});
	$('.uname_r').keyup(function() {
	    $('span.uname_empty').hide();
	    var inputVal = $(this).val();
	    var numericReg = /^[A-Za-z0-9 \.@]{3,20}$/;
	    if(!numericReg.test(inputVal) || inputVal.val().length < 0) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 135px;" class="empty uname_empty">Enter 3 to 20 Charaters</span>');	    
	       return valStatus;
	    }	    
	});
	
	$('.cpass_r').keyup(function() {
	    $('span.cpass_empty').hide();
	    var cpass = $('.cpass_r').val();
	    var pass = $('.password').val();	    
	    if(pass != cpass) {
	    	valStatus = false;
	       $(this).after('<span style="margin-left: 75px;" class="empty cpass_empty">Confirm Password Same as Password</span>');	      
	       return valStatus;
	    }
	    else{
	    	$('.reg_sub').removeAttr('style');
	    	$('.reg_sub').removeAttr('disabled');
	    }
	});
return valStatus;
}















$(document).ready(function(){ 		
	
	
$('.add_but').click(function(){
	$('.save_but,.clear_but').attr("enabled", true);
		$('.add_but,.edit_but,.edits_but,.delete_but').attr("disabled", true);
		$('.add_but,.edit_but,.edits_but,.delete_but').css({"background":'#B2DDE8',"color":'#D8EEFD'});
		$('.gridtable').hide();
});
$('.edit_but').click(function(){
	$('.clear_but').attr("enabled", true);
		$('.add_but,.edit_but,.edits_but,.save_but,.delete_but').attr("disabled", true);
		$('.add_but,.edit_but,.edits_but,.save_but,.delete_but').css({"background":'#B2DDE8',"color":'#D8EEFD'});	
		$('.gridtable').hide();
});	

$('.edits_but').click(function(){
	$('.clear_but,.edit_but').attr("enabled", true);
		$('.add_but,.save_but,.delete_but').attr("disabled", true);
		$('.add_but,.save_but,.delete_but').css({"background":'#B2DDE8',"color":'#D8EEFD'});	
		$('.gridtable').hide();
});	

$('.delete_but').click(function(){
	$('.clear_but,.delete_but').attr("enabled", true);
		$('.add_but,.edit_but,.edits_but,.save_but').attr("disabled", true);
		$('.add_but,.edit_but,.edits_but,.save_but').css({"background":'#B2DDE8',"color":'#D8EEFD'});
		$('.gridtable').hide();
});
	
$('.view_but').click(function(){
	$('.add_but,.edit_but,.edits_but,.save_but,.clear_but,.delete_but').attr("enabled", true);
	$('.add_but,.edit_but,.edits_but,.save_but,.delete_but').css({"background":'#008DB1',"color":'#D8EEFD'});
		
});
	
	
	$(".select").click(function(){			
		$(".popup1").show();
		$(".popup2,.popup3,.popup4,.popup5,.popup6").hide();
	}); 
	$(".select2").click(function(){
		$(".popup2").show();
		$(".popup1,.popup3,.popup4,.popup5,.popup6").hide();				
	});
	$(".select3").click(function(){
		$(".popup3").show();
		$(".popup2,.popup1,.popup4,.popup5,.popup6").hide();							
	});
	$(".select4").click(function(){
		$(".popup4").show();
		$(".popup2,.popup1,.popup3,.popup5,.popup6").hide();							
	});
	$(".select5").click(function(){
		$(".popup5").show();
		$(".popup2,.popup1,.popup4,.popup3,.popup6").hide();							
	});
	$(".select6").click(function(){
		$(".popup6").show();
		$(".popup2,.popup1,.popup4,.popup3,.popup5").hide();							
	});				
	$(".cancel,.closes,.closep").click(function(){	
		$(".popup1,.popup2,.popup3,.popup4,.popup5,.popup6,.cuserbox").hide();					
	}); 
	$(".Master").click(function(){		
		$(".merchant,.vuserbox,.cuserbox").hide();					
	}); 	
	$(".Merchants").click(function(){
		$(".merchant").show();
		$(".popup1,.popup3,.popup2,.popup4,.popup5,.popup6,.vuserbox,.cuserbox").hide();					
	});
	$(".ucreation").mouseover(function(){
		$(".mouseover").show();
	});
	$(".headerm").mouseover(function(){
		$(".submenu").show();
	});
	$(".headerm").mouseout(function(){
		$(".submenu").hide();
	});
	$(".headerms").mouseover(function(){
		$(".submenus").show();
	});
	$(".headerms").mouseout(function(){
		$(".submenus").hide();
	});
	$(".headerms3").mouseover(function(){
		$(".submenus3").show();
	});
	$(".headerms3").mouseout(function(){
		$(".submenus3").hide();
	});
	
	
	
	
	$(".ucreation").mouseout(function(){
		$(".mouseover").hide();
	});
	$(".vusers").click(function(){
		$(".vuserbox").show();
		$(".mouseover,.popup1,.popup3,.popup2,.popup4,.popup5,.popup6,.merchant,.cuserbox").hide();
	});	
	$(".cusers").click(function(){
		$(".cuserbox").show();
		$(".mouseover,.popup1,.popup3,.popup2,.popup4,.popup5,.popup6,.merchant,.vuserbox").hide();
	});
});