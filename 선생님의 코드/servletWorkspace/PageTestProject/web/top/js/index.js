$(document).ready(function (e) {
    $('.bxslider').bxSlider({});

    $('.icons li.tool_click a').click(function (e) {
        $('.tool_sec').slideDown();
        $(this).parent().parent().parent().siblings().find('.tool_sec').hide();
    });
    $('.icons li em').click(function (e) {
        $('.tool_sec').slideUp();
    });
    $('.tab1').show();
    $('.tabs ul li').click(function (e) {
        $(this).addClass('active');
        $(this).siblings().removeClass('active');

        var target = '.' + $(this).attr('id');
        $(target).fadeIn();
        $(target).siblings().hide();
    });

    $('.topbar').hide();
});