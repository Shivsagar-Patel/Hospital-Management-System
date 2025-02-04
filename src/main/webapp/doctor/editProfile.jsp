<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.DAO.specialistDao"%>
<%@ page import="java.util.List"%>
<%@ page import="com.entity.Specialist"%>
<%@ page import="com.DAO.DoctorDao"%>
<%@ page import="com.entity.Doctor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<c:if test="${empty doctorObj }">
		<c:redirect url="../docter_login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>


	<div class="container p-4 ">
		<div class="row">
			<div class="col-md-4">
				<div class="card paint-card">
					<p class="text-center fs-3">Change Password</p>

					<c:if test="${not empty succMsg }">
						<p class="text-center text-success fs-3">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty errMsg }">
						<p class="text-center text-danger fs-5">${errMsg}</p>
						<c:remove var="errMsg" scope="session" />
					</c:if>
					<div class="card-body">
						<form action="../changeDoctPassword" method="post">
							<div class="mb-3">
								<label>Enter New Password</label><input type="text"
									name="newPassword" class="form-control" required>
							</div>

							<div class="mb-3">
								<label>Enter Old Password</label><input type="text"
									name="oldPassword" class="form-control" required>
							</div>

							<input type="hidden" value="${doctorObj.id }" name="uid">
							<button class="btn btn-primary col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-5 offset-2">

				<div class="card paint-card">
					<p class="text-center fs-3">Edit Profile</p>
					
					<c:if test="${not empty succMsgd }">
						<p class="text-center text-success fs-3">${succMsgd}</p>
						<c:remove var="succMsgd" scope="session" />
					</c:if>

					<c:if test="${not empty errMsgd }">
						<p class="text-center text-danger fs-5">${errMsgd}</p>
						<c:remove var="errMsgd" scope="session" />
					</c:if>
					<div class="card-body">
						<form action="../editDoctorProfile" method="post">
							<div class="mb-3">
								<label class=form-label">Full Name</label><input required
									name="fullname" type="text" class="form-control" value="${doctorObj.fullName }">
							</div>
							<div class="mb-3">
								<label class=form-label">DOB</label><input type="date" required
									name="dob" class="form-control" value="${doctorObj.dob}">
							</div>

							<div class="mb-3">
								<label class=form-label">Qualification</label><input type="text"
									required name="quali" class="form-control" value="${doctorObj.qualification }">
							</div>

							<div class="mb-3">
								<label class=form-label">Specialist</label><select name="spec"
									required class="form-control" >
									<option>${doctorObj.specialist }</option>

									<%
										specialistDao dao = new specialistDao(DBConnect.getCon());
										List<Specialist> list = dao.getAllSpecialist();
										for (Specialist s : list) {
									%>
									<option><%=s.getSpecialistName()%></option>
									<%
										}
									%>





								</select>
							</div>

							<div class="mb-3">
								<label class=form-label">Email</label><input type="text"
									readonly required name="email" class="form-control" value="${doctorObj.email }">
							</div>

							<div class="mb-3">
								<label class=form-label">Mob No</label><input type="text"
									required name="mobno" class="form-control" value="${doctorObj.mobNo }">
							</div>
							
							<input type="hidden" name="id" value="${doctorObj.id}">


							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>


		</div>
	</div>

</body>
</html>