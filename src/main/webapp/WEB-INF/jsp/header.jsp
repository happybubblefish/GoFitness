
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
<link rel="stylesheet" type="text/css" href="assets/css/jquery-ui.min.css"/>

<script type="application/javascript" src="assets/js/jquery-1.11.3.min.js"></script>
<script type="application/javascript" src="assets/js/jquery-ui.min.js"></script>
<script type="application/javascript" src="assets/js/bootstrap.js"></script>
<script type="application/javascript" src="assets/js/activities.js"></script>

<nav class="header navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a id="logo" class="navbar-brand" href="${contextPath}"> <img
				src="assets/imgs/logo.jpg" />
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
			<ul class="nav navbar-nav navbar-right">

				<li><a href="${ contextPath }/registration.html">BMI</a></li>
				
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Shopping <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Protein powder</a></li>
						<li><a href="#">Energy drink</a></li>
						<li><a href="#">Workout stuff</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
				
				<sec:authorize access="!hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
					<li><a href="${ contextPath }/login.html">Login</a></li>
					<li><a href="${ contextPath }/registration.html">Register</a></li>
				</sec:authorize>
				
				<li><a href="${ contextPath }/profileDetails.html">Hello, <sec:authentication
							property="name" /></a>
				<li>

				<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
					<li><a href="${ contextPath }/logout.html">Logout</a></li>
				</sec:authorize>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>