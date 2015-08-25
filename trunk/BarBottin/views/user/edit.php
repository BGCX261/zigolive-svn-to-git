
<b>{$user.name}</b>
<form action="/user/saveedit" method="POST">
	<input type="hidden" name="name" value="{$user.name}">
	email:<input type="text" name="email" value="{$user.email}"> <br>
	password:<input type="password" name="password"> <br>
	<input type="submit" value="Save">
</form>
