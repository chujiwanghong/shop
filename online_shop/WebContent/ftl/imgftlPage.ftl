<!DOCTYPE html>
<html lang="en">
	<head>
		<link rel="stylesheet" href="css/metro-bootstrap.min.css">
		<link rel="stylesheet" href="css/metro-bootstrap-responsive.css">
		<link rel="stylesheet" href="css/iconFont.css">
		<link rel="stylesheet" href="css/uploadify.css">
		<script src="js/api/jquery-1.7.1.min.js"></script>
		<script src="js/api/jquery.uploadify.min.js"></script>
		<script src="js/api/jquery-ui-1.9.2.custom.min.js"></script>
		<script src="js/api/metro.min.js"></script>
		<script type="text/javascript" src="js/imgftlPage.js"></script>
		<title>地址选择页面</title>
	</head>
	<body class="metro">
		<form method="POST" enctype="multipart/form-data" action="uploadimg.action"  >
		  File to upload: <input type="file" id="upload" name="upload"><br/>
		  Notes about the file: <input type="text" name="note"><br/>
		  File to upload: <input type="file" name="upload"><br/>
		  Notes about the file: <input type="text" name="note"><br/>
		  <br/>
		  <input type="submit" id="submit" value="Press" onclick="subclick();"> to upload the file!
		</form>
		 	<img id="image" ></img>
		 	<img id="photo" ></img>
	</body>
</html>
