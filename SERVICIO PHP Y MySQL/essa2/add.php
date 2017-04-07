<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		$imei = $_POST['imei'];
		$macbt = $_POST['macbt'];
		$ecom = $_POST['ecom'];
		
		//query de insersion en la base de datos
		$sql = "INSERT INTO dispositivos2 (imei,macbt,ecom) VALUES ('$imei','$macbt','$ecom')";
		
		//importacion de la base de datos
		require_once('dbConnect.php');

		// verificacion de existente en la base de datos
		$sqlVerificacion = "SELECT COUNT(*) AS total FROM dispositivos2 WHERE  macbt ='$macbt' AND imei ='$imei'";
		// preguntamos si existe este usuario
		$row=mysqli_fetch_object(mysqli_query($con, $sqlVerificacion));
		if($row->total == 0 ){
			//Ejecuta el query de insercion en la base
			if(mysqli_query($con,$sql)){
				echo 'Usuario adicionado de forma correcta!!!';
			}else{
				echo 'No se pudo adicionar Usuario en la BD. intenente de nuevo.';
			}
		}else{
			echo 'Usuario ya registrado en la base de datos';
		}

		//Cierra la conexion con la base de datos
		mysqli_close($con);
	}