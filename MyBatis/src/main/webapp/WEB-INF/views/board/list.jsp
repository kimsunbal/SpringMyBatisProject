<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Andrea - Free Bootstrap 4 Template by Colorlib</title>
<%@ include file="/include/head.jsp"%>
</head>

<body>

	<div id="colorlib-page">
		<%@ include file="/include/nav.jsp"%>
		<!-- START -->
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-xl-8 py-5 px-md-5">
							<div class="row pt-md-4">
								<c:forEach var="board" items="${boards}">
									<div class="col-md-12">
										<div class="blog-entry ftco-animate d-md-flex">
											<a href="single.html" class="img img-2" style="background-image: url(images/image_1.jpg);"></a>
											<div class="text text-2 pl-md-4">
												<h3 class="mb-2">
													<a href="single.html">${board.title}</a>
												</h3>
												<div class="meta-wrap">
													<p class="meta">
														<span><i class="icon-calendar mr-2"></i>${board.createDate}</span> <span><a href="single.html"><i class="icon-folder-o mr-2"></i>${board.userId}</a></span>
														<span><i class="icon-comment2 mr-2"></i>read count</span>
													</p>
												</div>
												<p class="mb-4">${board.content}</p>
												<p>
													<a href="/board/detail/${board.id}" class="btn-custom">Read More <span class="ion-ios-arrow-forward"></span></a>
												</p>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<!-- END-->

							<!-- 페이징 시작 -->
							<div class="row">
								<div class="col">
									<div class="block-27">
										<ul>
											<li><a href="#">&lt;</a></li>
											<li class="active"><span>1</span></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#">&gt;</a></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- 페이징 끝 -->
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