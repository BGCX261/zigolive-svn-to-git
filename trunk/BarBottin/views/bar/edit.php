<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
	<title>Barbottin - Inscription de bar</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<link rel='stylesheet' href='/static/css/css.css' type='text/css'>
</head>

<body>

<form method="POST" action="/Bar/save/{$bar.oid}">

<div class="BoxTitrePage">Create a bar sheet</div>

<table cellpadding="0" cellspacing="0" border="0" class="ColumnContentTable">
	<tr>
		<td valign="top" class="ColumnLarge">
			<div class="FormBoxName"><div class="FormBoxNameTxt">Name of the bar</div></div>
			<div class="FormBox">
				<table cellpadding="0" cellspacing="5" border="0">
					<tr>
						<td>Name of the bar</td>
						<td><INPUT style="border:1px solid #c3e9a6; width:380px; margin:0 5px;" TYPE=text NAME="BarName" VALUE="{$bar.name}" /></td>
					</tr>
					<tr>
						<td>Adress</td>
						<td><INPUT style="border:1px solid #c3e9a6; width:220px; margin:0 5px;" TYPE=text NAME="BarAddress" VALUE="{$bar.address}" />Post Code<INPUT style="border:1px solid #c3e9a6; width:75px; margin:0 5px; text-align:center" TYPE=text NAME="BarPostCode" VALUE="{$bar.postcode}" /></td>
					</tr>
					<tr>
						<td>City</td>
						<td><INPUT style="border:1px solid #c3e9a6; width:220px; margin:0 5px;" TYPE=text NAME="BarTown" VALUE="{$bar.city}" /></td>
					</tr>
				</table>
			</div>
			<div class="FormBoxName"><div class="FormBoxNameTxt">Description of this bar</div></div>
			<div class="FormTxtInfos">Let some words to describe the bar, atmospher... You can use the buttons underneath to stylize your text and links, adding images....  and so on.</div>
			<div class="FormBox">



				<!-- ####### You WYSIWYG CODE HERE ####### -->
				 <textarea name="BarDescription" rows="15" cols="60">{$bar.description}</textarea><br/>
				<!-- ####### You WYSIWYG CODE HERE ####### -->




				<center><input class="FormWWButton" type=submit value="Quick View" /><input class="FormWWButton" type=submit value="Save" /></center>

			</div>
			<div class="FormBoxName"><div class="FormBoxNameTxt">Services</div></div>
			<div class="FormBox">
				<table cellpadding="0" cellspacing="0" border="0" class="FormAmbiance">
					<tr>
						<td rowspan=5 valign="top" style="width:110px">Environment</td>
						<td><input type="checkbox" name="1" value="cool1" />Cool 1</td>
						<td><input type="checkbox" name="2" value="cool2" />Cool 2</td>
						<td><input type="checkbox" name="3" value="cool3" />Cool 3</td>
						<td><input type="checkbox" name="4" value="cool4" />Cool 4</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="5" value="cool5" />Cool 5</td>
						<td><input type="checkbox" name="6" value="cool6" />Cool 6</td>
						<td><input type="checkbox" name="7" value="cool7" />Cool 7</td>
						<td><input type="checkbox" name="8" value="cool8" />Cool 8</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="9" value="cool9" />Cool 9</td>
						<td><input type="checkbox" name="10" value="cool10" />Cool 10</td>
						<td><input type="checkbox" name="11" value="cool11" />Cool 11</td>
						<td><input type="checkbox" name="12" value="cool12" />Cool 12</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="13" value="cool13" />Cool 13</td>
						<td><input type="checkbox" name="14" value="cool14" />Cool 14</td>
						<td><input type="checkbox" name="15" value="cool15" />Cool 15</td>
						<td><input type="checkbox" name="16" value="cool16" />Cool 16</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="17" value="cool17" />Cool 17</td>
						<td><input type="checkbox" name="18" value="cool18" />Cool 18</td>
						<td><input type="checkbox" name="19" value="cool19" />Cool 19</td>
						<td><input type="checkbox" name="20" value="cool20" />Cool 20</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="FormAmbiance">
					<tr>
						<td rowspan=5 style="width:110px">Smoke</td>
						<td style="text-align:center;"><img src="/static/images/main/formulaire/form_smoke_1.gif" width="44" height="32" alt="fumee1"/></td>
						<td style="text-align:center;"><img src="/static/images/main/formulaire/form_smoke_2.gif" width="44" height="32" alt="fumee1"/></td>
						<td style="text-align:center;"><img src="/static/images/main/formulaire/form_smoke_3.gif" width="44" height="32" alt="fumee1"/></td>
						<td style="text-align:center;"><img src="/static/images/main/formulaire/form_smoke_4.gif" width="44" height="32" alt="fumee1"/></td>
						<td style="text-align:center;"><img src="/static/images/main/formulaire/form_smoke_5.gif" width="44" height="32" alt="fumee1"/></td>
					</tr>
					<tr>
						<td style="text-align:center;"><input type= "radio" name="fumee" value="1" /></td>
						<td style="text-align:center;"><input type= "radio" name="fumee" value="2" /></td>
						<td style="text-align:center;"><input type= "radio" name="fumee" value="3" /></td>
						<td style="text-align:center;"><input type= "radio" name="fumee" value="4" /></td>
						<td style="text-align:center;"><input type= "radio" name="fumee" value="5" /></td>
					</tr>
				</table>
			</div>
		</td>
		<td valign="top" class="ColumnSmall">
			<div class="FormBoxName"><div class="FormBoxNameTxt">Images of the bar</div></div>
			<div class="FormTxtInfos">Thoses images will appear in the "Diaporama" setcion of the bar sheet</div>
			<div class="FormBoxBrowse">
				<INPUT style="margin:0 5px 0 0;" TYPE=text NAME="Parcourir" VALUE="" SIZE=14 /><input type=submit value="Browse Image" />
			</div>
			<div class="FormBox">
				<table cellpadding="0" cellspacing="0" border="0" class="FormImage">
					<tr>
						<td >Image1</td>
						<td style="text-align:right; font-size:x-small;"><a href="#">Supprimer <span class="TextRouge1">[X]</span></a></td>
					</tr>
					<tr>
						<td >Image2</td>
						<td style="text-align:right; font-size:x-small;"><a href="#">Supprimer <span class="TextRouge1">[X]</span></a></td>
					</tr>
					<tr>
						<td >Image3</td>
						<td style="text-align:right; font-size:x-small;"><a href="#">Supprimer <span class="TextRouge1">[X]</span></a></td>
					</tr>
				</table>
			</div>
			<div class="FormBoxName"><div class="FormBoxNameTxt">Rank this bar now !</div></div>
			<div class="FormTxtInfos">Be the first to rank this bar ! Notes appear as soon as 5 (?) votes, for a same bar, as been done.</div>
			<div class="FormBox">
				<table cellpadding="0" cellspacing="0" border="0" class="FormImage">
					<tr>
						<td style="text-align:center;"><input type= "radio" name="VoteBar" value="1" />1</td>
						<td style="text-align:center;"><input type= "radio" name="VoteBar" value="2" />2</td>
						<td style="text-align:center;"><input type= "radio" name="VoteBar" value="3" />3</td>
						<td style="text-align:center;"><input type= "radio" name="VoteBar" value="4" />4</td>
						<td style="text-align:center;"><input type= "radio" name="VoteBar" value="5" />5</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
</table>
<center><input class="FormWWButton" type=submit value="create this new bar sheet" /></center>

</form>
</body>
</html>


