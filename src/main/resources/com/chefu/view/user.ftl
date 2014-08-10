<#-- @ftlvariable name="" type="com.chefu.views.LoginView" -->
<html>
<body>
<!-- calls getPerson().getName() and sanitizes it -->
<h1>Hello, ${userAccount.emailAddress?html}!</h1>
</body>
</html>