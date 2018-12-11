<%@ page language="java"  contentType="text/html; charset=UTF-8" %>

<html>
<body>
<h2>I AM YOU FATHER</h2>

springmvc上传文件
<form action="/manage/product/upload.do" name="form1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="springmvc上传文件"/>
</form>
富文本图片上传
<form action="/manage/product/richtext_img_upload.do" name="form1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="富文本上传文件"/>
</form>

</body>
</html>
