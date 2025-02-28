<?php
$servername = "localhost";
$username = "root";
$password = "";
$db = "thanosdb";

$conn = new mysqli($servername, $username, $password, $db);
if($conn->connect_error)
{
    die("Fail connecting to the database" . $conn->connect_error);
}

$sql = "CREATE TABLE names(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    age INT)";

if($conn->query($sql) === TRUE)
{
    echo "table created successfully";
}
else
{
    echo "fail creating table";
}

$conn->close();

?>