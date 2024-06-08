<?php
$servername = "localhost";
$username = "root";
$password = "";
$db = "thanosdb";

$conn = new mysqli($servername, $username, $password, $db);
if($conn->connect_error)
{
    die("fail");
}

$stmt = $conn->prepare("INSERT INTO names (name, age) VALUES (?,?)");
$stmt->bind_param("si", $firstname, $a);

$firstname = "kostas";
$a = 20;
$stmt->execute();

$firstname = "giannis";
$a = 50;
$stmt->execute();

echo "success entering values";

$stmt->close();
$conn->close();

?>