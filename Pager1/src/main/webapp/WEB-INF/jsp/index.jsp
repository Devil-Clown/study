<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Page</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#1").click(function(){
                window.location.href = "add";
            });
            $("#2").click(function () {
                window.location.href = "delete";
            });
            $("#3").click(function(){
                window.location.href = "select";
            });
            $("#4").click(function () {
                window.location.href = "update";
            });
        });
    </script>
</head>
<body>
    <button id="1">Add</button>
    <button id="2">Delete</button>
    <button id="3">Select</button>
    <button id="4">Update</button>
</body>
</html>