<!DOCTYPE html>
<html lang="en">

<head>
	<title>Andrea - Free Bootstrap 4 Template by Colorlib</title>
<%@ include file="../../../include/head.jsp"%>
</head>

<body>

	<div id="colorlib-page">
		<%@ include file="../../../include/nav.jsp"%>
		<div id="colorlib-main">
			<section class="ftco-section contact-section px-md-4">
				<div class="container">
					<div class="row block-9">
						<div class="col-lg-12 d-flex">
							<form action="#" class="bg-light p-5 contact-form">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Your Name">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Your Email">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Subject">
								</div>
								<div class="form-group">
									<textarea name="" id="" cols="30" rows="7" class="form-control"
										placeholder="Message"></textarea>
								</div>
								<div class="form-group">
									<input type="submit" value="Send Message" class="btn btn-primary py-3 px-5">
								</div>
							</form>

						</div>
					</div>
				</div>
			</section>
		</div><!-- END COLORLIB-MAIN -->
	</div><!-- END COLORLIB-PAGE -->

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
				stroke="#F96D00" /></svg></div>


	<%@ include file="../../../include/footer.jsp"%>
</body>

</html>