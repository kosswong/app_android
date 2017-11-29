<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

$movie_id = '1';

// get all products from products table
$result = mysqli_query($conn, "SELECT * FROM app_movies WHERE movie_id=$movie_id");

// check for empty result
if (mysqli_num_rows($result) > 0) {    
	$movie = array();
    while ($row = mysqli_fetch_array($result)) {
        // temp user array
        $movie["pid"] = $row["movie_id"];
        $movie["name"] = $row["movie_name"];
        $movie["price"] = '1000';
        $movie["description"] = $row["movie_detail"];
        $movie["class"] = $row["movie_class"];
        $movie["youtube"] = $row["youtube"];
    }
    // success
    $response["movie"] = $movie;
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No products found";

    // echo no users JSON
    echo json_encode($response);
}
?>
