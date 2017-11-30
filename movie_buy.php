<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db   = new Db_Connect();
$conn = $db->connect();
if (isset($_POST['movie_id'])) {
    
    $movie_id = $_POST['movie_id'];
    $unique_id  = $_POST['uid'];
    $email  = $_POST['email'];
    $name  = $_POST['name'];
    
    // get user information
	$user_id_get = mysqli_query($conn, "SELECT id FROM app_users WHERE unique_id='$unique_id' AND email='$email' AND name='$name' LIMIT 1");
	if($user_id_get){
		$user_id = mysqli_fetch_array($user_id_get);
		$user_id = $user_id['id'];
	}else{
    $response["error"]     = TRUE;
    $response["message"] = "User not exist!";
    echo json_encode($response);
exit;
}

    // get all products from products table
    $sql    = mysqli_query($conn, "SELECT * FROM app_user_pays WHERE user_id='$user_id' AND movie_id=$movie_id");
    $result = mysqli_fetch_array($sql);

    // check for empty result
    if (empty($result)) {
        mysqli_query($conn, "INSERT INTO `app_user_pays` (`user_id`, `movie_id`, `cart`) VALUES ('$user_id', '$movie_id', '0')");
        $response["message"] = "Added successfully!";
    } else {
        $response["success"] = 0;
        $response["message"] = "You have added it to cart already!";
    }
    echo json_encode($response);
    
} else {
    $response["error"]     = TRUE;
    $response["message"] = "Required parameters (name or email) is missing!";
    echo json_encode($response);
}
?>