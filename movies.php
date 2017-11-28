<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

	$sql = mysqli_query($conn, "SELECT movie_id,movie_name,poster FROM app_movies");
	$rows = array();
	while($r = mysqli_fetch_assoc($sql)) {
		$rows[] = $r;
	}
	//$result = mysqli_fetch_all($sql);
        if ($rows) {
            // get movies successfully
            $response["error"] = FALSE;
            $response["movies"] = $rows;
            echo json_encode($response);
        } else {
            // failed
            $response["error"] = TRUE;
            $response["error_msg"] = "No data, sorry!";
            echo json_encode($response);
        }

?>

