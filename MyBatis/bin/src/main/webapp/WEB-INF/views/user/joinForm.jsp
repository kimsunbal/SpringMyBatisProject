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
							<form action="/user/join" method="POST" class="bg-light p-5 contact-form">
								<h1>Join Form</h1>
								<div class="form-group">
									<input type="text" class="form-control" name="username" placeholder="Username">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="password" placeholder="Password">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Password check">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="email" placeholder="Email">
								</div>
								<div class="form-group text-right">
									<input type="submit" value="Join" class="btn btn-primary py-3 px-5">
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