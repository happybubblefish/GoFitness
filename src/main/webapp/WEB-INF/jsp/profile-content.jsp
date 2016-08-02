<%@ include file="commonCssJs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<div class="container goal-exercise-form">
	<div class="row">
		<!-- <div class="col-sm-12"> -->
		<h3>Please complete your profile in order to proceed:</h3>
		<form:form commandName="member" class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-3" for="firstName"> First
					name: </label>
				<div class="col-sm-3">
					<form:input type="text" id="firstName" path="firstName"
						class="form-control" placeholder="between 3 & 16 characters" />
				</div>
				<div class="col-sm-3">
					<form:errors path="firstName" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3" for="lastName"> Last
					name: </label>
				<div class="col-sm-3">
					<form:input placeholder="between 3 & 16 characters" type="text"
						id="lastName" path="lastName" class="form-control" />
				</div>
				<div class="col-sm-3">
					<form:errors path="lastName" cssClass="error" />
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-3" for="gender"> Gender:
				</label>
				<div class="col-sm-3">
					<label class="radio-inline"><form:radiobutton path="gender"
							value="Male" /> Male</label> <label class="radio-inline"><form:radiobutton
							path="gender" value="Female" /> Female</label>
				</div>
				<div class="col-sm-3">
					<form:errors path="gender" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3" for="age"> Age: </label>
				<div class="col-sm-3">
					<form:input placeholder="at least 18" class="form-control"
						type="number" id="age" path="age" />
				</div>
				<div class="col-sm-3">
					<form:errors path="age" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3" for="email"> Email: </label>
				<div class="col-sm-3">
					<form:input class="form-control" placeholder="123@xyz.com"
						type="email" id="email" path="email" />
				</div>
				<div class="col-sm-3">
					<form:errors path="email" cssClass="error" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3" for="height"> Height:
				</label>
				<div class="col-sm-3">
					<form:input class="form-control" type="text"
						placeholder="between 30cm and 300cm" id="height" path="height" />
				</div>
				<div class="col-sm-3">
					<form:errors path="height" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-3" for="weight"> Weight:</label>
				<div class="col-sm-3">
					<form:input class="form-control" type="text"
						placeholder="between 30lb and 500lb" id="weight" path="weight" />
				</div>
				<div class="col-sm-3">
					<form:errors path="weight" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-3">
					<input type="submit" class="btn btn-primary" value="Save" /> <a
						class="btn btn-warning" href="${ contextPath }/index.html">Cancel</a>
				</div>
			</div>
		</form:form>
	</div>
</div>