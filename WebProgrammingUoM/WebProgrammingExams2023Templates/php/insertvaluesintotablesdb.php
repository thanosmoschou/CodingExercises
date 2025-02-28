<?php
$servername = "localhost";
$username = "root";
$password = "";
$db = "thanosdb";


$conn = new mysqli($servername, $username, $password, $db);
if($conn->connect_error)
{
    die("error connecting to db" . $conn->connect_error);
}

$sql = "INSERT INTO names(name, age) VALUES ('thanos', 12)";

if($conn->query($sql) === TRUE)
{
    echo "success";
}
else
{
    echo "fail entering values";
}

$conn->close();

?>