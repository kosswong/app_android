<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

if (isset($_POST['email']) && isset($_POST['password'])) {

	// receiving the post params
	$email = $_POST['email'];
	$password = $_POST['password'];

	// get the user by email and password
	$stmt = mysqli_prepare($conn, "SELECT * FROM app_users WHERE email = ?");
	mysqli_stmt_bind_param($stmt, "s", $email);
	$result = mysqli_stmt_execute($stmt);

	$user = $stmt->get_result()->fetch_assoc();
	
	// check password
	/*if (!empty($result)) {
		$salt = $user['salt'];
		$encrypted_password = $user['encrypted_password'];
		$hash = checkhashSSHA($salt, $password);
		if($encrypted_password != $hash){	// verifying user password
			$user = false;
		}
	}*/

	if ($user != false) {
		// use is found
		$response["error"] = FALSE;
		$response["uid"] = $user["unique_id"];
		$response["user"]["name"] = $user["name"];
		$response["user"]["email"] = $user["email"];
		$response["user"]["money"] = $user["money"];
		$response["user"]["created_at"] = $user["created_at"];
		$response["user"]["updated_at"] = $user["updated_at"];
		echo json_encode($response);
	} else {
		// user is not found with the credentials
		$response["error"] = TRUE;
		$response["error_msg"] = "Login credentials are wrong. Please try again!";
		echo json_encode($response);
	}
	
} else {
	// required post params is missing
	$response["error"] = TRUE;
	$response["error_msg"] = "Required parameters email or password is missing!";
	echo json_encode($response);
}

    function checkhashSSHA($salt, $password) {
        $hash = base64_encode(sha1($password . $salt, true) . $salt);
        return $hash;
    }
?>

