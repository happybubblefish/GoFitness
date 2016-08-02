<%@ include file="commonCssJs.jsp"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container goal-exercise-form">
	<div class="row">
		<form:form commandName="editMember" class="form-horizontal">
			<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>

			<div class="form-group">
				<label for="firstName" class="control-label col-sm-3"> First
					name: </label>
				<div class="col-sm-3">
					<form:input class="form-control" type="text" id="firstName"
						path="firstName" placeholder="between 3 & 16 characters" />
				</div>
				<div class="col-sm-3">
					<form:errors path="firstName" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="lastName" class="control-label col-sm-3"> Last
					name: </label>
				<div class="col-sm-3">
					<form:input class="form-control" placeholder="lastname" type="text"
						id="lastName" path="lastName" />
				</div>
				<div class="col-sm-3">
					<form:errors path="lastName" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="gender" class="control-label col-sm-3"> Gender:
				</label>
				<div class="col-sm-3">
					<form:radiobutton path="gender" value="Male" />
					Male
					<form:radiobutton path="gender" value="Female" />
					Female
				</div>
				<div class="col-sm-3">
					<form:errors path="gender" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="age" class="control-label col-sm-3"> Age: </label>
				<div class="col-sm-3">
					<form:input class="form-control" placeholder="age" type="number"
						id="age" path="age" />
				</div>
				<div class="col-sm-3">
					<form:errors path="age" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="control-label col-sm-3"> Email: </label>
				<div class="col-sm-3">
					<form:input class="form-control" placeholder="email" type="email"
						id="email" path="email" />
				</div>
				<div class="col-sm-3">
					<form:errors path="email" cssClass="error" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<form:input type="hidden" name="id" path="id" />
				</div>
			</div>

			<div class="form-group">
				<label for="height" class="control-label col-sm-3"> Height:
				</label>
				<div class="col-sm-3">
					<form:input class="form-control" type="text" placeholder="height"
						id="height" path="height" />
				</div>
				<div class="col-sm-3">
					<form:errors path="lastName" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="weight" class="control-label col-sm-3"> Weight:
				</label>
				<div class="col-sm-3">
					<form:input class="form-control" type="text" placeholder="weight"
						id="weight" path="weight" />
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