<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ChatService | Registration Page</title>
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

    <script type="application/javascript">

      function checkRegisterForm() {

        if($("#password1").val() === $("#password2").val()) {
          if ($("#argument").is(":checked") ) {
            return true;
          } else {
            $("#argumentFeedback").val("please check the argument checkbox");
            return false;
          }
        }  else {
          $("#passwordFeedback").val("password dose not match");
          return false;
        }
      }

      function checkEmail () {
        var email = $("#email").val();
        $.get('${pageContext.request.contextPath}/RegisterServlet?email='+email,function(responseText,statusTxt, xhr) {

          document.getElementById('emailFeedback').innerHTML = responseText;
          $('#emailFeedback').attr('style','color : red');
        });
      }

    </script>

  </head>
  <body class="register-page">
    <div class="register-box">
      <div class="register-logo">
        <a href="${pageContext.request.contextPath}"><b>Chat</b>Service</a>
      </div>

      <div class="register-box-body">
        <p class="login-box-msg">Register a new membership</p>
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="post"  >
          <div class="form-group has-feedback">
            <input name="fullName" type="text" class="form-control" required="true" placeholder="Full name"/>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
            <span id="fullNameFeedback" ></span>
          </div>
          <div class="form-group has-feedback">
            <input id="email" name="email" type="email" class="form-control" required="ture"  placeholder="Email" onkeyup="checkEmail()" />
            <span  class="glyphicon glyphicon-envelope form-control-feedback"></span>
            <span id="emailFeedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input id="password1" name="password" type="password" class="form-control" required="true" placeholder="Password"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input id="password2" name="password" type="password" class="form-control" required="true" placeholder="Retype password"/>
            <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            <span id="passwordFeedback" ></span>
          </div>
          <div class="row">
            <div class="col-xs-8">    
              <div class="checkbox icheck">
                <label>
                  <input id="argument" name="argument" type="checkbox" required="true"> I agree to the <a href="#">terms</a>
                  <span id="argumentFeedback" ></span>
                </label>
              </div>                        
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat" onclick="return checkRegisterForm();" >Register</button>
            </div><!-- /.col -->
          </div>
        </form>        

        <%--<div class="social-auth-links text-center">--%>
          <%--<p>- OR -</p>--%>
          <%--<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using Facebook</a>--%>
          <%--<a href="#" class="btn btn-block btn-social btn-google-plus btn-flat"><i class="fa fa-google-plus"></i> Sign up using Google+</a>--%>
        <%--</div>--%>

        <a href="login.jsp" class="text-center">I already have a membership</a>
      </div><!-- /.form-box -->
    </div><!-- /.register-box -->

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