<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ChatService | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="${pageContext.request.contextPath}/dist/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/dist/js/html5shiv.js"></script>
        <script src="${pageContext.request.contextPath}/dist/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="${pageContext.request.contextPath}"><b>Chat</b>Service</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
          <div class="form-group has-feedback">
            <input name="email" type="email" class="form-control"  required="true" placeholder="Email"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input name="password" type="password" class="form-control" required="true" placeholder="Password"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">    
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox"> Remember Me
                </label>
              </div>                        
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
            </div><!-- /.col -->
          </div>
        </form>

        <%--<div class="social-auth-links text-center">--%>
          <%--<p>- OR -</p>--%>
          <%--<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using Facebook</a>--%>
          <%--<a href="#" class="btn btn-block btn-social btn-google-plus btn-flat"><i class="fa fa-google-plus"></i> Sign in using Google+</a>--%>
        <%--</div><!-- /.social-auth-links -->--%>

        <a href="#">I forgot my password</a><br>
        <a href="register.jsp" class="text-center">Register a new membership</a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.3 -->
    <script src="${pageContext.request.contextPath}/plugins/jQuery/jQuery-2.1.3.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>