<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

//isset($_POST['user_id'])
if (1) {

    // receiving the post params
    //$user_id = $_POST['user_id'];
    $user_id = 1;

    // check if user is already existed with the same email
	$sql = mysqli_query($conn, "
	SELECT * FROM app_user_pays p 
	JOIN app_movies m ON p.movie_id = m.movie_id 
	WHERE user_id ='$user_id' AND cart = 0
	");
	
	if (mysqli_num_rows($sql) > 0) {
		$response["products"] = array();
		
		while ($row = mysqli_fetch_array($sql)) {
			// temp user array
			$product = array();
			$product["mid"] = $row["movie_id"];
			$product["name"] = $row["movie_name"];
			$product["class"] = $row["movie_class"];

			// push single product into final response array
			array_push($response["products"], $product);
		}
    } else {
        // no record
        $response["error"] = TRUE;
        $response["error_msg"] = "No record!";
	}
        echo json_encode($response);
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (user_id) is missing!";
    echo json_encode($response);
}

?>

