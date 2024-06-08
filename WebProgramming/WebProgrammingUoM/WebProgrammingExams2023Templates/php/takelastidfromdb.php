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


$sql = "INSERT INTO names(name, age) VALUES ('eleni', 15)"; //I need to enter a value before I will take the last id
if($conn->query($sql) === TRUE)
{
    echo "success entering values";
    $last_id = $conn->insert_id;
    echo "last id $last_id";
}
else
{
    echo "fail entering values";
}




$conn->close();

?>