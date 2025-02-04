<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Docter Login Page</title>
<%@include file="component/allCss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Docter Login</p>

						<c:if test="${not empty succMsg }">
							<p class="text-center text-success fs-3">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errMsg }">
							<p class="text-center text-danger fs-5">${errMsg}</p>
							<c:remove var="errMsg" scope="session" />
						</c:if>

						<form action="doctorLogin" method="post">
							<div class="mb-3">
								<label class=form-label">Email Address</label><input required
									name="email" type="mail" class="form-control">
							</div>
							<div class="mb-3">
								<label class=form-label">Password</label><input required
									name="password" type="password" class="form-control">
							</div>
							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>