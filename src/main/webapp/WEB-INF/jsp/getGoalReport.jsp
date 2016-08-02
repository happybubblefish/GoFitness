<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="commonCssJs.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goal Report</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h2>
					<sec:authentication property="name" />
					's report
				</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-condensed">
						<tr>
							<th>Goal id</th>
							<th>Username</th>
							<th>Date</th>
							<th>Total minutes</th>
							<th>Exercise minutes</th>
							<th>Activity</th>
							<th>Sets</th>
							<th>Repetitions</th>
						</tr>

						<c:forEach items="${ goalReports }" var="goalReport">
							<tr>
								<td>${ goalReport.goalId }</td>
								<td>${ goalReport.username }</td>
								<td><fmt:formatDate value="${ goalReport.date }"
										pattern="MM/dd/yyyy" /></td>
								<%-- <td>${ goalReport.date }</td> --%>
								<td>${ goalReport.goalMinutes }</td>
								<td>${ goalReport.exerciseMinutes }</td>
								<td>${ goalReport.exerciseActivity }</td>
								<td>${ goalReport.sets }</td>
								<td>${ goalReport.reps }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				
				<hr/>
				<h3>Actual exercise report:</h3>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-condensed">
						<tr>
							<th>Goal id</th>
							<th>Username</th>
							<th>Date</th>
							<th>Total minutes</th>
							<th>Exercise minutes</th>
							<th>Activity</th>
							<th>Sets</th>
							<th>Repetitions</th>
						</tr>

						<c:forEach items="${ actualExerciseGoalReports }" var="actualExerciseGoalReport">
							<tr>
								<td>${ actualExerciseGoalReport.goalId }</td>
								<td>${ actualExerciseGoalReport.username }</td>
								<td><fmt:formatDate value="${ actualExerciseGoalReport.date }"
										pattern="MM/dd/yyyy" /></td>
								<%-- <td>${ goalReport.date }</td> --%>
								<td>${ actualExerciseGoalReport.goalMinutes }</td>
								<td>${ actualExerciseGoalReport.exerciseMinutes }</td>
								<td>${ actualExerciseGoalReport.exerciseActivity }</td>
								<td>${ actualExerciseGoalReport.sets }</td>
								<td>${ actualExerciseGoalReport.reps }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>