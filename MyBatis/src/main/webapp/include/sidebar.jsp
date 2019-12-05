<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-xl-4 sidebar ftco-animate bg-light pt-5">
	<div class="sidebar-box pt-md-4">
		<form action="#" class="search-form">
			<div class="form-group">
				<span class="icon icon-search"></span> <input type="text" class="form-control"
					placeholder="Type a keyword and hit enter">
			</div>
		</form>
	</div>

	<div class="sidebar-box ftco-animate">
		<h3 class="sidebar-heading">Popular Articles</h3>
		<c:forEach var="popularBoard" items="${popularBoards}">
			<div class="block-21 mb-4 d-flex">
				<a class="blog-img mr-4" style="background-image: url(${popularBoard.previewImg});"></a>
				<div class="text">
					<h3 class="heading">
						<a href="/board/detail/${popularBoard.id}">${popularBoard.title}</a>
					</h3>
					<div class="meta">
						<div>
							<a href="/board/detail/${popularBoard.id}"><span class="icon-calendar"></span>${popularBoard.createDate}</a>
						</div>
						<div>
							<a href="/board/detail/${popularBoard.id}"><span class="icon-person"></span>${popularBoard.username}</a>
						</div>
						<div>
							<a href="/board/detail/${popularBoard.id}"><span class="icon-chat"></span>${popularBoard.readCount}</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<div class="sidebar-box subs-wrap img py-4" style="background-image: url(images/bg_1.jpg);">
		<div class="overlay"></div>
		<h3 class="mb-4 sidebar-heading">Newsletter</h3>
		<p class="mb-4">Far far away, behind the word mountains, far from the countries Vokalia</p>
		<form action="#" class="subscribe-form">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Email Address"> <input
					type="submit" value="Subscribe" class="mt-2 btn btn-white submit">
			</div>
		</form>
	</div>

	<div class="sidebar-box ftco-animate">
		<h3 class="sidebar-heading">Paragraph</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus itaque, autem
			necessitatibus voluptate quod mollitia delectus aut.</p>
	</div>
</div>