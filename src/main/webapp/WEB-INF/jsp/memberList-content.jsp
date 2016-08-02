<%@ include file="commonCssJs.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>
.container {
	background-color: #ffffff;
}

td {
	text-align: center;
}

.goal-exercise-form {
	position: absolute;
	margin-top: 50px;
	background-color: #FFFFFF;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

#footer .bottom ul li {
	list-style-type: none;
	display: inline-block;
	float: left;
	padding-left: 30px;
}

/* footer */
#footer .copyright, #footer .bottom {
	text-align: center;
}
</style>

<c:if test="${ not empty members }">
	<div class="container goal-exercise-form col-md-8 col-md-offset-2">
		<div class="row">
			<table
				class="table table-bordered table-condensed table-hover table-responsive">
				<tr id="membersTr">
					<th style="text-align: center">Name</th>
					<th style="text-align: center">Gender</th>
					<th style="text-align: center">Email</th>
					<th style="text-align: center">Operation</th>
				</tr>
				<c:forEach items="${ members }" var="member">
					<tr>
						<td>${ member.firstName }${ member.lastName }</td>
						<td>${ member.gender }</td>
						<td>${ member.email }</td>
						<td><a href="${ contextPath }/preEditMember/${ member.id }"><button
									class="btn btn-warning">Edit</button></a> <a
							href="${ contextPath }/deleteMember/${ member.id }"
							onclick="return confirm('Are you sure to delete this member?')"><button
									class="btn btn-danger">Delete</button></a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-3">
					<a class="btn btn-success" href="${ contextPath }/index.html">Back
						to menu</a>
				</div>
			</div>
		</div>
	</div>
</c:if>