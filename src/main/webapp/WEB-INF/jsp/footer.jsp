<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="assets/css/jquery-ui.min.css" />

<script type="application/javascript"
	src="assets/js/jquery-1.11.3.min.js"></script>
<script type="application/javascript" src="assets/js/jquery-ui.min.js"></script>
<script type="application/javascript" src="assets/js/bootstrap.js"></script>
<script type="application/javascript" src="assets/js/activities.js"></script>

<div id="footer" class="navbar navbar-default navbar-fixed-bottom">
	<div class="container">
		<div class="row">
			<div class="bottom col-md-6 col-md-offset-3">
				<ul>
					<li><a href="${ contextpath }/FitnessTracker/index.html">HOME</a></li>
					<li><a href="#">CONTACT US</a></li>
					<li><a href="#">DOCUMENTATION</a></li>
					<li><a href="#">BLOG</a></li>
					<li><a href="#">WIKI</a></li>
				</ul>
			</div>
			
			<div class="copyright col-md-6 col-md-offset-3">
				<spring:message code="copyright" />
			</div>
		</div>
	</div>
</div>