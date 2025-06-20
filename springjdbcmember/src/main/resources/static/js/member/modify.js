  $(document).ready(function () {
    var formObj = $("#member");
    $("#btnModify").on("click", function () {
      formObj.attr("action", "/member/modify");
      formObj.attr("method", "post");
      formObj.submit();
    });
      $("#btnList").on("click", function () {
        self.location = "/member/list";
      });
  });