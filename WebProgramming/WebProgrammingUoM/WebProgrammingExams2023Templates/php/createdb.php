<?php 
$servername = "localhost";
$username = "root";
$password = "";

$conn = new mysqli($servername, $username, $password);

if($conn->connect_error)
{
    die("Error connecting " . $conn->connect_error);
}

$sql = "CREATE DATABASE thanosdb";
if($conn->query($sql) === TRUE)
{
    echo "DB created successfully.";
}
else
{
    echo "fail" . $conn->connect_error;
}

$conn->close();

?>