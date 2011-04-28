<!DOCTYPE html>
<html>
<head>
	<title>statuspanic generic status board</title>
	<link rel='stylesheet' href='${resource(dir:'css',file:'panic.css')}' />
	<script src='${resource(dir:'js',file:'jquery.js')}'></script>
	<script src='${resource(dir:'js',file:'board.js')}'></script>
	<style type='text/css'>
		#board { 
			${boardCSS} 
		}
	</style>
</head>
<body>
    <div id='board'>
    	<g:each in="${modules}" var="module">
    		<div class='module ${module.class}' id='${module.name}' style='${module.style}'></div>
    		<script>activate_module('${module.name}', ${module.update}, '${module.argstr}');</script>
    	</g:each>
    </div>
</body>
</html>