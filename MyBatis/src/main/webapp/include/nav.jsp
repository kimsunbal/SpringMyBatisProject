<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
<aside id="colorlib-aside" role="complementary" class="js-fullheight">
	<nav id="colorlib-main-menu" role="navigation">
		<ul>
			<li><a href="/">Home</a></li>
			<li><a href="/board/list">List</a></li>
			<c:choose>
				<c:when test="${empty sessionScope.user}">
					<li><a href="/user/joinForm">Join</a></li>
					<li><a href="/user/loginForm">Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/board/postForm">Post</a></li>
					<li><a href="/user/logout">Logout</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>

	<div class="colorlib-footer">
		<h1 id="colorlib-logo" class="mb-5">
			<a href="index.html" style="background-image: url(/images/bg_1.jpg);"><c:choose>
					<c:when test="${empty sessionScope.user}">
					Hello
					</c:when>
					<c:otherwise>
					${sessionScope.user.username}
					</c:otherwise>
				</c:choose> </a>
		</h1>
		<p class="pfooter">
			<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			Copyright &copy;
			<script>
				document.write(new Date().getFullYear());
			</script>
			All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
			<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
		</p>
	</div>
</aside>

<!-- END COLORLIB-ASIDE -->