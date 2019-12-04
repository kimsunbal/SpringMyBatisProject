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
								<div class="col-md-12 bg-light">
									<h1>${board.title}</h1>
									<div>
										<button class="col-md-2 btn btn-dark submit">수정</button>
										<button class="col-md-2 btn btn-dark submit">삭제</button>
										<br>
									</div>
								</div>
								<div>${board.content}</div>
								<div class="col-md-12 bg-light">
									<div class="desc">
										<h3>George Washington</h3>
									</div>
								</div>
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