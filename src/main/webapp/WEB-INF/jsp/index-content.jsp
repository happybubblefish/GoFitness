<%@ include file="commonCssJs.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">

			<div id="text">
				<p class="goalText">To get started, please set your goal first.</p>
			</div>

			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<a class="goal btn btn-lg btn-warning" href="addDailyGoal.html">
					Set daily Goal » </a>
			</sec:authorize>

			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<a class="goal btn btn-lg btn-success" href="actualExercise.html">
					Input your result » </a>
			</sec:authorize>

			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<a class="goal btn btn-lg btn-info" href="getGoalReports.html">
					View goal report » </a>
			</sec:authorize>

			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<a class="goal btn btn-lg btn-danger" href="editGoal.html"> View
					all Goals » </a>
			</sec:authorize>

			<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
				<a class="goal btn btn-lg btn-warning" href="memberList.html">
					View all users » </a>
			</sec:authorize>
		</div>
	</div>
</div>
