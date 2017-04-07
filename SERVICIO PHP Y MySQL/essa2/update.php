<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$name = $_POST['name'];
		$desg = $_POST['desg'];
		$sal = $_POST['salary'];
		
		require_once('dbConnect.php');
		
		$sql = "UPDATE employee SET name = '$name', department = '$desg', salary = '$sal' WHERE id = $id;";
		
		if(mysqli_query($con,$sql)){
			echo 'Actualizacion de usuario completa';
		}else{
			echo 'No se actualizo el registro intente de nuevo.';
		}
		
		mysqli_close($con);
	}