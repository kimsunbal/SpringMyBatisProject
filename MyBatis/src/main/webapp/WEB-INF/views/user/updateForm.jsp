<!DOCTYPE html>
<html lang="en">

<head>
<title>Andrea - Free Bootstrap 4 Template by Colorlib</title>
<%@ include file="/include/head.jsp"%>
</head>

<body>

	<div id="colorlib-page">
		<%@ include file="/include/nav.jsp"%>
		<div id="colorlib-main">
			<section class="ftco-section contact-section px-md-4">
				<div class="container">
					<div class="row block-9">
						<div class="col-lg-12 d-flex">
							<form action="/user/update" method="POST" class="bg-light p-5 contact-form">
								<input type="hidden" name="id" value="${user.id}">
								<h1>User Profile</h1>
								<div class="form-group">
									<input type="text" class="form-control" name="username" value="${user.username}" readonly="readonly">
								</div>
								<div class="form-group">
									<input type="password" class="form-control" placeholder="Password">
								</div>
								<div class="form-group">
									<input type="password" class="form-control" name="password" placeholder="Password check">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="email" placeholder="Email" value="${user.email}">
								</div>
								<div class="form-group">
									<input type="button" onclick="location.href='/user/delete/${user.id}'" value="Delete Account" class="btn btn-primary py-3 px-5" style="background-color: red">
									<input type="submit" value="Update" class="btn btn-primary py-3 px-5" style="float: right;">
								</div>
							</form>

						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- END COLORLIB-MAIN -->
	</div>
	<!-- END COLORLIB-PAGE -->

	<%@ include file="/include/footer.jsp"%>
</body>

</html>