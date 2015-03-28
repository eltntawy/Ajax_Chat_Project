<!DOCTYPE html>
<html>
<head>
    <title>Facebook Login JavaScript Example</title>
    <meta charset="UTF-8">

    <script type="application/javascript">

        function getFriendsList() {
            FB.getLoginStatus(function(response) {

                if(response.status = 'connected') {

                    var access_token = response.authResponse.accessToken;
                    var userId = response.authResponse.userID;

                    FB.api('/'+userId+'/friends?access_token='+access_token, function(response) {
                        console.log('Successful login for: ' + response.status);
                        var friends = '' ;
                        for (var i = 0 ; i < response.data.length ; i ++ ) {
                            var user = response.data[i];
                            friends += user.id + ' - '+ user.name+'\n';
                        }

                        document.getElementById('friends').innerHTML = friends;
                    });

                } else {
                    document.getElementById("friends").innerHTML = 'Not Connected';
                }

            });
        }

        function getProfileInfo() {
            FB.getLoginStatus(function(response) {

                if(response.status = 'connected') {

                    var access_token = response.authResponse.accessToken;
                    var userId = response.authResponse.userID;

                    FB.api('/'+userId+'?access_token='+access_token, function(response) {
                        console.log('Successful login for: ' + response.name);
                        var info = 'First Name : '+response.first_name +'<br/>';
                        info += 'Last Name : '+ response.last_name+'<br/>';
                        info += 'email : '+response.email+'<br/>';
                        info += 'gender : '+response.gender+'<br/>'
                        info += 'profile link : '+response.link+'<br/>';

                        document.getElementById('info').innerHTML = info;
                    });

                } else {
                    document.getElementById("info").innerHTML = 'Not Connected';
                }

            });
        }


    </script>
</head>
<body>

<div id="fb-root"></div>
<script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=834510086585755&version=v2.3";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<script>
    // This is called with the results from from FB.getLoginStatus().
    function statusChangeCallback(response) {
        console.log('statusChangeCallback');
        console.log(response);
        // The response object is returned with a status field that lets the
        // app know the current login status of the person.
        // Full docs on the response object can be found in the documentation
        // for FB.getLoginStatus().
        if (response.status === 'connected') {
            // Logged into your app and Facebook.
            testAPI();
        } else if (response.status === 'not_authorized') {
            // The person is logged into Facebook, but not your app.
            document.getElementById('status').innerHTML = 'Please log ' +
            'into this app.';
        } else {
            // The person is not logged into Facebook, so we're not sure if
            // they are logged into this app or not.
            document.getElementById('status').innerHTML = 'Please log ' +
            'into Facebook.';
        }
    }

    // This function is called when someone finishes with the Login
    // Button.  See the onlogin handler attached to it in the sample
    // code below.
    function checkLoginState() {
        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });
    }

    window.fbAsyncInit = function() {
        FB.init({
            appId      : '834510086585755',
            cookie     : true,  // enable cookies to allow the server to access
                                // the session
            xfbml      : true,  // parse social plugins on this page
            version    : 'v2.2' // use version 2.2
        });

        // Now that we've initialized the JavaScript SDK, we call
        // FB.getLoginStatus().  This function gets the state of the
        // person visiting this page and can return one of three states to
        // the callback you provide.  They can be:
        //
        // 1. Logged into your app ('connected')
        // 2. Logged into Facebook, but not your app ('not_authorized')
        // 3. Not logged into Facebook and can't tell if they are logged into
        //    your app or not.
        //
        // These three cases are handled in the callback function.

        FB.getLoginStatus(function(response) {
            statusChangeCallback(response);
        });

    };

    // Load the SDK asynchronously
    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    // Here we run a very simple test of the Graph API after login is
    // successful.  See statusChangeCallback() for when this call is made.
    function testAPI() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log('Successful login for: ' + response.name);
            document.getElementById('status').innerHTML =
                    'Thanks for logging in, ' + response.name + '!';
        });
    }

</script>

<!--
  Below we include the Login Button social plugin. This button uses
  the JavaScript SDK to present a graphical Login button that triggers
  the FB.login() function when clicked.
-->

<fb:login-button scope="public_profile,email,user_friends" onlogin="checkLoginState();"></fb:login-button>
<div class="fb-login-button" data-max-rows="1" data-size="xlarge" data-show-faces="true" data-auto-logout-link="true"></div>
<div id="status">
</div>


<input type="button" value="testAPI"  onclick="alert(testAPI());" />

<input type="button" value="checkLoginState"  onclick="alert(checkLoginState());" />

<input type="button" value="statusChangeCallback"  onclick="alert(statusChangeCallback());" />

<input type="button" value="getFriendsList" onclick="getFriendsList()"/>
<input type="button" value="Get Info" onclick="getProfileInfo()"/>

<div id="firends">

</div>

<div id="info"></div>

</body>
</html>