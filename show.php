<?php

$conn = mysqli_connect('localhost', 'root', '', 'eventprojects');
if ($conn) {
    $sql = "SELECT * FROM event_detail";
    $result = mysqli_query($conn, $sql);
    if ($result) {
        while ($row = mysqli_fetch_assoc($result)) {
            echo implode(' ', $row) . "\n";
        }
    } else {
        echo "Query failed: " . mysqli_error($conn);
    }
    mysqli_close($conn);
} else {
    echo "Failed to connect to database";
}
?>