<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-lg-8 px-md-5 py-5">
							<div class="row pt-md-4">
								<div class="col-md-12 bg-light" style="padding: 20px;">
									<h2>${board.title}</h2>
									<div style="float: right;">
										<div style="margin-top: 20px; margin-bottom: 20px">
											<input type="button" value="Update"
												onclick="location.href = '/board/updateForm/${board.id}'" class="btn btn-dark submit">
											<input type="button" value="Delete" onclick="location.href = '/board/delete/${board.id}'"
												class="btn btn-dark submit">
										</div>
									</div>
									<div style="display: inline-block;">
										<div>
											<a href="#"><span class="icon-person" style="margin-right: 10px"></span>${board.username}</a>
										</div>
										<div>
											<a href="#"><span class="icon-chat" style="margin-right: 10px"></span>${board.email}</a>
										</div>
										<div>
											<a href="#"><span class="icon-calendar" style="margin-right: 10px"></span>${board.createDate}</a>
										</div>
									</div>
								</div>

								<div class="col-md-12">${board.content}</div>

							</div>
							<!-- END-->
						</div>

						<!-- 사이드바 시작 -->
						<%@ include file="/include/sidebar.jsp"%>
						<!-- 사이드바 끝-->

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