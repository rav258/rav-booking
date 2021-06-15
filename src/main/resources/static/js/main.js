
"use strict";
$(document).ready(function() {


	// active link php

        var url = this.location.pathname;
        var filename = url.substring(url.lastIndexOf('/')+1);
        $('a[href="' + filename + '"]').parent().addClass('active');
		

    //Smooth Scroll 
	
    $('.page-scroll a').on('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 2500, 'easeInOutExpo');
        event.preventDefault();
    });
	

	//Navbar affix
	
	$('#nav').affix({
		  offset: {
			top: $('header').height()
		  }	 	  
	});	

    //	Back Top Link

    var offset = 200;
    var duration = 500;
    $(window).scroll(function() {
        if ($(this).scrollTop() > offset) {
            $('.back-to-top').fadeIn(400);
        } else {
            $('.back-to-top').fadeOut(400);
        }
    });

    //Owl-carousels
   
	$("#blog-slider").owlCarousel({
        dots: true,
        loop:true,
		margin: 10,
        autoplay: false,
        nav: true,
		  navText: [
            "<i class='fa fa-chevron-left'></i>",
            "<i class='fa fa-chevron-right'></i>"

        ],
        responsive: {
            1: {
                items: 1,
            },
			900: {
                items: 2,
            },
        }
    });
	 $("#services-slider").owlCarousel({
        dots: true,
        loop:true,
		margin: 50,
        autoplay: false,
        nav: true,
		  navText: [
            "<i class='fa fa-chevron-left'></i>",
            "<i class='fa fa-chevron-right'></i>"

        ],
        responsive: {
            1: {
                items: 1,
            },
			767: {
                items: 2,
            },
            1000: {
                items: 3,
            },
        }
    });
	$("#services-single-slider").owlCarousel({
        dots: true,
        loop:true,
		margin: 0,
        autoplay: true,
        nav: false,
        responsive: {
            1: {
                items: 1,
            },
			600: {
                items: 2,
            },
            1000: {
                items: 3,
            },
        }
    });
    $("#offers-slider").owlCarousel({
        dots: true,
	    margin: 50,
        loop:true,
        autoplay: false,
        nav: false,
        responsive: {
            1: {
                items: 1,
            },
		
        }
    });
	$("#testimonial-slider").owlCarousel({
        dots: true,
		margin: 50,
        loop:true,
        autoplay: false,
        nav: false,
        responsive: {
            1: {
                items: 1,
            },
			767: {
                items: 2,
            },
        
		
        }
    });
	

	//Dropdown nav on Hover

	$('.dropdown').hover(function() {
	  $(this).find('.dropdown-menu').stop(true, true).delay(100).fadeIn(500);
	}, function() {
	  $(this).find('.dropdown-menu').stop(true, true).delay(100).fadeOut(500);
	});
  
	
 
}); // end document ready


//On Click  function
	$(document).on('click',function(){
		
		//Navbar toggle
		$('.navbar .collapse').collapse('hide');
		
	})	

// Window load function

$(window).load(function() {

    // Page Preloader 	

    $("#preloader").slideUp("slow");
	
    // Pretty Photo

    $("a[data-gal^='prettyPhoto']").prettyPhoto({
        hook: 'data-gal'
    });
    ({
        animation_speed: 'normal',
        opacity: 1,
        show_title: true,
        allow_resize: true,
        counter_separator_label: '/',
        theme: 'light_square',
        /* light_rounded / dark_rounded / light_square / dark_square / facebook */
    });	
			
    //Isotope Nav Filter

    $('.category a').on('click', function() {
        $('.category .active').removeClass('active');
        $(this).addClass('active');

        var selector = $(this).attr('data-filter');
        $container.isotope({
            filter: selector,
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        return false;
    });
		
    //Isotope 

    var $container = $('#lightbox');
    $container.isotope({
        filter: '*',
        animationOptions: {
            duration: 750,
            easing: 'linear',
            queue: false,
            layoutMode: 'masonry'
        }

    });
	$(window).smartresize(function() {
        $container.isotope({
            columnWidth: '.col-sm-3'
        });
    });


}); // end window load
