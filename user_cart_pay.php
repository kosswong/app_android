<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

if (isset($_POST['user_id'])) {

    // receiving the post params
    $user_id = $_POST['user_id'];

    // check if user is already existed with the same email
	$sql = mysqli_query($conn, "
	SELECT COUNT(movie_id)*100 AS price FROM app_user_pays WHERE `user_id` = 1 AND `cart` = 0
	");
	
	if (mysqli_num_rows($sql) > 0) {
		$response["products"] = array();
		
		while ($row = mysqli_fetch_array($sql)) {
			// temp user array
			$product = array();

			// push single product into final response array
			array_push($response["products"], $product);
		}
    } else {
        // no record
        $response["error"] = TRUE;
    $response["error_msg"] = "You have paid".$product["price"];
	}
        echo json_encode($response);
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (user_id) is missing!";
    echo json_encode($response);
}

?>

