```css
<style>
	body{
		background:url("/mwp/images/background.jpg") no-repeat;
		background-size:cover;
	}

	<!--
		no-repeat	: 
		The background-image is not repeated. The image will only be shown once
		
		cover	:	
		Resize the background image to cover the entire container, 
		even if it has to stretch the image or cut a little bit off one of the edges
	-->
	
	.wrap{
		background:black;
		width:100%;
		height:50px;
        
    <!--
    	%	:	
        Defines the width in percent of the containing block    
  	-->
        
	}
	
	.menu{
		background:black;
		color:white;
		width:150px;
		height:50px;
		vertical-align:middle;
		text-align:center;
		display:table-cell;
        
        <!--
		middle	:	
        The element is placed in the middle of the parent element
            
        center	:	Centers the text
            
        table-cell	:	Let the element behave like a <td> element
        -->
		
	}
	
	.nav{
		width:600px;
		magin-left:auto;
		margin-right:auto;
        
    <!--
    auto :
The left margin receives a share of the unused horizontal space, as determined mainly by the layout mode that is used. If the values of margin-left and margin-right are both auto, the calculated space is evenly distributed. This table summarizes the different cases:  
        
   https://developer.mozilla.org/en-US/docs/Web/CSS/margin-left
    
    -->
		
	}
	
	.menu:hover{
	
		background:lightgray;
		color:orangered;
		font-weight:bold;
		cursor:pointer;
        
        <!--
        	pointer	:	The cursor is a pointer and indicates a link
        
        -->
		
	}
	
	.loginArea > #loginForm, .userInfo{
		float:right;
		
        
        <!--
        The float property is used for positioning and layout on web pages.

        The float property can have one of the following values:

        left - The element floats to the left of its container
        right- The element floats to the right of its container
        none - The element does not float (will be displayed just where it occurs in the text). This is default
        inherit - The element inherits the float value of its parent
        In its simplest use, the float property can be used to wrap text around images.
        -->
	
	}
	
	#memberLoginBtn, #memberJoinBtn, #memberInfoBtn, #memberLogoutBtn {
	
		display:inline-block;
		vertical-align:middle;
		text-align:center;
		cursor:pointer;
		width:150px;
		height:30px;
		border-radius:5px;
		background:orangered;
		color:white;
        
        
        <!--
        브라우저 너비를 채우고 알맞게 줄바꿈되는 박스 그리드를 만들 수 있는데, 그동안 이러한 박스 그리드를 만드는 방법은 float를 이용하는 것이었습니다. 하지만 이제 inline-block을 이용하면 만들기가 훨씬 더 쉽습니다. inline-block 엘리먼트는 inline 엘리먼트와 비슷하지만 너비와 높이를 지정할 수 있습니다.
        
        http://ko.learnlayout.com/inline-block.html
            
            힘든 방법(float를 이용)
            .box {
                float: left;
                width: 200px;
                height: 100px;
                margin: 1em;
            }
            .after-box {
                clear: left;
            }
        
        
        	쉬운 방법(inline-block을 이용)
            display 프로퍼티에 inline-block 값을 이용하면 똑같은 효과를 낼 수 있습니다.

            .box2 {
              display: inline-block;
              width: 200px;
              height: 100px;
              margin: 1em;
            }
        
        
        
        
        The border-radius property defines the radius of the element's corners.

        Tip: This property allows you to add rounded borders to elements! 

        This property can have from one to four values. Here are the rules:

        Four values - border-radius: 15px 50px 30px 5px; (first value applies to top-left corner, second value applies to top-right corner, third value applies to bottom-right corner, and fourth value applies to bottom-left corner):
        -->
		
	}
	
	.tile{
	
		width:150px;
		height:150px;
		background:black;
		display:inline-block;
	}
	
	.first-line{
		margin-up:10%;
	}
	
	
	.tile-menu:hover{
	
		background:skyblue;
		cursor:pointer;
		color:white;
	}
	
	.notile{
		visibility:hidden;
	
	}
	
	.tile1{
		background:darkgray;
	
	}
	
	.footer{
	
		position:fixed;
		left:0;
		bottom:0;
		background:brown;
		color:white;
		text-align:center;
		width:100%;
	}
	
	
</style>


<style>
	.outer{
		width: 600px;
		height: 500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border: 1px solid white;
	}
</style>



<style>
	.outer{
		width: 600px;
		height: 500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border: 1px solid white;
	}
	
	#idCheckBtn, #searchAddressBtn, #joinMainBtn, #joinBtn{
		background:orangered;
		order-radius:5px;
		width:100px;
		height:25px;
		text-align:center;
		cursor:pointer;
	}
	
	
	#joinMainBtn, #joinBtn{
		display:inline-block;
		
		
	}
	
	
	#searchAddressBtn, #joinBtn{
		background:yellowgreen;
		
	}
	
	
	
	
</style>



<style>
	.outer{
		width:600px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border:1px solid white;
	}
	
	#idCheckBtn, #searchAddressBtn, #joinMainBtn, #updateBtn, #deleteBtn{
		background:orangered;
		border-radius:5px;
		width:100px;
		height:25px;
		text-align:center;
		cursor:pointer;
	} 
	#joinMainBtn, #updateBtn, #deleteBtn {
		display:inline-block;
	}
	#searchAddressBtn, #updateBtn, #joinMainBtn{
		background:yellowgreen;
	}
</style>
```

