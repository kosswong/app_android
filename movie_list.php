<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

// get all products from products table
$result = mysqli_query($conn, "SELECT * FROM app_movies");

// check for empty result
if (mysqli_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["products"] = array();
    
    while ($row = mysqli_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["pid"] = $row["movie_id"];
        $product["name"] = $row["movie_name"];
        $product["price"] = '1000';
        $product["description"] = $row["movie_detail"];
        $product["created_at"] = 'NULL';
        $product["updated_at"] = 'NULL';

        // push single product into final response array
        array_push($response["products"], $product);
    }
    // success
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
