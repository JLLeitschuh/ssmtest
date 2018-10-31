// JavaScript Document

$(function(){
		$(".focus").click(function(){
					//$(this).toggleClass("style1").siblings(".focus").removeClass("style1")
					//$(this).toggleClass("style2").siblings(".focus").removeClass("style2")
					
					// 修改数字控制速度， slideUp(500)控制卷起速度
					$(this).next(".dropdownmenu").slideToggle(250).siblings(".dropdownmenu").slideUp(250);
			}) 
	   $(".dropdown").hover(function(){$(".dropdownmenu").slideUp(250);});
		});
		
		