<%@ include file="commonCssJs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>
.login-page, .form {
	width: 500px;
}
</style>

<script type="application/javascript" src="assets/js/activities.js"></script>

<div class="container goal-exercise-form col-md-6 col-md-offset-3">
	<h2>Enter exercise info:</h2>
	<form:form commandName="exercise" method="post" class="form-horizontal">
		<div class="form-group">
			<div class="control-group">
				<label for="textinput1" class="control-label col-sm-3"> <spring:message
						code="minutes.text" />
				</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="minutes" placeholder="Minutes between 1 and 120"/>
				</div>
				<div class="col-sm-4">
					<form:errors path="minutes" cssClass="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="control-group">
				<label for="selectinput1" class="control-label col-sm-3"> <spring:message
						code="minutes.activity" />
				</label>
				<div class="col-sm-4">
					<form:select class="form-control" id="activities" path="activity" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="control-group">
				<label for="textinput2" class="control-label col-sm-3"> <spring:message
						code="minutes.desc" />
				</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="description"
						placeholder="Description" />
				</div>
				<div class="col-sm-4">
					<form:errors path="description" cssClass="error" />
				</div>
			</div>
		</div>


		<div class="form-group">
			<div class="control-group">
				<label for="textinput2" class="control-label col-sm-3"> <spring:message
						code="minutes.sets" />
				</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="sets" placeholder="Sets" />
				</div>
				<div class="col-sm-4">
					<form:errors path="sets" cssClass="error" />
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="control-group">
				<label for="textinput2" class="control-label col-sm-3"> <spring:message
						code="minutes.reps" />
				</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="reps"
						placeholder="Repetitions" />
				</div>
				<div class="col-sm-4">
					<form:errors path="reps" cssClass="error" />
				</div>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-6 col-sm-offset-3">
				<input type="submit" class="btn btn-primary" value="Add" /> <a
					class="btn btn-warning" href="${ contextPath }/addDailyGoal.html">Cancel</a>
				<a class="btn btn-success" href="${ contextPath }/index.html">Back
					to menu</a>
			</div>
		</div>
	</form:form>
</div>




















