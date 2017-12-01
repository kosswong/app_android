<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

    // check if user is already existed with the same email

$result = mysqli_query($conn, "SELECT COUNT(`movie_id`)*100 AS price FROM `app_user_pays` WHERE user_id=1");
$row = mysqli_fetch_assoc($result);
$money = $row['price'];
	$sql = mysqli_query($conn, "UPDATE app_users SET money=money-".$row['price']." WHERE id=1");
	
//mysqli_query($conn, "UPDATE app_user_pays SET cart = 1 WHERE user_id = 1");
mysqli_query($conn, "DELETE FROM `app_user_pays` WHERE `user_id` = 1");


$result = mysqli_query($conn, "SELECT * FROM `app_users` WHERE id = 1");
$row = mysqli_fetch_assoc($result);

        $response["money"] = "$".$row['money'];
        $response["message"] = "Success!";

        echo json_encode($response);

?>