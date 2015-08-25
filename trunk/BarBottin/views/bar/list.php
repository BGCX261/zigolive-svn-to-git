
{foreach from=$bars item=bar}
	<a href="/Bar/View/{$bar->oid}">{$bar->name}</a> <a href="/Bar/Edit/{$bar.oid}">Edit</a><br>
{/foreach}