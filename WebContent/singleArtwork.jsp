<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<!--[if IE 8]>    <html class="ie8" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--><html lang="en-US" ><!--<![endif]-->

	<head>

		<meta charset="UTF-8" />

		<title>艺术品定制</title>

		<!--[if lt IE 9]>
		<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

		<meta name='viewport' content='width=device-width, initial-scale=0.7'>
		<meta name="format-detection" content="telephone=no">
		<style type="text/css">
a {
    text-decoration:none;
    color:#1c00ff;
}
 
fieldset.search {
    padding: 0px;
    border: none;
    width: 100%;
}
 
.search input, .search button {
    border: none;
    float: left;
}

.search input.box {
    height: 40px;
    width: calc(100% - 50px);
    margin-right: 0px;
    padding-right: 0px;
    margin: 1px;
}

.search input.box:focus {
    background: #e8e8e8 ;
    outline: none;
}

.search button.btn {
    border: none;
    width: 40px;
    height: 40px;
    margin: 0px auto;
    margin: 1px;
    background: url(images/user/search1.png) no-repeat top right;
}		
img.wp-smiley,
img.emoji {
	display: inline !important;
	border: none !important;
	box-shadow: none !important;
	height: 1em !important;
	width: 1em !important;
	margin: 0 .07em !important;
	vertical-align: -0.1em !important;
	background: none !important;
	padding: 0 !important;
}
/*==================================================*/
.imageholder{
	width: 100%;
	margin-bottom: 60px;
}

.imageholder img{
    width: 100%;
    height: 480px;
}

@media only screen and (max-width:1000px) {
	.imageholder{
	width: 100%;
	margin-bottom: 20px;
}
}

@media only screen and (max-width:1000px) {
	.imageholder img{
    width: cal(100%-20px);
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 0;
    height: 340px;
}
}

@media only screen and (max-width:600px) {
	.imageholder{
	width: 100%;
	margin-bottom: 0;
}
}

@media only screen and (max-width:600px) {
	.imageholder img{
    width: 100%;
    height: 260px;
}
}
@media only screen and (max-width:600px) {
	#container1 h3{
		font-size: 18px;
	}
}

@media only screen and (max-width:600px) {
	#container1 p{
		font-size: 14px;
	}
}

.easyzoom{
	float: left;
}

.easyzoom img{
	display: block;
}

/*==================================================*/


</style>
<script type='text/javascript' src='http://cdn.lamingtondrive.com/wp-includes/js/jquery/jquery.js?ver=1.11.3'></script>
<script type='text/javascript' src='http://cdn.lamingtondrive.com/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.2.1'></script>
<script type='text/javascript' src='http://cdn.lamingtondrive.com/wp-content/themes/lamingtondrive/js/min/init.min.js?ver=4.3.1'></script>

<link rel="stylesheet" href="css/easyzoom.css" type='text/css' media='all' />
<link rel="stylesheet" type="text/css" href="css/info.css" type='text/css' media='all' />
<link rel='stylesheet' id='style-css'  href='css/style.css' type='text/css' media='all' />
<link rel='stylesheet' id='icons-css'  href='http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css?ver=4.3.1' type='text/css' media='all' />



<script src='js/user/zoom/jquery-1.8.3.min.js'></script>
<script src='js/user/zoom/jquery.elevatezoom.js'></script>



	</head>

	<body>

		
		<header>
			<div class="container clearfix">

				<div id="logo">
					<a href="index.jsp">
<svg width="98px" height="98px" viewBox="0 0 98 98" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
    <defs></defs>
    <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" sketch:type="MSPage">
        <path d="M48.7,85.1146185 C28.5706667,85.1146185 12.2512261,68.8028647 12.2512261,48.6812722 C12.2512261,28.5596797 28.5706667,12.2465148 48.7,12.2465148 C68.8279217,12.2465148 85.1473623,28.5596797 85.1473623,48.6812722 C85.1473623,68.8028647 68.8279217,85.1146185 48.7,85.1146185 L48.7,85.1146185 Z M48.7,0 C21.8034841,0 0,21.7965105 0,48.6812722 C0,75.5674449 21.8034841,97.3625443 48.7,97.3625443 C75.5951043,97.3625443 97.4,75.5674449 97.4,48.6812722 C97.4,21.7965105 75.5951043,0 48.7,0 L48.7,0 Z" id="Fill-15" fill="#FFFFFF" sketch:type="MSShapeGroup"></path>
        <path d="M33.0186548,48.0491935 C33.7375844,48.0491935 34.0021616,47.9010331 34.525775,47.6061233 C35.2530159,47.1969184 36.2489897,46.636731 38.0386949,46.636731 C39.8284001,46.636731 40.8243739,47.1969184 41.5516148,47.6061233 C42.0752282,47.9010331 42.3384202,48.0491935 43.058735,48.0491935 C43.7776645,48.0491935 44.0242338,47.9094994 44.5644699,47.6061233 C45.2903256,47.1969184 46.2876846,46.636731 48.0773898,46.636731 C49.867095,46.636731 50.864454,47.1969184 51.5903097,47.6061233 C52.1305458,47.9094994 52.3757299,48.0491935 53.0960447,48.0491935 C53.8149742,48.0491935 54.0615435,47.9094994 54.6017796,47.6061233 C55.3276353,47.1969184 56.3249943,46.636731 58.1146995,46.636731 C59.90579,46.636731 60.9031489,47.1969184 61.6303898,47.6047123 C62.1567737,47.899622 62.4199656,48.0491935 63.1430509,48.0491935 C63.8647509,48.0491935 64.1293281,47.899622 64.655712,47.6047123 C65.3829529,47.1969184 66.3803118,46.636731 68.1714023,46.636731 L68.1714023,29 L28,29 L28,46.636731 C29.7897052,46.636731 30.785679,47.1969184 31.5129199,47.6061233 C32.053156,47.9094994 32.29834,48.0491935 33.0186548,48.0491935" id="Fill-16" fill="#FFFFFF" sketch:type="MSShapeGroup"></path>
        <path d="M63.1430509,51.4110514 C61.3505752,51.4110514 60.3532163,50.850864 59.6259754,50.4416591 C59.1009767,50.1467493 58.8363995,50 58.1146995,50 C57.3943847,50 57.1492006,50.138283 56.6089645,50.440248 C55.8831088,50.8494529 54.8857499,51.4110514 53.0960447,51.4110514 C51.3063394,51.4110514 50.3089805,50.8494529 49.5831248,50.440248 C49.0428887,50.138283 48.7963194,50 48.0773898,50 C47.357075,50 47.1118909,50.138283 46.5716548,50.440248 C45.8457992,50.8494529 44.8484402,51.4110514 43.058735,51.4110514 C41.2676445,51.4110514 40.2716708,50.8494529 39.5444299,50.440248 C39.0041938,50.138283 38.7576245,50 38.0386949,50 C37.3183801,50 37.0718108,50.138283 36.5329599,50.440248 C35.8043338,50.8494529 34.8097453,51.4110514 33.0186548,51.4110514 C31.2289496,51.4110514 30.2315907,50.8494529 29.505735,50.440248 C28.9654989,50.138283 28.7189296,50 28,50 L28,69.0491935 L68.1714023,69.0491935 L68.1714023,50 C67.448317,50 67.1851251,50.1467493 66.6601264,50.4416591 C65.9328855,50.850864 64.9355266,51.4110514 63.1430509,51.4110514" id="Fill-17" fill="#FFFFFF" sketch:type="MSShapeGroup"></path>
        <path d="M63.1430509,50.8221027 C61.7079622,50.8221027 60.9571725,50.4001984 60.2936518,50.0276808 C59.7021625,49.6974948 59.1924013,49.4110514 58.1146995,49.4110514 C57.038383,49.4110514 56.5286217,49.6960837 55.9399029,50.0276808 C55.2791526,50.4001984 54.5283629,50.8221027 53.0960447,50.8221027 C51.6637264,50.8221027 50.9129367,50.4001984 50.2521864,50.0276808 C49.6620824,49.6960837 49.1537063,49.4110514 48.0773898,49.4110514 C47.0010733,49.4110514 46.491312,49.6960837 45.9025932,50.0276808 C45.2418429,50.4001984 44.4910532,50.8221027 43.058735,50.8221027 C41.6250315,50.8221027 40.875627,50.4001984 40.2134915,50.0276808 C39.6233875,49.6960837 39.1136262,49.4110514 38.0386949,49.4110514 C36.9623784,49.4110514 36.4526171,49.6960837 35.8625131,50.0276808 C35.2017628,50.4001984 34.4523583,50.8221027 33.0186548,50.8221027 C31.5863366,50.8221027 30.8355469,50.4001984 30.1747966,50.0276808 C29.5846926,49.6960837 29.0763165,49.4110514 28,49.4110514 L28,48 C29.4323183,48 30.1831079,48.4204933 30.842473,48.7930109 C31.4325771,49.1246079 31.9409531,49.4110514 33.0186548,49.4110514 C34.0949714,49.4110514 34.6047326,49.1231969 35.1948367,48.7915998 C35.8569722,48.4204933 36.6063766,48 38.0386949,48 C39.4710132,48 40.2204176,48.4204933 40.8825531,48.7915998 C41.471272,49.1231969 41.9810332,49.4110514 43.058735,49.4110514 C44.1350515,49.4110514 44.6434275,49.1246079 45.2335316,48.7930109 C45.8942819,48.4204933 46.6450715,48 48.0773898,48 C49.5097081,48 50.2604977,48.4204933 50.921248,48.7930109 C51.5099669,49.1246079 52.0197281,49.4110514 53.0960447,49.4110514 C54.1723612,49.4110514 54.6807372,49.1246079 55.2708413,48.7930109 C55.9315916,48.4204933 56.6823812,48 58.1146995,48 C59.5497882,48 60.2991926,48.4204933 60.9627134,48.7915998 C61.5528174,49.1231969 62.0625787,49.4110514 63.1430509,49.4110514 C64.2221379,49.4110514 64.7318991,49.1231969 65.3233884,48.7915998 C65.9869091,48.4204933 66.7363136,48 68.1714023,48 L68.1714023,49.4110514 C67.0923153,49.4110514 66.5825541,49.6974948 65.9910648,50.0276808 C65.3289293,50.4001984 64.5781396,50.8221027 63.1430509,50.8221027" id="Fill-18" fill="#FFFFFF" sketch:type="MSShapeGroup"></path>
    </g>
</svg></a>
				</div>

				<nav class="clearfix">
					<div class="menu-menu-1-container">
						<ul id="menu-menu-1" class="menu">
							<li id="menu-item-50" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-50"><a href="index.html">首页</a></li>
							<li id="menu-item-98" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-98"><a href="artworks.html">艺术品</a></li>
                            <li id="menu-item-98" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-98"><a href="">艺术家</a></li>
                            <li id="menu-item-52" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-52"><a href="">艺术定制</a></li>
                            <li id="menu-item-617" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="">拍卖</a></li>
                            
                            <li id="menu-item-617" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="info_show.html">艺术资讯</a></li>
                            <li id="menu-item-617" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="lookForMyCart">购物车</a></li>
                            <li id="menu-item-617" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="login.html">登录</a></li>
                            
                        </ul>
                    </div>				
                </nav>

				<div class="hamburger">
					<i class="fa fa-bars"></i>
				</div>

			</div>
		</header>


        <!--此处是手机端的菜单-->
  		<div id="mobile_menu">
			<div class="menu-menu-1-container">
				<ul id="menu-menu-2" class="menu">
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-50"><a href="index.html">首页</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-50"><a href="artworks.html">艺术品</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-98"><a href="">艺术家</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-52"><a href="">艺术定制</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="">拍卖</a></li>
                    
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="info_show.html">艺术资讯</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="cart.jsp">购物车</a></li>
                    <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-617"><a href="login.html">登录</a></li>
                </ul>
            </div>			

            <div class="hamburger">
            	<i class="fa fa-bars"></i>
            </div>
		</div>
		<section>
		<div id="content" >
			<div id="dynamic" class="page page-id-428 page-template page-template-_templates page-template-shop page-template-_templatesshop-php">
				
                <div class="shop_container">
	                <div id="item_single" class="clearfix">
                        <div class="main_img">
                            <img id="zoom_01" src='images/user/${singleArtwork.imageURL.small}' data-zoom-image="images/user/${singleArtwork.imageURL.large}"/>
                        </div>
		                    
		                    <div class="info">
		                        <!--艺术品的名称-->
			                    <p class="title">${singleArtwork.name}</p>
			                    <!--艺术品的种类-->
			                    <p>${singleArtwork.type}</p>
			                    <!--艺术品的尺寸-->
			                    <p class="variants">${singleArtwork.size}</p>
			                    <!--艺术品创作者的名字-->
			                    <p class="vendor">${singleArtwork.artistName}</p>

                                <!--此处是艺术品的状态 商城/拍卖/仅作展示-->
							    <div class="desc">
							        <p class="p1">商城售卖</p>
							    </div>
			
			                    <div class="clearfix">
				                    <div class="price clearfix">
								        <div class="inner clearfix"><span class="cost">${singleArtwork.price}</span></div>
					                    <p class="gst"></p>
				                    </div>
                                
                                <!--此处是尚待修改的加入购物车js-->
                                <!--此处的链接是使用的方法-->
								<a class="add_to_cart" href="addOneOrderRecord"
							onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f);
								f.method = 'POST'; f.action = this.href; var v = document.createElement('input'); v.setAttribute('type', 'hidden');
								v.setAttribute('name', 'id'); v.setAttribute('value', 3632712772);
								f.appendChild(v); var r = document.createElement('input'); r.setAttribute('type', 'hidden');
								r.setAttribute('name', 'return_to'); r.setAttribute('value', 'back'); f.appendChild(r);
								f.submit(); return false;"><i class="fa fa-shopping-cart"></i>加入购物车</a>
			                    </div>
                            </div>
                    </div>
                </div>
			   

		        <footer data-type="background" data-speed="3" class="clearfix" id="contact"  style="background-image: url('images/user/1.jpg');">
					<div id="content" class="clearfix">
						<div class="one">													
						</div>
						<div class="two">							
							<p>
								<span>联系我们</span><br>
								13843214321<br>
								<a href="artAuction@sina.com">artAuction@sina.com</a>
							</p>
						</div>
					</div>
					<div id="credit">
						<p>&copy; 2015 <a href="">四点共圆</a></p>
					</div>
				</footer>		
			</div>
		</div>
	</section>


<script>
$('#zoom_01').elevateZoom({
zoomType: "inner",
cursor: "crosshair",
zoomWindowFadeIn: 500,
zoomWindowFadeOut: 750,
}); 
</script>

<script type='text/javascript' src='js/user/plugins.min.js'></script>
<script type='text/javascript' src='js/user/scripts.min.js'></script>
</body>

</html>
