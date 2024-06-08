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

$sql = "INSERT INTO names (name, age) VALUES ('furkan', 40);";
$sql .= "INSERT INTO names (name, age) VALUES ('panagiotis', 49);";
$sql .= "INSERT INTO names (name, age) VALUES ('giannoula', 30)";

if($conn->multi_query($sql) === TRUE)
{
    echo "success entering multiple values";
}
else
{
    echo "fail entering values";
}

$conn->close();


?>