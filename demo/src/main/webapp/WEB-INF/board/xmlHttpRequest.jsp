<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%-- 화면영역 --%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="linkToCSS" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
     document.addEventListener("DOMContentLoaded", function () {
    var postBtn = document.getElementById("postBtn");
    var postJsonBtn = document.getElementById("postJsonBtn");

    postBtn.addEventListener("click", function () {
      var boardNo = document.getElementById("boardNo").value;
      var title = document.getElementById("title").value;
      var content = document.getElementById("content").value;
      var writer = document.getElementById("writer").value;

      var boardObject = {
        boardNo: boardNo,
        title: title,
        content: content,
        writer: writer,
      };

      var xhr = new XMLHttpRequest();
      var url = "/board/" + boardNo;
      xhr.open("POST", url, true); //true: 비동기식, false: 동기식
      xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
      xhr.onload = function () {
        if (xhr.status === 200) {
          var result = xhr.responseText;
          console.log("result: " + result);
          if (result === "SUCCESS") {
            alert("SUCCESS");
          } else {
            alert("FAIL");
          }
        } else {
          console.error("Request failed. Status: " + xhr.status);
          // Handle error scenario if needed
        }
      };

      xhr.onerror = function () {
        console.error("Request failed. Network error.");
        // Handle network errors if needed
      };

      xhr.send(JSON.stringify(boardObject));
    });

    putJsonBtn.addEventListener("click", function () {
      var boardNo = document.getElementById("boardNo").value;
      var title = document.getElementById("title").value;
      var content = document.getElementById("content").value;
      var writer = document.getElementById("writer").value;
      var boardObject = {
        boardNo: boardNo,
        title: title,
        content: content,
        writer: writer,
      };

      var xhr = new XMLHttpRequest();
      var url = "/board/" + boardNo;

      xhr.open("PUT", url, true); //true: 비동기식, false: 동기식
      xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");

      xhr.onload = function () {
        if (xhr.status === 200) {
          var result = xhr.responseText;
          console.log("result: " + result);
          if (result === "SUCCESS") {
            alert("SUCCESS");
          } else {
            alert("FAIL");
          }
        } else {
          console.error("Request failed. Status: " + xhr.status);
          // Handle error scenario if needed
        }
      };

      xhr.onerror = function () {
        console.error("Request failed. Network error.");
        // Handle network errors if needed
      };

      xhr.send(JSON.stringify(boardObject));
    });
  });
    </script>
  </head>
  <body>
    <hr />
    <header>XMLHttpRequest.jsp 입니다.</header>
    <main>
      <h1>XMLHttpRequest</h1>
      <form>
        boardNo:
        <input type="text" name="boardNo" value="" id="boardNo" /><br />
        title: <input type="text" name="title" value="" id="title" /><br />
        content:
        <input type="text" name="content" value="" id="content" /><br />
        writer: <input type="text" name="writer" value="" id="writer" /><br />
      </form>
      <div>
        <button id="postBtn">수정(put)</button>
        <button id="postHeaderBtn">수정(put with header)</button>
      </div>
    </main>
    <hr />
  </body>
  <footer>
    <h2>footer 입니다.</h2>
  </footer>
</html>