<?php
$servername = "localhost";
$username = "root"; #at uom computers this is user and not root
$password = "";


$conn = new mysqli($servername, $username, $password);

if($conn->connect_error)
{
    die("Connection failed: " . $conn->connect_error);
}

echo "Connected successfully"

?>