<?php
$servername = "localhost";
$username = "root";
$password = "";


$conn = new mysqli($servername, $username, $password);
if($conn->connect_error)
{
    die("Fail");
}

$sql = "CREATE DATABASE IF NOT EXISTS thanosdb";
if($conn->query($sql) === TRUE)
{
    echo "Created successfully or already existed";
}
else
{
    echo "error creating database";
}

$conn->close();

?>