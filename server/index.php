<?php

$mysql = require("mysql.php");
if ($mysql) {
	mysql_select_db("webtrack", $mysql);
	mysql_set_charset("utf8", $mysql);
	$content = json_encode($_SERVER);
	$content = addslashes($content);
	$ret = mysql_query("INSERT INTO webtrack (`content`) VALUES ('{$content}')", $mysql);
	if (!$ret) {
		//print mysql_error($mysql);
	}
}
else {
	//print 'err';
}
//print $callback. '('. json_encode(array("hello" => "world")) .')';

print '';
