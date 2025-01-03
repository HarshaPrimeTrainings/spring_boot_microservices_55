<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<style>
.site-header {
	
}

.prdnav {
	display: inline-block;
	background-color: teal;
	color: white;
}

.nav {
	display: flex;
	justify-content: space-evenly;
}

.prdli {
	margin-right: 500px;
	color: white;
	list-style: none;
	font-size: large;
}

a{
	text-decoration: none;
	color: white
}
</style>
</head>
<header class="site-header">
	<div>PRODUCT LIST</div>
	<nav class="prdnav">
		<ul class="nav">
			<li class="prdli"><a href="/products">HOME</a></li>
			<li class="prdli"><a href="/producuts">PRODUCTS</a></li>
			<li class="prdli"><a href="/add">ADD_PRODUCT</a></li>
		</ul>
	</nav>
</header>
<body>
	<table>
		<tr>
			<th>PID</th>
			<th>PNAME</th>
			<th>QUANTITY</th>
		</tr>

		<c:forEach var="prd" items="${productlist}">
			<tr>
				<td>${prd.pid}</td>
				<td>${prd.pname}</td>
				<td>${prd.quatity}</td>
			</tr>
		</c:forEach>

	</table>

	</ul>
</body>