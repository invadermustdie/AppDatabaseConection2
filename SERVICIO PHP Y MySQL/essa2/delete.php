<?php 
	$id = $_GET['id'];
	
	require_once('dbConnect.php');
	
	$sql = "DELETE FROM employee WHERE id=$id;";
	
	if(mysqli_query($con,$sql)){

		echo 'Registro eliminado de la BD.';

	}else{

		echo 'No se elimino el registro intente de nuevo.';

	}
	
	mysqli_close($con);
