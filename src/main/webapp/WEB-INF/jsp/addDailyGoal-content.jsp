
<%@ include file="commonCssJs.jsp"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script type="text/javascript" src="assets/js/moods.js"></script>

<div class="container goal-exercise-form col-md-6 col-md-offset-3">
	<div class="form-container">
		<div class="row">
			<h3>Please set a goal:</h3>
			<form:form commandName="goal" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-3" for="textinput1"><spring:message
							code="goal.minutes" /></label>
					<div class="col-sm-4">
						<form:input path="minutes" class="form-control" />
					</div>
					<div class="col-sm-4">
						<form:errors path="minutes" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="datepicker"><spring:message
							code="goal.date" /></label>
					<div class="col-sm-4">
						<form:input id="datepicker" path="date" class="form-control"
							placeholder="date" />
					</div>
					<div class="col-sm-4">
						<form:errors path="date" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-3" for="selectinput1"> <spring:message
							code="goal.moods" /></label>
					<div class="col-sm-4">
						<form:select class="form-control" id="moods" path="mood" />
					</div>
					<div class="col-sm-4">
						<form:errors path="mood" cssClass="error" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-6 col-sm-offset-3">
						<input type="submit" class="btn btn-primary" value="Save" /> <a
							class="btn btn-warning" href="${ contextPath }/index.html">Cancel</a>
						<a class="btn btn-success" href="${ contextPath }/index.html">Back
							to menu</a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
