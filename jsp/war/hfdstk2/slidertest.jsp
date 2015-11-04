<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@page import="java.lang.*"%>
    <%@page import="java.awt.*" %>
	<%@page import="jspcursus.Auto" %>
	<%@page import="jspcursus.AutoLijst" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>OPdracht 9</title>
	
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	
	<link href="/nouislider/documentation/assets/base.css" rel="stylesheet">
	<link href="/nouislider/documentation/assets/prism.css" rel="stylesheet">
	<script src="/nouislider/documentation/assets/wNumb.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<link href="/noUiSlider/distribute/nouislider.min.css" rel="stylesheet">
	<script src="/noUiSlider/distribute/nouislider.js"></script>

	<script type="text/javascript" charset="utf-8" src="https://platform.twitter.com/js/button.aec556e1a316f63b43fda3ae1e6a3e10.js"></script>
	<style type="text/css">
	html, body {
	cursor:url(cursor.cur), auto;
	}

	div.box {
	display:inline-block;
	width: 100%;
	max-width: 300px;
	text-align: center;
	border: 1px solid black;
	border-radius: 5px;
	overflow: hidden;
	margin-top: 1.5em;
	margin-bottom: 1.5em;
	background: -webkit-linear-gradient(right, rgba(127,127,127,0), rgba(127,127,127,1));
    background: -o-linear-gradient(left, rgba(127,127,127,0), rgba(127,127,127,1)); 
    background: -moz-linear-gradient(left, rgba(127,127,127,0), rgba(127,127,127,1));
    background: linear-gradient(to left, rgba(127,127,127,0), rgba(127,127,127,1)); 
	}
	
	div.box .box_naam {
		width: 100%;
		background-color: blue;
		color: yellow;
		line-height: 2em;
		background-color: #800000;
		color: #FFF8DC;
		font-weight: bold;
		
	}
	</style>
	</head>
	<body>
		<div data-role="rangeslider">
        <label for="price-min">Price:</label>
        <input type="range" name="price-min" id="price-min" value="200" min="0" max="1000">
        <label for="price-max">Price:</label>
        <input type="range" name="price-max" id="price-max" value="800" min="0" max="1000">
      </div>
	
	</body>
	
	
</html>
