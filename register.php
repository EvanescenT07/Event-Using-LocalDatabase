<?php

if (isset($_POST)) {
    $conn = mysqli_connect('localhost', 'root', '', 'eventprojects');
    $id = $_POST['id'];
    $name = $_POST['name'];
    $date = $_POST['date'];
    $location = $_POST['location'];
    $description = $_POST['description'];
    $sql = "INSERT INTO event_detail (id, name, date, location, description) VALUES (" . $id . "', '" . $name . "', '" . $date . "', '" . $location . "', '" . $description . "')";
    $result = mysqli_query($conn, $sql);
    $row = mysqli_fetch_assoc($result);
    if ($row) {
        echo "Your Event already register";
    } else {
        "succes";
    }
}
