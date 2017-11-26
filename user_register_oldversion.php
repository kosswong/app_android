<?php

$response = array("error" => FALSE);

require_once __DIR__ . '/db_connect.php';
$db = new Db_Connect();
$conn = $db->connect();

/*if (isset($_POST['name']) && isset($_POST['email']) && isset($_POST['password'])) {

    // receiving the post params
    $name = $_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];*/
	
    $name = "etys";
    $email = "dfhdfhhdf@hddhdf.cc";
    $password = "dfhdfh";

    // check if user is already existed with the same email
	$stmt = mysqli_prepare($conn, "SELECT * FROM app_users WHERE email = ?");
	mysqli_stmt_bind_param($stmt, "s", $email);_backup_highsafety
	mysqli_stmt_execute($stmt);
	$result = mysqli_stmt_fetch($stmt);
	
    if (!empty($result)) {
        // user already existed
        $response["error"] = TRUE;
        $response["error_msg"] = "User already existed with " . $email;
        echo json_encode($response);
    } else {
        // create a new user
        $uuid = uniqid('', true);
        $hash = hashSSHA($password);
        $encrypted_password = $hash["encrypted"]; // encrypted password
        $salt = $hash["salt"]; // salt

		$stmt = mysqli_prepare($conn, "INSERT INTO app_users(unique_id, name, email, encrypted_password, salt, created_at) VALUES(?, ?, ?, ?, ?, NOW())");
		mysqli_stmt_bind_param($stmt, "sssss", $uuid, $name, $email, $encrypted_password, $salt);
		$result = mysqli_stmt_execute($stmt);
		
        // check for successful store
        if ($result) {
			$stmt = mysqli_prepare($conn, "SELECT * FROM app_users WHERE email = ?");
			mysqli_stmt_bind_param($stmt, "s", $email);
			$result = mysqli_stmt_execute($stmt);
            $user = $stmt->get_result()->fetch_assoc();
        }
		
        if ($user) {
            // user stored successfully
            $response["error"] = FALSE;
            $response["uid"] = $user["unique_id"];
            $response["user"]["name"] = $user["name"];
            $response["user"]["email"] = $user["email"];
            $response["user"]["created_at"] = $user["created_at"];
            $response["user"]["updated_at"] = $user["updated_at"];
            echo json_encode($response);
        } else {
            // user failed to store
            $response["error"] = TRUE;
            $response["error_msg"] = "Unknown error occurred in registration!";
            echo json_encode($response);
        }
    }
/*} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (name, email or password) is missing!";
    echo json_encode($response);
}*/
?>

