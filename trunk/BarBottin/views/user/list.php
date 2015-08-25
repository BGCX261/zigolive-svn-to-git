

{foreach from=$users item=user}

	{$user.name}</br> <a href="/user/remove/{$user.name}">Remove</a> <a href="/user/edit/{$user.name}">edit</a>

{/foreach}