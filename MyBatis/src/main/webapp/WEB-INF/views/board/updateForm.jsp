<!DOCTYPE html>
<html lang="en">

<head>
<title>Andrea - Free Bootstrap 4 Template by Colorlib</title>
<%@ include file="/include/head.jsp"%>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
</head>

<body>

	<div id="colorlib-page">
		<%@ include file="/include/nav.jsp"%>
		<div id="colorlib-main">
			<section class="ftco-section contact-section px-md-4">
				<div class="container">
					<div class="row block-9">
						<div class="col-lg-12 d-flex">
							<form action="/board/update" method="POST" class="bg-light p-5 contact-form">
								<input type="hidden" name="id" value="${board.id}">
								<h1>Update Form</h1>
								<div class="form-group">
									<input type="text" class="form-control" name="title" value="${board.title}" placeholder="Title">
								</div>
								<textarea id="summernote" name="content">${board.content}</textarea>
								<div id="summernote"></div>
								<script>
									$('#summernote').summernote({
										placeholder : 'Hello bootstrap 4',
										tabsize : 2,
										height : 200
									});
								</script>

								<br>
								<div class="form-group text-right">
									<input type="submit" value="Update" class="btn btn-primary py-3 px-5">
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