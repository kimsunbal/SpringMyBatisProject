<!DOCTYPE html>
<html lang="en">

<head>
<title>Andrea - Free Bootstrap 4 Template by Colorlib</title>
<%@ include file="/include/head.jsp"%>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

</head>

<body>

	<div id="colorlib-page">
		<%@ include file="/include/nav.jsp"%>
		<div id="colorlib-main">
			<section class="ftco-section contact-section px-md-4">
				<div class="container">
					<div class="row block-9">
						<div class="col-lg-12 d-flex">
							<form action="/board/post" method="POST" class="bg-light p-5 contact-form">
								<input type="hidden" name="userId" value="1">

								<h1>Post Form</h1>
								<div class="form-group">
									<input type="text" class="form-control" name="title" placeholder="Title">
								</div>
								<textarea class="form-control" id="p_content" name="content"></textarea>
								<br>
								<div class="form-group text-right">
									<input type="submit" value="Post" class="btn btn-primary py-3 px-5">
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
	<script type="text/javascript">
		CKEDITOR.replace('p_content', {
			height : 500			
		});
	</script>
</body>

</html>